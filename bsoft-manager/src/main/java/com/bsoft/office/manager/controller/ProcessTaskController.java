package com.bsoft.office.manager.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.manager.condition.ProcessDeployQueryCnd;
import com.bsoft.office.manager.condition.ProcessTaskQueryCnd;
import com.bsoft.office.manager.manager.ProcessDeployManager;
import com.bsoft.office.manager.manager.ProcessTaskManager;
import com.bsoft.office.manager.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: zy
 * @date: 2020/9/22
 * @description 流程待办任务
 */
@RestController
@RequestMapping("/processtask")
public class ProcessTaskController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProcessTaskController.class);
    @Autowired
    private ProcessTaskManager processTaskManager;
    @Autowired
    private ProcessDeployManager processDeployManager;

    /**
     * 获取待办任务列表
     * @param queryCnd
     * @param request
     */
    @GetMapping("/querytask")
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询待办任务")
    public OfficeResopnseBean queryTask(ProcessTaskQueryCnd queryCnd, HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("流程任务管理[{}]查询待办任务[{}]", userId, JSONUtils.toString(queryCnd));
        Result<ProcessTaskVO> resultVO = processTaskManager.getTaskList(userId, queryCnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(resultVO);
        return responseBean;
    }

    /**
     * 获取流程信息列表
     * @param queryCnd
     * @param request
     */
    @GetMapping(value = "/queryprocess")
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询待办任务统计")
    public OfficeResopnseBean queryProcess(ProcessDeployQueryCnd queryCnd, HttpServletRequest request){
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("流程任务管理[{}]查询待办任务统计[{}]", userId);
        List<ProcessTypeTreeVO> resultVO = processTaskManager.getProcessTree(userId);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(resultVO);
        return responseBean;
    }

    /**
     * 获取流程操作信息
     * @param processInstanceId
     * @param request
     */
    @GetMapping(value = "/queryrecord")
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询流程操作信息")
    public OfficeResopnseBean queryRecord(@RequestParam String processInstanceId, HttpServletRequest request){
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("流程任务管理[{}]查询流程操作信息[{}]", userId, processInstanceId);
        List<ActionRecordVO> actionRecordVOList = processTaskManager.getActionRecordList(userId, processInstanceId);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(actionRecordVOList);
        return responseBean;
    }

    /**
     * 终止流程
     * @param processInstanceId
     * @param request
     */
    @GetMapping(value = "/stopprocess")
    @OperLog(operType = OperLogType.OTHER,operDesc = "终止流程")
    public OfficeResopnseBean stopProcess(@RequestParam String processKey, @RequestParam String processInstanceId, HttpServletRequest request){
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("流程任务管理[{}]终止流程[{}]", userId, processInstanceId);
        processTaskManager.stop(userId, processKey, processInstanceId, "管理员操作终止");
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setMsg("终止成功！");
        return responseBean;
    }

    /**
     * 完成知会任务
     */
    @GetMapping(value = "/completenotify")
    @OperLog(operType = OperLogType.SAVE,operDesc = "完成知会任务")
    public OfficeResopnseBean completeNotifyTask(@RequestParam String taskId, HttpServletRequest request){
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("流程任务管理——[{}]完成知会，任务ID[{}]", userId, taskId);
        processTaskManager.completeNotifyTask(userId, taskId);
        return OfficeResopnseBean.newSuccessBean();
    }

    /**
     * 获取销售线索信息
     */
    @GetMapping(value = "/salesclue")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取销售线索信息")
    public OfficeResopnseBean getSalesClueInfo(@RequestParam Integer id, HttpServletRequest request){
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("流程任务管理[{}]获取销售线索信息[{}]", userId, id);
        SalesCluesViewVO result = processTaskManager.getSalesClueInfo(userId, id);
        return OfficeResopnseBean.newSuccessBean(result);
    }

    /**
     * 获取销售计划信息
     */
    @GetMapping(value = "/salesplan")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取销售计划信息")
    public OfficeResopnseBean getSalesPlanInfo(@RequestParam Integer id, HttpServletRequest request){
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("流程任务管理[{}]获取销售计划信息[{}]", userId, id);
        SalesPlanViewVO result = processTaskManager.getSalesPlanInfo(userId, id);
        return OfficeResopnseBean.newSuccessBean(result);
    }

    /**
     * 获取劳动合同信息
     */
    @GetMapping(value = "/laborcontract")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取劳动合同信息")
    public OfficeResopnseBean getlaborContractInfo(@RequestParam Integer id, HttpServletRequest request){
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("流程任务管理[{}]获取劳动合同信息[{}]", userId, id);
        LaborContractApplyViewVO result = processTaskManager.getLaborContractInfo(userId, id);
        return OfficeResopnseBean.newSuccessBean(result);
    }

}
