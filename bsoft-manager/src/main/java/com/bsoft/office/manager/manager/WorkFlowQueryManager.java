package com.bsoft.office.manager.manager;


import com.bsoft.office.manager.vo.BpmnModelVO;

public interface WorkFlowQueryManager {
    /**
     * 根据流程实例ID获取流程流转信息
     * @param processInstanceId
     * @return
     */
    BpmnModelVO getBpmnModelMessage(String processInstanceId,String personId);
}
