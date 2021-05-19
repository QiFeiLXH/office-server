package com.bsoft.office.manager.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.HeadStyle;
import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.poi.ss.usermodel.FillPatternType;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: zy
 * @date: 2020/11/20
 * @description
 */
@Data
public class SalesPlanViewVO implements Serializable {

    @OperLogFieldName(value = "ID")
    private Integer id;//主键

    @OperLogFieldName(value = "客户编码")
    private String customer;//客户编码

    @OperLogFieldName(value = "客户名称")
    private String customerName;//客户名称

    @OperLogFieldName(value = "产品内容")
    private String content;//产品内容 项目内容

    @OperLogFieldName(value = "预计软件额")
    private Double estimateSoftware;//预计软件额

    @OperLogFieldName(value = "预计净销售额软件")
    private Double estimateNetSales;//预计净销售额软件

    @OperLogFieldName(value = "预计硬件额")
    private Double estimateHardware;//预计硬件额

    @OperLogFieldName(value = "预计时间")
    private Double estimateMonth;//预计时间

    @OperLogFieldName(value = "状态")
    private Integer status;//状态 1.审核中 2.已审核

    @OperLogFieldName(value = "跟单人")
    private String trackPerson;//跟单人

    @OperLogFieldName(value = "跟单人姓名")
    private String trackPersonName;//跟单人姓名

    @OperLogFieldName(value = "跟单部门")
    private String trackDept;//跟单部门

    @OperLogFieldName(value = "跟单部门名称")
    private String trackDeptName;//跟单部门名称

    @OperLogFieldName(value = "线索编号")
    private Integer clueId;//线索编号

    @OperLogFieldName(value = "业务归属")
    private String businessBelong;//业务归属

    @OperLogFieldName(value = "项目阶段")
    private String stage;//项目阶段

    @OperLogFieldName(value = "线索性质")
    private String cluesNature;//线索性质

    @OperLogFieldName(value = "线索来源")
    private String cluesSource;//线索来源

    @OperLogFieldName(value = "计划来源")
    private String planSource;//计划来源

    @OperLogFieldName(value = "最新进展")
    private String latestDevelopment;//最新进展

    @OperLogFieldName(value = "开标时间")
    private String openingDate;//开标时间

    @OperLogFieldName(value = "上报日期")
    private Date reportDate;//上报日期

    @OperLogFieldName(value = "流程实例id")
    private String processInstanceId;//流程实例id

    @OperLogFieldName(value = "计划时间")
    private Date planDate;//计划时间

}
