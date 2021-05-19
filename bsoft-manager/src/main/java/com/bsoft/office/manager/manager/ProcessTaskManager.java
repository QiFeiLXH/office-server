package com.bsoft.office.manager.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.manager.condition.ProcessTaskQueryCnd;
import com.bsoft.office.manager.vo.*;

import java.util.List;

/**
 * @author: zy
 * @date: 2020/9/22
 * @description 流程待办任务
 */
public interface ProcessTaskManager {
    Result<ProcessTaskVO> getTaskList(String userId, ProcessTaskQueryCnd queryCnd);
    List<ProcessTaskCountVO> getTaskCount(String userId);
    List<ProcessTypeTreeVO> getProcessTree(String userId);
    List<ActionRecordVO> getActionRecordList(String userId, String processInstanceId);

    /**
     * 终止任务
     * @param userId 操作人
     * @param processKey 流程定义KEY
     * @param processInstanceId 流程实例ID
     * @param reason 终止原因
     */
    void stop(String userId, String processKey, String processInstanceId, String reason);

    /**
     * 完成知会
     * @param userId 操作员工
     * @param taskId 任务ID
     */
    void completeNotifyTask(String userId, String taskId);

    SalesCluesViewVO getSalesClueInfo(String userId, Integer id);
    SalesPlanViewVO getSalesPlanInfo(String userId, Integer id);
    LaborContractApplyViewVO getLaborContractInfo(String userId, Integer id);

}
