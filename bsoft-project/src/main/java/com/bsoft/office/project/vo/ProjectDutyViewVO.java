package com.bsoft.office.project.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/5/12 13:04
 * @Description
 */
@Data
public class ProjectDutyViewVO {
    /** 主键 */
    @OperLogFieldName(value = "id")
    private Integer id;
    /** 责任书名称 */
    @OperLogFieldName(value = "责任书名称")
    private String name;
    /** 考核开始日期 */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "考核开始日期")
    private Date startDate;
    /** 考核结束日期 */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "考核结束日期")
    private Date endDate;
    /** 合同编号 */
    @OperLogFieldName(value = "合同编号")
    private String contractNo;
    /** 客户编码 */
    @OperLogFieldName(value = "客户编码")
    private String customerId;
    /** 客户名称 */
    @OperLogFieldName(value = "客户名称")
    private String customerName;
    /** 人力成本 */
    @OperLogFieldName(value = "人力成本")
    private Double laborCost;
    /** 报销费用 */
    @OperLogFieldName(value = "报销费用")
    private Double reimburse;
    /** 奖金 */
    @OperLogFieldName(value = "奖金")
    private Double bonus;
    /** 预算总成本（万元） */
    @OperLogFieldName(value = "预算总成本")
    private Double budgetTotalCost;
    /** 计划回款（万元） */
    @OperLogFieldName(value = "计划回款")
    private Double expectedBackMoney;
    /** 签订日期 */
    @OperLogFieldName(value = "签订日期")
    private Date signDate;
    /** 签订人 */
    @OperLogFieldName(value = "签订人")
    private String signner;
    @OperLogFieldName(value = "签订人")
    private String signnerName;
    /** 审核标志 */
    @OperLogFieldName(value = "审核标志")
    private Integer auditFlag;
    /** 责任书年度 */
    @OperLogFieldName(value = "责任书年度")
    private Integer year;
    /** 项目计划是否已选择里程碑 0 未选择 1已选择 */
    @OperLogFieldName(value = "是否已选择")
    private Integer milepostSelectedFlag;
    /** 提交标志 0 未提交 1已提交（已提交的数据无法修改） */
    @OperLogFieldName(value = "提交标志")
    private Integer committed;
}
