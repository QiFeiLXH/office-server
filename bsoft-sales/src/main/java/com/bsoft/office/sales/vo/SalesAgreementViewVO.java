package com.bsoft.office.sales.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

import java.util.Date;

/**
 * @Author: Xuhui Lin
 */
@Data
public class SalesAgreementViewVO{
    @OperLogFieldName(value = "id")
    private Integer id;
    /** 协议编号 */
    @OperLogFieldName(value = "协议编号")
    private String agreementNo;
    /** 合作单位1 */
    @OperLogFieldName(value = "合作单位1")
    private Integer partner1;
    @OperLogFieldName(value = "合作单位1")
    private String partnerOneName;
    /** 合作单位1拼音 */
    @OperLogFieldName(value = "合作单位1拼音")
    private String partnerOneNameCode;
    /** 合作单位2 */
    @OperLogFieldName(value = "合作单位2")
    private Integer partner2;
    @OperLogFieldName(value = "合作单位2")
    private String partnerTwoName;
    /** 合作单位2拼音 */
    @OperLogFieldName(value = "合作单位2拼音")
    private String partnerTwoNameCode;
    /** 签订部门 */
    @OperLogFieldName(value = "签订部门")
    private String signDep;
    @OperLogFieldName(value = "签订部门")
    private String signDepText;
    /** 签订人 */
    @OperLogFieldName(value = "签订人")
    private String signer;
    @OperLogFieldName(value = "签订人")
    private String signerName;
    /** 签订日期 */
//    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "签订日期")
    private Date signDate;
    /** 合作开始日期 */
    @OperLogFieldName(value = "合作开始日期")
    private Date startDate;
    /** 合作结束日期 */
    @OperLogFieldName(value = "合作结束日期")
    private Date endDate;
    /** 合作起止日期 */
    @OperLogFieldName(value = "合作起止日期")
    private String  startStopDate;
    /** 合作类别 */
    @OperLogFieldName(value = "合作类别")
    private Integer cooperateType;
    @OperLogFieldName(value = "合作类别")
    private String cooperateTypeText;
    /** 原件状态 */
    @OperLogFieldName(value = "原件状态")
    private Integer originalStatus;
    @OperLogFieldName(value = "原件状态")
    private String originalStatusText;
    /** 是否公告披露 0否 1是 */
    @OperLogFieldName(value = "是否公告披露")
    private Integer notice;
    /** 业务归属 */
    @OperLogFieldName(value = "业务归属")
    private Integer ownerShip;
    /** 可以立项 0否 1是 */
    @OperLogFieldName(value = "可以立项")
    private Integer approval;
    /** 合作内容 */
    @OperLogFieldName(value = "合作内容")
    private String cooperateContent;
    /** 落地部门 */
    @OperLogFieldName(value = "落地部门")
    private String landingDep;
    @OperLogFieldName(value = "落地部门")
    private String landingDepText;
    /** 修改人 */
    @OperLogFieldName(value = "修改人")
    private String modifier;
    @OperLogFieldName(value = "修改人")
    private String modifierName;
    /** 修改日期 */
    @OperLogFieldName(value = "修改日期")
    private Date modifyDate;
    /** 登记人 */
    @OperLogFieldName(value = "登记人")
    private String registerant;
    @OperLogFieldName(value = "登记人")
    private String registerantName;
    /** 登记时间 */
    @OperLogFieldName(value = "登记时间")
    private Date registerDate;

}
