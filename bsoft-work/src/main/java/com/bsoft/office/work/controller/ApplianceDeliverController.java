package com.bsoft.office.work.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.work.condition.ApplianceQueryCnd;
import com.bsoft.office.work.manager.ApplianceManager;
import com.bsoft.office.work.vo.ApplianceUseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: zy
 * @date: 2020/11/5
 * @description 办公用品领用
 */
@RestController
@RequestMapping("/appliance/deliver")
public class ApplianceDeliverController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplianceDeliverController.class);

    @Autowired
    private ApplianceManager applianceManager;

    @GetMapping("/list")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取办公物品领用情况列表")
    public OfficeResopnseBean getApplianceUseList(ApplianceQueryCnd queryCnd, HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("办公用品领用-获取办公物品领用情况列表[{}][{}]", userId, JSONUtils.toString(queryCnd));
        Result<ApplianceUseVO> result = applianceManager.getApplianceUseList(userId, queryCnd);
        return OfficeResopnseBean.newSuccessBean(result);
    }

}
