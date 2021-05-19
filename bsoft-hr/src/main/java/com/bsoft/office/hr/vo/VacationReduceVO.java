package com.bsoft.office.hr.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;

import java.io.Serializable;
import java.util.Date;

public class VacationReduceVO{
    /**
     * 主键
     */
    @OperLogFieldName(value = "ID")
    private Integer id;
    /**
     * 使用年份
     */
    @OperLogFieldName(value = "使用年份")
    private String year;
    /**
     * 使用年假天数
     */
    @OperLogFieldName(value = "使用年假天数")
    private Integer days;
    /**
     * 备注
     */
    @OperLogFieldName(value = "备注")
    private String remark;
    /**
     * 登记人
     */
    @OperLogFieldName(value = "登记人")
    private String registrant;
    /**
     * 登记时间
     */
    @OperLogFieldName(value = "登记时间")
    private Date registDate;

    /**
     * 执行标志 0.未执行  1.已执行
     */
    @OperLogFieldName(value = "执行标志")
    private Integer flag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRegistrant() {
        return registrant;
    }

    public void setRegistrant(String registrant) {
        this.registrant = registrant;
    }

    public Date getRegistDate() {
        return registDate;
    }

    public void setRegistDate(Date registDate) {
        this.registDate = registDate;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}
