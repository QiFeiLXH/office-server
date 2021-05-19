package com.bsoft.office.common.manager.impl;

import com.bsoft.common.dto.FileServerDefinitionDTO;
import com.bsoft.common.service.HelpWordService;
import com.bsoft.menu.dto.MenuDTO;
import com.bsoft.menu.service.MenuService;
import com.bsoft.office.common.manager.HelpWordManager;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

/**
 * @Author: xucl
 * @DateTime: 2020/12/7 15:25
 * @Description:
 */
@Component
public class HelpWordManagerImpl implements HelpWordManager {
    @Reference(timeout = 6000)
    private HelpWordService helpWordService;
    @Reference(timeout = 6000)
    private MenuService menuService;

    @Override
    public FileServerDefinitionDTO getHelpWord(Integer menuId, String personId) {
        MenuDTO menu = menuService.getMenu(personId, menuId);
        if (menu != null && menu.getHelp() != null) {
           return helpWordService.getHelpWord(menu.getHelp(), personId);
        }
        return null;
    }
}
