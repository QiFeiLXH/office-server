package com.bsoft.office.work.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Huang GH
 * @date 2021/5/11 18:02
 */
@Data
public class PolicyVO implements Serializable {
    /**
     * 数据集合
     */
    private List<?> record;
    /**
     * 数据总数
     */
    private Integer total;

}
