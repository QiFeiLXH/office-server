package com.bsoft.office.organ.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/4/20 13:09
 * @Description
 */
@Data
@ExcelIgnoreUnannotated
public class BondOverdueInfoVO{
    @OperLogFieldName(value = "id")
    private String id;
    /** 申请人员id */
    @OperLogFieldName(value = "申请人员id")
    private String applicationPersonId;
    /** 申请人员 */
    @ExcelProperty(value = "申请人", index = 3)
    @OperLogFieldName(value = "申请人员")
    private String applicationPerson;
    /** 申请人拼音码 */
    @OperLogFieldName(value = "申请人拼音码")
    private String applicationPersonSimpleCode;
    /** 申请部门代码 */
    @OperLogFieldName(value = "申请部门代码")
    private String applicationDeptCode;
    /** 申请部门 */
    @ExcelProperty(value = "申请部门", index = 4)
    @OperLogFieldName(value = "申请部门")
    private String applicationDept;
    /** 领款人id */
    @OperLogFieldName(value = "领款人id")
    private String payeeId;
    /** 领款人 */
    @ExcelProperty(value = "领款人", index = 5)
    @OperLogFieldName(value = "领款人")
    private String payee;
    /** 收款单位 */
    @OperLogFieldName(value = "收款单位")
    private String receivingDeptCode;
    /** 收款单位 */
    @ExcelProperty(value = "收款单位", index = 6)
    @OperLogFieldName(value = "收款单位")
    private String receivingDept;
    /** 收款部门拼音 */
    @OperLogFieldName(value = "收款部门拼音")
    private String receivingDeptSimpleCode;
    /** 招标标号 */
    @ExcelProperty(value = "招标标号", index = 7)
    @OperLogFieldName(value = "招标标号")
    private String tenderNumber;
    /** 申请金额 */
    @ExcelProperty(value = "申请金额", index = 8)
    @OperLogFieldName(value = "申请金额")
    private Double applicationAmount;
    /** 履约标志 0未履约 1履约 */
    @ExcelProperty(value = "履约保证金标志", index = 11)
    @OperLogFieldName(value = "履约标志")
    private Integer performanceFlag;
    /** 预计退款时间 */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat("yyyy-MM-dd")
    @ExcelProperty(value = "预计退款时间", index = 9)
    @OperLogFieldName(value = "预计退款时间")
    private Date estimatedRefundTime;
    /** 合同号 */
    @ExcelProperty(value = "合同号", index = 12)
    @OperLogFieldName(value = "合同号")
    private String contractNo;
    /** 合同名称 */
    @ExcelProperty(value = "合同名称", index = 13)
    @OperLogFieldName(value = "合同名称")
    private String contractName;
    /** 借款类别 */
    @OperLogFieldName(value = "借款类别")
    private Integer loanType;
    /** 借款类别名称 */
    @ExcelProperty(value = "借款用途", index = 1)
    @OperLogFieldName(value = "借款类别名称")
    private String loanTypeText;
    /** 逾期标记 */
    @OperLogFieldName(value = "部门id")
    private Integer overdueFlag;
    /** 逾期天数 */
    @ExcelProperty(value = "逾期天数", index = 10)
    @OperLogFieldName(value = "逾期天数")
    private Integer overdueDays;
    /** 账户情况 */
    @OperLogFieldName(value = "部门id")
    private String accountInfo;
    /** oa流水号 */
    @ExcelProperty(value = "流水号", index = 0)
    @OperLogFieldName(value = "oa流水号")
    private String lshid;
    /** 登记日期 */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat("yyyy-MM-dd")
    @ExcelProperty(value = "申请日期", index = 2)
    @OperLogFieldName(value = "登记日期")
    private Date applicationDate;
    /** 归属人 */
    @OperLogFieldName(value = "归属人")
    private String attributorId;
    @OperLogFieldName(value = "归属人")
    private String attributor;
    /** 支付方式 */
    @OperLogFieldName(value = "支付方式")
    private String paymentWay;
    @OperLogFieldName(value = "支付方式")
    private String paymentWayText;
    /** 申请付款时间 */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "申请付款时间")
    private Date applicationPaymentTime;
    /** 合同编号 */
    @OperLogFieldName(value = "合同编号")
    private String contractCode;
    /** 销售主导 */
    @OperLogFieldName(value = "销售主导")
    private Integer salesLead;
    @OperLogFieldName(value = "销售主导")
    private String salesLeadText;
    /** 税票标志 */
    @OperLogFieldName(value = "税票标志")
    private Integer taxFlag;
    /** 税票号 */
    @OperLogFieldName(value = "税票号")
    private String taxNo;
    /** 税票金额 */
    @OperLogFieldName(value = "税票金额")
    private Double taxAmount;
    /** 客户名称 */
    @OperLogFieldName(value = "客户名称")
    private String clientName;
    /** 使用说明 */
    @OperLogFieldName(value = "使用说明")
    private String useInstructions;
    /** 具体条款 */
    @OperLogFieldName(value = "具体条款")
    private String specificTerms;
    /** 备注信息 */
    @OperLogFieldName(value = "备注信息")
    private String markInfo;
    /** 审核人员 */
    @OperLogFieldName(value = "审核人员")
    private String auditId;
    @OperLogFieldName(value = "审核人员")
    private String auditor;
    /** 审核标志 */
    @OperLogFieldName(value = "审核标志")
    private Integer auditFlag;
    /** 审核时间 */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "审核时间")
    private Date auditDate;
    /** 发放人员 */
    @OperLogFieldName(value = "发放人员")
    private String issuerId;
    @OperLogFieldName(value = "发放人员")
    private String issuer;
    /** 发放标志 */
    @OperLogFieldName(value = "发放标志")
    private Integer issueFlag;
    /** 发放日期 */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "发放日期")
    private Date issueDate;
    /** 冲账人员 */
    @OperLogFieldName(value = "冲账人员")
    private String chargePersonId;
    @OperLogFieldName(value = "冲账人员")
    private String chargePerson;
    /** 冲账标志 */
    @OperLogFieldName(value = "冲账标志")
    private Integer chargeFlag;
    /** 冲账日期 */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "冲账日期")
    private Date chargeDate;
    /** 登记人员 */
    @OperLogFieldName(value = "登记人员")
    private String registerPersonId;
    @OperLogFieldName(value = "登记人员")
    private String registerPerson;
}
