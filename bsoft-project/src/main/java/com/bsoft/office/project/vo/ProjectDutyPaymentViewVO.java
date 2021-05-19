package com.bsoft.office.project.vo;


import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/5/19 19:31
 * @Description
 */
@Data
public class ProjectDutyPaymentViewVO{
    @OperLogFieldName(value = "id")
    private String id;
    /** 合同编号 */
    @OperLogFieldName(value = "合同编号")
    private String contractNo;
    /** 合同号 */
    @OperLogFieldName(value = "合同号")
    private String contractCode;
    /** 付款类型 */
    @OperLogFieldName(value = "付款类型")
    private Integer paymentType;
    @OperLogFieldName(value = "付款类型")
    private String paymentTypeText;
    /** 付款科目 */
    @OperLogFieldName(value = "付款科目")
    private Integer paymentItem;
    @OperLogFieldName(value = "付款科目")
    private String paymentItemText;
    /** 付款时间 */
    @OperLogFieldName(value = "付款时间")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date paymentDate;
    /** 付款金额 */
    @OperLogFieldName(value = "付款金额")
    private Double paymentAmount;
    /** 付款条件 */
    @OperLogFieldName(value = "付款条件")
    private String paymentCondition;
    /** 计划回款id */
    @OperLogFieldName(value = "计划回款id")
    private Integer planPaymentId;
    /** 责任书id */
    @OperLogFieldName(value = "责任书id")
    private Integer dutyId;
    /** 计划回款 */
    @OperLogFieldName(value = "计划回款")
    private Double expected;
    /** 选择标记 1选择 0 未选择 */
    @OperLogFieldName(value = "选择标记")
    private Integer selectedFlag;
    /** 已回金额 */
    @OperLogFieldName(value = "已回金额")
    private Double amount;
    @OperLogFieldName(value = "子项")
    private List<ProjectDutyPaymentViewVO> children;

}
