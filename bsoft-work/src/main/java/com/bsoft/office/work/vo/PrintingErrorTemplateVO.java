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
 * @Date 2021/1/27 14:08
 * @Description
 */
@Data
@ExcelIgnoreUnannotated
public class PrintingErrorTemplateVO {
    /** 订单编号 */
    @ExcelProperty(value = "订单编号", index = 0)
    @ColumnWidth(25)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    @OperLogFieldName(value = "订单编号")
    private String orderNum;
    /** 客户名称 */
    @ExcelProperty(value = "客户名称", index = 1)
    @ColumnWidth(15)
    @OperLogFieldName(value = "客户名称")
    private String printUnitName;
    /** 联系人 */
    @ExcelProperty(value = "联系人", index = 2)
    @ColumnWidth(15)
    @OperLogFieldName(value = "联系人")
    private String contactPerson;
    /** 订单金额 */
    @ExcelProperty(value = "订单金额", index = 3)
    @ColumnWidth(20)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    @OperLogFieldName(value = "订单金额")
    private String approvalStr;
    private Double approval;
    /** 失败原因 */
    @ExcelProperty(value = "失败原因", index = 4)
    @ColumnWidth(25)
    @OperLogFieldName(value = "失败原因")
    private String failureReason;

}
