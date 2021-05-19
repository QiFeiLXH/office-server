package com.bsoft.office.work.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.HeadStyle;
import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;
import org.apache.poi.ss.usermodel.FillPatternType;

/**
 * @Author zhanglf
 * @Date 2020-12-21 16:23
 * @Version 1.0
 * 导入会议人员名单
 */
@Data
@ExcelIgnoreUnannotated
public class MeetPersonExcelErrorVO {
    private Integer meetId;
    @ExcelProperty(value = "姓名", index = 0)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    @OperLogFieldName(value = "姓名")
    private String personName;
    @ExcelProperty(value = "手机号码", index = 1)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    @OperLogFieldName(value = "手机号码")
    private String mobileNo;
    /** 导入失败原因*/
    @ExcelProperty(value = "导入失败原因", index = 2)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 1)
    @OperLogFieldName(value = "导入失败原因")
    private String failReason;
}
