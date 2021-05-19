package com.bsoft.office.project.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.project.condition.ProjectReportQueryCnd;
import com.bsoft.office.project.manager.ProjectLevelAllManager;
import com.bsoft.office.project.vo.*;
import com.bsoft.project.report.dto.ProjectAllByMonthDTO;
import com.bsoft.project.report.dto.ProjectAllSubTotalDTO;
import com.bsoft.project.report.dto.ProjectDepTypeByMonthDTO;
import com.bsoft.project.report.dto.ProjectDepTypeByYearDTO;
import com.bsoft.project.report.service.ProjectLevelService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: bsoft-office-server
 * @BelongsPackage: com.bsoft.office.project.manager.impl
 * @Author: Xuhui Lin
 * @CreateTime: 2020-04-02 09:39
 * @Description:
 */
@Service
public class ProjectLevelAllManagerImpl implements ProjectLevelAllManager {
    @Reference(timeout = 60000)
    private ProjectLevelService projectLevelService;
    @Autowired
    private IGenerator iGenerator;
    @Override
    public Result<ProjectLevelAllSubtotalVO> findProjectLevelAllSubtotal(ProjectReportQueryCnd cnd) {
        Result<ProjectAllSubTotalDTO> list =  projectLevelService.findAllSubTotal(cnd.getStartYear(),cnd.getEndYear(),cnd.getPageNo(),cnd.getPageSize());
        return iGenerator.convert(list, ProjectLevelAllSubtotalVO.class);
    }

    @Override
    public List<ProjectLevelAllSubtotalVO> exportProjectLevelAllSubtotal(ProjectReportQueryCnd cnd) {
        List<ProjectAllSubTotalDTO> list =  projectLevelService.findAllSubTotal(cnd.getStartYear(),cnd.getEndYear());
        return iGenerator.convert(list, ProjectLevelAllSubtotalVO.class);

    }

    @Override
    public Result<ProjectLevelAllByYearVO> findProjectLevelAllYear(ProjectReportQueryCnd cnd) {
        Result<ProjectAllSubTotalDTO> list =  projectLevelService.findAllGroupByYear(cnd.getStartYear(),cnd.getEndYear(),cnd.getPageNo(),cnd.getPageSize());
        return iGenerator.convert(list, ProjectLevelAllByYearVO.class);
    }

    @Override
    public List<ProjectLevelAllByYearVO> exportProjectLevelAllYear(ProjectReportQueryCnd cnd) {
        List<ProjectAllSubTotalDTO> list =  projectLevelService.findAllGroupByYear(cnd.getStartYear(),cnd.getEndYear());
        return iGenerator.convert(list, ProjectLevelAllByYearVO.class);
    }

    @Override
    public Result<ProjectLevelAllByMonthVO> findProjectLevelAllMonth(ProjectReportQueryCnd cnd) {
        Result<ProjectAllByMonthDTO> list =  projectLevelService.findAllGroupByMonth(cnd.getStartYear(),cnd.getEndYear(),cnd.getPageNo(),cnd.getPageSize());
        return iGenerator.convert(list, ProjectLevelAllByMonthVO.class);
    }

    @Override
    public List<ProjectLevelAllByMonthVO> exportProjectLevelAllMonth(ProjectReportQueryCnd cnd) {
        List<ProjectAllByMonthDTO> list =  projectLevelService.findAllGroupByMonth(cnd.getStartYear(),cnd.getEndYear());
        return iGenerator.convert(list, ProjectLevelAllByMonthVO.class);
    }

    @Override
    public Result<ProjectLevelDepTypeSubtotalVO> findProjectLevelAllDepSubtotal(ProjectReportQueryCnd cnd) {
        Result<ProjectDepTypeByYearDTO> list =  projectLevelService.findDepTypeSubTotal(cnd.getStartYear(),cnd.getEndYear(),cnd.getPageNo(),cnd.getPageSize());
        return iGenerator.convert(list, ProjectLevelDepTypeSubtotalVO.class);
    }

    @Override
    public List<ProjectLevelDepTypeSubtotalVO> exportProjectLevelAllDepSubtotal(ProjectReportQueryCnd cnd) {
        List<ProjectDepTypeByYearDTO> list =  projectLevelService.findDepTypeSubTotal(cnd.getStartYear(),cnd.getEndYear());
        return iGenerator.convert(list, ProjectLevelDepTypeSubtotalVO.class);
    }

    @Override
    public Result<ProjectLevelDepTypeByYearVO> findProjectLevelAllDepYear(ProjectReportQueryCnd cnd) {
        Result<ProjectDepTypeByYearDTO> list =  projectLevelService.findDepTypeGroupByYear(cnd.getStartYear(),cnd.getEndYear(),cnd.getPageNo(),cnd.getPageSize());
        return iGenerator.convert(list, ProjectLevelDepTypeByYearVO.class);
    }

    @Override
    public List<ProjectLevelDepTypeByYearVO> exportProjectLevelAllDepYear(ProjectReportQueryCnd cnd) {
        List<ProjectDepTypeByYearDTO> list =  projectLevelService.findDepTypeGroupByYear(cnd.getStartYear(),cnd.getEndYear());
        return iGenerator.convert(list, ProjectLevelDepTypeByYearVO.class);
    }

    @Override
    public Result<ProjectLevelDepTypeByMonthVO> findProjectLevelAllDepMonth(ProjectReportQueryCnd cnd) {
        Result<ProjectDepTypeByMonthDTO> list =  projectLevelService.findDepTypeGroupByMonth(cnd.getStartYear(),cnd.getEndYear(),cnd.getPageNo(),cnd.getPageSize());
        return iGenerator.convert(list, ProjectLevelDepTypeByMonthVO.class);
    }

    @Override
    public List<ProjectLevelDepTypeByMonthVO> exportProjectLevelAllDepMonth(ProjectReportQueryCnd cnd) {
        List<ProjectDepTypeByMonthDTO> list =  projectLevelService.findDepTypeGroupByMonth(cnd.getStartYear(),cnd.getEndYear());
        return iGenerator.convert(list, ProjectLevelDepTypeByMonthVO.class);
    }
}
