package com.bsoft.office.project.manager;

import com.bsoft.common.dto.FileServerDefinitionDTO;
import com.bsoft.common.result.Result;
import com.bsoft.office.project.condition.ProjectWordCountViewQueryCnd;
import com.bsoft.office.project.vo.*;
import com.bsoft.project.dto.ProjectWordDetailDTO;
import com.bsoft.project.dto.ProjectWordViewDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author Xuhui Lin
 * @Date 2020/5/19 13:23
 * @Description 此接口参数中contractNo为合同编号数据库对应htbh，contractNumber为合同号数据库对应contractNo
 */
public interface ProjectWordManager {
    List<StageDocumentHeaderVO> getStageDocumentHeader(String contractNo, Integer dutyId);

    List<Map<String,Object>> getStageDocument(String contractNo, Integer dutyId);

    List<Map<String, Object>> getDocumentDisplayListWithPlan(String contractNo,String projectId, Integer milepostId);

    List<PublicDicVO> getFileTypes();

    List<ContractWordViewVO> getContractWordViewDisplayList(String contractNumber, String inputContent, Integer isRequired);
    List<ContractWordViewVO> getContractWordViewList(String contractNumber, String inputContent, Integer isRequired);
    List<ContractWordDetailViewVO> getContractWordDetailViewList(String contractNumber, Integer standardWordId);
    ProjectWordDetailDTO getProjectWordDBDetail(String contractNumber, Integer dbDetailId, String personId);
    ProjectWordViewVO getProjectWordView(String contractId, String projectId, Integer standardWordId);
    void projectWordUpload(String userId, MultipartFile file, Integer id, Integer fileKey, String contractNumber, Integer detailId, Integer milepostId, Date finalCheckDate, Date onlineDate) throws IOException;
    void projectWordRemove(String contractNumber, Integer wordId, Integer wordDBid);
    Date getContractFinalCheckDate(String contractNumber);
    Date getContractOnlineDate(String contractNumber);
    FileServerDefinitionDTO getExampleFile(Integer exampleFileId);

    Result<ProjectWordCountViewVO> getProjectWordCountViewList(ProjectWordCountViewQueryCnd cnd);

}
