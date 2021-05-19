package com.bsoft.office.organ.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class InvoiceLibraryVO implements Serializable {
    @OperLogFieldName(value = "ID")
    private Integer id;
    @OperLogFieldName(value = "用途")
    private Integer source;
    @OperLogFieldName(value = "用途名称")
    private String sourceText;
    @OperLogFieldName(value = "所属公司")
    private Integer companyNo;
    @OperLogFieldName(value = "所属公司名称")
    private String abbreviation;
    @OperLogFieldName(value = "税号")
    private String taxno;
    @OperLogFieldName(value = "发票类型")
    private String invoiceType;
    @OperLogFieldName(value = "发票类型名称")
    private String invoiceTypeText;
    @OperLogFieldName(value = "发票代码")
    private String invoiceCode;
    @OperLogFieldName(value = "发票号码")
    private String invoiceNumber;
    @OperLogFieldName(value = "票据金额")
    private Double amount;
    @OperLogFieldName(value = "开票日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date invoiceDate;
    @OperLogFieldName(value = "费用人")
    private String expensePerson;
    @OperLogFieldName(value = "费用人名称")
    private String expensePersonText;
    @OperLogFieldName(value = "登记日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date registratDate;
    @OperLogFieldName(value = "消费单位名称")
    private String unitName;
    @OperLogFieldName(value = "消费单位税号")
    private String unitTaxno;
    @OperLogFieldName(value = "发票文件ID")
    private Integer invoiceFileId;
    @OperLogFieldName(value = "拼音码")
    private String pinYinCode;
    /** 凭证号 */
    @OperLogFieldName(value = "凭证号")
    private String voucher;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public String getSourceText() {
        return sourceText;
    }

    public void setSourceText(String sourceText) {
        this.sourceText = sourceText;
    }

    public Integer getCompanyNo() {
        return companyNo;
    }

    public void setCompanyNo(Integer companyNo) {
        this.companyNo = companyNo;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getTaxno() {
        return taxno;
    }

    public void setTaxno(String taxno) {
        this.taxno = taxno;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getInvoiceTypeText() {
        return invoiceTypeText;
    }

    public void setInvoiceTypeText(String invoiceTypeText) {
        this.invoiceTypeText = invoiceTypeText;
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getExpensePerson() {
        return expensePerson;
    }

    public void setExpensePerson(String expensePerson) {
        this.expensePerson = expensePerson;
    }

    public String getExpensePersonText() {
        return expensePersonText;
    }

    public void setExpensePersonText(String expensePersonText) {
        this.expensePersonText = expensePersonText;
    }

    public Date getRegistratDate() {
        return registratDate;
    }

    public void setRegistratDate(Date registratDate) {
        this.registratDate = registratDate;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getUnitTaxno() {
        return unitTaxno;
    }

    public void setUnitTaxno(String unitTaxno) {
        this.unitTaxno = unitTaxno;
    }

    public Integer getInvoiceFileId() {
        return invoiceFileId;
    }

    public void setInvoiceFileId(Integer invoiceFileId) {
        this.invoiceFileId = invoiceFileId;
    }

    public String getPinYinCode() {
        return pinYinCode;
    }

    public void setPinYinCode(String pinYinCode) {
        this.pinYinCode = pinYinCode;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }
}
