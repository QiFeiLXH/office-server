package com.bsoft.office.sysconfig.aspect;

import com.bsoft.logs.dto.RequestLogDTO;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.manager.MenuPublicManager;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.common.vo.MenuVO;
import com.bsoft.office.sysconfig.manager.RequestLogManager;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @version 1.0
 * @author: zy
 * @date: 2021/1/25
 * @description
 */

//@ControllerAdvice
public class BsoftOfficeRequestAdvice implements RequestBodyAdvice {
    private static final Logger logger= LoggerFactory.getLogger(BsoftOfficeRequestAdvice.class);

    @Autowired
    private RequestLogManager requestLogManager;

    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
        try{
//            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//            saveRequestLog(request);
            return inputMessage;
        } catch (Exception e){
            e.printStackTrace();
            return inputMessage;
        }
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return body;
    }

    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return body;
    }

    /**
     * 保存请求信息
     */
//    private void saveRequestLog(HttpServletRequest request) {
//        try {
//            HttpSession session = request.getSession();
//            if (session != null) {
//                RequestLogDTO requestLogDTO = new RequestLogDTO();
//                requestLogDTO.setUrl(request.getRequestURL().toString());// URL
//                requestLogDTO.setPersonId(ContextUtils.getUserId(request));// 工号
//                requestLogDTO.setIp(request.getRemoteAddr());// 主机IP
//                //requestLogDTO.setSystem(2);// 系统
//
//                String menuIdStr = request.getHeader("menuId");
//                Pattern pattern = Pattern.compile("[0-9]*");
//                if (StringUtils.isNotBlank(menuIdStr) && pattern.matcher(menuIdStr).matches()) {
//                    requestLogDTO.setMenuId(Integer.valueOf(menuIdStr)); // 菜单ID
//                }
//
//                Map<String, String[]> paramMap = request.getParameterMap();
//                String paramJson = JSONUtils.toString(paramMap);
//                if (!ServletFileUpload.isMultipartContent(request) && paramJson.length() < 4000) {
//                    // 不是文件上传请求且参数长度小于4000则保存请求参数
//                    requestLogDTO.setParams(paramJson);// 请求参数
//                }
//
//                logger.info("保存POST请求信息{}", JSONUtils.toString(requestLogDTO));
//                requestLogManager.sendMessage(requestLogDTO);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
}
