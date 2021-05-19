package com.bsoft.office.work.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

/**
 * @author: zy
 * @date: 2020/11/9
 * @description
 */
@Data
public class CustomerContactVO {
    @OperLogFieldName(value = "ID")
    private Integer id;

    @OperLogFieldName(value = "客户名称")
    private String customerName;

    @OperLogFieldName(value = "拼音码")
    private String simpleCode;

    @OperLogFieldName(value = "注销标志")
    private Integer flag;
}
