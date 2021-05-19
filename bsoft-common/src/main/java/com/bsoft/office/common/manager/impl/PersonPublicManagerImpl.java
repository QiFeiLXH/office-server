package com.bsoft.office.common.manager.impl;

import com.bsoft.office.common.condition.PersonSelectQueryCnd;
import com.bsoft.office.common.dozer.GeneratorUtil;
import com.bsoft.office.common.manager.PersonPublicManager;
import com.bsoft.office.common.vo.PersonSelectViewVO;
import com.bsoft.person.dto.PersonDTO;
import com.bsoft.person.dto.PersonSelectQueryCndDTO;
import com.bsoft.person.dto.PersonSelectViewDTO;
import com.bsoft.person.service.PersonService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/10/23 10:44
 * @Description
 */
@Component
public class PersonPublicManagerImpl implements PersonPublicManager {
    @Reference(timeout = 10000)
    private PersonService personService;
    @Autowired
    private GeneratorUtil generatorUtil;


    @Override
    public PersonSelectViewVO getCurrentPerson(String userId) {
        PersonDTO person = personService.getPerson(userId);
        return generatorUtil.convert(person,PersonSelectViewVO.class);
    }

    @Override
    public List<PersonSelectViewVO> findPersonSelectList(String simpleCode) {
        List<PersonSelectViewDTO> personSelectList = personService.findPersonSelectList(simpleCode);
        return generatorUtil.convert(personSelectList, PersonSelectViewVO.class);
    }

    @Override
    public List<PersonSelectViewVO> findSelectPersonList(String inputContent, Integer isValid) {
        List<PersonSelectViewDTO> personSelectList = personService.findPersonSelectList(inputContent,isValid);
        return generatorUtil.convert(personSelectList, PersonSelectViewVO.class);
    }

    @Override
    public List<PersonSelectViewVO> getPersonSelectList(PersonSelectQueryCnd queryCnd) {
        PersonSelectQueryCndDTO queryCndDTO = generatorUtil.convert(queryCnd, PersonSelectQueryCndDTO.class);
        List<PersonSelectViewDTO> personSelectList = personService.getPersonSelectList(queryCndDTO);
        return generatorUtil.convert(personSelectList, PersonSelectViewVO.class);
    }

    @Override
    public List<PersonSelectViewVO> getPersonsWithPersonIds(List<String> personIds) {
        List<PersonDTO> list = personService.getPersonList(personIds);
        return generatorUtil.convert(list, PersonSelectViewVO.class);
    }
}
