package com.bsoft.office.project.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

import java.io.Serializable;

/**
 * B08
 */
@Data
@ExcelIgnoreUnannotated
public class ContractLevelworkloadAllByYearVO implements Serializable {
//    @ExcelProperty(value = "序号", index = 0)
    private long ROW_ID;
    @ExcelProperty(value = "事业群", index = 1)
    private String CAREERGROUPTEXT;
    @ExcelProperty(value = "大区", index = 2)
    private String LARGEAREATEXT;
    @ExcelProperty(value = "小区", index = 3)
    private String SMALLAREATEXT;
    @ExcelProperty(value = "回款业绩部门", index = 4)
    private String MONEYBACKDEPTTEXT;
    @ExcelProperty(value = "销售业绩部门", index = 5)
    private String SALEDEPTTEXT;
    @ExcelProperty(value = "客户编码", index = 6)
    private String CUSTOMERCODE;
    @ExcelProperty(value = "客户名称", index = 7)
    private String CUSTOMERNAME;
    @ExcelProperty(value = "合同编号", index = 8)
    private String CONTRACTNO;
    @ExcelProperty(value = "合同名称", index = 9)
    private String CONTRACTNAME;
    @ExcelProperty(value = "合同金额", index = 10)
    private Double CONTRACTAMOUNT;
    @ExcelProperty(value = "合同软件金额", index = 11)
    private Double CONTRACTSOFTWAREAMOUNT;
    @ExcelProperty(value = "软件与服务金额", index = 12)
    private Double SOFTWARESERVICEAMOUNT;
    @ExcelProperty(value = "折扣", index = 13)
    private Double DISCOUNTRATE;
    @ExcelProperty(value = "合同签订日期", index = 14)
    private String CONTRACTSIGNINGDATE;
    @ExcelProperty(value = "合同考核日期", index = 15)
    private String CONTRACTASSESSMENTDATE;
    @ExcelProperty(value = "人力成本工作量年度", index = 16)
    private String YEAR;
    @ExcelProperty(value = "人力成本工作量(人/天)", index = 17)
    private Double WORKLOAD;
    @ExcelProperty(value = "T00", index = 18)
    private Double t00;
    @ExcelProperty(value = "T01", index = 19)
    private Double t01;
    @ExcelProperty(value = "T02", index = 20)
    private Double t02;
    @ExcelProperty(value = "T03", index = 21)
    private Double t03;
    @ExcelProperty(value = "T04", index = 22)
    private Double t04;
    @ExcelProperty(value = "T05", index = 23)
    private Double t05;
    @ExcelProperty(value = "T06", index = 24)
    private Double t06;
    @ExcelProperty(value = "T07", index = 25)
    private Double t07;
    @ExcelProperty(value = "T08", index = 26)
    private Double t08;
    @ExcelProperty(value = "T09", index = 27)
    private Double t09;
    @ExcelProperty(value = "T10", index = 28)
    private Double t10;
    @ExcelProperty(value = "T11", index = 29)
    private Double t11;
    @ExcelProperty(value = "T12", index = 30)
    private Double t12;
    @ExcelProperty(value = "T13", index = 31)
    private Double t13;
    @ExcelProperty(value = "T14", index = 32)
    private Double t14;
    @ExcelProperty(value = "T15", index = 33)
    private Double t15;
    @ExcelProperty(value = "T16", index = 34)
    private Double t16;
    @ExcelProperty(value = "T17", index = 35)
    private Double t17;
    @ExcelProperty(value = "T18", index = 36)
    private Double t18;
    @ExcelProperty(value = "T19", index = 37)
    private Double t19;
    @ExcelProperty(value = "T20", index = 38)
    private Double t20;
    @ExcelProperty(value = "T21", index = 39)
    private Double t21;
    @ExcelProperty(value = "T22", index = 40)
    private Double t22;
    @ExcelProperty(value = "T23", index = 41)
    private Double t23;
    @ExcelProperty(value = "T24", index = 42)
    private Double t24;
    @ExcelProperty(value = "T25", index = 43)
    private Double t25;
    @ExcelProperty(value = "T26", index = 44)
    private Double t26;
    @ExcelProperty(value = "T27", index = 45)
    private Double t27;
    @ExcelProperty(value = "T28", index = 46)
    private Double t28;
    @ExcelProperty(value = "T29", index = 47)
    private Double t29;
    @ExcelProperty(value = "T30", index = 48)
    private Double t30;
    @ExcelProperty(value = "T31", index = 49)
    private Double t31;
    @ExcelProperty(value = "T32", index = 50)
    private Double t32;
    @ExcelProperty(value = "T33", index = 51)
    private Double t33;
    @ExcelProperty(value = "T34", index = 52)
    private Double t34;
    @ExcelProperty(value = "T35", index = 53)
    private Double t35;
    @ExcelProperty(value = "T36", index = 54)
    private Double t36;
    @ExcelProperty(value = "T37", index = 55)
    private Double t37;
    @ExcelProperty(value = "T38", index = 56)
    private Double t38;
    @ExcelProperty(value = "T39", index = 57)
    private Double t39;
    @ExcelProperty(value = "T40", index = 58)
    private Double t40;
    @ExcelProperty(value = "P0", index = 59)
    private Double p0;
    @ExcelProperty(value = "P1", index = 60)
    private Double p1;
    @ExcelProperty(value = "P2", index = 61)
    private Double p2;
    @ExcelProperty(value = "P3", index = 62)
    private Double p3;
    @ExcelProperty(value = "P4", index = 63)
    private Double p4;
    @ExcelProperty(value = "P5", index = 64)
    private Double p5;
    @ExcelProperty(value = "P6", index = 65)
    private Double p6;
    @ExcelProperty(value = "P7", index = 66)
    private Double p7;
    @ExcelProperty(value = "P8", index = 67)
    private Double p8;
    @ExcelProperty(value = "P9", index = 68)
    private Double p9;
    @ExcelProperty(value = "P10", index = 69)
    private Double p10;
    @ExcelProperty(value = "P11", index = 70)
    private Double p11;
    @ExcelProperty(value = "P12", index = 71)
    private Double p12;
    @ExcelProperty(value = "P13", index = 72)
    private Double p13;
    @ExcelProperty(value = "P14", index = 73)
    private Double p14;
    @ExcelProperty(value = "P15", index = 74)
    private Double p15;
}
