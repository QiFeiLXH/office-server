package com.bsoft.office.project.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author zhanglf
 * @Date 2019-12-19 10:37
 * @Version 1.0
 * @Description
 */
@Data
@ExcelIgnoreUnannotated
public class ProjectLevelDepTypeByYearVO {
    private Integer id;
    private Integer careerGroup; //事业群编号
    @ExcelProperty(value = "事业群", index = 0)
    private String careerGroupText;//事业群名称
    private String largeArea;//大区编码
    @ExcelProperty(value = "大区", index = 1)
    private String largeAreaText;//大区名称
    private String smallArea;//小区编码
    @ExcelProperty(value = "小区", index = 2)
    private String smallAreaText;//小区名称
    private String moneyBackDept;//回款业绩部门编码
    @ExcelProperty(value = "回款业绩部门", index = 3)
    private String moneyBackDeptText;//回款业绩部门名称
    private String saleDept;//销售业绩部门编码
    @ExcelProperty(value = "销售业绩部门", index = 4)
    private String saleDeptText;//销售业绩部门名称
    @ExcelProperty(value = "客户编码", index = 5)
    private String customerCode;//客户编码
    @ExcelProperty(value = "客户名称", index = 6)
    private String customerName;//客户名称
    @ExcelProperty(value = "合同编号", index = 7)
    private String contractNo;//合同号
    @ExcelProperty(value = "合同名称", index = 8)
    private String contractName;//合同名称
    @ExcelProperty(value = "合同金额", index = 9)
    private Double contractAmount;//合同金额
    @ExcelProperty(value = "合同软件金额", index = 10)
    private Double contractSoftwareAmount;//合同软件金额
    @ExcelProperty(value = "软件与服务金额", index = 11)
    private Double softwareServiceAmount;//软件与服务金额
    @ExcelProperty(value = "折扣率", index = 12)
    private Double discountRate;//折扣率
    @ExcelProperty(value = "合同签订日期", index = 13)
    private String contractSigningDate;//合同签订日期
    @ExcelProperty(value = "合同考核日期", index = 14)
    private String contractAssessmentDate;//合同考核日期
    @ExcelProperty(value = "项目ID", index = 15)
    private String projectId;//项目ID
    @ExcelProperty(value = "项目名称", index = 16)
    private String projectName;//项目名称
    @ExcelProperty(value = "项目金额", index = 17)
    private Double projectAmount;//项目金额
    private Integer projectFlag;//项目类别
    @ExcelProperty(value = "项目类别", index = 18)
    private String projectFlagText;//项目类别
    private Integer projectType;//项目类型
    @ExcelProperty(value = "项目类型", index = 19)
    private String projectTypeText;//项目类型
    @ExcelProperty(value = "验收标记", index = 20)
    private String acceptanceStamp;//验收标记
    @ExcelProperty(value = "年度", index = 21)
    private Integer year;//年份
    private Integer depType;//部门类型:
    // 1.小区内：考勤人员所属部门为归属项目的工程区域
    // 2.小区外大区内：考勤人员所属部门的一级部门为归属项目的一级部门但是所属部门和工程区域不同。
    // 3.大区外：考勤人员所属部门的一级部门和归属项目的一级部门不同。
    @ExcelProperty(value = "产生部门类别", index = 22)
    private String depTypeText;//部门类型名称
    @ExcelProperty(value = "人力成本工作量", index = 23)
    private Double workload;//人力成本工作量
    @ExcelProperty(value = "人力成本金额", index = 24)
    private Double manpowerCost;//人力成本金额
    @ExcelProperty(value = "报销费用", index = 25)
    private Double expenses;//报销费用
    @ExcelProperty(value = "项目奖金", index = 26)
    private Double projectBonus;//项目奖金
}
