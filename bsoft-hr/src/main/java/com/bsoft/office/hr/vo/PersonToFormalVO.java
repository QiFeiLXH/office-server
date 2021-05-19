package com.bsoft.office.hr.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2021/2/1 8:52
 * @Description:
 */
public class PersonToFormalVO {
    @OperLogFieldName(value = "人员工号")
    private String personId;
    @OperLogFieldName(value = "姓名")
    private String personName;
    @OperLogFieldName(value = "部门代码")
    private String dept;
    @OperLogFieldName(value = "部门名称")
    private String deptName;
    @OperLogFieldName(value = "试用期(个月)")
    private Integer probation;
    @OperLogFieldName(value = "试用期结束日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date probationEndDate;
    @OperLogFieldName(value = "转正日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date toFormalDate;
    @OperLogFieldName(value = "状态")
    private Integer status;
    @OperLogFieldName(value = "拼音码")
    private String pym;
    @OperLogFieldName(value = "转正申请ID")
    private Integer turId;
    @OperLogFieldName(value = "考试方式")
    private String testMode;
    @OperLogFieldName(value = "转正方式")
    private Integer toformalType;
    @OperLogFieldName(value = "转正方式名称")
    private String toformalTypeText;

    public String getPym() {
        return pym;
    }

    public void setPym(String pym) {
        this.pym = pym;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getProbation() {
        return probation;
    }

    public void setProbation(Integer probation) {
        this.probation = probation;
    }

    public Date getProbationEndDate() {
        return probationEndDate;
    }

    public void setProbationEndDate(Date probationEndDate) {
        this.probationEndDate = probationEndDate;
    }

    public Date getToFormalDate() {
        return toFormalDate;
    }

    public void setToFormalDate(Date toFormalDate) {
        this.toFormalDate = toFormalDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTurId() {
        return turId;
    }

    public void setTurId(Integer turId) {
        this.turId = turId;
    }

    public String getTestMode() {
        return testMode;
    }

    public void setTestMode(String testMode) {
        this.testMode = testMode;
    }

    public Integer getToformalType() {
        return toformalType;
    }

    public void setToformalType(Integer toformalType) {
        this.toformalType = toformalType;
    }

    public String getToformalTypeText() {
        return toformalTypeText;
    }

    public void setToformalTypeText(String toformalTypeText) {
        this.toformalTypeText = toformalTypeText;
    }
}
