package com.bsoft.office.hr.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/14 9:44
 * @Description
 */
@ExcelIgnoreUnannotated
public class PersonStockViewVO {
    @OperLogFieldName(value = "id")
    private Integer id;
    /** 工号 */
    @OperLogFieldName(value = "工号")
    private String personId;
    /** 姓名 */
    @ExcelProperty(value = "姓名", index = 0)
    @OperLogFieldName(value = "姓名")
    private String personName;
    /** 拼音简码 */
    @OperLogFieldName(value = "拼音简码")
    private String simpleCode;
    /** 部门id */
    @OperLogFieldName(value = "部门id")
    private String deptId;
    /** 部门名称 */
    @ExcelProperty(value = "部门", index = 1)
    @OperLogFieldName(value = "部门名称")
    private String deptName;
    /** 在离职 */
    @OperLogFieldName(value = "状态")
    private String flag;
    @ExcelProperty(value = "状态", index = 2)
    @OperLogFieldName(value = "状态字典值")
    private String flagText;
    /** 登记人 */
    @OperLogFieldName(value = "登记人工号")
    private String register;
    @ExcelProperty(value = "登记人员", index = 4)
    @OperLogFieldName(value = "登记人员")
    private String registerName;
    /** 登记日期 */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @ExcelProperty(value = "登记日期", index = 5)
    @DateTimeFormat("yyyy-MM-dd")
    @OperLogFieldName(value = "登记日期")
    private Date registerDate;
    /** 离职日期 */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @ExcelProperty(value = "离职日期", index = 3)
    @DateTimeFormat("yyyy-MM-dd")
    @OperLogFieldName(value = "离职日期")
    private Date resignationDate;
    /** 备注 */
    @ExcelProperty(value = "备注", index = 6)
    @OperLogFieldName(value = "备注")
    private String remark;
    /** 注销 */
    @OperLogFieldName(value = "注销")
    private Integer logout;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getSimpleCode() {
        return simpleCode;
    }

    public void setSimpleCode(String simpleCode) {
        this.simpleCode = simpleCode;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getFlagText() {
        return flagText;
    }

    public void setFlagText(String flagText) {
        this.flagText = flagText;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public String getRegisterName() {
        return registerName;
    }

    public void setRegisterName(String registerName) {
        this.registerName = registerName;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Date getResignationDate() {
        return resignationDate;
    }

    public void setResignationDate(Date resignationDate) {
        this.resignationDate = resignationDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getLogout() {
        return logout;
    }

    public void setLogout(Integer logout) {
        this.logout = logout;
    }
}
