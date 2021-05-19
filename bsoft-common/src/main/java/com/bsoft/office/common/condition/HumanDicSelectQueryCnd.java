package com.bsoft.office.common.condition;

import lombok.Data;

/**
 * @author: zy
 * @date: 2021/2/22
 * @description 人事代码字典选择器查询参数
 */
@Data
public class HumanDicSelectQueryCnd {
    private Integer type;
    private String inputContent;
}
