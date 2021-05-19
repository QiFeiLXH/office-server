package com.bsoft.office.hr.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author zhanglf
 * @Date 2020-12-08 16:49
 * @Version 1.0
 * 劳动合同申请
 */
@Data
public class LaborContractApplyVO{
    @OperLogFieldName(value = "ID")
    private Integer id;//主键

    @OperLogFieldName(value = "工号")
    private String personId;//工号

    @OperLogFieldName(value = "劳动合同续签开始日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date renewalStartDate;//劳动合同续签开始日期

    @OperLogFieldName(value = "劳动合同续签结束日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date renewalEndDate;//劳动合同续签结束日期

    @OperLogFieldName(value = "备注")
    private String remark;//备注

    @OperLogFieldName(value = "大区审核")
    private Integer areaAudit;//大区审核

    @OperLogFieldName(value = "大区审核人")
    private String areaAuditor;//大区审核人

    @OperLogFieldName(value = "大区审核日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date areaAuditDate;//大区审核日期

    @OperLogFieldName(value = "人事审核")
    private Integer hrAudit;//人事审核

    @OperLogFieldName(value = "人事审核人")
    private String hrAuditor;//人事审核人

    @OperLogFieldName(value = "人事审核日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date hrAuditDate;//人事审核日期

    @OperLogFieldName(value = "人事审核意见")
    private String hrOpinion;//人事审核意见

    @OperLogFieldName(value = "部门审核标志")
    private Integer deptAudit;//部门审核标志 1.同意 2.不同意

    @OperLogFieldName(value = "部门审核人")
    private String deptAuditor;//部门审核人

    @OperLogFieldName(value = "部门审核日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date deptAuditDate;//部门审核日期

    @OperLogFieldName(value = "部门审核人意见")
    private String deptOpinion;//部门审核人意见

    @OperLogFieldName(value = "签订单位")
    private Integer signUnit;//签订单位

    @OperLogFieldName(value = "岗位")
    private String post;//岗位

    @OperLogFieldName(value = "部门")
    private String dept;//部门

    @OperLogFieldName(value = "入职时间")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date inDate;//入职时间

    @OperLogFieldName(value = "劳动合同到期时间")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date endDate;//劳动合同到期时间

    @OperLogFieldName(value = "年度绩效")
    private String evaluationGrade;//年度绩效

    @OperLogFieldName(value = "岗位序列")
    private String sequence;//岗位序列

    @OperLogFieldName(value = "评定职级")
    private String specialRank;//评定职级

    @OperLogFieldName(value = "流程实例id")
    private String processInstanceId;//流程实例id

    @OperLogFieldName(value = "审核状态")
    private Integer status;//审核状态 1.审核中 2.已审核

    @OperLogFieldName(value = "续签年限")
    private Integer renewalYear;//续签年限

    @OperLogFieldName(value = "离职申请单")
    private Integer quitApplyId;//离职申请单

    @OperLogFieldName(value = "首续签标志")
    private Integer renewalFlag;//首续签标志

    @OperLogFieldName(value = "经办人")
    private String dealPerson;//经办人

    @OperLogFieldName(value = "经办人办理日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date dealDate;//经办人办理日期

    @OperLogFieldName(value = "有无大区行政总监")
    private Integer flag;//人事审核分为两种情况 1.为有大区行政总监 人事专员只需人事审核* 2.为无大区行政总监 人事专员需处理与大区行政总监相同业务

    @OperLogFieldName(value = "任务定义key")
    private String taskDefineKey;//任务定义key 用于判断处于哪个节点

    @OperLogFieldName(value = "知会标志")
    private Integer notifyFlag;//知会标志0.正常待办任务 1.知会任务

}
