package com.bsoft.office.sales.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.sales.entity
 * @Author: Xuhui Lin
 * @CreateTime: 2020-06-29 20:23
 * @Description: 合作协议
 */
@Data
public class SalesAgreementVO {
    @OperLogFieldName(value = "id")
    private Integer id;
    /** 协议编号 */
    @OperLogFieldName(value = "协议编号")
    private String agreementNo;
    /** 合作单位1 */
    @OperLogFieldName(value = "合作单位1")
    private Integer partner1;
    /** 合作单位2 */
    @OperLogFieldName(value = "合作单位2")
    private Integer partner2;
    /** 签订部门 */
    @OperLogFieldName(value = "签订部门")
    private String signDep;
    /** 签订人 */
    @OperLogFieldName(value = "签订人")
    private String signer;
    /** 签定日期 */
    @OperLogFieldName(value = "签定日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date signDate;
    /** 合作类别 */
    @OperLogFieldName(value = "合作类别")
    private Integer cooperateType;
    /** 原件状态 */
    @OperLogFieldName(value = "原件状态")
    private Integer originalStatus;
    /** 开始日期 */
    @OperLogFieldName(value = "开始日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date startDate;
    /** 结束日期 */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "结束日期")
    private Date endDate;
    /** 业务归属 */
    @OperLogFieldName(value = "业务归属")
    private Integer ownerShip;
    /** 是否公告披露 0否 1是 */
    @OperLogFieldName(value = "是否公告披露")
    private Integer notice;
    /** 可以立项 */
    @OperLogFieldName(value = "可以立项")
    private Integer approval;
    /** 合作内容 */
    @OperLogFieldName(value = "合作内容")
    private String cooperateContent;
    /** 落地部门 */
    @OperLogFieldName(value = "落地部门")
    private String landingDep;

}
