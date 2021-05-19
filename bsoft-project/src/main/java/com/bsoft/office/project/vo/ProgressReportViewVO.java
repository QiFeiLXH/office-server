package com.bsoft.office.project.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2021/4/19 14:49
 * @Description:
 */
public class ProgressReportViewVO {
    @OperLogFieldName(value = "项目ID")
    private String projectId;
    @OperLogFieldName(value = "项目名称")
    private String projectName;
    @OperLogFieldName(value = "合同号")
    private String contractNo;
    @OperLogFieldName(value = "合同名称")
    private String contractName;
    @OperLogFieldName(value = "业务大类")
    private Integer businessType;
    @OperLogFieldName(value = "业务大类名称")
    private String businessTypeName;
    @OperLogFieldName(value = "项目经理")
    private String projectManager;
    @OperLogFieldName(value = "项目经理姓名")
    private String projectManagerName;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "上一次进度月份")
    private Date lastProgressMonth;
    @OperLogFieldName(value = "项目进度")
    private Double projectProgress;
    @OperLogFieldName(value = "进度经理")
    private String progressManager;
    @OperLogFieldName(value = "进度经理名称")
    private String progressManagerName;
    @OperLogFieldName(value = "产品清单提交数")
    private Integer submited;
    @OperLogFieldName(value = "产品清单总数")
    private Integer total;
    @OperLogFieldName(value = "回款业绩部门")
    private String collectionDept;
    @OperLogFieldName(value = "回款业绩部门名称")
    private String collectionDeptName;
    @OperLogFieldName(value = "立项日期")
    private Date proApplyDate;

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

    public Date getLastProgressMonth() {
        return lastProgressMonth;
    }

    public void setLastProgressMonth(Date lastProgressMonth) {
        this.lastProgressMonth = lastProgressMonth;
    }

    public Double getProjectProgress() {
        return projectProgress;
    }

    public void setProjectProgress(Double projectProgress) {
        this.projectProgress = projectProgress;
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

    public Integer getSubmited() {
        return submited;
    }

    public void setSubmited(Integer submited) {
        this.submited = submited;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
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

    public Date getProApplyDate() {
        return proApplyDate;
    }

    public void setProApplyDate(Date proApplyDate) {
        this.proApplyDate = proApplyDate;
    }
}
