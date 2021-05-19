package com.bsoft.office.work.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

/**
 * @version 1.0
 * @author: zy
 * @date: 2020/12/17
 * @description
 */
@Data
public class ApplianceStoreVO {
    @OperLogFieldName(value = "ID")
    private Integer id;

    /**物品类别*/
    @OperLogFieldName(value = "物品类别")
    private Integer type;

    /**物品名称*/
    @OperLogFieldName(value = "物品名称")
    private Integer name;

    /**规格*/
    @OperLogFieldName(value = "规格")
    private String standards;

    /**单价*/
    @OperLogFieldName(value = "单价")
    private Double unitPrice;

    /**剩余数量*/
    @OperLogFieldName(value = "剩余数量")
    private Integer surplusQuantity;

    /**类型名称*/
    @OperLogFieldName(value = "类型名称")
    private String typeName;

    /**物品名称*/
    @OperLogFieldName(value = "物品名称")
    private String nameName;
}
