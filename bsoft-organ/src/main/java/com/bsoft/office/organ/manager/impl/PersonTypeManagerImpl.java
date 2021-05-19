package com.bsoft.office.organ.manager.impl;

import com.bsoft.common.dto.PublicDicDTO;
import com.bsoft.common.result.Result;
import com.bsoft.hr.service.PersonTypeService;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.common.vo.PublicDicVO;
import com.bsoft.office.organ.manager.PersonTypeManager;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonTypeManagerImpl implements PersonTypeManager {

    @Reference(timeout = 60000)
    private PersonTypeService personTypeService;

    @Autowired
    private IGenerator iGenerator;

    @Override
    public PublicDicVO getPersonTypeInfo(String userId, PublicDicVO publicDicVO) {
        PublicDicDTO publicDicDTO = iGenerator.convert(publicDicVO, PublicDicDTO.class);
        PublicDicDTO personTypeInfo = personTypeService.getPersonTypeInfo(publicDicDTO);
        return iGenerator.convert(personTypeInfo, PublicDicVO.class);

    }

    @Override
    public Result<PublicDicVO> getPersonTypeInfoList(Integer pageNo, Integer pageSize, Integer type, Integer personflag) {
        Result<PublicDicDTO> personTypeInfoList = personTypeService.getPersonTypeInfoList(pageNo, pageSize,type,personflag);
        return iGenerator.convert(personTypeInfoList, PublicDicVO.class);
    }

    @Override
    public void addPersonType(String userId, PublicDicVO publicDicVO) {
        PublicDicDTO publicDicDTO = iGenerator.convert(publicDicVO, PublicDicDTO.class);
        personTypeService.addPersonType(userId,publicDicDTO);
    }

    @Override
    public void updatePersonType(String userId, PublicDicVO publicDicVO) {
        PublicDicDTO publicDicDTO = iGenerator.convert(publicDicVO, PublicDicDTO.class);
        personTypeService.updatePersonType(userId,publicDicDTO);
    }

    public boolean logoutPersonType(Integer id) {
        return personTypeService.logoutPersonType(id);
    }
}
