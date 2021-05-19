package com.bsoft.office.project.vo;

import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2021/5/6 9:50
 * @Description:
 */
public class ProContractProjectProgressVO {
    private String projectId;
    private String projectName;
    private String contractNo;
    private String contractName;
    private String projectManager;
    private String projectManagerName;
    private String progressManager;
    private String progressManagerName;
    private Date progressMonth;
    private Double progress;
    private Double contractProgress;

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

    public Double getContractProgress() {
        return contractProgress;
    }

    public void setContractProgress(Double contractProgress) {
        this.contractProgress = contractProgress;
    }
}
