package com.bsoft.office.project.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

/**
 * @BelongsProject: bsoft-office-server
 * @BelongsPackage: com.bsoft.project.plan.entity
 * @Author: Xuhui Lin
 * @CreateTime: 2020-02-16
 * @Description:
 */
@Data
public class ProjectPlanQueryTreeVO {
    /** 计划明细id */
    @OperLogFieldName(value = "计划明细id")
    private Integer id;
    /** 项目id */
    @OperLogFieldName(value = "项目id")
    private String projectId;
    /** 计划明细上级id */
    @OperLogFieldName(value = "计划明细上级id")
    private Integer parentId;
    /** 阶段id */
    @OperLogFieldName(value = "阶段id")
    private Integer milepostId;
    /** 计划id */
    @OperLogFieldName(value = "计划id")
    private Integer planId;
    /** 阶段名称 */
    @OperLogFieldName(value = "阶段名称")
    private String milepostName;
    /** 阶段层级 */
    @OperLogFieldName(value = "阶段层级")
    private Integer milepostLevel;
    /** 取消标志 0未取消、1取消*/
    @OperLogFieldName(value = "取消标志")
    private Integer logoff;
    /** 日志数量 */
    @OperLogFieldName(value = "日志数量")
    private Integer logNum;
    /** 工作量 */
    @OperLogFieldName(value = "工作量")
    private Double workloadSum;
}
