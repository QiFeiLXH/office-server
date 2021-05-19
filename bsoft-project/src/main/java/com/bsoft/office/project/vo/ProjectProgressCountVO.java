package com.bsoft.office.project.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2021/4/29 13:55
 * @Description:
 */
public class ProjectProgressCountVO {
    private String contractNo;
    private String contractName;
    private String projectId;
    private String projectName;
    private Integer colldeptParent;
    private String colldeptParentName;
    private String collectionDept;
    private String collectionDeptName;
    private String projectManager;
    private String projectManagerName;
    private Integer businessType;
    private String businessTypeName;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date progressMonth;
    private Double progress;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date reportDate;
    private Double contractProgress;
    private Integer progressNum;
    private String progressManager;
    private String progressManagerName;

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

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Integer getColldeptParent() {
        return colldeptParent;
    }

    public void setColldeptParent(Integer colldeptParent) {
        this.colldeptParent = colldeptParent;
    }

    public String getColldeptParentName() {
        return colldeptParentName;
    }

    public void setColldeptParentName(String colldeptParentName) {
        this.colldeptParentName = colldeptParentName;
    }

    public String getCollectionDept() {
        return collectionDept;
    }

    public void setCollectionDept(String collectionDept) {
        this.collectionDept = collectionDept;
    }

    public String getCollectionDeptName() {
        return collectionDeptName;
    }

    public void setCollectionDeptName(String collectionDeptName) {
        this.collectionDeptName = collectionDeptName;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }

    public String getProjectManagerName() {
        return projectManagerName;
    }

    public void setProjectManagerName(String projectManagerName) {
        this.projectManagerName = projectManagerName;
    }

    public Integer getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Integer businessType) {
        this.businessType = businessType;
    }

    public String getBusinessTypeName() {
        return businessTypeName;
    }

    public void setBusinessTypeName(String businessTypeName) {
        this.businessTypeName = businessTypeName;
    }

    public Date getProgressMonth() {
        return progressMonth;
    }

    public void setProgressMonth(Date progressMonth) {
        this.progressMonth = progressMonth;
    }

    public Double getProgress() {
        return progress;
    }

    public void setProgress(Double progress) {
        this.progress = progress;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public Double getContractProgress() {
        return contractProgress;
    }

    public void setContractProgress(Double contractProgress) {
        this.contractProgress = contractProgress;
    }

    public Integer getProgressNum() {
        return progressNum;
    }

    public void setProgressNum(Integer progressNum) {
        this.progressNum = progressNum;
    }

    public String getProgressManager() {
        return progressManager;
    }

    public void setProgressManager(String progressManager) {
        this.progressManager = progressManager;
    }

    public String getProgressManagerName() {
        return progressManagerName;
    }

    public void setProgressManagerName(String progressManagerName) {
        this.progressManagerName = progressManagerName;
    }
}
