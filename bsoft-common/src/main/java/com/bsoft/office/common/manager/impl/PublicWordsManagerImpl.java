package com.bsoft.office.common.manager.impl;

import com.bsoft.common.dto.PublicDicDTO;
import com.bsoft.common.dto.PublicWordsDTO;
import com.bsoft.common.dto.PublicWordsViewDTO;
import com.bsoft.common.result.Result;
import com.bsoft.common.service.PublicDicService;
import com.bsoft.common.service.PublicWordsService;
import com.bsoft.exception.ServiceException;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.common.manager.PublicWordsManager;
import com.bsoft.office.common.vo.PublicDicVO;
import com.bsoft.office.common.vo.PublicWordsVO;
import com.bsoft.office.common.vo.PublicWordsViewVO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/11/18 10:57
 * @Description 文档上传、下载、删除功能及列表查询
 */
@Component
public class PublicWordsManagerImpl implements PublicWordsManager {
    @Reference(timeout = 60000)
    private PublicWordsService publicWordsService;
    @Reference
    private PublicDicService publicDicService;

    @Autowired
    private IGenerator iGenerator;

    @Override
    public List<PublicDicVO> getFileTypesDic() {
        List<PublicDicDTO> fileTypes = publicDicService.getPublicDic(2002);
        return iGenerator.convert(fileTypes, PublicDicVO.class);
    }

    @Override
    public Result<PublicWordsViewVO> getPublicWordsList(Integer pageNo, Integer pageSize, Integer mainId, Integer type, Integer wordType) {
        Result<PublicWordsViewDTO> result = publicWordsService.getPublicWordsListWithWordType(pageNo, pageSize, mainId, type, wordType);
        return iGenerator.convert(result, PublicWordsViewVO.class);
    }

    @Override
    public void uploadFile(MultipartFile file, Integer contractId, Integer menuId, String personId, Integer wordType) throws IOException {
        PublicWordsVO publicWordsVO = new PublicWordsVO();
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
        // 控制上传文件的类型
        List<PublicDicDTO> fileUploadTypes = publicDicService.getPublicDic(2002);
        String format = fileName.substring(fileName.lastIndexOf(".") + 1);
        boolean check = false;
        for (PublicDicDTO uploadType : fileUploadTypes) {
            if(format.equals(uploadType.getName())){
                check = true;
                break;
            }
        }
        if (check) {
            BigDecimal fileSize = new BigDecimal(file.getSize()).divide(new BigDecimal(1024 * 1024), 2, RoundingMode.HALF_UP); // 单位兆
            publicWordsVO.setFileName(fileName);
            publicWordsVO.setFileSize(fileSize.doubleValue());
            publicWordsVO.setMenuId(menuId);
            publicWordsVO.setMainId(contractId);
            publicWordsVO.setUploader(personId);
            publicWordsVO.setType(1);
            publicWordsVO.setFileBytes(file.getBytes());
            publicWordsVO.setWordType(wordType);
            PublicWordsDTO word= iGenerator.convert(publicWordsVO, PublicWordsDTO.class);
            publicWordsService.savePublicWords(word);
        } else {
            throw new ServiceException("上传格式不正确");
        }
    }

    @Override
    public PublicWordsVO downloadFile(Integer fileId, Integer wordId, String personId) {
        PublicWordsDTO word = publicWordsService.getWaterMarkPublicWords(fileId, wordId,personId);
        return iGenerator.convert(word, PublicWordsVO.class);
    }

    @Override
    public void deleteFile(Integer fileId, Integer wordId) {
        publicWordsService.deleteFile(fileId, wordId);
    }
}
