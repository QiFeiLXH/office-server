package com.bsoft.office.project.manager.impl;

import com.bosft.progress.dto.ProReportTypeDTO;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.project.manager.ProReportTypeManager;
import com.bsoft.office.project.vo.ProReportTypeVO;
import com.bsoft.progress.service.ProReportTypeService;
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
public class ProReportTypeManagerImpl implements ProReportTypeManager {
    @Reference(timeout = 60000, check = false)
    private ProReportTypeService proReportTypeService;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public List<ProReportTypeVO> getProReportTypes() {
        List<ProReportTypeDTO> proProgressNodes = proReportTypeService.getProReportTypes();
        return iGenerator.convert(proProgressNodes, ProReportTypeVO.class);

    }

    @Override
    public void saveProReportTypes(ProReportTypeVO proReportTypeVO) {
        ProReportTypeDTO convert = iGenerator.convert(proReportTypeVO, ProReportTypeDTO.class);
        proReportTypeService.saveProReportTypes(convert);
    }

    @Override
    public void logoutProReportType(Integer id) {
        proReportTypeService.logoutProReportType(id);

    }

}
