package com.bsoft.office.sales.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.manager.AuthorityPublicManager;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.sales.condition.SalesContractAuditCndVO;
import com.bsoft.office.sales.manager.ContractModuleManager;
import com.bsoft.office.sales.vo.SalesContractAreaViewVO;
import com.bsoft.office.sales.vo.SalesContractViewVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2021/3/29 17:28
 * @Description
 */
@RestController
@RequestMapping("/salescontractaudit")
public class SalesContractModuleAuditController {
    @Autowired
    private ContractModuleManager contractModuleManager;
    @Autowired
    private AuthorityPublicManager authorityPublicManager;

    @GetMapping(value = "/depts")
    @OperLog(operType = OperLogType.QUERY,operDesc = "合同审核销售区域查询")
    public OfficeResopnseBean getSalesContractAreaList(HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        Integer menuId = ContextUtils.getMenuId(request);
        SalesContractAuditCndVO cnd = new SalesContractAuditCndVO();
        boolean allPermission = authorityPublicManager.checkAllPermission(userId, menuId, 1);
        cnd.setPersonId(userId);
        cnd.setAllPermission(allPermission);
        List<SalesContractAreaViewVO> list = contractModuleManager.getSalesContractAreaList(cnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(list);
        return responseBean;
    }

    @GetMapping(value = "/contracts")
    @OperLog(operType = OperLogType.QUERY,operDesc = "合同审核列表查询")
    public OfficeResopnseBean getSalesContractAuditList(HttpServletRequest request,SalesContractAuditCndVO cnd) {
        String userId = ContextUtils.getUserId(request);
        Integer menuId = ContextUtils.getMenuId(request);
        boolean allPermission = authorityPublicManager.checkAllPermission(userId, menuId, 1);
        cnd.setPersonId(userId);
        cnd.setAllPermission(allPermission);
        Result<SalesContractViewVO> list = contractModuleManager.getSalesContractAuditList(cnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(list);
        return responseBean;
    }

    @GetMapping(value = "/audit")
    @OperLog(operType = OperLogType.OTHER,operDesc = "合同审核")
    public OfficeResopnseBean auditSalesContract(String contractId) {
        contractModuleManager.auditSalesContract(contractId);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody("审核成功");
        return responseBean;
    }

    @GetMapping(value = "/back")
    @OperLog(operType = OperLogType.OTHER,operDesc = "合同退回")
    public OfficeResopnseBean returnSalesContract(String contractId, String backReason) {
        contractModuleManager.returnSalesContract(contractId, backReason);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody("退回成功");
        return responseBean;
    }
}
