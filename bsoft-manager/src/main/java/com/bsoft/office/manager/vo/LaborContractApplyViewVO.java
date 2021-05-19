package com.bsoft.office.manager.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Author zhanglf
 * @Date 2020-12-08 15:51
 * @Version 1.0
 * 劳动合同续签申请视图
 */
@Data
public class LaborContractApplyViewVO {
    private Integer id;//主键
    private String personId;//工号
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date renewalStartDate;//劳动合同续签开始日期
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date renewalEndDate;//劳动合同续签结束日期
    private String remark;//备注
    private Integer areaAudit;//大区审核
    private String areaAuditor;//大区审核人
    private String areaAuditorName;//大区审核人姓名
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date areaAuditDate;//大区审核日期
    private Integer hrAudit;//人事审核
    private String hrAuditor;//人事审核人
    private String hrAuditorName;//人事审核人姓名
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date hrAuditDate;//人事审核日期
    private String hrOpinion;//人事审核意见
    private Integer deptAudit;//部门审核标志 1.同意 2.不同意
    private String deptAuditor;//部门审核人
    private String deptAuditorName;//部门审核人姓名
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date deptAuditDate;//部门审核日期
    private String deptOpinion;//部门审核人意见
    private String personName;//姓名
    private Integer signUnit;//签订单位
    private String signUnitName;//签订单位
    private String post;//岗位
    private String dept;//部门
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date inDate;//入职时间
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date endDate;//劳动合同到期时间
    private String evaluationGrade;//年度绩效
    private String sequence;//岗位序列
    private String specialRank;//评定职级
    private String processInstanceId;//流程实例id
    private Integer status;//审核状态 1.审核中 2.已审核
    private Integer renewalYear;//续签年限
    private Integer quitApplyId;//离职申请单
    private String taskId;//任务id
    private Boolean readFlag;//是否已读
    private String taskDefineKey;//任务节点key
    /** 是否是知会*/
    private Integer notifyFlag;
    /** 经办人*/
    private String dealPerson;
    /** 经办人姓名*/
    private String dealPersonName;
    /** 经办时间*/
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private String dealDate;
}
