package com.bsoft.office.project.vo;


import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class CustomerProjectVO{
    @OperLogFieldName(value = "项目ID")
    private String projectId;
    @OperLogFieldName(value = "项目名称")
    private String projectName;
    @OperLogFieldName(value = "合同金额")
    private Double contractAmount;
    @OperLogFieldName(value = "大区ID")
    private String area;
    @OperLogFieldName(value = "大区名称")
    private String areaText;
    @OperLogFieldName(value = "签约日期")
    private Date signDate;
    @OperLogFieldName(value = "项目经理工号")
    private String projectManager;
    @OperLogFieldName(value = "项目经理")
    private String projectManagerText;
    @OperLogFieldName(value = "客户分类")
    private String classification;
    @OperLogFieldName(value = "客户等级")
    private String grade;
    @OperLogFieldName(value = "所属区域")
    private String region;
    @OperLogFieldName(value = "合同编号")
    private String contractId;
    @OperLogFieldName(value = "合同号码")
    private String contractNo;
    @OperLogFieldName(value = "归属类别ID")
    private Integer flag;
    @OperLogFieldName(value = "归属类别")
    private String flagText;
    @OperLogFieldName(value = "客户名称")
    private String customerName;
    @OperLogFieldName(value = "拼音码")
    private String pinyin;
    @OperLogFieldName(value = "常用标志")
    private Integer isCommon;
}



