package com.bsoft.office.manager.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.manager.condition.GroupRoleQueryCnd;
import com.bsoft.office.manager.manager.GroupRoleManager;
import com.bsoft.office.manager.vo.GroupRoleVO;
import com.bsoft.workflow.dto.GroupRoleDTO;
import com.bsoft.workflow.dto.GroupRoleQueryCndDTO;
import com.bsoft.workflow.service.GroupRoleService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: zy
 * @date: 2020/12/4
 * @description 流程组角色
 */
@Component
public class GroupRoleManagerImpl implements GroupRoleManager {

    @Autowired
    private IGenerator iGenerator;
    @Reference
    private GroupRoleService groupRoleService;

    @Override
    public Result<GroupRoleVO> getGroupRoleList(String userId, GroupRoleQueryCnd queryCnd) {
        GroupRoleQueryCndDTO queryCndDTO = iGenerator.convert(queryCnd, GroupRoleQueryCndDTO.class);
        Result<GroupRoleDTO> resultDTO = groupRoleService.getGroupRoleList(userId, queryCndDTO);
        return iGenerator.convert(resultDTO, GroupRoleVO.class);
    }

    @Override
    public void saveGroupRole(String userId, GroupRoleVO saveVO) {
        GroupRoleDTO saveDTO = iGenerator.convert(saveVO, GroupRoleDTO.class);
        // id为负数的情况视为新增
        if (saveDTO.getId() != null && saveDTO.getId() <= 0) {
            saveDTO.setId(null);
        }
        groupRoleService.saveGroupRole(userId, saveDTO);
    }

    @Override
    public void deleteGroupRole(String userId, Integer id) {
        groupRoleService.deleteGroupRole(userId, id);
    }
}
