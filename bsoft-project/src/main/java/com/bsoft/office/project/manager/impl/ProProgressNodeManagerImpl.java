package com.bsoft.office.project.manager.impl;


import com.bosft.progress.dto.ProProgressNodeDTO;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.project.manager.ProProgressNodeManager;
import com.bsoft.office.project.vo.ProProgressNodeVO;
import com.bsoft.progress.service.ProProgressNodeService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author kh Lin
 * @Date 2021/4/19 16:47
 * @Description
 */
@Service
public class ProProgressNodeManagerImpl implements ProProgressNodeManager {
    @Reference(timeout = 60000, check = false)
    private ProProgressNodeService proProgressNodeService;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public List<ProProgressNodeVO> getProProgressNodes(Integer id) {
        List<ProProgressNodeDTO> proProgressNodes = proProgressNodeService.getProProgressNodes(id);
        return iGenerator.convert(proProgressNodes,ProProgressNodeVO.class);

    }

    @Override
    public void saveProProgressNodes(List<ProProgressNodeVO> list) {
        List<ProProgressNodeDTO> convert = iGenerator.convert(list, ProProgressNodeDTO.class);
        proProgressNodeService.saveProProgressNodes(convert);
    }

    @Override
    public void logoutProProgressNode(Integer id) {
        proProgressNodeService.logoutProProgressNode(id);
    }
}
