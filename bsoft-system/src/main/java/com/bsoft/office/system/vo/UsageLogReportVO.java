package com.bsoft.office.system.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;

import java.io.Serializable;

public class UsageLogReportVO implements Serializable {
    @OperLogFieldName(value = "菜单ID")
    private Integer menuId;
    @OperLogFieldName(value = "菜单名称")
    private String name;
    @OperLogFieldName(value = "数量")
    private Long sl;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSl() {
        return sl;
    }

    public void setSl(Long sl) {
        this.sl = sl;
    }
}
