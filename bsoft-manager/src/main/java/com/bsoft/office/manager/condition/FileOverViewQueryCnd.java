package com.bsoft.office.manager.condition;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author: zy
 * @date: 2020/8/17 17:24
 */
@Data
public class FileOverViewQueryCnd {
    private Integer id;
    private String fileName;
    private Integer menuId;
    private Integer fileYear;
    private Integer fileMonth;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endDate;
    private Integer pageNo;
    private Integer pageSize;
}
