package com.bsoft.office.project.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

@Data
public class ProjectLogQueryProjectVO {
    /** 项目id */
    @OperLogFieldName(value = "项目id")
    private String projectId;
    /** 项目名称 */
    @OperLogFieldName(value = "项目名称")
    private String projectName;
    /** 项目经理 */
    @OperLogFieldName(value = "项目经理")
    private String projectManager;
    /** 日志填写人 */
    @OperLogFieldName(value = "日志填写人")
    private String submitter;
    /** 考勤日期 */
    @OperLogFieldName(value = "考勤日期")
    private String attendanceDate;
    /** 日志数 */
    @OperLogFieldName(value = "日志数")
    private Integer logsNum;
}
