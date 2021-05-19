package com.bsoft.office.manager.manager.impl;

import com.bsoft.common.dto.FileServerDefinitionDTO;
import com.bsoft.common.service.FileServerService;
import com.bsoft.exception.ServiceException;
import com.bsoft.menu.dto.MenuAndAuthDTO;
import com.bsoft.menu.service.MenuService;
import com.bsoft.office.common.dozer.GeneratorUtil;
import com.bsoft.office.common.manager.PublicDicManager;
import com.bsoft.office.common.vo.PublicDicVO;
import com.bsoft.office.manager.manager.MenuAuthManager;
import com.bsoft.office.manager.vo.MenuAndAuthVO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/10/19 9:57
 * @Description:
 */
@Service
public class MenuAuthManagerImpl implements MenuAuthManager {
    @Reference
    private MenuService menuService;
    @Reference(timeout = 60000)
    private FileServerService fileServerService;
    @Autowired
    private GeneratorUtil generatorUtil;
    @Autowired
    private PublicDicManager publicDicManager;

    @Override
    public List<MenuAndAuthVO> getMenuInfo(Integer system) {
        List<MenuAndAuthDTO> menuAndAuthDTOS = menuService.getMenuInfoBySystem(system);
        return generatorUtil.convert(menuAndAuthDTOS,MenuAndAuthVO.class);
    }

    @Override
    public MenuAndAuthVO getMenuDetailInfo(Integer menuId) {
        MenuAndAuthDTO menuAndAuthDTO = menuService.getMenuInfoByMenuId(menuId);
        return generatorUtil.convert(menuAndAuthDTO,MenuAndAuthVO.class);
    }

    @Override
    public Integer saveMenuInfo(MenuAndAuthVO menuAndAuthVO) {
        MenuAndAuthDTO menuAndAuthDTO = generatorUtil.convert(menuAndAuthVO,MenuAndAuthDTO.class);
        Integer menuId = menuService.saveMenuInfo(menuAndAuthDTO);
        return menuId;
    }

    @Override
    public Integer uploadFile(MultipartFile file, Integer menuId,Integer fileId) {
        Integer key = null;
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
        List<PublicDicVO> fileUploadTypes = publicDicManager.getPublicDics(2002);
        String format = fileName.substring(fileName.lastIndexOf(".") + 1);
        boolean check = false;
        for (PublicDicVO uploadType : fileUploadTypes) {
            if(format.equals(uploadType.getName())){
                check = true;
                break;
            }
        }
        if (check) {
            try {
                if(fileId>0){
                    fileServerService.update(fileId,fileName,file.getBytes());
                    key = fileId;
                }else{
                    key = fileServerService.saveWithMenu(menuId,fileName,file.getBytes());
                }
            } catch (IOException e) {
                throw new ServiceException("文件上传失败!");
            }
        } else {
            throw new ServiceException("上传格式不正确");
        }
        return key;
    }

    @Override
    public void deleteHelpWord(Integer fileId) {
        if (fileId != null && fileId > 0){
            fileServerService.remove(fileId);
        }
    }

    @Override
    public FileServerDefinitionDTO getHelpWord(Integer id) {
        FileServerDefinitionDTO fileServerDefinitionDTO = fileServerService.get(id);
        return fileServerDefinitionDTO;
    }

    public void deleteMenu(Integer menuId,Integer system){
        menuService.deleteMenu(menuId,system);
    }
}
