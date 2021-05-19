package com.bsoft.office.hr.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.hr.dto.NewEntryPersonInfoDTO;
import com.bsoft.hr.dto.NewEntryPersonInfoQueryCndDTO;
import com.bsoft.hr.dto.PersonCompanyDTO;
import com.bsoft.hr.service.NewEntryPersonInfoService;
import com.bsoft.office.common.dozer.GeneratorUtil;
import com.bsoft.office.hr.condition.NewEntryPersonInfoQueryCnd;
import com.bsoft.office.hr.manager.NewEntryPersonInfoManager;
import com.bsoft.office.hr.vo.NewEntryPersonInfoVO;
import com.bsoft.office.hr.vo.PersonCompanyVO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NewEntryPersonInfoManagerImpl implements NewEntryPersonInfoManager {
    @Reference(timeout = 60000)
    private NewEntryPersonInfoService personInfoService;

    @Override
    public Result<NewEntryPersonInfoVO> getPersonInfoList(String personId, NewEntryPersonInfoQueryCnd cnd) {
        NewEntryPersonInfoQueryCndDTO queryCnd = GeneratorUtil.instance().convert(cnd,NewEntryPersonInfoQueryCndDTO.class);
        Result<NewEntryPersonInfoDTO> result = personInfoService.getPersonInfoList(personId,queryCnd);
        return GeneratorUtil.instance().convert(result,NewEntryPersonInfoVO.class);
    }

    @Override
    public List<NewEntryPersonInfoVO> getAllPersonInfoList(String personId, NewEntryPersonInfoQueryCnd cnd) {
        NewEntryPersonInfoQueryCndDTO queryCnd = GeneratorUtil.instance().convert(cnd,NewEntryPersonInfoQueryCndDTO.class);
        List<NewEntryPersonInfoDTO> list =  personInfoService.getAllPersonInfoList(personId,queryCnd);
        return GeneratorUtil.instance().convert(list,NewEntryPersonInfoVO.class);
    }

    @Override
    public void updateSalary(String personId, String updatePersonId, Double probationSalary, Double regularSalary,Double paymentBase,Integer place) {
        personInfoService.updateSalary(personId, updatePersonId, probationSalary, regularSalary,paymentBase,place);
    }

    @Override
    public List<PersonCompanyVO> getAllCompany(String personId) {
        List<PersonCompanyDTO> list = personInfoService.getAllCompany(personId);
        return GeneratorUtil.instance().convert(list,PersonCompanyVO.class);
    }
}
