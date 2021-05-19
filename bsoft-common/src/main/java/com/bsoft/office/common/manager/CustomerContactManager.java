package com.bsoft.office.common.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.vo.CustomerContactVO;

/**
 * @version 1.0
 * @author: zy
 * @date: 2021/2/5
 * @description
 */
public interface CustomerContactManager {
    Result<CustomerContactVO> getCustomerContact(Integer pageNo, Integer pageSize, String inputContent);
}
