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
public class ProjectGroupVO {
    /** 主键  */
    @OperLogFieldName(value = "ID")
    private Integer id;
    /** 上级ID  */
    @OperLogFieldName(value = "上级ID")
    private Integer parentId;
    /** 合同编号 */
    @OperLogFieldName(value = "合同编号")
    private String contractNo;
    /** 组名称  */
    @OperLogFieldName(value = "组名称")
    private String groupName;
    /** 排序号 */
    @OperLogFieldName(value = "排序号")
    private Integer sortNo;
}
