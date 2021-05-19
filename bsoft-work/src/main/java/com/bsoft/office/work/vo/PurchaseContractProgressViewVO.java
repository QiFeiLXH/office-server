package com.bsoft.office.work.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/11/11 8:44
 * @Description 采购合同进度
 */
public class PurchaseContractProgressViewVO {
    @OperLogFieldName(value = "id")
    private Integer id;
    /** 采购合同号id */
    @OperLogFieldName(value = "采购合同号id")
    private Integer purchaseContractId;
    /** 采购合同号 */
    @OperLogFieldName(value = "采购合同号")
    private String purchaseContractNo;
    /** 合同名称 */
    @OperLogFieldName(value = "合同名称")
    private String contractName;
    /** 确认日期 */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "确认日期")
    private Date confirmDate;
    /** 进度 */
    @OperLogFieldName(value = "进度")
    private Double progress;
    /** 上次进度 */
    @OperLogFieldName(value = "上次进度")
    private Double lastProgress;
    /** 登记人 */
    @OperLogFieldName(value = "登记人")
    private String registerPersonId;
    @OperLogFieldName(value = "登记人")
    private String registerPersonName;
    /** 登记日期 */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "登记日期")
    private Date registerDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPurchaseContractId() {
        return purchaseContractId;
    }

    public void setPurchaseContractId(Integer purchaseContractId) {
        this.purchaseContractId = purchaseContractId;
    }

    public Date getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(Date confirmDate) {
        this.confirmDate = confirmDate;
    }

    public Double getProgress() {
        return progress;
    }

    public void setProgress(Double progress) {
        this.progress = progress;
    }

    public String getRegisterPersonId() {
        return registerPersonId;
    }

    public void setRegisterPersonId(String registerPersonId) {
        this.registerPersonId = registerPersonId;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Double getLastProgress() {
        return lastProgress;
    }

    public void setLastProgress(Double lastProgress) {
        this.lastProgress = lastProgress;
    }

    public String getRegisterPersonName() {
        return registerPersonName;
    }

    public void setRegisterPersonName(String registerPersonName) {
        this.registerPersonName = registerPersonName;
    }

    public String getPurchaseContractNo() {
        return purchaseContractNo;
    }

    public void setPurchaseContractNo(String purchaseContractNo) {
        this.purchaseContractNo = purchaseContractNo;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }
}
