package com.bsoft.office.project.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author zhanglf
 * @Date 2020-01-19 16:38
 * @Version 1.0
 * @Description
 */
public class ProjectPlanVO{
    @OperLogFieldName(value = "ID")
    private Integer id;//计划ID 主键
    @OperLogFieldName(value = "合同号")
    private String contractNo;//合同号 前端显示用
    @OperLogFieldName(value = "项目ID")
    private String projectId;//项目ID
    @OperLogFieldName(value = "项目经理")
    private String projectManager;//项目经理
    @OperLogFieldName(value = "计划创建人员")
    private String creater;//计划创建人员
    @OperLogFieldName(value = "计划创建日期")
    private Date createDate;//计划创建日期
    @OperLogFieldName(value = "批次")
    private Integer batchFlag;//批次
    @OperLogFieldName(value = "注销标志")
    private Integer logoff;//注销标志 1是 2否
    @OperLogFieldName(value = "变更标志")
    private Integer changeFlag;//变更标志
    @OperLogFieldName(value = "审核标志")
    private Integer auditFlag;//审核标志
    @OperLogFieldName(value = "合同编号")
    private String htbh;//合同编号 后台存储用
    @OperLogFieldName(value = "计划修改日期")
    private Date modifyDate;//计划修改日期

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getBatchFlag() {
        return batchFlag;
    }

    public void setBatchFlag(Integer batchFlag) {
        this.batchFlag = batchFlag;
    }

    public Integer getLogoff() {
        return logoff;
    }

    public void setLogoff(Integer logoff) {
        this.logoff = logoff;
    }

    public Integer getChangeFlag() {
        return changeFlag;
    }

    public void setChangeFlag(Integer changeFlag) {
        this.changeFlag = changeFlag;
    }

    public Integer getAuditFlag() {
        return auditFlag;
    }

    public void setAuditFlag(Integer auditFlag) {
        this.auditFlag = auditFlag;
    }

    public String getHtbh() {
        return htbh;
    }

    public void setHtbh(String htbh) {
        this.htbh = htbh;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}
