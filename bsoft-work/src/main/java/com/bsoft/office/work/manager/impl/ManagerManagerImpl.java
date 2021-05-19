package com.bsoft.office.work.manager.impl;

import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.work.manager.ManagerManager;
import com.bsoft.office.work.vo.ManagerVO;
import com.bsoft.work.dto.ManagerDTO;
import com.bsoft.work.service.ManagerService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ding cj
 * @Date 2021/5/14 10:02
 * @Description
 */
@Component
public class ManagerManagerImpl implements ManagerManager {

    @Reference
    private ManagerService managerService;

    @Autowired
    private IGenerator iGenerator;

    @Override
    public List<ManagerVO> findList(String personName, Integer councilId) {
        List<ManagerDTO> list = managerService.findList(personName, councilId);
        return iGenerator.convert(list,ManagerVO.class);
    }

    @Override
    public void deleteManager(Integer id) {
        managerService.deleteManager(id);
    }

    @Override
    public void saveManager(List<ManagerVO> managerList) {
        if(!managerList.isEmpty()){
            List<ManagerVO> addOrEditManagerVO = new ArrayList<>();
            for (ManagerVO managerVO : managerList) {
                if(managerVO.getIsNew() != null && managerVO.getIsNew()){
                    managerVO.setId(null);
                    addOrEditManagerVO.add(managerVO);
                }
                if(managerVO.getIsEdit() != null && managerVO.getIsEdit()){
                    addOrEditManagerVO.add(managerVO);
                }
            }
            if(!addOrEditManagerVO.isEmpty()){
                managerService.saveManager(iGenerator.convert(addOrEditManagerVO, ManagerDTO.class));
            }
        }
    }
}
