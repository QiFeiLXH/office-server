package com.bsoft.office.common.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;

import java.util.Date;

public class ProjectLookVO {
    @OperLogFieldName(value = "项目ID")
    private String projectId;
    @OperLogFieldName(value = "项目名称")
    private String projectName;
    @OperLogFieldName(value = "合同额")
    private Double contractAmount;
    @OperLogFieldName(value = "工程区域")
    private String area;
    @OperLogFieldName(value = "工程区域名称")
    private String areaText;
    @OperLogFieldName(value = "项目类别")
    private String flag;
    @OperLogFieldName(value = "项目类别名称")
    private String flagText;
    @OperLogFieldName(value = "签订日期")
    private Date signDate;
    @OperLogFieldName(value = "项目经理")
    private String projectManager;
    @OperLogFieldName(value = "项目经理姓名")
    private String projectManagerText;
    @OperLogFieldName(value = "合同号")
    private String contractNo;
    @OperLogFieldName(value = "合同编号")
    private String contractid;
    @OperLogFieldName(value = "客户名称")
    private String customerName;
    @OperLogFieldName(value = "拼音简码")
    private String pinyin;
    @OperLogFieldName(value = "客户所属区域")
    private String region;
    @OperLogFieldName(value = "客户分类")
    private String classification;
    @OperLogFieldName(value = "客户等级")
    private String grade;
    @OperLogFieldName(value = "完工标志")
    private Integer finshed;
    @OperLogFieldName(value = "线索编号")
    private Integer clueId;
    @OperLogFieldName(value = "业务归属")
    private Integer accountCaliber;
    @OperLogFieldName(value = "业务归属名称")
    private String accountCaliberText;

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

    public Double getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(Double contractAmount) {
        this.contractAmount = contractAmount;
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

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getFlagText() {
        return flagText;
    }

    public void setFlagText(String flagText) {
        this.flagText = flagText;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
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

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getContractid() {
        return contractid;
    }

    public void setContractid(String contractid) {
        this.contractid = contractid;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getFinshed() {
        return finshed;
    }

    public void setFinshed(Integer finshed) {
        this.finshed = finshed;
    }

    public Integer getClueId() {
        return clueId;
    }

    public void setClueId(Integer clueId) {
        this.clueId = clueId;
    }

    public Integer getAccountCaliber() {
        return accountCaliber;
    }

    public void setAccountCaliber(Integer accountCaliber) {
        this.accountCaliber = accountCaliber;
    }

    public String getAccountCaliberText() {
        return accountCaliberText;
    }

    public void setAccountCaliberText(String accountCaliberText) {
        this.accountCaliberText = accountCaliberText;
    }
}
