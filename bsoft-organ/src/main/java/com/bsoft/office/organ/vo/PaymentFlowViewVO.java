package com.bsoft.office.organ.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.HeadStyle;
import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.poi.ss.usermodel.FillPatternType;

import java.util.Date;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.payment.entity.primary
 * @Author: Qi fei
 * @CreateTime: 2020-07-25 18:08
 * @Description: 财务流水
 */
@Data
@ExcelIgnoreUnannotated
public class PaymentFlowViewVO {
    @OperLogFieldName(value = "id")
    private Integer id;
    /** 部门id */
    @OperLogFieldName(value = "部门id")
    private String deptId;
    @ExcelProperty(value = "所属部门", index = 1)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    @OperLogFieldName(value = "所属部门")
    private String deptName;
    /** 一级部门 */
    @OperLogFieldName(value = "一级部门")
    private String parentDeptId;
    @ExcelProperty(value = "所属区域", index = 0)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 1)
    @OperLogFieldName(value = "所属区域")
    private String parentDeptName;
    /** 机构名称 */
    @ExcelProperty(value = "机构名称", index = 2)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    @OperLogFieldName(value = "机构名称")
    private String orgName;
    /** 业务条线 */
    @OperLogFieldName(value = "业务条线")
    private Integer businessLine;
    @ExcelProperty(value = "业务条线", index = 3)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    @OperLogFieldName(value = "业务条线")
    private String businessLineText;
    /** 类别 */
    @OperLogFieldName(value = "类别")
    private Integer type;
    @ExcelProperty(value = "类别", index = 4)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    @OperLogFieldName(value = "类别")
    private String typeText;
    /** 金额 */
    @OperLogFieldName(value = "金额")
    private Double amount;
    @ExcelProperty(value = "流水", index = 5)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    @OperLogFieldName(value = "流水")
    private String amountStr;
    /** 核算时间 */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "核算时间")
    private Date accountDate;
    @ExcelProperty(value = "核算时间", index = 6)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    @DateTimeFormat("yyyy.MM.dd")
    @OperLogFieldName(value = "核算时间")
    private String accountDateStr;
    /** 审核日期 */
    @OperLogFieldName(value = "审核日期")
    private Date auditDate;
    /** 审核标记 0 未审核 1审核 */
    @OperLogFieldName(value = "审核标记")
    private Integer auditFlag;
    /** 审核人 */
    @OperLogFieldName(value = "审核人")
    private String auditter;
    /** 备注信息 */
    @ExcelProperty(value = "备注信息", index = 7)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 1)
    @OperLogFieldName(value = "备注信息")
    private String remark;
    /** 登记日期 */
    @OperLogFieldName(value = "登记日期")
    private Date registrationDate;
    /** 登记人 */
    @OperLogFieldName(value = "登记人")
    private String register;
    @OperLogFieldName(value = "登记人")
    private String registerName;
    /** 1.流水  2.收益 */
    @OperLogFieldName(value = "标志")
    private Integer flag;

}
