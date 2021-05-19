package com.bsoft.office.sales.vo;

import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author: zy
 * @date: 2020/11/20
 * @description 销售计划汇总
 */
@Data
public class SalesPlanReportVO {

    /** 主键*/
    @OperLogFieldName(value = "ID")
    private Integer id;

    /** 客户编码*/
    @OperLogFieldName(value = "客户编码")
    private String customer;

    /** 计划月份*/
    @JsonFormat(pattern = "yyyy-MM", timezone = "GMT+8")
    @DateTimeFormat("yyyy-MM")
    @OperLogFieldName(value = "计划月份")
    private Date planDate;

    /** 客户名称*/
    @OperLogFieldName(value = "客户名称")
    private String customerName;

    /** 产品内容 项目内容*/
    @OperLogFieldName(value = "产品内容")
    private String content;

    /** 业务归属*/
    @OperLogFieldName(value = "业务归属")
    private String businessBelong;

    /** 线索性质*/
    @OperLogFieldName(value = "线索性质")
    private String cluesNature;

    /** 跟单人*/
    @OperLogFieldName(value = "跟单人")
    private String trackPerson;

    /** 跟单人姓名*/
    @OperLogFieldName(value = "跟单人姓名")
    private String trackPersonName;

    /** 跟单部门*/
    @OperLogFieldName(value = "跟单部门")
    private String trackDept;

    /** 跟单部门名称*/
    @OperLogFieldName(value = "跟单部门名称")
    private String trackDeptName;

    /** 一级部门编号*/
    @OperLogFieldName(value = "一级部门编号")
    private String parentDept;

    /** 一级部门名称*/
    @OperLogFieldName(value = "一级部门名称")
    private String parentDeptName;

    /** 跟单日期*/
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat("yyyy-MM-dd")
    @OperLogFieldName(value = "跟单日期")
    private Date trackDate;

    /** 最新进展（跟单情况）*/
    @OperLogFieldName(value = "最新进展")
    private String latestDevelopment;

    /** 线索来源*/
    @OperLogFieldName(value = "线索来源")
    private String cluesSource;

    /** 项目阶段*/
    @OperLogFieldName(value = "项目阶段")
    private String stage;

    /** 销售阶段*/
    @OperLogFieldName(value = "销售阶段")
    private String salesStage;

    /** 预计软件额*/
    @OperLogFieldName(value = "预计软件额")
    private Double estimateSoftware;

    /** 预计首款额*/
    @OperLogFieldName(value = "预计首款额")
    private Double estimateFirstAmount;

    /** 预计硬件额*/
    @OperLogFieldName(value = "预计硬件额")
    private Double estimateHardware;

    /** 预计净销售额软件*/
    @OperLogFieldName(value = "预计净销售额软件")
    private Double estimateNetSales;

    /** 预计系统软件额*/
    @OperLogFieldName(value = "预计系统软件额")
    private Double estimateSysSoftware;

    /** 预计签约时间*/
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat("yyyy-MM-dd")
    @OperLogFieldName(value = "预计签约时间")
    private Date signDate;

    /** 预计月份*/
    @OperLogFieldName(value = "预计月份")
    private String estimateMonth;

    /** 签约概率*/
    @OperLogFieldName(value = "签约概率")
    private Double signProbability;

    /** 计划来源*/
    @OperLogFieldName(value = "计划来源")
    private String planSource;

    /** 开标时间*/
    @OperLogFieldName(value = "开标时间")
    private String openingDate;

    /** 上报日期*/
    @OperLogFieldName(value = "上报日期")
    private Date reportDate;

    /** 状态 1.审核中 2.已审核*/
    @OperLogFieldName(value = "状态")
    private Integer status;

    /** 线索编号*/
    @OperLogFieldName(value = "线索编号")
    private Integer clueId;

    /** 流程实例id*/
    @OperLogFieldName(value = "流程实例id")
    private String processInstanceId;
}
