package com.bsoft.office.common.vo;

import lombok.Data;

/**
 * @author: zy
 * @date: 2020/11/5
 * @description 成本代码字典
 */
@Data
public class CostDicVO {
    /** 代码类别*/
    private Integer type;
    /** 识别ID*/
    private Integer id;
    /** 名称*/
    private String name;
    /** 拼音码*/
    private String pinyin;
    private Integer protect;
    /** 单价*/
    private Double price;
    /** 规格*/
    private String standards;
    /** 注销标志*/
    private Integer logout;
}
