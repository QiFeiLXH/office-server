package com.bsoft.office.project.vo;

import java.io.Serializable;

/**
 * @Author Xuhui Lin
 * @Date 2021/4/6 16:41
 * @Description
 */
public class ProjectProgressManagerVO {
    /** id */
    private Integer id;
    /** 部门id */
    private String deptId;
    /** 部门名称 */
    private String deptName;
    /** 上级部门id */
    private String parentDeptId;
    /** 管理人 */
    private String manager;
    /** 管理人姓名 */
    private String managerName;
    /** 备注 */
    private String remark;
    /** 类别 */
    private Integer type;
    /** 注销 */
    private Integer logout;
    /** 排序 */
    private Integer sortBy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getParentDeptId() {
        return parentDeptId;
    }

    public void setParentDeptId(String parentDeptId) {
        this.parentDeptId = parentDeptId;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getLogout() {
        return logout;
    }

    public void setLogout(Integer logout) {
        this.logout = logout;
    }

    public Integer getSortBy() {
        return sortBy;
    }

    public void setSortBy(Integer sortBy) {
        this.sortBy = sortBy;
    }
}
