package com.bsoft.office.project.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

/**
 * @author: zy
 * @date: 2020/8/17 14:28
 */
@Data
public class ProjectLogChartMonthVO {
    /* 月份 */
    @OperLogFieldName(value = "月份")
    private Integer date;

    /* 平均结构化日志数量 */
    @OperLogFieldName(value = "平均结构化日志数量")
    private Double projectLogCount;

    /* 平均普通日志数量 */
    @OperLogFieldName(value = "平均普通日志数量")
    private Double workLogCount;

    /* 平均APP日志数量 */
    @OperLogFieldName(value = "平均APP日志数量")
    private Double appLogCount;

    /* 平均结构化日志占比 */
    @OperLogFieldName(value = "平均结构化日志占比")
    private Double projectLogRate;

}
