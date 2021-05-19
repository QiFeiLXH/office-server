package com.bsoft.office.hr.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: zy
 * @date: 2020/8/5 12:01
 */
@Data
public class TrainChartVO implements Serializable {

    // 培训年份
    @OperLogFieldName(value = "培训年份")
    private Integer trainYear;

    // 一级部门名称
    @OperLogFieldName(value = "一级部门名称")
    private String department;

    // 一级部门类别
    @OperLogFieldName(value = "一级部门类别")
    private Integer departmentType;

    //  培训类型
    @OperLogFieldName(value = "培训类型")
    private Integer trainType;

    // 培训数量
    @OperLogFieldName(value = "培训数量")
    private Integer attendCount;

}