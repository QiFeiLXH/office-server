package com.bsoft.office.common.vo;


import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class ActionRecordVO{
    /**
     * 主键
     */
    @OperLogFieldName(value = "ID")
    private Integer id;
    /**
     * 流程ID
     */
    @OperLogFieldName(value = "流程实例ID")
    private String processInstanceId;
    /**
     * 操作人
     */
    @OperLogFieldName(value = "操作人")
    private String auditor;
    /**
     * 审核意见
     */
    @OperLogFieldName(value = "审核意见")
    private String auditOpinion;
    /**
     * 审核时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @OperLogFieldName(value = "审核时间")
    private Date auditDate;
    /**
     * 操作名称备注
     */
    @OperLogFieldName(value = "操作名称备注")
    private String action;
    /**
     * 任务环节
     */
    @OperLogFieldName(value = "任务节点名称")
    private String taskName;
    /**
     *操作系统 1.手机客户端  5.web门户
     * @return
     */
    @OperLogFieldName(value = "操作系统")
    private Integer system;
}
