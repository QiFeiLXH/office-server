package com.bsoft.office.sales.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.vo.ActionRecordVO;
import com.bsoft.office.sales.condition.SalesPlanQueryCndVO;
import com.bsoft.office.sales.vo.*;

import java.util.List;

public interface SalesPlanManager {
    /**
     * 根据条件获取销售计划列表
     * @param personId
     * @param cnd
     * @return
     */
    Result<SalesPlanVO> getSalesPlan(String personId, SalesPlanQueryCndVO cnd);

    /**
     * 跟单人是本人的销售线索，已立项且未关闭的。计划签约日期在今年或以后的。
     * @param personId
     * @return
     */
    List<SalesCluesViewVO> getClues(String personId);

    /**
     * 批量保存销售计划，并发起对应审核流程
     * @param list
     */
    void save(String personId,List<SalesPlanVO> list);

    /**
     * 根据查询条件查询出对应的销售计划的总金额
     * @param cnd
     * @return
     */
    SalesPlanAmountVO getSalesPlanAmount(String personId, SalesPlanQueryCndVO cnd);

    /**
     * 根据查询条件查询出对应的销售计划待办列表的总金额
     * @param cnd
     * @return
     */
    SalesPlanAmountVO getSalesPlanAmountWithAudit(String personId, TaskQueryCndVO cnd);

    /**
     * 根据年份获取当年有数据的月份
     * @param year
     * @return
     */
    List<String> getReportMonthWithYear(String personId,String year);

    /**
     * 根据当前登录人查询出待办任务中的 所有跟单人
     * @return
     */
    List<SalesPlanPersonVO> getTrackPersonsByAuditor(String personId,TaskQueryCndVO cnd);

    /**
     * 根据当前登录人查询出待办任务中的 所有跟单部门
     * @return
     */
    List<SalesPlanDeptVO> getTrackDeptsByAuditor(String personId,TaskQueryCndVO cnd);

    /**
     * 根据条件获取待审核计划列表
     * @return
     */
    Result<SalesPlanViewVO> getSalesPlanAuditList(String personId,TaskQueryCndVO cnd);

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

    /**
     * 根据Id获取计划 并设置已读
     * @param personId
     * @param id
     * @param taskId 任务id
     * @return
     */
    SalesPlanDetailViewVO getSalesPlanDetail(String personId,Integer id,String taskId);

    /**
     * 根据Id获取计划
     * @param personId
     * @param id
     * @return
     */
    SalesPlanDetailViewVO getSalesPlanDetail(String personId,Integer id);


    /**
     * 审核计划时修改 对应信息
     * @param salesPlanVO
     */
    void updateSalesPlanWithAudit(String personId, SalesPlanVO salesPlanVO);

}
