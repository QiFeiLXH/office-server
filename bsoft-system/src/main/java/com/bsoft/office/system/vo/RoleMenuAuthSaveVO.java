package com.bsoft.office.system.vo;

import java.util.List;
import java.util.Map;

public class RoleMenuAuthSaveVO {
    private Integer roleId;
    private List<Integer> menuIds;
    private List<Map> authInfo;
    private Integer system;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public List<Integer> getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(List<Integer> menuIds) {
        this.menuIds = menuIds;
    }

    public List<Map> getAuthInfo() {
        return authInfo;
    }

    public void setAuthInfo(List<Map> authInfo) {
        this.authInfo = authInfo;
    }

    public Integer getSystem() {
        return system;
    }

    public void setSystem(Integer system) {
        this.system = system;
    }
}
