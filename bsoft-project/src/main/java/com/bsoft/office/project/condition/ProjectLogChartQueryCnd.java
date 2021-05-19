package com.bsoft.office.project.condition;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author: zy
 * @date: 2020/8/12 16:40
 */
@Data
public class ProjectLogChartQueryCnd {
    // 年份
    private Integer year;
    // 开始日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    // 结束日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    // 页码
    private Integer pageNo;
    // 每页数量
    private Integer pageSize;

}