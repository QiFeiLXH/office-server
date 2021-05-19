package com.bsoft.office.manager.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

/**
 * @author: zy
 * @date: 2020/9/25
 * @description 流程待办任务统计
 */
@Data
public class ProcessTaskCountVO {
    /* 主键 */
    @OperLogFieldName(value = "ID")
    private Integer id;

    /* 流程定义KEY */
    @OperLogFieldName(value = "流程定义KEY")
    private String key;

    /* 流程定义名称 */
    @OperLogFieldName(value = "流程定义名称")
    private String name;

    /* 待办任务数 */
    @OperLogFieldName(value = "待办任务数")
    private Integer taskCount;

    /* 流程类别 */
    @OperLogFieldName(value = "流程类别")
    private Integer type;
}
