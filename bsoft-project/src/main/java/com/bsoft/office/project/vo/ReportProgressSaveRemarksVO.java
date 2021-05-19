package com.bsoft.office.project.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;

/**
 * @Author: xucl
 * @DateTime: 2021/4/26 19:02
 * @Description:
 */
public class ReportProgressSaveRemarksVO {
    @OperLogFieldName(value = "产品清单id")
    private Integer id;
    @OperLogFieldName(value = "备注")
    private String remarks;
    @OperLogFieldName(value = "最早上线日期")
    private String firstOnLineDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getFirstOnLineDate() {
        return firstOnLineDate;
    }

    public void setFirstOnLineDate(String firstOnLineDate) {
        this.firstOnLineDate = firstOnLineDate;
    }
}
