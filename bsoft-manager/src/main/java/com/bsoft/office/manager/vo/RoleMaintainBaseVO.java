package com.bsoft.office.manager.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

/*
 * @author  hy
 * @date  2020/8/4 21:15
 * @description
 */
@Data
public class RoleMaintainBaseVO {
    private Integer roleId;
    private String role;
    @OperLogFieldName(value = "角色名称")
    private String roleName;
    @OperLogFieldName(value = "工号")
    private String userId;
    @OperLogFieldName(value = "姓名")
    private String userName;
    @OperLogFieldName(value = "人员部门代码")
    private String userDept;
    @OperLogFieldName(value = "人员部门名称")
    private String userDeptName;
    @OperLogFieldName(value = "部门")
    private String dept;
    private Integer id;
    @OperLogFieldName(value = "来源")
    private Integer sourceType;
}
