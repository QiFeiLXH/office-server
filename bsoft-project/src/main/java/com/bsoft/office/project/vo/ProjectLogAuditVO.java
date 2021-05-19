package com.bsoft.office.project.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;

import java.util.Date;

/**
 * 项目工程日志
 */

public class ProjectLogAuditVO {
    @OperLogFieldName(value = "ID")
    private Integer id;
    @OperLogFieldName(value = "审核人")
    private String auditter;
    @OperLogFieldName(value = "待审人")
    private String nextAuditter;//下一步待审人
    @OperLogFieldName(value = "审核日期")
    private Date auditDate;
    @OperLogFieldName(value = "审核标志")
    private Integer auditFlag;
    @OperLogFieldName(value = "拒绝次数")
    private Integer refuse;
    @OperLogFieldName(value = "项目日志阶段")
    private Integer auditType;
    @OperLogFieldName(value = "意见")
    private String remark;
    @OperLogFieldName(value = "归属项目合同号")
    private String contractNo;
    @OperLogFieldName(value = "提交人")
    private String submitter;
    @OperLogFieldName(value = "日志id")
    private Integer workLogId;
    @OperLogFieldName(value = "确认工时")
    private Double verifyHours;
    @OperLogFieldName(value = "归属项目ID")
    private String projectId;
    @OperLogFieldName(value = "操作来源")
    private Integer flag; //操作来源 5.门户   12.app

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuditter() {
        return auditter;
    }

    public void setAuditter(String auditter) {
        this.auditter = auditter;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    public Integer getAuditFlag() {
        return auditFlag;
    }

    public void setAuditFlag(Integer auditFlag) {
        this.auditFlag = auditFlag;
    }

    public Integer getRefuse() {
        return refuse;
    }

    public void setRefuse(Integer refuse) {
        this.refuse = refuse;
    }


    public Integer getAuditType() {
        return auditType;
    }

    public void setAuditType(Integer auditType) {
        this.auditType = auditType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getSubmitter() {
        return submitter;
    }

    public void setSubmitter(String submitter) {
        this.submitter = submitter;
    }

    public Integer getWorkLogId() {
        return workLogId;
    }

    public void setWorkLogId(Integer workLogId) {
        this.workLogId = workLogId;
    }

    public Double getVerifyHours() {
        return verifyHours;
    }

    public void setVerifyHours(Double verifyHours) {
        this.verifyHours = verifyHours;
    }

    public String getNextAuditter() {
        return nextAuditter;
    }

    public void setNextAuditter(String nextAuditter) {
        this.nextAuditter = nextAuditter;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}
