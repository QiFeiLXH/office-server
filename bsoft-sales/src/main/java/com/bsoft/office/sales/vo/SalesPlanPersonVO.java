package com.bsoft.office.sales.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

import java.util.Date;

@Data
public class SalesPlanPersonVO{
    @OperLogFieldName(value = "员工工号")
    private String personId;
    @OperLogFieldName(value = "员工姓名")
    private String personName;

}
