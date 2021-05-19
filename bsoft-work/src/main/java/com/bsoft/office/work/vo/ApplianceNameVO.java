package com.bsoft.office.work.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

/**
 * @author: zy
 * @date: 2020/12/2
 * @description 行政用品名称
 */
@Data
public class ApplianceNameVO {
    /** 类别*/
    @OperLogFieldName(value = "类别")
    private Integer type;

    /** 代码识别ID*/
    @OperLogFieldName(value = "代码识别ID")
    private Integer id;

    /** 名称*/
    @OperLogFieldName(value = "名称")
    private String name;

    /** 拼音码*/
    @OperLogFieldName(value = "拼音码")
    private String pinyin;

    /** 规格*/
    @OperLogFieldName(value = "规格")
    private String standards;

    /** 注销标注*/
    @OperLogFieldName(value = "注销标注")
    private Integer logout;

    /** 物品类别*/
    @OperLogFieldName(value = "物品类别")
    private Integer applianceType;
}
