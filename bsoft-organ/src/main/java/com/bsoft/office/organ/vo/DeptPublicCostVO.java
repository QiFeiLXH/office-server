package com.bsoft.office.organ.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/4/20 11:08
 * @Description 部门对公费用记录（中标服务费）
 */
@Data
public class DeptPublicCostVO{
    @OperLogFieldName(value = "id")
    private Integer id;
    /** 申请工号 */
    @OperLogFieldName(value = "申请工号")
    private String applicationPersonId;
    /** 申请人 */
    @OperLogFieldName(value = "申请人")
    private String applicationPerson;
    /** 申请部门代码 */
    @OperLogFieldName(value = "申请部门代码")
    private String applicationDeptCode;
    /** 申请部门 */
    @OperLogFieldName(value = "申请部门")
    private String applicationDept;
    /** 领款人工号 */
    @OperLogFieldName(value = "领款人工号")
    private String payeeId;
    /** 领款人 */
    @OperLogFieldName(value = "领款人")
    private String payee;
    /** 收款部门代码 */
    @OperLogFieldName(value = "收款部门代码")
    private String receivingDeptCode;
    /** 收款部门 */
    @OperLogFieldName(value = "收款部门")
    private String receivingDept;
    /** 收款部门拼音 */
    @OperLogFieldName(value = "收款部门拼音")
    private String receivingDeptSimpleCode;
    /** 数据来源 1.对公费用 2.中标服务费 */
    @OperLogFieldName(value = "数据来源")
    private Integer costType;
    @OperLogFieldName(value = "数据来源")
    private String costTypeText;
    /** 招标标号 */
    @OperLogFieldName(value = "招标标号")
    private String tenderNumber;
    /** 申请金额 */
    @OperLogFieldName(value = "申请金额")
    private Double applicationAmount;
    /** 发放金额 */
    @OperLogFieldName(value = "发放金额")
    private Double amountIssued;
    /** 发放时间 */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "发放时间")
    private Date releaseTime;
    /** 挂账周期 */
    @OperLogFieldName(value = "挂账周期")
    private Integer accountingCycle;
    /** 账户情况 */
    @OperLogFieldName(value = "账户情况")
    private String accountinfo;
    /** 发票归还标志 0未归还 1归还 */
    @OperLogFieldName(value = "发票归还标志")
    private Integer invoiceReturnFlag;
    @OperLogFieldName(value = "流水号")
    private String lshid;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "申请时间")
    private Date sqsj;
    @OperLogFieldName(value = "税票金额")
    private Double spje;
    @OperLogFieldName(value = "项目名称")
    private String projectName;
    @OperLogFieldName(value = "审核金额")
    private Double shje;
    /** 逾期标记 */
    @OperLogFieldName(value = "逾期标记")
    private Integer overdueFlag;
    /** 逾期天数 */
    @OperLogFieldName(value = "逾期天数")
    private Integer overdueDays;
    /** 超额金额 */
    @OperLogFieldName(value = "超额金额")
    private Double excessAmount;
    /** 税票号 */
    @OperLogFieldName(value = "税票号")
    private String taxReceiptNo;
    /** 备注 */
    @OperLogFieldName(value = "备注")
    private String remarks;
    /** 自用 */
    @OperLogFieldName(value = "自用")
    private Integer selfUse;
    /** 核算部门名称*/
    @OperLogFieldName(value = "核算部门名称")
    private String accountingDepartment;
    /** 核算口径归属名称*/
    @OperLogFieldName(value = "核算口径归属名称")
    private String accountingCaliberName;
    /** 开户银行*/
    @OperLogFieldName(value = "开户银行")
    private String depositBank;
    /** 费用分类*/
    @OperLogFieldName(value = "费用分类")
    private String classificationName;
    /** 银行账号*/
    @OperLogFieldName(value = "银行账号")
    private String bankAccount;
    /** 明细科目*/
    @OperLogFieldName(value = "明细科目")
    private String detailedAccountName;
    /** 费用类别*/
    @OperLogFieldName(value = "费用类别")
    private String expenseCategory;
    /** 登记人*/
    @OperLogFieldName(value = "登记人")
    private String registrant;
    /** 核算时间*/
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "核算时间")
    private Date accountingTime;
    /** 发放方式*/
    @OperLogFieldName(value = "发放方式")
    private String distributionMethod;
    /** 发放人*/
    @OperLogFieldName(value = "发放人")
    private String issuer;
    /** 发放标志*/
    @OperLogFieldName(value = "发放标志")
    private Integer releaseMark;
}
