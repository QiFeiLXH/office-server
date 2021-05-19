package com.bsoft.office.common.manager;

import com.bsoft.office.common.vo.ActionRecordVO;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-12-11 17:05
 * @Version 1.0
 */
public interface WorkFlowManager {
    /**
     * 通过-审核
     *
     * @param taskId        待办任务ID
     */
    void successApply(String personId,String taskId,String opinion,Integer system, Integer id, String processInstanceId);

    /**
     * 拒绝-审核
     *
     * @param taskId 待办任务ID
     */
    void failApply(String personId,String taskId,String opinion,Integer system);
    /**
     * 根据流程实例ID获取流程操作信息
     * @param personId 工号
     * @param processInstanceId 流程实例ID
     * @return
     */
    List<ActionRecordVO> getActionRecords(String personId, String processInstanceId);
}
