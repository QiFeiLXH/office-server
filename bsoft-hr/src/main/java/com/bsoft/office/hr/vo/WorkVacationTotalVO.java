package com.bsoft.office.hr.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/8/19 16:31
 * @Description
 */
@Data
public class WorkVacationTotalVO {
    @OperLogFieldName(value = "id")
    private String id;
    /** 年份 */
    @OperLogFieldName(value = "年份")
    private String year;
    /** 工号 */
    @OperLogFieldName(value = "工号")
    private String personId;
    /** 类型 */
    @OperLogFieldName(value = "类型")
    private Integer type;
    /** 工龄 */
    @OperLogFieldName(value = "工龄")
    private Integer standing;
    /** 天数 */
    @OperLogFieldName(value = "天数")
    private Double days;
    /** 已用天数 */
    @OperLogFieldName(value = "已用天数")
    private Double daysUsed;
    /** 生成日期 */
    @OperLogFieldName(value = "生成日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date createDate;
    /** 有效开始日期 */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "有效开始日期")
    private Date startDate;
    /** 有效截止日期 */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "有效截止日期")
    private Date endDate;
}
