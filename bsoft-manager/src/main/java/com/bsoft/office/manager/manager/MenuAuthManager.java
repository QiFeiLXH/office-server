package com.bsoft.office.manager.manager;

import com.bsoft.common.dto.FileServerDefinitionDTO;
import com.bsoft.office.common.vo.PublicDicVO;
import com.bsoft.office.manager.vo.MenuAndAuthVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/10/19 9:57
 * @Description:
 */
public interface MenuAuthManager {

    List<MenuAndAuthVO> getMenuInfo(Integer system);

    MenuAndAuthVO getMenuDetailInfo(Integer menuId);

    Integer saveMenuInfo(MenuAndAuthVO menuAndAuthVO);

    Integer uploadFile(MultipartFile file, Integer menuId,Integer fileId);

    void deleteHelpWord(Integer fileId);

    FileServerDefinitionDTO getHelpWord(Integer id);

    void deleteMenu(Integer menuId,Integer system);
}
