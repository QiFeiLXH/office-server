package com.bsoft.office.project.vo;


import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

/**
 * @BelongsProject: bsoft-office-server
 * @BelongsPackage: com.bsoft.project.group.entity
 * @Author: Xuhui Lin
 * @CreateTime: 2020-02-12
 * @Description: 项目计划查看视图
 */
@Data
public class ProjectPlanQueryViewVO {
    /** 项目id */
    @OperLogFieldName(value = "项目id")
    private String projectId;
    /** 项目名称 */
    @OperLogFieldName(value = "项目名称")
    private String projectName;
    /** 合同号 */
    @OperLogFieldName(value = "合同号")
    private String contractNo;
    /** 合同名称*/
    @OperLogFieldName(value = "合同名称")
    private String contractName;
    /** 工程区域 */
    @OperLogFieldName(value = "工程区域")
    private String smallArea;
    /** 工程区域文本 */
    @OperLogFieldName(value = "工程区域文本")
    private String smallAreaText;
    /** 大区 */
    @OperLogFieldName(value = "大区")
    private String largeArea;
    /** 大区文本 */
    @OperLogFieldName(value = "大区文本")
    private String largeAreaText;
    /** 项目类别 */
    @OperLogFieldName(value = "项目类别")
    private Integer flag;
    /** 项目类别文本*/
    @OperLogFieldName(value = "项目类别文本")
    private String flagText;
    /** 项目类型 */
    @OperLogFieldName(value = "项目类型")
    private Integer projectType;
    /** 项目类型文本 */
    @OperLogFieldName(value = "项目类型文本")
    private String projectTypeText;
    /** 项目经理 */
    @OperLogFieldName(value = "项目经理")
    private String projectManager;
    /** 项目经理姓名 */
    @OperLogFieldName(value = "项目经理姓名")
    private String projectManagerText;
    /** 计划id */
    @OperLogFieldName(value = "计划id")
    private Integer planId;
    /** 有无计划 0无 1有 */
    @OperLogFieldName(value = "有无计划")
    private String planFlag;

}
