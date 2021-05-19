package com.bsoft.office.hr.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;

/**
 * @Author Xuhui Lin
 * @Date 2020/7/24 16:42
 * @Description 绩效保存结果
 */
public class PerformanceSaveResultVO{
    /** 成功数量 */
    @OperLogFieldName(value = "成功数量")
    private Integer successCount;
    /** 失败数量 */
    @OperLogFieldName(value = "失败数量")
    private Integer failCount;

    public Integer getSuccessCount() {
        return successCount;
    }

    public void setSuccessCount(Integer successCount) {
        this.successCount = successCount;
    }

    public Integer getFailCount() {
        return failCount;
    }

    public void setFailCount(Integer failCount) {
        this.failCount = failCount;
    }
}
