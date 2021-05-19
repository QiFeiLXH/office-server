package com.bsoft.office.manager.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.common.vo.PublicDicVO;
import com.bsoft.office.manager.condition.AppBindCountQueryCnd;
import com.bsoft.office.manager.condition.AppDeptCountQueryCnd;
import com.bsoft.office.manager.manager.AppUserCountManager;
import com.bsoft.office.manager.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: zy
 * @date: 2020/10/19
 * @description APP用户分布情况分析
 */
@RestController
@RequestMapping("/app/usercount")
public class AppUserCountController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppUserCountController.class);
    @Autowired
    private AppUserCountManager appUserCountManager;

    @RequestMapping("/dept")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取APP用户部门分布情况列表")
    public OfficeResopnseBean doQueryAppDeptCountList(AppDeptCountQueryCnd queryCnd, HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("[{}]获取APP用户部门分布情况列表[{}]", userId, JSONUtils.toString(queryCnd));
        Result<AppDeptCountVO> result = appUserCountManager.getDeptCountList(userId, queryCnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        return responseBean;
    }

    @RequestMapping("/depttype")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取部门分类列表")
    public OfficeResopnseBean doQueryDeptTypeList(HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("[{}]获取部门分类列表", userId);
        List<PublicDicVO> result = appUserCountManager.getDeptTypeList();
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        return responseBean;
    }

    @RequestMapping("/province")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取APP用户省份分布情况列表")
    public OfficeResopnseBean doQueryAppProvinceCountList(HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("[{}]获取APP用户省份分布情况列表", userId);
        List<AppProvinceCountVO> result = appUserCountManager.getProvinceCountList(userId);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        return responseBean;
    }

    @RequestMapping("/terminal")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取APP用户终端分布情况列表")
    public OfficeResopnseBean doQueryAppTerminalCountList(HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("[{}]获取APP用户终端分布情况列表", userId);
        List<AppTerminalCountVO> result = appUserCountManager.getTerminalCountList(userId);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        return responseBean;
    }

    @RequestMapping("/proportion")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取APP用户占比情况")
    public OfficeResopnseBean doQueryAppBoundProportion(AppDeptCountQueryCnd queryCnd,HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("[{}]获取APP用户占比情况", userId);
        AppBoundProportionVO result = appUserCountManager.getBoundProportion(userId,queryCnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        return responseBean;
    }


}
