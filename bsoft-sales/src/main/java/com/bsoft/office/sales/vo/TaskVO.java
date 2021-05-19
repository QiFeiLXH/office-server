package com.bsoft.office.sales.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;

import java.util.Date;

public class TaskVO {
    /**
     * 任务ID
     */
    @OperLogFieldName(value = "任务ID")
    private String taskId;
    /**
     *任务定义ID
     */
    @OperLogFieldName(value = "任务定义ID")
    private String taskDefineKey;
    /**
     * 任务名称
     */
    @OperLogFieldName(value = "任务名称")
    private String taskName;
    /**
     *任务创建时间
     */
    @OperLogFieldName(value = "任务创建时间")
    private Date createTime;
    /**
     *任务待办人或者候选人
     */
    @OperLogFieldName(value = "任务待办人")
    private String assignee;
    /**
     *任务待办人或者候选人姓名
     */
    @OperLogFieldName(value = "任务待办人姓名")
    private String assigneeName;
    /**
     *流程实例ID
     */
    @OperLogFieldName(value = "流程实例ID")
    private String processInstanceId;
    /**
     *流程businessKey
     */
    @OperLogFieldName(value = "流程businessKey")
    private String businessKey;
    /**
     *流程发起时间
     */
    @OperLogFieldName(value = "流程发起时间")
    private Date processCreateTime;
    /**
     *流程定义名称
     */
    @OperLogFieldName(value = "流程定义名称")
    private String processName;
    /**
     *流程定义的key
     */
    @OperLogFieldName(value = "流程定义KEY")
    private String processKey;

    /* 流程发起人ID */
    @OperLogFieldName(value = "流程发起人工号")
    private String applyUserId;

    /* 流程发起人姓名 */
    @OperLogFieldName(value = "流程发起人姓名")
    private String applyUserName;

    /* 流程申请ID */
    @OperLogFieldName(value = "流程申请ID")
    private String applyId;

    /**
     * 待办任务是否已读
     */
    @OperLogFieldName(value = "是否已读")
    private Boolean readFlag;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskDefineKey() {
        return taskDefineKey;
    }

    public void setTaskDefineKey(String taskDefineKey) {
        this.taskDefineKey = taskDefineKey;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getAssigneeName() {
        return assigneeName;
    }

    public void setAssigneeName(String assigneeName) {
        this.assigneeName = assigneeName;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    public Date getProcessCreateTime() {
        return processCreateTime;
    }

    public void setProcessCreateTime(Date processCreateTime) {
        this.processCreateTime = processCreateTime;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getProcessKey() {
        return processKey;
    }

    public void setProcessKey(String processKey) {
        this.processKey = processKey;
    }

    public String getApplyUserId() {
        return applyUserId;
    }

    public void setApplyUserId(String applyUserId) {
        this.applyUserId = applyUserId;
    }

    public String getApplyUserName() {
        return applyUserName;
    }

    public void setApplyUserName(String applyUserName) {
        this.applyUserName = applyUserName;
    }

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId;
    }

    public Boolean getReadFlag() {
        return readFlag;
    }

    public void setReadFlag(Boolean readFlag) {
        this.readFlag = readFlag;
    }
}
