package com.bsoft.office.project.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/*
 * @author  hy
 * @date  2020/3/5 12:46
 * @description
 */
@Data
public class ProjectLogPlanDetailVO implements Serializable {
    private Integer id;
    private Integer parentId;
    private String milepostName;
    private Integer logoff;
    private Integer logNum;
    private Double workloadSum;
    private String contractNo;
    private String icon;
    private Integer range;
    private Integer milepostId;
    private Integer finishFlag;
    private List<ProjectLogPlanDetailVO> children;
}
