package com.bsoft.office.sales.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;

public class SalesPlanAmountVO {
    @OperLogFieldName(value = "预计软件额")
    private Double estimateSoftware;
    @OperLogFieldName(value = "预计净软件额")
    private Double estimateNetSales;
    @OperLogFieldName(value = "预计硬件额")
    private Double estimateHardware;

    public Double getEstimateSoftware() {
        return estimateSoftware;
    }

    public void setEstimateSoftware(Double estimateSoftware) {
        this.estimateSoftware = estimateSoftware;
    }

    public Double getEstimateNetSales() {
        return estimateNetSales;
    }

    public void setEstimateNetSales(Double estimateNetSales) {
        this.estimateNetSales = estimateNetSales;
    }

    public Double getEstimateHardware() {
        return estimateHardware;
    }

    public void setEstimateHardware(Double estimateHardware) {
        this.estimateHardware = estimateHardware;
    }
}
