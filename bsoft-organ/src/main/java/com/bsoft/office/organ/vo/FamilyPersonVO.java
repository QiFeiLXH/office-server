package com.bsoft.office.organ.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

import java.io.Serializable;

public class FamilyPersonVO implements Serializable {
    private Integer id;
    private Integer zpid;
    @OperLogFieldName(value = "称谓")
    private Integer appellation;
    @OperLogFieldName(value = "称谓文本")
    private String appellationText;
    @OperLogFieldName(value = "姓名")
    private String name;
    @OperLogFieldName(value = "年龄")
    private Integer age;
    @OperLogFieldName(value = "工作单位及岗位职务")
    private String company;
    @OperLogFieldName(value = "电话")
    private String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getZpid() {
        return zpid;
    }

    public void setZpid(Integer zpid) {
        this.zpid = zpid;
    }

    public Integer getAppellation() {
        return appellation;
    }

    public void setAppellation(Integer appellation) {
        this.appellation = appellation;
    }

    public String getAppellationText() {
        return appellationText;
    }

    public void setAppellationText(String appellationText) {
        this.appellationText = appellationText;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
