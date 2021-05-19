package com.bsoft.office.sales.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2021/4/19 10:52
 * @Description
 */
public class SalesContractCheckViewVO {
    /** 合同号 */
    @OperLogFieldName(value = "合同号")
    private String contractNo;
    /** 工号 */
    @OperLogFieldName(value = "工号")
    private String personId;
    /** 客户名称 */
    @OperLogFieldName(value = "客户名称")
    private String customerName;
    /** 跟单人 */
    @OperLogFieldName(value = "跟单人")
    private String merchandiser;
    /** 评审人 */
    @OperLogFieldName(value = "评审人")
    private String reviewer;
    /** 评审人姓名 */
    @OperLogFieldName(value = "评审人姓名")
    private String reviewerName;
    /** 标志 */
    @OperLogFieldName(value = "标志")
    private Integer completeFlag;
    @OperLogFieldName(value = "标志")
    private String completeFlagText;
    /** 核对人 */
    @OperLogFieldName(value = "核对人")
    private String checkPerson;
    /** 核对人名字 */
    @OperLogFieldName(value = "核对人名字")
    private String checkPersonName;
    /** 核对日期 */
    @OperLogFieldName(value = "核对日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date checkDate;
    /** 合同编号 */
    @OperLogFieldName(value = "合同编号")
    private String contractId;
    /** 核对标志 */
    @OperLogFieldName(value = "核对标志")
    private Integer checkedFlag;

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getMerchandiser() {
        return merchandiser;
    }

    public void setMerchandiser(String merchandiser) {
        this.merchandiser = merchandiser;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public Integer getCompleteFlag() {
        return completeFlag;
    }

    public void setCompleteFlag(Integer completeFlag) {
        this.completeFlag = completeFlag;
    }

    public String getCompleteFlagText() {
        return completeFlagText;
    }

    public void setCompleteFlagText(String completeFlagText) {
        this.completeFlagText = completeFlagText;
    }

    public String getCheckPerson() {
        return checkPerson;
    }

    public void setCheckPerson(String checkPerson) {
        this.checkPerson = checkPerson;
    }

    public String getCheckPersonName() {
        return checkPersonName;
    }

    public void setCheckPersonName(String checkPersonName) {
        this.checkPersonName = checkPersonName;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public Integer getCheckedFlag() {
        return checkedFlag;
    }

    public void setCheckedFlag(Integer checkedFlag) {
        this.checkedFlag = checkedFlag;
    }
}
