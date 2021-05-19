package com.bsoft.office.common.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author zhanglf
 * @Date 2020-12-09 11:13
 * @Version 1.0
 */
@Data
public class CustomerParamVO{
    @OperLogFieldName(value = "属性KEY")
    private String key;
    @OperLogFieldName(value = "属性值")
    private String param;
}
