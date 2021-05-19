package com.bsoft.office.organ.vo;

import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.annotation.OperLogFieldName;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author zhanglf
 * @Date 2020-04-17 11:33
 * @Version 1.0
 * @Description
 */
public class BondInfoVO implements Serializable {
    private String id; // 主键id  jkpz
    @OperLogFieldName(value = "领款人")
    private String payee;//领款人 lkr
    @OperLogFieldName(value = "领款人姓名")
    private String payeeName;//领款人姓名
    @OperLogFieldName(value = "收款单位")
    private String collectionUnit;//收款单位 skdw
    @OperLogFieldName(value = "申请时间")
    private Date applicantTime;//申请时间 sqrq
    @OperLogFieldName(value = "保证金")
    private Double bond;//保证金 sqje
    @OperLogFieldName(value = "履约保证金")
    private Double performanceBond; //履约保证金 lybzj
    @OperLogFieldName(value = "发放时间")
    private Date paymentTime;//发放时间 ffsj
    @OperLogFieldName(value = "预计退款时间")
    private Date estimatedRefundTime;// 预计退款时间 yjtksj
    @OperLogFieldName(value = "履约标志")
    private Integer performanceSymbol;//履约标志
    @OperLogFieldName(value = "逾期天数")
    private Integer overdueDays;//逾期天数

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public String getPayeeName() {
        return payeeName;
    }

    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName;
    }

    public String getCollectionUnit() {
        return collectionUnit;
    }

    public void setCollectionUnit(String collectionUnit) {
        this.collectionUnit = collectionUnit;
    }

    public Date getApplicantTime() {
        return applicantTime;
    }

    public void setApplicantTime(Date applicantTime) {
        this.applicantTime = applicantTime;
    }

    public Double getBond() {
        return bond;
    }

    public void setBond(Double bond) {
        this.bond = bond;
    }

    public Double getPerformanceBond() {
        return performanceBond;
    }

    public void setPerformanceBond(Double performanceBond) {
        this.performanceBond = performanceBond;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Date getEstimatedRefundTime() {
        return estimatedRefundTime;
    }

    public void setEstimatedRefundTime(Date estimatedRefundTime) {
        this.estimatedRefundTime = estimatedRefundTime;
    }

    public Integer getPerformanceSymbol() {
        return performanceSymbol;
    }

    public void setPerformanceSymbol(Integer performanceSymbol) {
        this.performanceSymbol = performanceSymbol;
    }

    public Integer getOverdueDays() {
        return overdueDays;
    }

    public void setOverdueDays(Integer overdueDays) {
        this.overdueDays = overdueDays;
    }
}
