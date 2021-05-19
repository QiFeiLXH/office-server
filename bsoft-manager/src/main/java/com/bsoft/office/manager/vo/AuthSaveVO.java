package com.bsoft.office.manager.vo;

import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.annotation.OperLogFieldName;

import java.util.List;
import java.util.Map;

/**
 * @Author: xucl
 * @DateTime: 2020/10/27 14:47
 * @Description:
 */
public class AuthSaveVO {
    @OperLogFieldName(value = "角色ID")
    private Integer roleId;
    @OperLogFieldName(value = "工号")
    private String personId;
    @OperLogFieldName(value = "系统ID")
    private Integer system;
    @OperLogFieldName(value = "菜单ID列表")
    private List<Integer> menuIds;
    @OperLogFieldName(value = "菜单权限")
    private List<Map> menuAuths;
    @OperLogFieldName(value = "菜单数据范围")
    private List<Map> menuRanges;
    @OperLogFieldName(value = "菜单部门权限")
    private List<Map> personDeptAuths;

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

    public Integer getSystem() {
        return system;
    }

    public void setSystem(Integer system) {
        this.system = system;
    }

    public List<Integer> getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(List<Integer> menuIds) {
        this.menuIds = menuIds;
    }

    public List<Map> getMenuAuths() {
        return menuAuths;
    }

    public void setMenuAuths(List<Map> menuAuths) {
        this.menuAuths = menuAuths;
    }

    public List<Map> getMenuRanges() {
        return menuRanges;
    }

    public void setMenuRanges(List<Map> menuRanges) {
        this.menuRanges = menuRanges;
    }

    public List<Map> getPersonDeptAuths() {
        return personDeptAuths;
    }

    public void setPersonDeptAuths(List<Map> personDeptAuths) {
        this.personDeptAuths = personDeptAuths;
    }
}
