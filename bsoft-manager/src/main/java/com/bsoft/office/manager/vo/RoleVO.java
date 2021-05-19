package com.bsoft.office.manager.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;

/**
 * @Author: xucl
 * @DateTime: 2020/10/20 21:19
 * @Description:
 */
public class RoleVO {
    private Integer id;
    @OperLogFieldName(value = "上级ID")
    private Integer parentId;
    @OperLogFieldName(value = "角色名称")
    private String name;
    private String roleName;
    @OperLogFieldName(value = "sort")
    private Integer sort;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
