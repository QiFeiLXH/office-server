package com.bsoft.office.manager.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author: zy
 * @date: 2020/10/22
 * @description APP用户绑定情况统计
 */
@Data
public class AppBindCountVO {
    /* 日期 */
    @OperLogFieldName(value = "日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date countDate;

    /* 绑定人数 */
    @OperLogFieldName(value = "绑定人数")
    private Integer bindCount;

    /* 解绑人数 */
    @OperLogFieldName(value = "解绑人数")
    private Integer unBindCount;

    /* 净增人数 */
    @OperLogFieldName(value = "净增人数")
    private Integer absoluteCount;
}
