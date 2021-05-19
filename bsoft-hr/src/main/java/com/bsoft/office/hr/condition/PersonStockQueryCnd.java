package com.bsoft.office.hr.condition;

import lombok.Data;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/14 10:14
 * @Description
 */
@Data
public class PersonStockQueryCnd {
    private Integer pageNo;
    private Integer pageSize;
    private String flag;
    private String inputContent;
}
