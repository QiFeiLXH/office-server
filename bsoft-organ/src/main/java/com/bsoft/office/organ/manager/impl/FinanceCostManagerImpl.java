package com.bsoft.office.organ.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.cost.dto.FinanceCostQueryCndDTO;
import com.bsoft.cost.dto.FinanceCostViewDTO;
import com.bsoft.cost.service.FinanceCostService;
import com.bsoft.office.organ.condition.FinanceCostQueryCnd;
import com.bsoft.office.organ.manager.FinanceCostManager;
import com.bsoft.office.organ.vo.FinanceCostViewVO;
import com.bsoft.office.common.dozer.GeneratorUtil;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-05-26 10:48
 * @Version 1.0
 * @Description
 */
@Component
public class FinanceCostManagerImpl implements FinanceCostManager {
    @Reference(timeout = 60000)
    private FinanceCostService financeCostService;
    @Autowired
    private GeneratorUtil generatorUtil;
    @Override
    public Result<FinanceCostViewVO> getFinanceCostList(FinanceCostQueryCnd queryCnd) {
        FinanceCostQueryCndDTO queryCndDTO = generatorUtil.convert(queryCnd,FinanceCostQueryCndDTO.class);
        Result<FinanceCostViewDTO> dtoResult = financeCostService.getFinanceCostList(queryCndDTO);
        return generatorUtil.convert(dtoResult,FinanceCostViewVO.class);
    }

    @Override
    public List<FinanceCostViewVO> exportFinanceCostList(FinanceCostQueryCnd cnd) {
        FinanceCostQueryCndDTO queryCndDTO = generatorUtil.convert(cnd,FinanceCostQueryCndDTO.class);
        List<FinanceCostViewDTO> dtoResult = financeCostService.getFinanceCostDownload(queryCndDTO);
        List<FinanceCostViewVO> result = generatorUtil.convert(dtoResult,FinanceCostViewVO.class);
        return result;
    }
}
