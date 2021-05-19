package com.bsoft.office.manager.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;

/**
 * @Author: xucl
 * @DateTime: 2020/10/19 9:58
 * @Description:
 */
public class AuthorityVO {
    @OperLogFieldName(value = "id")
    private Integer id;
    @OperLogFieldName(value = "权限名称")
    private String name;
    @OperLogFieldName(value = "菜单id")
    private Integer menuId;
    @OperLogFieldName(value = "权限描述")
    private String describe;
    @OperLogFieldName(value = "权限key")
    private Integer key;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }
}
