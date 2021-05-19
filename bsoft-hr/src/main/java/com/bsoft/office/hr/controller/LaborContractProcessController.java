package com.bsoft.office.hr.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.common.vo.ActionRecordVO;
import com.bsoft.office.hr.condition.LaborContractProcessTaskQueryCnd;
import com.bsoft.office.hr.manager.LaborContractRenewalManager;
import com.bsoft.office.hr.vo.LaborContractApplyViewVO;
import com.bsoft.office.hr.vo.LaborContractProcessTaskVO;
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
 * @author: zy
 * @date: 2020/12/14
 * @description 劳动合同流程查询
 * @version 1.0
 */
@RestController
@RequestMapping("/laborcontract/process")
public class LaborContractProcessController {
    private final static Logger LOGGER = LoggerFactory.getLogger(LaborContractProcessController.class);
    @Autowired
    private LaborContractRenewalManager laborContractRenewalManager;

    @GetMapping("/tasklist")
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询合同流程任务列表")
    public OfficeResopnseBean getTaskList(LaborContractProcessTaskQueryCnd queryCnd, HttpServletRequest request) {
        LOGGER.info("劳动合同流程查询——获取流程任务列表[{}]", JSONUtils.toString(queryCnd));
        String userId = ContextUtils.getUserId(request);
        Result<LaborContractProcessTaskVO> result = laborContractRenewalManager.getProcessTaskList(userId, queryCnd);
        return OfficeResopnseBean.newSuccessBean(result);
    }

    @GetMapping("/actionrecord")
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询劳动合同流程操作信息")
    public OfficeResopnseBean getActionRecordInfo(String processInstanceId, HttpServletRequest request) {
        LOGGER.info("劳动合同流程查询——获取流程操作信息列表[{}]", processInstanceId);
        String userId = ContextUtils.getUserId(request);
        List<ActionRecordVO> list = laborContractRenewalManager.getActionRecords(userId, processInstanceId);
        return OfficeResopnseBean.newSuccessBean(list);
    }

    @GetMapping("/laborcontract")
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询劳动合同申请信息")
    public OfficeResopnseBean getLaborContractInfo(@RequestParam("laborContractId") Integer laborContractId, HttpServletRequest request) {
        LOGGER.info("劳动合同流程查询——获取合同申请信息[{}]", laborContractId);
        String userId = ContextUtils.getUserId(request);
        LaborContractApplyViewVO laborContractInfo = laborContractRenewalManager.getLaborContractApplyView(userId, laborContractId);
        return OfficeResopnseBean.newSuccessBean(laborContractInfo);
    }
}
