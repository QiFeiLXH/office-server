package com.bsoft.office.hr.condition;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @version 1.0
 * @author: zy
 * @date: 2020/12/14
 * @description 劳动合同流程查询参数
 */
@Data
public class LaborContractProcessTaskQueryCnd {
    /** 申请ID*/
    private String applyId;
    /** 申请人ID*/
    private String applyUserId;
    /** 待办人ID*/
    private String personId;
    /** 接收时间范围--开始*/
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date startDate;
    /** 结束时间范围--结束*/
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date endDate;
    /** 是否完结*/
    private Boolean finished;
    /** 页码*/
    private Integer pageNo;
    /** 每页条目*/
    private Integer pageSize;
    /** 知会是否完结*/
    private Integer flag;
}
