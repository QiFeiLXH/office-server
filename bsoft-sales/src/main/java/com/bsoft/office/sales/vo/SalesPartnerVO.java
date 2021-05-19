package com.bsoft.office.sales.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Author: Xuhui Lin
 * @Description: 合作协议-合作单位
 */
@Data
public class SalesPartnerVO {
    @OperLogFieldName(value = "id")
    private Integer id;
    /** 合作单位名称 */
    @OperLogFieldName(value = "合作单位名称")
    private String partnerName;
    /** 合作单位拼音简码 */
    @OperLogFieldName(value = "合作单位拼音简码")
    private String nameCode;
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
    /** 省 */
    @OperLogFieldName(value = "省")
    private String province;
    /** 市 */
    @OperLogFieldName(value = "市")
    private String city;
    /** 县 */
    @OperLogFieldName(value = "县")
    private String county;
    /** 联系人 */
    @OperLogFieldName(value = "联系人")
    private String contactPerson;

}
