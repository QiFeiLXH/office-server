package com.bsoft.office.manager.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.List;
import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2020/11/26 11:08
 * @Description:
 */
public class CompanyViewVO {
    @OperLogFieldName(value = "公司ID")
    private Integer companyId;
    @OperLogFieldName(value = "公司名称")
    private String companyName;
    @OperLogFieldName(value = "上级公司ID")
    private Integer parentCompanyId;
    @OperLogFieldName(value = "上级公司名称")
    private String parentcompanyName;
    @OperLogFieldName(value = "排序")
    private Integer sort;
    @OperLogFieldName(value = "拼音码")
    private String pinyinCode;
    @OperLogFieldName(value = "分子公司")
    private Integer subsidiary;
    @OperLogFieldName(value = "税号")
    private String taxno;
    @OperLogFieldName(value = "地址")
    private String address;
    @OperLogFieldName(value = "电话")
    private String phone;
    @OperLogFieldName(value = "注销标志")
    private Integer signOff;
    @OperLogFieldName(value = "公司简称")
    private String abbreviation;
    private Integer reimbursement;
    @OperLogFieldName(value = "单位编码")
    private String unitcode;
    @OperLogFieldName(value = "备注")
    private String remarks;
    @OperLogFieldName(value = "创建日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date creationDate;
    @OperLogFieldName(value = "用途")
    private String purpose;
    @OperLogFieldName(value = "省份")
    private String province;
    @OperLogFieldName(value = "省份名称")
    private String provinceText;
    @OperLogFieldName(value = "地址")
    private String city;
    @OperLogFieldName(value = "地市名称")
    private String cityText;
    @OperLogFieldName(value = "县市")
    private String county;
    @OperLogFieldName(value = "县市名称")
    private String countyText;
    private List<CompanyViewVO> children;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getParentCompanyId() {
        return parentCompanyId;
    }

    public void setParentCompanyId(Integer parentCompanyId) {
        this.parentCompanyId = parentCompanyId;
    }

    public String getParentcompanyName() {
        return parentcompanyName;
    }

    public void setParentcompanyName(String parentcompanyName) {
        this.parentcompanyName = parentcompanyName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getPinyinCode() {
        return pinyinCode;
    }

    public void setPinyinCode(String pinyinCode) {
        this.pinyinCode = pinyinCode;
    }

    public Integer getSubsidiary() {
        return subsidiary;
    }

    public void setSubsidiary(Integer subsidiary) {
        this.subsidiary = subsidiary;
    }

    public String getTaxno() {
        return taxno;
    }

    public void setTaxno(String taxno) {
        this.taxno = taxno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getSignOff() {
        return signOff;
    }

    public void setSignOff(Integer signOff) {
        this.signOff = signOff;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public Integer getReimbursement() {
        return reimbursement;
    }

    public void setReimbursement(Integer reimbursement) {
        this.reimbursement = reimbursement;
    }

    public String getUnitcode() {
        return unitcode;
    }

    public void setUnitcode(String unitcode) {
        this.unitcode = unitcode;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getProvinceText() {
        return provinceText;
    }

    public void setProvinceText(String provinceText) {
        this.provinceText = provinceText;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityText() {
        return cityText;
    }

    public void setCityText(String cityText) {
        this.cityText = cityText;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCountyText() {
        return countyText;
    }

    public void setCountyText(String countyText) {
        this.countyText = countyText;
    }

    public List<CompanyViewVO> getChildren() {
        return children;
    }

    public void setChildren(List<CompanyViewVO> children) {
        this.children = children;
    }
}
