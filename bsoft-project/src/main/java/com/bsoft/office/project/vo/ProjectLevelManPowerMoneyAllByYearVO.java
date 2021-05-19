package com.bsoft.office.project.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

import java.io.Serializable;

/**
 * C02
 */
@Data
@ExcelIgnoreUnannotated
public class ProjectLevelManPowerMoneyAllByYearVO implements Serializable {
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
    @ExcelProperty(value = "项目ID", index = 16)
    private String PROJECTID;
    @ExcelProperty(value = "项目名称", index = 17)
    private String PROJECTNAME;
    @ExcelProperty(value = "项目金额", index = 18)
    private Double PROJECTAMOUNT;
    @ExcelProperty(value = "项目类别", index = 19)
    private String PROJECTFLAGTEXT;
    @ExcelProperty(value = "项目类型", index = 20)
    private String PROJECTTYPETEXT;
    @ExcelProperty(value = "验收标记", index = 21)
    private String ACCEPTANCESTAMP;
    @ExcelProperty(value = "人力成本金额年度", index = 22)
    private String YEAR;
    @ExcelProperty(value = "人力成本金额", index = 23)
    private Double AMOUNT;
}
