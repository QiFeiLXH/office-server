package com.bsoft.office.project.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

/**
 * @BelongsProject: bsoft-office-server
 * @BelongsPackage: com.bsoft.project.plan.entity
 * @Author: Xuhui Lin
 * @CreateTime: 2020-02-17
 * @Description: 项目计划查询-日志列表
 */
@Data
public class ProjectPlanQueryLogVO {
    /** id */
    @OperLogFieldName(value = "ID")
    private Integer id;
    /** 考勤id */
    @OperLogFieldName(value = "考勤ID")
    private Integer attendanceId;
    /** 项目id */
    @OperLogFieldName(value = "项目ID")
    private String projectId;
    /** 员工id */
    @OperLogFieldName(value = "员工工号")
    private String personId;
    /** 员工姓名 */
    @OperLogFieldName(value = "员工姓名")
    private String personName;
    /** 阶段id */
    @OperLogFieldName(value = "阶段ID")
    private Integer milepostId;
    /** 考勤日期 */
    @OperLogFieldName(value = "考勤日期")
    private String attendanceDate;
    /** 工作量 */
    @OperLogFieldName(value = "工作量")
    private Double workload;
    /** 工时占比 */
    @OperLogFieldName(value = "工时占比")
    private Double workloadRate;
    /** 角色：1、管理 2、销售 3、技术 4、工程 5、服务 6、其他 7、支持 */
    @OperLogFieldName(value = "角色")
    private Integer role;
    /** 类别：1、会议 2、协调 3、上线 4、培训5、验收 6、维护7、其他 */
    @OperLogFieldName(value = "类别")
    private Integer type;
    /** 结果0:进行中 1：已完成 */
    @OperLogFieldName(value = "结果")
    private Integer result;
    /** 审核状态 4为已审 其他待审 */
    @OperLogFieldName(value = "审核状态ID")
    private Integer auditStatus;
    /** 审核状态 4为已审 其他待审 */
    @OperLogFieldName(value = "审核状态")
    private String auditStatusText;
}
