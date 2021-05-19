package com.bsoft.office.common.manager.impl;

import com.bsoft.common.dto.PublicDicDTO;
import com.bsoft.common.dto.PublicDicSelectQueryCndDTO;
import com.bsoft.common.service.PublicDicService;
import com.bsoft.office.common.condition.PublicDicSelectQueryCnd;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.common.manager.PublicDicManager;
import com.bsoft.office.common.vo.PublicDicVO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/10/19 17:45
 * @Description
 */
@Component
public class PublicDicManagerImpl implements PublicDicManager {
    @Reference
    private PublicDicService publicDicService;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public List<PublicDicVO> getPublicDics(Integer type) {
        List<PublicDicVO> dics = iGenerator.convert(publicDicService.getPublicDic(type), PublicDicVO.class);
        return dics;
    }

    @Override
    public List<PublicDicVO> getPublicDicsWithFlag(Integer type, Integer flag) {
        List<PublicDicVO> dics = iGenerator.convert(publicDicService.getPublicDicWithFlag(type, flag), PublicDicVO.class);
        return dics;
    }

    @Override
    public List<PublicDicVO> getPublicDicSelectList(PublicDicSelectQueryCnd queryCnd) {
        PublicDicSelectQueryCndDTO queryCndDTO = iGenerator.convert(queryCnd, PublicDicSelectQueryCndDTO.class);
        List<PublicDicDTO> list = publicDicService.getPublicDicSelectList(queryCndDTO);
        return iGenerator.convert(list, PublicDicVO.class);
    }
}
