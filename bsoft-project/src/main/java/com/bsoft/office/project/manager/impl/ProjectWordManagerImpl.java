package com.bsoft.office.project.manager.impl;

import com.bosft.progress.dto.ProjectWordCountViewDTO;
import com.bosft.progress.dto.ProjectWordCountViewQueryCndDTO;
import com.bsoft.common.dto.FileServerDefinitionDTO;
import com.bsoft.common.dto.PublicDicDTO;
import com.bsoft.common.result.Result;
import com.bsoft.common.service.FileServerService;
import com.bsoft.contract.dto.ContractDTO;
import com.bsoft.contract.dto.ContractExDTO;
import com.bsoft.contract.service.ContractService;
import com.bsoft.exception.ServiceException;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.project.condition.ProjectWordCountViewQueryCnd;
import com.bsoft.office.project.manager.ProjectWordManager;
import com.bsoft.office.project.vo.*;
import com.bsoft.project.dto.*;
import com.bsoft.project.service.ProjectDutyService;
import com.bsoft.project.service.ProjectService;
import com.bsoft.project.service.ProjectWordService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author Xuhui Lin
 * @Date 2020/5/19 13:23
 * @Description
 */
@Service
public class ProjectWordManagerImpl implements ProjectWordManager {
    @Reference
    private ProjectDutyService projectDutyService;
    @Reference(protocol = "hessian",check=false,timeout = 10000)
    private ProjectWordService projectWordService;
    @Reference(timeout = 60000,check = false)
    private com.bsoft.progress.service.ProjectWordService progressProjectWordService;
    @Reference
    private ContractService contractService;
    @Reference
    private ProjectService projectService;
    @Reference
    private FileServerService fileServerService;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public List<StageDocumentHeaderVO> getStageDocumentHeader(String contractNo, Integer dutyId) {
        List<StageDocumentHeaderVO> header = new ArrayList<>();
        List<ProjectDutyMilepostVO> milepostList = iGenerator.convert(projectDutyService.getProjectDutyMileposts(contractNo, dutyId), ProjectDutyMilepostVO.class);
        List<Integer> rowSpan = projectWordService.getMilepostStageDocumentCount();
        StageDocumentHeaderVO stageText = new StageDocumentHeaderVO("阶段","stageText",null,rowSpan,80,"left");
        header.add(stageText);
        StageDocumentHeaderVO documentName = new StageDocumentHeaderVO("文档名称","documentName",null,null,280,"left");
        header.add(documentName);
        String headerName = "";
        for (int i = 0; i < milepostList.size(); i++) {
            headerName = new StringBuilder().append(i + 1).append(".").append(milepostList.get(i).getName()).toString();
            StageDocumentHeaderVO milepost = new StageDocumentHeaderVO(headerName,"milepost_"+milepostList.get(i).getId(),null,null,140,null);
            header.add(milepost);
        }
        return header;
    }

    @Override
    public List<Map<String,Object>> getStageDocument(String contractNo, Integer dutyId) {
        List<Map<String,Object>> result = projectWordService.getMilepostDocumentDisplayList(contractNo, dutyId);
        return result;
    }

    @Override
    public List<Map<String, Object>> getDocumentDisplayListWithPlan(String contractNo,String projectId, Integer milepostId) {
        List<Map<String,Object>> result = projectWordService.getDocumentDisplayListWithPlan(contractNo,projectId, milepostId);
        return result;
    }

    @Override
    public List<PublicDicVO> getFileTypes() {
        List<PublicDicDTO> fileTypes = projectWordService.getProjectLogFileUploadType();
        List<PublicDicVO> fileTypeVOS = iGenerator.convert(fileTypes, PublicDicVO.class);
        return fileTypeVOS;
    }

    @Override
    public List<ContractWordViewVO> getContractWordViewDisplayList(String contractNumber, String inputContent, Integer isRequired) {
        ContractDTO contract = contractService.getContractByContractNo(contractNumber);
        List<ContractWordViewDTO> list = projectWordService.getContractWordViewDisplayList(contract.getId(), inputContent, isRequired);
        return iGenerator.convert(list, ContractWordViewVO.class);
    }

    @Override
    public List<ContractWordViewVO> getContractWordViewList(String contractNumber, String inputContent, Integer isRequired) {
        ContractDTO contract = contractService.getContractByContractNo(contractNumber);
        List<ContractWordViewDTO> list = projectWordService.getContractWordViewList(contract.getId(), inputContent, isRequired);
        return iGenerator.convert(list, ContractWordViewVO.class);
    }

    @Override
    public List<ContractWordDetailViewVO> getContractWordDetailViewList(String contractNumber, Integer standardWordId) {
        ContractDTO contract = contractService.getContractByContractNo(contractNumber);
        List<ContractWordDetailViewDTO> list = projectWordService.getContractWordDetailViewList(contract.getId(), standardWordId);
        return iGenerator.convert(list, ContractWordDetailViewVO.class);
    }

    @Override
    public ProjectWordDetailDTO getProjectWordDBDetail(String contractNumber, Integer dbDetailId, String personId) {
        ContractDTO contract = contractService.getContractByContractNo(contractNumber);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        String fileYear = contract.getFileYear() != null ? contract.getFileYear().toString() : sdf.format(contract.getSignDate());
        ProjectWordDetailDTO projectWordDetailDTO = projectWordService.getProjectWordDBDetailDO(fileYear, dbDetailId, personId);
        return projectWordDetailDTO;
    }

    @Override
    public ProjectWordViewVO getProjectWordView(String contractNumber, String projectId, Integer standardWordId) {
        ContractDTO contract = contractService.getContractByContractNo(contractNumber);
        ProjectWordViewDTO projectWordView = projectWordService.getProjectWordView(contract.getId(), projectId, standardWordId);
        return iGenerator.convert(projectWordView, ProjectWordViewVO.class);
    }

    @Override
    public void projectWordUpload(String userId,
                                  MultipartFile file,
                                  Integer id,
                                  Integer fileKey,
                                  String contractNumber,
                                  Integer detailId,
                                  Integer milepostId,
                                  Date finalCheckDate,
                                  Date onlineDate) throws IOException {
        ContractDTO contract = contractService.getContractByContractNo(contractNumber);
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
            if (format.equals(uploadType.getName())) {
                check = true;
                break;
            }
        }
        if (check) {
            uploadDTO.setMilepostId(milepostId);
            uploadDTO.setOriginalFilename(fileName);
            uploadDTO.setUserId(userId);
            uploadDTO.setFileBytes(file.getBytes());
            uploadDTO.setContractId(contract.getId());
            uploadDTO.setFileKey(fileKey);
            uploadDTO.setDetailId(detailId);
            uploadDTO.setId(id);
            uploadDTO.setNewFileName(System.currentTimeMillis()+ Objects.requireNonNull(file.getOriginalFilename()).substring(file.getOriginalFilename().lastIndexOf("."),file.getOriginalFilename().length()));
            String fileYear = contract.getFileYear() != null ? contract.getFileYear().toString():sdf.format(contract.getSignDate());
            if (finalCheckDate != null) { //上传文件时带有终验日期则更新终验日期
                // 更新合同拓展表的终验日期
                contractService.updateContractExCheckDate(contractNumber, finalCheckDate);
                // 更新项目表的终验日期
                projectService.updateProjectFinalCheckDate(contract.getId(), finalCheckDate);
                // 更新项目拓展表的终验日期
                progressProjectWordService.updateFinalCheckDate(contractNumber, finalCheckDate);
            }
            if (onlineDate != null) { //上传文件时带有上线函日期则更新上线函日期
                // 更新项目拓展表的上线函日期
                progressProjectWordService.updateOnlineDate(contractNumber, onlineDate);
            }
            projectWordService.projectWordUpload(uploadDTO, fileYear);
        } else {
            throw new ServiceException("上传格式不正确");
        }
    }

    @Override
    public void projectWordRemove(String contractNumber, Integer wordId, Integer wordDBid) {
        ContractDTO contract = contractService.getContractByContractNo(contractNumber);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        String fileYear = contract.getFileYear() != null ? contract.getFileYear().toString():sdf.format(contract.getSignDate());
        projectWordService.deleteFile(wordId, wordDBid, fileYear);
    }

    @Override
    public Date getContractFinalCheckDate(String contractNumber) {
        ContractExDTO contractEx = contractService.getContractEx(contractNumber);
        return contractEx.getCheckDate();
    }

    @Override
    public Date getContractOnlineDate(String contractNumber) {
        return progressProjectWordService.getOnlineDate(contractNumber);
    }

    @Override
    public FileServerDefinitionDTO getExampleFile(Integer exampleFileId) {
        FileServerDefinitionDTO fileServerDefinitionDTO = fileServerService.get(exampleFileId);
        return fileServerDefinitionDTO;
    }

    @Override
    public Result<ProjectWordCountViewVO> getProjectWordCountViewList(ProjectWordCountViewQueryCnd cnd) {
        ProjectWordCountViewQueryCndDTO cndDTO = iGenerator.convert(cnd, ProjectWordCountViewQueryCndDTO.class);
        Result<ProjectWordCountViewDTO> result = progressProjectWordService.getProjectWordCountViewList(cndDTO);
        return iGenerator.convert(result, ProjectWordCountViewVO.class);
    }

}
