package com.bsoft.office.project.vo;


/**
 * @Author Xuhui Lin
 * @Date 2021/4/6 16:50
 * @Description
 */

public class RegionProgressViewVO {
    /** 部门id */
    private String deptId;
    /** 部门名称 */
    private String deptName;
    /** 管理人 */
    private String manager;
    /** 管理人姓名 */
    private String managerName;
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
