package com.bsoft.office.organ.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.cost.dto.BondInfoDTO;
import com.bsoft.cost.dto.BondInfoQueryCndDTO;
import com.bsoft.cost.dto.BondOverdueInfoDTO;
import com.bsoft.cost.service.BondService;
import com.bsoft.office.organ.condition.BondInfoQueryCnd;
import com.bsoft.office.common.dozer.GeneratorUtil;
import com.bsoft.office.organ.manager.BondManager;
import com.bsoft.office.organ.vo.BondInfoVO;
import com.bsoft.office.organ.vo.BondOverdueInfoVO;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-04-20 13:25
 * @Version 1.0
 * @Description
 */
@Component
public class BondManagerImpl implements BondManager {
    private static final Logger logger = LoggerFactory.getLogger(BondManagerImpl.class);
    @Reference
    private BondService bondService;
    @Autowired
    private GeneratorUtil generatorUtil;
    @Override
    public Result<BondInfoVO> getBondNotRushAccount(String userId, Integer performanceSymbol,String context, Integer pageSize, Integer pageNo) {
        Result<BondInfoDTO> dtoResult = bondService.getBondNotRushAccount(userId, performanceSymbol,context, pageSize, pageNo);
        Result<BondInfoVO> voResult = generatorUtil.convert(dtoResult,BondInfoVO.class);
        return voResult;
    }

    @Override
    public Result<BondOverdueInfoVO> getBondOverdueInfoList(BondInfoQueryCnd bondInfoQueryCnd) {
        BondInfoQueryCndDTO cnd = generatorUtil.convert(bondInfoQueryCnd, BondInfoQueryCndDTO.class);
        return generatorUtil.convert(bondService.getBondOverdueInfoList(cnd), BondOverdueInfoVO.class);
    }

    @Override
    public List<BondOverdueInfoVO> exportBondOverdueInfoList(BondInfoQueryCnd bondInfoQueryCnd) {
        BondInfoQueryCndDTO cnd = generatorUtil.convert(bondInfoQueryCnd, BondInfoQueryCndDTO.class);
        return generatorUtil.convert(bondService.getAllBondOverdueInfoList(cnd), BondOverdueInfoVO.class);
    }

    @Override
    public BondOverdueInfoVO getBondOverdueDetail(String id) {
        BondOverdueInfoDTO dto = bondService.getBondOverdueInfo(id);
        return generatorUtil.convert(dto,BondOverdueInfoVO.class);
    }

    @Override
    public List<BondOverdueInfoVO> exportPersonalBondInfoList(BondInfoQueryCnd bondInfoQueryCnd) {
        BondInfoQueryCndDTO cnd = generatorUtil.convert(bondInfoQueryCnd, BondInfoQueryCndDTO.class);
        return generatorUtil.convert(bondService.getPersonalAllBondList(cnd), BondOverdueInfoVO.class);
    }

    @Override
    public Result<BondOverdueInfoVO> getPersonalBondList(BondInfoQueryCnd bondInfoQueryCnd) {
        BondInfoQueryCndDTO cnd = generatorUtil.convert(bondInfoQueryCnd, BondInfoQueryCndDTO.class);
        return generatorUtil.convert(bondService.getPersonalBondList(cnd), BondOverdueInfoVO.class);
    }
}
