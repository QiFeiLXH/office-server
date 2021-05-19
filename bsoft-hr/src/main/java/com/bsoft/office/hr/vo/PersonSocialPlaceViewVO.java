package com.bsoft.office.hr.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/11/26 13:05
 * @Description
 */
public class PersonSocialPlaceViewVO implements Serializable {
    /** 工号 */
    @OperLogFieldName(value = "员工工号")
    private String personId;
    @OperLogFieldName(value = "员工姓名")
    private String personName;
    /** 拼音简码 */
    @OperLogFieldName(value = "拼音简码")
    private String simpleCode;
    /** 部门id */
    @OperLogFieldName(value = "部门id")
    private String deptId;
    @OperLogFieldName(value = "部门名称")
    private String deptName;
    /** 是否离职 */
    @OperLogFieldName(value = "是否离职")
    private String valid;
    /** 社保缴纳地id */
    @OperLogFieldName(value = "现社保缴纳地id")
    private Integer nowPlace;
    @OperLogFieldName(value = "现社保缴纳地名称")
    private Integer place;
    /** 社保缴纳地名称 */
    @OperLogFieldName(value = "现社保缴纳地名称")
    private String nowPlaceName;
    @OperLogFieldName(value = "社保缴纳地名称")
    private String placeName;
    /** 社保缴纳地简称 */
    @OperLogFieldName(value = "社保缴纳地简称")
    private String abbreviation;
    /** 现社保缴纳地对接人id */
    @OperLogFieldName(value = "现社保缴纳地对接人id")
    private String nowMeeter;
    @OperLogFieldName(value = "现社保缴纳地对接人姓名")
    private String nowMeeterName;
    /** 社保缴纳地对接人id */
    @OperLogFieldName(value = "社保缴纳地对接人id")
    private String meeter;
    @OperLogFieldName(value = "社保缴纳地对接人姓名")
    private String meeterName;
    @OperLogFieldName(value = "月份")
    private Date month;

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

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public Integer getNowPlace() {
        return nowPlace;
    }

    public void setNowPlace(Integer nowPlace) {
        this.nowPlace = nowPlace;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    public String getNowPlaceName() {
        return nowPlaceName;
    }

    public void setNowPlaceName(String nowPlaceName) {
        this.nowPlaceName = nowPlaceName;
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

    public String getNowMeeter() {
        return nowMeeter;
    }

    public void setNowMeeter(String nowMeeter) {
        this.nowMeeter = nowMeeter;
    }

    public String getNowMeeterName() {
        return nowMeeterName;
    }

    public void setNowMeeterName(String nowMeeterName) {
        this.nowMeeterName = nowMeeterName;
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

    public Date getMonth() {
        return month;
    }

    public void setMonth(Date month) {
        this.month = month;
    }
}
