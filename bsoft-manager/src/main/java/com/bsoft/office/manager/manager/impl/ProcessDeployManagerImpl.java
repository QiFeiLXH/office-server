package com.bsoft.office.manager.manager.impl;

import com.bsoft.common.dto.PublicDicDTO;
import com.bsoft.common.result.Result;
import com.bsoft.common.service.PublicDicService;
import com.bsoft.office.common.dozer.GeneratorUtil;
import com.bsoft.office.common.vo.PublicDicVO;
import com.bsoft.office.manager.condition.ProcessDeployQueryCnd;
import com.bsoft.office.manager.manager.ProcessDeployManager;
import com.bsoft.office.manager.vo.ProcessDeployVO;
import com.bsoft.office.manager.vo.ProcessFileVO;
import com.bsoft.workflow.dto.ProcessDeployDTO;
import com.bsoft.workflow.dto.ProcessDeployQueryCndDTO;
import com.bsoft.workflow.dto.ProcessFileDTO;
import com.bsoft.workflow.service.ProcessDeployService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.autoconfigure.integration.IntegrationAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Component
public class ProcessDeployManagerImpl implements ProcessDeployManager {

    private static final Integer PUBLIC_DIC_TYPE_PROCESS = 2005;
    @Reference
    private ProcessDeployService processDeployService;
    @Reference
    private PublicDicService publicDicService;

    @Override
    public Result<ProcessDeployVO> getProcessDeployList(ProcessDeployQueryCnd cnd, String personId) {
        ProcessDeployQueryCndDTO queryCndDTO = GeneratorUtil.instance().convert(cnd,ProcessDeployQueryCndDTO.class);
        Result<ProcessDeployDTO> result = processDeployService.getProcessDeployList(queryCndDTO,personId);
        return GeneratorUtil.instance().convert(result,ProcessDeployVO.class);
    }

    @Override
    public List<PublicDicVO> getProcessDeployType() {
        List<PublicDicDTO> publicDicDTOList = publicDicService.getPublicDic(PUBLIC_DIC_TYPE_PROCESS);
        return GeneratorUtil.instance().convert(publicDicDTOList, PublicDicVO.class);
    }

    @Override
    public void saveProcessDeploy(ProcessDeployVO processDeployVO, String personId) {
        ProcessDeployDTO processDeployDTO = GeneratorUtil.instance().convert(processDeployVO,ProcessDeployDTO.class);
        processDeployService.saveProcess(processDeployDTO,personId);
    }

    @Override
    public Integer uploadProcessFile(MultipartFile file, Integer agreementId, Integer menuId, String personId) throws IOException {
        ProcessFileVO fileVO = new ProcessFileVO();
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
        // 控制上传文件的类型
//        List<PublicDicDTO> fileUploadTypes = coopertaionAgreementService.getFileUploadType();
//        String format = fileName.substring(fileName.lastIndexOf(".") + 1);
//        boolean check = false;
//        for (PublicDicDTO uploadType : fileUploadTypes) {
//            if(format.equals(uploadType.getName())){
//                check = true;
//                break;
//            }
//        }
//        if (check) {
            fileVO.setMenuId(menuId);
            fileVO.setFileName(fileName);
            fileVO.setFileBytes(file.getBytes());
//        }
        ProcessFileDTO fileDTO = GeneratorUtil.instance().convert(fileVO,ProcessFileDTO.class);
        Integer fileId = processDeployService.saveProcessFile(fileDTO,personId);
        return fileId;
    }

    @Override
    public void deployProcess(Integer id, String personId) {
        processDeployService.deployProcess(id,personId);
    }
}
