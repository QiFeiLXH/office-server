package com.bsoft.office.project.manager.impl;

import com.bsoft.attendance.dto.*;
import com.bsoft.attendance.service.AttendanceService;
import com.bsoft.attendance.service.ProjectLogService;
import com.bsoft.common.dto.PublicDicDTO;
import com.bsoft.common.result.Result;
import com.bsoft.common.service.ServerDateService;
import com.bsoft.contract.dto.ContractDTO;
import com.bsoft.contract.service.ContractService;
import com.bsoft.exception.ServiceException;
import com.bsoft.house.dto.HouseDTO;
import com.bsoft.house.service.HouseService;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.common.utils.DateUtils;
import com.bsoft.office.project.condition.ProjectLogQueryCnd;
import com.bsoft.office.project.condition.ProjectWordQueryCnd;
import com.bsoft.office.project.manager.ProjectLogManager;
import com.bsoft.office.project.vo.*;
import com.bsoft.project.dto.*;
import com.bsoft.project.service.ProjectDutyService;
import com.bsoft.project.service.ProjectPlanService;
import com.bsoft.project.service.ProjectWordService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProjectLogManagerImpl implements ProjectLogManager {

    @Reference(timeout = 60000)
    private ProjectLogService projectLogService;

    @Reference(timeout = 60000)
    private ProjectPlanService projectPlanService;

    @Reference
    private ServerDateService serverDateService;

    @Reference(timeout = 60000)
    private ProjectWordService projectWordService;

    @Reference(timeout = 60000)
    private ContractService contractService;

    @Reference(timeout = 60000)
    private HouseService houseService;

    @Reference(timeout = 60000)
    private AttendanceService attendanceService;

    @Reference(timeout = 60000)
    private ProjectDutyService projectDutyService;

    @Autowired
    private IGenerator generatorUtil;

    @Override
    public Map<String,Object> init(String userId){
        Map<String,Object> map = new HashMap<>();
        ProjectBaseDTO customerProjectDTO = projectLogService.getLastestProjectBase(userId);
        List<ProjectWorkLogSituationVO> situations = new ArrayList<>();
        List<ProjectLogPlanDetailVO> tree = new ArrayList<>();
        List<Integer> openKeys = new ArrayList<>();
        List<ProjectWorkLogSituationDTO> result = projectLogService.getProjectWorkLogSituation(userId,5);
        List<PublicDicDTO> roles = projectLogService.getProjectLogRoles();
        List<PublicDicVO> roleVOS = generatorUtil.convert(roles, PublicDicVO.class);
        List<PublicDicDTO> types = projectLogService.getProjectLogTypes();
        List<PublicDicVO> typeVOS = generatorUtil.convert(types, PublicDicVO.class);
        List<PublicDicDTO> fileTypes = projectWordService.getProjectLogFileUploadType();
        List<PublicDicVO> fileTypeVOS = generatorUtil.convert(fileTypes, PublicDicVO.class);
        situations = generatorUtil.convert(result,ProjectWorkLogSituationVO.class);
        Boolean noPlan = true;
        if(customerProjectDTO != null){
            List<ProjectLogPlanDetailDTO> treeDto = projectPlanService.getProjectLogPlanDetailTree(customerProjectDTO.getProjectId(),userId, situations.get(0).getAttendanceDate(),0);
            tree = generatorUtil.convert(treeDto,ProjectLogPlanDetailVO.class);
            this.getOpenKeys(openKeys,tree);
            Integer count = projectPlanService.getProjectLogPlanCount(customerProjectDTO.getProjectId());
            noPlan = count == 0;
        }
        //boolean haveLogs = projectLogService.haveProjectLogs(userId);
        map.put("customerProject", generatorUtil.convert(customerProjectDTO, CustomerProjectVO.class));
        map.put("planTree", tree);
        map.put("noPlan", noPlan);
        map.put("openKeys",openKeys);
        map.put("time", situations);
        map.put("roles", roleVOS);
        map.put("types", typeVOS);
        map.put("fileTypes", fileTypeVOS);
        //map.put("haveLogs", haveLogs);
        return map;
    }

    @Override
    public List<ProjectLogVO> getOwnProjectLogs(String projectId, String userId, Integer milepostId, java.sql.Date attendanceDate){
        List<ProjectLogDTO> list = projectLogService.getProjectWorkLogs(projectId,userId,milepostId,attendanceDate);
        List<ProjectLogVO> result = generatorUtil.convert(list ,ProjectLogVO.class);
        return result;
    }

    @Override
    public Result<CustomerProjectVO> searchProjects(String userId, String context, Integer pageNo, Integer pageSize){
        Result<ProjectBaseDTO> resultDTO = projectLogService.searchProjectsWithCommon(userId,context, pageNo, pageSize);
        Result<CustomerProjectVO>  resultVO = generatorUtil.convert(resultDTO, CustomerProjectVO.class);
        return resultVO;
    }

    @Override
    public void deleteProjectLog(Integer id){
        Integer auditCount = projectLogService.getProjectLogAuditCount(id);
        if(auditCount > 0 ){
            throw new ServiceException("该日志已审核,不能删除");
        }else{
            projectLogService.deleteProjectLog(id);
        }
    }

    @Override
    public Map<String,Object> getPlanTree(String projectId,String userId,String attendanceDate,Integer part){
        List<ProjectWorkLogSituationDTO> times = projectLogService.getProjectWorkLogSituation(userId,5);
        List<ProjectWorkLogSituationVO> situations = generatorUtil.convert(times,ProjectWorkLogSituationVO.class);
        List<ProjectLogPlanDetailDTO> treeDto = projectPlanService.getProjectLogPlanDetailTree(projectId,userId, DateUtils.toDate(attendanceDate),part);
        List<ProjectLogPlanDetailVO> tree = generatorUtil.convert(treeDto,ProjectLogPlanDetailVO.class);
        Integer count = projectPlanService.getProjectLogPlanCount(projectId);
        Boolean noPlan = count == 0;
        List<Integer> openKeys = new ArrayList<>();
        this.getOpenKeys(openKeys,tree);
        Map<String,Object> map = new HashMap<>();
        map.put("planTree",tree);
        map.put("openKeys",openKeys);
        map.put("noPlan",noPlan);
        map.put("time", situations);
        return map;
    }

    public void getOpenKeys(List<Integer> openKeys,List<ProjectLogPlanDetailVO> tree){
        tree.forEach(projectLogPlanDetailVO -> {
            if(projectLogPlanDetailVO.getChildren() != null){
                if(projectLogPlanDetailVO.getChildren().size() > 0){
                    openKeys.add(projectLogPlanDetailVO.getId());
                    this.getOpenKeys(openKeys, projectLogPlanDetailVO.getChildren());
                }
            }
        });
    }

    @Override
    public List<ProjectLogVO> saveWorkLogs(String userId, ProjectLogBaseVO projectLogBaseVO) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date attendanceDate = sdf.parse(projectLogBaseVO.getAttendanceDate());
        java.util.Date now = serverDateService.getServerDateTime();
        Integer days = Math.toIntExact(DateUtils.dateToLocalDate(now).toEpochDay() - DateUtils.dateToLocalDate(new java.sql.Date(attendanceDate.getTime())).toEpochDay());
        if(days > 4){
            throw new ServiceException("只能保存5天内的日志");
        }
        List<ProjectLogVO> projectLogs = projectLogBaseVO.getProjectLogs();

        List<ProjectLogDTO> oldLogs = projectLogService.getProjectWorkLogsWithNoTechnum(projectLogBaseVO.getProjectId(),userId,attendanceDate);
        oldLogs.forEach((projectLogDTO)->{
            projectLogs.removeIf((projectLog)->projectLogDTO.getId().equals(projectLog.getId())&&projectLogDTO.getAuditCount()>0);
        });
        ProjectLogBaseDTO projectLogBaseDTO = new ProjectLogBaseDTO(projectLogBaseVO.getContractNo(), new java.sql.Date(attendanceDate.getTime()), projectLogBaseVO.getProjectName(), projectLogBaseVO.getHouseId(), projectLogBaseVO.getHouseType(),projectLogBaseVO.getEvection());
        projectLogs.removeIf((projectLog)->projectLog.getTechnumid() != null && projectLog.getSourceType() == 1);
        List<ProjectLogDTO> projectLogDTOList = generatorUtil.convert(projectLogs, ProjectLogDTO.class);
        projectLogDTOList = projectLogService.saveProjectLogsAndWorkLogs(userId, projectLogBaseDTO ,projectLogDTOList,5);
        return generatorUtil.convert(projectLogDTOList,ProjectLogVO.class);
    }

    @Override
    public Result<ProjectPlanQueryLogVO> getProjectWorklogList(Integer pageSize, Integer pageNo, Integer milepostId, String contractNo) {
        return generatorUtil.convert(projectLogService.getProjectPlanQueryLogList(pageSize, pageNo, milepostId, contractNo), ProjectPlanQueryLogVO.class);
    }

    @Override
    public ProjectLogInfoQueryVO getWorklogInfo(Integer id) {
        return generatorUtil.convert(projectLogService.getProjectLog(id), ProjectLogInfoQueryVO.class);
    }

    @Override
    public Result<ProjectWordViewVO> getProjectWordList(ProjectWordQueryCnd projectWordQueryCnd) {
        Result<ProjectWordViewDTO> resultDTO = projectWordService.getProjectWordViewList(projectWordQueryCnd.getPageNo(),projectWordQueryCnd.getPageSize(),projectWordQueryCnd.getContractNo(),projectWordQueryCnd.getProjectId(),projectWordQueryCnd.getStage());
        Result<ProjectWordViewVO> resultVO = generatorUtil.convert(resultDTO, ProjectWordViewVO.class);
        return resultVO;
    }

    @Override
    public Result<ProjectWordRecordViewVO> getProjectWordDetails(Integer page, Integer size, Integer id, Integer milepostId) {
        Result<ProjectWordRecordViewDTO> resultDTO = projectWordService.getProjectWordDetails(page, size, id, milepostId);
        Result<ProjectWordRecordViewVO> resultVO = generatorUtil.convert(resultDTO, ProjectWordRecordViewVO.class);
        return resultVO;
    }

    @Override
    public void fileUpload(String userId, MultipartFile file, Integer id, Integer fileKey, String contractId,Integer detailId,Integer milepostId) throws IOException {
        ContractDTO contractDTO = contractService.getContract(contractId);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        ProjectWordBaseUploadDTO uploadDTO = new ProjectWordBaseUploadDTO();
        // 获取文件名
        String fileName = file.getOriginalFilename();
        //判断是否为IE浏览器的文件名，IE浏览器下文件名会带有盘符信息
        // Check for Unix-style path
        int unixSep = fileName.lastIndexOf('/');
        // Check for Windows-style path
        int winSep = fileName.lastIndexOf('\\');
        int pos = Math.max(winSep, unixSep);
        if (pos != -1)  {
            fileName = fileName.substring(pos + 1);
        }
        List<PublicDicDTO> fileUploadTypes = projectWordService.getProjectLogFileUploadType();
        String format = fileName.substring(fileName.lastIndexOf(".") + 1);
        boolean check = false;
        for (PublicDicDTO uploadType : fileUploadTypes) {
            if(format.equals(uploadType.getName())){
                check = true;
                break;
            }
        }
        if(check){
            uploadDTO.setMilepostId(milepostId);
            uploadDTO.setOriginalFilename(fileName);
            uploadDTO.setUserId(userId);
            uploadDTO.setFileBytes(file.getBytes());
            uploadDTO.setContractId(contractId);
            uploadDTO.setFileKey(fileKey);
            uploadDTO.setDetailId(detailId);
            uploadDTO.setId(id);
            uploadDTO.setNewFileName(System.currentTimeMillis()+ Objects.requireNonNull(file.getOriginalFilename()).substring(file.getOriginalFilename().lastIndexOf("."),file.getOriginalFilename().length()));
            String fileYear = contractDTO.getFileYear() != null ? contractDTO.getFileYear().toString():sdf.format(contractDTO.getSignDate());
            projectWordService.projectWordUpload(uploadDTO,fileYear);
        }else{
            throw new ServiceException("上传格式不正确");
        }
    }

    @Override
    public ProjectWordDetailDTO findDetailById(String htbh, Integer detailId) {
        ContractDTO contractDTO = contractService.getContract(htbh);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        String fileYear = contractDTO.getFileYear() != null ? contractDTO.getFileYear().toString():sdf.format(contractDTO.getSignDate());
        return projectWordService.findDetailById(fileYear,detailId);
    }

    @Override
    public void deleteFile(Integer id, Integer detailId, String htbh) {
        ContractDTO contractDTO = contractService.getContract(htbh);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        String fileYear = contractDTO.getFileYear() != null ? contractDTO.getFileYear().toString():sdf.format(contractDTO.getSignDate());
        projectWordService.deleteFile(id,detailId,fileYear);
    }

    @Override
    public ReferenceDocumentDTO findReferenceFileById(Integer fileId) {
        ReferenceDocumentDTO referenceDocumentDTO = projectWordService.getReferenceDocument(fileId);
        return referenceDocumentDTO;
    }

    @Override
    public Result<HouseVO> searchHouses(String context,String area,String userId, Integer pageNo, Integer pageSize) {
        Result<HouseDTO> result = houseService.searchHouseViews(context,area,userId,pageNo,pageSize);
        return generatorUtil.convert(result,HouseVO.class);
    }

    @Override
    public AttendanceVO ownAttendance(String userId, String attendanceDate) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date d = null;
        try {
            d = format.parse(attendanceDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        java.sql.Date date = new java.sql.Date(d.getTime());
        AttendanceWholeDTO attendanceWholeDTO = attendanceService.getAttendance(date, userId);
        AttendanceDTO attendanceDTO = attendanceWholeDTO.getAttendanceDTO();
        return generatorUtil.convert(attendanceDTO,AttendanceVO.class);
    }

    @Override
    public List<PublicDicVO>  getFileUploadTypes() {
        List<PublicDicDTO> fileUploadTypes = projectWordService.getProjectLogFileUploadType();
        return generatorUtil.convert(fileUploadTypes,PublicDicVO.class);
    }

    @Override
    public Result<ProjectLogQueryProjectVO> getProjectsWithLogsnum(ProjectLogQueryCnd projectLogQueryCnd) {
        ProjectLogQueryCndDTO cnd = generatorUtil.convert(projectLogQueryCnd, ProjectLogQueryCndDTO.class);
        return generatorUtil.convert(projectLogService.getProjectLogQueryProjectList(cnd), ProjectLogQueryProjectVO.class);
    }

    @Override
    public Result<ProjectLogQueryDetailVO> getProjectLogSummary(ProjectLogQueryCnd projectLogQueryCnd, String inputContent, String projectId) {
        ProjectLogQueryCndDTO cnd = generatorUtil.convert(projectLogQueryCnd, ProjectLogQueryCndDTO.class);
        return generatorUtil.convert(projectLogService.getProjectLogQueryLogList(cnd, inputContent, projectId), ProjectLogQueryDetailVO.class);
    }

    @Override
    public List<StageDocumentHeaderVO> getStageDocumentHeader(String contractNo) {
        List<StageDocumentHeaderVO> header = new ArrayList<>();
        List<ProjectDutyMilepostDTO> milepostList = projectDutyService.getDutyMilepostsWithPlan(contractNo);
        milepostList = milepostList.stream().sorted(Comparator.comparing(ProjectDutyMilepostDTO::getId)).collect(Collectors.toList());
        List<Integer> rowSpan = projectWordService.getStageDocumentCount(contractNo);
        StageDocumentHeaderVO stageText = new StageDocumentHeaderVO("阶段","stageText",null,rowSpan,80,"left");
        header.add(stageText);
        StageDocumentHeaderVO documentName = new StageDocumentHeaderVO("文档名称","documentName",null,null,280,"left");
        header.add(documentName);
        for (int i = 0; i < milepostList.size(); i++) {
            StageDocumentHeaderVO milepost = new StageDocumentHeaderVO((i+1)+"."+milepostList.get(i).getName(),"milepost"+i,2,null,70,null);
            header.add(milepost);
            StageDocumentHeaderVO milepostWordsNumber = new StageDocumentHeaderVO("数目","wordsNumber"+i,0,null,70,null);
            header.add(milepostWordsNumber);
        }
        return header;
    }

    @Override
    public Boolean milepostPlanIsFinished(String contractId,Integer dutyId){
        Boolean finished = projectPlanService.milepostPlanIsFinished(contractId, dutyId);
        return finished;
    }

    @Override
    public List<Map<String,Object>> getStageDocument(String contractNo,String projectId) {
        List<Map<String,Object>> result = projectWordService.getDocumentDisplayList(contractNo,projectId);
        return result;
    }

    @Override
    public List<StageDocumentHeaderVO> getStageDocumentHeader(String contractNo, Integer dutyMilepostId) {
        List<StageDocumentHeaderVO> header = new ArrayList<>();
        List<ProjectDutyMilepostDTO> milepostList = projectDutyService.getProjectDutyMileposts(dutyMilepostId);
        List<Integer> rowSpan = projectWordService.getStageDocumentCount(contractNo);
        StageDocumentHeaderVO stageText = new StageDocumentHeaderVO("阶段","stageText",null,rowSpan,80,"left");
        header.add(stageText);
        StageDocumentHeaderVO documentName = new StageDocumentHeaderVO("文档名称","documentName",null,null,280,"left");
        header.add(documentName);
        for (int i = 0; i < milepostList.size(); i++) {
            StageDocumentHeaderVO milepost = new StageDocumentHeaderVO(milepostList.get(i).getName(),"milepost"+i,2,null,70,null);
            header.add(milepost);
            StageDocumentHeaderVO milepostWordsNumber = new StageDocumentHeaderVO("数目","wordsNumber"+i,0,null,70,null);
            header.add(milepostWordsNumber);
        }
        return header;
    }

    @Override
    public List<Map<String, Object>> getStageDocument(String contractNo,String projectId, Integer dutyMilepostId) {
        List<Map<String,Object>> result = projectWordService.getDocumentDisplayListWithPlan(contractNo,projectId,dutyMilepostId);
        return result;
    }
}
