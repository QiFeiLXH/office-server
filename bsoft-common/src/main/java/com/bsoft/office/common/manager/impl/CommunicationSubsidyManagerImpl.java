package com.bsoft.office.common.manager.impl;

import com.bsoft.common.dto.CommunicationSubsidyDTO;
import com.bsoft.common.service.CommunicationSubsidyService;
import com.bsoft.office.common.dozer.GeneratorUtil;
import com.bsoft.office.common.manager.CommunicationSubsidyManager;
import com.bsoft.office.common.vo.CommunicationSubsidyVO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/12/30 15:26
 * @Description:
 */
@Component
public class CommunicationSubsidyManagerImpl implements CommunicationSubsidyManager {

    @Reference
    private CommunicationSubsidyService communicationSubsidyService;
    @Autowired
    private GeneratorUtil generatorUtil;
    @Override
    public List<CommunicationSubsidyVO> getCommunicationSubsidy() {
        List<CommunicationSubsidyDTO> list = communicationSubsidyService.getCommunicationSubsidy();
        return generatorUtil.convert(list,CommunicationSubsidyVO.class);
    }
}
