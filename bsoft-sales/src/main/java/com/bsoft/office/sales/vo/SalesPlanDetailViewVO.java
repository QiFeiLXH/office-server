package com.bsoft.office.sales.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class SalesPlanDetailViewVO  {
    @OperLogFieldName(value = "ID")
    private Integer id;//计划Id
    @OperLogFieldName(value = "客户名称")
    private String customerName;//客户名称
    @OperLogFieldName(value = "销售区域")
    private String salesArea;//销售区域
    @OperLogFieldName(value = "客户分了")
    private String type;//客户分类
    @OperLogFieldName(value = "客户状态")
    private String customerStatus;//客户状态
    @OperLogFieldName(value = "医院等级")
    private String hospitalLevel;//医院等级
    @OperLogFieldName(value = "基本信息")
    private String baseInfo;//基本信息
    @OperLogFieldName(value = "新老客户")
    private String newFlag;//新老客户
    @OperLogFieldName(value = "大客户标志")
    private Integer bigCustomerFlag;//大客户标志
    @OperLogFieldName(value = "省份")
    private String province;//省份
    @OperLogFieldName(value = "产品内容")
    private String productContent;//产品内容
    @OperLogFieldName(value = "线索性质")
    private String cluesNature;//线索性质
    @OperLogFieldName(value = "跟单人")
    private String trackPerson;//跟单人
    @OperLogFieldName(value = "跟单部门")
    private String trackDept;//跟单部门
    @OperLogFieldName(value = "竞争对手")
    private String competitor;//竞争对手
    @OperLogFieldName(value = "线索来源")
    private String cluesSource;//线索来源
    @OperLogFieldName(value = "切入阶段")
    private String entryStage;//切入阶段
    @OperLogFieldName(value = "销售阶段")
    private String salesStage;//销售阶段
    @OperLogFieldName(value = "切入说明")
    private String remarkInfo;//切入说明
    @OperLogFieldName(value = "预计软件额")
    private Double softwareAmount;//预计软件额
    @OperLogFieldName(value = "预计首款额")
    private Double firstAmount;//预计首款额
    @OperLogFieldName(value = "预计硬件额")
    private Double hardwareAmount;//预计硬件额
    @OperLogFieldName(value = "预计净软件额")
    private Double estimateNetSales;//预计净软件额
    @OperLogFieldName(value = "预计系统软件额")
    private Double systemSoftwareAmount;//预计系统软件额
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "预计签约日期")
    private Date signDate;//预计签约日期
    @OperLogFieldName(value = "预计签约概率")
    private Double signProbability;//预计签约概率
    @OperLogFieldName(value = "投标日期")
    private String biddingDate;//投标日期
    @OperLogFieldName(value = "招投标标志")
    private Integer biddingFlag;//招投标标志
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "跟单日期")
    private Date trackDate;//跟单日期
    @OperLogFieldName(value = "跟单情况")
    private String trackInfo;//跟单情况

}
