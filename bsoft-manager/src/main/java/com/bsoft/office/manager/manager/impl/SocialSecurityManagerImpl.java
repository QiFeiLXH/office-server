package com.bsoft.office.manager.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.hr.dto.CompanySocialMeeterDTO;
import com.bsoft.hr.service.SocialSecurityService;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.manager.manager.SocialSecurityManager;
import com.bsoft.office.manager.vo.CompanySocialMeeterVO;
import com.bsoft.office.manager.vo.CompanySocialMeeterViewVO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/11/27 8:47
 * @Description
 */
@Service
public class SocialSecurityManagerImpl implements SocialSecurityManager {
    @Autowired
    private IGenerator iGenerator;
    @Reference(timeout = 10000)
    private SocialSecurityService socialSecurityService;

    @Override
    public Result<CompanySocialMeeterViewVO> getCompanySocialMeeterList(String inputContent, List<Integer> socialCompanyFlag, Integer pageNo, Integer pageSize) {
        Result<CompanySocialMeeterDTO> result = socialSecurityService.getCompanySocialMeeterList(inputContent,socialCompanyFlag,pageNo, pageSize);
        return iGenerator.convert(result, CompanySocialMeeterViewVO.class);
    }

    @Override
    public void saveCompanySocialMeeter(CompanySocialMeeterVO companySocialMeeterVO) {
        CompanySocialMeeterDTO companySocialMeeterDTO = iGenerator.convert(companySocialMeeterVO, CompanySocialMeeterDTO.class);
        socialSecurityService.saveCompanySocialMeeter(companySocialMeeterDTO);
    }
}
