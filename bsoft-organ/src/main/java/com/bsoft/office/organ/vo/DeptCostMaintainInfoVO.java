package com.bsoft.office.organ.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

import java.util.List;

/**
 * @author: lkh
 * @date: 2020/12/18
 * @description 部门财务类别维护方式
 */
@Data
public class DeptCostMaintainInfoVO {
    // 一级部门
    @OperLogFieldName(value = "一级部门")
    private String dept;
    // 一级部门名称
    @OperLogFieldName(value = "一级部门名称")
    private String deptName;
    /** 维护标志 0未维护财务类别部门 1全部部门 */
    @OperLogFieldName(value = "维护标志 0未维护财务类别部门 1全部部门")
    private Integer maintain;
//    /** 维护状态 0未维护财务类别部门 1已维护 */
//    private Integer maintainType;
    // 父部门
    @OperLogFieldName(value = "父部门")
    private String parentDept;
    // 子部门
    @OperLogFieldName(value = "子部门")
    private List<DeptCostMaintainInfoVO> children;

    /** 部门财务类别 1,按部门 2，按岗位 */
    @OperLogFieldName(value = "部门财务类别 1,按部门 2，按岗位")
    private Integer PersonTypeFlag;

    /** 部门是否维护标志 0 未维护 1已维护 */
    @OperLogFieldName(value = "部门是否维护标志 0 未维护 1已维护")
    private Integer flag;


}
