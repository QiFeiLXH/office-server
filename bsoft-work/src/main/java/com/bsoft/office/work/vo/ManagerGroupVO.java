package com.bsoft.office.work.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Huang GH
 * @date 2021/5/10 13:14
 */
@Data
public class ManagerGroupVO implements Serializable {
    /**
     * 委员会id
     */
    private Integer councilId;
    /**
     * 委员会名称
     */
    private String councilName;
    /**
     *  类别 1决策类  2提案类
     */
    private Integer type;
    /**
     *  是否注销 0未注销 1已注销
     */
    private Integer isCancel;
    /**
     * 组员数量
     */
    private Integer memberNum;

    /**
     * 是否是修改
     */
    private Boolean isEdit;

    /**
     * 是否是新增
     */
    private Boolean isNew;
}
