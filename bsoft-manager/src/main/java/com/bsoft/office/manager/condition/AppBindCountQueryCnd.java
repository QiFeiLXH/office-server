package com.bsoft.office.manager.condition;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author: zy
 * @date: 2020/10/22
 * @description
 */
@Data
public class AppBindCountQueryCnd {
    /* 开始日期 */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    /* 结束日期 */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    /* 页码 */
    private Integer pageNo;
    /* 每页条数 */
    private Integer pageSize;
}
