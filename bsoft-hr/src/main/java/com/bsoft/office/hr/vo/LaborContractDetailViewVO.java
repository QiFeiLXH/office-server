package com.bsoft.office.hr.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @version 1.0
 * @author: zy
 * @date: 2020/12/24
 * @description
 */
@Data
public class LaborContractDetailViewVO {
    /** 主键*/
    @OperLogFieldName(value = "ID")
    private Integer id;
    /** 工号*/
    @OperLogFieldName(value = "工号")
    private String personId;
    /** 姓名*/
    @OperLogFieldName(value = "姓名")
    private String personName;

    /**首续签标志0首签1续签*/
    @OperLogFieldName(value = "首续签标志")
    private Integer renewalFlag;
    /**试用开始日期*/
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "试用开始日期")
    private Date trialStartDate;
    /**试用结束日期*/
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "试用结束日期")
    private Date trialEndDate;
    /** 续签年限*/
    @OperLogFieldName(value = "续签年限")
    private Integer renewalYear;
    /** 劳动合同续签开始日期*/
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "劳动合同续签开始日期")
    private Date renewalStartDate;
    /** 劳动合同续签结束日期*/
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "劳动合同续签结束日期")
    private Date renewalEndDate;

    /** 部门审核标志 1.同意 2.不同意*/
    @OperLogFieldName(value = "部门审核标志")
    private Integer deptAudit;
    /** 部门审核人*/
    @OperLogFieldName(value = "部门审核人工号")
    private String deptAuditor;
    /** 部门审核人*/
    @OperLogFieldName(value = "部门审核人姓名")
    private String deptAuditorName;
    /** 部门审核日期*/
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "部门审核日期")
    private Date deptAuditDate;
    /** 部门审核人意见*/
    @OperLogFieldName(value = "部门审核人意见")
    private String deptOpinion;

    /** 签订单位*/
    @OperLogFieldName(value = "签订单位")
    private String signUnit;
    /** 签订单位*/
    @OperLogFieldName(value = "签订单位名称")
    private String signUnitName;
    /** 经办人*/
    @OperLogFieldName(value = "经办人工号")
    private String dealPerson;
    /** 经办人姓名*/
    @OperLogFieldName(value = "经办人姓名")
    private String dealPersonName;
    /** 经办时间*/
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "经办时间")
    private Date dealDate;
    /** 备注*/
    @OperLogFieldName(value = "备注")
    private String remark;

    /** 人事审核*/
    @OperLogFieldName(value = "人事审核标志")
    private Integer hrAudit;
    /** 人事审核人*/
    @OperLogFieldName(value = "人事审核人工号")
    private String hrAuditor;
    /** 人事审核人*/
    @OperLogFieldName(value = "人事审核人姓名")
    private String hrAuditorName;
    /** 人事审核日期*/
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "人事审核日期")
    private Date hrAuditDate;
    /** 人事审核意见*/
    @OperLogFieldName(value = "人事审核意见")
    private String hrOpinion;
}
