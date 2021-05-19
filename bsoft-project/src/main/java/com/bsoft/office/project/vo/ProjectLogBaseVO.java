package com.bsoft.office.project.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/*
 * @author  hy
 * @date  2020/3/18 9:58
 * @description
 */
@Data
public class ProjectLogBaseVO implements Serializable  {
    @OperLogFieldName(value = "项目ID")
    private String projectId;
    @OperLogFieldName(value = "合同号")
    private String contractNo;
    @OperLogFieldName(value = "考勤日期")
    private String attendanceDate;
    @OperLogFieldName(value = "项目名称")
    private String projectName;
    @OperLogFieldName(value = "宿舍ID")
    private Integer houseId;
    @OperLogFieldName(value = "住宿情况")
    private Integer houseType;
    @OperLogFieldName(value = "日志详情")
    private List<ProjectLogVO> projectLogs;
    @OperLogFieldName(value = "出差标志")
    private Integer evection;
    @OperLogFieldName(value = "项目变更标志")
    private Boolean projectChangeFlag;
}
