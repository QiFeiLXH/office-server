package com.bsoft.office.hr.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.HeadStyle;
import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;
import org.apache.poi.ss.usermodel.FillPatternType;

import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/14 9:44
 * @Description
 */
@ExcelIgnoreUnannotated
@Data
public class PersonStockTemplateVO {
    /** 工号 */
    @ExcelProperty(value = "工号", index = 0)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    @OperLogFieldName(value = "工号")
    private String personId;
    /** 姓名 */
    @ExcelProperty(value = "姓名", index = 1)
    @OperLogFieldName(value = "姓名")
    private String personName;
    /** 部门名称 */
    @ExcelProperty(value = "部门", index = 2)
    @OperLogFieldName(value = "部门")
    private String deptName;
    /** 登记人 */
    @OperLogFieldName(value = "登记人")
    private String register;
    /** 备注 */
    @OperLogFieldName(value = "备注")
    private String remark;
    /** 登记日期 */
    @OperLogFieldName(value = "登记日期")
    private Date registerDate;


}
