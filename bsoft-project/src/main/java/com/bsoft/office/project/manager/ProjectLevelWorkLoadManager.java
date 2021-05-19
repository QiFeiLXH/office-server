package com.bsoft.office.project.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.project.condition.ProjectReportQueryCnd;
import com.bsoft.office.project.vo.*;

import java.util.List;

public interface ProjectLevelWorkLoadManager {
    Result<ProjectLevelworkloadAllVO> getProjectLevelworkloadAll(ProjectReportQueryCnd cnd);
    List<ProjectLevelworkloadAllVO> getProjectLevelworkloadAllList(Integer startYear, Integer endYear);
    Result<ProjectLevelworkloadAllByYearVO> getProjectLevelworkloadAllByYear(ProjectReportQueryCnd cnd);
    List<ProjectLevelworkloadAllByYearVO> getProjectLevelworkloadAllByYearList(Integer startYear, Integer endYear);
    Result<ProjectLevelworkloadAllByMonthVO> getProjectLevelworkloadAllByMonth(ProjectReportQueryCnd cnd);
    List<ProjectLevelworkloadAllByMonthVO> getProjectLevelworkloadAllByMonthList(Integer startYear, Integer endYear);
    Result<ProjectLevelworkloadAllByDepVO> getProjectLevelworkloadAllByDep(ProjectReportQueryCnd cnd);
    List<ProjectLevelworkloadAllByDepVO> getProjectLevelworkloadAllByDepList(Integer startYear, Integer endYear);
    Result<ProjectLevelworkloadAllByDepByYearVO> getProjectLevelworkloadAllVOByDepByYear(ProjectReportQueryCnd cnd);
    List<ProjectLevelworkloadAllByDepByYearVO> getProjectLevelworkloadAllVOByDepByYearList(Integer startYear, Integer endYear);
    Result<ProjectLevelworkloadAllByDepByMonthVO> getProjectLevelworkloadAllVOByDepByMonth(ProjectReportQueryCnd cnd);
    List<ProjectLevelworkloadAllByDepByMonthVO> getProjectLevelworkloadAllVOByDepByMonthList(Integer startYear, Integer endYear);
}
