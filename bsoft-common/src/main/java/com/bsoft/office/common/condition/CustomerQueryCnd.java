package com.bsoft.office.common.condition;

import lombok.Data;

/**
 * @author: zy
 * @date: 2020/12/7
 * @description 客户基本信息查询参数
 */
@Data
public class CustomerQueryCnd {
    private String inputContent;
    private Integer pageNo;
    private Integer pageSize;
}
