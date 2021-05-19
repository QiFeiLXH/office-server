package com.bsoft.office.organ.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.organ.manager.BankChargesManager;
import com.bsoft.office.organ.manager.BondManager;
import com.bsoft.office.organ.vo.BankChargesNoBillVO;
import com.bsoft.office.organ.vo.BondInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author zhanglf
 * @Date 2020-04-20 13:31
 * @Version 1.0
 * @Description
 */
@RestController
@RequestMapping(value="/cost")
public class CostController {
    private static Logger logger  = LoggerFactory.getLogger(CostController.class);
    @Autowired
    private BankChargesManager bankChargesManager;
    @Autowired
    private BondManager bondManager;

    @RequestMapping(value = "/nobill",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取对公费用，中标服务费未收到发票待办列表")
    public OfficeResopnseBean getBankChargesNoBill(@RequestParam("pageSize") Integer pageSize,
                                                   @RequestParam("pageNo") Integer pageNo,
                                                   @RequestParam("context") String context,
                                                   HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        Result<BankChargesNoBillVO> voResult = bankChargesManager.getBankChargesNoBill(personId,context,pageSize,pageNo);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(voResult);
        logger.info("工号：{}，获取对公费用，中标服务费未收到发票待办列表成功！",personId);
        return responseBean;
    }

    @RequestMapping(value = "/notrushaccount",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取保证金，履约保证金未冲账待办列表")
    public OfficeResopnseBean getBondNotRushAccount(@RequestParam("pageSize") Integer pageSize,
                                                    @RequestParam("pageNo") Integer pageNo,
                                                    @RequestParam("performanceSymbol") Integer performanceSymbol,
                                                    @RequestParam("context") String context,
                                                    HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        Result<BondInfoVO> voResult = bondManager.getBondNotRushAccount(personId,performanceSymbol,context,pageSize,pageNo);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(voResult);
        logger.info("工号：{}，获取保证金，履约保证金未冲账待办列表成功！",personId);
        return responseBean;
    }
}
