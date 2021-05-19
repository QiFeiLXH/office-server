package com.bsoft.office.project.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.project.report.vo
 * @Author: Xuhui Lin
 * @CreateTime: 2020-02-06
 * @Description: 项目组视图vo
 */
@Data
public class ProjectGroupViewVO {
    /** 主键-组别id */
    @OperLogFieldName(value = "组ID")
    private Integer groupId;
    /** 组名 */
    @OperLogFieldName(value = "组名")
    private String groupName;
    /** 上级ID */
    @OperLogFieldName(value = "上级ID")
    private Integer parentId;
    /** 合同编号 */
    @OperLogFieldName(value = "合同号码")
    private String contractNo;
    /** 组长ID */
    @OperLogFieldName(value = "组长ID")
    private String leaderId;
    /** 组长名字 */
    @OperLogFieldName(value = "组长姓名")
    private String leaderName;
    /** 层级 */
    @OperLogFieldName(value = "层级")
    private Integer levelNo;
    /** 排序号 */
    @OperLogFieldName(value = "排序号")
    private Integer sortNo;
    /** 是否有组员 */
    @OperLogFieldName(value = "是否有组员")
    private Integer haveMembers;
    /** 组员数量 */
    @OperLogFieldName(value = "组员数量")
    private Integer membersNum;
    /** 项目组组长key */
    @OperLogFieldName(value = "项目组长key")
    private Integer leaderKey;
    /** 项目经理维护组长标记 1为项目经理维护 0为非项目经理维护 */
    @OperLogFieldName(value = "项目经理维护组长标志")
    private Integer managerMaintain;
    /** 子节点 */
    @OperLogFieldName(value = "子节点")
    private List<ProjectGroupViewVO> children = new ArrayList<>();
    /** 前台树形样式属性 */
    @OperLogFieldName(value = "前台树形样式属性")
    private Map<String,String> scopedSlots = new HashMap<>();

    {
        scopedSlots.put("title","custom");
    }

}
