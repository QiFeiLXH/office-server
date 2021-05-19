package com.bsoft.office.hr.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.hr.manager.WorkCertificateManager;
import com.bsoft.office.hr.vo.WorkCertificateNumViewVO;
import com.bsoft.office.hr.vo.WorkCertificateVO;
import com.bsoft.person.dto.WorkCertificateDTO;
import com.bsoft.person.dto.WorkCertificateNumDTO;
import com.bsoft.person.service.WorkCertificateService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Xuhui Lin
 * @Date 2020/8/4 14:55
 * @Description
 */
@Service
public class WorkCertificateManagerImpl implements WorkCertificateManager {
    @Reference
    private WorkCertificateService workCertificateService;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public Result<WorkCertificateNumViewVO> getCertificateNumList(String deptId, String inputContent, Integer pageNo, Integer pageSize) {
        Result<WorkCertificateNumDTO> result = workCertificateService.getCertificateNumList(deptId, inputContent, pageNo, pageSize);
        return iGenerator.convert(result, WorkCertificateNumViewVO.class);
    }

    @Override
    public Result<WorkCertificateVO> getPersonalCertificateList(String personId, Integer pageNo, Integer pageSize) {
        Result<WorkCertificateDTO> result = workCertificateService.getPersonalCertificateList(personId, pageNo, pageSize);
        return iGenerator.convert(result, WorkCertificateVO.class);
    }
}
