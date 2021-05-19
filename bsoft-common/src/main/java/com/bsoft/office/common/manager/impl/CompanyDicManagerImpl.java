package com.bsoft.office.common.manager.impl;

import com.bsoft.common.dto.CompanyViewDTO;
import com.bsoft.common.service.CompanyService;
import com.bsoft.office.common.dozer.GeneratorUtil;
import com.bsoft.office.common.manager.CompanyDicManager;
import com.bsoft.office.common.vo.CompanyDicVO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/11/30 13:35
 * @Description:
 */
@Component
public class CompanyDicManagerImpl implements CompanyDicManager {
    @Reference
    private CompanyService companyService;
    @Autowired
    private GeneratorUtil generatorUtil;

    @Override
    public List<CompanyDicVO> getCompanyDic(Integer type) {
        List<CompanyViewDTO> companyViewDTOS = companyService.getCompanyDic(type);
        return generatorUtil.convert(companyViewDTOS,CompanyDicVO.class);
    }
}
