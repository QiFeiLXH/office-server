package com.bsoft.office.sales.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.annotation.RequiredExportLog;
import com.bsoft.office.common.condition.ExportLogParams;
import com.bsoft.office.common.exportExcel.ExportExcel;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.common.vo.ActionRecordVO;
import com.bsoft.office.sales.manager.SalesCluesManager;
import com.bsoft.office.sales.manager.SalesPlanManager;
import com.bsoft.office.sales.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/salesplanaudit")
public class SalesPlanAuditController {
    private final  static Logger LOGGER = LoggerFactory.getLogger(SalesPlanAuditController.class);
    @Autowired
    private SalesPlanManager salesPlanManager;
    @Autowired
    private SalesCluesManager salesCluesManager;

    @RequestMapping(value = "/getlist",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询本人销售计划审核列表")
    public OfficeResopnseBean getAuditList(@RequestBody TaskQueryCndVO queryCndVO, HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        queryCndVO.setPersonId(personId);
        Result<SalesPlanViewVO> result = salesPlanManager.getSalesPlanAuditList(personId,queryCndVO);
        SalesPlanAmountVO salesPlanAmountVO = salesPlanManager.getSalesPlanAmountWithAudit(personId,queryCndVO);
        OfficeResopnseBean resopnseBean = OfficeResopnseBean.newSuccessBean();
        Map<String,Object> res = new HashMap<>();
        res.put("list",result);
        res.put("amount",salesPlanAmountVO);
        resopnseBean.setBody(res);
        LOGGER.info("工号:{}获取本人销售计划审核列表成功",new Object[]{personId});
        return resopnseBean;
    }

    @RequestMapping(value = "/getpersons",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询本人销售计划待办任务中所有跟单人列表")
    public OfficeResopnseBean getTrackPersons(@RequestBody TaskQueryCndVO queryCndVO, HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        queryCndVO.setPersonId(personId);
        List<SalesPlanPersonVO> list = salesPlanManager.getTrackPersonsByAuditor(personId,queryCndVO);
        OfficeResopnseBean resopnseBean = OfficeResopnseBean.newSuccessBean();
        resopnseBean.setBody(list);
        LOGGER.info("工号:{}获取本人销售计划待办任务中所有跟单人列表",new Object[]{personId});
        return resopnseBean;
    }

    @RequestMapping(value = "/getdepts",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询本人销售计划待办任务中所有跟单部门列表")
    public OfficeResopnseBean getDepts(@RequestBody TaskQueryCndVO queryCndVO, HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        queryCndVO.setPersonId(personId);
        List<SalesPlanDeptVO> list = salesPlanManager.getTrackDeptsByAuditor(personId,queryCndVO);
        OfficeResopnseBean resopnseBean = OfficeResopnseBean.newSuccessBean();
        resopnseBean.setBody(list);
        LOGGER.info("工号:{}获取本人销售计划待办任务中所有跟单部门列表",new Object[]{personId});
        return resopnseBean;
    }

    /**
     * 销售线索 审核同意
     */
    @RequestMapping(value = "/agree",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.MODIFY,operDesc = "销售计划，审核同意")
    public OfficeResopnseBean agree(@RequestBody SalesPlanAuditVO salesPlanAuditVO, HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        String taskId = salesPlanAuditVO.getTaskId();
        String opinion = salesPlanAuditVO.getOpinion();
        Integer id = salesPlanAuditVO.getId();
        SalesPlanVO salesPlanVO = salesPlanAuditVO.getSalesPlanVO();
        String processInstanceId = salesPlanAuditVO.getProcessInstanceId();
        salesPlanManager.successApply(personId,taskId,opinion,5,id,processInstanceId);
        salesPlanManager.updateSalesPlanWithAudit(personId,salesPlanVO);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        LOGGER.info("销售计划 审核同意");
        return responseBean;
    }

    /**
     * 销售线索 审核不同意
     */
    @RequestMapping(value = "/disagree",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.MODIFY,operDesc = "销售计划，审核不同意")
    public OfficeResopnseBean disagree(@RequestBody SalesPlanAuditVO salesPlanAuditVO, HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        String taskId = salesPlanAuditVO.getTaskId();
        String opinion = salesPlanAuditVO.getOpinion();
        SalesPlanVO salesPlanVO = salesPlanAuditVO.getSalesPlanVO();
        salesPlanManager.failApply(personId,taskId,opinion,5);
        salesPlanManager.updateSalesPlanWithAudit(personId,salesPlanVO);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        LOGGER.info("销售计划 审核不同意");
        return responseBean;
    }

    /**
     * 销售线索  获取基本信息以及审核流程操作信息
     */
    @RequestMapping(value = "/getplan",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询销售计划基本信息及审核流程操作信息")
    public OfficeResopnseBean getPlan(@RequestParam Integer Id,@RequestParam String processInstanceId,HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        SalesPlanDetailViewVO planInfo = salesPlanManager.getSalesPlanDetail(personId,Id);
        List<ActionRecordVO> actionRecords = salesPlanManager.getActionRecords(personId,processInstanceId);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        Map<String,Object> result = new HashMap<>();
        result.put("planInfo",planInfo);
        result.put("actionRecords",actionRecords);
        responseBean.setBody(result);
        LOGGER.info("获取销售计划基本信息以及审核流程操作信息");
        return responseBean;
    }

    /**
     * 销售线索  获取基本信息以及审核流程操作信息（设置已读）
     */
    @RequestMapping(value = "/getplanread",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询销售计划基本信息及审核流程操作信息，并设置已读")
    public OfficeResopnseBean getPlan(@RequestParam Integer Id,@RequestParam String processInstanceId,@RequestParam String taskId, HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        SalesPlanDetailViewVO planInfo = salesPlanManager.getSalesPlanDetail(personId,Id,taskId);
        List<ActionRecordVO> actionRecords = salesPlanManager.getActionRecords(personId,processInstanceId);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        Map<String,Object> result = new HashMap<>();
        result.put("planInfo",planInfo);
        result.put("actionRecords",actionRecords);
        responseBean.setBody(result);
        LOGGER.info("获取销售计划基本信息以及审核流程操作信息");
        return responseBean;
    }

    @RequestMapping(value = "/auditall",method = RequestMethod.POST)
    public OfficeResopnseBean auditWithList(@RequestBody List<SalesPlanAuditVO> auditVOS, HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        for(SalesPlanAuditVO auditVO : auditVOS){
            String taskId = auditVO.getTaskId();
            String opinion = auditVO.getOpinion();
            String processInstanceId = auditVO.getProcessInstanceId();
            Integer id = auditVO.getId();
            if(auditVO.getFlag().equals(1)){ // flag为1 同意
                salesPlanManager.successApply(personId,taskId,opinion,5,id,processInstanceId);
            }else if(auditVO.getFlag().equals(2)){ // flag为2 退回
                salesPlanManager.failApply(personId,taskId,opinion,5);
            }
        }
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        LOGGER.info("销售计划 批量审核");
        return responseBean;
    }

    /**
     *功能描述: 反馈意见导出
     */
    @PostMapping("/exportdownload")
    @RequiredExportLog
    public void exportOpinion(@RequestBody TaskQueryCndVO queryCndVO, ExportLogParams params,  HttpServletRequest request,
                              HttpServletResponse response){
        String personId = ContextUtils.getUserId(request);
        queryCndVO.setPersonId(personId);
        Result<SalesPlanViewVO> result = salesPlanManager.getSalesPlanAuditList(personId,queryCndVO);
        List<SalesPlanViewVO> list = result.getItems();
        ExportExcel.export(list, SalesPlanViewVO.class,"销售计划列表",response);
    }



}
