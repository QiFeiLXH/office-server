package com.bsoft.office.common.manager.impl;

import com.bsoft.auth.service.AuthService;
import com.bsoft.menu.dto.MenuAndAuthDTO;
import com.bsoft.menu.service.MenuService;
import com.bsoft.office.common.dozer.GeneratorUtil;
import com.bsoft.office.common.manager.MenuPublicManager;
import com.bsoft.office.common.vo.MenuVO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author Xuhui Lin
 * @Date 2020/10/22 16:49
 * @Description
 */
@Component
public class MenuPublicManagerImpl implements MenuPublicManager {
    @Reference
    private MenuService menuService;
    @Reference
    private AuthService authService;

    @Autowired
    GeneratorUtil generatorUtil;

    @Override
    public MenuVO getMenuInfo(Integer menuId) {
        MenuAndAuthDTO menuDTO = menuService.getMenuInfoByMenuId(menuId);
        return generatorUtil.convert(menuDTO, MenuVO.class);
    }

    @Override
    public boolean checkPrivateMenuPermission(String personId, Integer menuId) {
        return authService.checkPrivateMenuPermission(personId, menuId);
    }
}
