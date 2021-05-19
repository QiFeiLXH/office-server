package com.bsoft.office.project.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.dozer.GeneratorUtil;
import com.bsoft.office.project.condition.ProjectReportQueryCnd;
import com.bsoft.office.project.manager.ProjectLevelWorkLoadManager;
import com.bsoft.office.project.vo.*;
import com.bsoft.project.report.dto.*;
import com.bsoft.project.report.service.ProjectLevelWorkloadService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectLevelWorkLoadManagerImpl implements ProjectLevelWorkLoadManager {
    @Reference(timeout = 60000)
    ProjectLevelWorkloadService projectLevelWorkloadService;

    @Autowired
    GeneratorUtil generatorUtil;
    @Override
    public Result<ProjectLevelworkloadAllVO> getProjectLevelworkloadAll(ProjectReportQueryCnd cnd) {
        Result<ProjectLevelworkloadAllDTO> result = projectLevelWorkloadService.findAllSubTotal(cnd.getStartYear(),cnd.getEndYear(),cnd.getPageNo(),cnd.getPageSize());
        Result<ProjectLevelworkloadAllVO> result1 = generatorUtil.convert(result,ProjectLevelworkloadAllVO.class);
        return result1;
    }

    @Override
    public List<ProjectLevelworkloadAllVO> getProjectLevelworkloadAllList(Integer startYear, Integer endYear) {
        List<ProjectLevelworkloadAllDTO> result = projectLevelWorkloadService.findAllSubTotalList(startYear, endYear);
        List<ProjectLevelworkloadAllVO> result1 = generatorUtil.convert(result,ProjectLevelworkloadAllVO.class);
        return result1;
    }

    @Override
    public Result<ProjectLevelworkloadAllByYearVO> getProjectLevelworkloadAllByYear(ProjectReportQueryCnd cnd) {
        Result<ProjectLevelworkloadAllByYearDTO> result = projectLevelWorkloadService.findAllGroupByYear(cnd.getStartYear(),cnd.getEndYear(),cnd.getPageNo(),cnd.getPageSize());
        Result<ProjectLevelworkloadAllByYearVO> result1 = generatorUtil.convert(result,ProjectLevelworkloadAllByYearVO.class);
        return result1;
    }

    @Override
    public List<ProjectLevelworkloadAllByYearVO> getProjectLevelworkloadAllByYearList(Integer startYear, Integer endYear) {
        List<ProjectLevelworkloadAllByYearDTO> result = projectLevelWorkloadService.findAllGroupByYearList(startYear, endYear);
        List<ProjectLevelworkloadAllByYearVO> result1 = generatorUtil.convert(result,ProjectLevelworkloadAllByYearVO.class);
        return result1;
    }

    @Override
    public Result<ProjectLevelworkloadAllByMonthVO> getProjectLevelworkloadAllByMonth(ProjectReportQueryCnd cnd) {
        Result<ProjectLevelworkloadAllByMonthDTO> result = projectLevelWorkloadService.findAllGroupByMonth(cnd.getStartYear(),cnd.getEndYear(),cnd.getPageNo(),cnd.getPageSize());
        Result<ProjectLevelworkloadAllByMonthVO> result1 = generatorUtil.convert(result,ProjectLevelworkloadAllByMonthVO.class);
        return result1;
    }

    @Override
    public List<ProjectLevelworkloadAllByMonthVO> getProjectLevelworkloadAllByMonthList(Integer startYear, Integer endYear) {
        List<ProjectLevelworkloadAllByMonthDTO> result = projectLevelWorkloadService.findAllGroupByMonthList(startYear, endYear);
        List<ProjectLevelworkloadAllByMonthVO> result1 = generatorUtil.convert(result,ProjectLevelworkloadAllByMonthVO.class);
        return result1;
    }

    @Override
    public Result<ProjectLevelworkloadAllByDepVO> getProjectLevelworkloadAllByDep(ProjectReportQueryCnd cnd) {
        Result<ProjectLevelworkloadAllByDepDTO> result = projectLevelWorkloadService.findDepTypeSubTotal(cnd.getStartYear(),cnd.getEndYear(),cnd.getPageNo(),cnd.getPageSize());
        Result<ProjectLevelworkloadAllByDepVO> result1 = generatorUtil.convert(result, ProjectLevelworkloadAllByDepVO.class);
        return result1;
    }

    @Override
    public List<ProjectLevelworkloadAllByDepVO> getProjectLevelworkloadAllByDepList(Integer startYear, Integer endYear) {
        List<ProjectLevelworkloadAllByDepDTO> result = projectLevelWorkloadService.findDepTypeSubTotalList(startYear, endYear);
        List<ProjectLevelworkloadAllByDepVO> result1 = generatorUtil.convert(result, ProjectLevelworkloadAllByDepVO.class);
        return result1;
    }

    @Override
    public Result<ProjectLevelworkloadAllByDepByYearVO> getProjectLevelworkloadAllVOByDepByYear(ProjectReportQueryCnd cnd) {
        Result<ProjectLevelworkloadAllByDepByYearDTO> result = projectLevelWorkloadService.findDepTypeGroupByYear(cnd.getStartYear(),cnd.getEndYear(),cnd.getPageNo(),cnd.getPageSize());
        Result<ProjectLevelworkloadAllByDepByYearVO> result1 = generatorUtil.convert(result, ProjectLevelworkloadAllByDepByYearVO.class);
        return result1;
    }

    @Override
    public List<ProjectLevelworkloadAllByDepByYearVO> getProjectLevelworkloadAllVOByDepByYearList(Integer startYear, Integer endYear) {
        List<ProjectLevelworkloadAllByDepByYearDTO> result = projectLevelWorkloadService.findDepTypeGroupByYearList(startYear, endYear);
        List<ProjectLevelworkloadAllByDepByYearVO> result1 = generatorUtil.convert(result, ProjectLevelworkloadAllByDepByYearVO.class);
        return result1;
    }

    @Override
    public Result<ProjectLevelworkloadAllByDepByMonthVO> getProjectLevelworkloadAllVOByDepByMonth(ProjectReportQueryCnd cnd) {
        Result<ProjectLevelworkloadAllByDepByMonthDTO> result = projectLevelWorkloadService.findDepTypeGroupByMonth(cnd.getStartYear(),cnd.getEndYear(),cnd.getPageNo(),cnd.getPageSize());
        Result<ProjectLevelworkloadAllByDepByMonthVO> result1 = generatorUtil.convert(result, ProjectLevelworkloadAllByDepByMonthVO.class);
        return result1;
    }

    @Override
    public List<ProjectLevelworkloadAllByDepByMonthVO> getProjectLevelworkloadAllVOByDepByMonthList(Integer startYear, Integer endYear) {
        List<ProjectLevelworkloadAllByDepByMonthDTO> result = projectLevelWorkloadService.findDepTypeGroupByMonthList(startYear, endYear);
        List<ProjectLevelworkloadAllByDepByMonthVO> result1 = generatorUtil.convert(result, ProjectLevelworkloadAllByDepByMonthVO.class);
        return result1;
    }
}
