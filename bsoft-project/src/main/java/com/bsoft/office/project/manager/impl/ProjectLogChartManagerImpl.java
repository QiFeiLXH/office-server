package com.bsoft.office.project.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.project.condition.ProjectLogChartQueryCnd;
import com.bsoft.office.project.manager.ProjectLogChartManager;
import com.bsoft.office.project.vo.ProjectLogChartMonthVO;
import com.bsoft.office.project.vo.ProjectLogChartVO;
import com.bsoft.project.report.dto.ProjectLogChartDTO;
import com.bsoft.project.report.dto.ProjectLogChartMonthDTO;
import com.bsoft.project.report.dto.ProjectLogChartQueryCndDTO;
import com.bsoft.project.report.service.ProjectLogChartService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: zy
 * @date: 2020/8/6 19:04
 */

@Component
public class ProjectLogChartManagerImpl implements ProjectLogChartManager {

    @Reference(timeout = 60000)
    private ProjectLogChartService projectLogChartService;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public Result<ProjectLogChartVO> getLogChartList(ProjectLogChartQueryCnd queryCnd) {
        ProjectLogChartQueryCndDTO queryCndDTO = iGenerator.convert(queryCnd, ProjectLogChartQueryCndDTO.class);
        Result<ProjectLogChartDTO> result = projectLogChartService.getLogChartList(queryCndDTO);
        return iGenerator.convert(result, ProjectLogChartVO.class);
    }

    @Override
    public Result<ProjectLogChartMonthVO> getLogChartMonthList(ProjectLogChartQueryCnd queryCnd) {
        ProjectLogChartQueryCndDTO queryCndDTO = iGenerator.convert(queryCnd, ProjectLogChartQueryCndDTO.class);
        Result<ProjectLogChartMonthDTO> result = projectLogChartService.getLogChartMonthList(queryCndDTO);
        return iGenerator.convert(result, ProjectLogChartMonthVO.class);
    }
}
