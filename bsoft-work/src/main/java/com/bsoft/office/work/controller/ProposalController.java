package com.bsoft.office.work.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.work.condition.PolicyQueryCnd;
import com.bsoft.office.work.manager.ManagerGroupManager;
import com.bsoft.office.work.manager.PolicyManager;
import com.bsoft.work.dto.ManagerGroupDTO;
import com.bsoft.work.dto.PolicyDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author Huang GH
 * @date 2021/5/10 13:52
 */
@RestController
@RequestMapping("/proposal")
public class ProposalController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProposalController.class);

    @Autowired
    private ManagerGroupManager managerGroupManager;
    @Autowired
    private PolicyManager policyManager;

    @GetMapping("/getManagerGroup")
    public OfficeResopnseBean getTest(PolicyQueryCnd policyQueryCnd) {
        List<ManagerGroupDTO> byQueryCnd = managerGroupManager.findByQueryCnd(policyQueryCnd);
        return OfficeResopnseBean.newSuccessBean(byQueryCnd);
    }

    @GetMapping("/getPolicyList")
    public OfficeResopnseBean getPolicyList(PolicyQueryCnd policyQueryCnd) {
        Result<PolicyDTO> policyDTOResult = policyManager.selectByQueryCnd(policyQueryCnd);
        return OfficeResopnseBean.newSuccessBean(policyDTOResult);
    }
}
