package com.bsoft.office.project.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;

/**
 * @Author: xucl
 * @DateTime: 2021/4/19 19:42
 * @Description:
 */
public class ProjectReportTypeViewVO {
    @OperLogFieldName(value = "上报分类")
    private Integer reportType;
    @OperLogFieldName(value = "项目ID")
    private String projectId;
    @OperLogFieldName(value = "上报分类名称")
    private String name;
    @OperLogFieldName(value = "上报分类的类型")
    private Integer type;

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
}
