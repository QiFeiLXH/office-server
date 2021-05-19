package com.bsoft.office.sales.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.HeadStyle;
import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;
import org.apache.poi.ss.usermodel.FillPatternType;

import java.util.Date;

@Data
@ExcelIgnoreUnannotated
public class SalesPlanViewVO{
    @OperLogFieldName(value = "ID")
    private Integer id;//主键
    @OperLogFieldName(value = "客户编码")
    private String customer;//客户编码
    @ExcelProperty(value = "客户名称", index = 3)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    @OperLogFieldName(value = "客户名称")
    private String customerName;//客户名称
    @ExcelProperty(value = "项目内容", index = 4)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    @OperLogFieldName(value = "项目内容")
    private String content;//产品内容 项目内容
    @ExcelProperty(value = "项目预算-软件（万）", index = 5)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    @OperLogFieldName(value = "预计软件额")
    private Double estimateSoftware;//预计软件额
    @ExcelProperty(value = "预计净销售额软件（万）", index = 6)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    @OperLogFieldName(value = "预计净销售额软件")
    private Double estimateNetSales;//预计净销售额软件
    @ExcelProperty(value = "项目预算-硬件（万）", index = 7)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    @OperLogFieldName(value = "预计硬件额")
    private Double estimateHardware;//预计硬件额
    @ExcelProperty(value = "预计时间", index = 8)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    @OperLogFieldName(value = "预计时间")
    private String estimateMonth;//预计时间
    @OperLogFieldName(value = "状态")
    private Integer status;//状态 1.审核中 2.已审核
    @OperLogFieldName(value = "跟单人")
    private String trackPerson;//跟单人
    @ExcelProperty(value = "跟单人", index = 1)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    @OperLogFieldName(value = "跟单人姓名")
    private String trackPersonName;//跟单人姓名
    @OperLogFieldName(value = "跟单部门")
    private String trackDept;//跟单部门
    @OperLogFieldName(value = "线索编号")
    private Integer clueId;//线索编号
    @ExcelProperty(value = "业务归属", index = 0)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    @OperLogFieldName(value = "业务归属")
    private String businessBelong;//业务归属
    @ExcelProperty(value = "项目阶段", index = 10)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    @OperLogFieldName(value = "项目阶段")
    private String stage;//项目阶段
    @ExcelProperty(value = "线索性质", index = 12)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    @OperLogFieldName(value = "线索性质")
    private String cluesNature;//线索性质
    @ExcelProperty(value = "线索来源", index = 13)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    @OperLogFieldName(value = "线索来源")
    private String cluesSource;//线索来源
    @ExcelProperty(value = "计划来源", index = 14)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    @OperLogFieldName(value = "计划来源")
    private String planSource;//计划来源
    @ExcelProperty(value = "最新进展", index = 11)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    @OperLogFieldName(value = "最新进展")
    private String latestDevelopment;//最新进展
    @ExcelProperty(value = "开标时间", index = 9)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    @OperLogFieldName(value = "开标时间")
    private String openingDate;//开标时间
    @OperLogFieldName(value = "上报日期")
    private Date reportDate;//上报日期
    @OperLogFieldName(value = "流程实例ID")
    private String processInstanceId;//流程实例id
    @OperLogFieldName(value = "跟单部门名称")
    private String trackDeptName;//跟单部门名称
    @OperLogFieldName(value = "已读标志")
    private Boolean readFlag;//已读标志
    @OperLogFieldName(value = "任务ID")
    private String taskId;//任务ID
}
