package com.bsoft.office.organ.condition;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @BelongsProject: bsoft-office-server
 * @BelongsPackage: com.bsoft.office.administration.condition
 * @Author: Qi fei
 * @CreateTime: 2020-07-26 10:12
 * @Description:
 */
@Data
public class FlowPaymentQueryCnd {
    /** 页码 */
    private Integer pageNo;
    /** 每页条数 */
    private Integer pageSize;
    /** 1.流水  2.收益 */
    private Integer flag;
    /** 审核标记 */
    private Integer auditFlag;
    /** 类别 */
    private Integer type;
    /** 业务条线 */
    private Integer businessLine;
    /** 所属区域 */
    private String parentDeptId;
    /** 登记开始日期 */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startDate;
    /** 登记结束日期 */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date endDate;
}
