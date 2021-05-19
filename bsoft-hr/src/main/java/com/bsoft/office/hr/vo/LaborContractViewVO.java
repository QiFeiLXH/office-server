package com.bsoft.office.hr.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @version 1.0
 * @author: zy
 * @date: 2020/12/15
 * @description 劳动合同信息
 */
@Data
public class LaborContractViewVO {
    /** 主键*/
    @OperLogFieldName(value = "ID")
    private Integer id;
    /** 工号*/
    @OperLogFieldName(value = "工号")
    private String personId;
    /** 姓名*/
    @OperLogFieldName(value = "姓名")
    private String personName;
    /** 部门*/
    @OperLogFieldName(value = "部门")
    private String dept;
    /** 部门名称*/
    @OperLogFieldName(value = "部门名称")
    private String deptName;
    /** 岗位*/
    @OperLogFieldName(value = "岗位")
    private String post;
    /** 岗位名称*/
    @OperLogFieldName(value = "岗位名称")
    private String postName;
    /** 入职时间*/
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "入职时间")
    private Date inDate;
    /** 到期时间*/
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "到期时间")
    private Date endDate;
    /** 年度绩效*/
    @OperLogFieldName(value = "年度绩效")
    private String evaluationGrade;
    /** 岗位序列*/
    @OperLogFieldName(value = "岗位序列")
    private String sequence;
    /** 岗位序列名称*/
    @OperLogFieldName(value = "岗位序列名称")
    private String sequenceName;
    /** 评定职级*/
    @OperLogFieldName(value = "评定职级")
    private Integer specialRank;
    /** 评定职级名称*/
    @OperLogFieldName(value = "评定职级名称")
    private String specialRankName;

    /** 劳动合同续签开始日期*/
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "劳动合同续签开始日期")
    private Date renewalStartDate;
    /** 劳动合同续签结束日期*/
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "劳动合同续签结束日期")
    private Date renewalEndDate;
    /** 签订单位*/
    @OperLogFieldName(value = "签订单位")
    private Integer signUnit;
    /** 签订单位*/
    @OperLogFieldName(value = "签订单位名称")
    private String signUnitName;
    /** 经办人*/
    @OperLogFieldName(value = "经办人工号")
    private String dealPerson;
    /** 经办人姓名*/
    @OperLogFieldName(value = "经办人姓名")
    private String dealPersonName;

    /** 首续签标志*/
    @OperLogFieldName(value = "首续签标志")
    private Integer renewalFlag;
    /** 离职标志'0'未离职'1'已离职*/
    @OperLogFieldName(value = "离职标志")
    private String flag;
}
