package com.bsoft.office.project.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/5/14 14:29
 * @Description 项目责任书
 */
@Data
public class ProjectDutyVO{
    @OperLogFieldName(value = "id")
    private Integer id;
    /** 客户编码 */
    @OperLogFieldName(value = "客户编码")
    private String customerId;
    /** 责任书名称 */
    @OperLogFieldName(value = "责任书名称")
    private String name;
    /** 考核开始日期 */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "考核开始日期")
    private Date startDate;
    /** 考核结束日期 */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "考核结束日期")
    private Date endDate;
    /** 人力成本 */
    @OperLogFieldName(value = "人力成本")
    private Double laborCost;
    /** 报销费用 */
    @OperLogFieldName(value = "报销费用")
    private Double reimburse;
    /** 奖金 */
    @OperLogFieldName(value = "奖金")
    private Double bonus;
    /** 签订日期 */
    @OperLogFieldName(value = "签订日期")
    private Date signDate;
    /** 登记日期 */
    @OperLogFieldName(value = "登记日期")
    private Date registerDate;
    /** 签订人 */
    @OperLogFieldName(value = "签订人")
    private String signner;
    /** 审核人 */
    @OperLogFieldName(value = "审核人")
    private String auditter;
    /** 审核日期 */
    @OperLogFieldName(value = "审核日期")
    private Date auditDate;
    /** 审核标志 */
    @OperLogFieldName(value = "审核标志")
    private Integer auditFlag;
    /** 提交标志 0 未提交 1已提交（已提交的数据无法修改） */
    @OperLogFieldName(value = "提交标志")
    private Integer committed;
}
