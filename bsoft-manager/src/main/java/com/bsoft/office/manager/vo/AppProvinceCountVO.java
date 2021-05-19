package com.bsoft.office.manager.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

/**
 * @author: zy
 * @date: 2020/10/20
 * @description APP用户省份分布情况
 */
@Data
public class AppProvinceCountVO {
    /* 省份 */
    @OperLogFieldName(value = "省份")
    private String province;

    /* 用户数 */
    @OperLogFieldName(value = "用户数")
    private Integer userCount;
}
