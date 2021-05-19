package com.bsoft.office.hr.condition;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @BelongsProject: bsoft-office-server
 * @BelongsPackage: com.bsoft.office.administration.condition
 * @Author: Xuhui Lin
 * @CreateTime: 2020-07-21 19:48
 * @Description:
 */
@Data
public class TrainKnowledgeQueryCnd {
    /** 页码 */
    private Integer pageNo;
    /** 每页条数 */
    private Integer pageSize;
    /** 输入内容 */
    private String inputContent;
    /** 部门id */
    private String deptId;
    /** 登记开始日期 */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startDate;
    /** 登记结束日期 */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date endDate;
}
