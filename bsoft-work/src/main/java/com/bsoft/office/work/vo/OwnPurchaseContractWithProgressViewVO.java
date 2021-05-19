package com.bsoft.office.work.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.format.NumberFormat;
import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/11/5 14:53
 * @Description 公司自用合同
 */
@ExcelIgnoreUnannotated
public class OwnPurchaseContractWithProgressViewVO {
    /** 采购id */
    @OperLogFieldName(value = "采购id")
    private Integer purchaseContractId;
    /** 采购合同号 */
    @ExcelProperty(value = "采购合同号", index = 0)
    @OperLogFieldName(value = "采购合同号")
    private String purchaseContractNo;
    /** 签定部门 */
    @OperLogFieldName(value = "签定部门")
    private String signDept;
    /** 签定部门名称 */
    @OperLogFieldName(value = "签定部门名称")
    private String signDeptName;
    /** 对方单位 */
    @OperLogFieldName(value = "对方单位")
    private Integer suppliers;
    /** 对方单位名称 */
    @ExcelProperty(value = "对方单位", index = 2)
    @OperLogFieldName(value = "对方单位名称")
    private String suppliersText;
    /** 合同金额 */
    @ExcelProperty(value = "合同金额", index = 3)
    @OperLogFieldName(value = "合同金额")
    private Double totalAmount;
    /** 有无合同 */
    @OperLogFieldName(value = "有无合同")
    private Integer hasContract;
    @OperLogFieldName(value = "有无合同")
    private String hasContractText;
    /** 签定人 */
    @OperLogFieldName(value = "签定人")
    private String signer;
    /** 签定人名字 */
    @OperLogFieldName(value = "签定人名字")
    private String signerText;
    /** 签定日期 */
    @OperLogFieldName(value = "签定日期")
    private Date signDate;
    /** 已支付金额 */
    @OperLogFieldName(value = "已支付金额")
    private Double payAmount;
    /** 采购大类 */
    @OperLogFieldName(value = "采购大类")
    private Integer flag;
    /** 采购合同原件 */
    @OperLogFieldName(value = "采购合同原件")
    private Integer originalStatus;
    /** 完结标志 */
    @OperLogFieldName(value = "完结标志")
    private Integer endMark;
    /** 合同内容 */
    @OperLogFieldName(value = "合同内容")
    private String productName;
    /** 决算金额 */
    @OperLogFieldName(value = "决算金额")
    private Double finalCostAmount;
    /** 审核状态 */
    @OperLogFieldName(value = "审核状态")
    private Integer status;
    @OperLogFieldName(value = "审核状态")
    private String statusText;
    /** 合同名称 */
    @ExcelProperty(value = "合同名称", index = 1)
    @OperLogFieldName(value = "合同名称")
    private String contractName;
    /** 签定年份 */
    @OperLogFieldName(value = "签定年份")
    private Integer signYear;
    /** 合同进度 */
    @ExcelProperty(value = "进度", index = 4)
    @NumberFormat("#.##%")
    @OperLogFieldName(value = "合同进度")
    private Double progress;
    /** 合同确认日期 */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @ExcelProperty(value = "确认月份", index = 5)
    @DateTimeFormat("yyyy-MM")
    @OperLogFieldName(value = "合同确认日期")
    private Date confirmDate;
    /** 合同分类 */
    @OperLogFieldName(value = "合同分类")
    private Integer classification;
    /** 补充协议标志 */
    @OperLogFieldName(value = "补充协议标志")
    private Integer supplementFlag;
    /** 原合同id */
    @OperLogFieldName(value = "原合同id")
    private Integer originalContractId;
    /** 登记人 */
    @OperLogFieldName(value = "登记人")
    private String registerPersonId;
    /** 登记日期 */
    @OperLogFieldName(value = "登记日期")
    private Date registerDate;

    public Integer getPurchaseContractId() {
        return purchaseContractId;
    }

    public void setPurchaseContractId(Integer purchaseContractId) {
        this.purchaseContractId = purchaseContractId;
    }

    public String getPurchaseContractNo() {
        return purchaseContractNo;
    }

    public void setPurchaseContractNo(String purchaseContractNo) {
        this.purchaseContractNo = purchaseContractNo;
    }

    public String getSignDept() {
        return signDept;
    }

    public void setSignDept(String signDept) {
        this.signDept = signDept;
    }

    public Integer getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Integer suppliers) {
        this.suppliers = suppliers;
    }

    public String getSuppliersText() {
        return suppliersText;
    }

    public void setSuppliersText(String suppliersText) {
        this.suppliersText = suppliersText;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getHasContract() {
        return hasContract;
    }

    public void setHasContract(Integer hasContract) {
        this.hasContract = hasContract;
    }

    public String getSigner() {
        return signer;
    }

    public void setSigner(String signer) {
        this.signer = signer;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public Double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Double payAmount) {
        this.payAmount = payAmount;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getOriginalStatus() {
        return originalStatus;
    }

    public void setOriginalStatus(Integer originalStatus) {
        this.originalStatus = originalStatus;
    }

    public Integer getEndMark() {
        return endMark;
    }

    public void setEndMark(Integer endMark) {
        this.endMark = endMark;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getFinalCostAmount() {
        return finalCostAmount;
    }

    public void setFinalCostAmount(Double finalCostAmount) {
        this.finalCostAmount = finalCostAmount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getSignDeptName() {
        return signDeptName;
    }

    public void setSignDeptName(String signDeptName) {
        this.signDeptName = signDeptName;
    }

    public String getSignerText() {
        return signerText;
    }

    public void setSignerText(String signerText) {
        this.signerText = signerText;
    }

    public Integer getSignYear() {
        return signYear;
    }

    public void setSignYear(Integer signYear) {
        this.signYear = signYear;
    }

    public Double getProgress() {
        return progress;
    }

    public void setProgress(Double progress) {
        this.progress = progress;
    }

    public Date getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(Date confirmDate) {
        this.confirmDate = confirmDate;
    }

    public Integer getClassification() {
        return classification;
    }

    public void setClassification(Integer classification) {
        this.classification = classification;
    }

    public String getHasContractText() {
        return hasContractText;
    }

    public void setHasContractText(String hasContractText) {
        this.hasContractText = hasContractText;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public Integer getSupplementFlag() {
        return supplementFlag;
    }

    public void setSupplementFlag(Integer supplementFlag) {
        this.supplementFlag = supplementFlag;
    }

    public Integer getOriginalContractId() {
        return originalContractId;
    }

    public void setOriginalContractId(Integer originalContractId) {
        this.originalContractId = originalContractId;
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
}
