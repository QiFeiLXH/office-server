package com.bsoft.office.hr.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 调休请假表
 */

public class LeaveVO {
    /**
     *主键
     */
    @OperLogFieldName(value = "id")
    private Integer id;
    /**
     *请假开始日期
     */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "请假开始日期")
    private Date startDate;
    /**
     * 请假开始日期 上/下午请假标志 1.上午 2.下午
     */
    @OperLogFieldName(value = "请假开始标志")
    private Integer startFlag;
    /**
     *请假结束日期
     */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "请假结束日期")
    private Date endDate;
    /**
     * 请假结束日期 上/下午请假标志 1.上午 2.下午
     */
    @OperLogFieldName(value = "请假结束标志")
    private Integer endFlag;
    /**
     * 请假类型 1.年假  2.加班
     */
    @OperLogFieldName(value = "请假类型")
    private Integer type;
    /**
     * 请假天数 默认四小时
     */
    @OperLogFieldName(value = "请假天数")
    private Integer leaveTimes;
    /**
     * 申请日期
     */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "申请日期")
    private Date applyDate;
    /**
     * 请假原因
     */
    @OperLogFieldName(value = "请假原因")
    private String remark;
    /**
     * 申请人
     */
    @OperLogFieldName(value = "申请人")
    private String personId;
    /**
     * Oa流水号
     */
    @OperLogFieldName(value = "Oa流水号")
    private String lshid;
    /**
     * appid
     */
    @OperLogFieldName(value = "appid")
    private Integer appid;
    /**
     * 审核标志
     */
    @OperLogFieldName(value = "审核标志")
    private Integer auditFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getStartFlag() {
        return startFlag;
    }

    public void setStartFlag(Integer startFlag) {
        this.startFlag = startFlag;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getEndFlag() {
        return endFlag;
    }

    public void setEndFlag(Integer endFlag) {
        this.endFlag = endFlag;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getLeaveTimes() {
        return leaveTimes;
    }

    public void setLeaveTimes(Integer leaveTimes) {
        this.leaveTimes = leaveTimes;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getLshid() {
        return lshid;
    }

    public void setLshid(String lshid) {
        this.lshid = lshid;
    }

    public Integer getAppid() {
        return appid;
    }

    public void setAppid(Integer appid) {
        this.appid = appid;
    }

    public Integer getAuditFlag() {
        return auditFlag;
    }

    public void setAuditFlag(Integer auditFlag) {
        this.auditFlag = auditFlag;
    }
}
