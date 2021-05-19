package com.bsoft.office.sales.vo;

/**
 * @Author: xucl
 * @DateTime: 2020/10/12 16:47
 * @Description:
 */

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.HeadStyle;
import lombok.Data;
import org.apache.poi.ss.usermodel.FillPatternType;

import java.util.Date;

/**
 * 销售提成导入Excel VO
 */
@Data
@ExcelIgnoreUnannotated
@HeadStyle(fillForegroundColor = 9)
public class SalesCommisImportVO {
    private Integer accountingCaliber;
    @ExcelProperty(value = "核算口径归属", index = 0)
    @HeadStyle(fillForegroundColor = 13)
    private String accountingCaliberText;
    @ExcelProperty(value = "一级区域", index = 1)
    private String bm1;
    private String departMent;
    @ExcelProperty(value = "归属部门", index = 2)
    @HeadStyle(fillForegroundColor = 13)
    private String departMentText;
    @ExcelProperty(value = "申请人工号", index = 3)
    @HeadStyle(fillForegroundColor = 13)
    private String salesMan;
    @ExcelProperty(value = "申请人", index = 4)
    private String salesManText;
    @ExcelProperty(value = "合同编号", index = 5)
    @HeadStyle(fillForegroundColor = 13)
    private String contractNo;
    @ExcelProperty(value = "客户名称", index = 6)
    private String khmc;
    @ExcelProperty(value = "合同名称", index = 7)
    private String contractName;
    @ExcelProperty(value = "合同金额", index = 8)
    private Double htje;
    @ExcelProperty(value = "总软件额", index = 9)
    private Double zrje;
    @ExcelProperty(value = "净软件额", index = 10)
    @HeadStyle(fillForegroundColor = 13)
    private Double contractAmount;
    @ExcelProperty(value = "采购外包金额", index = 11)
    private Double cgwbje;
    @ExcelProperty(value = "硬件金额", index = 12)
    private Double yjje;
    @ExcelProperty(value = "签订日期", index = 13)
    private Date qdrq;
    @ExcelProperty(value = "合同原件", index = 14)
    private String htyj;
    @ExcelProperty(value = "类别", index = 15)
    private String lb;
    @ExcelProperty(value = "合同折扣", index = 16)
    private String htzk;
    @ExcelProperty(value = "可提成总额", index = 17)
    @HeadStyle(fillForegroundColor = 13)
    private Double totalRoyalty;
    @ExcelProperty(value = "可用费用", index = 18)
    @HeadStyle(fillForegroundColor = 13)
    private Double sellingExpenses;
    @ExcelProperty(value = "回款总额", index = 19)
    private Double hkze;
    @ExcelProperty(value = "回款比例", index = 20)
    private Double hkbl;
    @ExcelProperty(value = "已发放金额", index = 21)
    private Double yffje;
    @ExcelProperty(value = "本次申请金额", index = 22)
    private Double bcsqje;
    @ExcelProperty(value = "失败原因", index = 23)
    private String errorMsg;
}
