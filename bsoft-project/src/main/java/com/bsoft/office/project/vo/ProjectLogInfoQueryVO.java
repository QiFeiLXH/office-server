package com.bsoft.office.project.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

import java.util.Date;

/**
 * @BelongsProject: bsoft-office-server
 * @BelongsPackage: com.bsoft.project.plan.entity
 * @Author: Qi fei
 * @CreateTime: 2020-02-18 13:41
 * @Description:
 */
@Data
public class ProjectLogInfoQueryVO {
    /** ID */
    @OperLogFieldName(value = "ID")
    private Integer id;
    /** 考勤ID */
    @OperLogFieldName(value = "考勤ID")
    private Integer attendanceId;
    /** 项目id */
    @OperLogFieldName(value = "项目ID")
    private String projectId;
    /** 合同编号 */
    @OperLogFieldName(value = "合同编号")
    private String contractNo;
    /** 计划阶段 */
    @OperLogFieldName(value = "计划阶段")
    private Integer milepostId;
    /** 范围 */
    @OperLogFieldName(value = "范围")
    private Integer range;
    /** 计划id */
    @OperLogFieldName(value = "计划ID")
    private Integer plan;
    /** 角色 */
    @OperLogFieldName(value = "角色")
    private Integer role;
    /** 方式 */
    @OperLogFieldName(value = "方式")
    private Integer model;
    /** 类型 */
    @OperLogFieldName(value = "类型")
    private Integer type;
    /** 工作日志 */
    @OperLogFieldName(value = "工作日志")
    private String workLog;
    /** 工时 */
    @OperLogFieldName(value = "工时")
    private Double workload;
    /** kq_gzrz中的日志id */
    @OperLogFieldName(value = "日志ID")
    private Integer workLogId;
    /** 最新审核人 */
    @OperLogFieldName(value = "最新审核人")
    private String auditter;
    /** 最新审核日期 */
    @OperLogFieldName(value = "最新审核日期")
    private Date auditDate;
    /** 审核标志:0、未审核 1、同意 2、不同意 */
    @OperLogFieldName(value = "审核标志")
    private Integer auditFlag;
    /** 拒绝标志 */
    @OperLogFieldName(value = "拒绝标志")
    private Integer refuse;
    /** 审核意见 */
    @OperLogFieldName(value = "审核意见")
    private String remark;
    /** 提交时间 */
    @OperLogFieldName(value = "提交时间")
    private Date submitDate;
    /** 提交人工号 */
    @OperLogFieldName(value = "提交人工号")
    private String submitter;
    /** 结果0:进行中 1：已完成 */
    @OperLogFieldName(value = "结果")
    private Integer result;
    /** 日志阶段：0.项目人员修改，1.组长审核，2.项目经理审核，3.小区负责人审核，4.结束 */
    @OperLogFieldName(value = "日志审核阶段")
    private Integer auditType;
    /** 考勤日期 */
    @OperLogFieldName(value = "考勤日期")
    private Date attendanceDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(Integer attendanceId) {
        this.attendanceId = attendanceId;
    }

    public Integer getMilepostId() {
        return milepostId;
    }

    public void setMilepostId(Integer milepostId) {
        this.milepostId = milepostId;
    }

    public Integer getRange() {
        return range;
    }

    public void setRange(Integer range) {
        this.range = range;
    }

    public Integer getPlan() {
        return plan;
    }

    public void setPlan(Integer plan) {
        this.plan = plan;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getModel() {
        return model;
    }

    public void setModel(Integer model) {
        this.model = model;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getWorkLog() {
        return workLog;
    }

    public void setWorkLog(String workLog) {
        this.workLog = workLog;
    }

    public Double getWorkload() {
        return workload;
    }

    public void setWorkload(Double workload) {
        this.workload = workload;
    }

    public Integer getWorkLogId() {
        return workLogId;
    }

    public void setWorkLogId(Integer workLogId) {
        this.workLogId = workLogId;
    }

    public String getAuditter() {
        return auditter;
    }

    public void setAuditter(String auditter) {
        this.auditter = auditter;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    public Integer getAuditFlag() {
        return auditFlag;
    }

    public void setAuditFlag(Integer auditFlag) {
        this.auditFlag = auditFlag;
    }

    public Integer getRefuse() {
        return refuse;
    }

    public void setRefuse(Integer refuse) {
        this.refuse = refuse;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public String getSubmitter() {
        return submitter;
    }

    public void setSubmitter(String submitter) {
        this.submitter = submitter;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Integer getAuditType() {
        return auditType;
    }

    public void setAuditType(Integer auditType) {
        this.auditType = auditType;
    }

    public Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }
}
