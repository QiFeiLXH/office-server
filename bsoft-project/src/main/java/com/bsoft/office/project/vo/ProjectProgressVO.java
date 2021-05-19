package com.bsoft.office.project.vo;

import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2021/5/12 18:58
 * @Description:
 */
public class ProjectProgressVO {
    private Integer id;
    private String projectId;
    private Date progressMonth;
    private String reporter;
    private String reporterName;
    private Date reportDate;
    private Double progress;

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

    public Date getProgressMonth() {
        return progressMonth;
    }

    public void setProgressMonth(Date progressMonth) {
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

    public Double getProgress() {
        return progress;
    }

    public void setProgress(Double progress) {
        this.progress = progress;
    }
}
