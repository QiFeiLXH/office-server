package com.bsoft.office.sales.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.sales.condition.OriginalAcceptanceQueryCndVO;
import com.bsoft.office.sales.manager.OriginalAcceptanceManager;
import com.bsoft.office.sales.vo.OriginalAcceptanceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/7/29 16:12
 * @Description: 财务接收
 */
@RestController
@RequestMapping(value = "/financialaccept")
public class FinancialAcceptanceController {
    @Autowired
    private OriginalAcceptanceManager originalAcceptanceManager;

    /**
     * 财务接收审核列表
     *  @param cndVO
     * @return
     */
    @RequestMapping(value = "financelist",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.QUERY,operDesc = "财务接收查询列表")
    public OfficeResopnseBean getFinancialReceptionList(@RequestBody OriginalAcceptanceQueryCndVO cndVO){
        Result<OriginalAcceptanceVO> originalAcceptanceVOResult = originalAcceptanceManager.getFinancialReceptionList(cndVO);
        return OfficeResopnseBean.newSuccessBean(originalAcceptanceVOResult);
    }

    /**
     * 财务接收
     * @param words 文档记录列表
     * @return
     */
    @RequestMapping(value = "/financialaudit",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.MODIFY,operDesc = "财务接收审核文档")
    public OfficeResopnseBean auditFinancialReception(@RequestBody List<OriginalAcceptanceVO> words, HttpServletRequest request){
        String userId = ContextUtils.getUserId(request);
        originalAcceptanceManager.auditFinancialReception(words,userId);
        return OfficeResopnseBean.newSuccessBean();
    }

}
