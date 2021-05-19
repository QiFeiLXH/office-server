package com.bsoft.office.manager.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;

import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2020/7/21 9:36
 * @Description: app已绑定VO
 */
public class AppBoundVO {
    @OperLogFieldName(value = "工号")
    private String personId;
    @OperLogFieldName(value = "姓名")
    private String personName;
    @OperLogFieldName(value = "离职标志")
    private String logoff;
    @OperLogFieldName(value = "离职")
    private String logoffText;
    @OperLogFieldName(value = "设备号")
    private String appDevice;
    @OperLogFieldName(value = "头像")
    private String head;
    @OperLogFieldName(value = "部门代码")
    private String deptId;
    @OperLogFieldName(value = "部门名称")
    private String deptName;
    @OperLogFieldName(value = "邮箱")
    private String email;
    @OperLogFieldName(value = "手机号码")
    private String mobileNo;
    @OperLogFieldName(value = "拼音码")
    private String pinYinCode;
    @OperLogFieldName(value = "手机型号")
    private String phoneModel;
    @OperLogFieldName(value = "绑定日期")
    private Date appbindDate;
    @OperLogFieldName(value = "绑定地址")
    private String appRegistPlace;
    @OperLogFieldName(value = "手机系统")
    private String appMobileSystem;

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

    public String getLogoff() {
        return logoff;
    }

    public void setLogoff(String logoff) {
        this.logoff = logoff;
    }

    public String getLogoffText() {
        return logoffText;
    }

    public void setLogoffText(String logoffText) {
        this.logoffText = logoffText;
    }

    public String getAppDevice() {
        return appDevice;
    }

    public void setAppDevice(String appDevice) {
        this.appDevice = appDevice;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPinYinCode() {
        return pinYinCode;
    }

    public void setPinYinCode(String pinYinCode) {
        this.pinYinCode = pinYinCode;
    }

    public String getPhoneModel() {
        return phoneModel;
    }

    public void setPhoneModel(String phoneModel) {
        this.phoneModel = phoneModel;
    }

    public Date getAppbindDate() {
        return appbindDate;
    }

    public void setAppbindDate(Date appbindDate) {
        this.appbindDate = appbindDate;
    }

    public String getAppRegistPlace() {
        return appRegistPlace;
    }

    public void setAppRegistPlace(String appRegistPlace) {
        this.appRegistPlace = appRegistPlace;
    }

    public String getAppMobileSystem() {
        return appMobileSystem;
    }

    public void setAppMobileSystem(String appMobileSystem) {
        this.appMobileSystem = appMobileSystem;
    }
}
