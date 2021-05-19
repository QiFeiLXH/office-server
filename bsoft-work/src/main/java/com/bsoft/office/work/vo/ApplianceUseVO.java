package com.bsoft.office.work.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author: zy
 * @date: 2020/11/5
 * @description 办公用品领用
 */
@Data
public class ApplianceUseVO {
    /**主键*/
    @OperLogFieldName(value = "ID")
    private Integer id;

    /**物品类别id*/
    @OperLogFieldName(value = "物品类别id")
    private Integer type;

    /**物品名称id*/
    @OperLogFieldName(value = "物品名称id")
    private String name;

    /**规格*/
    @OperLogFieldName(value = "规格")
    private String standards;

    /**数量*/
    @OperLogFieldName(value = "数量")
    private Integer quantity;

    /**单价*/
    @OperLogFieldName(value = "单价")
    private Double unitPrice;

    /**金额*/
    @OperLogFieldName(value = "金额")
    private Double money;

    /**领用人id*/
    @OperLogFieldName(value = "领用人id")
    private String userId;

    /**领用部门id*/
    @OperLogFieldName(value = "领用部门id")
    private String useDept;

    /**归属项目id*/
    @OperLogFieldName(value = "归属项目id")
    private String projectId;

    /**领用日期*/
    @OperLogFieldName(value = "领用日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date useDate;

    /**流水号*/
    @OperLogFieldName(value = "流水号")
    private String lshid;

    /**类别*/
    @OperLogFieldName(value = "类别")
    private String typeName;

    /**名称*/
    @OperLogFieldName(value = "名称")
    private String nameName;

    /**领用人*/
    @OperLogFieldName(value = "领用人")
    private String userName;

    /**部门*/
    @OperLogFieldName(value = "部门")
    private String useDeptName;

    /**项目*/
    @OperLogFieldName(value = "项目")
    private String projectName;

}
