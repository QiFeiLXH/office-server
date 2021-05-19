package com.bsoft.office.hr.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.HeadStyle;
import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.poi.ss.usermodel.FillPatternType;

import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/7/17 14:34
 * @Description
 */
@Data
@ExcelIgnoreUnannotated
public class PerformanceViewVO{
    /** 员工工号 */
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    @ExcelProperty(value = "员工工号", index = 0)
    @OperLogFieldName(value = "员工工号")
    private String personId;
    /** 评价日期 */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "评价日期")
    private Date evaluationDate;
    /** 员工姓名 */
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    @ExcelProperty(value = "员工姓名", index = 1)
    @OperLogFieldName(value = "员工姓名")
    private String personName;
    /** 员工姓名拼音 */
    @OperLogFieldName(value = "员工姓名拼音")
    private String simpleCode;
    /** 部门id */
    @OperLogFieldName(value = "部门id")
    private String deptId;
    /** 部门名称 */
    @OperLogFieldName(value = "部门名称")
    private String deptName;
    /** 年份 */
    @OperLogFieldName(value = "年份")
    private Integer year;
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    @ExcelProperty(value = "年份", index = 2)
    @OperLogFieldName(value = "年份")
    private String yearStr;
    /** 年度绩效 */
    @OperLogFieldName(value = "年度绩效")
    private Double performance;
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    @ExcelProperty(value = "年度绩效分", index = 3)
    @OperLogFieldName(value = "年度绩效")
    private String performanceStr;
    /** 评价等级 */
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    @ExcelProperty(value = "绩效等级", index = 4)
    @OperLogFieldName(value = "评价等级")
    private String evaluationGrade;
    /** 评价内容 */
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = -1)
    @ExcelProperty(value = "评价内容", index = 5)
    @OperLogFieldName(value = "评价内容")
    private String evaluationContent;
    /** 登记人工号 */
    @OperLogFieldName(value = "登记人工号")
    private String evaluationPerson;
    /** 登记人姓名 */
    @OperLogFieldName(value = "登记人姓名")
    private String evaluationPersonName;

}
