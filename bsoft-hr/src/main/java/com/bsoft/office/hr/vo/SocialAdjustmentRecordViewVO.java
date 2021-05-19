package com.bsoft.office.hr.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/11/27 14:40
 * @Description
 */
public class SocialAdjustmentRecordViewVO {
    @OperLogFieldName(value = "id")
    private Integer id;
    /** 月份 */
    @JsonFormat(pattern="yyyy-MM",timezone = "GMT+8")
    @OperLogFieldName(value = "月份")
    private Date month;
    /** 社保缴纳地id */
    @OperLogFieldName(value = "社保缴纳地id")
    private Integer place;
    /** 社保对接人工号 */
    @OperLogFieldName(value = "社保对接人工号")
    private String meeter;
    /** 社保对接人姓名 */
    @OperLogFieldName(value = "社保对接人姓名")
    private String meeterName;
    /** 登记人 */
    @OperLogFieldName(value = "登记人")
    private String submitter;
    @OperLogFieldName(value = "登记人名字")
    private String submitterName;
    /** 登记日期 */
    @OperLogFieldName(value = "登记日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date submitDate;
    /** 缴纳地名称 */
    @OperLogFieldName(value = "缴纳地名称")
    private String placeName;
    /** 缴纳地简称 */
    @OperLogFieldName(value = "缴纳地简称")
    private String abbreviation;

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

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getSubmitterName() {
        return submitterName;
    }

    public void setSubmitterName(String submitterName) {
        this.submitterName = submitterName;
    }
}
