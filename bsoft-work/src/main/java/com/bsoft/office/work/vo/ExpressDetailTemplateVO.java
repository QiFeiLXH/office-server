package com.bsoft.office.work.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.HeadStyle;
import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;
import org.apache.poi.ss.usermodel.FillPatternType;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/20 10:43
 * @Description
 */
@Data
@ExcelIgnoreUnannotated
public class ExpressDetailTemplateVO {
    @ExcelProperty(value = "运单号", index = 0)
    @ColumnWidth(25)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    @OperLogFieldName(value = "运单号")
    private String expressNo;
    @ExcelProperty(value = "应收金额", index = 1)
    @ColumnWidth(15)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    @OperLogFieldName(value = "应收金额")
    private String approvalStr;
    private Double approval;
    @ColumnWidth(20)
    @ExcelProperty(value = "结算重量", index = 2)
    @OperLogFieldName(value = "结算重量")
    private String weight;
    @ColumnWidth(20)
    @ExcelProperty(value = "寄件人", index = 3)
    @OperLogFieldName(value = "寄件人")
    private String sender;
}
