package com.bsoft.office.hr.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.hr.condition.LaborContractQueryCnd;
import com.bsoft.office.hr.manager.LaborContractRenewalManager;
import com.bsoft.office.hr.vo.LaborContractApplyViewVO;
import com.bsoft.office.hr.vo.LaborContractDetailViewVO;
import com.bsoft.office.hr.vo.LaborContractViewVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @version 1.0
 * @author: zy
 * @date: 2020/12/15
 * @description 劳动合同信息
 */
@RestController
@RequestMapping("/laborcontract")
public class LaborContractController {
    private final static Logger LOGGER = LoggerFactory.getLogger(LaborContractController.class);
    @Autowired
    private LaborContractRenewalManager laborContractRenewalManager;

    @GetMapping("/list")
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询劳动合同列表")
    public OfficeResopnseBean getLaborContractList(LaborContractQueryCnd queryCnd, HttpServletRequest request) {
        LOGGER.info("劳动合同——获取劳动合同列表[{}]", JSONUtils.toString(queryCnd));
        String userId = ContextUtils.getUserId(request);
        Result<LaborContractViewVO> result = laborContractRenewalManager.getLaborContractList(userId, queryCnd);
        return OfficeResopnseBean.newSuccessBean(result);
    }

    @GetMapping("/detail")
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询员工个人劳动合同申请列表")
    public OfficeResopnseBean getLaborContractDetail(@RequestParam("personId") String personId,
                                                   HttpServletRequest request) {
        LOGGER.info("劳动合同——获取员工个人劳动合同申请列表[{}]", personId);
        String userId = ContextUtils.getUserId(request);
        List<LaborContractDetailViewVO> list = laborContractRenewalManager.getLaborContractDetail(userId, personId);
        return OfficeResopnseBean.newSuccessBean(list);
    }
}
