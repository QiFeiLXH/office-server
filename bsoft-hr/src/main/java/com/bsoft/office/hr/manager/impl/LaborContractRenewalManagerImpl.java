package com.bsoft.office.hr.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.hr.dto.*;
import com.bsoft.hr.service.LaborContractRenewalService;
import com.bsoft.office.common.dozer.GeneratorUtil;
import com.bsoft.office.common.vo.ActionRecordVO;
import com.bsoft.office.common.vo.CustomerParamVO;
import com.bsoft.office.hr.condition.LaborContractProcessTaskQueryCnd;
import com.bsoft.office.hr.condition.LaborContractQueryCnd;
import com.bsoft.office.common.vo.TaskAuditVO;
import com.bsoft.office.hr.manager.LaborContractRenewalManager;
import com.bsoft.office.hr.vo.*;
import com.bsoft.office.hr.vo.LaborContractApplyVO;
import com.bsoft.office.hr.vo.LaborContractApplyViewVO;
import com.bsoft.office.hr.vo.TaskQueryCndVO;
import com.bsoft.office.hr.vo.LaborContractApplyVO;
import com.bsoft.office.hr.vo.LaborContractApplyViewVO;
import com.bsoft.office.hr.vo.LaborContractQuitViewVO;
import com.bsoft.office.hr.vo.TaskQueryCndVO;
import com.bsoft.workflow.dto.ActionRecordDTO;
import com.bsoft.workflow.dto.CustomerParamDTO;
import com.bsoft.workflow.dto.TaskDTO;
import com.bsoft.workflow.dto.TaskAuditDTO;
import com.bsoft.workflow.dto.TaskQueryCndDTO;
import com.bsoft.workflow.service.ActionRecordService;
import com.bsoft.workflow.service.WorkFlowActionService;
import com.bsoft.workflow.service.WorkFlowQueryService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-12-09 13:42
 * @Version 1.0
 */
@Component
public class LaborContractRenewalManagerImpl implements LaborContractRenewalManager {
    @Reference(timeout = 60000)
    private LaborContractRenewalService laborContractRenewalService;
    @Reference(timeout = 60000)
    private WorkFlowQueryService workFlowQueryService;
    @Reference(timeout = 60000)
    private WorkFlowActionService workFlowActionService;
    @Reference(timeout = 60000)
    private ActionRecordService actionRecordService;
    @Override
    public Result<LaborContractApplyViewVO> getLaborContractAuditList(String personId,TaskQueryCndVO cnd) {
        TaskQueryCndDTO queryCndDTO = GeneratorUtil.instance().convert(cnd,TaskQueryCndDTO.class);
        Result<LaborContractApplyViewDTO> result = laborContractRenewalService.getLaborContractAuditList(personId,queryCndDTO);
        return GeneratorUtil.instance().convert(result,LaborContractApplyViewVO.class);
    }

    @Override
    public void deptAudit(String personId, LaborContractApplyVO laborContractApply, TaskAuditVO taskAuditVO) {
        LaborContractApplyDTO dto = GeneratorUtil.instance().convert(laborContractApply,LaborContractApplyDTO.class);
        TaskAuditDTO taskAuditDTO = GeneratorUtil.instance().convert(taskAuditVO,TaskAuditDTO.class);
        laborContractRenewalService.deptAudit(personId,dto,taskAuditDTO);
    }

    @Override
    public void areaAudit(String personId, LaborContractApplyVO laborContractApply, TaskAuditVO taskAuditVO) {
        LaborContractApplyDTO dto = GeneratorUtil.instance().convert(laborContractApply,LaborContractApplyDTO.class);
        TaskAuditDTO taskAuditDTO = GeneratorUtil.instance().convert(taskAuditVO,TaskAuditDTO.class);
        laborContractRenewalService.areaAudit(personId,dto,taskAuditDTO);
    }

    @Override
    public void hrAudit(Integer flag, String personId, LaborContractApplyVO laborContractApply, TaskAuditVO taskAuditVO) {
        LaborContractApplyDTO dto = GeneratorUtil.instance().convert(laborContractApply,LaborContractApplyDTO.class);
        TaskAuditDTO taskAuditDTO = GeneratorUtil.instance().convert(taskAuditVO,TaskAuditDTO.class);
        laborContractRenewalService.hrAudit(flag,personId,dto,taskAuditDTO);
    }

    @Override
    public List<CustomerParamVO> getCustomParam(String personId, String taskId) {
        List<CustomerParamDTO> list = workFlowQueryService.getCustomParam(personId,taskId);
        return GeneratorUtil.instance().convert(list,CustomerParamVO.class);
    }

    @Override
    public Result<LaborContractProcessTaskVO> getProcessTaskList(String personId, LaborContractProcessTaskQueryCnd queryCnd) {
        TaskQueryCndDTO queryCndDTO = GeneratorUtil.instance().convert(queryCnd, TaskQueryCndDTO.class);
        queryCndDTO.setProcessDefinitionKey("laborContract");
        Result<TaskDTO> result = workFlowQueryService.getTaskListWithNotify(personId, queryCndDTO);
        return GeneratorUtil.instance().convert(result, LaborContractProcessTaskVO.class);
    }

    @Override
    public Result<LaborContractViewVO> getLaborContractList(String personId, LaborContractQueryCnd queryCnd) {
        LaborContractQueryCndDTO queryCndDTO = GeneratorUtil.instance().convert(queryCnd, LaborContractQueryCndDTO.class);
        Result<LaborContractViewDTO> result = laborContractRenewalService.getLaborContractInfoList(personId, queryCndDTO);
        return GeneratorUtil.instance().convert(result, LaborContractViewVO.class);
    }

    @Override
    public List<ActionRecordVO> getActionRecords(String personId, String processInstanceId) {
        List<ActionRecordDTO> list = actionRecordService.getActionRecordsWithNext(personId,processInstanceId);
        return GeneratorUtil.instance().convert(list,ActionRecordVO.class);
    }

    @Override
    public LaborContractApplyViewVO getLaborContractApplyView(String personId, Integer id) {
        LaborContractApplyViewDTO dto = laborContractRenewalService.getLaborContractApply(personId, id);
        return GeneratorUtil.instance().convert(dto,LaborContractApplyViewVO.class);
    }

    @Override
    public List<LaborContractQuitViewVO> getQuitList(String personId) {
        List<LaborContractQuitViewDTO> quit = laborContractRenewalService.getLaborContractQuitList(personId);
        return GeneratorUtil.instance().convert(quit,LaborContractQuitViewVO.class);
    }

    @Override
    public List<LaborContractApplyViewVO> getPersonalLaborContractApplyViewList(String userId, String personId) {
        List<LaborContractApplyViewDTO> list = laborContractRenewalService.getPersonalLaborContractApplyViewList(userId, personId);
        return GeneratorUtil.instance().convert(list, LaborContractApplyViewVO.class);
    }

    @Override
    public void completeNotifyTask(String user, String taskId) {
        workFlowActionService.completeNotifyTask(user, taskId);
    }

    @Override
    public List<LaborContractDetailViewVO> getLaborContractDetail(String userId, String personId) {
        List<LaborContractDetailViewDTO> list = laborContractRenewalService.getLaborContractDetail(userId, personId);
        return GeneratorUtil.instance().convert(list, LaborContractDetailViewVO.class);
    }


}
