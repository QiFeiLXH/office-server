package com.bsoft.office.organ.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/15 9:52
 * @Description
 */
@Data
public class InvoiceRecordViewVO {
    @OperLogFieldName(value = "id")
    private Integer id;
    /** 申请部门id */
    @OperLogFieldName(value = "申请部门id")
    private String applyDeptId;
    /** 申请部门名称 */
    @OperLogFieldName(value = "申请部门名称")
    private String applyDeptName;
    /** 合同号 */
    @OperLogFieldName(value = "合同号")
    private String contractNo;
    /** 客户id */
    @OperLogFieldName(value = "客户id")
    private String customerId;
    /** 客户名称 */
    @OperLogFieldName(value = "客户名称")
    private String customerName;
    /** 客户名称拼音 */
    @OperLogFieldName(value = "客户名称拼音")
    private String customerSimpleCode;
    /** 开票单位id */
    @OperLogFieldName(value = "开票单位id")
    private String invoiceUnitId;
    /** 开票单位名称 */
    @OperLogFieldName(value = "开票单位名称")
    private String invoiceUnitName;
    /** 开票单位税号 */
    @OperLogFieldName(value = "开票单位税号")
    private String invoiceTaxNo;
    /** 开票单位地址 */
    @OperLogFieldName(value = "开票单位地址")
    private String invoiceAddress;
    /** 开票单位电话 */
    @OperLogFieldName(value = "开票单位电话")
    private String invoicePhone;
    /** 开票单位开户行 */
    @OperLogFieldName(value = "开票单位开户行")
    private String invoiceOpeningBank;
    /** 开票单位账号 */
    @OperLogFieldName(value = "开票单位账号")
    private String invoiceBankAccount;
    /** 分公司id */
    @OperLogFieldName(value = "分公司id")
    private Integer companyId;
    /** 分公司名称 */
    @OperLogFieldName(value = "分公司名称")
    private String companyName;
    /** 开户行 */
    @OperLogFieldName(value = "开户行")
    private String openingBank;
    /** 银行账号 */
    @OperLogFieldName(value = "银行账号")
    private String bankAccount;
    /** 公司税号 */
    @OperLogFieldName(value = "公司税号")
    private String companyTaxNo;
    /** 公司地址 */
    @OperLogFieldName(value = "公司地址")
    private String address;
    /** 公司电话 */
    @OperLogFieldName(value = "公司电话")
    private String phone;
    /** 票据金额 */
    @OperLogFieldName(value = "票据金额")
    private Double invoiceAmount;
    /** 税率 */
    @OperLogFieldName(value = "税率")
    private Double taxRate;
    /** 开票人id */
    @OperLogFieldName(value = "开票人id")
    private String issuerId;
    /** 开票人姓名 */
    @OperLogFieldName(value = "开票人姓名")
    private String issuerName;
    /** 开票日期 */
    @OperLogFieldName(value = "开票日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date invoiceDate;
    /** 领票人id */
    @OperLogFieldName(value = "领票人id")
    private String ticketHolderId;
    /** 领票人姓名 */
    @OperLogFieldName(value = "领票人姓名")
    private String ticketHolder;
    /** 流水号id */
    @OperLogFieldName(value = "流水号id")
    private String lshid;
    /** 发票pdfid */
    @OperLogFieldName(value = "发票pdfid")
    private Integer invoicePdfID;
    /** 发票pdf url */
    @OperLogFieldName(value = "发票pdf url")
    private String invoicePdfUrl;
    /** 发票类别 */
    @OperLogFieldName(value = "发票类别")
    private Integer invoiceType;
    @OperLogFieldName(value = "发票类别")
    private String invoiceTypeText;
    /** 付款款项 */
    @OperLogFieldName(value = "付款款项")
    private Integer paymentItem;
    @OperLogFieldName(value = "付款款项")
    private String paymentItemText;
    /** 款项类别 */
    @OperLogFieldName(value = "款项类别")
    private Integer noteCategory;
    @OperLogFieldName(value = "款项类别")
    private String noteCategoryText;
    /** 发票款项 */
    @OperLogFieldName(value = "发票款项")
    private Integer invoiceItem;
    @OperLogFieldName(value = "签约单位id")
    private String invoiceItemText;
    /** 签约单位id */
    @OperLogFieldName(value = "签约单位id")
    private Integer contractUnitId;
    /** 签约单位名称 */
    @OperLogFieldName(value = "签约单位名称")
    private String contractUnitName;
    /** 备注 */
    @OperLogFieldName(value = "备注")
    private String mark;
    /** 申请日期 */
    @OperLogFieldName(value = "申请日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date applyDate;
    /** 领票标志 */
    @OperLogFieldName(value = "领票标志")
    private Integer acceptFlag;
    /** 开票标志 */
    @OperLogFieldName(value = "开票标志")
    private Integer invoiceFlag;
    /** 申请人 */
    @OperLogFieldName(value = "申请人")
    private String applyer;
    @OperLogFieldName(value = "申请人")
    private String applyerName;
}
