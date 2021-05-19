package com.bsoft.office.sales.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.manager.AuthorityPublicManager;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.sales.condition.SalesContractAuditCndVO;
import com.bsoft.office.sales.condition.SalesContractCheckQueryCndVO;
import com.bsoft.office.sales.manager.ContractModuleManager;
import com.bsoft.office.sales.vo.SalesContractAreaViewVO;
import com.bsoft.office.sales.vo.SalesContractCheckViewVO;
import com.bsoft.office.sales.vo.SalesContractModuleCheckViewVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2021/4/19 15:29
 * @Description
 */
@RestController
@RequestMapping("/salescontractcheck")
public class SalesContractModuleCheckController {
    @Autowired
    private ContractModuleManager contractModuleManager;
    @Autowired
    private AuthorityPublicManager authorityPublicManager;

    @GetMapping(value = "/contract")
    @OperLog(operType = OperLogType.QUERY,operDesc = "核对合同查询")
    public OfficeResopnseBean getSalesCheckContractList(SalesContractCheckQueryCndVO cnd,HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        Integer menuId = ContextUtils.getMenuId(request);
        cnd.setPersonId(userId);
        boolean allPermission = authorityPublicManager.checkAllPermission(userId, menuId, 1);
        cnd.setAllPermission(allPermission);
        Result<SalesContractCheckViewVO> result = contractModuleManager.getSalesCheckContractList(cnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        return responseBean;
    }

    @GetMapping(value = "/module")
    @OperLog(operType = OperLogType.QUERY,operDesc = "核对合同模块查询")
    public OfficeResopnseBean getSalesCheckContractModuleList(Integer pageNo, Integer pageSize, String contractId) {
        Result<SalesContractModuleCheckViewVO> result = contractModuleManager.getSalesCheckContractModuleList(pageNo, pageSize, contractId);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        return responseBean;
    }

    @GetMapping(value = "/check")
    @OperLog(operType = OperLogType.OTHER,operDesc = "合同核对")
    public OfficeResopnseBean checkSalesContract(String contractId, HttpServletRequest request) {
        String personId = ContextUtils.getUserId(request);
        contractModuleManager.checkSalesContract(contractId, personId);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody("核对成功！");
        return responseBean;
    }

    @GetMapping(value = "/uncheckedcount")
    @OperLog(operType = OperLogType.OTHER,operDesc = "合同核对")
    public OfficeResopnseBean getUncheckedCount(HttpServletRequest request) {
        String personId = ContextUtils.getUserId(request);
        Integer menuId = ContextUtils.getMenuId(request);
        boolean allPermission = authorityPublicManager.checkAllPermission(personId, menuId, 1);
        Integer count = contractModuleManager.getUncheckedCount(personId,allPermission);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(count);
        return responseBean;
    }
}
