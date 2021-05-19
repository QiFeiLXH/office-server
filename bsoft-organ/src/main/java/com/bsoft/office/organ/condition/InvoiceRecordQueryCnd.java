package com.bsoft.office.organ.condition;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/15 10:31
 * @Description
 */
@Data
public class InvoiceRecordQueryCnd {
    /** 页码 */
    private Integer pageNo;
    /** 页量 */
    private Integer pageSize;
    /** 开始日期 */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startDate;
    /** 结束日期 */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date endDate;
    /** 部门id */
    private String deptId;
    /** 开票标志 */
    private Integer invoiceFlag;
    /** 输入内容 */
    private String inputContent;

}
