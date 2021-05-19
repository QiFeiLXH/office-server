package com.bsoft.office.project.condition;

import lombok.Data;

@Data
public class ProjectLogQueryCnd {
    private Integer pageSize;
    private Integer pageNo;
    private String startDate;
    private String endDate;
    private String userId;
}
