package com.bsoft.office.manager.condition;

import lombok.Data;

/**
 * @author: zy
 * @date: 2020/12/4
 * @description 流程组角色查询参数
 */
@Data
public class GroupRoleQueryCnd {
    /** 输入内容*/
    private String inputContent;
    /** 页码*/
    private Integer pageNo;
    /** 每页条数*/
    private Integer pageSize;
}
