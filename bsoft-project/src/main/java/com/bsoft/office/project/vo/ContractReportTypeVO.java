package com.bsoft.office.project.vo;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2021/5/6 18:56
 * @Description:
 */
public class ContractReportTypeVO {
    private Integer reportType;
    private String name;
    private Integer type;
    private List<ProProgressNodeVO> headers;

    public Integer getReportType() {
        return reportType;
    }

    public void setReportType(Integer reportType) {
        this.reportType = reportType;
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
