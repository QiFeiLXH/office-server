package com.bsoft.office.sales.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.bsoft.workflow.dto.TaskDTO;

import java.io.Serializable;
import java.util.Date;

public class SalesCluesTaskVO extends TaskVO {
    /**
     * 签单概率
     */
    @OperLogFieldName(value = "签单概率")
    private Integer signProbability;

    /**
     * 预计签约时间
     */
    @OperLogFieldName(value = "预计签约时间")
    private String signTime;

    /**
     * 预计软件额
     */
    @OperLogFieldName(value = "预计软件额")
    private Double softwareAmount;

    /**
     * 预计首款
     */
    @OperLogFieldName(value = "预计首款")
    private Double firstAmount;

    /**
     * 跟单人
     */
    @OperLogFieldName(value = "跟单人")
    private String trackPerson;

    public Integer getSignProbability() {
        return signProbability;
    }

    public void setSignProbability(Integer signProbability) {
        this.signProbability = signProbability;
    }

    public String getSignTime() {
        return signTime;
    }

    public void setSignTime(String signTime) {
        this.signTime = signTime;
    }

    public Double getSoftwareAmount() {
        return softwareAmount;
    }

    public void setSoftwareAmount(Double softwareAmount) {
        this.softwareAmount = softwareAmount;
    }

    public Double getFirstAmount() {
        return firstAmount;
    }

    public void setFirstAmount(Double firstAmount) {
        this.firstAmount = firstAmount;
    }

    public String getTrackPerson() {
        return trackPerson;
    }

    public void setTrackPerson(String trackPerson) {
        this.trackPerson = trackPerson;
    }
}
