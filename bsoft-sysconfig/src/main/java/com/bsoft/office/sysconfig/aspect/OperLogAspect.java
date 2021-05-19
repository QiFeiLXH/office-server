package com.bsoft.office.sysconfig.aspect;

import com.alibaba.fastjson.serializer.SerializeFilter;
import com.bsoft.exception.ServiceException;
import com.bsoft.logs.dto.RequestLogDTO;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.common.utils.IpUtils;
import com.bsoft.office.sysconfig.filter.BeanNameFilter;
import com.bsoft.office.sysconfig.filter.BeanValueFilter;
import com.bsoft.office.sysconfig.manager.RequestLogManager;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.RequestFacade;
import org.apache.catalina.connector.Response;
import org.apache.catalina.connector.ResponseFacade;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @Author: xucl
 * @DateTime: 2021/2/5 9:09
 * @Description: 切面处理类，操作日志记录处理
 */
@Aspect
@Component
public class OperLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(OperLogAspect.class);

    @Autowired
    private RequestLogManager requestLogManager;

    /**
     * 设置操作日志切入点 记录操作日志 在注解的位置切入代码
     */
    @Pointcut("@annotation(com.bsoft.office.common.annotation.OperLog)")
    public void operLogPoinCut(){
    }

    /**
     * 设置操作异常切入点记录异常日志 扫描所有controller包下操作
     */
    @Pointcut("execution(* com.bsoft.office.*.controller..*.*(..))")
    public void operExceptionLogPoinCut(){
    }

    private RequestLogDTO initLogBean(HttpServletRequest request,OperLog opLog,JoinPoint joinPoint){
        RequestLogDTO operlog = new RequestLogDTO();
        operlog.setUrl(request.getRequestURL().toString());// 请求Url
        operlog.setPersonId(ContextUtils.getUserId(request));// 请求人工号
        operlog.setIp(IpUtils.getIpAdrress(request));//请求IP地址
        String menuIdStr = request.getHeader("menuId");
        Pattern pattern = Pattern.compile("[0-9]*");
        if (StringUtils.isNotBlank(menuIdStr) && pattern.matcher(menuIdStr).matches()) {
            operlog.setMenuId(Integer.valueOf(menuIdStr)); // 菜单ID
        }
        String paramJson = "";
        if ("POST".equalsIgnoreCase(request.getMethod())){
            Object[] args = joinPoint.getArgs(); // 参数值
            if (args.length > 0){
                List<Object> argsList = new ArrayList<>();
                for (Object o:args){
                    if(!o.getClass().equals(RequestFacade.class) && !o.getClass().equals(ResponseFacade.class) && o.getClass().equals(MultipartFile.class)){
                        argsList.add(o);
                    }
                }
                paramJson = JSONUtils.toString(argsList);
            }
        }else{
            Map<String, String[]> paramMap = request.getParameterMap();
            paramJson = JSONUtils.toString(paramMap);
        }
        if (!ServletFileUpload.isMultipartContent(request) && paramJson.length() < 4000) {
            // 不是文件上传请求且参数长度小于4000则保存请求参数
            operlog.setParams(paramJson);// 请求参数
        }
        if (opLog != null) {
            String operType = opLog.operType();
            String operDesc = opLog.operDesc();
            operlog.setType(operType); // 操作类型
            operlog.setDescribe(operDesc); // 操作描述
        }
        return operlog;
    }

    /**
     * 正常返回通知，拦截用户操作日志，连接点正常执行完成后执行， 如果连接点抛出异常，则不会执行
     * @param joinPoint 切入点
     * @param keys       返回结果
     */
    @AfterReturning(value = "operLogPoinCut()", returning = "keys")
    public void saveOperLog(JoinPoint joinPoint, Object keys) {
        try{

            // 获取RequestAttributes
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            // 从获取RequestAttributes中获取HttpServletRequest的信息
            HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
            // 从切面织入点处通过反射机制获取织入点处的方法
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            // 获取切入点所在的方法
            Method method = signature.getMethod();
            // 获取操作
            OperLog opLog = method.getAnnotation(OperLog.class);
            //通过注解，将json的key自定义
            BeanNameFilter beanNameFilter = new BeanNameFilter();
            //返回值内有日期格式的，格式化为yyyy-MM-dd HH:mm:ss
            BeanValueFilter beanValueFilter = new BeanValueFilter();
            SerializeFilter[] filters = new SerializeFilter[]{
              beanNameFilter,
              beanValueFilter
            };
            RequestLogDTO operlog = this.initLogBean(request,opLog,joinPoint);
            requestLogManager.generateOperlog(operlog,1,keys,filters,null);
        }catch (Exception e){
            logger.error("保存操作日志信息失败:" + e.getMessage());
//            e.printStackTrace();
        }
    }

    /**
     * 异常返回通知，用于拦截异常日志信息 连接点抛出异常后执行
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(pointcut = "operExceptionLogPoinCut()", throwing = "e")
    public void saveExceptionLog(JoinPoint joinPoint, Throwable e) {
        try{
            // 获取RequestAttributes
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            // 从获取RequestAttributes中获取HttpServletRequest的信息
            HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
            // 从切面织入点处通过反射机制获取织入点处的方法
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            // 获取切入点所在的方法
            Method method = signature.getMethod();
            // 获取操作
            OperLog opLog = method.getAnnotation(OperLog.class);
            RequestLogDTO operlog = this.initLogBean(request,opLog,joinPoint);
            requestLogManager.generateOperlog(operlog,2,null,null,e);
        }catch (Exception e2){
            logger.error("保存日志异常信息失败:" + e2.getMessage());
//            e2.printStackTrace();
        }
    }
}
