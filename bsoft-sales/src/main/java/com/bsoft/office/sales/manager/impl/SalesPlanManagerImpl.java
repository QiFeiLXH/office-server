package com.bsoft.office.sales.manager.impl;

import com.bsoft.clue.dto.*;
import com.bsoft.clue.service.SalesPlanService;
import com.bsoft.common.result.Result;
import com.bsoft.dept.dto.DeptDTO;
import com.bsoft.office.common.dozer.GeneratorUtil;
import com.bsoft.office.common.vo.ActionRecordVO;
import com.bsoft.office.sales.condition.SalesPlanQueryCndVO;
import com.bsoft.office.sales.manager.SalesPlanManager;
import com.bsoft.office.sales.vo.*;
import com.bsoft.person.dto.PersonDTO;
import com.bsoft.workflow.dto.ActionRecordDTO;
import com.bsoft.workflow.dto.TaskQueryCndDTO;
import com.bsoft.workflow.service.ActionRecordService;
import com.bsoft.workflow.service.WorkFlowActionService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SalesPlanManagerImpl implements SalesPlanManager {
    @Reference(timeout = 60000)
    private SalesPlanService salesPlanService;
    @Reference
    private ActionRecordService actionRecordService;
    @Reference(timeout = 10000)
    private WorkFlowActionService workFlowActionService;
    @Override
    public Result<SalesPlanVO> getSalesPlan(String personId, SalesPlanQueryCndVO cnd) {
        SalesPlanQueryCndDTO cndDTO = GeneratorUtil.instance().convert(cnd,SalesPlanQueryCndDTO.class);
        Result<SalesPlanDTO> result = salesPlanService.getSalesPlan(personId,cndDTO);
        return GeneratorUtil.instance().convert(result,SalesPlanVO.class);
    }

    @Override
    public List<SalesCluesViewVO> getClues(String personId) {
        List<SalesCluesViewDTO> list = salesPlanService.getClues(personId);
        return GeneratorUtil.instance().convert(list, SalesCluesViewVO.class);
    }

    @Override
    public void save(String personId, List<SalesPlanVO> list) {
        List<SalesPlanDTO> planDTOS = GeneratorUtil.instance().convert(list,SalesPlanDTO.class);
        salesPlanService.save(personId,planDTOS);
    }

    @Override
    public SalesPlanAmountVO getSalesPlanAmount(String personId, SalesPlanQueryCndVO cnd) {
        SalesPlanQueryCndDTO cndDTO = GeneratorUtil.instance().convert(cnd,SalesPlanQueryCndDTO.class);
        SalesPlanAmountDTO salesPlanAmountDTO = salesPlanService.getSalesPlanAmount(personId,cndDTO);
        return GeneratorUtil.instance().convert(salesPlanAmountDTO,SalesPlanAmountVO.class);
    }

    @Override
    public SalesPlanAmountVO getSalesPlanAmountWithAudit(String personId, TaskQueryCndVO cnd) {
        TaskQueryCndDTO cndDTO = GeneratorUtil.instance().convert(cnd,TaskQueryCndDTO.class);
        SalesPlanAmountDTO salesPlanAmountDTO = salesPlanService.getSalesPlanAmountWithAudit(personId,cndDTO);
        return GeneratorUtil.instance().convert(salesPlanAmountDTO,SalesPlanAmountVO.class);
    }

    @Override
    public List<String> getReportMonthWithYear(String personId, String year) {
        return salesPlanService.getReportMonthWithYear(personId, year);
    }

    @Override
    public List<SalesPlanPersonVO> getTrackPersonsByAuditor(String personId,TaskQueryCndVO cnd) {
        TaskQueryCndDTO cndDTO = GeneratorUtil.instance().convert(cnd,TaskQueryCndDTO.class);
        List<PersonDTO> list = salesPlanService.getTrackPersonsByAuditor(personId,cndDTO);
        return GeneratorUtil.instance().convert(list,SalesPlanPersonVO.class);
    }

    @Override
    public List<SalesPlanDeptVO> getTrackDeptsByAuditor(String personId, TaskQueryCndVO cnd) {
        TaskQueryCndDTO cndDTO = GeneratorUtil.instance().convert(cnd,TaskQueryCndDTO.class);
        List<DeptDTO> list = salesPlanService.getTrackDeptsByAuditor(personId,cndDTO);
        return GeneratorUtil.instance().convert(list,SalesPlanDeptVO.class);
    }

    @Override
    public Result<SalesPlanViewVO> getSalesPlanAuditList(String personId,TaskQueryCndVO cnd) {
        TaskQueryCndDTO cndDTO = GeneratorUtil.instance().convert(cnd,TaskQueryCndDTO.class);
        Result<SalesPlanViewDTO> result = salesPlanService.getSalesPlanAuditList(personId,cndDTO);
        return GeneratorUtil.instance().convert(result,SalesPlanViewVO.class);
    }

    @Override
    public void successApply(String personId, String taskId, String opinion, Integer system,Integer id,String processInstanceId) {
        salesPlanService.successApply(personId, taskId, opinion, system, id, processInstanceId);
    }

    @Override
    public void failApply(String personId, String taskId, String opinion, Integer system) {
        salesPlanService.failApply(personId, taskId, opinion, system);
    }

    @Override
    public List<ActionRecordVO> getActionRecords(String personId, String processInstanceId) {
        List<ActionRecordDTO> recordDTOS = actionRecordService.getActionRecordsWithNext(personId, processInstanceId);
        return GeneratorUtil.instance().convert(recordDTOS,ActionRecordVO.class);
    }

    @Override
    public SalesPlanDetailViewVO getSalesPlanDetail(String personId, Integer id, String taskId) {
        SalesPlanDetailViewDTO result = salesPlanService.getSalesPlanDetail(personId,id);
        workFlowActionService.setTaskLocalVar(taskId,"readFlag",true);//设置已读
        return GeneratorUtil.instance().convert(result,SalesPlanDetailViewVO.class);
    }

    @Override
    public SalesPlanDetailViewVO getSalesPlanDetail(String personId, Integer id) {
        SalesPlanDetailViewDTO result = salesPlanService.getSalesPlanDetail(personId,id);
        return GeneratorUtil.instance().convert(result,SalesPlanDetailViewVO.class);
    }

    @Override
    public void updateSalesPlanWithAudit(String personId, SalesPlanVO salesPlanVO) {
        SalesPlanDTO salesPlanDTO = GeneratorUtil.instance().convert(salesPlanVO,SalesPlanDTO.class);
        salesPlanService.updateSalesPlanWithAudit(personId,salesPlanDTO);
    }
}
