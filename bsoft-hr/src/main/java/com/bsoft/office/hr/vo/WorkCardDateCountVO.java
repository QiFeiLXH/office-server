package com.bsoft.office.hr.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

/**
 * @Author Xuhui Lin
 * @Date 2020/12/15 17:26
 * @Description
 */
@Data
public class WorkCardDateCountVO {
    @OperLogFieldName(value = "日期")
    private String dateStr;
    @OperLogFieldName(value = "数量")
    private Integer count;
}
