package com.bsoft.office.project.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;

import java.util.List;
import java.util.Map;

/**
 * @Author: xucl
 * @DateTime: 2021/4/21 9:49
 * @Description:
 */
public class ReportProgressSaveVO {
    @OperLogFieldName(value = "进度id")
    private Integer progressId;
    @OperLogFieldName(value = "项目id")
    private String projectId;
    @OperLogFieldName(value = "月份")
    private String month;
    @OperLogFieldName(value = "上报人")
    private String reporter;
    @OperLogFieldName(value = "上报人姓名")
    private String reporterName;
    @OperLogFieldName(value = "上报类型")
    private Integer reportType;
    @OperLogFieldName(value = "产品清单节点数量")
    private List<ReportProgressSaveDetailVO> list;
    @OperLogFieldName(value = "产品清单的备注及最早上线日期")
    private List<ReportProgressSaveRemarksVO> remarks;

    public Integer getProgressId() {
        return progressId;
    }

    public void setProgressId(Integer progressId) {
        this.progressId = progressId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
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

    public Integer getReportType() {
        return reportType;
    }

    public void setReportType(Integer reportType) {
        this.reportType = reportType;
    }

    public List<ReportProgressSaveDetailVO> getList() {
        return list;
    }

    public void setList(List<ReportProgressSaveDetailVO> list) {
        this.list = list;
    }

    public List<ReportProgressSaveRemarksVO> getRemarks() {
        return remarks;
    }

    public void setRemarks(List<ReportProgressSaveRemarksVO> remarks) {
        this.remarks = remarks;
    }
}
