package com.bsoft.office.project.condition;

import lombok.Data;

import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/5/12 13:16
 * @Description
 */
@Data
public class ProjectDutyQueryCnd {
    private Integer year;
    private Integer startYear;
    private Integer endYear;
    private Integer auditFlag;
    private String userId;
    private Date startDate;
    private Date endDate;
    private Integer pageNo;
    private Integer pageSize;
    private String customerName;
    private String dutyName;
}
