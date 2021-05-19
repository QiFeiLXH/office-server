package com.bsoft.office.common.exportExcel;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

/**
 * @BelongsProject: bsoft-office-server
 * @BelongsPackage: com.bsoft.office.common.exportExcel
 * @Author: Qi fei
 * @CreateTime: 2020-07-26 10:43
 * @Description: 导入结果
 */
@Data
public class ImportResultVO {
    /** 成功数量 */
    @OperLogFieldName(value = "成功数量")
    private Integer successCount;
    /** 失败数量 */
    @OperLogFieldName(value = "失败数量")
    private Integer failCount;

    public ImportResultVO() {}

    public ImportResultVO(Integer successCount, Integer failCount) {
        this.successCount = successCount;
        this.failCount = failCount;
    }
}
