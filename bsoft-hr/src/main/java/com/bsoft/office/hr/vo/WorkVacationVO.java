package com.bsoft.office.hr.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author: zy
 * @date: 2020/8/20
 */
@Data
public class WorkVacationVO {
    // id
    @OperLogFieldName(value = "id")
    private Integer id;

    // 年份
    @OperLogFieldName(value = "年份")
    private String year;

    // 工号
    @OperLogFieldName(value = "工号")
    private String personId;

    // 部门
    @OperLogFieldName(value = "部门")
    private String dept;

    // 类型
    @OperLogFieldName(value = "类型")
    private Integer type;

    // 生成时间
    @OperLogFieldName(value = "生成时间")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date createDate;

    // 有效开始日期
    @OperLogFieldName(value = "有效开始日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date startDate;

    // 有效截止日期
    @OperLogFieldName(value = "有效截止日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date endDate;

    // 登记人
    @OperLogFieldName(value = "登记人")
    private String registrant;

    // 加班类型（1工作日加班 2节假日加班）
    @OperLogFieldName(value = "加班类型")
    private Integer workType;

    // 加班开始时间
    @OperLogFieldName(value = "加班开始时间")
    @JsonFormat(pattern = "HH:mm", timezone = "GMT+8")
    private Date workStartDate;

    // 加班结束时间
    @OperLogFieldName(value = "加班结束时间")
    @JsonFormat(pattern = "HH:mm", timezone = "GMT+8")
    private Date workEndDate;

    // 加班原因
    @OperLogFieldName(value = "加班原因")
    private String remark;

    // 加班时长（小时）
    @OperLogFieldName(value = "加班时长")
    private Double workTimes;

    // 流水号
    @OperLogFieldName(value = "流水号")
    private String lshid;

    // 审核标志
    @OperLogFieldName(value = "审核标志")
    private Integer auditFlag;

    //系统自动生成标志
    @OperLogFieldName(value = "系统自动生成标志")
    private Integer autoFlag;
}
