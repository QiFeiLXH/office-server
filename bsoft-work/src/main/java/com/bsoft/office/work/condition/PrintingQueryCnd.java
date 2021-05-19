package com.bsoft.office.work.condition;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/27 14:58
 * @Description
 */
public class PrintingQueryCnd {
    private Integer pageNo;
    private Integer pageSize;
    @DateTimeFormat(pattern = "yyyy-MM-dd" )
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd" )
    private Date endDate;
    private String inputContent;
    private String deptId;
    private Integer status;

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

    public String getInputContent() {
        return inputContent;
    }

    public void setInputContent(String inputContent) {
        this.inputContent = inputContent;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
