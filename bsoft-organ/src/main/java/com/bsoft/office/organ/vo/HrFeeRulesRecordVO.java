package com.bsoft.office.organ.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: zy
 * @date: 2020/12/23
 * @description 人员财物维护
 */
@Data
public class HrFeeRulesRecordVO implements Serializable {

    //工号
    @OperLogFieldName(value = "工号")
    private String personId;
    //部门
    @OperLogFieldName(value = "部门")
    private String dept;
    //姓名
    @OperLogFieldName(value = "姓名")
    private String xusName;
    //岗位大类
    @OperLogFieldName(value = "岗位大类")
    private Integer postType;

    //现财务类别
    @OperLogFieldName(value = "现财务类别")
    private Integer financialTypeNow;

    //现财务类别
    @OperLogFieldName(value = "现财务类别")
    private String financialNameNow;

    //调整后财务类别
    @OperLogFieldName(value = "调整后财务类别")
    private Integer financialTypeAfter;

    //调整后财务类别
    @OperLogFieldName(value = "调整后财务类别")
    private String financialNameAfter;

    //调整年月
    @OperLogFieldName(value = "调整年月")
    @JsonFormat(pattern="yyyy-MM",timezone = "GMT+8")
    private Date adjustDate;

    //登记日期
    @OperLogFieldName(value = "登记日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date registrantionDate;

    //登记人
    @OperLogFieldName(value = "登记人")
    private String registrant;

    //登记人姓名
    @OperLogFieldName(value = "登记人姓名")
    private String registrantName;
}
