package com.bsoft.office.organ.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.organ.condition.BondInfoQueryCnd;
import com.bsoft.office.organ.vo.BondInfoVO;
import com.bsoft.office.organ.vo.BondOverdueInfoVO;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-04-20 11:29
 * @Version 1.0
 * @Description
 */
public interface BondManager {
    Result<BondInfoVO> getBondNotRushAccount(String userId, Integer performanceSymbol,String context,Integer pageSize, Integer pageNo);

    Result<BondOverdueInfoVO> getBondOverdueInfoList(BondInfoQueryCnd bondInfoQueryCnd);

    List<BondOverdueInfoVO> exportBondOverdueInfoList(BondInfoQueryCnd bondInfoQueryCnd);

    BondOverdueInfoVO getBondOverdueDetail(String id);

    List<BondOverdueInfoVO> exportPersonalBondInfoList(BondInfoQueryCnd bondInfoQueryCnd);

    Result<BondOverdueInfoVO> getPersonalBondList(BondInfoQueryCnd bondInfoQueryCnd);
}
