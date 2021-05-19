package com.bsoft.office.project.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;

public class ProjectWithAuditVO {
    @OperLogFieldName(value = "合同号")
    private String contractNo;
    @OperLogFieldName(value = "项目名称")
    private String projectName;
    @OperLogFieldName(value = "项目经理")
    private String projectManager;
    @OperLogFieldName(value = "项目ID")
    private String projectId;
    @OperLogFieldName(value = "待审数量")
    private Integer countNum;

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public Integer getCountNum() {
        return countNum;
    }

    public void setCountNum(Integer countNum) {
        this.countNum = countNum;
    }
}
