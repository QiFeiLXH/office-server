package com.bsoft.office.hr.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: zy
 * @date: 2020/8/26
 * @description
 */
@Data
public class AnnualVacationInfoVO implements Serializable {
    // id
    @OperLogFieldName(value = "ID")
    private Integer id;
    // 年份
    @OperLogFieldName(value = "年份")
    private String year;
    // 员工工号
    @OperLogFieldName(value = "员工工号")
    private String personId;
    // 员工姓名
    @OperLogFieldName(value = "员工姓名")
    private String personName;
    // 部门代码
    @OperLogFieldName(value = "部门代码")
    private String deptId;
    // 部门名称
    @OperLogFieldName(value = "部门名称")
    private String deptName;
    // 假期类型
    @OperLogFieldName(value = "假期类型")
    private Integer type;
    // 假期时长
    @OperLogFieldName(value = "假期时长")
    private Double workTimes;
    // 创建时间
    @OperLogFieldName(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createDate;
    // 开始生效时间
    @OperLogFieldName(value = "开始生效时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date startDate;
    // 有效截止时间
    @OperLogFieldName(value = "有效截止时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date endDate;
    // 备注
    @OperLogFieldName(value = "备注")
    private String remark;
    // 审核标志
    @OperLogFieldName(value = "审核标志")
    private Integer auditFlag;
    // 系统自动生成标志
    @OperLogFieldName(value = "系统自动生成标志")
    private Integer autoFlag;
    //使用标志
    @OperLogFieldName(value = "使用标志")
    private Integer useFlag;
    //加班开始时间
    @OperLogFieldName(value = "加班开始时间")
    private Date workStartDate;
    //加班结束时间
    @OperLogFieldName(value = "加班结束时间")
    private Date workEndDate;
}
