package com.bsoft.office.project.manager.impl;

import com.bsoft.attendance.service.ProjectLogService;
import com.bsoft.attendance.dto.ProjectLogDTO;
import com.bsoft.common.result.Result;
import com.bsoft.office.common.dozer.GeneratorUtil;
import com.bsoft.office.project.condition.ProjectPlanQueryCnd;
import com.bsoft.office.project.condition.ProjectStandardWordQueryCnd;
import com.bsoft.office.project.manager.ProjectPlanManager;
import com.bsoft.office.project.vo.*;
import com.bsoft.project.dto.*;
import com.bsoft.project.service.ProjectPlanService;
import com.bsoft.project.service.ProjectWordService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProjectPlanManagerImpl implements ProjectPlanManager {
    @Reference(timeout = 60000)
    private ProjectPlanService projectPlanService;
    @Reference(timeout = 60000)
    private ProjectLogService projectLogService;
    @Reference(timeout = 60000)
    private ProjectWordService projectWordService;
    @Autowired
    private GeneratorUtil generator;

    @Override
    public Result<ProjectHavePlanVO> findByProjectManager(String projectManager, String context, Integer page, Integer size) {
        Result<ProjectWithPlanDTO> result = projectPlanService.getProjectWithPlans(projectManager,context,page,size);
        return generator.convert(result,ProjectHavePlanVO.class);
    }

    @Override
    public List<ProjectPlanDetailVO> findPlanDetailByPlanId(Integer planId) {
        List<ProjectPlanDetailDTO>  projectPlanDetailDTOList = projectPlanService.getProjectPlanDetailTree(planId);
        return generator.convert(projectPlanDetailDTOList,ProjectPlanDetailVO.class);
    }


    @Override
    public ProjectPlanVO saveProjectPlanAndDetail(String userId,ProjectPlanAndDetailVO projectPlanAndDetailVO) {
        ProjectPlanDTO projectPlanDTO = generator.convert(projectPlanAndDetailVO.getPlan(),ProjectPlanDTO.class);
        projectPlanDTO.setCreater(userId);
        List<ProjectPlanDetailDTO> detailDTOS = generator.convert(projectPlanAndDetailVO.getDetails(),ProjectPlanDetailDTO.class);
        projectPlanDTO = projectPlanService.saveProjectPlanAndDetail(projectPlanDTO,detailDTOS,projectPlanAndDetailVO.getDeletes());
        return generator.convert(projectPlanDTO,ProjectPlanVO.class);
    }

    @Override
    public Boolean getByMilepostId(List<Integer> milePostId) {
        List<ProjectLogDTO> projectLogDTOS = projectLogService.getByMilepostId(milePostId);
        if (projectLogDTOS.size() > 0) {
            return true;
        }
        return false;
    }

    public Result<ProjectHavePlanVO> getProjectPlanQueryList(String personId, ProjectPlanQueryCnd paramsCnd, Integer pageNo, Integer pageSize) {
        ProjectPlanQueryCndDTO cnds = generator.convert(paramsCnd, ProjectPlanQueryCndDTO.class);
        Result<ProjectWithPlanDTO> result = projectPlanService.getProjectWithPlansAndAuth(personId, cnds,pageNo,pageSize);
        return generator.convert(result, ProjectHavePlanVO.class);
    }

    public Map<String, Object> getProjectPlanQueryTree(String contractNo, String projectId, Integer part) {
        List<ProjectLogPlanDetailDTO> treeDto = projectPlanService.getProjectLogPlanDetailQueryTree(contractNo,part);
        Integer count = projectPlanService.getProjectLogPlanCount(projectId);
        boolean noPlan = count == 0;
        List<ProjectLogPlanDetailVO> tree = generator.convert(treeDto,ProjectLogPlanDetailVO.class);
        List<Integer> openKeys = new ArrayList<>();
        List<Double> workloadSum = new ArrayList<>();
        this.getOpenKeys(openKeys,tree,workloadSum);
        Double totalWorkloadRate = workloadSum.stream().collect(Collectors.summingDouble(value -> value));
        Map<String,Object> map = new HashMap<>();
        map.put("planTree",tree);
        map.put("openKeys",openKeys);
        map.put("noPlan",noPlan);
        map.put("total", new BigDecimal(totalWorkloadRate).setScale(2, RoundingMode.HALF_UP).doubleValue());
        return map;

    }

    @Override
    public Result<ProjectStandardWordVO> getProjectStandardWordList(ProjectStandardWordQueryCnd projectStandardWordQueryCnd) {
        ProjectStandardWordQueryCndDTO cnd = generator.convert(projectStandardWordQueryCnd, ProjectStandardWordQueryCndDTO.class);
        return generator.convert(projectWordService.getProjectStandardWordList(cnd), ProjectStandardWordVO.class);
    }


    public void getOpenKeys(List<Integer> openKeys,List<ProjectLogPlanDetailVO> tree,List<Double> workloadSum){
        for (ProjectLogPlanDetailVO projectLogPlanDetailVO : tree) {
            if (projectLogPlanDetailVO.getWorkloadSum() > 0) {
                workloadSum.add(projectLogPlanDetailVO.getWorkloadSum());
            }
            if(projectLogPlanDetailVO.getChildren() != null){
                if(projectLogPlanDetailVO.getChildren().size() > 0){
                    openKeys.add(projectLogPlanDetailVO.getId());
                    this.getOpenKeys(openKeys, projectLogPlanDetailVO.getChildren(),workloadSum);
                }
            }
        }
    }
}
