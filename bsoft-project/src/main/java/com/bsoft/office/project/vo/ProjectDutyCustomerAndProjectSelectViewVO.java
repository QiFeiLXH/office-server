package com.bsoft.office.project.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

/**
 * @Author Xuhui Lin
 * @Date 2020/5/13 9:36
 * @Description 项目责任书-客户/项目选择
 */
@Data
public class ProjectDutyCustomerAndProjectSelectViewVO {
    /** 合同编号 */
    @OperLogFieldName(value = "合同编号")
    private String contractNo;
    /** 合同号 */
    @OperLogFieldName(value = "合同号")
    private String contractCode;
    /** 合同名称 */
    @OperLogFieldName(value = "合同名称")
    private String contractName;
    /** 项目id */
    @OperLogFieldName(value = "项目id")
    private String projectId;
    /** 客户编码 */
    @OperLogFieldName(value = "客户编码")
    private String customerId;
    /** 客户名称 */
    @OperLogFieldName(value = "客户名称")
    private String customerName;
    /** 项目经理 */
    @OperLogFieldName(value = "项目经理")
    private String projectManager;
    /** 工程区域 */
    @OperLogFieldName(value = "工程区域")
    private String area;
    @OperLogFieldName(value = "工程区域")
    private String areaText;
}
