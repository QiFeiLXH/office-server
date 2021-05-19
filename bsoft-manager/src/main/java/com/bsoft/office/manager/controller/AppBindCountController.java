package com.bsoft.office.manager.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.manager.condition.AppBindCountQueryCnd;
import com.bsoft.office.manager.manager.AppBindCountManager;
import com.bsoft.office.manager.manager.AppUserCountManager;
import com.bsoft.office.manager.vo.AppBindCountVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: zy
 * @date: 2020/10/23
 * @description APP用户绑定情况统计
 */
@RestController
@RequestMapping("/app/bindcount")
public class AppBindCountController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppUserCountController.class);
    @Autowired
    private AppBindCountManager appBindCountManager;

    @RequestMapping("/total")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取APP用户绑定总人数")
    public OfficeResopnseBean doQueryAppBindTotalCount(HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("[{}]获取APP用户绑定总人数", userId);
        Integer result = appBindCountManager.getBindTotalCount(userId);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        return responseBean;
    }

    @RequestMapping("/chart")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取APP用户绑定情况图表")
    public OfficeResopnseBean doQueryAppBindCountListForChart(AppBindCountQueryCnd queryCnd, HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("[{}]获取APP用户绑定情况图表[{}]", userId, JSONUtils.toString(queryCnd));
        List<AppBindCountVO> result = appBindCountManager.getBindCountList(userId, queryCnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        return responseBean;
    }

    @RequestMapping("/table")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取APP用户绑定情况列表")
    public OfficeResopnseBean doQueryAppBindCountListForTable(AppBindCountQueryCnd queryCnd, HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("[{}]获取APP用户绑定情况列表[{}]", userId, JSONUtils.toString(queryCnd));
        Result<AppBindCountVO> result = appBindCountManager.getBindCountListWithPage(userId, queryCnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        return responseBean;
    }
}
