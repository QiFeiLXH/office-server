package com.bsoft.office.project.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

/**
 * @Author KangHua Lin
 * @Date 2021/4/19 16:41
 * @Description
 */
@Data
public class ProProgressNodeVO {
    /** id */
    @OperLogFieldName(value = "id")
    private Integer id;
    /** 模块上报分类Id */
    @OperLogFieldName(value = "模块上报分类Id")
    private Integer reportTypeId ;
    /** 节点名称*/
    @OperLogFieldName(value = "节点名称")
    private String  planName;
    /** 节点比例 */
    @OperLogFieldName(value = "节点比例")
    private Double proportion ;
    /** 注销标志 0未注销  1注销 */
    @OperLogFieldName(value = "注销标志")
    private Integer logout;
    /** 排序序号  */
    @OperLogFieldName(value = "排序序号")
    private Integer sort;

}
