package com.bsoft.office.project.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;

import java.util.Date;

/**
 * @Author zhanglf
 * @Date 2020-01-17 11:02
 * @Version 1.0
 * @Description
 */
public class ProjectHavePlanVO {
    @OperLogFieldName(value = "合同编号")
    private String htbh;//合同编号 160810094137
    @OperLogFieldName(value = "合同号")
    private String contractNo;//合同编号 2016-1049
    @OperLogFieldName(value = "合同名称")
    private String contractName;//合同名称
    @OperLogFieldName(value = "大区编号")
    private String largeArea;//大区编号
    @OperLogFieldName(value = "大区名称")
    private String largeAreaText;//大区名称
    @OperLogFieldName(value = "工程区域")
    private String area;//工程区域编号
    @OperLogFieldName(value = "工程区域名称")
    private String areaText;//工程区域名称
    @OperLogFieldName(value = "项目ID")
    private String projectId;//项目id
    @OperLogFieldName(value = "项目名称")
    private String projectName;//项目名称
    @OperLogFieldName(value = "项目类别")
    private Integer flag;//项目类别
    @OperLogFieldName(value = "项目类别名称")
    private String flagText;
    @OperLogFieldName(value = "项目类型")
    private Integer projectType;//项目类型
    @OperLogFieldName(value = "项目类型名称")
    private String projectTypeText;
    @OperLogFieldName(value = "项目经理")
    private String projectManager;//项目经理
    @OperLogFieldName(value = "项目经理姓名")
    private String projectManagerText;
    @OperLogFieldName(value = "计划ID")
    private Integer planId;//计划id
    @OperLogFieldName(value = "成员数量")
    private Integer memberNum;//成员数量
    @OperLogFieldName(value = "有无计划")
    private String planFlag;//有无计划 0无 1有
    @OperLogFieldName(value = "计划修改日期")
    private Date modifyDate;//计划修改日期
    @OperLogFieldName(value = "已审工作量")
    private Double workloadAudited;//已审工作量（人日）
    @OperLogFieldName(value = "总工作量")
    private Double totalWorkload;//总工作量（人日）
    @OperLogFieldName(value = "项目规模")
    private Integer scale;//项目规模 1.大 2.中 3.小 4.微

    public String getHtbh() {
        return htbh;
    }

    public void setHtbh(String htbh) {
        this.htbh = htbh;
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

    public String getLargeArea() {
        return largeArea;
    }

    public void setLargeArea(String largeArea) {
        this.largeArea = largeArea;
    }

    public String getLargeAreaText() {
        return largeAreaText;
    }

    public void setLargeAreaText(String largeAreaText) {
        this.largeAreaText = largeAreaText;
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

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getFlagText() {
        return flagText;
    }

    public void setFlagText(String flagText) {
        this.flagText = flagText;
    }

    public Integer getProjectType() {
        return projectType;
    }

    public void setProjectType(Integer projectType) {
        this.projectType = projectType;
    }

    public String getProjectTypeText() {
        return projectTypeText;
    }

    public void setProjectTypeText(String projectTypeText) {
        this.projectTypeText = projectTypeText;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }

    public String getProjectManagerText() {
        return projectManagerText;
    }

    public void setProjectManagerText(String projectManagerText) {
        this.projectManagerText = projectManagerText;
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public String getPlanFlag() {
        return planFlag;
    }

    public void setPlanFlag(String planFlag) {
        this.planFlag = planFlag;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getMemberNum() {
        return memberNum;
    }

    public void setMemberNum(Integer memberNum) {
        this.memberNum = memberNum;
    }

    public Double getWorkloadAudited() {
        return workloadAudited;
    }

    public void setWorkloadAudited(Double workloadAudited) {
        this.workloadAudited = workloadAudited;
    }

    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
    }

    public Double getTotalWorkload() {
        return totalWorkload;
    }

    public void setTotalWorkload(Double totalWorkload) {
        this.totalWorkload = totalWorkload;
    }
}
