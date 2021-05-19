package com.bsoft.office.manager.vo;

import lombok.Data;

import java.util.List;

/**
 * @author: zy
 * @date: 2020/10/15
 * @description 流程分类统计树
 */
@Data
public class ProcessTypeTreeVO {
    /* 流程类别ID */
    private Integer id;
    /* 流程类别名称 */
    private String name;
    /* 流程待办任务统计 */
    private List<ProcessTaskCountVO> children;
}
