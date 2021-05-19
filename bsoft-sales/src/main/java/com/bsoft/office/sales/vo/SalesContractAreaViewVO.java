package com.bsoft.office.sales.vo;


import com.bsoft.office.common.annotation.OperLogFieldName;
import com.bsoft.sales.dto.SalesContractAreaDTO;

import java.io.Serializable;
import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2021/3/29 17:01
 * @Description
 */
public class SalesContractAreaViewVO {
    /** 部门id */
    @OperLogFieldName(value = "部门id")
    private String deptId;
    /** 部门名称 */
    @OperLogFieldName(value = "部门名称")
    private String deptName;
    /** 上级部门id */
    @OperLogFieldName(value = "上级部门id")
    private String parentDeptId;
    /** 未审数量 */
    @OperLogFieldName(value = "未审数量")
    private Integer unreviewedCount;
    /** 未关联数量 */
    @OperLogFieldName(value = "未关联数量")
    private Integer notassociatedCount;
    @OperLogFieldName(value = "子部门")
    private List<SalesContractAreaViewVO> children;

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

    public Integer getUnreviewedCount() {
        return unreviewedCount;
    }

    public void setUnreviewedCount(Integer unreviewedCount) {
        this.unreviewedCount = unreviewedCount;
    }

    public Integer getNotassociatedCount() {
        return notassociatedCount;
    }

    public void setNotassociatedCount(Integer notassociatedCount) {
        this.notassociatedCount = notassociatedCount;
    }

    public List<SalesContractAreaViewVO> getChildren() {
        return children;
    }

    public void setChildren(List<SalesContractAreaViewVO> children) {
        this.children = children;
    }
}
