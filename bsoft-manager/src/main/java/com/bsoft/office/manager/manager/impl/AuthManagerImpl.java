package com.bsoft.office.manager.manager.impl;

import com.bsoft.auth.dto.*;
import com.bsoft.auth.service.AuthService;
import com.bsoft.auth.service.RoleService;
import com.bsoft.common.result.Result;
import com.bsoft.menu.service.MenuService;
import com.bsoft.office.common.dozer.GeneratorUtil;
import com.bsoft.office.common.manager.PublicDicManager;
import com.bsoft.office.common.sort.ListBeanSort;
import com.bsoft.office.common.vo.PublicDicVO;
import com.bsoft.office.manager.condition.AuthorityQueryCnd;
import com.bsoft.office.manager.manager.AuthManager;
import com.bsoft.office.manager.vo.*;
import org.apache.curator.shaded.com.google.common.collect.Collections2;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @Author: xucl
 * @DateTime: 2020/10/20 16:47
 * @Description:
 */
@Component
public class AuthManagerImpl implements AuthManager {
    @Autowired
    private GeneratorUtil generatorUtil;
    @Reference
    private RoleService roleService;
    @Reference
    private MenuService menuService;
    @Reference
    private AuthService authService;
    @Autowired
    private PublicDicManager publicDicManager;

    @Override
    public List<RoleShowVO> getRoles() {
        List<RoleDTO> roleDTOS = roleService.getRoleList();
        List<RoleVO> roleVOS = generatorUtil.convert(roleDTOS,RoleVO.class);
        List<PublicDicVO> publicDicVOS = publicDicManager.getPublicDics(3008);
        ListBeanSort.sort(publicDicVOS,"id",true);
        List<RoleShowVO> roleShowVOS = generatorUtil.convert(publicDicVOS,RoleShowVO.class);
        roleShowVOS.forEach(RoleShowVO->{
            Collection<RoleVO> result = Collections2.filter(roleVOS, x->x.getParentId().equals(RoleShowVO.getId()));
            if (result.size()>0){
                List<RoleVO> list = new ArrayList<>(result);
                ListBeanSort.sort(list,"sort",true);
                RoleShowVO.setChildren(list);
            }
        });
        return roleShowVOS;
    }

    @Override
    public List<RolePersonViewVO> findRolePersonsByRole(Integer roleId) {
        List<RolePersonViewDTO> list = roleService.getRolePerson(roleId);
        return generatorUtil.convert(list,RolePersonViewVO.class);
    }

    @Override
    public List<RoleVO> saveRoles(List<RoleVO> roleVOS) {
        List<RoleDTO> roleDTOS = generatorUtil.convert(roleVOS,RoleDTO.class);
        List<RoleDTO> list = roleService.saveRoles(roleDTOS);
        return generatorUtil.convert(list,RoleVO.class);
    }

    @Override
    public void deleteRole(Integer roleId) {
        roleService.deleteRole(roleId);
    }

    @Override
    public void saveRolePerson(RolePersonVO rolePersonVO) {
        RolePersonDTO rolePersonDTO = generatorUtil.convert(rolePersonVO,RolePersonDTO.class);
        roleService.saveRolePerson(rolePersonDTO);
    }

    @Override
    public void deleteRolePerson(String personId) {
        roleService.deleteRolePerson(personId);
    }

//    @Override
//    public List<Map> getRolePerson(String personId) {
//        List<Map> list = roleService.getRolesByPersonId(personId);
//        return list;
//    }

    @Override
    public Map<String, Object> getMenuAuth(Integer roleId, String personId, Integer system) {
        return menuService.getMenuWithAuth(roleId,system,personId);
    }

    @Override
    public void saveAuth(Integer roleId, String personId, Integer system, List<Integer> menuIds, List<Map> menuAuths, List<Map> menuRanges,List<Map> personDeptAuths) {
        menuService.saveAuth(roleId,personId,system,menuIds,menuAuths,menuRanges,personDeptAuths);
    }

    @Override
    public Result<AuthorityPersonVO> getPermissionalPersonList(List<AuthorityQueryCnd> menuAuths, Integer pageNo, Integer pageSize) {
        List<AuthorityQueryCndDTO> menuAuthDTOS = generatorUtil.convert(menuAuths, AuthorityQueryCndDTO.class);
        Result<AuthorityPersonDTO> list = authService.getPermissionalPersonList(menuAuthDTOS, pageNo, pageSize);
        return generatorUtil.convert(list,AuthorityPersonVO.class);
    }

    @Override
    public List<RolePersonViewVO> getRolePersonByPersonId(String personId) {
        List<RolePersonViewDTO> list = roleService.getRolePersonByPersonId(personId);
        return generatorUtil.convert(list,RolePersonViewVO.class);
    }
}
