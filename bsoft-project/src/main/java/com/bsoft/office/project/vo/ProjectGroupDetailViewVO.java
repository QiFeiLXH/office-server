package com.bsoft.office.project.vo;


import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.project.report.entity
 * @Author: Xuhui lin
 * @CreateTime: 2020-02-06
 * @Description: 项目组成员明细视图
 */
@Data
public class ProjectGroupDetailViewVO {
    /** id */
    @OperLogFieldName(value = "ID")
    private Integer id;
    /** id,用于表格展示唯一键  */
    @OperLogFieldName(value = "表格展示唯一键")
    private Integer detailKey;
    /** 项目组ID  */
    @OperLogFieldName(value = "项目组ID")
    private Integer groupId;
    /** 项目组组名  */
    @OperLogFieldName(value = "项目组名称")
    private String groupName;
    /** 合同编号  */
    @OperLogFieldName(value = "合同编号")
    private String contractNo;
    /** 组成员工号  */
    @OperLogFieldName(value = "组成员工号")
    private String personId;
    /** 组成员工姓名  */
    @OperLogFieldName(value = "组成员姓名")
    private String personName;
    /** 组成员工姓名拼音简码  */
    @OperLogFieldName(value = "组成员拼音码")
    private String simpleCode;
    /** 一级部门id  */
    @OperLogFieldName(value = "一级部门ID")
    private String largeDeptId;
    /** 一级部门名称  */
    @OperLogFieldName(value = "一级部门名称")
    private String largeDeptName;
    /** 组成员工部门代码  */
    @OperLogFieldName(value = "组成员部门代码")
    private String deptCode;
    /** 组成员工部门名称  */
    @OperLogFieldName(value = "组成员部门名称")
    private String deptName;
    /** 1、组长 0、组员  */
    @OperLogFieldName(value = "是否组长")
    private Integer leader;
    /** 在职标志 1、离职 0、在职 */
    @OperLogFieldName(value = "在职标志")
    private String isValid;
    /** 所属项目项目组长工号  */
    @OperLogFieldName(value = "项目组长工号")
    private String leaderId;
    /** 所属项目项目组长姓名  */
    @OperLogFieldName(value = "项目组长姓名")
    private String leaderName;
    /** 所属项目项目组长id  */
    @OperLogFieldName(value = "项目组长ID")
    private Integer leaderKey;
    /** 项目组组长维护工号 */
    @OperLogFieldName(value = "项目组长维护工号")
    private String maintainId;

}
