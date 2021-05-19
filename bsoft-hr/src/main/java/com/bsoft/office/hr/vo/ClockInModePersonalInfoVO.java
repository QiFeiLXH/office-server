package com.bsoft.office.hr.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

/**
 * @author: zy
 * @date: 2020/8/30
 * @description 个人考勤方式
 */
@Data
public class ClockInModePersonalInfoVO {
    // 工号
    @OperLogFieldName(value = "工号")
    private String personId;
    // 姓名
    @OperLogFieldName(value = "姓名")
    private String personName;
    // 部门
    @OperLogFieldName(value = "部门")
    private String dept;
    // 部门名称
    @OperLogFieldName(value = "部门名称")
    private String deptName;
    // 部门考勤方式
    @OperLogFieldName(value = "部门考勤方式")
    private Integer attendFlagDept;
    // 个人考勤方式
    @OperLogFieldName(value = "个人考勤方式")
    private Integer attendFlagPersonal;

}
