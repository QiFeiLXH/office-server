package com.bsoft.office.sales.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.common.vo.ActionRecordVO;
import com.bsoft.office.sales.manager.SalesCluesManager;
import com.bsoft.office.sales.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/salesclues")
public class SalesCluesController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SalesCluesController.class);
    @Autowired
    private SalesCluesManager salesCluesManager;

    /**
     * 销售线索 审核同意
     */
    @RequestMapping(value = "/agree",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.MODIFY,operDesc = "审核销售线索同意")
    public OfficeResopnseBean agree(@RequestParam String taskId,@RequestParam String opinion,@RequestParam Integer clueId,@RequestParam  String processInstanceId, HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        salesCluesManager.successApply(personId,taskId,opinion,5,clueId,processInstanceId);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        LOGGER.info("销售线索 审核同意");
        return responseBean;
    }

    /**
     * 销售线索 审核不同意
     */
    @RequestMapping(value = "/disagree",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.MODIFY,operDesc = "审核销售线索不同意")
    public OfficeResopnseBean disagree(@RequestParam String taskId,@RequestParam String opinion, HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        salesCluesManager.failApply(personId,taskId,opinion,5);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        LOGGER.info("销售线索 审核不同意");
        return responseBean;
    }

    @RequestMapping(value = "/auditall",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.MODIFY,operDesc = "批量审核销售线索")
    public OfficeResopnseBean auditWithList(@RequestBody List<SalesCluesAuditVO> auditVOS, HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        for(SalesCluesAuditVO auditVO : auditVOS){
            String taskId = auditVO.getTaskId();
            String opinion = auditVO.getOpinion();
            Integer system = auditVO.getSystem();
            if(auditVO.getFlag().equals(1)){ // flag为1 同意
                Integer clueId = auditVO.getClueId();
                String processInstanceId = auditVO.getProcessInstanceId();
                salesCluesManager.successApply(personId,taskId,opinion,5,clueId,processInstanceId);
            }else if(auditVO.getFlag().equals(2)){ // flag为2 退回
                salesCluesManager.failApply(personId,taskId,opinion,5);
            }
        }
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        LOGGER.info("销售线索 批量审核");
        return responseBean;
    }


    /**
     * 销售线索  获取待办列表
     */
    @RequestMapping(value = "/getlist",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询销售线索审核待办列表")
    public OfficeResopnseBean getTaskList(@RequestBody TaskQueryCndVO data, HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        data.setPersonId(personId);//设置查询条件-待办人
        Result<SalesCluesTaskVO> result = salesCluesManager.getTaskList(personId,data);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        LOGGER.info("获取消息线索审核 待办列表");
        return responseBean;
    }

    /**
     * 销售线索  获取基本信息以及审核流程操作信息
     */
    @RequestMapping(value = "/getclue",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询销售线索基本信息及审核流程操作信息")
    public OfficeResopnseBean getClue(@RequestParam Integer clueId,@RequestParam String processInstanceId, HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        SalesCluesViewVO clueInfo = salesCluesManager.getClue(personId,clueId);
        List<ActionRecordVO> actionRecords = salesCluesManager.getActionRecords(personId,processInstanceId);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        Map<String,Object> result = new HashMap<>();
        result.put("clueInfo",clueInfo);
        result.put("actionRecords",actionRecords);
        responseBean.setBody(result);
        LOGGER.info("获取销售线索基本信息以及审核流程操作信息");
        return responseBean;
    }

    /**
     * 销售线索  获取基本信息以及审核流程操作信息（设置已读）
     */
    @RequestMapping(value = "/getclueread",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.MODIFY,operDesc = "查询销售线索基本信息及审核流程操作信息,并设置已读")
    public OfficeResopnseBean getClue(@RequestParam Integer clueId,@RequestParam String processInstanceId,@RequestParam String taskId, HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        SalesCluesViewVO clueInfo = salesCluesManager.getClue(personId,clueId,taskId);
        List<ActionRecordVO> actionRecords = salesCluesManager.getActionRecords(personId,processInstanceId);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        Map<String,Object> result = new HashMap<>();
        result.put("clueInfo",clueInfo);
        result.put("actionRecords",actionRecords);
        responseBean.setBody(result);
        LOGGER.info("获取销售线索基本信息以及审核流程操作信息");
        return responseBean;
    }



}
