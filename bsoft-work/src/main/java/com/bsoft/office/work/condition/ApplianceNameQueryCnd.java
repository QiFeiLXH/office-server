package com.bsoft.office.work.condition;

import lombok.Data;

import java.util.List;

/**
 * @author: zy
 * @date: 2020/12/2
 * @description 行政用品名称查询参数
 */
@Data
public class ApplianceNameQueryCnd {
    /** 注销标志列表*/
    private List<Integer> logoutList;
    /** 物品类别*/
    private Integer applianceType;
    /** 输入内容*/
    private String inputContent;
    /** 页码*/
    private Integer pageNo;
    /** 每页条数*/
    private Integer pageSize;
}
