package com.bsoft.office.hr.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/11/27 14:40
 * @Description
 */
public class SocialAdjustmentRecordVO {
    @OperLogFieldName(value = "id")
    private Integer id;
    /**
     * 月份
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @OperLogFieldName(value = "月份")
    private Date month;
    /**
     * 社保缴纳地id
     */
    @OperLogFieldName(value = "社保缴纳地id")
    private Integer place;
    /**
     * 社保对接人工号
     */
    @OperLogFieldName(value = "社保对接人工号")
    private String meeter;
    /**
     * 社保对接人姓名
     */
    @OperLogFieldName(value = "社保对接人姓名")
    private String meeterName;
    /**
     * 登记人
     */
    @OperLogFieldName(value = "登记人")
    private String submitter;
    /**
     * 登记日期
     */
    @OperLogFieldName(value = "登记日期")
    private Date submitDate;
    /**
     * 工号
     */
    @OperLogFieldName(value = "工号")
    private String personId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getMonth() {
        return month;
    }

    public void setMonth(Date month) {
        this.month = month;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    public String getMeeter() {
        return meeter;
    }

    public void setMeeter(String meeter) {
        this.meeter = meeter;
    }

    public String getMeeterName() {
        return meeterName;
    }

    public void setMeeterName(String meeterName) {
        this.meeterName = meeterName;
    }

    public String getSubmitter() {
        return submitter;
    }

    public void setSubmitter(String submitter) {
        this.submitter = submitter;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }
}
