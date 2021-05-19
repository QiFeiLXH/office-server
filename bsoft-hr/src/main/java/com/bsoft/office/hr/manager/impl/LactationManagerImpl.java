package com.bsoft.office.hr.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.hr.dto.LactationDTO;
import com.bsoft.hr.dto.LactationQueryCndDTO;
import com.bsoft.hr.service.LactationService;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.hr.condition.LactationQueryCnd;
import com.bsoft.office.hr.manager.LactationManager;
import com.bsoft.office.hr.vo.LactationVO;
import com.bsoft.office.hr.vo.LactationViewVO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/5 10:55
 * @Description
 */
@Service
public class LactationManagerImpl implements LactationManager {
    @Reference
    private LactationService lactationService;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public Result<LactationViewVO> getLactationList(LactationQueryCnd queryCnd) {
        LactationQueryCndDTO cnd = iGenerator.convert(queryCnd, LactationQueryCndDTO.class);
        Result<LactationDTO> result = lactationService.getLactationList(cnd);
        return iGenerator.convert(result, LactationViewVO.class);
    }

    @Override
    public Integer saveLactation(LactationVO lactation) {
        LactationDTO lactationDTO = iGenerator.convert(lactation, LactationDTO.class);
        return lactationService.saveLactation(lactationDTO);
    }

}
