package com.bsoft.office.hr.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/14 9:44
 * @Description
 */
@ExcelIgnoreUnannotated
@Data
public class PersonStockErrorTemplateVO {
    /** 工号 */
    @ExcelProperty(value = "工号", index = 0)
    @OperLogFieldName(value = "员工工号")
    private String personId;
    /** 姓名 */
    @ExcelProperty(value = "姓名", index = 1)
    @OperLogFieldName(value = "姓名")
    private String personName;
    /** 部门名称 */
    @ExcelProperty(value = "部门", index = 2)
    @OperLogFieldName(value = "部门名称")
    private String deptName;
    /** 失败原因 */
    @ExcelProperty(value = "失败原因", index = 3)
    @OperLogFieldName(value = "失败原因")
    private String failureReason;


}
