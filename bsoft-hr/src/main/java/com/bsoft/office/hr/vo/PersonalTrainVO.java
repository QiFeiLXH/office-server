package com.bsoft.office.hr.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

/**
 * @Author Xuhui Lin
 * @Date 2020/8/10 14:54
 * @Description
 */
@Data
public class PersonalTrainVO {
    @OperLogFieldName(value = "员工工号")
    private String personId;
    /** 员工姓名 */
    @OperLogFieldName(value = "员工姓名")
    private String personName;
    /** 员工姓名拼音简码 */
    @OperLogFieldName(value = "员工姓名拼音简码")
    private String simpleCode;
    /** 部门id */
    @OperLogFieldName(value = "部门id")
    private String deptId;
    /** 部门名称 */
    @OperLogFieldName(value = "部门名称")
    private String deptName;
    /** 年份 */
    @OperLogFieldName(value = "年份")
    private Integer year;
    /** 总授课课时 */
    @OperLogFieldName(value = "总授课课时")
    private Double totalTeachingHours;
    /** 总参训课时 */
    @OperLogFieldName(value = "总参训课时")
    private Double totalTrainingHours;
    /** eoffice在职培训课时 */
    @OperLogFieldName(value = "eoffice在职培训课时")
    private Double eofficeHours;
    /** 云学堂自主学习课时 */
    @OperLogFieldName(value = "云学堂自主学习课时")
    private Double yxtLearnSelfHours;
    /** 云学堂指派学习课时 */
    @OperLogFieldName(value = "云学堂指派学习课时")
    private Double yxtLearnAssignedHours;
    /** 知识分享数 */
    @OperLogFieldName(value = "知识分享数")
    private Integer shareCount;

}
