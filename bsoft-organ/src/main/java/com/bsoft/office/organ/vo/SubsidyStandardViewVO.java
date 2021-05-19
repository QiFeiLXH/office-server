package com.bsoft.office.organ.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2020/11/23 12:12
 * @Description:
 */
public class SubsidyStandardViewVO {
    @OperLogFieldName(value = "ID")
    private Integer id;
    @OperLogFieldName(value = "工号")
    private String personId;
    @OperLogFieldName(value = "姓名")
    private String personName;
    @OperLogFieldName(value = "拼音码")
    private String pycode;
    @OperLogFieldName(value = "部门代码")
    private String organizCode;
    @OperLogFieldName(value = "部门名称")
    private String deptName;
    @OperLogFieldName(value = "项目ID")
    private String projectId;
    @OperLogFieldName(value = "项目名称")
    private String projectName;
    @OperLogFieldName(value = "合同号")
    private String contractNo;
    @OperLogFieldName(value = "工程区域")
    private String area;
    @OperLogFieldName(value = "工程区域名称")
    private String areaText;
    @OperLogFieldName(value = "省份")
    private String province;
    @OperLogFieldName(value = "省份名称")
    private String provinceText;
    @OperLogFieldName(value = "地市")
    private String city;
    @OperLogFieldName(value = "地市名称")
    private String cityText;
    @OperLogFieldName(value = "县市")
    private String county;
    @OperLogFieldName(value = "县市名称")
    private String countyText;
    @OperLogFieldName(value = "省外")
    private Double outProvince;
    @OperLogFieldName(value = "省内")
    private Double inProvince;
    @OperLogFieldName(value = "地级市内")
    private Double inCity;
    @OperLogFieldName(value = "备注")
    private String remarks;
    @OperLogFieldName(value = "申请日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date applydate;
    @OperLogFieldName(value = "登记人")
    private String registrant;
    @OperLogFieldName(value = "登记人姓名")
    private String registrantName;
    @OperLogFieldName(value = "状态")
    private Integer state;
    @OperLogFieldName(value = "分类")
    private Integer flag;
    @OperLogFieldName(value = "是否离职")
    private Integer logoff;
    @OperLogFieldName(value = "作废人")
    private String voider;
    @OperLogFieldName(value = "作废人姓名")
    private String voiderName;
    @OperLogFieldName(value = "作废日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date voiderDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPycode() {
        return pycode;
    }

    public void setPycode(String pycode) {
        this.pycode = pycode;
    }

    public String getOrganizCode() {
        return organizCode;
    }

    public void setOrganizCode(String organizCode) {
        this.organizCode = organizCode;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAreaText() {
        return areaText;
    }

    public void setAreaText(String areaText) {
        this.areaText = areaText;
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

    public Double getOutProvince() {
        return outProvince;
    }

    public void setOutProvince(Double outProvince) {
        this.outProvince = outProvince;
    }

    public Double getInProvince() {
        return inProvince;
    }

    public void setInProvince(Double inProvince) {
        this.inProvince = inProvince;
    }

    public Double getInCity() {
        return inCity;
    }

    public void setInCity(Double inCity) {
        this.inCity = inCity;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getApplydate() {
        return applydate;
    }

    public void setApplydate(Date applydate) {
        this.applydate = applydate;
    }

    public String getRegistrant() {
        return registrant;
    }

    public void setRegistrant(String registrant) {
        this.registrant = registrant;
    }

    public String getRegistrantName() {
        return registrantName;
    }

    public void setRegistrantName(String registrantName) {
        this.registrantName = registrantName;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getLogoff() {
        return logoff;
    }

    public void setLogoff(Integer logoff) {
        this.logoff = logoff;
    }

    public String getVoider() {
        return voider;
    }

    public void setVoider(String voider) {
        this.voider = voider;
    }

    public String getVoiderName() {
        return voiderName;
    }

    public void setVoiderName(String voiderName) {
        this.voiderName = voiderName;
    }

    public Date getVoiderDate() {
        return voiderDate;
    }

    public void setVoiderDate(Date voiderDate) {
        this.voiderDate = voiderDate;
    }
}
