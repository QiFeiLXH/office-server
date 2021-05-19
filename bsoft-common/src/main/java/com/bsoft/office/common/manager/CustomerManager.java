package com.bsoft.office.common.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.condition.CustomerQueryCnd;
import com.bsoft.office.common.vo.CustomerVO;

/**
 * @author: zy
 * @date: 2020/12/7
 * @description
 */
public interface CustomerManager {
    Result<CustomerVO> getCustomerList(CustomerQueryCnd queryCnd);
}
