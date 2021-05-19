package com.bsoft.office.work.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.work.condition.ApplianceQueryCnd;
import com.bsoft.office.work.manager.ApplianceManager;
import com.bsoft.office.work.vo.ApplianceStockVO;
import com.bsoft.office.work.vo.ApplianceUseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: zy
 * @date: 2020/11/5
 * @description 办公用品库存
 */
@RestController
@RequestMapping("/appliance/store")
public class ApplianceStoreController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplianceStoreController.class);
    @Autowired
    private ApplianceManager applianceManager;

    @GetMapping("/list")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取办公物品库存列表")
    public OfficeResopnseBean getApplianceStoreList(ApplianceQueryCnd queryCnd, HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("办公用品库存-获取办公物品库存列表[{}][{}]", userId, JSONUtils.toString(queryCnd));
        Result<ApplianceStockVO> result = applianceManager.getApplianceStoreList(userId, queryCnd);
        return OfficeResopnseBean.newSuccessBean(result);
    }

    @GetMapping("/usedetail")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取办公物品领用情况")
    public OfficeResopnseBean getApplianceUseDetail(Integer stockId, HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("办公用品库存-获取办公物品领用情况[{}][{}]", userId, stockId);
        List<ApplianceUseVO> result = applianceManager.getApplianceUseDetail(userId, stockId);
        return OfficeResopnseBean.newSuccessBean(result);
    }
}
