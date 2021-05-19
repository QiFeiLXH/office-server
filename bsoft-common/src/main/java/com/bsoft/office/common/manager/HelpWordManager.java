package com.bsoft.office.common.manager;

import com.bsoft.common.dto.FileServerDefinitionDTO;

/**
 * @Author: xucl
 * @DateTime: 2020/12/7 15:04
 * @Description:
 */
public interface HelpWordManager {
    FileServerDefinitionDTO getHelpWord(Integer menuId,String personId);
}
