package com.bsoft.office.organ.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.hr.dto.PersonFinancialViewDTO;
import com.bsoft.hr.service.PersonFinancialViewService;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.organ.manager.PersonFinancialViewManager;
import com.bsoft.office.organ.vo.PersonFinancialViewVO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonFinancialViewManagerImpl implements PersonFinancialViewManager {
    @Reference(timeout = 60000)
    private PersonFinancialViewService personFinancialViewService;

    @Autowired
    private IGenerator iGenerator;

    @Override
    public Result<PersonFinancialViewVO> getPersonFinancialList(PersonFinancialViewVO personFinancialViewVO) {
        PersonFinancialViewDTO convert = iGenerator.convert(personFinancialViewVO, PersonFinancialViewDTO.class);
        Result<PersonFinancialViewDTO> personFinancialList = personFinancialViewService.getPersonFinancialList(convert);
        Result<PersonFinancialViewVO> result = iGenerator.convert(personFinancialList, PersonFinancialViewVO.class);
        return result;

    }

    @Override
    public void updatePersonFinancial(String userId,List<PersonFinancialViewVO> personFinancialViewVOList) {
        List<PersonFinancialViewDTO> convert = iGenerator.convert(personFinancialViewVOList, PersonFinancialViewDTO.class);
         personFinancialViewService.updatePersonFinancial(userId,convert);
    }
}
