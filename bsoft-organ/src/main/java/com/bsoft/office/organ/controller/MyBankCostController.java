package com.bsoft.office.organ.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.organ.condition.PublicCostCnd;
import com.bsoft.office.organ.manager.BankChargesManager;
import com.bsoft.office.organ.vo.DeptPublicCostVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


/**
 * @Author Xuhui Lin
 * @Date 2020/4/20 17:39
 * @Description 我的银行费用
 */
@RestController
@RequestMapping("/mybankcost")
public class MyBankCostController {
    private static Logger logger  = LoggerFactory.getLogger(MyBankCostController.class);

    @Autowired
    private BankChargesManager bankChargesManager;

    /**
     *功能描述: 对公费用（中标服务费）查询
     */
    @PostMapping(value = "/personalquery")
    @OperLog(operType = OperLogType.QUERY,operDesc = "对公费用（中标服务费）列表")
    public OfficeResopnseBean getPersonalPublicCostList(@RequestBody PublicCostCnd publicCostCnd,
                                                HttpServletRequest request){
        String userId = ContextUtils.getUserId(request);
        publicCostCnd.setUserId(userId);
        Result<DeptPublicCostVO> result = bankChargesManager.getPersonalPublicCostList(publicCostCnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        logger.info("获取对公费用（中标服务费）列表成功！[{}]", JSONUtils.toString(result));
        return responseBean;
    }
}
