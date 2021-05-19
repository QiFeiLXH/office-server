package com.bsoft.office.system.manager;

import com.bsoft.office.system.vo.RolePersonVO;
import com.bsoft.office.system.vo.RolePersonViewVO;
import com.bsoft.office.system.vo.RoleVO;

import java.util.List;
import java.util.Map;

public interface RoleManager {
    /**
     * 获取系统角色列表
     * @return
     */
    List<RoleVO> getRoleList();

    List<RoleVO> saveRole(RoleVO roleVO);

    List<RolePersonVO> getRolePersonList(String value);

    List<RolePersonViewVO> getPersonListByRoleId(Integer roleId);

    boolean saveRolePerson(Integer roleId,List<String> orininal,List<String> newlist);

    List<RolePersonVO> getOrgPersonList(String bmdm);

    Map RoleMenuAuthInfo(Integer roleId,Integer system);

    boolean saveRoleMenuAuthInfo(Integer roleId,List<Integer> menuIds,List<Map> authInfo,Integer system);

    boolean deleteRole(Integer roleId);

}
