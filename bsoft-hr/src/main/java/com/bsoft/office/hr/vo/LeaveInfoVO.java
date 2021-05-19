package com.bsoft.office.hr.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/8/19 17:50
 * @Description
 */
@Data
public class LeaveInfoVO {
    @OperLogFieldName(value = "id")
    private Integer id;
    /** 工号 */
    @OperLogFieldName(value = "工号")
    private String personId;
    /** 请假类型 */
    @OperLogFieldName(value = "请假类型")
    private Integer type;
    /** 申请日期 */
    @OperLogFieldName(value = "申请日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date applyDate;
    /** 请假开始日期 */
    @OperLogFieldName(value = "请假开始日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date startDate;
    /** 请假结束日期 */
    @OperLogFieldName(value = "请假结束日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date endDate;
    /** 年份 */
    @OperLogFieldName(value = "年份")
    private String year;
    /** 请假天数 */
    @OperLogFieldName(value = "请假天数")
    private Double leaveDays;
    /** 其中年份用的 */
    @OperLogFieldName(value = "其中年份用的")
    private Double someDays;
    /** 备注/原因 */
    @OperLogFieldName(value = "备注/原因")
    private String remark;
    /** 流水号 */
    @OperLogFieldName(value = "流水号")
    private String lshid;
    @OperLogFieldName(value = "审核标志")
    private Integer auditFlag;
}
