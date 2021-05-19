package com.bsoft.office.organ.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.organ.condition.PublicCostCnd;
import com.bsoft.office.organ.vo.BankChargesNoBillVO;
import com.bsoft.office.organ.vo.DeptPublicCostVO;

/**
 * @Author zhanglf
 * @Date 2020-04-20 11:29
 * @Version 1.0
 * @Description
 */
public interface BankChargesManager {
    Result<BankChargesNoBillVO> getBankChargesNoBill(String userId,String context, Integer pageSize, Integer pageNo);

    Result<DeptPublicCostVO> getPublicCostList(PublicCostCnd publicCostCnd);

    DeptPublicCostVO getPublicCostDetail(Integer id);

    Result<DeptPublicCostVO> getPersonalPublicCostList(PublicCostCnd publicCostCnd);
}
