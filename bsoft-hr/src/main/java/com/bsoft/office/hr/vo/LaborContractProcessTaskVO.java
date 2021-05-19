package com.bsoft.office.hr.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @version 1.0
 * @author: zy
 * @date: 2020/12/14
 * @description 劳动合同续签流程任务
 */
@Data
public class LaborContractProcessTaskVO {
    /** 任务ID */
    @OperLogFieldName(value = "任务ID")
    private String taskId;
    /** 任务定义ID */
    @OperLogFieldName(value = "任务定义ID")
    private String taskDefineKey;
    /** 任务名称 */
    @OperLogFieldName(value = "任务名称")
    private String taskName;
    /** 任务创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @OperLogFieldName(value = "任务创建时间")
    private Date createTime;
    /** 任务待办人或者候选人 */
    @OperLogFieldName(value = "任务待办人")
    private String assignee;
    /** 任务待办人或者候选人姓名 */
    @OperLogFieldName(value = "任务待办人姓名")
    private String assigneeName;
    /** 流程实例ID */
    @OperLogFieldName(value = "流程实例ID")
    private String processInstanceId;
    /** 流程businessKey */
    @OperLogFieldName(value = "流程businessKey")
    private String businessKey;
    /** 流程发起时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @OperLogFieldName(value = "流程发起时间")
    private Date processCreateTime;
    /** 流程定义名称 */
    @OperLogFieldName(value = "流程定义名称")
    private String processName;
    /** 流程定义的key */
    @OperLogFieldName(value = "流程定义key")
    private String processKey;
    /** 流程发起人ID */
    @OperLogFieldName(value = "流程发起人工号")
    private String applyUserId;
    /** 流程发起人姓名 */
    @OperLogFieldName(value = "流程发起人姓名")
    private String applyUserName;
    /** 流程申请ID */
    @OperLogFieldName(value = "流程申请ID")
    private String applyId;
    /** 待办任务是否已读*/
    @OperLogFieldName(value = "已读标志")
    private Boolean readFlag;
}
