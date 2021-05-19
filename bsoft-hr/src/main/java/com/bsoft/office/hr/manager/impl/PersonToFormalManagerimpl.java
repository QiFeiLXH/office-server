package com.bsoft.office.hr.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.dozer.GeneratorUtil;
import com.bsoft.office.hr.condition.PersonToFormalQueryCnd;
import com.bsoft.office.hr.manager.PersonToFormalManager;
import com.bsoft.office.hr.vo.PersonToFormalCountVO;
import com.bsoft.office.hr.vo.PersonToFormalVO;
import com.bsoft.office.hr.vo.PersonTurViewVO;
import com.bsoft.person.dto.PersonToFormalCountDTO;
import com.bsoft.person.dto.PersonToFormalDTO;
import com.bsoft.person.dto.PersonToFormalQueryCndDTO;
import com.bsoft.person.dto.PersonTurViewDTO;
import com.bsoft.person.service.PersonToFormalService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2021/2/1 8:54
 * @Description:
 */
@Service
public class PersonToFormalManagerimpl implements PersonToFormalManager {

    @Reference
    private PersonToFormalService personToFormalService;
    @Autowired
    private GeneratorUtil generatorUtil;

    @Override
    public List<PersonToFormalCountVO> getMonthCount(Integer year) {
        List<PersonToFormalCountDTO> personToFormalCountDTOS = personToFormalService.getMonthCount(year);
        return generatorUtil.convert(personToFormalCountDTOS,PersonToFormalCountVO.class);
    }

    @Override
    public Result<PersonToFormalVO> getMonthPersonToFormalList(PersonToFormalQueryCnd cnd) {
        PersonToFormalQueryCndDTO cndDTO = generatorUtil.convert(cnd,PersonToFormalQueryCndDTO.class);
        Result<PersonToFormalDTO> personToFormalDTOResult = personToFormalService.getMonthPersonToFormalList(cndDTO);
        return generatorUtil.convert(personToFormalDTOResult,PersonToFormalVO.class);
    }

    @Override
    public PersonTurViewVO getPersonTur(Integer id) {
        PersonTurViewDTO personTurViewDTO = personToFormalService.getPersonTur(id);
        return generatorUtil.convert(personTurViewDTO,PersonTurViewVO.class);
    }

}
