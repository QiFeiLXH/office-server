package com.bsoft.office.work.vo;


import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

/**
 * @Author Lkh
 * @Date 2021/4/7 14:08
 * @Description
 */

@Data
public class CompanySealVO {
    /**印章ID*/
    @OperLogFieldName(value = "印章ID")
    private  Integer  id ;
    /**公司ID*/
    @OperLogFieldName(value = "公司ID")
    private  Integer  companyId;
    /**公司名称*/
    @OperLogFieldName(value = "公司名称")
    private  String   companyName;
    /**公司简拼*/
    @OperLogFieldName(value = "公司简拼")
    private  String   pinyin;
    /**印章是否在公司：1存在,0不在*/
    @OperLogFieldName(value = "印章是否在公司：0存在,1不在")
    private  Integer  sealCompanyFlag;
    /**是否为公章：1是,0否*/
    @OperLogFieldName(value = "是否为公章：0是,1否")
    private  Integer  officialSealFlag;
    /**公章保管人Id*/
    @OperLogFieldName(value = "公章保管人Id")
    private  String  officialSealCustodianId;
    /**公章保管人姓名*/
    @OperLogFieldName(value = "公章保管人姓名")
    private  String  officialSealCustodianName;
    /**是否为合同章：1是,0否*/
    @OperLogFieldName(value = "是否为合同章：0是,1否")
    private  Integer  contractSealFlag;
    /**合同章保管人Id*/
    @OperLogFieldName(value = "合同章保管人Id")
    private  String  contractSealCustodianId;
    /**合同章保管人姓名*/
    @OperLogFieldName(value = "合同章保管人姓名")
    private   String contractSealCustodianName;
    /**公司类别:0 分公司,1 子公司*/
    @OperLogFieldName(value = "1子公司，2分公司，3其他")
    private  Integer  companyType;
    /** 页码*/
    @OperLogFieldName(value = "页码")
    private Integer pageNo;
    /** 每页条数*/
    @OperLogFieldName(value = "每页条数")
    private Integer pageSize;


}
