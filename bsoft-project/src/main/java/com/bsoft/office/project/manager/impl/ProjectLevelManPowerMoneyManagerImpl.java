package com.bsoft.office.project.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.dozer.GeneratorUtil;
import com.bsoft.office.project.condition.ProjectReportQueryCnd;
import com.bsoft.office.project.manager.ProjectLevelManPowerMoneyManager;
import com.bsoft.office.project.vo.*;
import com.bsoft.project.report.dto.*;
import com.bsoft.project.report.service.ProjectLevelManPowerMoneyService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectLevelManPowerMoneyManagerImpl implements ProjectLevelManPowerMoneyManager {
    @Reference(timeout = 60000)
    ProjectLevelManPowerMoneyService projectLevelManPowerMoneyService;
    @Autowired
    GeneratorUtil generatorUtil;
    @Override
    public Result<ProjectLevelManPowerMoneyAllVO> getProjectLevelmoneyloadAll(ProjectReportQueryCnd cnd) {
        Result<ProjectLevelManPowerMoneyAllDTO> result = projectLevelManPowerMoneyService.findAllSubTotal(cnd.getStartYear(),cnd.getEndYear(),cnd.getPageNo(),cnd.getPageSize());
        Result<ProjectLevelManPowerMoneyAllVO> result1 = generatorUtil.convert(result,ProjectLevelManPowerMoneyAllVO.class);
        return result1;
    }

    @Override
    public List<ProjectLevelManPowerMoneyAllVO> getProjectLevelmoneyloadAllList(Integer startYear, Integer endYear) {
        List<ProjectLevelManPowerMoneyAllDTO> result = projectLevelManPowerMoneyService.findAllSubTotalList(startYear, endYear);
        List<ProjectLevelManPowerMoneyAllVO> result1 = generatorUtil.convert(result,ProjectLevelManPowerMoneyAllVO.class);
        return result1;
    }

    @Override
    public Result<ProjectLevelManPowerMoneyAllByYearVO> getProjectLevelmoneyloadAllByYear(ProjectReportQueryCnd cnd) {
        Result<ProjectLevelManPowerMoneyAllByYearDTO> result = projectLevelManPowerMoneyService.findAllGroupByYear(cnd.getStartYear(),cnd.getEndYear(),cnd.getPageNo(),cnd.getPageSize());
        Result<ProjectLevelManPowerMoneyAllByYearVO> result1 = generatorUtil.convert(result,ProjectLevelManPowerMoneyAllByYearVO.class);
        return result1;
    }

    @Override
    public List<ProjectLevelManPowerMoneyAllByYearVO> getProjectLevelmoneyloadAllByYearList(Integer startYear, Integer endYear) {
        List<ProjectLevelManPowerMoneyAllByYearDTO> result = projectLevelManPowerMoneyService.findAllGroupByYearList(startYear, endYear);
        List<ProjectLevelManPowerMoneyAllByYearVO> result1 = generatorUtil.convert(result,ProjectLevelManPowerMoneyAllByYearVO.class);
        return result1;
    }

    @Override
    public Result<ProjectLevelManPowerMoneyAllByMonthVO> getProjectLevelmoneyloadAllByMonth(ProjectReportQueryCnd cnd) {
        Result<ProjectLevelManPowerMoneyAllByMonthDTO> result = projectLevelManPowerMoneyService.findAllGroupByMonth(cnd.getStartYear(),cnd.getEndYear(),cnd.getPageNo(),cnd.getPageSize());
        Result<ProjectLevelManPowerMoneyAllByMonthVO> result1 = generatorUtil.convert(result,ProjectLevelManPowerMoneyAllByMonthVO.class);
        return result1;
    }

    @Override
    public List<ProjectLevelManPowerMoneyAllByMonthVO> getProjectLevelmoneyloadAllByMonthList(Integer startYear, Integer endYear) {
        List<ProjectLevelManPowerMoneyAllByMonthDTO> result = projectLevelManPowerMoneyService.findAllGroupByMonthList(startYear, endYear);
        List<ProjectLevelManPowerMoneyAllByMonthVO> result1 = generatorUtil.convert(result,ProjectLevelManPowerMoneyAllByMonthVO.class);
        return result1;
    }

    @Override
    public Result<ProjectLevelManPowerMoneyAllByDepVO> getProjectLevelmoneyloadAllByDep(ProjectReportQueryCnd cnd) {
        Result<ProjectLevelManPowerMoneyAllByDepDTO> result = projectLevelManPowerMoneyService.findDepTypeSubTotal(cnd.getStartYear(),cnd.getEndYear(),cnd.getPageNo(),cnd.getPageSize());
        Result<ProjectLevelManPowerMoneyAllByDepVO> result1 = generatorUtil.convert(result, ProjectLevelManPowerMoneyAllByDepVO.class);
        return result1;
    }

    @Override
    public List<ProjectLevelManPowerMoneyAllByDepVO> getProjectLevelmoneyloadAllByDepList(Integer startYear, Integer endYear) {
        List<ProjectLevelManPowerMoneyAllByDepDTO> result = projectLevelManPowerMoneyService.findDepTypeSubTotalList(startYear, endYear);
        List<ProjectLevelManPowerMoneyAllByDepVO> result1 = generatorUtil.convert(result, ProjectLevelManPowerMoneyAllByDepVO.class);
        return result1;
    }

    @Override
    public Result<ProjectLevelManPowerMoneyAllByDepByYearVO> getProjectLevelmoneyloadAllVOByDepByYear(ProjectReportQueryCnd cnd) {
        Result<ProjectLevelManPowerMoneyAllByDepByYearDTO> result = projectLevelManPowerMoneyService.findDepTypeGroupByYear(cnd.getStartYear(),cnd.getEndYear(),cnd.getPageNo(),cnd.getPageSize());
        Result<ProjectLevelManPowerMoneyAllByDepByYearVO> result1 = generatorUtil.convert(result, ProjectLevelManPowerMoneyAllByDepByYearVO.class);
        return result1;
    }

    @Override
    public List<ProjectLevelManPowerMoneyAllByDepByYearVO> getProjectLevelmoneyloadAllVOByDepByYearList(Integer startYear, Integer endYear) {
        List<ProjectLevelManPowerMoneyAllByDepByYearDTO> result = projectLevelManPowerMoneyService.findDepTypeGroupByYearList(startYear, endYear);
        List<ProjectLevelManPowerMoneyAllByDepByYearVO> result1 = generatorUtil.convert(result, ProjectLevelManPowerMoneyAllByDepByYearVO.class);
        return result1;
    }

    @Override
    public Result<ProjectLevelManPowerMoneyAllByDepByMonthVO> getProjectLevelmoneyloadAllVOByDepByMonth(ProjectReportQueryCnd cnd) {
        Result<ProjectLevelManPowerMoneyAllByDepByMonthDTO> result = projectLevelManPowerMoneyService.findDepTypeGroupByMonth(cnd.getStartYear(),cnd.getEndYear(),cnd.getPageNo(),cnd.getPageSize());
        Result<ProjectLevelManPowerMoneyAllByDepByMonthVO> result1 = generatorUtil.convert(result, ProjectLevelManPowerMoneyAllByDepByMonthVO.class);
        return result1;
    }

    @Override
    public List<ProjectLevelManPowerMoneyAllByDepByMonthVO> getProjectLevelmoneyloadAllVOByDepByMonthList(Integer startYear, Integer endYear) {
        List<ProjectLevelManPowerMoneyAllByDepByMonthDTO> result = projectLevelManPowerMoneyService.findDepTypeGroupByMonthList(startYear, endYear);
        List<ProjectLevelManPowerMoneyAllByDepByMonthVO> result1 = generatorUtil.convert(result, ProjectLevelManPowerMoneyAllByDepByMonthVO.class);
        return result1;
    }
}
