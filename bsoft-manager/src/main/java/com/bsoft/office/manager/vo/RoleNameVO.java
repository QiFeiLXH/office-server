package com.bsoft.office.manager.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;

/**
 * @Auther: hy
 * @Date: 2020/8/3
 * @Description:
 */
public class RoleNameVO {
    private Integer id;
    @OperLogFieldName(value = "角色ID")
    private String role;
    @OperLogFieldName(value = "名称")
    private String roleName;
    @OperLogFieldName(value = "状态")
    private Integer status;
    @OperLogFieldName(value = "排序")
    private Integer sort;
    @OperLogFieldName(value = "来源")
    private Integer sourceType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }
}
