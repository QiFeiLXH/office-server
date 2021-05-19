package com.bsoft.office.organ.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.cost.dto.BankChargesNoBillDTO;
import com.bsoft.cost.dto.DeptPublicCostDTO;
import com.bsoft.cost.dto.PublicCostCndDTO;
import com.bsoft.cost.service.BankChargesService;
import com.bsoft.office.organ.condition.PublicCostCnd;
import com.bsoft.office.organ.vo.DeptPublicCostVO;
import com.bsoft.office.common.dozer.GeneratorUtil;
import com.bsoft.office.organ.manager.BankChargesManager;
import com.bsoft.office.organ.vo.BankChargesNoBillVO;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author zhanglf
 * @Date 2020-04-20 13:07
 * @Version 1.0
 * @Description
 */
@Component
public class BankChargesManagerImpl implements BankChargesManager {
    private static final Logger logger =  LoggerFactory.getLogger(BankChargesManagerImpl.class);
    @Reference
    private BankChargesService bankChargesService;
    @Autowired
    private GeneratorUtil generatorUtil;

    @Override
    public Result<BankChargesNoBillVO> getBankChargesNoBill(String userId,String context, Integer pageSize, Integer pageNo) {
        Result<BankChargesNoBillDTO> dtoResult  = bankChargesService.getBillNotReceived(userId,context, pageSize, pageNo);
        Result<BankChargesNoBillVO> voResult = generatorUtil.convert(dtoResult,BankChargesNoBillVO.class);
        return voResult;
    }

    public Result<DeptPublicCostVO> getPublicCostList(PublicCostCnd publicCostCnd) {
        PublicCostCndDTO cnd = generatorUtil.convert(publicCostCnd, PublicCostCndDTO.class);
        return generatorUtil.convert(bankChargesService.getPublicCostList(cnd), DeptPublicCostVO.class);
    }

    @Override
    public DeptPublicCostVO getPublicCostDetail(Integer id) {
        DeptPublicCostDTO dto = bankChargesService.getDeptPublicCost(id);
        return generatorUtil.convert(dto, DeptPublicCostVO.class);
    }

    @Override
    public Result<DeptPublicCostVO> getPersonalPublicCostList(PublicCostCnd publicCostCnd) {
        PublicCostCndDTO cnd = generatorUtil.convert(publicCostCnd, PublicCostCndDTO.class);
        return generatorUtil.convert(bankChargesService.getPersonalPublicCostList(cnd), DeptPublicCostVO.class);
    }
}
