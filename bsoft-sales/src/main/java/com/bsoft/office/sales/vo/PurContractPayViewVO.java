package com.bsoft.office.sales.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2020/9/23 15:11
 * @Description: 支付信息VO
 */
public class PurContractPayViewVO {
    @OperLogFieldName(value = "id")
    private Integer id;
    @OperLogFieldName(value = "申请人")
    private String applyer;
    @OperLogFieldName(value = "申请人姓名")
    private String applyerText;
    @OperLogFieldName(value = "申请日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date applyDate;
    @OperLogFieldName(value = "合同号")
    private String contractNo;
    @OperLogFieldName(value = "项目ID")
    private String projectid;
    @OperLogFieldName(value = "项目名称")
    private String projectName;
    @OperLogFieldName(value = "核算部门")
    private String accountDept;
    @OperLogFieldName(value = "核算部门名称")
    private String accountDeptText;
    @OperLogFieldName(value = "核算口径")
    private Integer accountcaliber;
    @OperLogFieldName(value = "核算口径名称")
    private String accountcaliberText;
    @OperLogFieldName(value = "归属人")
    private String belonger;
    @OperLogFieldName(value = "归属人名称")
    private String belongerText;
    @OperLogFieldName(value = "采购性质")
    private Integer nature;
    @OperLogFieldName(value = "采购性质名称")
    private String natureText;
    @OperLogFieldName(value = "供货商")
    private Integer supplier;
    @OperLogFieldName(value = "供货商名称")
    private String supplierText;
    @OperLogFieldName(value = "采购内容")
    private String procurementContent;
    @OperLogFieldName(value = "采购合同号")
    private String purchaseContractNo;
    @OperLogFieldName(value = "本次申请")
    private Double applyAmount;
    @OperLogFieldName(value = "备注信息")
    private String remarks;
    @OperLogFieldName(value = "税票标志")
    private Integer taxFlag;
    @OperLogFieldName(value = "税票金额")
    private Double taxAmount;
    @OperLogFieldName(value = "发票代码")
    private String invoiceCode;
    @OperLogFieldName(value = "发票号码")
    private String invoiceNumber;
    @OperLogFieldName(value = "发票类型")
    private Integer invoiceType;
    @OperLogFieldName(value = "发票类型名称")
    private String invoiceTypeText;
    @OperLogFieldName(value = "税率")
    private Double taxRate;
    @OperLogFieldName(value = "凭证号")
    private Integer voucherNo;
    @OperLogFieldName(value = "采购合同ID")
    private Integer htid;
    @OperLogFieldName(value = "发放标志")
    private Integer ffbz;
    @OperLogFieldName(value = "发放日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date ffsj;
    @OperLogFieldName(value = "登记人")
    private String registrant;
    @OperLogFieldName(value = "登记人姓名")
    private String registrantText;
    @OperLogFieldName(value = "登记日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date registrantDate;
    @OperLogFieldName(value = "已支付金额")
    private Double paidAmount;
    @OperLogFieldName(value = "总金额")
    private Double totalAmount;
    @OperLogFieldName(value = "合同名称")
    private String contractName;
    @OperLogFieldName(value = "已申请总金额")
    private Double totalApplyAmount;
    @OperLogFieldName(value = "收款单位")
    private Integer payee;

    public Integer getPayee() {
        return payee;
    }

    public void setPayee(Integer payee) {
        this.payee = payee;
    }

    public Double getTotalApplyAmount() {
        return totalApplyAmount;
    }

    public void setTotalApplyAmount(Double totalApplyAmount) {
        this.totalApplyAmount = totalApplyAmount;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public Double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApplyer() {
        return applyer;
    }

    public void setApplyer(String applyer) {
        this.applyer = applyer;
    }

    public String getApplyerText() {
        return applyerText;
    }

    public void setApplyerText(String applyerText) {
        this.applyerText = applyerText;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getProjectid() {
        return projectid;
    }

    public void setProjectid(String projectid) {
        this.projectid = projectid;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getAccountDept() {
        return accountDept;
    }

    public void setAccountDept(String accountDept) {
        this.accountDept = accountDept;
    }

    public String getAccountDeptText() {
        return accountDeptText;
    }

    public void setAccountDeptText(String accountDeptText) {
        this.accountDeptText = accountDeptText;
    }

    public Integer getAccountcaliber() {
        return accountcaliber;
    }

    public void setAccountcaliber(Integer accountcaliber) {
        this.accountcaliber = accountcaliber;
    }

    public String getAccountcaliberText() {
        return accountcaliberText;
    }

    public void setAccountcaliberText(String accountcaliberText) {
        this.accountcaliberText = accountcaliberText;
    }

    public String getBelonger() {
        return belonger;
    }

    public void setBelonger(String belonger) {
        this.belonger = belonger;
    }

    public String getBelongerText() {
        return belongerText;
    }

    public void setBelongerText(String belongerText) {
        this.belongerText = belongerText;
    }

    public Integer getNature() {
        return nature;
    }

    public void setNature(Integer nature) {
        this.nature = nature;
    }

    public String getNatureText() {
        return natureText;
    }

    public void setNatureText(String natureText) {
        this.natureText = natureText;
    }

    public Integer getSupplier() {
        return supplier;
    }

    public void setSupplier(Integer supplier) {
        this.supplier = supplier;
    }

    public String getSupplierText() {
        return supplierText;
    }

    public void setSupplierText(String supplierText) {
        this.supplierText = supplierText;
    }

    public String getProcurementContent() {
        return procurementContent;
    }

    public void setProcurementContent(String procurementContent) {
        this.procurementContent = procurementContent;
    }

    public String getPurchaseContractNo() {
        return purchaseContractNo;
    }

    public void setPurchaseContractNo(String purchaseContractNo) {
        this.purchaseContractNo = purchaseContractNo;
    }

    public Double getApplyAmount() {
        return applyAmount;
    }

    public void setApplyAmount(Double applyAmount) {
        this.applyAmount = applyAmount;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getTaxFlag() {
        return taxFlag;
    }

    public void setTaxFlag(Integer taxFlag) {
        this.taxFlag = taxFlag;
    }

    public Double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(Double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Integer getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(Integer invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getInvoiceTypeText() {
        return invoiceTypeText;
    }

    public void setInvoiceTypeText(String invoiceTypeText) {
        this.invoiceTypeText = invoiceTypeText;
    }

    public Double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }

    public Integer getVoucherNo() {
        return voucherNo;
    }

    public void setVoucherNo(Integer voucherNo) {
        this.voucherNo = voucherNo;
    }

    public Integer getHtid() {
        return htid;
    }

    public void setHtid(Integer htid) {
        this.htid = htid;
    }

    public Integer getFfbz() {
        return ffbz;
    }

    public void setFfbz(Integer ffbz) {
        this.ffbz = ffbz;
    }

    public Date getFfsj() {
        return ffsj;
    }

    public void setFfsj(Date ffsj) {
        this.ffsj = ffsj;
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
}
