package com.bsoft.office.system.vo;

import java.util.List;

public class RolePersonSaveVO {
    Integer roleId;
    List<String> orininal;
    List<String> newList;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public List<String> getOrininal() {
        return orininal;
    }

    public void setOrininal(List<String> orininal) {
        this.orininal = orininal;
    }

    public List<String> getNewList() {
        return newList;
    }

    public void setNewList(List<String> newList) {
        this.newList = newList;
    }
}
