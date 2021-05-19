package com.bsoft.office.manager.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author: zy
 * @date: 2020/10/27
 * @description
 */
@Data
public class RequestLogReportVO {
    /* 主键 */
    @OperLogFieldName(value = "主键")
    private Integer id;

    /* 菜单ID */
    @OperLogFieldName(value = "菜单ID")
    private Integer menuId;

    /* 请求路径 */
    @OperLogFieldName(value = "请求路径")
    private String url;

    /* 统计日期 */
    @OperLogFieldName(value = "统计日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date countDate;

    /* 请求次数 */
    @OperLogFieldName(value = "请求次数")
    private Integer requestCount;

    /* 请求人数 */
    @OperLogFieldName(value = "请求人数")
    private Integer personCount;

    /* 菜单名称 */
    @OperLogFieldName(value = "菜单名称")
    private String menuName;
}
