package com.bsoft.office.project.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author: lkh
 * @DateTime: 2021/4/21 14:50
 * @Description:
 */
@Data
public class ProjectProductVO {

    @OperLogFieldName(value = "id")
    private Integer id;
    @OperLogFieldName(value = "项目ID")
    private String projectId;
    @OperLogFieldName(value = "系统ID")
    private Integer systemId;
    @OperLogFieldName(value = "系统名称")
    private String systemName;
    @OperLogFieldName(value = "产品清单ID")
    private Integer productId;
    @OperLogFieldName(value = "产品编号")
    private Integer productNumber;
    @OperLogFieldName(value = "产品名称")
    private String productName;
    @OperLogFieldName(value = "合同模块名称")
    private String moduleName;
    @OperLogFieldName(value = "产品金额")
    private Double amount;
    @OperLogFieldName(value = "模块上报类型")
    private Integer reportType;
    @OperLogFieldName(value = "模块上报类型名称")
    private String reportTypeName;
    @OperLogFieldName(value = "承建分工:1自主,2采购外包自主实施,3采购外包非自主实施")
    private Integer constructionType;
    @OperLogFieldName(value = "承建分工类型名称")
    private String constructionTypeName;
    @OperLogFieldName(value = "目标机构数")
    private Integer orgNum;
    @OperLogFieldName(value = "提交标志")
    private Integer sumbitFlag;
    @OperLogFieldName(value = "提交人")
    private String sumbiter;
    @OperLogFieldName(value = "提交人姓名")
    private String sumbiterName;
    @OperLogFieldName(value = "提交日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date sumbitDate;
    @OperLogFieldName(value = "最新模块进度")
    private Double lastProgress;
    @OperLogFieldName(value = "最新上报月份")
    private Date lastProgressMonth;
    @OperLogFieldName(value = "备注")
    private String remarks;
    @OperLogFieldName(value = "业务大类")
    private Integer businessType;



}
