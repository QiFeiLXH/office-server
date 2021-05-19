package com.bsoft.office.project.vo;

import java.util.List;

public class ProjectPlanAndDetailVO {
    private ProjectPlanVO plan;
    private List<ProjectPlanDetailVO> details;
    private List<Integer> deletes;

    public ProjectPlanVO getPlan() {
        return plan;
    }

    public void setPlan(ProjectPlanVO plan) {
        this.plan = plan;
    }

    public List<ProjectPlanDetailVO> getDetails() {
        return details;
    }

    public void setDetails(List<ProjectPlanDetailVO> details) {
        this.details = details;
    }

    public List<Integer> getDeletes() {
        return deletes;
    }

    public void setDeletes(List<Integer> deletes) {
        this.deletes = deletes;
    }
}
