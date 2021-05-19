package com.bsoft.office.project.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

public class AttendanceVO {
    private Integer id; //考勤ID
    private String personId; //员工工号
    @OperLogFieldName(value = "考勤日期")
    private Date attendanceDate; //考勤日期
    @OperLogFieldName(value = "日志提交时间")
    private Date submitDate; //日志提交时间
    @OperLogFieldName(value = "租房ID")
    private Integer rentId; //租房ID
    @OperLogFieldName(value = "出差标志")
    private Integer evection; //出差标志
    @OperLogFieldName(value = "住宿情况")
    private Integer stay;  //住宿情况
    @OperLogFieldName(value = "租房名称")
    private String rentName;//租房名称
    @OperLogFieldName(value = "工作日")
    private Boolean workDay;//工作日

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

    public Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public Integer getRentId() {
        return rentId;
    }

    public void setRentId(Integer rentId) {
        this.rentId = rentId;
    }

    public Integer getEvection() {
        return evection;
    }

    public void setEvection(Integer evection) {
        this.evection = evection;
    }

    public Integer getStay() {
        return stay;
    }

    public void setStay(Integer stay) {
        this.stay = stay;
    }

    public String getRentName() {
        return rentName;
    }

    public void setRentName(String rentName) {
        this.rentName = rentName;
    }

    public Boolean getWorkDay() {
        return workDay;
    }

    public void setWorkDay(Boolean workDay) {
        this.workDay = workDay;
    }
}
