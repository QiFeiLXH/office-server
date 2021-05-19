package com.bsoft.office.hr.condition;

import lombok.Data;

/**
 * @author: zy
 * @date: 2020/8/14 16:41
 */
@Data
public class TrainChartCnd {
    // 培训年份
    private Integer trainYear;
    // 一级部门类别
    private Integer departmentType;
    // 培训类型
    private Integer trainType;
    // 页码
    private Integer pageNo;
    // 每页条目
    private Integer pageSize;
}
