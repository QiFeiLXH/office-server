package com.bsoft.office.project.vo;


/**
 * @Author Xuhui Lin
 * @Date 2021/4/7 16:11
 * @Description
 */
public class DeptProgressViewVO {
    /** 部门id */
    private String deptId;
    /** 部门名称 */
    private String deptName;
    /** 管理人 */
    private String manager;
    /** 管理人姓名 */
    private String managerName;
    /** 一级部门id */
    private String parentDeptId;
    /** 一级部门名称 */
    private String parentDeptName;
    /** 一级管理人 */
    private String regionManager;
    /** 一级管理人姓名 */
    private String regionManagerName;
    /** 备注 */
    private String remark;
    /** 注销 */
    private Integer logout;
    /** 类别 */
    private Integer type;
    /** 排序 */
    private Integer sortBy;

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

    public String getParentDeptId() {
        return parentDeptId;
    }

    public void setParentDeptId(String parentDeptId) {
        this.parentDeptId = parentDeptId;
    }

    public String getParentDeptName() {
        return parentDeptName;
    }

    public void setParentDeptName(String parentDeptName) {
        this.parentDeptName = parentDeptName;
    }

    public String getRegionManager() {
        return regionManager;
    }

    public void setRegionManager(String regionManager) {
        this.regionManager = regionManager;
    }

    public String getRegionManagerName() {
        return regionManagerName;
    }

    public void setRegionManagerName(String regionManagerName) {
        this.regionManagerName = regionManagerName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getLogout() {
        return logout;
    }

    public void setLogout(Integer logout) {
        this.logout = logout;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSortBy() {
        return sortBy;
    }

    public void setSortBy(Integer sortBy) {
        this.sortBy = sortBy;
    }
}
