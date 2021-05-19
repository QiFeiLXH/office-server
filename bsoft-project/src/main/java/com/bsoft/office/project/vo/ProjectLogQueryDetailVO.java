package com.bsoft.office.project.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

import java.util.Date;

@Data
public class ProjectLogQueryDetailVO {
    @OperLogFieldName(value = "主键")
    private Integer id;
    /**
     * 项目id
     */
    @OperLogFieldName(value = "项目id")
    private String projectId;
    /**
     * 项目名称
     */
    @OperLogFieldName(value = "项目名称")
    private String projectName;
    /**
     * 项目计划阶段id
     */
    @OperLogFieldName(value = "项目计划阶段id")
    private Integer milepostId;
    /**
     * 项目计划阶段名称
     */
    @OperLogFieldName(value = "项目计划阶段名称")
    private String milepostName;
    /**
     * 项目比例
     */
    @OperLogFieldName(value = "项目比例")
    private Double projectRate;
    /**
     * 员工id
     */
    @OperLogFieldName(value = "员工id")
    private String personId;
    /**
     * 员工姓名
     */
    @OperLogFieldName(value = "员工姓名")
    private String personName;
    /** 员工姓名拼音简码 */
    @OperLogFieldName(value = "员工姓名拼音简码")
    private String personSimpleCode;
    /**
     * 部门代码
     */
    @OperLogFieldName(value = "部门代码")
    private String deptCode;
    /**
     * 部门名称
     */
    @OperLogFieldName(value = "部门名称")
    private String deptName;
    /** 员工姓名拼音简码 */
    @OperLogFieldName(value = "员工姓名拼音简码")
    private String deptSimpleCode;
    /**
     * 项目日志
     */
    @OperLogFieldName(value = "项目日志")
    private String worklog;
    /** 范围：1、合同内 2、合同外 */
    @OperLogFieldName(value = "范围")
    private Integer range;
    /** 计划：1、计划内 2、计划外 */
    @OperLogFieldName(value = "计划")
    private Integer plan;
    /** 角色：1、管理 2、销售 3、技术 4、工程 5、服务 6、其他 7、支持 */
    @OperLogFieldName(value = "角色")
    private Integer role;
    /** 方式：1、现场2、远程 */
    @OperLogFieldName(value = "方式")
    private Integer model;
    /** 类别：1、会议 2、协调 3、上线 4、培训5、验收 6、维护7、其他 */
    @OperLogFieldName(value = "类别")
    private Integer type;
    /** 工时 */
    @OperLogFieldName(value = "工时")
    private Double workload;
    /** 结果0:进行中 1：已完成 */
    @OperLogFieldName(value = "结果")
    private Integer result;
    /**
     * 审核状态
     */
    @OperLogFieldName(value = "审核状态")
    private Integer auditStatus;
    /**
     * 审核状态名称
     */
    @OperLogFieldName(value = "审核状态名称")
    private String auditStatusText;
    /**
     * 考勤日期
     */
    @OperLogFieldName(value = "考勤日期")
    private String attendanceDate;
    /**
     * 项目经理id
     */
    @OperLogFieldName(value = "项目经理id")
    private String projectManager;
    /**
     * 项目经理名称
     */
    @OperLogFieldName(value = "项目经理名称")
    private String projectManagerText;
    /**
     * 签订日期
     */
    @OperLogFieldName(value = "签订日期")
    private Date signDate;
    /**
     * 工程区域代码
     */
    @OperLogFieldName(value = "工程区域代码")
    private String area;
    /**
     * 工程区域名称
     */
    @OperLogFieldName(value = "工程区域名称")
    private String areaText;
    /**
     * 合同金额
     */
    @OperLogFieldName(value = "合同金额")
    private Double hte;
    /**
     * 客户编号
     */
    @OperLogFieldName(value = "客户编号")
    private String customerCode;
    /**
     * 客户名称
     */
    @OperLogFieldName(value = "客户名称")
    private String customerName;
    /**
     * 客户分类
     */
    @OperLogFieldName(value = "客户分类")
    private String classificationCode;
    /**
     * 客户分类
     */
    @OperLogFieldName(value = "客户分类")
    private String classification;
    /**
     * 客户等级
     */
    @OperLogFieldName(value = "客户等级")
    private String gradeCode;
    /**
     * 客户等级
     */
    @OperLogFieldName(value = "客户等级")
    private String grade;
    /**
     * 所属区域代码
     */
    @OperLogFieldName(value = "所属区域代码")
    private String regionCode;
    /**
     * 所属区域文本
     */
    @OperLogFieldName(value = "所属区域文本")
    private String region;
}
