package com.bsoft.office.organ.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/15 9:44
 * @Description
 */
@Data
public class InvoiceContentViewVO {
    @OperLogFieldName(value = "id")
    private Integer id;
    /** 开票记录id */
    @OperLogFieldName(value = "开票记录id")
    private Integer invoiceRecordId;
    /** 开票内容 */
    @OperLogFieldName(value = "开票内容")
    private String productContent;
    /** 物品名称 */
    @OperLogFieldName(value = "物品名称")
    private String goodsName;
    /** 税收分类码 */
    @OperLogFieldName(value = "税收分类码")
    private String taxCode;
    /** 税率 */
    @OperLogFieldName(value = "税率")
    private Double taxRate;
    /** 规格型号 */
    @OperLogFieldName(value = "规格型号")
    private String model;
    /** 单位 */
    @OperLogFieldName(value = "单位")
    private String unit;
    /** 数量 */
    @OperLogFieldName(value = "数量")
    private Integer count;
    /** 单价 */
    @OperLogFieldName(value = "单价")
    private Double unitPrice;
    /** 金额 */
    @OperLogFieldName(value = "金额")
    private Double amount;

}
