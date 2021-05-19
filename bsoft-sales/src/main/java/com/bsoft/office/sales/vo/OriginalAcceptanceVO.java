package com.bsoft.office.sales.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2020/7/29 16:11
 * @Description: 合同原件审核
 */
public class OriginalAcceptanceVO {
    @OperLogFieldName(value = "记录ID")
    private Integer recordId;
    @OperLogFieldName(value = "资料ID")
    private Integer documentId;
    @OperLogFieldName(value = "资料名称")
    private String documentName;
    @OperLogFieldName(value = "数量")
    private Integer documentNumber;
    @OperLogFieldName(value = "接收数量")
    private Integer newDocumentNumber;
    @OperLogFieldName(value = "原件接收标志")
    private Integer receivingFlag;
    @OperLogFieldName(value = "原件接收数量")
    private Integer receivingNumber;
    @OperLogFieldName(value = "原件接收人")
    private String receiver;
    @OperLogFieldName(value = "原件接收人姓名")
    private String receiverText;
    @OperLogFieldName(value = "原件接收时间")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date receivingDate;
    @OperLogFieldName(value = "原件接收备注")
    private String receivingRemarks;
    @OperLogFieldName(value = "归档接收标志")
    private Integer filingFlag;
    @OperLogFieldName(value = "归档接收数量")
    private Integer filingNumber;
    @OperLogFieldName(value = "归档接收人")
    private String archivist;
    @OperLogFieldName(value = "归档接收人姓名")
    private String archivistText;
    @OperLogFieldName(value = "归档接收时间")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date filingDate;
    @OperLogFieldName(value = "归档接收备注")
    private String filingRemarks;
    @OperLogFieldName(value = "原件审核阶段")
    private Integer status;
    @OperLogFieldName(value = "合同号")
    private String contractno;
    @OperLogFieldName(value = "合同名称")
    private String contractName;
    @OperLogFieldName(value = "合同额")
    private Double money;
    @OperLogFieldName(value = "签定人")
    private String signatory;
    @OperLogFieldName(value = "签定人姓名")
    private String signatoryText;
    @OperLogFieldName(value = "签定日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date signDate;
    @OperLogFieldName(value = "受理人")
    private String contractReviewer;
    @OperLogFieldName(value = "受理人姓名")
    private String contractReviewerText;
    @OperLogFieldName(value = "市场区域")
    private String area;
    @OperLogFieldName(value = "市场区域名称")
    private String areaText;
    @OperLogFieldName(value = "拼音码")
    private String pinYinCode;
    @OperLogFieldName(value = "客户名称")
    private String customerName;

    public String getPinYinCode() {
        return pinYinCode;
    }

    public void setPinYinCode(String pinYinCode) {
        this.pinYinCode = pinYinCode;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Integer documentId) {
        this.documentId = documentId;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public Integer getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(Integer documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Integer getReceivingFlag() {
        return receivingFlag;
    }

    public void setReceivingFlag(Integer receivingFlag) {
        this.receivingFlag = receivingFlag;
    }

    public Integer getReceivingNumber() {
        return receivingNumber;
    }

    public void setReceivingNumber(Integer receivingNumber) {
        this.receivingNumber = receivingNumber;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getReceiverText() {
        return receiverText;
    }

    public void setReceiverText(String receiverText) {
        this.receiverText = receiverText;
    }

    public Date getReceivingDate() {
        return receivingDate;
    }

    public void setReceivingDate(Date receivingDate) {
        this.receivingDate = receivingDate;
    }

    public String getReceivingRemarks() {
        return receivingRemarks;
    }

    public void setReceivingRemarks(String receivingRemarks) {
        this.receivingRemarks = receivingRemarks;
    }

    public Integer getFilingFlag() {
        return filingFlag;
    }

    public void setFilingFlag(Integer filingFlag) {
        this.filingFlag = filingFlag;
    }

    public Integer getFilingNumber() {
        return filingNumber;
    }

    public void setFilingNumber(Integer filingNumber) {
        this.filingNumber = filingNumber;
    }

    public String getArchivist() {
        return archivist;
    }

    public void setArchivist(String archivist) {
        this.archivist = archivist;
    }

    public String getArchivistText() {
        return archivistText;
    }

    public void setArchivistText(String archivistText) {
        this.archivistText = archivistText;
    }

    public Date getFilingDate() {
        return filingDate;
    }

    public void setFilingDate(Date filingDate) {
        this.filingDate = filingDate;
    }

    public String getFilingRemarks() {
        return filingRemarks;
    }

    public void setFilingRemarks(String filingRemarks) {
        this.filingRemarks = filingRemarks;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getContractno() {
        return contractno;
    }

    public void setContractno(String contractno) {
        this.contractno = contractno;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getSignatory() {
        return signatory;
    }

    public void setSignatory(String signatory) {
        this.signatory = signatory;
    }

    public String getSignatoryText() {
        return signatoryText;
    }

    public void setSignatoryText(String signatoryText) {
        this.signatoryText = signatoryText;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public String getContractReviewer() {
        return contractReviewer;
    }

    public void setContractReviewer(String contractReviewer) {
        this.contractReviewer = contractReviewer;
    }

    public String getContractReviewerText() {
        return contractReviewerText;
    }

    public void setContractReviewerText(String contractReviewerText) {
        this.contractReviewerText = contractReviewerText;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAreaText() {
        return areaText;
    }

    public void setAreaText(String areaText) {
        this.areaText = areaText;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getNewDocumentNumber() {
        return newDocumentNumber;
    }

    public void setNewDocumentNumber(Integer newDocumentNumber) {
        this.newDocumentNumber = newDocumentNumber;
    }
}
