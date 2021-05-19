package com.bsoft.office.hr.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/8/3 12:29
 * @Description
 */
@Data
public class RankViewVO {
    @OperLogFieldName(value = "id")
    private Integer id;
    /** 员工id */
    @OperLogFieldName(value = "员工id")
    private String personId;
    /** 员工姓名 */
    @OperLogFieldName(value = "员工姓名")
    private String personName;
    /** 拼音简码 */
    @OperLogFieldName(value = "拼音简码")
    private String simpleCode;
    /** 部门id */
    @OperLogFieldName(value = "部门id")
    private String deptId;
    /** 部门名称 */
    @OperLogFieldName(value = "部门名称")
    private String deptName;
    /** 职级序列 */
    @OperLogFieldName(value = "职级序列")
    private Integer rankSequence;
    @OperLogFieldName(value = "职级序列文本")
    private String rankSequenceText;
    /** 专业职级 */
    @OperLogFieldName(value = "专业职级")
    private Integer grade;
    @OperLogFieldName(value = "专业职级文本")
    private String gradeText;
    /** 评定日期 */
    @OperLogFieldName(value = "评定日期")
    private Date evalDate;
    /** 领导意见 */
    @OperLogFieldName(value = "领导意见")
    private String leaderOpinion;
    /** 专家意见 */
    @OperLogFieldName(value = "专家意见")
    private String expertOpinion;
    /** 申报职级 */
    @OperLogFieldName(value = "申报职级")
    private Integer declareGrade;
    @OperLogFieldName(value = "申报职级文本")
    private String declareGradeText;
    /** 申报日期 */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "申报日期")
    private Date declareDate;
    /** 评分 */
    @OperLogFieldName(value = "评分")
    private Double evalScore;
    /** 评定结果 */
    @OperLogFieldName(value = "评定结果")
    private Integer evalResult;
    /** 年度 */
    @OperLogFieldName(value = "年度")
    private Integer year;
    /** 文件服务器文件id */
    @OperLogFieldName(value = "文件服务器文件id")
    private Integer pptId;
    /** ppt文件名 */
    @OperLogFieldName(value = "ppt文件名")
    private String pptName;

}
