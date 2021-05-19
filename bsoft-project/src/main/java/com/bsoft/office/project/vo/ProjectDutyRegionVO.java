package com.bsoft.office.project.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

/**
 * @Author Xuhui Lin
 * @Date 2020/5/14 14:29
 * @Description 项目责任书-项目范围
 */
@Data
public class ProjectDutyRegionVO {
    @OperLogFieldName(value = "id")
    private Integer id;
    /** 责任书id */
    @OperLogFieldName(value = "责任书id")
    private Integer dutyId;
    /** 合同编号 */
    @OperLogFieldName(value = "合同编号")
    private String contractNo;
    /** 权重 */
    @OperLogFieldName(value = "权重")
    private Double weight;
}
