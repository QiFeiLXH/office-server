package com.bsoft.office.sales.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/25 12:18
 * @Description
 */
public class PurchaseContractPaymentVO {
    @OperLogFieldName(value = "id")
    private Integer id;
    /** cg_htxx id */
    @OperLogFieldName(value = "采购合同id")
    private Integer contractId;
    /** 付款科目 */
    @OperLogFieldName(value = "付款科目")
    private Integer paymentAccount;
    @OperLogFieldName(value = "付款科目")
    private String paymentAccountText;
    /** 付款金额 */
    @OperLogFieldName(value = "付款金额")
    private Double payment;
    /** 付款条件 */
    @OperLogFieldName(value = "付款条件")
    private String remarks;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public Integer getPaymentAccount() {
        return paymentAccount;
    }

    public void setPaymentAccount(Integer paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

    public String getPaymentAccountText() {
        return paymentAccountText;
    }

    public void setPaymentAccountText(String paymentAccountText) {
        this.paymentAccountText = paymentAccountText;
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
