package com.bsoft.office.sales.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2020/10/10 17:27
 * @Description:
 */
public class SalesCommisViewVO {
    @OperLogFieldName(value = "ID")
    private Integer id;
    @OperLogFieldName(value = "合同编号")
    private String htbh;
    @OperLogFieldName(value = "合同编号")
    private String contractNo;
    @OperLogFieldName(value = "合同名称")
    private String contractName;
    @OperLogFieldName(value = "销售人员")
    private String salesMan;
    @OperLogFieldName(value = "销售人员姓名")
    private String salesManText;
    @OperLogFieldName(value = "归属部门")
    private String departMent;
    @OperLogFieldName(value = "归属部门名称")
    private String departMentText;
    @OperLogFieldName(value = "有效合同额")
    private Double contractAmount;
    @OperLogFieldName(value = "提成有效期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date expiryDate;
    @OperLogFieldName(value = "登记人员")
    private String registrant;
    @OperLogFieldName(value = "登记人员姓名")
    private String registrantText;
    @OperLogFieldName(value = "登记日期")
    private Date registrantDate;
    @OperLogFieldName(value = "备注说明")
    private String remarks;
    @OperLogFieldName(value = "可提成总额")
    private Double totalRoyalty;
    @OperLogFieldName(value = "销售费用")
    private Double sellingExpenses;
    @OperLogFieldName(value = "提奖标志")
    private Integer commissionValidFlag;
    @OperLogFieldName(value = "回款有效")
    private Integer paymentValid;
    @OperLogFieldName(value = "已提总额")
    private Double totalCommission;
    @OperLogFieldName(value = "业绩分配标志")
    private Integer distributionFlag;
    @OperLogFieldName(value = "审核标志")
    private Integer auditFlag;
    @OperLogFieldName(value = "审核人员")
    private String auditor;
    @OperLogFieldName(value = "审核人员姓名")
    private String auditorText;
    @OperLogFieldName(value = "审核日期")
    private Date auditDate;
    @OperLogFieldName(value = "核算口径归属")
    private Integer accountingCaliber;
    @OperLogFieldName(value = "核算口径归属名称")
    private String accountingCaliberText;
    @OperLogFieldName(value = "已提奖标志")
    private Integer awardMark;

    public Integer getAwardMark() {
        return awardMark;
    }

    public void setAwardMark(Integer awardMark) {
        this.awardMark = awardMark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHtbh() {
        return htbh;
    }

    public void setHtbh(String htbh) {
        this.htbh = htbh;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getSalesMan() {
        return salesMan;
    }

    public void setSalesMan(String salesMan) {
        this.salesMan = salesMan;
    }

    public String getSalesManText() {
        return salesManText;
    }

    public void setSalesManText(String salesManText) {
        this.salesManText = salesManText;
    }

    public String getDepartMent() {
        return departMent;
    }

    public void setDepartMent(String departMent) {
        this.departMent = departMent;
    }

    public String getDepartMentText() {
        return departMentText;
    }

    public void setDepartMentText(String departMentText) {
        this.departMentText = departMentText;
    }

    public Double getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(Double contractAmount) {
        this.contractAmount = contractAmount;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getRegistrant() {
        return registrant;
    }

    public void setRegistrant(String registrant) {
        this.registrant = registrant;
    }

    public String getRegistrantText() {
        return registrantText;
    }

    public void setRegistrantText(String registrantText) {
        this.registrantText = registrantText;
    }

    public Date getRegistrantDate() {
        return registrantDate;
    }

    public void setRegistrantDate(Date registrantDate) {
        this.registrantDate = registrantDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Double getTotalRoyalty() {
        return totalRoyalty;
    }

    public void setTotalRoyalty(Double totalRoyalty) {
        this.totalRoyalty = totalRoyalty;
    }

    public Double getSellingExpenses() {
        return sellingExpenses;
    }

    public void setSellingExpenses(Double sellingExpenses) {
        this.sellingExpenses = sellingExpenses;
    }

    public Integer getCommissionValidFlag() {
        return commissionValidFlag;
    }

    public void setCommissionValidFlag(Integer commissionValidFlag) {
        this.commissionValidFlag = commissionValidFlag;
    }

    public Integer getPaymentValid() {
        return paymentValid;
    }

    public void setPaymentValid(Integer paymentValid) {
        this.paymentValid = paymentValid;
    }

    public Double getTotalCommission() {
        return totalCommission;
    }

    public void setTotalCommission(Double totalCommission) {
        this.totalCommission = totalCommission;
    }

    public Integer getDistributionFlag() {
        return distributionFlag;
    }

    public void setDistributionFlag(Integer distributionFlag) {
        this.distributionFlag = distributionFlag;
    }

    public Integer getAuditFlag() {
        return auditFlag;
    }

    public void setAuditFlag(Integer auditFlag) {
        this.auditFlag = auditFlag;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public String getAuditorText() {
        return auditorText;
    }

    public void setAuditorText(String auditorText) {
        this.auditorText = auditorText;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    public Integer getAccountingCaliber() {
        return accountingCaliber;
    }

    public void setAccountingCaliber(Integer accountingCaliber) {
        this.accountingCaliber = accountingCaliber;
    }

    public String getAccountingCaliberText() {
        return accountingCaliberText;
    }

    public void setAccountingCaliberText(String accountingCaliberText) {
        this.accountingCaliberText = accountingCaliberText;
    }
}
