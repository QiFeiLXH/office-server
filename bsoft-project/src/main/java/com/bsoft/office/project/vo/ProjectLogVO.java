package com.bsoft.office.project.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ProjectLogVO implements Serializable {
    @OperLogFieldName(value = "ID")
    private Integer id;
    @OperLogFieldName(value = "考勤ID")
    private Integer attendanceId;
    @OperLogFieldName(value = "里程碑ID")
    private Integer milepostId;
    @OperLogFieldName(value = "合同内外")
    private Integer range;
    @OperLogFieldName(value = "计划内外")
    private Integer plan;
    @OperLogFieldName(value = "角色")
    private Integer role;
    @OperLogFieldName(value = "方式")
    private Integer model;
    @OperLogFieldName(value = "类别")
    private Integer type;
    @OperLogFieldName(value = "工作日志")
    private String workLog;
    @OperLogFieldName(value = "工时")
    private Double workload;
    @OperLogFieldName(value = "工作日志ID")
    private Integer workLogId;
    @OperLogFieldName(value = "审核标志")
    private Integer auditFlag;
    @OperLogFieldName(value = "事件结果")
    private Integer result;
    @OperLogFieldName(value = "提交人")
    private String submitter;
    @OperLogFieldName(value = "项目日志阶段")
    private Integer auditType;
    @OperLogFieldName(value = "考勤日期")
    private Date attendanceDate;
    @OperLogFieldName(value = "支持日志ID")
    private String technumid;
    @OperLogFieldName(value = "审核次数")
    private Integer auditCount;
    @OperLogFieldName(value = "项目ID")
    private String projectId;
    @OperLogFieldName(value = "项目类型")
    private String projectType;
    @OperLogFieldName(value = "项目部门")
    private String projectDept;
    @OperLogFieldName(value = "操作来源")
    private Integer sourceType;
    @OperLogFieldName(value = "项目名称")
    private String projectName;
}
