package com.bsoft.office.hr.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2021/1/21 14:47
 * @Description:
 */
public class AttendanceCountDetailVO {
    @OperLogFieldName(value = "工号")
    private String personId;
    @OperLogFieldName(value = "姓名")
    private String personName;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "考勤日期")
    private Date attendanceDate;
    @OperLogFieldName(value = "上班时间")
    private Date goWorkTime;
    @OperLogFieldName(value = "下班时间")
    private Date offWorkTime;
    @OperLogFieldName(value = "上午考勤类别")
    private String attendanceTypeAm;
    @OperLogFieldName(value = "上午考勤类别名称")
    private String attendanceTypeAmText;
    @OperLogFieldName(value = "下午考勤类别")
    private String attendanceTypeBm;
    @OperLogFieldName(value = "下午考勤类别名称")
    private String attendanceTypeBmText;
    @OperLogFieldName(value = "补充说明")
    private String supplementNotes;
    @OperLogFieldName(value = "考勤说明")
    private String AttendanceNotes;

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

    public Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public Date getGoWorkTime() {
        return goWorkTime;
    }

    public void setGoWorkTime(Date goWorkTime) {
        this.goWorkTime = goWorkTime;
    }

    public Date getOffWorkTime() {
        return offWorkTime;
    }

    public void setOffWorkTime(Date offWorkTime) {
        this.offWorkTime = offWorkTime;
    }

    public String getAttendanceTypeAm() {
        return attendanceTypeAm;
    }

    public void setAttendanceTypeAm(String attendanceTypeAm) {
        this.attendanceTypeAm = attendanceTypeAm;
    }

    public String getAttendanceTypeAmText() {
        return attendanceTypeAmText;
    }

    public void setAttendanceTypeAmText(String attendanceTypeAmText) {
        this.attendanceTypeAmText = attendanceTypeAmText;
    }

    public String getAttendanceTypeBm() {
        return attendanceTypeBm;
    }

    public void setAttendanceTypeBm(String attendanceTypeBm) {
        this.attendanceTypeBm = attendanceTypeBm;
    }

    public String getAttendanceTypeBmText() {
        return attendanceTypeBmText;
    }

    public void setAttendanceTypeBmText(String attendanceTypeBmText) {
        this.attendanceTypeBmText = attendanceTypeBmText;
    }

    public String getSupplementNotes() {
        return supplementNotes;
    }

    public void setSupplementNotes(String supplementNotes) {
        this.supplementNotes = supplementNotes;
    }

    public String getAttendanceNotes() {
        return AttendanceNotes;
    }

    public void setAttendanceNotes(String attendanceNotes) {
        AttendanceNotes = attendanceNotes;
    }
}
