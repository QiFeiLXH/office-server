package com.bsoft.office.sales.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.dozer.GeneratorUtil;
import com.bsoft.office.sales.condition.OriginalAcceptanceQueryCndVO;
import com.bsoft.office.sales.manager.OriginalAcceptanceManager;
import com.bsoft.office.sales.vo.OriginalAcceptanceVO;
import com.bsoft.sales.dto.OriginalAcceptanceDTO;
import com.bsoft.sales.dto.OriginalAcceptanceQueryCndDTO;
import com.bsoft.sales.service.OriginalAcceptanceService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/7/29 16:23
 * @Description: 合同原件审核
 */
@Service
public class OriginalAcceptanceManagerImpl implements OriginalAcceptanceManager {
    @Reference(timeout = 60000)
    private OriginalAcceptanceService originalAcceptanceService;
    @Autowired
    private GeneratorUtil generatorUtil;

    @Override
    public Result<OriginalAcceptanceVO> getFinancialReceptionList(OriginalAcceptanceQueryCndVO cndVO) {
        OriginalAcceptanceQueryCndDTO cndDTO = generatorUtil.convert(cndVO,OriginalAcceptanceQueryCndDTO.class);
        cndDTO.setStatus(1);
        Result<OriginalAcceptanceDTO> dtoResult = originalAcceptanceService.getOriginalAcceptance(cndDTO);
        return generatorUtil.convert(dtoResult,OriginalAcceptanceVO.class);
    }

    @Override
    public void auditFinancialReception(List<OriginalAcceptanceVO> words, String userId) {
        List<OriginalAcceptanceDTO> wordDTOS = generatorUtil.convert(words, OriginalAcceptanceDTO.class);
        originalAcceptanceService.auditOriginalAcceptance(wordDTOS,userId,2);
    }

    @Override
    public Result<OriginalAcceptanceVO> getFinancialFilingList(OriginalAcceptanceQueryCndVO cndVO) {
        OriginalAcceptanceQueryCndDTO cndDTO = generatorUtil.convert(cndVO,OriginalAcceptanceQueryCndDTO.class);
        cndDTO.setStatus(2);
        Result<OriginalAcceptanceDTO> dtoResult = originalAcceptanceService.getOriginalAcceptance(cndDTO);
        return generatorUtil.convert(dtoResult,OriginalAcceptanceVO.class);
    }

    @Override
    public void auditFinanceFill(List<OriginalAcceptanceVO> words, String userId) {
        List<OriginalAcceptanceDTO> wordDTOS = generatorUtil.convert(words, OriginalAcceptanceDTO.class);
        originalAcceptanceService.auditOriginalAcceptance(wordDTOS,userId,3);
    }

    @Override
    public Result<OriginalAcceptanceVO> getLegalReceptionList(OriginalAcceptanceQueryCndVO cndVO) {
        OriginalAcceptanceQueryCndDTO cndDTO = generatorUtil.convert(cndVO,OriginalAcceptanceQueryCndDTO.class);
        cndDTO.setStatus(3);
        Result<OriginalAcceptanceDTO> dtoResult = originalAcceptanceService.getOriginalAcceptance(cndDTO);
        return generatorUtil.convert(dtoResult,OriginalAcceptanceVO.class);
    }

    @Override
    public void auditLegalReception(List<OriginalAcceptanceVO> words, String userId) {
        List<OriginalAcceptanceDTO> wordDTOS = generatorUtil.convert(words, OriginalAcceptanceDTO.class);
        originalAcceptanceService.auditOriginalAcceptance(wordDTOS,userId,4);
    }
}
