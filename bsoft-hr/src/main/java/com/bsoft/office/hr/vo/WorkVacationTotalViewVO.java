package com.bsoft.office.hr.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

/**
 * @author: zy
 * @date: 2020/8/20
 */
@Data
public class WorkVacationTotalViewVO {
    // 年份
    @OperLogFieldName(value = "年份")
    private String year;

    // 员工工号
    @OperLogFieldName(value = "员工工号")
    private String personId;

    // 员工姓名
    @OperLogFieldName(value = "员工姓名")
    private String personName;

    // 部门编号
    @OperLogFieldName(value = "部门编号")
    private String deptId;

    // 部门名称
    @OperLogFieldName(value = "部门名称")
    private String deptName;

    // 总调休假
    @OperLogFieldName(value = "总调休假")
    private Double workTimes;

    // 已用调休假
    @OperLogFieldName(value = "已用调休假")
    private Double useTimes;

    // 未用调休假
    @OperLogFieldName(value = "未用调休假")
    private Double restTimes;
}
