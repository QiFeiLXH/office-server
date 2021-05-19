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
 * @Date 2020/7/21 13:09
 * @Description 云学堂培训-知识学习视图
 */
@Data
@ExcelIgnoreUnannotated
public class TrainKnowledgeLearnViewVO{
    @OperLogFieldName(value = "id")
    private Integer id;
    /** 员工工号 */
    @ExcelProperty(value = "工号", index = 0)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    @OperLogFieldName(value = "员工工号")
    private String personId;
    /** 员工姓名 */
    @ExcelProperty(value = "姓名", index = 1)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 1)
    @OperLogFieldName(value = "员工姓名")
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
    /** 学习进度 */
    @OperLogFieldName(value = "学习进度")
    private Double learningRate;
    @ExcelProperty(value = "学习进度", index = 3)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    @OperLogFieldName(value = "学习进度")
    private String learningRateStr;
    /** 学习模式 */
    @ExcelProperty(value = "学习模式", index = 4)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    @OperLogFieldName(value = "学习模式")
    private String learningModel;
    /** 学习时长（存的分钟） */
    @OperLogFieldName(value = "学习时长")
    private Double learningTime;
    @ExcelProperty(value = "学习时长(分钟)", index = 5)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    @OperLogFieldName(value = "学习时长(分钟)")
    private String learningTimeStr;
    /** 获得学分 */
    @OperLogFieldName(value = "获得学分")
    private Double earnedCredits;
    @ExcelProperty(value = "获得学分", index = 6)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    @OperLogFieldName(value = "获得学分")
    private String earnedCreditsStr;
    /** 开始时间-取的首次学习时间 */
    @OperLogFieldName(value = "开始时间")
    private Date startDate;
    @ExcelProperty(value = "首次学习时间", index = 7)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    @DateTimeFormat("yyyy/MM/dd HH:mm")
    @OperLogFieldName(value = "首次学习时间")
    private String startDateStr;
    /** 结束时间 */
    @OperLogFieldName(value = "结束时间")
    private Date endDate;
    @ExcelProperty(value = "最近学习时间", index = 8)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    @DateTimeFormat("yyyy/MM/dd HH:mm")
    @OperLogFieldName(value = "最近学习时间")
    private String endDateStr;
    /** 登记人 */
    @OperLogFieldName(value = "登记人")
    private String register;
    /** 登记时间 */
    @OperLogFieldName(value = "登记时间")
    private Date registrationDate;

}
