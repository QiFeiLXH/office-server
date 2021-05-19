package com.bsoft.office.project.manager.impl;

import com.bosft.progress.dto.ProjectProductViewDTO;
import com.bosft.progress.dto.ProjectProductViewQueryCndDTO;
import com.bosft.progress.dto.ProjectReportCountQueryCndDTO;
import com.bosft.progress.dto.ProjectReportCountViewDTO;
import com.bsoft.common.result.Result;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.project.manager.ProjectProductViewManager;
import com.bsoft.office.project.manager.ProjectReportCountViewManager;
import com.bsoft.office.project.vo.ProjectProductViewVO;
import com.bsoft.office.project.vo.ProjectReportCountViewVO;
import com.bsoft.progress.service.ProjectProductViewService;
import com.bsoft.progress.service.ProjectReportCountViewService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProjectReportCountViewManagerImpl implements ProjectReportCountViewManager {
    @Reference(timeout = 60000, check = false)
    private ProjectReportCountViewService projectReportCountViewService;
    @Autowired
    private IGenerator iGenerator;
    @Override
    public Result<ProjectReportCountViewVO> getprojectReportCountViews(ProjectReportCountQueryCndDTO cnd) {
        Result<ProjectReportCountViewDTO> projectReportCountViews = projectReportCountViewService.getProjectReportCountViews(cnd);
        Result<ProjectReportCountViewVO> convert = iGenerator.convert(projectReportCountViews, ProjectReportCountViewVO.class);
        return convert;
    }

}
