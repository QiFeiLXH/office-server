package com.bsoft.office.organ.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: lkh
 * @date: 2020/12/23
 * @description 人员财物维护
 */
public class PersonFinancialViewVO implements Serializable {

    //工号
    @OperLogFieldName(value = "工号")
    private String personId;
    //部门
    @OperLogFieldName(value = "部门")
    private String dept;
    //姓名
    @OperLogFieldName(value = "姓名")
    private String xusName;
    //岗位大类
    @OperLogFieldName(value = "岗位大类")
    private Integer postType;

    //现财务类别
    @OperLogFieldName(value = "现财务类别")
    private Integer financialTypeNow;


    //现财务类别
    @OperLogFieldName(value = "现财务类别名称")
    private String financialNameNow;

    //调整后财务类别
    @OperLogFieldName(value = "调整后财务类别")
    private Integer FinancialTypeAfter;
    //调整年月
    @OperLogFieldName(value = "调整年月")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date adjustDate;
    //1按部门 2按岗位 3.特殊维护
    @OperLogFieldName(value = "1按部门 2按岗位 3.特殊维护")
    private Integer type;

    //传入查询的财务类别
    @OperLogFieldName(value = "传入查询的财务类别")
    private Integer financialTypeFind;
    // 页码
    @OperLogFieldName(value = "页码")
    private Integer pageNo;
    // 每页条目
    @OperLogFieldName(value = "每页条目")
    private Integer pageSize;

    //岗位名字
    @OperLogFieldName(value = "岗位名字")
    private String postName;
    //部门名字
    @OperLogFieldName(value = "部门名字")
    private String deptName;

    //离职标志
    @OperLogFieldName(value = "离职标志")
    private Integer flag;


    //登记日期
    @OperLogFieldName(value = "登记日期")
    private Date registrantionDate;

    //登记人
    @OperLogFieldName(value = "登记人")
    private String registrant;

    public Date getRegistrantionDate() {
        return registrantionDate;
    }

    public void setRegistrantionDate(Date registrantionDate) {
        this.registrantionDate = registrantionDate;
    }

    public String getRegistrant() {
        return registrant;
    }

    public void setRegistrant(String registrant) {
        this.registrant = registrant;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public Integer getFinancialTypeFind() {
        return financialTypeFind;
    }

    public void setFinancialTypeFind(Integer financialTypeFind) {
        this.financialTypeFind = financialTypeFind;
    }

    public String getXusName() {
        return xusName;
    }

    public void setXusName(String xusName) {
        this.xusName = xusName;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Integer getPostType() {
        return postType;
    }

    public void setPostType(Integer postType) {
        this.postType = postType;
    }

    public Integer getFinancialTypeNow() {
        return financialTypeNow;
    }

    public void setFinancialTypeNow(Integer financialTypeNow) {
        this.financialTypeNow = financialTypeNow;
    }

    public Integer getFinancialTypeAfter() {
        return FinancialTypeAfter;
    }

    public void setFinancialTypeAfter(Integer financialTypeAfter) {
        FinancialTypeAfter = financialTypeAfter;
    }

    public Date getAdjustDate() {
        return adjustDate;
    }

    public void setAdjustDate(Date adjustDate) {
        this.adjustDate = adjustDate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getFinancialNameNow() {
        return financialNameNow;
    }

    public void setFinancialNameNow(String financialNameNow) {
        this.financialNameNow = financialNameNow;
    }
}
