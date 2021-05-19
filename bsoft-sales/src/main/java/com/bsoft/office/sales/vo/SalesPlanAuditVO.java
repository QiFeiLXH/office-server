package com.bsoft.office.sales.vo;

import lombok.Data;

@Data
public class SalesPlanAuditVO {
    private String processInstanceId;
    private String taskId;
    private String opinion;
    private Integer flag;
    private Integer system;
    private Integer id;
    private SalesPlanVO salesPlanVO;


}
