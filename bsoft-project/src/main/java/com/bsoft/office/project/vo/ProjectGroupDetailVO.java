package com.bsoft.office.project.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

/**
 * @BelongsProject: bsoft-office-server
 * @BelongsPackage: com.bsoft.project.group.entity
 * @Author: Xuhui Lin
 * @CreateTime: 2020-03-18
 * @Description:
 */
@Data
public class ProjectGroupDetailVO {
    /** 主键  */
    @OperLogFieldName(value = "主键")
    private Integer id;
    /** 项目组ID  */
    @OperLogFieldName(value = "项目组ID")
    private Integer groupId;
    /** 组成员工号  */
    @OperLogFieldName(value = "组成员工号")
    private String personId;
    /** 1、组长 0、组员  */
    @OperLogFieldName(value = "标志")
    private Integer leader;
    /** 维护组长的工号  */
    @OperLogFieldName(value = "维护组长的工号")
    private String maintainId;
}
