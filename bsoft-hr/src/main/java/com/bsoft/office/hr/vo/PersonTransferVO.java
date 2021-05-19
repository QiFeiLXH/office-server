package com.bsoft.office.hr.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2020/12/30 11:12
 * @Description:
 */
public class PersonTransferVO {
    @OperLogFieldName(value = "ID")
    private Integer id;
    @OperLogFieldName(value = "工号")
    private String personId;
    @OperLogFieldName(value = "姓名")
    private String personName;
    @OperLogFieldName(value = "拼音码")
    private String pym;
    @OperLogFieldName(value = "部门代码")
    private String dept;
    @OperLogFieldName(value = "部门名称")
    private String deptText;
    @OperLogFieldName(value = "岗位大类")
    private Integer jobCategory;//岗位大类
    @OperLogFieldName(value = "岗位大类名称")
    private String jobCategoryText;
    @OperLogFieldName(value = "岗位职务")
    private Integer post;//岗位职务
    @OperLogFieldName(value = "岗位职务名称")
    private String postText;
    @OperLogFieldName(value = "人员归属群")
    private Integer personnelGroup;//人员归属群
    @OperLogFieldName(value = "人员归属群名称")
    private String personnelGroupText;
    @OperLogFieldName(value = "本地化")
    private Integer localflag;//本地化
    @OperLogFieldName(value = "本地化名称")
    private String localflagText;
    @OperLogFieldName(value = "省份")
    private String divisionProvince;
    @OperLogFieldName(value = "省份名称")
    private String divisionProvinceText;
    @OperLogFieldName(value = "地市")
    private String divisionCity;
    @OperLogFieldName(value = "地市名称")
    private String divisionCityText;
    @OperLogFieldName(value = "县市")
    private String divisionCounty;
    @OperLogFieldName(value = "县市名称")
    private String divisionCountyText;
    @OperLogFieldName(value = "补贴")
    private Integer communicationSubsidy;//补贴
    @OperLogFieldName(value = "补贴名称")
    private String communicationSubsidyText;
    @OperLogFieldName(value = "类别")
    private Integer type;//普通、实习、中层、领导、顾问、其他
    @OperLogFieldName(value = "类别名称")
    private String typeText;
    @OperLogFieldName(value = "毕业日期")
    private Date graduationDate;//毕业日期
    @OperLogFieldName(value = "调动日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date transferDate;//调动日期
    @OperLogFieldName(value = "驻地")
    private String ssx;

    public String getSsx() {
        return ssx;
    }

    public void setSsx(String ssx) {
        this.ssx = ssx;
    }

    public String getDivisionProvinceText() {
        return divisionProvinceText;
    }

    public void setDivisionProvinceText(String divisionProvinceText) {
        this.divisionProvinceText = divisionProvinceText;
    }

    public String getDivisionCityText() {
        return divisionCityText;
    }

    public void setDivisionCityText(String divisionCityText) {
        this.divisionCityText = divisionCityText;
    }

    public String getDivisionCountyText() {
        return divisionCountyText;
    }

    public void setDivisionCountyText(String divisionCountyText) {
        this.divisionCountyText = divisionCountyText;
    }

    public Date getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }

    public Date getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(Date graduationDate) {
        this.graduationDate = graduationDate;
    }

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

    public String getPym() {
        return pym;
    }

    public void setPym(String pym) {
        this.pym = pym;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getDeptText() {
        return deptText;
    }

    public void setDeptText(String deptText) {
        this.deptText = deptText;
    }

    public Integer getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(Integer jobCategory) {
        this.jobCategory = jobCategory;
    }

    public String getJobCategoryText() {
        return jobCategoryText;
    }

    public void setJobCategoryText(String jobCategoryText) {
        this.jobCategoryText = jobCategoryText;
    }

    public Integer getPost() {
        return post;
    }

    public void setPost(Integer post) {
        this.post = post;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public Integer getPersonnelGroup() {
        return personnelGroup;
    }

    public void setPersonnelGroup(Integer personnelGroup) {
        this.personnelGroup = personnelGroup;
    }

    public String getPersonnelGroupText() {
        return personnelGroupText;
    }

    public void setPersonnelGroupText(String personnelGroupText) {
        this.personnelGroupText = personnelGroupText;
    }

    public Integer getLocalflag() {
        return localflag;
    }

    public void setLocalflag(Integer localflag) {
        this.localflag = localflag;
    }

    public String getLocalflagText() {
        return localflagText;
    }

    public void setLocalflagText(String localflagText) {
        this.localflagText = localflagText;
    }

    public String getDivisionProvince() {
        return divisionProvince;
    }

    public void setDivisionProvince(String divisionProvince) {
        this.divisionProvince = divisionProvince;
    }

    public String getDivisionCity() {
        return divisionCity;
    }

    public void setDivisionCity(String divisionCity) {
        this.divisionCity = divisionCity;
    }

    public String getDivisionCounty() {
        return divisionCounty;
    }

    public void setDivisionCounty(String divisionCounty) {
        this.divisionCounty = divisionCounty;
    }

    public Integer getCommunicationSubsidy() {
        return communicationSubsidy;
    }

    public void setCommunicationSubsidy(Integer communicationSubsidy) {
        this.communicationSubsidy = communicationSubsidy;
    }

    public String getCommunicationSubsidyText() {
        return communicationSubsidyText;
    }

    public void setCommunicationSubsidyText(String communicationSubsidyText) {
        this.communicationSubsidyText = communicationSubsidyText;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTypeText() {
        return typeText;
    }

    public void setTypeText(String typeText) {
        this.typeText = typeText;
    }
}
