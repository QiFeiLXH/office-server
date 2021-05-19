package com.bsoft.office.hr.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.bsoft.office.common.annotation.OperLogFieldName;

/**
 * @Author: xucl
 * @DateTime: 2021/1/20 10:42
 * @Description:
 */
@ExcelIgnoreUnannotated
public class AttendanceStatisticsVO {
    @ExcelProperty(value = "人员编号", index = 2)
    @OperLogFieldName(value = "工号")
    private String personId;
    @ExcelProperty(value = "姓名", index = 1)
    @OperLogFieldName(value = "姓名")
    private String personName;
    @OperLogFieldName(value = "部门代码")
    private String dept;
    @ExcelProperty(value = "部门名称", index = 0)
    @OperLogFieldName(value = "部门名称")
    private String deptName;
    @ExcelProperty(value = "正常出勤", index = 4)
    @OperLogFieldName(value = "正常出勤")
    private Double ts1;
    @ExcelProperty(value = "出差", index = 5)
    @OperLogFieldName(value = "出差")
    private Double ts2;
    @ExcelProperty(value = "迟到", index = 6)
    @OperLogFieldName(value = "迟到")
    private Double ts3;
    @ExcelProperty(value = "早退", index = 7)
    @OperLogFieldName(value = "早退")
    private Double ts4;
    @ExcelProperty(value = "旷工", index = 8)
    @OperLogFieldName(value = "旷工")
    private Double ts5;
    @ExcelProperty(value = "事假", index = 9)
    @OperLogFieldName(value = "事假")
    private Double ts6;
    @ExcelProperty(value = "病假", index = 10)
    @OperLogFieldName(value = "病假")
    private Double ts7;
    @ExcelProperty(value = "丧假", index = 11)
    @OperLogFieldName(value = "丧假")
    private Double ts8;
    @ExcelProperty(value = "婚假", index = 12)
    @OperLogFieldName(value = "婚假")
    private Double ts9;
    @ExcelProperty(value = "产假", index = 13)
    @OperLogFieldName(value = "产假")
    private Double ts10;
    @ExcelProperty(value = "护理假", index = 14)
    @OperLogFieldName(value = "护理假")
    private Double ts11;
    @ExcelProperty(value = "调休", index = 15)
    @OperLogFieldName(value = "调休")
    private Double ts12;
    @ExcelProperty(value = "年休", index = 16)
    @OperLogFieldName(value = "年休")
    private Double ts13;
    @ExcelProperty(value = "离职", index = 17)
    @OperLogFieldName(value = "离职")
    private Double ts16;
    private Integer sdbz;
    private String flag;
    private String xdno;
    private String xdnoName;
    @ExcelProperty(value = "产检假", index = 18)
    @OperLogFieldName(value = "产检假")
    private Double ts17;
    @ExcelProperty(value = "长病假", index = 19)
    @OperLogFieldName(value = "长病假")
    private Double ts19;
    @ExcelProperty(value = "考勤天数", index = 3)
    @OperLogFieldName(value = "考勤天数")
    private Double attendAnceCountDays;
    @OperLogFieldName(value = "异常考勤日期")
    private String abnormalDay;

    public Double getTs17() {
        return ts17;
    }

    public void setTs17(Double ts17) {
        this.ts17 = ts17;
    }

    public Double getTs19() {
        return ts19;
    }

    public void setTs19(Double ts19) {
        this.ts19 = ts19;
    }

    public Double getAttendAnceCountDays() {
        return attendAnceCountDays;
    }

    public void setAttendAnceCountDays(Double attendAnceCountDays) {
        this.attendAnceCountDays = attendAnceCountDays;
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

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Double getTs1() {
        return ts1;
    }

    public void setTs1(Double ts1) {
        this.ts1 = ts1;
    }

    public Double getTs2() {
        return ts2;
    }

    public void setTs2(Double ts2) {
        this.ts2 = ts2;
    }

    public Double getTs3() {
        return ts3;
    }

    public void setTs3(Double ts3) {
        this.ts3 = ts3;
    }

    public Double getTs4() {
        return ts4;
    }

    public void setTs4(Double ts4) {
        this.ts4 = ts4;
    }

    public Double getTs5() {
        return ts5;
    }

    public void setTs5(Double ts5) {
        this.ts5 = ts5;
    }

    public Double getTs6() {
        return ts6;
    }

    public void setTs6(Double ts6) {
        this.ts6 = ts6;
    }

    public Double getTs7() {
        return ts7;
    }

    public void setTs7(Double ts7) {
        this.ts7 = ts7;
    }

    public Double getTs8() {
        return ts8;
    }

    public void setTs8(Double ts8) {
        this.ts8 = ts8;
    }

    public Double getTs9() {
        return ts9;
    }

    public void setTs9(Double ts9) {
        this.ts9 = ts9;
    }

    public Double getTs10() {
        return ts10;
    }

    public void setTs10(Double ts10) {
        this.ts10 = ts10;
    }

    public Double getTs11() {
        return ts11;
    }

    public void setTs11(Double ts11) {
        this.ts11 = ts11;
    }

    public Double getTs12() {
        return ts12;
    }

    public void setTs12(Double ts12) {
        this.ts12 = ts12;
    }

    public Double getTs16() {
        return ts16;
    }

    public void setTs16(Double ts16) {
        this.ts16 = ts16;
    }

    public Integer getSdbz() {
        return sdbz;
    }

    public void setSdbz(Integer sdbz) {
        this.sdbz = sdbz;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getXdno() {
        return xdno;
    }

    public void setXdno(String xdno) {
        this.xdno = xdno;
    }

    public String getXdnoName() {
        return xdnoName;
    }

    public void setXdnoName(String xdnoName) {
        this.xdnoName = xdnoName;
    }

    public Double getTs13() {
        return ts13;
    }

    public void setTs13(Double ts13) {
        this.ts13 = ts13;
    }

    public String getAbnormalDay() {
        return abnormalDay;
    }

    public void setAbnormalDay(String abnormalDay) {
        this.abnormalDay = abnormalDay;
    }
}
