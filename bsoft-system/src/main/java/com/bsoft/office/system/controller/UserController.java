package com.bsoft.office.system.controller;

import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.system.manager.UserManager;
import com.bsoft.office.system.vo.MenuAndAuthVO;
import com.bsoft.office.system.vo.MenuVO;
import com.bsoft.office.system.vo.PersonVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * 用户基本信息
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserManager userManager;

    @RequestMapping(value = "/admin/info",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询当前登录用户基本信息")
    public OfficeResopnseBean userInfoBySystem(@RequestParam(value = "system",required = true) Integer system,
                                                HttpServletRequest request,
                                                HttpServletResponse response){
        String userId = ContextUtils.getUserId(request);
        logger.info("获取员工[{}]基本信息...",userId);
        PersonVO personVO = userManager.getUserInfo(userId);
        ContextUtils.setAttribute(request,"userName",personVO.getPersonName());
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setProperty("userInfo",personVO);
        return bean;
    }

    @RequestMapping(value = "/admin/nav",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询当前用户的权限信息")
    public OfficeResopnseBean getCurrentUserNav(@RequestParam(value = "system",required = true) Integer system,
                                                HttpServletRequest request,
                                                HttpServletResponse response){
        String userId = ContextUtils.getUserId(request);
        logger.info("获取系统[{}],员工[{}],菜单导航信息",system,userId);
        List<MenuAndAuthVO> results = userManager.getCurrentUserNavBySystem(userId, system);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(results);
        return bean;
    }
}
