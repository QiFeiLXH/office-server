package com.bsoft.office.common.manager.impl;

import com.bsoft.auth.service.AuthService;
import com.bsoft.office.common.manager.AuthorityPublicManager;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

/**
 * @Author Xuhui Lin
 * @Date 2020/10/22 14:51
 * @Description
 */
@Component
public class AuthorityPublicManagerImpl implements AuthorityPublicManager {
    @Reference
    private AuthService authService;

    @Override
    public boolean checkAllPermission(String personId, Integer menuId, Integer orderNum) {
        return authService.checkAllPermission(personId, menuId, orderNum);
    }
}
