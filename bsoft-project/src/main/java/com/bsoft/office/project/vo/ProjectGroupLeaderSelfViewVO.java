package com.bsoft.office.project.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.project.report.entity
 * @Author: Xuhui Lin
 * @CreateTime: 2020-02-06
 * @Description: 项目组组长为自身的列表数据vo
 */
@Data
public class ProjectGroupLeaderSelfViewVO {
    /** 项目ID */
    @OperLogFieldName(value = "项目ID")
    private String projectId;
    /** 主键-组别id */
    @OperLogFieldName(value = "组别id")
    private String leaderGroupIds;
    /** 组名 */
    @OperLogFieldName(value = "组名")
    private String leaderGroups;
    /** 项目名称 */
    @OperLogFieldName(value = "项目名称")
    private String projectName;
    /** 合同名称 */
    @OperLogFieldName(value = "合同名称")
    private String contractName;
    /** 合同编号 */
    @OperLogFieldName(value = "合同编号")
    private String contractNo;
    /** 项目经理ID */
    @OperLogFieldName(value = "项目经理ID")
    private String managerId;
    /** 项目经理名字 */
    @OperLogFieldName(value = "项目经理名字")
    private String managerText;
    /** 签订时间 */
    @OperLogFieldName(value = "签订时间")
    private String signDate;
    /** 立项时间 */
    @OperLogFieldName(value = "立项时间")
    private String establishedDate;
    /** 工程区域 */
    @OperLogFieldName(value = "工程区域")
    private String area;
    /** 工程区域文本 */
    @OperLogFieldName(value = "工程区域文本")
    private String areaText;
    /** 合同金额 */
    @OperLogFieldName(value = "合同金额")
    private String amount;
    /** 客户编码 */
    @OperLogFieldName(value = "客户编码")
    private String customerCode;
    /** 客户名称 */
    @OperLogFieldName(value = "客户名称")
    private String customerName;
    /** 客户类别 */
    @OperLogFieldName(value = "客户类别")
    private String customerClassCode;
    /** 客户类别文本 */
    @OperLogFieldName(value = "客户类别文本")
    private String customerClass;
    /** 客户级别 */
    @OperLogFieldName(value = "客户级别")
    private String customerStateCode;
    /** 客户级别文本 */
    @OperLogFieldName(value = "客户级别文本")
    private String customerState;
    /** 客户所属区域 */
    @OperLogFieldName(value = "客户所属区域")
    private String respectiveRegionCode;
    /** 客户所属区域文本 */
    @OperLogFieldName(value = "客户所属区域文本")
    private String respectiveRegion;
    /** 组长ID */
    @OperLogFieldName(value = "组长ID")
    private String leaderId;
    /** 组长名字 */
    @OperLogFieldName(value = "组长名字")
    private String leaderName;
    /** 组员人数 */
    @OperLogFieldName(value = "组员人数")
    private Integer membersNumber;

}
