package com.bsoft.office.manager.manager.impl;

import com.bsoft.office.common.dozer.GeneratorUtil;
import com.bsoft.office.manager.manager.WorkFlowQueryManager;
import com.bsoft.office.manager.vo.BpmnModelVO;
import com.bsoft.workflow.dto.BpmnModelDTO;
import com.bsoft.workflow.service.WorkFlowQueryService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

@Component
public class WorkFlowQueryManagerImpl implements WorkFlowQueryManager {
    @Reference
    private WorkFlowQueryService workFlowQueryService;
    @Override
    public BpmnModelVO getBpmnModelMessage(String processInstanceId,String personId) {
        BpmnModelDTO bpmnModelDTO = workFlowQueryService.getBpmnModelMessage(processInstanceId,personId);
        return GeneratorUtil.instance().convert(bpmnModelDTO,BpmnModelVO.class);
    }
}
