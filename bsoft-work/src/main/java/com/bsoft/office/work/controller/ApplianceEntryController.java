package com.bsoft.office.work.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.annotation.RequiredExportLog;
import com.bsoft.office.common.condition.ExportLogParams;
import com.bsoft.office.common.exportExcel.*;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.common.vo.CostDicVO;
import com.bsoft.office.work.condition.ApplianceQueryCnd;
import com.bsoft.office.work.manager.ApplianceManager;
import com.bsoft.office.work.vo.ApplianceStockVO;
import com.bsoft.office.work.vo.ApplianceUseVO;
import com.bsoft.office.work.vo.CustomerContactVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author: zy
 * @date: 2020/11/5
 * @description 办公用品入库
 */
@RestController
@RequestMapping("/appliance/entry")
public class ApplianceEntryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplianceEntryController.class);
    @Autowired
    private ApplianceManager applianceManager;

    @GetMapping("/list")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取办公物品入库列表")
    public OfficeResopnseBean getApplianceStockList(ApplianceQueryCnd queryCnd, HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("办公用品入库-获取办公物品入库列表[{}][{}]", userId, JSONUtils.toString(queryCnd));
        Result<ApplianceStockVO> result = applianceManager.getApplianceStockList(userId, queryCnd);
        return OfficeResopnseBean.newSuccessBean(result);
    }

    @PostMapping("/save")
    @OperLog(operType = OperLogType.SAVE,operDesc = "保存办公物品入库信息")
    public OfficeResopnseBean saveApplianceStock(@RequestBody ApplianceStockVO saveVO, HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("办公用品入库-保存办公物品入库信息[{}][{}]", userId, JSONUtils.toString(saveVO));
        applianceManager.saveApplianceStock(userId, saveVO);
        return OfficeResopnseBean.newSuccessBean();
    }

    @PostMapping("/submit")
    @OperLog(operType = OperLogType.SAVE,operDesc = "提交办公物品入库信息")
    public OfficeResopnseBean submitApplianceStock(@RequestBody ApplianceStockVO saveVO, HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("办公用品入库-保存办公物品入库信息[{}][{}]", userId, JSONUtils.toString(saveVO));
        applianceManager.submitApplianceStock(userId, saveVO);
        return OfficeResopnseBean.newSuccessBean();
    }

    @GetMapping("/nameselect")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取办公物品名称")
    public OfficeResopnseBean getApplianceNameSelectList(@RequestParam("type") Integer type,
                                                      @RequestParam("inputContent") String inputContent,
                                                      HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("办公用品入库-获取办公物品名称[{}][{}][{}]", userId, type, inputContent);
        List<CostDicVO> result = applianceManager.getApplianceNameSelectList(type, inputContent);
        return OfficeResopnseBean.newSuccessBean(result);
    }

    @GetMapping("/unpay")
    @OperLog(operType = OperLogType.QUERY,operDesc = "统计未支付金额")
    public OfficeResopnseBean countApplianceUnPayMoney(@RequestParam("type") Integer type , HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("办公用品入库-统计未支付金额[{}][{}]", userId, type);
        Double result = applianceManager.countApplianceUnPayMoney(userId, type);
        return OfficeResopnseBean.newSuccessBean(result);
    }

    /** 客户往来单位列表*/
    @GetMapping("/customers")
    @OperLog(operType = OperLogType.QUERY,operDesc = "客户往来单位列表")
    public OfficeResopnseBean getCustomerContactsList(@RequestParam Integer pageNo,
                                                      @RequestParam Integer pageSize,
                                                      @RequestParam(required = false) String inputContent){
        Result<CustomerContactVO> result = applianceManager.getCustomerContactList(pageNo, pageSize, inputContent);
        return OfficeResopnseBean.newSuccessBean(result);
    }


}
