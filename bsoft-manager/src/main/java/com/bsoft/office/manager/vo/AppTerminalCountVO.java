package com.bsoft.office.manager.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

/**
 * @author: zy
 * @date: 2020/10/22
 * @description APP用户终端分布情况统计
 */
@Data
public class AppTerminalCountVO {
    @OperLogFieldName(value = "终端")
    private String terminal;

    @OperLogFieldName(value = "用户数")
    private Integer userCount;
}
