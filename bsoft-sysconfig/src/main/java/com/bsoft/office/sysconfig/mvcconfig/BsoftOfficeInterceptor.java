package com.bsoft.office.sysconfig.mvcconfig;

import com.bsoft.office.common.exception.NoLogonException;
import com.bsoft.office.common.manager.MenuPublicManager;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.common.utils.IpUtils;
import com.bsoft.office.common.vo.MenuVO;
import com.bsoft.office.sysconfig.manager.RequestLogManager;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class BsoftOfficeInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(BsoftOfficeInterceptor.class);

    @Autowired
    private RequestLogManager requestLogManager;

    @Autowired
    private MenuPublicManager menuPublicManager;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        logger.info("IP地址：[{}],发送[{}]请求！", IpUtils.getIpAdrress(request),request.getServletPath());
        if (request.getServletPath().equals("/auth/login") ||
                request.getServletPath().equals("/auth/logout") ||
                request.getServletPath().equals("/auth/checkLogon") ||
                request.getServletPath().equals("/auth/checkEnable") ||
                request.getServletPath().equals("/oauth/autoLogin") ||
                request.getServletPath().equals("/code/refresh") ||
                request.getServletPath().equals("/employe/sendsms") ||
                request.getServletPath().equals("/employe/checksms") ||
                request.getServletPath().equals("/employe/checkrecruitmentstatus")
        ){
            return true;

        }
        // 校验员工 、请求 、菜单是否能匹配，能则请求继续否则终止
//        if (!checkRequestAuth(request)) {
//            OfficeResopnseBean bean = OfficeResopnseBean.newFailBean(404,"请求不正确，请先确认是否拥有菜单权限！");
//            returnJson(response, JSONObject.toJSONString(bean));
//            return false;
//        }
        HttpSession httpSession = request.getSession(false);

        if (request.getServletPath().startsWith("/employe")){
            //招聘信息
            if (httpSession == null){
                throw new NoLogonException("验证手机号码！");
            }
            String mobileno = (String) httpSession.getAttribute("mobileno");
            if (mobileno == null || mobileno == ""){
                throw new NoLogonException("验证手机号码！");
            }
        } else {
            //系统登录
            if (httpSession == null){
                throw new NoLogonException("请重新登录");
            }
            String userId = (String) httpSession.getAttribute("userId");
            if (userId == null || userId == ""){
                throw new NoLogonException("请重新登录");
            }
        }

        // 保存请求信息
//        if (request.getMethod().toLowerCase().equals("get")) {
//            this.saveRequestLog(request);
//        }

        return true;
    }

    private boolean checkRequestAuth(HttpServletRequest request) {
        String urlPath = request.getServletPath();
        String userId = ContextUtils.getUserId(request);
        Integer menuId = ContextUtils.getMenuId(request);
        MenuVO menu = menuPublicManager.getMenuInfo(menuId);
        // 判断请求url与菜单是否匹配
        if (StringUtils.isNotBlank(menu.getPrefix()) && urlPath.contains(menu.getPrefix())) {
            // 如果菜单是公用的，则直接放行请求
            if (menu.getPubFlag() == 1) {
                logger.info("请求校验通过,菜单id:{},url:{}",menuId, urlPath);
                return true;
            } else {
                // 否则查看员工是否拥有该菜单权限
                boolean result = menuPublicManager.checkPrivateMenuPermission(userId, menuId);
                logger.info("请求校验结果:{},菜单id:{},url:{}",result,menuId,urlPath);
                return result;
            }
        } else {
            logger.info("请求校验结果失败，请求url与菜单不匹配,菜单id:{},url:{}",menuId,urlPath);
            return false;
        }
    }

    /**
     * 保存请求信息
     */
//    private void saveRequestLog(HttpServletRequest request) {
//        try {
//            RequestLogDTO requestLogDTO = new RequestLogDTO();
//            requestLogDTO.setUrl(request.getRequestURL().toString());// URL
//            requestLogDTO.setPersonId(ContextUtils.getUserId(request));// 工号
//            requestLogDTO.setIp(request.getRemoteAddr());// 主机IP
//            //requestLogDTO.setSystem(2);// 系统
//
//            String menuIdStr = request.getHeader("menuId");
//            Pattern pattern = Pattern.compile("[0-9]*");
//            if (StringUtils.isNotBlank(menuIdStr) && pattern.matcher(menuIdStr).matches()) {
//                requestLogDTO.setMenuId(Integer.valueOf(menuIdStr)); // 菜单ID
//            }
//
//            Map<String, String[]> paramMap = request.getParameterMap();
//            String paramJson = JSONUtils.toString(paramMap);
//            if (!ServletFileUpload.isMultipartContent(request) && paramJson.length() < 4000) {
//                // 不是文件上传请求且参数长度小于4000则保存请求参数
//                requestLogDTO.setParams(paramJson);// 请求参数
//            }
//
//            logger.info("保存GET请求信息{}", JSONUtils.toString(requestLogDTO));
//            requestLogManager.sendMessage(requestLogDTO);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                 @Nullable Exception ex) throws Exception {

    }
}
