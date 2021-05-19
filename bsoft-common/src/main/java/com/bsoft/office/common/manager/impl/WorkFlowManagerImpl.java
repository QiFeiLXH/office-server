package com.bsoft.office.common.manager.impl;

import com.bsoft.office.common.dozer.GeneratorUtil;
import com.bsoft.office.common.manager.WorkFlowManager;
import com.bsoft.office.common.vo.ActionRecordVO;
import com.bsoft.workflow.dto.ActionRecordDTO;
import com.bsoft.workflow.service.ActionRecordService;
import com.bsoft.workflow.service.WorkFlowActionService;
import org.apache.dubbo.config.annotation.Reference;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-12-11 17:06
 * @Version 1.0
 */
public class WorkFlowManagerImpl implements WorkFlowManager {
    @Reference
    private ActionRecordService actionRecordService;
    @Reference(timeout = 10000)
    private WorkFlowActionService workFlowActionService;
    @Override
    public void successApply(String personId, String taskId, String opinion, Integer system, Integer id, String processInstanceId) {
    }

    @Override
    public void failApply(String personId, String taskId, String opinion, Integer system) {
    }

    @Override
    public List<ActionRecordVO> getActionRecords(String personId, String processInstanceId) {
        List<ActionRecordDTO> recordDTOS = actionRecordService.getActionRecordsWithNext(personId, processInstanceId);
        return GeneratorUtil.instance().convert(recordDTOS,ActionRecordVO.class);
    }
}
