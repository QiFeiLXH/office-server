package com.bsoft.office.sales.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/24 15:27
 * @Description
 */
public class CustomerContactsVO {
    @OperLogFieldName(value = "id")
    private Integer id;
    @OperLogFieldName(value = "客户名称")
    private String customerName;
    @OperLogFieldName(value = "拼音简码")
    private String simpleCode;
    @OperLogFieldName(value = "标志")
    private Integer flag;

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
}
