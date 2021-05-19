package com.bsoft.office.sales.manager.impl;

import com.bsoft.clue.dto.SalesCluesTaskDTO;
import com.bsoft.clue.dto.SalesCluesTaskQueryCndDTO;
import com.bsoft.clue.dto.SalesCluesViewDTO;
import com.bsoft.clue.service.SalesCluesService;
import com.bsoft.common.result.Result;
import com.bsoft.exception.ServiceException;
import com.bsoft.office.common.dozer.GeneratorUtil;
import com.bsoft.office.sales.manager.SalesCluesManager;
import com.bsoft.office.common.vo.ActionRecordVO;
import com.bsoft.office.sales.vo.SalesCluesTaskVO;
import com.bsoft.office.sales.vo.SalesCluesViewVO;
import com.bsoft.office.sales.vo.TaskQueryCndVO;
import com.bsoft.workflow.dto.ActionRecordDTO;
import com.bsoft.workflow.service.ActionRecordService;
import com.bsoft.workflow.service.WorkFlowActionService;
import com.bsoft.workflow.service.WorkFlowQueryService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class SalesCluesManagerImpl implements SalesCluesManager {
    @Reference(timeout = 10000)
    private SalesCluesService salesCluesService;
    @Reference(timeout = 10000)
    private WorkFlowQueryService workFlowQueryService;
    @Reference(timeout = 10000)
    private ActionRecordService actionRecordService;
    @Reference(timeout = 10000)
    private WorkFlowActionService workFlowActionService;

    @Override
    public void submit(String personId,Integer clueId) {
        salesCluesService.submit(personId, clueId);
    }

    @Override
    public void successApply(String personId,String taskId,String opinion,Integer system,Integer clueId,String processInstanceId) {
        salesCluesService.successApply(personId, taskId, opinion, system, clueId, processInstanceId);
    }

    @Override
    public void failApply(String personId,String taskId,String opinion,Integer system) {
        salesCluesService.failApply(personId, taskId, opinion, system);
    }

    @Override
    public void apply(String personId,String taskId, Map<String, Object> map) {
        salesCluesService.apply(personId, taskId, map);
    }

    @Override
    public Result<SalesCluesTaskVO> getTaskList(String personId, TaskQueryCndVO data) {
        try{
            SalesCluesTaskQueryCndDTO queryCndDTO = GeneratorUtil.instance().convert(data, SalesCluesTaskQueryCndDTO.class);
            Result<SalesCluesTaskDTO> result = salesCluesService.getTaskList(personId,queryCndDTO);
            return GeneratorUtil.instance().convert(result, SalesCluesTaskVO.class);
        }catch (ServiceException e){
            throw e;
        }
    }

    @Override
    public SalesCluesViewVO getClue(String personId, Integer clueId) {
        SalesCluesViewDTO salesCluesViewDTO = salesCluesService.getClue(personId,clueId);
        return GeneratorUtil.instance().convert(salesCluesViewDTO,SalesCluesViewVO.class);
    }

    @Override
    public SalesCluesViewVO getClue(String personId, Integer clueId,String taskId) {
        SalesCluesViewDTO salesCluesViewDTO = salesCluesService.getClue(personId,clueId);
        workFlowActionService.setTaskLocalVar(taskId,"readFlag",true);//设置已读
        return GeneratorUtil.instance().convert(salesCluesViewDTO,SalesCluesViewVO.class);
    }

    @Override
    public List<ActionRecordVO> getActionRecords(String personId, String processInstanceId) {
        List<ActionRecordDTO> recordDTOS = actionRecordService.getActionRecordsWithNext(personId, processInstanceId);
//        TaskQueryCndDTO dto = new TaskQueryCndDTO();
//        dto.setProcessInstanceId(processInstanceId);
//        dto.setPageNo(0);//设置分页
//        dto.setPageSize(999);//设置分页大小
//        Result<TaskDTO> result = workFlowQueryService.getTaskList(personId,dto); //获取当前流程待办任务
//        List<TaskDTO> kernelTaskDTOS = result.getItems();
//        Integer i = 0;
//        for(TaskDTO taskDTO : kernelTaskDTOS){ //将流程操作记录 以及 待办任务 结合到一个集合中
//            ActionRecordDTO actionRecord = new ActionRecordDTO();
//            actionRecord.setAction("待审核");
//            actionRecord.setAuditor(taskDTO.getAssigneeName());
//            actionRecord.setTaskName(taskDTO.getTaskName());
//            actionRecord.setId(i);
//            i--;
//            recordDTOS.add(actionRecord);
//        }
        return GeneratorUtil.instance().convert(recordDTOS,ActionRecordVO.class);
    }


}
