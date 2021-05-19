package com.bsoft.office.manager.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.manager.condition.GroupRoleQueryCnd;
import com.bsoft.office.manager.vo.GroupRoleVO;

/**
 * @author: zy
 * @date: 2020/12/4
 * @description 流程组角色
 */
public interface GroupRoleManager {
    /**
     * 获取流程组角色列表
     * @param queryCnd 查询参数
     * @return
     */
    Result<GroupRoleVO> getGroupRoleList(String userId, GroupRoleQueryCnd queryCnd);

    /**
     * 保存流程组角色信息
     * @param saveVO 组角色信息
     */
    void saveGroupRole(String userId, GroupRoleVO saveVO);

    /**
     * 删除流程组角色信息
     * @param id 组角色ID
     */
    void deleteGroupRole(String userId, Integer id);

}
