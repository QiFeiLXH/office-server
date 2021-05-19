package com.bsoft.office.organ.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.cost.dto.SubsidyStandardQueryCndDTO;
import com.bsoft.cost.dto.SubsidyStandardViewDTO;
import com.bsoft.cost.service.SubsidyStandardService;
import com.bsoft.office.organ.condition.SubsidyStandardQueryCnd;
import com.bsoft.office.organ.manager.SubsidyStandardManager;
import com.bsoft.office.organ.vo.SubsidyStandardViewVO;
import com.bsoft.office.common.dozer.GeneratorUtil;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: xucl
 * @DateTime: 2020/11/25 17:39
 * @Description:
 */
@Component
public class SubsidyStandardManagerImpl implements SubsidyStandardManager {

    @Reference
    private SubsidyStandardService standardService;
    @Autowired
    private GeneratorUtil generatorUtil;

    @Override
    public Result<SubsidyStandardViewVO> findSubsidyStandard(SubsidyStandardQueryCnd cnd) {
        SubsidyStandardQueryCndDTO standardQueryCndDTO = generatorUtil.convert(cnd,SubsidyStandardQueryCndDTO.class);
        Result<SubsidyStandardViewDTO> result = standardService.findSubsidyStandard(standardQueryCndDTO);
        return generatorUtil.convert(result,SubsidyStandardViewVO.class);
    }

    @Override
    public void saveSubsidyStandard(SubsidyStandardViewVO standardViewVO) {
        SubsidyStandardViewDTO subsidyStandardViewDTO = generatorUtil.convert(standardViewVO,SubsidyStandardViewDTO.class);
        standardService.saveSubsidyStandard(subsidyStandardViewDTO);
    }
}
