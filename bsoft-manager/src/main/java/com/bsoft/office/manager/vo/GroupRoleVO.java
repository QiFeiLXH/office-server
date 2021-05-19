package com.bsoft.office.manager.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

/**
 * @author: zy
 * @date: 2020/12/4
 * @description 流程组角色
 */
@Data
public class GroupRoleVO {
    /** 主键*/
    @OperLogFieldName(value = "ID")
    private Integer id;

    /** 组名称*/
    @OperLogFieldName(value = "组名称")
    private String groupName;

    /** 组成员*/
    @OperLogFieldName(value = "组成员")
    private String users;

    /** 组成员姓名*/
    @OperLogFieldName(value = "组成员姓名")
    private String usersName;
}
