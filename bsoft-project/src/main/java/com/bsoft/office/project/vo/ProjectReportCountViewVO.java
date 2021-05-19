package com.bsoft.office.project.vo;


import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

import java.util.Date;

/**
 * @Author: lkh
 * @DateTime: 2021/5/17 14:50
 * @Description:
 */
@Data
public class ProjectReportCountViewVO {
    @OperLogFieldName(value = "主键")
    private Integer id;
    /**一级部门Id */
    @OperLogFieldName(value = "一级部门Id")
    private Integer collDeptParent;
    /**一级部门名称 */
    @OperLogFieldName(value = "一级部门名称")
    private String collDeptParentName;
    /**一级部门需要上报数量 */
    @OperLogFieldName(value = "一级部门需要上报数量")
    private Integer collDeptParentNeedMaintain;
    /**一级部门已上报数量 */
    @OperLogFieldName(value = "一级部门已上报数量")
    private Integer collDeptParentMaintain;
    /**一级部门未上报数量 */
    @OperLogFieldName(value = "一级部门未上报数量")
    private Integer collDeptParentNotMaintain;
    /**二级部门Id */
    @OperLogFieldName(value = "二级部门Id")
    private String collectionDept;
    /**二级部门名称 */
    @OperLogFieldName(value = "二级部门名称")
    private String collectionDeptName;
    /**二级部门需要上报数量 */
    @OperLogFieldName(value = "二级部门需要上报数量")
    private String collectionDeptNeedMaintain;
    /**二级部门已上报数量 */
    @OperLogFieldName(value = "二级部门已上报数量")
    private String collectionDeptMaintain;
    /**二级部门未上报数量 */
    @OperLogFieldName(value = "二级部门未上报数量")
    private String collectionDeptNotMaintain;
    /**进度月份*/
    @OperLogFieldName(value = "进度月份")
    private Date progressMonth;

}
