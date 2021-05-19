package com.bsoft.office.organ.condition;

import lombok.Data;

@Data
public class



DeptMaintainInfoQueryCnd {


    // 部门
    private String dept;
    /* 部门类别 */
    private String deptType;
    // 页码
    private Integer pageNo;
    // 每页条目
    private Integer pageSize;

    /** 维护标志 0未维护财务类别部门 1全部部门 */
    private Integer maintain;
    /** 维护状态 0未维护财务类别部门 1已维护 */
    private Integer maintainType;
    /** 部门财务类别 1,按部门 2，按岗位 */
    private Integer PersonTypeFlag;
}
