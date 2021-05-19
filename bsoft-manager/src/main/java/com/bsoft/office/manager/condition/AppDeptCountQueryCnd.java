package com.bsoft.office.manager.condition;

import lombok.Data;

/**
 * @author: zy
 * @date: 2020/10/19
 * @description APP用户部门分布情况查询条件
 */
@Data
public class AppDeptCountQueryCnd {
    // 部门类别
    private Integer deptType;
    // 分页参数
    private Integer pageNo;
    // 分页参数
    private Integer pageSize;
}
