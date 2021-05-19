package com.bsoft.office.common.manager.impl;

import com.bsoft.auth.service.AuthService;
import com.bsoft.office.common.manager.DeptPermissionManager;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/10/19 17:05
 * @Description
 */
@Component
public class DeptPermissionManagerImpl implements DeptPermissionManager {
    @Reference
    private AuthService authService;

    @Override
    public List<String> getPersonalAuthorityDepts(String personId, Integer flag) {
        return authService.getPersonalAuthorityDepts(personId, flag);
    }

    @Override
    public void saveAuthorityDept(String personId,Integer flag, List<String> needSaves, List<String> needDeletes) {
        authService.saveAuthorityDept(personId, flag, needSaves, needDeletes);
    }
}
