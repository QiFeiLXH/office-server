package com.bsoft.office.hr.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Author lkh
 * @Date 2021/3/5
 * @Description
 */
@ExcelIgnoreUnannotated
public class PersonTransferConditionVO {
    @OperLogFieldName(value = "id")
    private Integer id;
    @OperLogFieldName(value = "用户离职标志")
    private String flag;
    /** 工号 */
    @ExcelProperty(value = "工号", index = 0)
    @OperLogFieldName(value = "工号")
    private String personId;
    /** 姓名 */
    @ExcelProperty(value = "姓名", index = 1)
    @OperLogFieldName(value = "姓名")
    private String personName;

    @OperLogFieldName(value = "调前部门ID")
    private String aheadDept;//调前部门
    @ExcelProperty(value = "调前部门", index = 3)
    @OperLogFieldName(value = "调前部门")
    private String aheadDeptText;
    @OperLogFieldName(value = "调后部门ID")
    private String laterDept;//调后部门
    @ExcelProperty(value = "调后部门", index = 9)
    @OperLogFieldName(value = "调后部门")
    private String laterDeptText;
    @OperLogFieldName(value = "调前岗位大类ID")

    private String aheadJobCategory;//调前岗位大类
    @OperLogFieldName(value = "调前岗位大类")
    @ExcelProperty(value = "调前岗位大类", index = 4)
    private String aheadJobCategoryText;
    @OperLogFieldName(value = "调后岗位大类ID")
    private String laterJobCategory;//调后岗位大类
    @OperLogFieldName(value = "调后岗位大类")
    @ExcelProperty(value = "调后岗位大类", index = 10)
    private String laterJobCategoryText;
    @OperLogFieldName(value = "调前岗位职务ID")
    private String aheadPost;//调前岗位职务
    @OperLogFieldName(value = "调前岗位职务")
    @ExcelProperty(value = "调前岗位职务", index = 5)
    private String aheadPostText;
    @OperLogFieldName(value = "调后岗位职务ID")
    private String laterPost;//调后岗位职务
    @OperLogFieldName(value = "调后岗位职务")
    @ExcelProperty(value = "调后岗位职务", index = 11)
    private String laterPostText;
    @OperLogFieldName(value = "调动日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat("yyyy-MM-dd")
    @ExcelProperty(value = "调动日期", index = 2)
    private Date transferDate;//调动日期
    @OperLogFieldName(value = "调前补贴ID")
    private Integer aheadCommunicationSubsidy;//调前补贴
    @OperLogFieldName(value = "调前核算口径归属")
    @ExcelProperty(value = "调前核算口径归属", index = 6)
    private String aheadCommunicationSubsidyText;
    @OperLogFieldName(value = "调后补贴ID")
    private Integer laterCommunicationSubsidy;//调后补贴
    @OperLogFieldName(value = "调后核算口径归属")
    @ExcelProperty(value = "调后核算口径归属", index = 12)
    private String  laterCommunicationSubsidyText;
    @OperLogFieldName(value = "调前费用类别ID")
    private Integer aheadCost;//调前费用类别
    @OperLogFieldName(value = "调前费用类别")
    @ExcelProperty(value = "调前费用类别", index = 7)
    private String  aheadCostText;
    @OperLogFieldName(value = "调后费用类别ID")
    private Integer laterCost;//调后费用类别
    @OperLogFieldName(value = "调后费用类别")
    @ExcelProperty(value = "调后费用类别", index = 13)
    private String  laterCostText;
    @OperLogFieldName(value = "调前财务类别ID")
    private Integer aheadFinancial;//调前财务类别
    @OperLogFieldName(value = "调前财务类别")
    @ExcelProperty(value = "调前财务类别", index = 8)
    private String  aheadFinancialText;
    @OperLogFieldName(value = "调后财务类别ID")
    private Integer laterFinancial;//调后财务类别
    @OperLogFieldName(value = "调后财务类别")
    @ExcelProperty(value = "调后财务类别", index = 14)
    private String  laterFinancialText;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
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

    public String getAheadDept() {
        return aheadDept;
    }

    public void setAheadDept(String aheadDept) {
        this.aheadDept = aheadDept;
    }

    public String getAheadDeptText() {
        return aheadDeptText;
    }

    public void setAheadDeptText(String aheaddeptText) {
        this.aheadDeptText = aheaddeptText;
    }

    public String getLaterDept() {
        return laterDept;
    }

    public void setLaterDept(String laterDept) {
        this.laterDept = laterDept;
    }

    public String getLaterDeptText() {
        return laterDeptText;
    }

    public void setLaterDeptText(String laterDeptText) {
        this.laterDeptText = laterDeptText;
    }

    public String getAheadJobCategory() {
        return aheadJobCategory;
    }

    public void setAheadJobCategory(String aheadJobCategory) {
        this.aheadJobCategory = aheadJobCategory;
    }

    public String getAheadJobCategoryText() {
        return aheadJobCategoryText;
    }

    public void setAheadJobCategoryText(String aheadJobCategoryText) {
        this.aheadJobCategoryText = aheadJobCategoryText;
    }

    public String getLaterJobCategory() {
        return laterJobCategory;
    }

    public void setLaterJobCategory(String laterJobCategory) {
        this.laterJobCategory = laterJobCategory;
    }

    public String getLaterJobCategoryText() {
        return laterJobCategoryText;
    }

    public void setLaterJobCategoryText(String laterJobCategoryText) {
        this.laterJobCategoryText = laterJobCategoryText;
    }

    public String getAheadPost() {
        return aheadPost;
    }

    public void setAheadPost(String aheadPost) {
        this.aheadPost = aheadPost;
    }

    public String getAheadPostText() {
        return aheadPostText;
    }

    public void setAheadPostText(String aheadPostText) {
        this.aheadPostText = aheadPostText;
    }

    public String getLaterPost() {
        return laterPost;
    }

    public void setLaterPost(String laterPost) {
        this.laterPost = laterPost;
    }

    public String getLaterPostText() {
        return laterPostText;
    }

    public void setLaterPostText(String laterPostText) {
        this.laterPostText = laterPostText;
    }

    public Date getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }

    public Integer getAheadCommunicationSubsidy() {
        return aheadCommunicationSubsidy;
    }

    public void setAheadCommunicationSubsidy(Integer aheadCommunicationSubsidy) {
        this.aheadCommunicationSubsidy = aheadCommunicationSubsidy;
    }

    public String getAheadCommunicationSubsidyText() {
        return aheadCommunicationSubsidyText;
    }

    public void setAheadCommunicationSubsidyText(String aheadCommunicationSubsidyText) {
        this.aheadCommunicationSubsidyText = aheadCommunicationSubsidyText;
    }

    public Integer getLaterCommunicationSubsidy() {
        return laterCommunicationSubsidy;
    }

    public void setLaterCommunicationSubsidy(Integer laterCommunicationSubsidy) {
        this.laterCommunicationSubsidy = laterCommunicationSubsidy;
    }

    public String getLaterCommunicationSubsidyText() {
        return laterCommunicationSubsidyText;
    }

    public void setLaterCommunicationSubsidyText(String laterCommunicationSubsidyText) {
        this.laterCommunicationSubsidyText = laterCommunicationSubsidyText;
    }

    public Integer getAheadCost() {
        return aheadCost;
    }

    public void setAheadCost(Integer aheadCost) {
        this.aheadCost = aheadCost;
    }

    public String getAheadCostText() {
        return aheadCostText;
    }

    public void setAheadCostText(String aheadCostText) {
        this.aheadCostText = aheadCostText;
    }

    public Integer getLaterCost() {
        return laterCost;
    }

    public void setLaterCost(Integer laterCost) {
        this.laterCost = laterCost;
    }

    public String getLaterCostText() {
        return laterCostText;
    }

    public void setLaterCostText(String laterCostText) {
        this.laterCostText = laterCostText;
    }

    public Integer getAheadFinancial() {
        return aheadFinancial;
    }

    public void setAheadFinancial(Integer aheadFinancial) {
        this.aheadFinancial = aheadFinancial;
    }

    public String getAheadFinancialText() {
        return aheadFinancialText;
    }

    public void setAheadFinancialText(String aheadFinancialText) {
        this.aheadFinancialText = aheadFinancialText;
    }

    public Integer getLaterFinancial() {
        return laterFinancial;
    }

    public void setLaterFinancial(Integer laterFinancial) {
        this.laterFinancial = laterFinancial;
    }

    public String getLaterFinancialText() {
        return laterFinancialText;
    }

    public void setLaterFinancialText(String laterFinancialText) {
        this.laterFinancialText = laterFinancialText;
    }
}
