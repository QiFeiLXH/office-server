package com.bsoft.office.manager.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.manager.vo.RoleMaintainBaseVO;
import com.bsoft.office.manager.vo.RoleNameVO;

import java.util.List;
import java.util.Map;

/**
 * @Auther: hy
 * @Date: 2020/8/3
 * @Description:
 */
public interface RoleMaintainManager {

    List<RoleNameVO> getRoles(Integer status, String content);

    RoleNameVO saveRole(RoleNameVO roleNameVO);

    List<RoleMaintainBaseVO> getDeptRoles(String dept);

    void saveDeptRoles(List<RoleMaintainBaseVO> deptRoles);

    List<Map<String, Object>> getDeptRoleDetails();

    Map<String,Object> exportDeptRoleDetails();

    List<RoleNameVO> saveRoles(List<RoleNameVO> roles);
}
