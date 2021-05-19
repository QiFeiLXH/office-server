package com.bsoft.office.sales.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.HeadStyle;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.poi.ss.usermodel.FillPatternType;

import java.util.Date;

/**
 * @author: zy
 * @date: 2020/12/10
 * @description 销售计划导出失败数据
 */
@Data
@ExcelIgnoreUnannotated
public class SalesPlanReportExcelErrorVO {

    /** 业务归属*/
    @ExcelProperty(value = "业务归属", index = 0)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    private String businessBelong;

    /** 跟单人*/
    @ExcelProperty(value = "工号", index = 1)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    private String trackPerson;

    /** 跟单人姓名*/
    @ExcelProperty(value = "跟单人", index = 2)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 1)
    private String trackPersonName;

    /** 跟单部门名称*/
    @ExcelProperty(value = "跟单部门", index = 3)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    private String trackDeptName;

    /** 客户名称*/
    @ExcelProperty(value = "客户名称", index = 4)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    private String customerName;

    /** 产品内容 项目内容*/
    @ExcelProperty(value = "项目内容", index = 5)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 1)
    private String content;

    /** 预计软件额*/
    private Double estimateSoftware;
    @ExcelProperty(value = "项目预算-软件（万）", index = 6)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    private String estimateSoftwareStr;

    /** 预计净销售额软件*/
    private Double estimateNetSales;
    @ExcelProperty(value = "预计净销售额软件（万）", index = 7)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    private String estimateNetSalesStr;

    /** 预计硬件额*/
    private Double estimateHardware;
    @ExcelProperty(value = "项目预算-硬件（万）", index = 8)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    private String estimateHardwareStr;

    /** 预计签约时间*/
    private Date signDate;
    @ExcelProperty(value = "预计时间", index = 9)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    private String signDateStr;

    /** 开标时间*/
    @ExcelProperty(value = "开标时间", index = 10)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 1)
    private String openingDate;

    /** 项目阶段*/
    @ExcelProperty(value = "项目阶段", index = 11)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 1)
    private String stage;

    /** 最新进展（跟单情况）*/
    @ExcelProperty(value = "跟单情况", index = 12)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 1)
    private String latestDevelopment;

    /** 线索性质*/
    @ExcelProperty(value = "线索性质", index = 13)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 1)
    private String cluesNature;

    /** 计划来源*/
    @ExcelProperty(value = "计划来源", index = 14)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 1)
    private String planSource;

    /** 计划月份*/
    private Date planDate;
    @ExcelProperty(value = "计划月份", index = 15)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    private String planDateStr;

    /** 导入失败原因*/
    @ExcelProperty(value = "导入失败原因", index = 16)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 1)
    private String failReason;
}
