package com.bsoft.office.project.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.project.condition.ProjectReportQueryCnd;
import com.bsoft.office.project.manager.ProjectLevelBonusManager;
import com.bsoft.office.project.vo.*;
import com.bsoft.project.report.dto.ProjectBonusDTO;
import com.bsoft.project.report.service.ProjectBonusService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/4/26 17:42
 * @Description
 */
@Service
public class ProjectLevelBonusManagerImpl implements ProjectLevelBonusManager {
    @Reference(timeout = 60000)
    private ProjectBonusService projectBonusService;
    @Autowired
    private IGenerator iGenerator;
    @Override
    public Result<ProjectLevelBonusAllSubtotalVO> getProjectLevelBonusAllSubtotal(ProjectReportQueryCnd queryCnd) {
        Result<ProjectBonusDTO> result = projectBonusService.findProjectBonusProAllTotal(queryCnd.getStartYear(), queryCnd.getEndYear(), queryCnd.getPageNo(), queryCnd.getPageSize());
        return iGenerator.convert(result, ProjectLevelBonusAllSubtotalVO.class);
    }

    @Override
    public List<ProjectLevelBonusAllSubtotalVO> exportProjectLevelBonusAllSubtotal(ProjectReportQueryCnd queryCnd) {
        List<ProjectBonusDTO> result = projectBonusService.findProjectBonusProAllTotal(queryCnd.getStartYear(), queryCnd.getEndYear());
        return iGenerator.convert(result, ProjectLevelBonusAllSubtotalVO.class);
    }

    @Override
    public Result<ProjectLevelBonusAllByYearVO> getProjectLevelBonusAllYear(ProjectReportQueryCnd queryCnd) {
        Result<ProjectBonusDTO> result = projectBonusService.findProjectBonusProAllYear(queryCnd.getStartYear(), queryCnd.getEndYear(), queryCnd.getPageNo(), queryCnd.getPageSize());
        return iGenerator.convert(result, ProjectLevelBonusAllByYearVO.class);
    }

    @Override
    public List<ProjectLevelBonusAllByYearVO> exportProjectLevelBonusAllYear(ProjectReportQueryCnd queryCnd) {
        List<ProjectBonusDTO> result = projectBonusService.findProjectBonusProAllYear(queryCnd.getStartYear(), queryCnd.getEndYear());
        return iGenerator.convert(result, ProjectLevelBonusAllByYearVO.class);
    }

    @Override
    public Result<ProjectLevelBonusAllByMonthVO> getProjectLevelBonusAllMonth(ProjectReportQueryCnd queryCnd) {
        Result<ProjectBonusDTO> result = projectBonusService.findProjectBonusProAllMonth(queryCnd.getStartYear(), queryCnd.getEndYear(), queryCnd.getPageNo(), queryCnd.getPageSize());
        return iGenerator.convert(result, ProjectLevelBonusAllByMonthVO.class);
    }

    @Override
    public List<ProjectLevelBonusAllByMonthVO> exportProjectLevelBonusAllMonth(ProjectReportQueryCnd queryCnd) {
        List<ProjectBonusDTO> result = projectBonusService.findProjectBonusProAllMonth(queryCnd.getStartYear(), queryCnd.getEndYear());
        return iGenerator.convert(result, ProjectLevelBonusAllByMonthVO.class);
    }

    @Override
    public Result<ProjectLevelBonusDepTypeSubtotalVO> getProjectLevelBonusDepSubtotal(ProjectReportQueryCnd queryCnd) {
        Result<ProjectBonusDTO> result = projectBonusService.findProjectBonusProDepTotal(queryCnd.getStartYear(), queryCnd.getEndYear(), queryCnd.getPageNo(), queryCnd.getPageSize());
        return iGenerator.convert(result, ProjectLevelBonusDepTypeSubtotalVO.class);
    }

    @Override
    public List<ProjectLevelBonusDepTypeSubtotalVO> exportProjectLevelBonusDepSubtotal(ProjectReportQueryCnd queryCnd) {
        List<ProjectBonusDTO> result = projectBonusService.findProjectBonusProDepTotal(queryCnd.getStartYear(), queryCnd.getEndYear());
        return iGenerator.convert(result, ProjectLevelBonusDepTypeSubtotalVO.class);
    }

    @Override
    public Result<ProjectLevelBonusDepTypeByYearVO> getProjectLevelBonusDepYear(ProjectReportQueryCnd queryCnd) {
        Result<ProjectBonusDTO> result = projectBonusService.findProjectBonusProDepYear(queryCnd.getStartYear(), queryCnd.getEndYear(), queryCnd.getPageNo(), queryCnd.getPageSize());
        return iGenerator.convert(result, ProjectLevelBonusDepTypeByYearVO.class);
    }

    @Override
    public List<ProjectLevelBonusDepTypeByYearVO> exportProjectLevelBonusDepYear(ProjectReportQueryCnd queryCnd) {
        List<ProjectBonusDTO> result = projectBonusService.findProjectBonusProDepYear(queryCnd.getStartYear(), queryCnd.getEndYear());
        return iGenerator.convert(result, ProjectLevelBonusDepTypeByYearVO.class);
    }

    @Override
    public Result<ProjectLevelBonusDepTypeByMonthVO> getProjectLevelBonusDepMonth(ProjectReportQueryCnd queryCnd) {
        Result<ProjectBonusDTO> result = projectBonusService.findProjectBonusProDepMonth(queryCnd.getStartYear(), queryCnd.getEndYear(), queryCnd.getPageNo(), queryCnd.getPageSize());
        return iGenerator.convert(result, ProjectLevelBonusDepTypeByMonthVO.class);
    }

    @Override
    public List<ProjectLevelBonusDepTypeByMonthVO> exportProjectLevelBonusDepMonth(ProjectReportQueryCnd queryCnd) {
        List<ProjectBonusDTO> result = projectBonusService.findProjectBonusProDepMonth(queryCnd.getStartYear(), queryCnd.getEndYear());
        return iGenerator.convert(result, ProjectLevelBonusDepTypeByMonthVO.class);
    }
}
