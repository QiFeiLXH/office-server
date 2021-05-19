package com.bsoft.office.project.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2021/4/20 19:19
 * @Description
 */
public class ProjectExpandViewVO {
    /** 项目id */
    private String projectId;
    /** 项目名称 */
    private String projectName;
    /** 合同号 */
    private String contractNo;
    /** 回款一级部门 */
    private Integer collDeptParent;
    /** 回款二级部门id */
    private String collectionDept;
    /** 回款二级部门名称 */
    private String collectionDeptName;
    /** 业务大类 */
    private Integer businessType;
    /** 业务大类名称 */
    private String businessTypeName;
    /** 项目经理工号 */
    private String projectManager;
    /** 项目经理姓名 */
    private String projectManagerName;
    /** 是否上报进度 */
    private Integer reportFlag;
    /** 进度经理 */
    private String progressManager;
    /** 进度经理姓名 */
    private String progressManagerName;
    /** 维护人 */
    private String registrant;
    /** 维护人姓名 */
    private String registrantName;
    /** 维护日期 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date registrantDate;
    /** 维护标志 */
    private Integer maintainFlag;
    /** 项目经理是否离职 */
    private String logout;

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

    public Integer getCollDeptParent() {
        return collDeptParent;
    }

    public void setCollDeptParent(Integer collDeptParent) {
        this.collDeptParent = collDeptParent;
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

    public Integer getReportFlag() {
        return reportFlag;
    }

    public void setReportFlag(Integer reportFlag) {
        this.reportFlag = reportFlag;
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

    public String getRegistrant() {
        return registrant;
    }

    public void setRegistrant(String registrant) {
        this.registrant = registrant;
    }

    public String getRegistrantName() {
        return registrantName;
    }

    public void setRegistrantName(String registrantName) {
        this.registrantName = registrantName;
    }

    public Date getRegistrantDate() {
        return registrantDate;
    }

    public void setRegistrantDate(Date registrantDate) {
        this.registrantDate = registrantDate;
    }

    public Integer getMaintainFlag() {
        return maintainFlag;
    }

    public void setMaintainFlag(Integer maintainFlag) {
        this.maintainFlag = maintainFlag;
    }

    public String getLogout() {
        return logout;
    }

    public void setLogout(String logout) {
        this.logout = logout;
    }
}
