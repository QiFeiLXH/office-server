package com.bsoft.office.organ.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;

/**
 * @author: LKH
 * @date: 2020/12/15
 * @description 岗位费用默认规则
 */
public class PostAndCostRuleVO {
    /** id*/
    @OperLogFieldName(value = "id")
    private  Integer id;
    /** 岗位类别ID*/
    @OperLogFieldName(value = "岗位类别ID")
    private  Integer postType;
    /** 岗位类别名称*/
    @OperLogFieldName(value = "岗位类别名称")
    private  String  postName;
    /** 费用类别ID*/
    @OperLogFieldName(value = "费用类别ID")
    private  Integer costType;
    /** 费用类别名称*/
    @OperLogFieldName(value = "费用类别名称")
    private  String  costName;
    /** 财务类别ID*/
    @OperLogFieldName(value = "财务类别ID")
    private  Integer financialType;
    /** 财务类别名称*/
    @OperLogFieldName(value = "财务类别名称")
    private  String  financialName;

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getCostName() {
        return costName;
    }

    public void setCostName(String costName) {
        this.costName = costName;
    }

    public String getFinancialName() {
        return financialName;
    }

    public void setFinancialName(String financialName) {
        this.financialName = financialName;
    }



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

    public Integer getCostType() {
        return costType;
    }

    public void setCostType(Integer costType) {
        this.costType = costType;
    }

    public Integer getFinancialType() {
        return financialType;
    }

    public void setFinancialType(Integer financialType) {
        this.financialType = financialType;
    }
}
