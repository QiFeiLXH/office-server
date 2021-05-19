package com.bsoft.office.project.condition;

import lombok.Data;

/*
 * @author  hy
 * @date  2020/3/24 11:10
 * @description
 */
@Data
public class ProjectWordQueryCnd {
    private Integer pageNo;
    private Integer pageSize;
    private String contractNo;
    private String projectId;
    private Integer stage;
}
