package com.bsoft.office.sales.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.vo.ActionRecordVO;
import com.bsoft.office.sales.vo.*;

import java.util.List;
import java.util.Map;

public interface SalesCluesManager {
    /**
     * 提交
     *
     * @param clueId           线索编号
     */
    void submit(String personId,Integer clueId);

    /**
     * 通过-审核
     *
     * @param taskId        待办任务ID
     */
    void successApply(String personId,String taskId,String opinion,Integer system,Integer clueId,String processInstanceId);

    /**
     * 拒绝-审核
     *
     * @param taskId 待办任务ID
     */
    void failApply(String personId,String taskId,String opinion,Integer system);

    /**
     * 申请处理方法
     *
     * @param taskId 待办任务ID
     * @param map    变量组
     */
    void apply(String personId,String taskId, Map<String, Object> map);

    /**
     * 获取销售线索 待办信息
     * @param data 查询条件
     * @param personId 查询人员工号
     * @return
     */
    Result<SalesCluesTaskVO> getTaskList(String personId, TaskQueryCndVO data);

    /**
     * 根据线索编号获取销售线索
     * @param personId
     * @param clueId
     * @param taskId 任务id
     * @return
     */
    SalesCluesViewVO getClue(String personId,Integer clueId,String taskId);

    /**
     * 根据线索编号获取销售线索
     * @param personId
     * @param clueId
     * @return
     */
    SalesCluesViewVO getClue(String personId,Integer clueId);

    /**
     * 根据流程实例ID获取流程操作信息
     * @param personId 工号
     * @param processInstanceId 流程实例ID
     * @return
     */
    List<ActionRecordVO> getActionRecords(String personId, String processInstanceId);
}
