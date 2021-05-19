package com.bsoft.office.work.manager.impl;

import com.bsoft.common.dto.FileServerDefinitionDTO;
import com.bsoft.common.result.Result;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.work.condition.BusinessCardQueryCnd;
import com.bsoft.office.work.manager.BusinessCardManager;
import com.bsoft.office.work.vo.BusinessCardViewVO;
import com.bsoft.person.dto.BusinessCardDTO;
import com.bsoft.person.dto.BusinessCardQueryCndDTO;
import com.bsoft.person.service.BusinessCardService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2021/2/3 16:24
 * @Description
 */
@Service
public class BusinessCardManagerImpl implements BusinessCardManager {
    @Reference
    private BusinessCardService businessCardService;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public Result<BusinessCardViewVO> getBusinessCardList(BusinessCardQueryCnd queryCnd) {
        BusinessCardQueryCndDTO cnd = iGenerator.convert(queryCnd, BusinessCardQueryCndDTO.class);
        Result<BusinessCardDTO> result = businessCardService.getBusinessCardList(cnd);
        return iGenerator.convert(result, BusinessCardViewVO.class);
    }

    @Override
    public Integer getBusinessCardUnpaidCount(BusinessCardQueryCnd queryCnd) {
        BusinessCardQueryCndDTO cnd = iGenerator.convert(queryCnd, BusinessCardQueryCndDTO.class);
        return businessCardService.getBusinessCardUnpaidCount(cnd);
    }

    @Override
    public Double getBusinessCardUnpaidAmount() {
        return businessCardService.getBusinessCardUnpaidAmount();
    }

    @Override
    public Double getBusinessCardTotalAmount(List<Integer> businessCardIds) {
        return businessCardService.getBusinessCardTotalAmount(businessCardIds);
    }

    @Override
    public List<Integer> getBusinessCardIdList(BusinessCardQueryCnd queryCnd) {
        BusinessCardQueryCndDTO cnd = iGenerator.convert(queryCnd, BusinessCardQueryCndDTO.class);
        return businessCardService.getBusinessCardIdList(cnd);
    }

    @Override
    public void payBusinessCard(List<Integer> businessCardIds) {
        businessCardService.updateBusinessCardPay(businessCardIds);
    }

    @Override
    public List<BusinessCardViewVO> applyPayBusinessCard(List<Integer> businessCardIds) {
        List<BusinessCardDTO> list = businessCardService.updateBusinessCardApplyPay(businessCardIds);
        return iGenerator.convert(list, BusinessCardViewVO.class);
    }

    @Override
    public FileServerDefinitionDTO showImageByte(Integer id) {
        FileServerDefinitionDTO definitionDTO = businessCardService.showImageByte(id);
        return definitionDTO;
    }
}
