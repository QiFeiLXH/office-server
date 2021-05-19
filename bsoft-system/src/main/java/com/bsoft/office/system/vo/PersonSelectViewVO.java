package com.bsoft.office.system.vo;

import lombok.Data;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.person.dto
 * @Author: Xuhui Lin
 * @CreateTime: 2020-03-14 15:57
 * @Description:
 */
@Data
public class PersonSelectViewVO {
    /** 员工工号 */
    private String personId;
    /** 员工姓名 */
    private String personName;
    /** 部门代码 */
    private String deptCode;
    /** 部门名称 */
    private String deptName;
    /** 员工姓名拼音 */
    private String simpleCode;
    /** 一级部门id */
    private Integer largeDeptId;
    /** 一级部门名称 */
    private String largeDeptName;
    /** 员工离职标志 0未离职 1离职 */
    private String isValid;

    private String mobile;

    private String email;

    private Integer company;

}
