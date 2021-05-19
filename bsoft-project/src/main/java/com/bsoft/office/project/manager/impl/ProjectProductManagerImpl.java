package com.bsoft.office.project.manager.impl;


import com.bosft.progress.dto.ProjectProductDTO;
import com.bosft.progress.dto.ProjectProductQueryCndDTO;
import com.bosft.progress.dto.ProjectProductSubmitDTO;
import com.bosft.progress.dto.ProjectProductViewDTO;
import com.bsoft.common.result.Result;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.project.manager.ProjectProductManager;
import com.bsoft.office.project.vo.ProjectProductVO;
import com.bsoft.office.project.vo.ProjectProductViewVO;
import com.bsoft.progress.service.ProjectProductService;
import com.bsoft.progress.service.ProjectProductViewService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjectProductManagerImpl implements ProjectProductManager {

    @Reference(timeout = 60000, check = false)
    private ProjectProductService projectProductService;
    @Autowired
    private IGenerator iGenerator;
    @Override
    public Result<ProjectProductVO> getProjectProducts(ProjectProductQueryCndDTO cnd) {
        Result<ProjectProductDTO> projectProducts = projectProductService.getProjectProducts(cnd);
        Result<ProjectProductVO> convert = iGenerator.convert(projectProducts, ProjectProductVO.class);
        return convert;
    }

    @Override
    public void saveProjectProducts(List<ProjectProductVO> projectProductDOS) {
        List<ProjectProductDTO> convert = iGenerator.convert(projectProductDOS, ProjectProductDTO.class);
        projectProductService.saveProjectProducts(convert);
    }

    @Override
    public void submitProjectProducts(List<ProjectProductVO> projectProductVOS,ProjectProductSubmitDTO projectProductSubmitDTO) {
        List<ProjectProductDTO> convert = iGenerator.convert(projectProductVOS, ProjectProductDTO.class);
        projectProductService.submitProjectProducts(convert,projectProductSubmitDTO);
    }
}
