package com.bsoft.office.project.condition;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @BelongsProject: bsoft-office-server
 * @BelongsPackage: com.bsoft.project.condition
 * @Author: Xuhui Lin
 * @CreateTime: 2020-03-18 16:16
 * @Description:
 */
@Data
public class ProjectPlanQueryCnd {
    /** 项目计划创建选项 ‘-1’全部 ‘0’未创建 ‘1’已创建 */
    private String optionsValue;
    /** 输入内容 */
    private String inputContent;
    /** 项目经理 */
    private String projectManager;
    /** 大区 */
    private String largeArea;
    /** 工程区域 */
    private String area;
    /** 页码 */
    private Integer pageNo;
    /** 每页数量 */
    private Integer pageSize;
    /** 开始日期 */
    private String startDate;
    /** 结束日期 */
    private String endDate;
}
