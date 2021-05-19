package com.bsoft.office.common.manager;

import com.bsoft.common.dto.FileServerDefinitionDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Author Xuhui Lin
 * @Date 2020/12/17 15:44
 * @Description
 */
public interface FilePublicManager {

    void rewriteFile(MultipartFile file, Integer fileId) throws IOException;

    /**
     * 下载
     * @param fileId 文件id
     * @return
     */
    FileServerDefinitionDTO downloadFile(Integer fileId);

    byte[] showImageByte(Integer fileId);

    Integer uploadFile(MultipartFile file, Integer menuId) throws IOException;
}
