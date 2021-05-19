package com.bsoft.office.hr.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;

import java.io.Serializable;

public class ExpertVO implements Serializable {
    @OperLogFieldName(value = "专家工号")
    private String expertId;
    @OperLogFieldName(value = "专家姓名")
    private String expertName;
    @OperLogFieldName(value = "所在部门")
    private String dept;
    @OperLogFieldName(value = "专家类型")
    private Integer type;
    @OperLogFieldName(value = "专家类型值")
    private String typeText;
    @OperLogFieldName(value = "专家ID")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExpertId() {
        return expertId;
    }

    public void setExpertId(String expertId) {
        this.expertId = expertId;
    }

    public String getExpertName() {
        return expertName;
    }

    public void setExpertName(String expertName) {
        this.expertName = expertName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getTypeText() {
        return typeText;
    }

    public void setTypeText(String typeText) {
        this.typeText = typeText;
    }
}
