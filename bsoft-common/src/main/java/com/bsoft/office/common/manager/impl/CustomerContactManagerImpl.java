package com.bsoft.office.common.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.common.manager.CustomerContactManager;
import com.bsoft.office.common.vo.CustomerContactVO;
import com.bsoft.sales.dto.CustomerContactsDTO;
import com.bsoft.sales.service.CustomerContactsService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: zy
 * @date: 2021/2/5
 * @description
 */
@Component
public class CustomerContactManagerImpl implements CustomerContactManager {
    @Reference
    private CustomerContactsService customerContactsService;
    @Autowired
    private IGenerator iGenerator;
    @Override
    public Result<CustomerContactVO> getCustomerContact(Integer pageNo, Integer pageSize, String inputContent) {
        Result<CustomerContactsDTO> list = customerContactsService.getCustomerContactsList(pageNo, pageSize, inputContent);
        return iGenerator.convert(list, CustomerContactVO.class);
    }
}
