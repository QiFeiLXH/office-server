package com.bsoft.office.work.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/12/30 14:53
 * @Description
 */
@ExcelIgnoreUnannotated
public class ExpressDetailViewVO {
    private Integer id;
    /** 快递单号 */
    @ColumnWidth(25)
    @ExcelProperty(value = "快递单号", index = 0)
    @OperLogFieldName(value = "快递单号")
    private String expressNo;
    /** 申请人 */
    @OperLogFieldName(value = "申请人")
    private String applicant;
    @ColumnWidth(25)
    @ExcelProperty(value = "申请人", index = 1)
    @OperLogFieldName(value = "申请人")
    private String applicantName;
    /** 部门id */
    @OperLogFieldName(value = "部门id")
    private String deptId;
    @ColumnWidth(30)
    @ExcelProperty(value = "部门", index = 3)
    @OperLogFieldName(value = "部门")
    private String deptName;
    /** 申请日期 */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat("yyyy-MM-dd")
    @ColumnWidth(25)
    @ExcelProperty(value = "申请日期", index = 2)
    @OperLogFieldName(value = "申请日期")
    private Date applyDate;
    /** 金额 */
    @ColumnWidth(15)
    @ExcelProperty(value = "金额", index = 4)
    @OperLogFieldName(value = "金额")
    private Double amount;
    /** 核准金额 */
    @ColumnWidth(15)
    @ExcelProperty(value = "核准金额", index = 5)
    @OperLogFieldName(value = "核准金额")
    private Double approval;
    /** 流水号id */
    @ColumnWidth(25)
    @ExcelProperty(value = "流水号", index = 6)
    @OperLogFieldName(value = "流水号id")
    private String lshid;
    /** 状态 */
    @OperLogFieldName(value = "状态")
    private Integer status;
    @ColumnWidth(25)
    @ExcelProperty(value = "状态", index = 7)
    @OperLogFieldName(value = "状态")
    private String statusText;
    /** 归属人 */
    @OperLogFieldName(value = "归属人")
    private String belonger;
    @OperLogFieldName(value = "归属人")
    private String belongerName;
    /** 归属部门 */
    @OperLogFieldName(value = "归属部门")
    private String belongDept;
    @OperLogFieldName(value = "归属部门")
    private String belongDeptName;
    /** 项目id */
    @OperLogFieldName(value = "项目id")
    private String projectId;
    @OperLogFieldName(value = "项目id")
    private String projectName;
    /** 费用类别 */
    @OperLogFieldName(value = "费用类别")
    private Integer costType;
    @OperLogFieldName(value = "费用类别")
    private String costTypeText;
    /** 核算口径 */
    @OperLogFieldName(value = "核算口径")
    private Integer accountCaliber;
    @OperLogFieldName(value = "核算口径")
    private String accountCaliberText;
    /** 申领理由 */
    @OperLogFieldName(value = "申领理由")
    private String reason;
    /** 快递内容 */
    @OperLogFieldName(value = "快递内容")
    private String context;
    /** 收件人 */
    @OperLogFieldName(value = "收件人")
    private String recipient;
    /** 收件地区 */
    @OperLogFieldName(value = "收件地区")
    private String area;
    /** 收件地址 */
    @OperLogFieldName(value = "收件地址")
    private String address;
    /** 重量 */
    @OperLogFieldName(value = "重量")
    private String weight;
    /** 寄件日期 */
    @OperLogFieldName(value = "寄件日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date shipmentDate;
    /** 申请支付日期 */
    @DateTimeFormat("yyyy-MM-dd")
    @ColumnWidth(25)
    @ExcelProperty(value = "申请支付日期", index = 8)
    @OperLogFieldName(value = "申请支付日期")
    private Date applyPayDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExpressNo() {
        return expressNo;
    }

    public void setExpressNo(String expressNo) {
        this.expressNo = expressNo;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public Double getApproval() {
        return approval;
    }

    public void setApproval(Double approval) {
        this.approval = approval;
    }

    public String getLshid() {
        return lshid;
    }

    public void setLshid(String lshid) {
        this.lshid = lshid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getBelonger() {
        return belonger;
    }

    public void setBelonger(String belonger) {
        this.belonger = belonger;
    }

    public String getBelongerName() {
        return belongerName;
    }

    public void setBelongerName(String belongerName) {
        this.belongerName = belongerName;
    }

    public String getBelongDept() {
        return belongDept;
    }

    public void setBelongDept(String belongDept) {
        this.belongDept = belongDept;
    }

    public String getBelongDeptName() {
        return belongDeptName;
    }

    public void setBelongDeptName(String belongDeptName) {
        this.belongDeptName = belongDeptName;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Integer getCostType() {
        return costType;
    }

    public void setCostType(Integer costType) {
        this.costType = costType;
    }

    public String getCostTypeText() {
        return costTypeText;
    }

    public void setCostTypeText(String costTypeText) {
        this.costTypeText = costTypeText;
    }

    public Integer getAccountCaliber() {
        return accountCaliber;
    }

    public void setAccountCaliber(Integer accountCaliber) {
        this.accountCaliber = accountCaliber;
    }

    public String getAccountCaliberText() {
        return accountCaliberText;
    }

    public void setAccountCaliberText(String accountCaliberText) {
        this.accountCaliberText = accountCaliberText;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Date getShipmentDate() {
        return shipmentDate;
    }

    public void setShipmentDate(Date shipmentDate) {
        this.shipmentDate = shipmentDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public Date getApplyPayDate() {
        return applyPayDate;
    }

    public void setApplyPayDate(Date applyPayDate) {
        this.applyPayDate = applyPayDate;
    }
}
