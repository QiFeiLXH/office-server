package com.bsoft.office.sales.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;

/**
 * @Author: xucl
 * @DateTime: 2020/9/29 14:26
 * @Description:
 */
public class CustomerContactViewVO {
    @OperLogFieldName(value = "id")
    private Integer id;
    @OperLogFieldName(value = "客户名称")
    private String customerName;
    @OperLogFieldName(value = "拼音码")
    private String simpleCode;
    @OperLogFieldName(value = "标志")
    private Integer flag;
    @OperLogFieldName(value = "收款单位id")
    private Integer payeeId;
    @OperLogFieldName(value = "收款单位名称")
    private String unitName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSimpleCode() {
        return simpleCode;
    }

    public void setSimpleCode(String simpleCode) {
        this.simpleCode = simpleCode;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(Integer payeeId) {
        this.payeeId = payeeId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
}
