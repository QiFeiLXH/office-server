package com.bsoft.office.work.manager;

import com.bsoft.common.dto.FileServerDefinitionDTO;
import com.bsoft.common.result.Result;
import com.bsoft.office.work.condition.BusinessCardQueryCnd;
import com.bsoft.office.work.vo.BusinessCardViewVO;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2021/2/3 16:23
 * @Description
 */
public interface BusinessCardManager {
    Result<BusinessCardViewVO> getBusinessCardList(BusinessCardQueryCnd queryCnd);

    Integer getBusinessCardUnpaidCount(BusinessCardQueryCnd queryCnd);

    Double getBusinessCardUnpaidAmount();

    Double getBusinessCardTotalAmount(List<Integer> businessCardIds);

    List<Integer> getBusinessCardIdList(BusinessCardQueryCnd queryCnd);

    void payBusinessCard(List<Integer> businessCardIds);

    List<BusinessCardViewVO> applyPayBusinessCard(List<Integer> businessCardIds);

    FileServerDefinitionDTO showImageByte(Integer id);
}
