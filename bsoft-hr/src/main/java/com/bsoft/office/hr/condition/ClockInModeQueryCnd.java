package com.bsoft.office.hr.condition;

import lombok.Data;

/**
 * @author: zy
 * @date: 2020/8/30
 * @description 考勤方式维护查询参数
 */
@Data
public class ClockInModeQueryCnd {
    // 工号
    private String personId;
    // 姓名
    private String personName;
    // 部门
    private String dept;
    /* 部门类别 */
    private String deptType;
    // 页码
    private Integer pageNo;
    // 每页条目
    private Integer pageSize;
}
