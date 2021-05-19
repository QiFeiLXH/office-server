package com.bsoft.office.work.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.work.condition.ApplianceNameQueryCnd;
import com.bsoft.office.work.manager.ApplianceManager;
import com.bsoft.office.work.vo.ApplianceNameVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: zy
 * @date: 2020/12/2
 * @description 行政用品名称
 */
@RestController
@RequestMapping("/appliance/name")
public class ApplianceNameController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplianceNameController.class);
    @Autowired
    private ApplianceManager applianceManager;

    @GetMapping("/list")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取行政用品类别列表")
    public OfficeResopnseBean getApplianceNameList(ApplianceNameQueryCnd queryCnd, HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("行政用品名称-获取行政用品类别列表[{}][{}]", userId, queryCnd);
        Result<ApplianceNameVO> result = applianceManager.getApplianceNameList(userId, queryCnd);
        return OfficeResopnseBean.newSuccessBean(result);
    }

    @PostMapping("/save")
    @OperLog(operType = OperLogType.SAVE,operDesc = "保存物品名称字典信息")
    public OfficeResopnseBean saveApplianceTypes(@RequestBody ApplianceNameVO saveVO, HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("行政用品名称-保存物品名称字典信息[{}][{}]", userId, saveVO);
        applianceManager.saveApplianceName(userId, saveVO);
        return OfficeResopnseBean.newSuccessBean();
    }
}
