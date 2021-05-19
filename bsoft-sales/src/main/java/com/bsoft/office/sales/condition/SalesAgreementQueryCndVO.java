package com.bsoft.office.sales.condition;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/7/1 13:13
 * @Description
 */
@Data
public class SalesAgreementQueryCndVO{
    /** 页码 */
    private Integer pageNo;
    /** 每页条数 */
    private Integer pageSize;
    /** 合作单位名称、拼音 */
    private String partnerName;
    /** 是否披露 */
    private Integer notice;
    /** 合作类别 */
    private Integer cooperateType;
    /** 原件状态 */
    private Integer originalStatus;
    /** 合作开始日期 */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startDate;
    /** 合作结束日期 */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date endDate;

}
