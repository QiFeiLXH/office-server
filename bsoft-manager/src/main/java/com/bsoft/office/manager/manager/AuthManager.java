package com.bsoft.office.manager.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.manager.condition.AuthorityQueryCnd;
import com.bsoft.office.manager.vo.*;

import java.util.List;
import java.util.Map;

/**
 * @Author: xucl
 * @DateTime: 2020/10/20 16:47
 * @Description:
 */
public interface AuthManager {

    /**
     * 获取角色列表
     * @return
     */
    List<RoleShowVO> getRoles();
    /**
     * 获取角色人员信息
     * @param roleId
     * @return
     */
    List<RolePersonViewVO> findRolePersonsByRole(Integer roleId);

    /**
     * 保存角色信息
     * @param roleVOS
     * @return
     */
    List<RoleVO> saveRoles(List<RoleVO> roleVOS);

    /**
     * 删除角色
     * @param roleId
     */
    void deleteRole(Integer roleId);

    /**
     * 保存人员角色信息
     * @param rolePersonVO
     */
    void saveRolePerson(RolePersonVO rolePersonVO);

    /**
     * 删除人员角色信息
     * @param personId
     */
    void deleteRolePerson(String personId);

//    /**
//     * 获取人员有的角色
//     * @param personId
//     * @return
//     */
//    List<Map> getRolePerson(String personId);

    /**
     *
     * @param roleId
     * @param personId
     * @param system
     * @return
     */
    Map<String,Object> getMenuAuth(Integer roleId,String personId,Integer system);

    /**
     * 保存权限信息
     * @param roleId 角色ID
     * @param personId 人员ID，若为0表示保存的是角色权限信息，不为0表示保存的是人员权限信息
     * @param system 系统ID
     * @param menuIds 选中的所以菜单ID
     * @param menuAuths 选中的菜单权限Map<menuId,authId>
     * @param menuRanges 选中的菜单数据范围Map<menuId,range>
     * @param personDeptAuths 选中的自定义数据范围
     */
    void saveAuth(Integer roleId,
                  String personId,
                  Integer system,
                  List<Integer> menuIds,
                  List<Map> menuAuths,
                  List<Map> menuRanges,
                  List<Map> personDeptAuths
    );

    /**
     * 获取具有指定权限的人员
     * @return
     */
    Result<AuthorityPersonVO> getPermissionalPersonList(List<AuthorityQueryCnd> menuAuths, Integer pageNo, Integer pageSize);

    List<RolePersonViewVO> getRolePersonByPersonId(String personId);
}
