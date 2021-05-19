package com.bsoft.office.sales.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2021/3/16 9:03
 * @Description
 */
public class SalesContractViewVO {
    /** 合同编号 */
    @OperLogFieldName(value = "合同编号")
    private String contractId;
    /** 合同号 */
    @OperLogFieldName(value = "合同号")
    private String contractNo;
    /** 合同名称 */
    @OperLogFieldName(value = "合同名称")
    private String contractName;
    /** 合同金额 */
    @OperLogFieldName(value = "合同金额")
    private Double contractAmount;
    /** 跟单人 */
    @OperLogFieldName(value = "跟单人")
    private String merchandiser;
    /** 跟单人名字 */
    @OperLogFieldName(value = "跟单人名字")
    private String merchandiserName;
    /** 签定日期 */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "签定日期")
    private Date signDate;
    /** 销售区域 */
    @OperLogFieldName(value = "销售区域")
    private String saleArea;
    /** 销售区域名字 */
    @OperLogFieldName(value = "销售区域名字")
    private String saleAreaName;
    @OperLogFieldName(value = "合同金额方式")
    /** 合同金额方式 */
    private Integer completeFlag;
    /** 是否已提交 */
    @OperLogFieldName(value = "是否已提交")
    private Integer committed;
    /** 退回原因 */
    @OperLogFieldName(value = "退回原因")
    private String backReason;

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
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

    public Double getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(Double contractAmount) {
        this.contractAmount = contractAmount;
    }

    public String getMerchandiser() {
        return merchandiser;
    }

    public void setMerchandiser(String merchandiser) {
        this.merchandiser = merchandiser;
    }

    public String getMerchandiserName() {
        return merchandiserName;
    }

    public void setMerchandiserName(String merchandiserName) {
        this.merchandiserName = merchandiserName;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public String getSaleArea() {
        return saleArea;
    }

    public void setSaleArea(String saleArea) {
        this.saleArea = saleArea;
    }

    public String getSaleAreaName() {
        return saleAreaName;
    }

    public void setSaleAreaName(String saleAreaName) {
        this.saleAreaName = saleAreaName;
    }

    public Integer getCompleteFlag() {
        return completeFlag;
    }

    public void setCompleteFlag(Integer completeFlag) {
        this.completeFlag = completeFlag;
    }

    public Integer getCommitted() {
        return committed;
    }

    public void setCommitted(Integer committed) {
        this.committed = committed;
    }

    public String getBackReason() {
        return backReason;
    }

    public void setBackReason(String backReason) {
        this.backReason = backReason;
    }
}
