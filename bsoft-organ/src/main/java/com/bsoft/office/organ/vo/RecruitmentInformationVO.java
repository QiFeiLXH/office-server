package com.bsoft.office.organ.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;

import java.math.BigDecimal;
import java.util.Date;

public class RecruitmentInformationVO {
    private Integer id;
    @OperLogFieldName(value = "身份证号")
    private String idCard;
    @OperLogFieldName(value = "姓名")
    private String personName;
    @OperLogFieldName(value = "政治面貌")
    private Integer politicalOutlook;
    @OperLogFieldName(value = "手机号码")
    private String phone;
    @OperLogFieldName(value = "民族")
    private Integer nation;
    @OperLogFieldName(value = "出生地县市")
    private Integer birthplace;
    @OperLogFieldName(value = "籍贯县市")
    private Integer nativePlace;
    @OperLogFieldName(value = "身高")
    private Integer height;
    @OperLogFieldName(value = "体重")
    private BigDecimal weight;
    @OperLogFieldName(value = "血型")
    private Integer bloodType;
    @OperLogFieldName(value = "婚姻状况")
    private Integer maritalStatus;
    @OperLogFieldName(value = "户口性质")
    private Integer accountNature;
    @OperLogFieldName(value = "户口地址")
    private String registeredAddress;
    @OperLogFieldName(value = "家庭地址")
    private String homeAddress;
    @OperLogFieldName(value = "身份证正面")
    private Integer frontIdCard;
    @OperLogFieldName(value = "身份证反面")
    private Integer reverseIdCard;
    @OperLogFieldName(value = "毕业时间")
    private Date graduateDate;
    @OperLogFieldName(value = "第一次工作日期")
    private Date firstWork;
    @OperLogFieldName(value = "社保缴纳标志")
    private Integer paymentFlag;
    @OperLogFieldName(value = "工牌办理标志")
    private Integer workCardFlag;
    @OperLogFieldName(value = "餐补充值入工牌")
    private Integer mealRechargeFlag;
    @OperLogFieldName(value = "同创业工号")
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

    public Integer getPoliticalOutlook() {
        return politicalOutlook;
    }

    public void setPoliticalOutlook(Integer politicalOutlook) {
        this.politicalOutlook = politicalOutlook;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getNation() {
        return nation;
    }

    public void setNation(Integer nation) {
        this.nation = nation;
    }

    public Integer getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(Integer birthplace) {
        this.birthplace = birthplace;
    }

    public Integer getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(Integer nativePlace) {
        this.nativePlace = nativePlace;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public Integer getBloodType() {
        return bloodType;
    }

    public void setBloodType(Integer bloodType) {
        this.bloodType = bloodType;
    }

    public Integer getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(Integer maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Integer getAccountNature() {
        return accountNature;
    }

    public void setAccountNature(Integer accountNature) {
        this.accountNature = accountNature;
    }

    public String getRegisteredAddress() {
        return registeredAddress;
    }

    public void setRegisteredAddress(String registeredAddress) {
        this.registeredAddress = registeredAddress;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Integer getFrontIdCard() {
        return frontIdCard;
    }

    public void setFrontIdCard(Integer frontIdCard) {
        this.frontIdCard = frontIdCard;
    }

    public Integer getReverseIdCard() {
        return reverseIdCard;
    }

    public void setReverseIdCard(Integer reverseIdCard) {
        this.reverseIdCard = reverseIdCard;
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
