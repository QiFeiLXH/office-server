package com.bsoft.office.sales.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;

/**
 * @Author Xuhui Lin
 * @Date 2021/3/3 12:46
 * @Description
 */
public class ContractModuleProductVO {
    @OperLogFieldName(value = "id")
    private Integer id;
    @OperLogFieldName(value = "产品id")
    private Integer productId;
    @OperLogFieldName(value = "模块id")
    private Integer moduleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }
}
