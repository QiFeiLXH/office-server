package com.bsoft.office.sales.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Author: Xuhui Lin
 */
@Data
public class SalesPartnerViewVO{
    @OperLogFieldName(value = "id")
    private Integer id;
    /** 合作单位名称 */
    @OperLogFieldName(value = "合作单位名称")
    private String partnerName;
    /** 地址 */
    @OperLogFieldName(value = "地址")
    private String address;
    /** 联系电话 */
    @OperLogFieldName(value = "联系电话")
    private String phone;
    /** 登记日期 */
    @OperLogFieldName(value = "登记日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date registerDate;
    /** 联系人 */
    @OperLogFieldName(value = "联系人")
    private String contactPerson;
    /** 省 */
    @OperLogFieldName(value = "省")
    private Integer province;
    @OperLogFieldName(value = "省")
    private String provinceText;
    /** 市 */
    @OperLogFieldName(value = "市")
    private Integer city;
    @OperLogFieldName(value = "市")
    private String cityText;
    /** 县 */
    @OperLogFieldName(value = "县")
    private Integer county;
    @OperLogFieldName(value = "县")
    private String countyText;
    /** 省市县+地址 */
    @OperLogFieldName(value = "省市县+地址")
    private String stitchingAddress;
    /** 是否已有协议选择该合作单位*/
    @OperLogFieldName(value = "是否已有协议选择该合作单位")
    private Integer hasAgreement;
}
