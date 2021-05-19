package com.bsoft.office.hr.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.HeadStyle;
import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;
import org.apache.poi.ss.usermodel.FillPatternType;

import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/7/21 13:10
 * @Description 云学堂培训-知识分享视图  IndexedColors用来设置背景色的选择
 */
@Data
@ExcelIgnoreUnannotated
public class TrainKnowledgeShareViewVO{
    @OperLogFieldName(value = "id")
    private Integer id;
    /** 员工工号 */
    @ExcelProperty(value = "账号", index = 1)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    @OperLogFieldName(value = "员工工号")
    private String personId;
    /** 员工姓名 */
    @ExcelProperty(value = "姓名", index = 0)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 1)
    @OperLogFieldName(value = "姓名")
    private String personName;
    /** 所在部门 */
    @OperLogFieldName(value = "所在部门")
    private String deptId;
    /** 所在部门名称 */
    @OperLogFieldName(value = "所在部门名称")
    private String deptName;
    /** 知识名称 */
    @ExcelProperty(value = "知识名称", index = 2)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    @OperLogFieldName(value = "知识名称")
    private String knowledgeName;
    /** 分享时间 */
    @OperLogFieldName(value = "分享时间")
    private Date shareDate;
    @ExcelProperty(value = "分享时间", index = 3)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    @DateTimeFormat("yyyy/MM/dd HH:mm:ss")
    @OperLogFieldName(value = "分享时间")
    private String shareDateStr;
    /** 登记人 */
    @OperLogFieldName(value = "登记人")
    private String register;
    /** 登记日期 */
    @OperLogFieldName(value = "登记日期")
    private Date registrationDate;

}
