package com.bsoft.office.project.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ProjectLogAuditAndEditVO implements Serializable {
    private Integer id;
    private Integer attendanceId;
    private Integer milepostId;
    private Integer range;
    private Integer plan;
    private Integer role;
    private Integer model;
    private Integer type;
    private String workLog;
    private Double workload;
    private Integer workLogId;
    private Integer auditFlag;
    private Integer result;
    private String submitter;
    private Integer auditType;
    private Date attendanceDate;
    private String technumid;
    private Integer auditCount;
    private String projectId;
    private String projectType;
    private String projectDept;
    private Integer sourceType;
    private String remark;
}
