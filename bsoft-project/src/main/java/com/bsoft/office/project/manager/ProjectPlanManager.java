package com.bsoft.office.project.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.project.condition.ProjectPlanQueryCnd;
import com.bsoft.office.project.condition.ProjectStandardWordQueryCnd;
import com.bsoft.office.project.vo.*;

import java.util.List;
import java.util.Map;

public interface ProjectPlanManager {
    Result<ProjectHavePlanVO> findByProjectManager(String projectManager, String context, Integer page, Integer size);

    List<ProjectPlanDetailVO> findPlanDetailByPlanId(Integer planId);

    ProjectPlanVO saveProjectPlanAndDetail(String userId,ProjectPlanAndDetailVO projectPlanAndDetailVO);

    Boolean getByMilepostId(List<Integer> milePostId);

    Result<ProjectHavePlanVO> getProjectPlanQueryList(String personId, ProjectPlanQueryCnd paramsCnd, Integer pageNo, Integer pageSize);

    Map<String, Object> getProjectPlanQueryTree(String contractNo, String projectId, Integer part);

    Result<ProjectStandardWordVO> getProjectStandardWordList(ProjectStandardWordQueryCnd projectStandardWordQueryCnd);

}
