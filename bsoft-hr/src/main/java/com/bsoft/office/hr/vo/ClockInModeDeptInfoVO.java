package com.bsoft.office.hr.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

import java.util.List;

/**
 * @author: zy
 * @date: 2020/8/30
 * @description 部门考勤方式
 */
@Data
public class ClockInModeDeptInfoVO {
    // 一级部门
    @OperLogFieldName(value = "一级部门")
    private String dept;
    // 一级部门名称
    @OperLogFieldName(value = "一级部门名称")
    private String deptName;
    // 部门考勤方式
    @OperLogFieldName(value = "部门考勤方式")
    private Integer attendFlagDept;
    // 父部门
    @OperLogFieldName(value = "父部门")
    private String parentDept;
    // 子部门
    @OperLogFieldName(value = "子部门")
    private List<ClockInModeDeptInfoVO> children;
}
