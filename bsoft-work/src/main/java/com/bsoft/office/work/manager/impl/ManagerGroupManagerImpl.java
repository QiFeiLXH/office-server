package com.bsoft.office.work.manager.impl;

import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.work.condition.PolicyQueryCnd;
import com.bsoft.office.work.manager.ManagerGroupManager;
import com.bsoft.office.work.vo.ManagerGroupVO;
import com.bsoft.work.dto.ManagerGroupDTO;
import com.bsoft.work.dto.PolicyQueryCndDTO;
import com.bsoft.work.service.ManageGroupService;
import org.apache.dubbo.config.annotation.Reference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Huang GH
 * @date 2021/5/10 13:15
 */
@Component
public class ManagerGroupManagerImpl implements ManagerGroupManager {
    @Reference
    private ManageGroupService manageGroupService;

    @Autowired
    private IGenerator iGenerator;

    @Override
    public List<ManagerGroupDTO> findByQueryCnd(PolicyQueryCnd queryCnd) {
        PolicyQueryCndDTO convert = iGenerator.convert(queryCnd, PolicyQueryCndDTO.class);
        return manageGroupService.findGroupByType(convert);
    }

    @Override
    public List<ManagerGroupVO> findList(String councilName, Integer isCancel) {
        List<ManagerGroupDTO> list = manageGroupService.findList(councilName, isCancel);
        return iGenerator.convert(list, ManagerGroupVO.class);
    }

    @Override
    public void cancelManagerGroup(Integer councilId, Integer isCancel) {
        manageGroupService.cancelManagerGroup(councilId, isCancel);
    }

    @Override
    public void saveManagerGroups(List<ManagerGroupVO> managerGroupList) {
        if (!managerGroupList.isEmpty()) {
            List<ManagerGroupVO> addOrEditManagerGroupVO = new ArrayList<>();
            for (ManagerGroupVO managerGroupVO : managerGroupList) {
                if (managerGroupVO.getIsNew() != null && managerGroupVO.getIsNew()) {
                    managerGroupVO.setCouncilId(null);
                    addOrEditManagerGroupVO.add(managerGroupVO);
                }
                if (managerGroupVO.getIsEdit() != null && managerGroupVO.getIsEdit()) {
                    addOrEditManagerGroupVO.add(managerGroupVO);
                }
            }
            if (!addOrEditManagerGroupVO.isEmpty()) {
                manageGroupService.saveManagerGroups(iGenerator.convert(addOrEditManagerGroupVO, ManagerGroupDTO.class));
            }
        }
    }
}
