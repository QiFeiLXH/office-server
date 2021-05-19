package com.bsoft.office.hr.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;

/**
 * @Author: xucl
 * @DateTime: 2021/2/1 8:52
 * @Description:
 */
public class PersonToFormalCountVO {
    @OperLogFieldName(value = "月份")
    private String month;
    @OperLogFieldName(value = "总共需要转正人数")
    private Integer need;
    @OperLogFieldName(value = "已转正人数")
    private Integer hasToFormal;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getNeed() {
        return need;
    }

    public void setNeed(Integer need) {
        this.need = need;
    }

    public Integer getHasToFormal() {
        return hasToFormal;
    }

    public void setHasToFormal(Integer hasToFormal) {
        this.hasToFormal = hasToFormal;
    }
}
