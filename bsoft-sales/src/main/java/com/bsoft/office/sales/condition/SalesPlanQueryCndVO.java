package com.bsoft.office.sales.condition;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
public class SalesPlanQueryCndVO {
    private Integer pageNo;
    private Integer pageSize;
    private Integer status;
    private String estimateMonth;
    private Date reportDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date planDate;
    private String trackPerson;
    private String trackDept;
    private String processInstanceId;
    private List<Integer> statusList;
    private String inputContent;
}
