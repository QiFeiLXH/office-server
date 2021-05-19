package com.bsoft.office.project.vo;


import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Author: lkh
 * @DateTime: 2021/4/21 14:50
 * @Description:
 */

@Data
public class ProjectProductViewVO {
    @OperLogFieldName(value = "ID")
    private Integer id;
    /** 合同号 */
    @OperLogFieldName(value = "合同号")
    private String contractNo;
    /** 合同名称 */
    @OperLogFieldName(value = "合同名称")
    private String contractName;
    /** 项目id */
    @OperLogFieldName(value = "项目id")
    private String projectId;
    /** 项目名称 */
    @OperLogFieldName(value = "项目名称")
    private String projectName;
    /** 项目经理工号 */
    @OperLogFieldName(value = "项目经理工号")
    private String projectManager;
    /** 项目经理姓名 */
    @OperLogFieldName(value = "项目经理姓名")
    private String projectManagerName;
    /** 进度经理 */
    @OperLogFieldName(value = "进度经理")
    private String progressManager;
    /** 进度经理姓名 */
    @OperLogFieldName(value = "进度经理姓名")
    private String progressManagerName;
    /**一级部门Id */
    @OperLogFieldName(value = "一级部门Id")
    private Integer collDeptParent;
    /**一级部门名称 */
    @OperLogFieldName(value = "一级部门名称")
    private String collDeptParentName;
    /**二级部门Id */
    @OperLogFieldName(value = "二级部门Id")
    private String collectionDept;
    /**二级部门名称 */
    @OperLogFieldName(value = "二级部门名称")
    private String collectionDeptName;
    /**回款部门Id */
    @OperLogFieldName(value = "回款部门Id")
    private String rollbackDept;
    /**回款部门名称 */
    @OperLogFieldName(value = "回款部门名称")
    private String rollbackDeptName;
    /** 维护情况 */
    @OperLogFieldName(value = "维护情况")
    private Integer maintain;
    /** 维护情况标志  0 未维护  1 已维护 */
    @OperLogFieldName(value = "维护情况标志  0 未维护  1 已维护")
    private Integer maintainFlag;
    @OperLogFieldName(value = "上报进度标志  0 不上报  1上报")
    private Integer reportFlag;
    /** 立项日期 PROAPPLYDATE*/
    @OperLogFieldName(value = "立项日期")
    private Date proApplyDate;
    private Integer pageNo;
    private Integer pageSize;

}
