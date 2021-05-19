package com.bsoft.office.work.condition;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/12/30 15:14
 * @Description
 */
@Data
public class ExpressQueryCnd {
    private Integer pageNo;
    private Integer pageSize;
    @DateTimeFormat(pattern = "yyyy-MM-dd" )
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd" )
    private Date endDate;
    private String inputContent;
    private String deptId;
    private Integer status;
}
