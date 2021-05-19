package com.bsoft.office.common.manager.impl;

import com.bsoft.common.dto.HumanDicSelectQueryCndDTO;
import com.bsoft.common.service.HumanDicService;
import com.bsoft.office.common.condition.HumanDicSelectQueryCnd;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.common.manager.HumanDicManager;
import com.bsoft.office.common.vo.HumanDicVO;
import com.bsoft.person.dto.HumanDicDTO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HumanDicManagerImpl implements HumanDicManager {
    @Reference
    private HumanDicService humanDicService;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public List<HumanDicDTO> getHumanDic(Integer type) {
        return humanDicService.getHumanDic(type);
    }

    @Override
    public List<HumanDicVO> getHumanDicSelectList(HumanDicSelectQueryCnd queryCnd) {
        HumanDicSelectQueryCndDTO queryCndDTO = iGenerator.convert(queryCnd, HumanDicSelectQueryCndDTO.class);
        List<HumanDicDTO> list = humanDicService.getHumanDicSelectList(queryCndDTO);
        return iGenerator.convert(list, HumanDicVO.class);
    }
}
