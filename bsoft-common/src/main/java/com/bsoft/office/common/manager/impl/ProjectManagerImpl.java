package com.bsoft.office.common.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.common.manager.ProjectManager;
import com.bsoft.office.common.vo.ProjectLookVO;
import com.bsoft.office.common.vo.ProjectVO;
import com.bsoft.project.dto.ProjectDTO;
import com.bsoft.project.dto.ProjectLookDTO;
import com.bsoft.project.service.ProjectService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/24 15:53
 * @Description
 */
@Service
public class ProjectManagerImpl implements ProjectManager {
    @Autowired
    private IGenerator iGenerator;
    @Reference
    private ProjectService projectService;
    @Override
    public Result<ProjectVO> getProjectList(Integer pageNo, Integer pageSize, String contractNo) {
        Result<ProjectDTO> result = projectService.getProjectsWithContractNo(pageNo, pageSize, contractNo);
        return iGenerator.convert(result, ProjectVO.class);
    }

    @Override
    public Result<ProjectLookVO> getProjectLookList(Integer pageNo, Integer pageSize, String contractNo, String inputContent) {
        Result<ProjectLookDTO> result = projectService.getProjectLookList(pageNo, pageSize, contractNo, inputContent);
        return iGenerator.convert(result, ProjectLookVO.class);
    }

    public Result<ProjectLookVO> getAllProjectList(Integer pageNo, Integer pageSize, String inputContent){
        Result<ProjectLookDTO> result = projectService.getAllProjectList(pageNo,pageSize,inputContent);
        return iGenerator.convert(result, ProjectLookVO.class);
    }
}
