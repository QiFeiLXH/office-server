package com.bsoft.office.hr.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;

import java.io.Serializable;

public class PersonCompanyVO{
    @OperLogFieldName(value = "所属公司")
    private Integer company;
    @OperLogFieldName(value = "所属公司名称")
    private String companyText;

    public Integer getCompany() {
        return company;
    }

    public void setCompany(Integer company) {
        this.company = company;
    }

    public String getCompanyText() {
        return companyText;
    }

    public void setCompanyText(String companyText) {
        this.companyText = companyText;
    }
}
