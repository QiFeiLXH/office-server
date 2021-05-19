package com.bsoft.office.organ.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.organ.condition.FinanceCostQueryCnd;
import com.bsoft.office.organ.vo.FinanceCostViewVO;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-05-26 10:46
 * @Version 1.0
 * @Description
 */
public interface FinanceCostManager {
    Result<FinanceCostViewVO> getFinanceCostList(FinanceCostQueryCnd queryCnd);

    List<FinanceCostViewVO> exportFinanceCostList(FinanceCostQueryCnd cnd);
}
