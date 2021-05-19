package com.bsoft.office.project.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

/**
 * @Author Xuhui Lin
 * @Date 2020/5/13 8:36
 * @Description 项目责任书-计划回款
 */
@Data
public class ProjectDutyPaymentVO{
    @OperLogFieldName(value = "id")
    private Integer id;
    /** 责任书id */
    @OperLogFieldName(value = "责任书id")
    private Integer dutyId;
    /** 合同编号 */
    @OperLogFieldName(value = "合同编号")
    private String contractNo;
    /** 付款方式id */
    @OperLogFieldName(value = "付款方式id")
    private Integer paymentId;
    /** 预计回款 */
    @OperLogFieldName(value = "预计回款")
    private Integer expected;
}
