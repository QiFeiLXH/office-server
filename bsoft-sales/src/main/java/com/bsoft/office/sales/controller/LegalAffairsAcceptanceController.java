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
 * @Description: 法务接收
 */
@RestController
@RequestMapping(value = "/legalaffairs")
public class LegalAffairsAcceptanceController {
    @Autowired
    private OriginalAcceptanceManager originalAcceptanceManager;

    /**
     * 法务接收
     * @param cndVO
     * @return
     */
    @RequestMapping(value = "legallist",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.QUERY,operDesc = "法务接收查询列表")
    public OfficeResopnseBean getLegalReceptionList(@RequestBody OriginalAcceptanceQueryCndVO cndVO){
        Result<OriginalAcceptanceVO> originalAcceptanceVOResult = originalAcceptanceManager.getLegalReceptionList(cndVO);
        return OfficeResopnseBean.newSuccessBean(originalAcceptanceVOResult);
    }

    /**
     * 法务接收
     * @param words
     * @return
     */
    @RequestMapping(value = "/legalaudit",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.MODIFY,operDesc = "法务接收审核文档")
    public OfficeResopnseBean auditLegalReception(@RequestBody List<OriginalAcceptanceVO> words, HttpServletRequest request){
        String userId = ContextUtils.getUserId(request);
        originalAcceptanceManager.auditLegalReception(words,userId);
        return OfficeResopnseBean.newSuccessBean();
    }
}
