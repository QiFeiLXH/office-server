package com.bsoft.office.manager.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;

import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2020/7/20 17:04
 * @Description: 解绑申请
 */
public class UnbindViewVO {
    @OperLogFieldName(value = "id")
    private Integer id;
    @OperLogFieldName(value = "申请人")
    private String personId;
    @OperLogFieldName(value = "申请人姓名")
    private String personName;
    @OperLogFieldName(value = "申请原因")
    private String reason;
    @OperLogFieldName(value = "审核标志")
    private Integer auditflag;
    @OperLogFieldName(value = "审核名称")
    private String auditflagText;
    @OperLogFieldName(value = "审核人")
    private String auditter;
    @OperLogFieldName(value = "审核人姓名")
    private String auditterText;
    @OperLogFieldName(value = "审核日期")
    private Date auditDate;
    @OperLogFieldName(value = "申请日期")
    private Date applyDate;
    @OperLogFieldName(value = "设备号")
    private String appDevice;
    @OperLogFieldName(value = "手机型号")
    private String phoneModel;
    @OperLogFieldName(value = "绑定日期")
    private Date appbindDate;

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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getAuditflag() {
        return auditflag;
    }

    public void setAuditflag(Integer auditflag) {
        this.auditflag = auditflag;
    }

    public String getAuditflagText() {
        return auditflagText;
    }

    public void setAuditflagText(String auditflagText) {
        this.auditflagText = auditflagText;
    }

    public String getAuditter() {
        return auditter;
    }

    public void setAuditter(String auditter) {
        this.auditter = auditter;
    }

    public String getAuditterText() {
        return auditterText;
    }

    public void setAuditterText(String auditterText) {
        this.auditterText = auditterText;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getAppDevice() {
        return appDevice;
    }

    public void setAppDevice(String appDevice) {
        this.appDevice = appDevice;
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
}
