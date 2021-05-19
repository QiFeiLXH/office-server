package com.bsoft.office.common.manager.impl;

import com.bsoft.common.dto.FileServerDefinitionDTO;
import com.bsoft.common.dto.PublicDicDTO;
import com.bsoft.common.service.FileServerService;
import com.bsoft.common.service.PublicDicService;
import com.bsoft.exception.ServiceException;
import com.bsoft.office.common.manager.FilePublicManager;
import com.bsoft.office.common.utils.FileUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Xuhui Lin
 * @Date 2020/12/17 15:44
 * @Description
 */
@Service
public class FilePublicManagerImpl implements FilePublicManager {
    @Reference(timeout = 60000)
    private FileServerService fileServerService;
    @Reference
    private PublicDicService publicDicService;

    @Override
    public void rewriteFile(MultipartFile file, Integer fileId) throws IOException {
        String fileName = this.getFileName(file);
        boolean checkResult = this.checkUploadFileTypeBySuffix(fileName);
        if (checkResult) {
            fileServerService.update(fileId, fileName, file.getBytes());
        } else {
            throw new ServiceException("上传格式不正确");
        }
    }

    @Override
    public FileServerDefinitionDTO downloadFile(Integer fileId) {
        FileServerDefinitionDTO file = fileServerService.get(fileId);
        return file;
    }

    @Override
    public byte[] showImageByte(Integer fileId) {
        FileServerDefinitionDTO file = fileServerService.get(fileId);
        return file.getData();
    }

    @Override
    public Integer uploadFile(MultipartFile file, Integer menuId) throws IOException {
        String fileName = this.getFileName(file);
        boolean checkResult = this.checkUploadFileTypeBySuffix(fileName);
        if (checkResult) {
            return fileServerService.saveWithMenu(menuId, fileName, file.getBytes());
        } else {
            throw new ServiceException("上传格式不正确");
        }

    }

    private String getFileName(MultipartFile file) {
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
        return fileName;
    }

    // 校验上传的文件类型是否符合可上传的文件
    private boolean checkUploadFileTypeBySuffix(String fileName) {
        // 控制上传文件的类型
        List<PublicDicDTO> fileUploadTypes = publicDicService.getPublicDic(2002);
        List<String> fileTypes = fileUploadTypes.stream().map(PublicDicDTO::getName).collect(Collectors.toList());
        String suffix = FileUtils.getFileSuffix(fileName);
        boolean result = fileTypes.contains(suffix);
        return result;
    }
}
