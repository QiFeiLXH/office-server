package com.bsoft.office.organ.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author: LKH
 * @date: 2020/12/15
 * @description 岗位费用默认规则
 */
public class DeptCostMaintainVO {
    private  Integer id;
    @OperLogFieldName(value = "岗位类别")
    private  Integer postType;
    @OperLogFieldName(value = "岗位类别名称")
    private  String  postName;
    @OperLogFieldName(value = "财务类别")
    private  Integer financialType;
    @OperLogFieldName(value = "财务类别名称")
    private  String  financialName;
    @OperLogFieldName(value = "部门")
    private  String  dept;
    @OperLogFieldName(value = "调整类型")
    private  Integer type;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "调整时间")
    private  Date adjustDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPostType() {
        return postType;
    }

    public void setPostType(Integer postType) {
        this.postType = postType;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public Integer getFinancialType() {
        return financialType;
    }

    public void setFinancialType(Integer financialType) {
        this.financialType = financialType;
    }

    public String getFinancialName() {
        return financialName;
    }

    public void setFinancialName(String financialName) {
        this.financialName = financialName;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getAdjustDate() {
        return adjustDate;
    }

    public void setAdjustDate(Date adjustDate) {
        this.adjustDate = adjustDate;
    }
}
