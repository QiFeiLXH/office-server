package com.bsoft.office.project.manager.impl;

import com.bsoft.attendance.dto.*;
import com.bsoft.attendance.service.ProjectLogService;
import com.bsoft.common.dto.PublicDicDTO;
import com.bsoft.common.result.Result;
import com.bsoft.office.common.dozer.GeneratorUtil;
import com.bsoft.office.project.condition.WorkLogAuditCnd;
import com.bsoft.office.project.manager.ProjectLogAuditManager;
import com.bsoft.office.project.vo.*;
import com.bsoft.project.dto.ProjectBaseDTO;
import com.bsoft.project.dto.ProjectLookDTO;
import com.bsoft.project.dto.ProjectPlanDetailDTO;
import com.bsoft.project.service.ProjectPlanService;
import com.bsoft.project.service.ProjectService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author zhanglf
 * @Date 2020-03-20 9:12
 * @Version 1.0
 * @Description
 */
@Service
public class ProjectLogAuditManagerImpl implements ProjectLogAuditManager {
    @Reference(timeout = 60000)
    private ProjectService projectService;
    @Reference(timeout = 60000)
    private ProjectLogService projectLogService;
    @Reference(timeout = 60000)
    private ProjectPlanService projectPlanService;
    @Autowired
    private GeneratorUtil generatorUtil;
    @Override
    public Result<ProjectLogNeedAuditVO> getProjectLogNeedAudit(String userId, WorkLogAuditCnd params) {
        params.setLoginUser(userId);
        WorkLogAuditCndDTO cndDTO = generatorUtil.convert(params,WorkLogAuditCndDTO.class);
        Result<ProjectLogNeedAuditDTO> workLoDgTOPage = projectLogService.getProjectLogNeedAudit(userId,cndDTO,params.getPageNo()-1,params.getPageSize());
        return generatorUtil.convert(workLoDgTOPage, ProjectLogNeedAuditVO.class);
    }

    @Override
    public void auditProjectLogs(String userId,List<ProjectLogAuditVO> projectLogAuditVOS) {
        projectLogAuditVOS.stream().forEach(logAudit->{
            logAudit.setAuditter(userId);
            logAudit.setFlag(5);
        });
        List<ProjectLogAuditDTO> projectLogAudits = generatorUtil.convert(projectLogAuditVOS,ProjectLogAuditDTO.class);
        projectLogService.auditProjectLogs(projectLogAudits);
    }

    @Override
    public Map<String, Object> getWorkLogById(Integer proWorkLogId, String projectId) {
        ProjectLogDTO projectLogDTO = projectLogService.getProjectLog(proWorkLogId);
        ProjectPlanDetailDTO projectPlanDetailDTO = new ProjectPlanDetailDTO();
        if(projectLogDTO.getMilepostId() == -1){
            projectPlanDetailDTO.setMilepostName("计划外");
        }else{
            projectPlanDetailDTO = projectPlanService.getProjectPlanDetail(projectLogDTO.getMilepostId());
            if(projectPlanDetailDTO == null){
                projectPlanDetailDTO = new ProjectPlanDetailDTO();
                projectPlanDetailDTO.setMilepostName("计划外");
            }
        }
//        ProjectBaseDTO customerProjectDTO = projectService.getProjectBase(projectId);
        ProjectLookDTO projectLookDTO = projectService.getProject(projectId);
        ProjectLogAuditAndEditVO projectLogVO = generatorUtil.convert(projectLogDTO,ProjectLogAuditAndEditVO.class);
        Map<String,Object> returnMap = new HashMap<>();
        returnMap.put("projectLog",projectLogVO);
        returnMap.put("planDetail",projectPlanDetailDTO);
        returnMap.put("projectInfo",projectLookDTO);
        return returnMap;
    }

    @Override
    public ProjectLogVO saveWorkLog(ProjectLogBaseVO savaWorkLogVO) {
        List<ProjectLogVO> projectLogs = savaWorkLogVO.getProjectLogs();
        List<ProjectLogDTO> projectLogDTOList = generatorUtil.convert(projectLogs, ProjectLogDTO.class);
        ProjectLogDTO projectLogDTO = projectLogDTOList.get(0);
        String contractNo = savaWorkLogVO.getContractNo();
        String projectName = savaWorkLogVO.getProjectName();
        Boolean projectChangeFlag = savaWorkLogVO.getProjectChangeFlag();
        if(projectLogDTO.getPlan().equals(2)){
            projectLogDTO.setMilepostId(-1);
        }
        projectLogDTO = projectLogService.editProjectLogAndWorkLog(projectLogDTO.getSubmitter(),contractNo,new java.sql.Date(projectLogDTO.getAttendanceDate().getTime()),projectName,projectLogDTO, projectChangeFlag,5);
        return generatorUtil.convert(projectLogDTO,ProjectLogVO.class);
    }

    @Override
    public Result<ProjectWithAuditVO> getProjectWithAuditList(String userId,WorkLogAuditCnd params) {
        WorkLogAuditCndDTO cndDTO = generatorUtil.convert(params,WorkLogAuditCndDTO.class);
        Result<ProjectWithAuditDTO> projectWithAuditDTOS = projectLogService.getProjectWithAuditList(userId,cndDTO,params.getPageNo(),params.getPageSize());
        return generatorUtil.convert(projectWithAuditDTOS,ProjectWithAuditVO.class);
    }

    @Override
    public Map<String, Object> getRoleAndType() {
        Map<String,Object> map = new HashMap<>();
        List<PublicDicDTO> roles = projectLogService.getProjectLogRoles();
        List<PublicDicDTO> types = projectLogService.getProjectLogTypes();
        map.put("roles", generatorUtil.convert(roles,PublicDicVO.class));
        map.put("types", generatorUtil.convert(types,PublicDicVO.class));
        return map;
    }
}
