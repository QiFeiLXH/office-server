package com.bsoft.office.project.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: zy
 * @date: 2020/8/6 19:04
 */
@Data
public class ProjectLogChartVO implements Serializable {
    /* 日期 */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "日期")
    private Date date;

    /* 结构化日志数量 */
    @OperLogFieldName(value = "结构化日志数量")
    private Integer projectLogCount;

    /* 普通日志数量 */
    @OperLogFieldName(value = "普通日志数量")
    private Integer workLogCount;

    /* APP日志数量 */
    @OperLogFieldName(value = "APP日志数量")
    private Integer appLogCount;

    /* 结构化日志占比 */
    @OperLogFieldName(value = "结构化日志占比")
    private Double projectLogRate;

}