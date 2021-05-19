package com.bsoft.office.manager.manager.impl;

import com.bsoft.clue.dto.SalesCluesViewDTO;
import com.bsoft.clue.dto.SalesPlanViewDTO;
import com.bsoft.clue.service.SalesCluesService;
import com.bsoft.clue.service.SalesPlanService;
import com.bsoft.common.dto.PublicDicDTO;
import com.bsoft.common.result.Result;
import com.bsoft.common.service.PublicDicService;
import com.bsoft.hr.dto.LaborContractApplyViewDTO;
import com.bsoft.hr.service.LaborContractRenewalService;
import com.bsoft.office.common.dozer.GeneratorUtil;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.manager.condition.ProcessTaskQueryCnd;
import com.bsoft.office.manager.manager.ProcessTaskManager;
import com.bsoft.office.manager.vo.*;
import com.bsoft.workflow.dto.ActionRecordDTO;
import com.bsoft.workflow.dto.ProcessTaskCountDTO;
import com.bsoft.workflow.dto.TaskDTO;
import com.bsoft.workflow.dto.TaskQueryCndDTO;
import com.bsoft.workflow.service.ActionRecordService;
import com.bsoft.workflow.service.WorkFlowActionService;
import com.bsoft.workflow.service.WorkFlowQueryService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: zy
 * @date: 2020/9/22
 * @description 流程待办任务
 */
@Component
public class ProcessTaskManagerImpl implements ProcessTaskManager {

    @Autowired
    private IGenerator iGenerator;
    @Reference(timeout = 10000)
    private WorkFlowQueryService workFlowQueryService;
    @Reference(timeout = 10000)
    private ActionRecordService actionRecordService;
    @Reference(timeout = 10000)
    private WorkFlowActionService workFlowActionService;
    @Reference
    private PublicDicService publicDicService;
    @Reference
    private SalesCluesService salesCluesService;
    @Reference
    private SalesPlanService salesPlanService;
    @Reference
    private LaborContractRenewalService laborContractRenewalService;
    @Override
    public Result<ProcessTaskVO> getTaskList(String userId, ProcessTaskQueryCnd queryCnd) {
        TaskQueryCndDTO queryCndDTO = iGenerator.convert(queryCnd, TaskQueryCndDTO.class);
        Result<TaskDTO> resultDTO = workFlowQueryService.getTaskListWithNotify(userId, queryCndDTO);
        Result<ProcessTaskVO> resultVO = iGenerator.convert(resultDTO, ProcessTaskVO.class);
        return resultVO;
    }

    @Override
    public List<ProcessTaskCountVO> getTaskCount(String userId) {
        List<ProcessTaskCountDTO> processTaskCountDTOList = workFlowQueryService.getProcessTaskCount(userId);
        List<ProcessTaskCountVO> processTaskCountVOList = iGenerator.convert(processTaskCountDTOList, ProcessTaskCountVO.class);
        return processTaskCountVOList;
    }

    @Override
    public List<ProcessTypeTreeVO> getProcessTree(String userId) {
        List<PublicDicDTO> processList = publicDicService.getPublicDic(2005);
        List<ProcessTaskCountDTO> processTaskCountDTOList = workFlowQueryService.getProcessTaskCount(userId);

        List<ProcessTypeTreeVO> processTypeTreeVOList = iGenerator.convert(processList, ProcessTypeTreeVO.class);
        List<ProcessTaskCountVO> processTaskCountVOList = iGenerator.convert(processTaskCountDTOList, ProcessTaskCountVO.class);

        for(ProcessTypeTreeVO node:processTypeTreeVOList) {
            List<ProcessTaskCountVO> children = new ArrayList<>();
            for(ProcessTaskCountVO taskCount:processTaskCountVOList){
                if(taskCount.getType().equals(node.getId())){
                   children.add(taskCount);
                }
            }
            node.setChildren(children);
        }

        return processTypeTreeVOList;
    }

    @Override
    public List<ActionRecordVO> getActionRecordList(String userId, String processInstanceId) {
        List<ActionRecordDTO> actionRecordDTOList = actionRecordService.getActionRecordsWithNext(userId, processInstanceId);
        return iGenerator.convert(actionRecordDTOList, ActionRecordVO.class);

    }

    @Override
    @Transactional
    public void stop(String userId, String processKey, String processInstanceId, String reason) {
        workFlowActionService.stop(userId, processInstanceId, reason);
        if ("laborContract".equals(processKey)) {
            laborContractRenewalService.setStatusToStop(userId, processInstanceId);
        }
    }

    @Override
    public void completeNotifyTask(String userId, String taskId) {
        workFlowActionService.completeNotifyTask(userId, taskId);
    }

    @Override
    public SalesCluesViewVO getSalesClueInfo(String userId, Integer id) {
        SalesCluesViewDTO salesCluesViewDTO = salesCluesService.getClue(userId, id);
        return iGenerator.convert(salesCluesViewDTO,SalesCluesViewVO.class);
    }

    @Override
    public SalesPlanViewVO getSalesPlanInfo(String userId, Integer id) {
        SalesPlanViewDTO salesPlanInfo = salesPlanService.getSalesPlanInfo(userId, id);
        return iGenerator.convert(salesPlanInfo, SalesPlanViewVO.class);
    }

    @Override
    public LaborContractApplyViewVO getLaborContractInfo(String userId, Integer id) {
        LaborContractApplyViewDTO result = laborContractRenewalService.getLaborContractApply(userId, id);
        return iGenerator.convert(result, LaborContractApplyViewVO.class);
    }
}
