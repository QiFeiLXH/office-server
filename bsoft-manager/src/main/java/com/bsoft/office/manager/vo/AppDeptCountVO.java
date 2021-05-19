package com.bsoft.office.manager.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

/**
 * @author: zy
 * @date: 2020/10/19
 * @description APP用户部门分布情况
 */
@Data
public class AppDeptCountVO {
    // 部门编号
    @OperLogFieldName(value = "部门编号")
    private String dept;

    // 部门名称
    @OperLogFieldName(value = "部门名称")
    private String deptName;

    // 部门类别
    @OperLogFieldName(value = "部门类别")
    private Integer deptType;

    // 部门员工数
    @OperLogFieldName(value = "部门员工数")
    private Integer personCount;

    // 部门APP用户数
    @OperLogFieldName(value = "部门APP用户数")
    private Integer userCount;
}
