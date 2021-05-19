package com.bsoft.office.hr.manager;

import com.bsoft.common.result.Result;
import com.bsoft.hr.dto.LaborContractApplyViewDTO;
import com.bsoft.office.common.vo.ActionRecordVO;
import com.bsoft.office.common.vo.CustomerParamVO;
import com.bsoft.office.hr.condition.LaborContractProcessTaskQueryCnd;
import com.bsoft.office.hr.condition.LaborContractQueryCnd;
import com.bsoft.office.hr.vo.*;
import com.bsoft.office.common.vo.TaskAuditVO;
import com.bsoft.office.hr.vo.LaborContractApplyVO;
import com.bsoft.office.hr.vo.LaborContractApplyViewVO;
import com.bsoft.office.hr.vo.TaskQueryCndVO;
import com.bsoft.workflow.dto.ActionRecordDTO;
import com.bsoft.office.hr.vo.LaborContractApplyVO;
import com.bsoft.office.hr.vo.LaborContractApplyViewVO;
import com.bsoft.office.hr.vo.LaborContractQuitViewVO;
import com.bsoft.office.hr.vo.TaskQueryCndVO;
import com.bsoft.workflow.dto.ActionRecordDTO;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-12-08 16:21
 * @Version 1.0
 */
public interface LaborContractRenewalManager {

    /**
     * 根据条件获取待审核劳动续签合同
     * @return
     */
    Result<LaborContractApplyViewVO> getLaborContractAuditList(String personId,TaskQueryCndVO cnd);

    /**
     * 部门审核人处理
     * @param laborContractApply
     */
    void deptAudit(String personId, LaborContractApplyVO laborContractApply, TaskAuditVO taskAuditVO);

    /**
     * 大区行政总监处理
     */
    void areaAudit(String personId, LaborContractApplyVO laborContractApply, TaskAuditVO taskAuditVO);

    /**
     * 人事审核
     * flag分为两种情况 1.为有大区行政总监 人事专员只需人事审核
     * 2.为无大区行政总监 人事专员需处理与大区行政总监相同业务
     * @param flag
     * @param laborContractApply
     */
    void hrAudit(Integer flag, String personId, LaborContractApplyVO laborContractApply, TaskAuditVO taskAuditVO);

    /**
     * 获取任务节点自定义节点属性
     * @param taskId 任务ID
     * @return
     */
    List<CustomerParamVO> getCustomParam(String personId, String taskId);

    /**
     * 获取劳动合同续签流程任务列表
     * @param personId 操作人工号
     * @param queryCnd 查询参数
     * @return
     */
    Result<LaborContractProcessTaskVO> getProcessTaskList(String personId, LaborContractProcessTaskQueryCnd queryCnd);

    /**
     * 获取劳动合同信息
     * @param personId 操作人工号
     * @param queryCnd 查询参数
     * @return
     */
    Result<LaborContractViewVO> getLaborContractList(String personId, LaborContractQueryCnd queryCnd);

    /**
     * 获取流程操作记录
     * @param personId
     * @param processInstanceId
     * @return
     */
    List<ActionRecordVO> getActionRecords(String personId, String processInstanceId);

    /**
     * 获取劳动续签合同详情
     * @param personId
     * @param id
     * @return
     */
    LaborContractApplyViewVO getLaborContractApplyView(String personId,Integer id);

    /**
     * 根据工号获取离职单
     * @param personId
     * @return
     */
    List<LaborContractQuitViewVO> getQuitList(String personId);


    /**
     * 获取员工个人劳动合同申请列表
     * @param userId 操作工号
     * @param personId 用于查询的工号
     * @return
     */
    List<LaborContractApplyViewVO> getPersonalLaborContractApplyViewList(String userId, String personId);

    /**
     * 完成知会
     * @param user
     * @param taskId
     */
    void completeNotifyTask(String user, String taskId);

    /**
     * 获取劳动合同详情
     * @param userId
     * @param personId
     * @return
     */
    List<LaborContractDetailViewVO> getLaborContractDetail(String userId, String personId);
}
