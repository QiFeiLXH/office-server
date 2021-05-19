package com.bsoft.office.work.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.work.condition.PolicyQueryCnd;
import com.bsoft.office.work.manager.PolicyManager;
import com.bsoft.work.dto.PolicyDTO;
import com.bsoft.work.dto.PolicyQueryCndDTO;

import com.bsoft.work.service.PolicyService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @author Huang GH
 * @date 2021/5/11 18:03
 */
@Component
public class PolicyManagerImpl implements PolicyManager {

    @Autowired
    private IGenerator iGenerator;
    @Reference
    private PolicyService policyService;
    @Override
    public  Result<PolicyDTO> selectByQueryCnd(PolicyQueryCnd policyQueryCnd) {
        PolicyQueryCndDTO convert = iGenerator.convert(policyQueryCnd, PolicyQueryCndDTO.class);
        return policyService.selectByQueryCnd(convert);
    }
}
