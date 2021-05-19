package com.bsoft.office.project.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/5/13 9:44
 * @Description 项目责任书-项目范围
 */
@Data
public class ProjectDutyRegionViewVO{
    @OperLogFieldName(value = "id")
    private Integer id;
    /** 责任书id */
    @OperLogFieldName(value = "责任书id")
    private Integer dutyId;
    /** 合同编号 */
    @OperLogFieldName(value = "合同编号")
    private String contractNo;
    /** 合同号 */
    @OperLogFieldName(value = "合同号")
    private String contractCode;
    /** 合同名称 */
    @OperLogFieldName(value = "合同名称")
    private String contractName;
    /** 权重 */
    @OperLogFieldName(value = "权重")
    private Double weight;
    /** 里程碑 */
    @OperLogFieldName(value = "里程碑")
    private List<ProjectDutyMilepostViewVO> mileposts;
}
