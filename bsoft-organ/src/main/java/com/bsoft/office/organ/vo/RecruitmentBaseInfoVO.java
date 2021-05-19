package com.bsoft.office.organ.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * @Auther: hy
 * @Date: 2020/5/19
 * @Description:
*/
public class RecruitmentBaseInfoVO {
    private Integer id;
    @OperLogFieldName(value = "身份证号")
    private String idCard;
    @OperLogFieldName(value = "姓名")
    private String personName;
    @OperLogFieldName(value = "性别")
    private Integer gender;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "出生年月")
    private Date birthDate;
    @OperLogFieldName(value = "手机号码")
    private String phone;
    @OperLogFieldName(value = "应聘岗位")
    private Integer appliedPosition;
    @OperLogFieldName(value = "应聘岗位名称")
    private String appliedPositionText;
    @OperLogFieldName(value = "录用部门")
    private String dept;
    @OperLogFieldName(value = "录用部门名称")
    private String deptText;
    @OperLogFieldName(value = "登记时间")
    private Date registrationTime;
    @OperLogFieldName(value = "登记人员")
    private String registrant;
    @OperLogFieldName(value = "登记人员名称")
    private String registrantName;
    @OperLogFieldName(value = "登记人员电话")
    private String registrantPhone;
    @OperLogFieldName(value = "登记人员邮箱")
    private String registrantEmail;
    /** 招聘类型 0普通；1实习；2中层；3领导；4顾问*/
    @OperLogFieldName(value = "招聘类型")
    private Integer recruitmentType;
    @OperLogFieldName(value = "招聘类型名称")
    private String recruitmentTypeText;
    /** 录用备注 boss直聘 前程无忧 智联招聘 其他*/
    @OperLogFieldName(value = "录用备注")
    private Integer employmentNotes;
    @OperLogFieldName(value = "录用备注名称")
    private String employmentNotesText;
    @OperLogFieldName(value = "文化程度")
    private Integer education;
    @OperLogFieldName(value = "文化程度名称")
    private String educationText;
    @OperLogFieldName(value = "录用备注备注")
    private String employmentNotesDetail;
    @OperLogFieldName(value = "所属公司")
    private Integer company;
    @OperLogFieldName(value = "所属公司名称")
    private String companyText;
    /** 是否留用 1 是；0否*/
    @OperLogFieldName(value = "是否留用")
    private Integer isUse;
    @OperLogFieldName(value = "实现薪资")
    private Double internshipSalary;
    @OperLogFieldName(value = "使用期薪资")
    private Double trialSalary;
    @OperLogFieldName(value = "转正薪资")
    private Double regularSalary;
    @OperLogFieldName(value = "个人邮箱")
    private String email;
    @OperLogFieldName(value = "试用期")
    private Integer probationPeriod;
    @OperLogFieldName(value = "报到日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date startDate;
    @OperLogFieldName(value = "状态")
    /** 状态 默认0 1：招聘中 2：录用（审核通过） 3：人才库 4: 已发邮件 5：待审核 6：退回待修改*/
    private Integer status;
    @OperLogFieldName(value = "状态名称")
    private String statusText;
    @OperLogFieldName(value = "退回理由")
    private String  remarks;
    @OperLogFieldName(value = "岗位大类")
    private String jobCategory;
    @OperLogFieldName(value = "岗位大类名称")
    private String jobCategoryText;
    @OperLogFieldName(value = "人员归属群")
    private Integer personnelGroup;
    @OperLogFieldName(value = "人员归属群名称")
    private String personnelGroupText;
    @OperLogFieldName(value = "毕业时间")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date graduateDate;
    @OperLogFieldName(value = "第一次工作日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date firstWork;
    @OperLogFieldName(value = "本地化")
    /** 本地化 0 非本地；1县级本地；3地级本地；2省本地*/
    private Integer localFlag;
    @OperLogFieldName(value = "调后通讯补贴")
    private Integer communicationSubsidy;
    @OperLogFieldName(value = "调后通讯补贴名称")
    private String communicationSubsidyText;
    @OperLogFieldName(value = "社保缴纳地")
    private Integer paymentPlace;
    @OperLogFieldName(value = "社保缴纳地名称")
    private String paymentPlaceText;
    @OperLogFieldName(value = "社保缴纳基数")
    private Double paymentBase;
    private String province;
    private String city;
    private String county;
    @OperLogFieldName(value = "岗位信息ID")
    private Integer positionInfoId;
    @OperLogFieldName(value = "驻地信息ID")
    private Integer residentInfoId;
    @OperLogFieldName(value = "邮件发送标志")
    /** 0 保存  1 需发送 */
    private Integer sendStatus;
    @OperLogFieldName(value = "证件类型")
    /** 1 身份证  2 护照 */
    private Integer idCardType;
    @OperLogFieldName(value = "一寸照")
    private Integer oneInchPhoto;
    @OperLogFieldName(value = "驻地省份")
    private String divisionProvince;
    @OperLogFieldName(value = "驻地省份名称")
    private String divisionProvinceText;
    @OperLogFieldName(value = "驻地地市")
    private String divisionCity;
    @OperLogFieldName(value = "驻地地市名称")
    private String divisionCityText;
    @OperLogFieldName(value = "驻地县市")
    private String divisionCounty;
    @OperLogFieldName(value = "驻地县市名称")
    private String divisionCountyText;
    @OperLogFieldName(value = "社保缴纳标志")
    private Integer paymentFlag;
    @OperLogFieldName(value = "工牌办理标志")
    private Integer workCardFlag;
    @OperLogFieldName(value = "餐补充值入工牌")
    private Integer mealRechargeFlag;
    @OperLogFieldName(value = "同创业工号")
    /** 慧康物联网,同创业工号*/
    private Integer sameBsoft;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAppliedPosition() {
        return appliedPosition;
    }

    public void setAppliedPosition(Integer appliedPosition) {
        this.appliedPosition = appliedPosition;
    }

    public String getAppliedPositionText() {
        return appliedPositionText;
    }

    public void setAppliedPositionText(String appliedPositionText) {
        this.appliedPositionText = appliedPositionText;
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

    public Date getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(Date registrationTime) {
        this.registrationTime = registrationTime;
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

    public String getRegistrantPhone() {
        return registrantPhone;
    }

    public void setRegistrantPhone(String registrantPhone) {
        this.registrantPhone = registrantPhone;
    }

    public String getRegistrantEmail() {
        return registrantEmail;
    }

    public void setRegistrantEmail(String registrantEmail) {
        this.registrantEmail = registrantEmail;
    }

    public Integer getRecruitmentType() {
        return recruitmentType;
    }

    public void setRecruitmentType(Integer recruitmentType) {
        this.recruitmentType = recruitmentType;
    }

    public String getRecruitmentTypeText() {
        return recruitmentTypeText;
    }

    public void setRecruitmentTypeText(String recruitmentTypeText) {
        this.recruitmentTypeText = recruitmentTypeText;
    }

    public Integer getEmploymentNotes() {
        return employmentNotes;
    }

    public void setEmploymentNotes(Integer employmentNotes) {
        this.employmentNotes = employmentNotes;
    }

    public String getEmploymentNotesText() {
        return employmentNotesText;
    }

    public void setEmploymentNotesText(String employmentNotesText) {
        this.employmentNotesText = employmentNotesText;
    }

    public Integer getEducation() {
        return education;
    }

    public void setEducation(Integer education) {
        this.education = education;
    }

    public String getEducationText() {
        return educationText;
    }

    public void setEducationText(String educationText) {
        this.educationText = educationText;
    }

    public String getEmploymentNotesDetail() {
        return employmentNotesDetail;
    }

    public void setEmploymentNotesDetail(String employmentNotesDetail) {
        this.employmentNotesDetail = employmentNotesDetail;
    }

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

    public Integer getIsUse() {
        return isUse;
    }

    public void setIsUse(Integer isUse) {
        this.isUse = isUse;
    }

    public Double getInternshipSalary() {
        return internshipSalary;
    }

    public void setInternshipSalary(Double internshipSalary) {
        this.internshipSalary = internshipSalary;
    }

    public Double getTrialSalary() {
        return trialSalary;
    }

    public void setTrialSalary(Double trialSalary) {
        this.trialSalary = trialSalary;
    }

    public Double getRegularSalary() {
        return regularSalary;
    }

    public void setRegularSalary(Double regularSalary) {
        this.regularSalary = regularSalary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getProbationPeriod() {
        return probationPeriod;
    }

    public void setProbationPeriod(Integer probationPeriod) {
        this.probationPeriod = probationPeriod;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(String jobCategory) {
        this.jobCategory = jobCategory;
    }

    public String getJobCategoryText() {
        return jobCategoryText;
    }

    public void setJobCategoryText(String jobCategoryText) {
        this.jobCategoryText = jobCategoryText;
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

    public Date getGraduateDate() {
        return graduateDate;
    }

    public void setGraduateDate(Date graduateDate) {
        this.graduateDate = graduateDate;
    }

    public Date getFirstWork() {
        return firstWork;
    }

    public void setFirstWork(Date firstWork) {
        this.firstWork = firstWork;
    }

    public Integer getLocalFlag() {
        return localFlag;
    }

    public void setLocalFlag(Integer localFlag) {
        this.localFlag = localFlag;
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

    public Integer getPaymentPlace() {
        return paymentPlace;
    }

    public void setPaymentPlace(Integer paymentPlace) {
        this.paymentPlace = paymentPlace;
    }

    public String getPaymentPlaceText() {
        return paymentPlaceText;
    }

    public void setPaymentPlaceText(String paymentPlaceText) {
        this.paymentPlaceText = paymentPlaceText;
    }

    public Double getPaymentBase() {
        return paymentBase;
    }

    public void setPaymentBase(Double paymentBase) {
        this.paymentBase = paymentBase;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public Integer getPositionInfoId() {
        return positionInfoId;
    }

    public void setPositionInfoId(Integer positionInfoId) {
        this.positionInfoId = positionInfoId;
    }

    public Integer getResidentInfoId() {
        return residentInfoId;
    }

    public void setResidentInfoId(Integer residentInfoId) {
        this.residentInfoId = residentInfoId;
    }

    public Integer getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }

    public Integer getIdCardType() {
        return idCardType;
    }

    public void setIdCardType(Integer idCardType) {
        this.idCardType = idCardType;
    }

    public Integer getOneInchPhoto() {
        return oneInchPhoto;
    }

    public void setOneInchPhoto(Integer oneInchPhoto) {
        this.oneInchPhoto = oneInchPhoto;
    }

    public String getDivisionProvince() {
        return divisionProvince;
    }

    public void setDivisionProvince(String divisionProvince) {
        this.divisionProvince = divisionProvince;
    }

    public String getDivisionProvinceText() {
        return divisionProvinceText;
    }

    public void setDivisionProvinceText(String divisionProvinceText) {
        this.divisionProvinceText = divisionProvinceText;
    }

    public String getDivisionCity() {
        return divisionCity;
    }

    public void setDivisionCity(String divisionCity) {
        this.divisionCity = divisionCity;
    }

    public String getDivisionCityText() {
        return divisionCityText;
    }

    public void setDivisionCityText(String divisionCityText) {
        this.divisionCityText = divisionCityText;
    }

    public String getDivisionCounty() {
        return divisionCounty;
    }

    public void setDivisionCounty(String divisionCounty) {
        this.divisionCounty = divisionCounty;
    }

    public String getDivisionCountyText() {
        return divisionCountyText;
    }

    public void setDivisionCountyText(String divisionCountyText) {
        this.divisionCountyText = divisionCountyText;
    }

    public Integer getPaymentFlag() {
        return paymentFlag;
    }

    public void setPaymentFlag(Integer paymentFlag) {
        this.paymentFlag = paymentFlag;
    }

    public Integer getWorkCardFlag() {
        return workCardFlag;
    }

    public void setWorkCardFlag(Integer workCardFlag) {
        this.workCardFlag = workCardFlag;
    }

    public Integer getMealRechargeFlag() {
        return mealRechargeFlag;
    }

    public void setMealRechargeFlag(Integer mealRechargeFlag) {
        this.mealRechargeFlag = mealRechargeFlag;
    }

    public Integer getSameBsoft() {
        return sameBsoft;
    }

    public void setSameBsoft(Integer sameBsoft) {
        this.sameBsoft = sameBsoft;
    }
}
