package com.bsoft.office.project.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.project.condition.ProjectDutyQueryCnd;
import com.bsoft.office.project.manager.ProjectDutyManager;
import com.bsoft.office.project.vo.*;
import com.bsoft.project.dto.*;
import com.bsoft.project.service.ProjectDutyService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author Xuhui Lin
 * @Date 2020/5/12 12:56
 * @Description
 */
@Service
public class ProjectDutyManagerImpl implements ProjectDutyManager {
    @Reference
    private ProjectDutyService projectDutyService;
    @Autowired
    private IGenerator iGenerator;
    @Override
    public Result<ProjectDutyViewVO> getProjectDutyMaintainList(ProjectDutyQueryCnd cnd) {
        ProjectDutyQueryCndDTO params = iGenerator.convert(cnd, ProjectDutyQueryCndDTO.class);
        return iGenerator.convert(projectDutyService.getProjectDutyMaintainList(params), ProjectDutyViewVO.class);
    }

    @Override
    public Result<ProjectDutyAuditViewVO> getProjectDutyAuditList(ProjectDutyQueryCnd cnd) {
        ProjectDutyQueryCndDTO params = iGenerator.convert(cnd, ProjectDutyQueryCndDTO.class);
        return iGenerator.convert(projectDutyService.getProjectDutyAuditList(params), ProjectDutyAuditViewVO.class);
    }

    @Override
    public Result<ProjectDutyCustomerAndProjectSelectViewVO> getProjectDutyCustomerSelectList(Integer pageNo, Integer pageSize, String userId) {
        return iGenerator.convert(projectDutyService.getProjectDutyCustomerSelectList(pageNo, pageSize, userId), ProjectDutyCustomerAndProjectSelectViewVO.class);
    }

    @Override
    public List<ProjectDutyRegionViewVO> getProjectDutyRegionList(Integer dutyId) {
        return iGenerator.convert(projectDutyService.getProjectDutyRegionList(dutyId), ProjectDutyRegionViewVO.class);
    }

    @Override
    public Result<ProjectDutyCustomerAndProjectSelectViewVO> getProjectDutyProjectSelectList(String userId, String customerId, Integer pageNo, Integer pageSize) {
        return iGenerator.convert(projectDutyService.getProjectDutyProjectSelectList(userId, customerId, pageNo, pageSize), ProjectDutyCustomerAndProjectSelectViewVO.class);
    }

    @Override
    public String getProjectDutyNameNo(String customerId, String year) {
        return projectDutyService.getProjectDutyNameNo(customerId, year);
    }

    @Override
    public void deleteProjectDuty(Integer dutyId) {
        projectDutyService.deleteProjectDuty(dutyId);
    }

    @Override
    public Integer saveProjectDuty(ProjectDutyAndRegionVO projectDutyAndRegionVO, String userId) {
        ProjectDutyDTO dutyDto = iGenerator.convert(projectDutyAndRegionVO.getDuty(), ProjectDutyDTO.class);
        List<ProjectDutyRegionDTO> saveRegions = iGenerator.convert(projectDutyAndRegionVO.getSaveRegions(), ProjectDutyRegionDTO.class);
        return projectDutyService.saveProjectDutyAndRegion(dutyDto, saveRegions, projectDutyAndRegionVO.getDeleteRegions(), userId, projectDutyAndRegionVO.getContractNo());
    }

    @Override
    public void auditProjectDutyList(List<ProjectDutyAuditSaveVO> auditSaveVOS, String userId) {
        List<ProjectDutyAuditSaveDTO> auditSaveDTO = iGenerator.convert(auditSaveVOS,ProjectDutyAuditSaveDTO.class);
        projectDutyService.auditProjectDutyList(auditSaveDTO,userId);
    }

    @Override
    public List<ProjectDutyMilepostVO> getDutyMilepostList(String contractNo) {
        List<ProjectDutyMilepostDTO> dutyMilepostDTOS = projectDutyService.getProjectDutyMileposts(contractNo);
        return iGenerator.convert(dutyMilepostDTOS,ProjectDutyMilepostVO.class);
    }

    @Override
    public List<ProjectDutyMilepostVO> getDutyMilepostsWithPlan(String contractNo) {
        List<ProjectDutyMilepostDTO> dutyMilepostDTOS = projectDutyService.getDutyMilepostsWithPlan(contractNo);
        Integer num = 1;
        for(ProjectDutyMilepostDTO dutyMilepostDTO : dutyMilepostDTOS){
            String dutyName =  new StringBuilder().append(num).append(".").append(dutyMilepostDTO.getName()).toString();
            dutyMilepostDTO.setName(dutyName);
            num++;
        }
        return iGenerator.convert(dutyMilepostDTOS,ProjectDutyMilepostVO.class);
    }

    @Override
    public void saveProjectDutyMilepost(List<ProjectDutyMilepostVO> projectDutyMilepostVOS, List<Integer> deletes) {
        List<ProjectDutyMilepostDTO> mileposts = iGenerator.convert(projectDutyMilepostVOS, ProjectDutyMilepostDTO.class);
        // 数据处理，前台新增数据的id为负数，保存前将新增数据的id改为null
        mileposts.forEach(milepost -> {
            if (milepost.getId() < 0) {
                milepost.setId(null);
            }
        });
        projectDutyService.saveProjectDutyMilepost(mileposts, deletes);
    }

    @Override
    public Result<ProjectDutyMilepostViewVO> getProjectDutyMliepost(String contractNo, Integer dutyId, Integer pageNo, Integer pageSize) {
        Result<ProjectDutyMilepostViewVO> result = iGenerator.convert(projectDutyService.getProjectDutyMilepostList(contractNo, dutyId, pageNo, pageSize), ProjectDutyMilepostViewVO.class);
        result.getItems().forEach(milepost -> {
            if (!StringUtils.isBlank(milepost.getWords())) {
                milepost.setWordsNum(milepost.getWords().split(",").length);
                List<Integer> list = Arrays.asList(milepost.getWords().split(",")).stream().map(i -> Integer.valueOf(i)).collect(Collectors.toList());
                milepost.setWordsList(list);
            } else {
                milepost.setWordsList(new ArrayList<>());
            }
        });

        return result;
    }

    @Override
    public List<ProjectDutyPaymentViewVO> getProjectDutyPayment(Integer dutyId) {
        return iGenerator.convert(projectDutyService.getProjectDutyPayment(dutyId), ProjectDutyPaymentViewVO.class);
    }

    @Override
    public void saveProjectDutyPayment(List<ProjectDutyPaymentVO> saves, List<Integer> deletes) {
        List<ProjectDutyPaymentDTO> paymentDTOS = iGenerator.convert(saves, ProjectDutyPaymentDTO.class);
        projectDutyService.saveProjectDutyPayment(paymentDTOS, deletes);
    }

    @Override
    public List<ProjectDutyAuditViewVO> exportProjectDutyAuditList(ProjectDutyQueryCnd cnd) {
        ProjectDutyQueryCndDTO cndDTO = iGenerator.convert(cnd, ProjectDutyQueryCndDTO.class);
        return iGenerator.convert(projectDutyService.getAllProjectDutyAuditList(cndDTO), ProjectDutyAuditViewVO.class);
    }

    @Override
    public ProjectDutyViewVO getProjectDutyView(Integer dutyId) {
        return iGenerator.convert(projectDutyService.getOneProjectDutyView(dutyId), ProjectDutyViewVO.class);
    }

}
