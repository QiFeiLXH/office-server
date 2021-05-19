package com.bsoft.office.organ.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2021/3/4 10:04
 * @Description:
 */
public class DeptCostTypeViewVO {
    @OperLogFieldName(value = "年份")
    private Integer year;
    @OperLogFieldName(value = "部门代码")
    private String dept;
    @OperLogFieldName(value = "部门名称")
    private String deptName;
    @OperLogFieldName(value = "登记人")
    private String registrant;
    @OperLogFieldName(value = "登记日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date registrantDate;
    @OperLogFieldName(value = "费用类别")
    private String costTypes;
    @OperLogFieldName(value = "默认费用类别")
    private Integer costType;
    @OperLogFieldName(value = "部门类别")
    private Integer deptType;
    @OperLogFieldName(value = "核算口径归属")
    private String accountcalibers;
    @OperLogFieldName(value = "一级部门")
    private String parentDept;
    @OperLogFieldName(value = "一级部门名称")
    private String parentDeptName;
    @OperLogFieldName(value = "部门类别名称")
    private String deptTypeName;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
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

    public String getRegistrant() {
        return registrant;
    }

    public void setRegistrant(String registrant) {
        this.registrant = registrant;
    }

    public Date getRegistrantDate() {
        return registrantDate;
    }

    public void setRegistrantDate(Date registrantDate) {
        this.registrantDate = registrantDate;
    }

    public String getCostTypes() {
        return costTypes;
    }

    public void setCostTypes(String costTypes) {
        this.costTypes = costTypes;
    }

    public Integer getCostType() {
        return costType;
    }

    public void setCostType(Integer costType) {
        this.costType = costType;
    }

    public Integer getDeptType() {
        return deptType;
    }

    public void setDeptType(Integer deptType) {
        this.deptType = deptType;
    }

    public String getAccountcalibers() {
        return accountcalibers;
    }

    public void setAccountcalibers(String accountcalibers) {
        this.accountcalibers = accountcalibers;
    }

    public String getParentDept() {
        return parentDept;
    }

    public void setParentDept(String parentDept) {
        this.parentDept = parentDept;
    }

    public String getParentDeptName() {
        return parentDeptName;
    }

    public void setParentDeptName(String parentDeptName) {
        this.parentDeptName = parentDeptName;
    }

    public String getDeptTypeName() {
        return deptTypeName;
    }

    public void setDeptTypeName(String deptTypeName) {
        this.deptTypeName = deptTypeName;
    }
}
