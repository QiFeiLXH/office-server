package com.bsoft.office.work.condition;

import lombok.Data;

import java.util.List;

/**
 * @author: zy
 * @date: 2020/11/5
 * @description 办公用品查询条件
 */
@Data
public class ApplianceQueryCnd {
    private Integer stockId;
    private Integer type;
    private Integer name;
    private String inputContent;
    private List<Integer> statusList;
    private String userId;
    private String useDept;
    private String startDateStr;
    private String endDateStr;
    private Integer pageNo;
    private Integer pageSize;
    private Integer submitFlag;
}
