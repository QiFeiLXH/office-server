package com.bsoft.office.organ.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author zhanglf
 * @Date 2020-04-17 11:10
 * @Version 1.0
 * @Description 成本记录表
 */
public class BankChargesNoBillVO implements Serializable {
    private Integer id;//主键ID
    @OperLogFieldName(value = "申请人工号")
    private String applicant;//申请人工号  sqgh
    @OperLogFieldName(value = "申请人姓名")
    private String applicantName;//申请人姓名
    @OperLogFieldName(value = "收款单位")
    private String collectionUnit;//收款单位 skdw
    @OperLogFieldName(value = "核准金额")
    private Double authorizedAmount;//核准金额  shje
    @OperLogFieldName(value = "申请时间")
    private Date applicantTime;//申请时间 sqsj
    @OperLogFieldName(value = "发放时间")
    private Date paymentTime;//发放时间 ffsj
    @OperLogFieldName(value = "归属部门")
    private String department;//归属部门 gsbm
    @OperLogFieldName(value = "归属项目")
    private String attributionItems;//归属项目 gsxm
    @OperLogFieldName(value = "数据来源")
    private Integer costType;//数据来源 1.对公费用 2.中标服务费
    @OperLogFieldName(value = "数据来源名称")
    private String costTypeText;//数据来源 1.对公费用 2.中标服务费
    @OperLogFieldName(value = "税票标志")
    private Integer billSymbol;//税票标志 spbz
    @OperLogFieldName(value = "税票金额")
    private Double billAmount;//税票金额 spje
    @OperLogFieldName(value = "发放标志")
    private Integer paymentSymbol; //发放标志 ffbz
    @OperLogFieldName(value = "费用类别")
    private Integer category;//费用类别 fylb

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getCollectionUnit() {
        return collectionUnit;
    }

    public void setCollectionUnit(String collectionUnit) {
        this.collectionUnit = collectionUnit;
    }

    public Double getAuthorizedAmount() {
        return authorizedAmount;
    }

    public void setAuthorizedAmount(Double authorizedAmount) {
        this.authorizedAmount = authorizedAmount;
    }

    public Date getApplicantTime() {
        return applicantTime;
    }

    public void setApplicantTime(Date applicantTime) {
        this.applicantTime = applicantTime;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAttributionItems() {
        return attributionItems;
    }

    public void setAttributionItems(String attributionItems) {
        this.attributionItems = attributionItems;
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

    public Integer getBillSymbol() {
        return billSymbol;
    }

    public void setBillSymbol(Integer billSymbol) {
        this.billSymbol = billSymbol;
    }

    public Double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(Double billAmount) {
        this.billAmount = billAmount;
    }

    public Integer getPaymentSymbol() {
        return paymentSymbol;
    }

    public void setPaymentSymbol(Integer paymentSymbol) {
        this.paymentSymbol = paymentSymbol;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }
}
