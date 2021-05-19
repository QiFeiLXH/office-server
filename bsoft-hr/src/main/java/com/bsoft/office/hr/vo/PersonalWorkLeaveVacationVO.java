package com.bsoft.office.hr.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

/**
 * @Author Xuhui Lin
 * @Date 2020/8/19 10:59
 * @Description
 */
@Data
public class PersonalWorkLeaveVacationVO {
    /** 工号 */
    @OperLogFieldName(value = "员工工号")
    private String personId;
    /** 请假类型 */
    @OperLogFieldName(value = "请假类型")
    private Integer type;
    /** 历年剩余天数 */
    @OperLogFieldName(value = "历年剩余天数")
    private Double lastYearDaysLeft;
    /** 当年总天数 */
    @OperLogFieldName(value = "当年总天数")
    private Double currentYearDays;
    /** 今年已用 */
    @OperLogFieldName(value = "今年已用")
    private Double currentYearDaysUsed;
    /** 剩余可用 */
    @OperLogFieldName(value = "剩余可用")
    private Double totalDaysLeft;
    /** 即将过期天数 */
    @OperLogFieldName(value = "即将过期天数")
    private Double expiringDays;

}
