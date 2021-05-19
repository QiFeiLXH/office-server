package com.bsoft.office.work.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/27 14:08
 * @Description
 */
@Data
@ExcelIgnoreUnannotated
public class PrintingViewVO {
    private Integer id;
    /** 订单编号 */
    @ColumnWidth(25)
    @ExcelProperty(value = "订单编号", index = 0)
    @OperLogFieldName(value = "订单编号")
    private String orderNum;
    /** 申请人 */
    @OperLogFieldName(value = "订单编号")
    private String applicant;
    @ColumnWidth(25)
    @ExcelProperty(value = "申请人", index = 1)
    @OperLogFieldName(value = "申请人")
    private String applicantName;
    /** 拼音码 */
    @OperLogFieldName(value = "拼音码")
    private String simpleCode;
    /** 部门id */
    @OperLogFieldName(value = "部门id")
    private String deptId;
    @ColumnWidth(30)
    @ExcelProperty(value = "部门", index = 3)
    @OperLogFieldName(value = "部门")
    private String deptName;
    /** 文印日期 */
    @DateTimeFormat("yyyy-MM-dd")
    @ColumnWidth(25)
    @ExcelProperty(value = "文印日期", index = 2)
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "文印日期")
    private Date printDate;
    /** 合计金额 */
    @ColumnWidth(15)
    @ExcelProperty(value = "金额", index = 4)
    @OperLogFieldName(value = "合计金额")
    private Double sumAmount;
    /** 核准金额 */
    @ColumnWidth(15)
    @ExcelProperty(value = "核准金额", index = 5)
    @OperLogFieldName(value = "核准金额")
    private Double approval;
    /** 流水号id */
    @ColumnWidth(25)
    @ExcelProperty(value = "流水号", index = 6)
    @OperLogFieldName(value = "流水号id")
    private String lshid;
    /** 状态 */
    private Integer status;
    @ColumnWidth(25)
    @ExcelProperty(value = "状态", index = 7)
    @OperLogFieldName(value = "状态")
    private String statusText;
    /** 申请日期 */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "申请日期")
    private Date applyDate;
    /** 归属人 */
    @OperLogFieldName(value = "归属人")
    private String belonger;
    @OperLogFieldName(value = "归属人")
    private String belongerName;
    /** 归属部门 */
    @OperLogFieldName(value = "归属部门")
    private String belongDept;
    @OperLogFieldName(value = "归属部门")
    private String belongDeptName;
    /** 项目id */
    @OperLogFieldName(value = "项目id")
    private String projectId;
    @OperLogFieldName(value = "项目id")
    private String projectName;
    /** 费用类别 */
    @OperLogFieldName(value = "费用类别")
    private Integer costType;
    @OperLogFieldName(value = "费用类别")
    private String costTypeText;
    /** 核算口径 */
    @OperLogFieldName(value = "核算口径")
    private Integer accountCaliber;
    @OperLogFieldName(value = "核算口径")
    private String accountCaliberText;
    /** 申领事由 */
    @OperLogFieldName(value = "申领事由")
    private String reason;
    /** 文印单位 */
    @OperLogFieldName(value = "文印单位")
    private Integer printUnit;
    @OperLogFieldName(value = "文印单位")
    private String printUnitName;
    /** 申请支付日期 */
    @ColumnWidth(25)
    @ExcelProperty(value = "申请支付日期", index = 8)
    @DateTimeFormat("yyyy-MM-dd")
    @OperLogFieldName(value = "申请支付日期")
    private Date applyPayDate;


}
