package com.bsoft.office.manager.condition;

import lombok.Data;

@Data
public class ProcessDeployQueryCnd{
    /* 输入内容 */
    private String inputContent;
    /* 页码 */
    private Integer pageNo;
    /* 每页数量 */
    private Integer pageSize;
    /* 部署状态*/
    private Integer status;
    /* 流程类别 */
    private Integer type;
}
