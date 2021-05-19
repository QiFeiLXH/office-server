package com.bsoft.office.hr.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

/**
 * @Author Xuhui Lin
 * @Date 2020/8/19 10:59
 * @Description
 */

@Data
public class WorkLeaveVacationVO {
    /** 工号 */
    @OperLogFieldName(value = "工号")
    private String personId;
    /** 姓名 */
    @OperLogFieldName(value = "姓名")
    private String personName;
    /** 拼音 */
    @OperLogFieldName(value = "拼音")
    private String simpleCode;
    /** 部门id */
    @OperLogFieldName(value = "部门id")
    private String deptId;
    /** 部门名称 */
    @OperLogFieldName(value = "部门名称")
    private String deptName;
    /** 历年年休 */
    @OperLogFieldName(value = "历年年休")
    private Double oldAnnualDays;
    /** 当年年休 */
    @OperLogFieldName(value = "当年年休")
    private Double currentAnnualDays;
    /** 已用年休 */
    @OperLogFieldName(value = "已用年休")
    private Double annualDaysUsed;
    /** 剩余年休 */
    @OperLogFieldName(value = "剩余年休")
    private Double annualDaysLeft;
    /** 历年调休 */
    @OperLogFieldName(value = "历年调休")
    private Double oldRestDays;
    /** 当年调休 */
    @OperLogFieldName(value = "当年调休")
    private Double currentRestDays;
    /** 已用调休 */
    @OperLogFieldName(value = "已用调休")
    private Double restDaysUsed;
    /** 剩余调休 */
    @OperLogFieldName(value = "剩余调休")
    private Double restDaysLeft;

}
