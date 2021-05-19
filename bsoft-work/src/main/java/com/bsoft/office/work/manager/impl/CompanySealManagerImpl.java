package com.bsoft.office.work.manager.impl;

import com.bsoft.common.dto.CompanyViewDTO;
import com.bsoft.common.result.Result;
import com.bsoft.common.service.CompanyService;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.work.manager.CompanySealManager;
import com.bsoft.office.work.vo.CompanySealVO;
import com.bsoft.work.dto.CompanySealDTO;
import com.bsoft.work.dto.CompanySealQueryCnd;
import com.bsoft.work.service.CompanySealService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanySealManagerImpl implements CompanySealManager {
    @Reference
    private CompanySealService companySealService;
    @Reference
    private CompanyService companyService;
    @Autowired
    private IGenerator iGenerator;
    @Override
    public Result<CompanySealVO> getCompanySealList(CompanySealQueryCnd companySealQueryCnd) {
        Result<CompanySealDTO> companySealList = companySealService.getCompanySealList(companySealQueryCnd);
        return  iGenerator.convert(companySealList,CompanySealVO.class);
    }

    @Override
    public void saveCompanySeal(CompanySealDTO companySealDTO) {
        companySealService.saveCompanySeal(companySealDTO);
    }

    @Override
    public CompanySealVO getCompanySeal(Integer id) {
        return iGenerator.convert( companySealService.getCompanySealView(id),CompanySealVO.class);

    }

    @Override
    public List<CompanyViewDTO> getCompanyNoCancel(String input) {
        return companyService.getCompanyViewList(input);

    }
}
