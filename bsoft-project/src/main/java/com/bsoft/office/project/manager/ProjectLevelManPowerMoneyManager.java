package com.bsoft.office.project.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.project.condition.ProjectReportQueryCnd;
import com.bsoft.office.project.vo.*;

import java.util.List;

public interface ProjectLevelManPowerMoneyManager {
    Result<ProjectLevelManPowerMoneyAllVO> getProjectLevelmoneyloadAll(ProjectReportQueryCnd cnd);
    List<ProjectLevelManPowerMoneyAllVO> getProjectLevelmoneyloadAllList(Integer startYear, Integer endYear);
    Result<ProjectLevelManPowerMoneyAllByYearVO> getProjectLevelmoneyloadAllByYear(ProjectReportQueryCnd cnd);
    List<ProjectLevelManPowerMoneyAllByYearVO> getProjectLevelmoneyloadAllByYearList(Integer startYear, Integer endYear);
    Result<ProjectLevelManPowerMoneyAllByMonthVO> getProjectLevelmoneyloadAllByMonth(ProjectReportQueryCnd cnd);
    List<ProjectLevelManPowerMoneyAllByMonthVO> getProjectLevelmoneyloadAllByMonthList(Integer startYear, Integer endYear);
    Result<ProjectLevelManPowerMoneyAllByDepVO> getProjectLevelmoneyloadAllByDep(ProjectReportQueryCnd cnd);
    List<ProjectLevelManPowerMoneyAllByDepVO> getProjectLevelmoneyloadAllByDepList(Integer startYear, Integer endYear);
    Result<ProjectLevelManPowerMoneyAllByDepByYearVO> getProjectLevelmoneyloadAllVOByDepByYear(ProjectReportQueryCnd cnd);
    List<ProjectLevelManPowerMoneyAllByDepByYearVO> getProjectLevelmoneyloadAllVOByDepByYearList(Integer startYear, Integer endYear);
    Result<ProjectLevelManPowerMoneyAllByDepByMonthVO> getProjectLevelmoneyloadAllVOByDepByMonth(ProjectReportQueryCnd cnd);
    List<ProjectLevelManPowerMoneyAllByDepByMonthVO> getProjectLevelmoneyloadAllVOByDepByMonthList(Integer startYear, Integer endYear);
}
