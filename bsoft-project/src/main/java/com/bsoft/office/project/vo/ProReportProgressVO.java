package com.bsoft.office.project.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2021/4/20 14:53
 * @Description:
 */
public class ProReportProgressVO {
    @OperLogFieldName(value = "id")
    private Integer id;
    @OperLogFieldName(value = "项目id")
    private String projectId;
    @OperLogFieldName(value = "产品清单系统id")
    private Integer systemId;
    @OperLogFieldName(value = "产品清单系统名称")
    private String systemName;
    @OperLogFieldName(value = "产品id")
    private Integer productId;
    @OperLogFieldName(value = "产品编号")
    private Integer productNumber;
    @OperLogFieldName(value = "产品名称")
    private String productName;
    @OperLogFieldName(value = "合同模块名称")
    private String moduleName;
    @OperLogFieldName(value = "项目金额")
    private Double amount;
    @OperLogFieldName(value = "上报分类")
    private Integer reportType;
    @OperLogFieldName(value = "产品最新进度")
    private Double lastProgress;
    @OperLogFieldName(value = "产品最新进度月份")
    private Date lastProgressMonth;
    @OperLogFieldName(value = "产品备注")
    private String remarks;
    @OperLogFieldName(value = "产品机构数")
    private Integer orgNum;
    @OperLogFieldName(value = "进度id")
    private Integer progressId;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "进度月份")
    private String progressMonth;
    @OperLogFieldName(value = "上报人")
    private String reporter;
    @OperLogFieldName(value = "上报人姓名")
    private String reporterName;
    @OperLogFieldName(value = "上报日期")
    private Date reportDate;
    @OperLogFieldName(value = "项目进度")
    private Double projectProgress;
    @OperLogFieldName(value = "模块进度id")
    private Integer productProgressId;
    @OperLogFieldName(value = "模块进度")
    private Double productProgress;
    @OperLogFieldName(value = "上报节点ids")
    private String nodeids;
    @OperLogFieldName(value = "上报节点numbers")
    private String progressNums;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "最早上线日期")
    private Date firstOnLineDate;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "验收日期")
    private Date checkDate;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "开始日期")
    private Date startDate;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "结束日期")
    private Date endDate;
    @OperLogFieldName(value = "维护月份")
    private Integer termOfService;
    @OperLogFieldName(value = "承建分工")
    private Integer constructionType;
    @OperLogFieldName(value = "承建分工名称")
    private String constructionTypeName;
    @OperLogFieldName(value = "业务归属")
    private Integer businessowner;
    @OperLogFieldName(value = "业务归属名称")
    private String businessownerName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Integer productNumber) {
        this.productNumber = productNumber;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getReportType() {
        return reportType;
    }

    public void setReportType(Integer reportType) {
        this.reportType = reportType;
    }

    public Double getLastProgress() {
        return lastProgress;
    }

    public void setLastProgress(Double lastProgress) {
        this.lastProgress = lastProgress;
    }

    public Date getLastProgressMonth() {
        return lastProgressMonth;
    }

    public void setLastProgressMonth(Date lastProgressMonth) {
        this.lastProgressMonth = lastProgressMonth;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getOrgNum() {
        return orgNum;
    }

    public void setOrgNum(Integer orgNum) {
        this.orgNum = orgNum;
    }

    public Integer getProgressId() {
        return progressId;
    }

    public void setProgressId(Integer progressId) {
        this.progressId = progressId;
    }

    public String getProgressMonth() {
        return progressMonth;
    }

    public void setProgressMonth(String progressMonth) {
        this.progressMonth = progressMonth;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public String getReporterName() {
        return reporterName;
    }

    public void setReporterName(String reporterName) {
        this.reporterName = reporterName;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public Double getProjectProgress() {
        return projectProgress;
    }

    public void setProjectProgress(Double projectProgress) {
        this.projectProgress = projectProgress;
    }

    public Integer getProductProgressId() {
        return productProgressId;
    }

    public void setProductProgressId(Integer productProgressId) {
        this.productProgressId = productProgressId;
    }

    public Double getProductProgress() {
        return productProgress;
    }

    public void setProductProgress(Double productProgress) {
        this.productProgress = productProgress;
    }

    public String getNodeids() {
        return nodeids;
    }

    public void setNodeids(String nodeids) {
        this.nodeids = nodeids;
    }

    public String getProgressNums() {
        return progressNums;
    }

    public void setProgressNums(String progressNums) {
        this.progressNums = progressNums;
    }

    public Date getFirstOnLineDate() {
        return firstOnLineDate;
    }

    public void setFirstOnLineDate(Date firstOnLineDate) {
        this.firstOnLineDate = firstOnLineDate;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getTermOfService() {
        return termOfService;
    }

    public void setTermOfService(Integer termOfService) {
        this.termOfService = termOfService;
    }

    public Integer getConstructionType() {
        return constructionType;
    }

    public void setConstructionType(Integer constructionType) {
        this.constructionType = constructionType;
    }

    public String getConstructionTypeName() {
        return constructionTypeName;
    }

    public void setConstructionTypeName(String constructionTypeName) {
        this.constructionTypeName = constructionTypeName;
    }

    public Integer getBusinessowner() {
        return businessowner;
    }

    public void setBusinessowner(Integer businessowner) {
        this.businessowner = businessowner;
    }

    public String getBusinessownerName() {
        return businessownerName;
    }

    public void setBusinessownerName(String businessownerName) {
        this.businessownerName = businessownerName;
    }
}
