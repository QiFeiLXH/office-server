package com.bsoft.office.work.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.work.condition.PolicyQueryCnd;
import com.bsoft.work.dto.PolicyDTO;


/**
 * @author Huang GH
 * @date 2021/5/11 18:00
 */
public interface PolicyManager {

    Result<PolicyDTO> selectByQueryCnd(PolicyQueryCnd policyQueryCnd);
}
