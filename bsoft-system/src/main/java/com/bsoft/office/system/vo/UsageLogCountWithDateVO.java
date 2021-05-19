package com.bsoft.office.system.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;

public class UsageLogCountWithDateVO{
    @OperLogFieldName(value = "菜单ID")
    private Integer menuId;//菜单ID
    @OperLogFieldName(value = "菜单名称")
    private String menuName;//菜单名称
    @OperLogFieldName(value = "点击次数")
    private Integer count;//点击次数
    @OperLogFieldName(value = "点击人数")
    private Integer personCount;//点击人数


    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPersonCount() {
        return personCount;
    }

    public void setPersonCount(Integer personCount) {
        this.personCount = personCount;
    }
}
