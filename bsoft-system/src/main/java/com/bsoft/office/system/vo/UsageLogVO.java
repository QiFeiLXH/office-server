package com.bsoft.office.system.vo;

import java.io.Serializable;
import java.util.Date;

public class UsageLogVO implements Serializable {
    private Integer menuId;
    private String personId;
    private Date useDate;
    private String ip;

    public Integer getMenuId() {
        return this.menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getPersonId() {
        return this.personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Date getUseDate() {
        return this.useDate;
    }

    public void setUseDate(Date useDate) {
        this.useDate = useDate;
    }

    public String getIp() {
        return this.ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
