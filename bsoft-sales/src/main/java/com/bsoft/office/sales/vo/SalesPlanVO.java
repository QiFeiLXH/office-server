package com.bsoft.office.sales.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SalesPlanVO implements Serializable {
    @OperLogFieldName(value = "ID")
    private Integer id;//主键
    @OperLogFieldName(value = "客户编码")
    private String customer;//客户编码
    @OperLogFieldName(value = "客户名称")
    private String customerName;//客户名称
    @OperLogFieldName(value = "产品内容")
    private String content;//产品内容 项目内容
    @OperLogFieldName(value = "预计软件额")
    private Double estimateSoftware;//预计软件额（可修改）
    @OperLogFieldName(value = "预计净销售额软件")
    private Double estimateNetSales;//预计净销售额软件（可修改）
    @OperLogFieldName(value = "预计硬件额")
    private Double estimateHardware;//预计硬件额（可修改）
    @OperLogFieldName(value = "预计月份")
    private String estimateMonth;//预计月份（可修改）
    @OperLogFieldName(value = "状态")
    private Integer status;//状态 1.审核中 2.已审核
    @OperLogFieldName(value = "跟单人")
    private String trackPerson;//跟单人
    @OperLogFieldName(value = "跟单人姓名")
    private String trackPersonName;//跟单人姓名
    @OperLogFieldName(value = "跟单部门")
    private String trackDept;//跟单部门
    @OperLogFieldName(value = "线索编号")
    private Integer clueId;//线索编号
    @OperLogFieldName(value = "业务归属")
    private String businessBelong;//业务归属
    @OperLogFieldName(value = "项目阶段")
    private String stage;//项目阶段（可修改）
    @OperLogFieldName(value = "线索性质")
    private String cluesNature;//线索性质
    @OperLogFieldName(value = "线索来源")
    private String cluesSource;//线索来源
    @OperLogFieldName(value = "计划来源")
    private String planSource;//计划来源
    @OperLogFieldName(value = "最新进展")
    private String latestDevelopment;//最新进展（可修改）
    @OperLogFieldName(value = "开标时间")
    private String openingDate;//开标时间
    @OperLogFieldName(value = "上报日期")
    private Date reportDate;//上报日期
    @OperLogFieldName(value = "流程实例ID")
    private String processInstanceId;//流程实例id
    @OperLogFieldName(value = "计划日期")
    private Date planDate;//计划日期
    @OperLogFieldName(value = "跟单日期")
    private Date trackDate;//跟单日期
    @OperLogFieldName(value = "销售阶段")
    private String salesStage;//销售阶段
    @OperLogFieldName(value = "签约概率")
    private Double signProbability;//签约概率（可修改）
    @OperLogFieldName(value = "预计签约日期")
    private Date signDate;//预计签约日期（可修改）
    @OperLogFieldName(value = "预计首款额")
    private Double estimateFirstAmount;//预计首款额（可修改）
    @OperLogFieldName(value = "预计系统软件额")
    private Double estimateSysSoftware;//预计系统软件额（可修改）
    @OperLogFieldName(value = "切入说明")
    private String remarkInfo;//切入说明
}
