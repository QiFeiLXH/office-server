package com.bsoft.office.manager.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;

/**
 * @Author: xucl
 * @DateTime: 2020/10/22 10:20
 * @Description:
 */
public class RolePersonVO {
    @OperLogFieldName(value = "角色ID")
    private Integer roleId;
    @OperLogFieldName(value = "工号")
    private String personId;
    @OperLogFieldName(value = "姓名")
    private String personName;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
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
}
