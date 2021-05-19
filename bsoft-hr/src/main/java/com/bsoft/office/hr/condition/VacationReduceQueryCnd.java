package com.bsoft.office.hr.condition;

import java.io.Serializable;

public class VacationReduceQueryCnd{
    private String  year;
    private Integer pageNo;
    private Integer pageSize;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
