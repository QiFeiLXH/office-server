package com.bsoft.office.common.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.customer.dto.CustomerDTO;
import com.bsoft.customer.dto.CustomerQueryCndDTO;
import com.bsoft.customer.service.CustomerService;
import com.bsoft.office.common.condition.CustomerQueryCnd;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.common.manager.CustomerManager;
import com.bsoft.office.common.vo.CustomerVO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: zy
 * @date: 2020/12/7
 * @description 客户基本信息
 */
@Component
public class CustomerManagerImpl implements CustomerManager {

    @Reference
    private CustomerService customerService;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public Result<CustomerVO> getCustomerList(CustomerQueryCnd queryCnd) {
        CustomerQueryCndDTO queryCndDTO = iGenerator.convert(queryCnd, CustomerQueryCndDTO.class);
        Result<CustomerDTO> result = customerService.getCustomerList(queryCndDTO);
        return iGenerator.convert(result, CustomerVO.class);
    }
}
