package com.bsoft.office.project.condition;

/**
 * @Author: xucl
 * @DateTime: 2021/4/29 13:56
 * @Description:
 */
public class ProjectProgressCountQueryCnd {
    /** 页码 */
    private Integer pageNo;
    /** 页量 */
    private Integer pageSize;
    /** 输入内容 */
    private String inputContent;
    /** 工号 */
    private String personId;
    /** 回款业绩部门*/
    private String deptNo;
    /** 进度经理 */
    private String progressManager;
    /** 是否上报  0否，1是，2全部*/
    private Integer reportFlag;

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

    public String getInputContent() {
        return inputContent;
    }

    public void setInputContent(String inputContent) {
        this.inputContent = inputContent;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public String getProgressManager() {
        return progressManager;
    }

    public void setProgressManager(String progressManager) {
        this.progressManager = progressManager;
    }

    public Integer getReportFlag() {
        return reportFlag;
    }

    public void setReportFlag(Integer reportFlag) {
        this.reportFlag = reportFlag;
    }
}
