package com.bsoft.office.project.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Author: zhanglf
 * @CreateTime: 2020-05-21 18:33
 * @Description: 项目责任书审核
 */
@ExcelIgnoreUnannotated
public class ProjectDutyAuditViewVO{
    @OperLogFieldName(value = "id")
    private Integer id;
    /** 责任书名称 */
    @ExcelProperty(value = "责任书名称", index = 0)
    @OperLogFieldName(value = "责任书名称")
    private String name;
    /** 工程区域 */
    @OperLogFieldName(value = "回款业绩部门")
    private String backMoneyDept;
    @ExcelProperty(value = "回款业绩部门", index = 2)
    @OperLogFieldName(value = "id")
    private String backMoneyDeptText;
    /** 一级部门 */
    @OperLogFieldName(value = "一级部门")
    private String largeBackMoneyDept;
    @ExcelProperty(value = "回款业绩一级部门", index = 1)
    @OperLogFieldName(value = "回款业绩一级部门")
    private String largeBackMoneyDeptText;
    /** 项目经理 */
    @OperLogFieldName(value = "项目经理")
    private String projectManager;
    @ExcelProperty(value = "项目经理", index = 6)
    @OperLogFieldName(value = "项目经理")
    private String projectManagerName;
    /** 开始时间 */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "开始时间")
    private Date startDate;
    /** 结束时间 */
    @OperLogFieldName(value = "结束时间")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date endDate;
    /** 签订日期 */
    @OperLogFieldName(value = "签订日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date signDate;
    /** 人力成本 */
    @OperLogFieldName(value = "人力成本")
    private Double laborCost;
    /** 报销费用 */
    @OperLogFieldName(value = "报销费用")
    private Double reimburse;
    /** 奖金 */
    @OperLogFieldName(value = "奖金")
    private Double bonus;
    /** 预算总成本 */
    @OperLogFieldName(value = "预算总成本")
    @ExcelProperty(value = "预算总成本（万元）", index = 3)
    private Double budgetTotalCost;
    /** 计划回款 */
    @OperLogFieldName(value = "计划回款")
    @ExcelProperty(value = "计划回款（万元）", index = 4)
    private Double planBackMoney;
    /** 审核标记 */
    @OperLogFieldName(value = "审核标记")
    private Integer auditFlag;
    @OperLogFieldName(value = "审核标记")
    @ExcelProperty(value = "审核情况", index = 7)
    private String auditFlagText;
    /**年份*/
    @OperLogFieldName(value = "年份")
    @ExcelProperty(value = "年份", index = 5)
    private Integer year;
    /** 客户id */
    @OperLogFieldName(value = "客户id")
    private String customerId;
    /** 客户名称 */
    @OperLogFieldName(value = "客户名称")
    private String customerName;
    /** 是否已提交 */
    @OperLogFieldName(value = "是否已提交")
    private Integer committed;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBackMoneyDept() {
        return backMoneyDept;
    }

    public void setBackMoneyDept(String backMoneyDept) {
        this.backMoneyDept = backMoneyDept;
    }

    public String getBackMoneyDeptText() {
        return backMoneyDeptText;
    }

    public void setBackMoneyDeptText(String backMoneyDeptText) {
        this.backMoneyDeptText = backMoneyDeptText;
    }

    public String getLargeBackMoneyDept() {
        return largeBackMoneyDept;
    }

    public void setLargeBackMoneyDept(String largeBackMoneyDept) {
        this.largeBackMoneyDept = largeBackMoneyDept;
    }

    public String getLargeBackMoneyDeptText() {
        return largeBackMoneyDeptText;
    }

    public void setLargeBackMoneyDeptText(String largeBackMoneyDeptText) {
        this.largeBackMoneyDeptText = largeBackMoneyDeptText;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }

    public String getProjectManagerName() {
        return projectManagerName;
    }

    public void setProjectManagerName(String projectManagerName) {
        this.projectManagerName = projectManagerName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public Double getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(Double laborCost) {
        this.laborCost = laborCost;
    }

    public Double getReimburse() {
        return reimburse;
    }

    public void setReimburse(Double reimburse) {
        this.reimburse = reimburse;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    public Double getBudgetTotalCost() {
        return budgetTotalCost;
    }

    public void setBudgetTotalCost(Double budgetTotalCost) {
        this.budgetTotalCost = budgetTotalCost;
    }

    public Double getPlanBackMoney() {
        return planBackMoney;
    }

    public void setPlanBackMoney(Double planBackMoney) {
        this.planBackMoney = planBackMoney;
    }

    public Integer getAuditFlag() {
        return auditFlag;
    }

    public void setAuditFlag(Integer auditFlag) {
        this.auditFlag = auditFlag;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAuditFlagText() {
        return auditFlagText;
    }

    public void setAuditFlagText(String auditFlagText) {
        this.auditFlagText = auditFlagText;
    }

    public Integer getCommitted() {
        return committed;
    }

    public void setCommitted(Integer committed) {
        this.committed = committed;
    }
}
