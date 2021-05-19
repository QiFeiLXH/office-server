package com.bsoft.office.manager.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

import java.util.Date;

/**
 * @author: zy
 * @date: 2020/9/25
 * @description 流程操作信息
 */
@Data
public class ActionRecordVO {
    /* 主键 */
    @OperLogFieldName(value = "ID")
    private Integer id;

    /* 流程ID */
    @OperLogFieldName(value = "流程ID")
    private String processInstanceId;

    /* 操作人 */
    @OperLogFieldName(value = "操作人")
    private String auditor;

    /* 审核意见 */
    @OperLogFieldName(value = "审核意见")
    private String auditOpinion;

    /* 审核时间 */
    @OperLogFieldName(value = "审核时间")
    private Date auditDate;

    /* 操作名称备注 */
    @OperLogFieldName(value = "操作名称备注")
    private String action;

    /* 任务环节 */
    @OperLogFieldName(value = "任务环节")
    private String taskName;
}
