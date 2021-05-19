package com.bsoft.office.hr.condition;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2021/1/21 10:57
 * @Description:
 */
public class BackAttendanceParam {
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date month;
    private List<String> personIds;

    public Date getMonth() {
        return month;
    }

    public void setMonth(Date month) {
        this.month = month;
    }

    public List<String> getPersonIds() {
        return personIds;
    }

    public void setPersonIds(List<String> personIds) {
        this.personIds = personIds;
    }
}
