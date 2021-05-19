package com.bsoft.office.project.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.project.condition.ProjectLogQueryCnd;
import com.bsoft.office.project.condition.ProjectWordQueryCnd;
import com.bsoft.office.project.vo.*;
import com.bsoft.project.dto.ProjectWordDetailDTO;
import com.bsoft.project.dto.ReferenceDocumentDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface ProjectLogManager {

    Map<String,Object> init(String userId);

    List<ProjectLogVO> getOwnProjectLogs(String projectId, String userId, Integer milepostId, java.sql.Date attendanceDate);

    Result<CustomerProjectVO> searchProjects(String userId, String context, Integer pageNo, Integer pageSize);

    void deleteProjectLog(Integer id);

    Map<String,Object> getPlanTree(String projectId,String userId,String attendanceDate,Integer part);

    List<ProjectLogVO> saveWorkLogs(String userId, ProjectLogBaseVO projectLogBaseVO) throws ParseException;

    Result<ProjectPlanQueryLogVO> getProjectWorklogList(Integer pageSize, Integer pageNo, Integer milepostId, String contractNo);

    ProjectLogInfoQueryVO getWorklogInfo(Integer id);

    Result<ProjectWordViewVO> getProjectWordList(ProjectWordQueryCnd projectWordQueryCnd);

    Result<ProjectWordRecordViewVO> getProjectWordDetails(Integer page , Integer size , Integer id , Integer milepostId);

    void fileUpload(String userId, MultipartFile file, Integer id, Integer fileKey, String contractId,Integer detailId,Integer milepostId) throws IOException;

    ProjectWordDetailDTO findDetailById(String htbh, Integer detailId);

    void deleteFile(Integer id, Integer detailId, String htbh);

    ReferenceDocumentDTO findReferenceFileById(Integer fileId);

    Result<HouseVO> searchHouses(String context,String area,String userId, Integer pageNo, Integer pageSize);

    AttendanceVO ownAttendance(String userId, String attendanceDate);

    List<PublicDicVO> getFileUploadTypes();

    Result<ProjectLogQueryProjectVO> getProjectsWithLogsnum(ProjectLogQueryCnd projectLogQueryCnd);

    Result<ProjectLogQueryDetailVO> getProjectLogSummary(ProjectLogQueryCnd projectLogQueryCnd, String inputContent, String projectId);

    List<StageDocumentHeaderVO> getStageDocumentHeader(String contractNo);

    List<Map<String,Object>> getStageDocument(String contractNo,String projectId);

    List<StageDocumentHeaderVO> getStageDocumentHeader(String contractNo,Integer dutyMilepostId);

    List<Map<String,Object>> getStageDocument(String contractNo,String projectId,Integer dutyMilepostId);

    Boolean milepostPlanIsFinished(String contractId,Integer dutyId);
}
