package com.bsoft.office.hr.condition;

import lombok.Data;

/**
 * @version 1.0
 * @author: zy
 * @date: 2020/12/14
 * @description 劳动合同查询参数
 */
@Data
public class LaborContractQueryCnd {
    /** 工号*/
    private String personId;
    /** 部门*/
    private String dept;
    /** 离职标志0未离职1已离职*/
    private String flag;
    /** 页码*/
    private Integer pageNo;
    /** 每页条目*/
    private Integer pageSize;
}
