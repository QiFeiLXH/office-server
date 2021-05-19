package com.bsoft.office.manager.condition;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author: zy
 * @date: 2020/10/27
 * @description
 */
@Data
public class RequestLogReportQueryCnd {
    private Integer menuId;
    private String url;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    private Integer pageNo;
    private Integer pageSize;

}
