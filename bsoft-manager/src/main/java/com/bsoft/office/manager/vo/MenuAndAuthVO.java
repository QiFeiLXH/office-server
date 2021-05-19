package com.bsoft.office.manager.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/10/19 9:58
 * @Description:
 */
public class MenuAndAuthVO {
    @OperLogFieldName(value = "菜单ID")
    private Integer id;
    @OperLogFieldName(value = "菜单名称")
    private String name;
    @OperLogFieldName(value = "上级菜单ID")
    private Integer parentId;
    @OperLogFieldName(value = "图标")
    private String icon;
    @OperLogFieldName(value = "url路径")
    private String object;
    @OperLogFieldName(value = "公用标志")
    private Integer pubFlag;
    @OperLogFieldName(value = "排序")
    private Integer sort;
    @OperLogFieldName(value = "系统ID")
    private Integer system;
    @OperLogFieldName(value = "在用标志")
    private Integer active;
    @OperLogFieldName(value = "组件")
    private String component;
    @OperLogFieldName(value = "权限相关")
    private String permisionid;
    @OperLogFieldName(value = "权限范围")
    private Integer range;
    @OperLogFieldName(value = "权限备注")
    private String remark;
    @OperLogFieldName(value = "帮助文档ID")
    private Integer help;//帮助文档ID
    @OperLogFieldName(value = "请求前缀")
    private String prefix;
    @OperLogFieldName(value = "帮助文档名称")
    private String fileName;
    private List<MenuAndAuthVO> child;
    private List<AuthorityVO> auth;

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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public Integer getPubFlag() {
        return pubFlag;
    }

    public void setPubFlag(Integer pubFlag) {
        this.pubFlag = pubFlag;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getSystem() {
        return system;
    }

    public void setSystem(Integer system) {
        this.system = system;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getPermisionid() {
        return permisionid;
    }

    public void setPermisionid(String permisionid) {
        this.permisionid = permisionid;
    }

    public Integer getRange() {
        return range;
    }

    public void setRange(Integer range) {
        this.range = range;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getHelp() {
        return help;
    }

    public void setHelp(Integer help) {
        this.help = help;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public List<MenuAndAuthVO> getChild() {
        return child;
    }

    public void setChild(List<MenuAndAuthVO> child) {
        this.child = child;
    }

    public List<AuthorityVO> getAuth() {
        return auth;
    }

    public void setAuth(List<AuthorityVO> auth) {
        this.auth = auth;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
