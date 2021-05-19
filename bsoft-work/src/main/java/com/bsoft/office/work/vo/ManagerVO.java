package com.bsoft.office.work.vo;

import lombok.Data;

/**
 * @Author ding cj
 * @Date 2021/5/14 9:55
 * @Description
 */
@Data
public class ManagerVO {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 委员会id
     */
    private Integer councilId;

    /**
     * 工号
     */
    private Integer personId;

    /**
     * 姓名
     */
    private String personName;

    /**
     * 部门
     */
    private String dept;

    /**
     * 是否是修改
     */
    private Boolean isEdit;

    /**
     * 是否是新增
     */
    private Boolean isNew;
}
