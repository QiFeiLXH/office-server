package com.bsoft.office.project.manager.impl;

import com.bosft.progress.dto.ProjectProductViewDTO;
import com.bosft.progress.dto.ProjectProductViewQueryCndDTO;
import com.bsoft.common.result.Result;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.project.manager.ProjectProductViewManager;
import com.bsoft.office.project.vo.ProjectProductViewVO;
import com.bsoft.progress.service.ProjectProductViewService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProjectProductViewManagerImpl implements ProjectProductViewManager {
    @Reference(timeout = 60000, check = false)
    private ProjectProductViewService projectProductViewService;
    @Autowired
    private IGenerator iGenerator;
    @Override
    public Result<ProjectProductViewVO> getProjectProductViews(ProjectProductViewQueryCndDTO cnd) {
        Result<ProjectProductViewDTO> projectProductViews = projectProductViewService.getProjectProductViews(cnd);
        Result<ProjectProductViewVO> convert = iGenerator.convert(projectProductViews, ProjectProductViewVO.class);
        return convert;
    }
}
