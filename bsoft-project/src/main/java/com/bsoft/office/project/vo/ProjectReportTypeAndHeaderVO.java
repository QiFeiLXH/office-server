package com.bsoft.office.project.vo;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2021/5/6 11:14
 * @Description:
 */
public class ProjectReportTypeAndHeaderVO {
    private Integer reportType;
    private String projectId;
    private String name;
    private Integer type;
    private List<ProProgressNodeVO> headers;

    public Integer getReportType() {
        return reportType;
    }

    public void setReportType(Integer reportType) {
        this.reportType = reportType;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<ProProgressNodeVO> getHeaders() {
        return headers;
    }

    public void setHeaders(List<ProProgressNodeVO> headers) {
        this.headers = headers;
    }
}
