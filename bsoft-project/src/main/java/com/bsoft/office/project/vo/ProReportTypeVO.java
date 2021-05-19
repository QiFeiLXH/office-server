package com.bsoft.office.project.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

/**
 * @Author KangHua Lin
 * @Date 2021/4/19 16:41
 * @Description
 */
@Data
public class ProReportTypeVO {
    /** id */
    @OperLogFieldName(value = "id")
    private Integer id;
    /** 模块上报分类名称 */
    @OperLogFieldName(value = "模块上报分类名称")
    private String name;
    /** 上报类型  1 按节点进度，2 按运维时间*/
    @OperLogFieldName(value = "上报类型  1 按节点进度，2 按运维时间")
    private Integer type;
    @OperLogFieldName(value = "注销标志 0未注销  1注销")
    /** 注销标志 0未注销  1注销 */
    private Integer logout;

}
