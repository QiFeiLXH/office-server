package com.bsoft.office.sales.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

@Data
public class SalesPlanDeptVO {
    @OperLogFieldName(value = "部门编码")
    private String deptId;
    @OperLogFieldName(value = "部门名称")
    private String deptName;

}
