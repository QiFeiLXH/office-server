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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


/**
 * @Author Xuhui Lin
 * @Date 2020/4/20 17:39
 * @Description 部门对公费用查询
 */
@RestController
@RequestMapping("/publiccost")
public class PublicCostController {
    private static Logger logger  = LoggerFactory.getLogger(PublicCostController.class);

    @Autowired
    private BankChargesManager bankChargesManager;

    /**
     *功能描述: 对公费用（中标服务费）查询
     */
    @PostMapping(value = "/query")
    @OperLog(operType = OperLogType.QUERY,operDesc = "对公费用（中标服务费）列表")
    public OfficeResopnseBean getPublicCostList(@RequestBody PublicCostCnd publicCostCnd,
                                                             HttpServletRequest request){
        String userId = ContextUtils.getUserId(request);
        publicCostCnd.setUserId(userId);
        Result<DeptPublicCostVO> result = bankChargesManager.getPublicCostList(publicCostCnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        logger.info("获取对公费用（中标服务费）列表成功！[{}]", JSONUtils.toString(result));
        return responseBean;
    }

    /**
     * 根据id获取银行费用详情信息
     * @param id
     * @return
     */
    @GetMapping(value = "/getdetail")
    @OperLog(operType = OperLogType.QUERY,operDesc = "银行费用详情")
    public OfficeResopnseBean getBondInfoById(@RequestParam("id") Integer id){
        DeptPublicCostVO voResult = bankChargesManager.getPublicCostDetail(id);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(voResult);
        logger.info("获取id为:{}的银行费用详情成功", id);
        return responseBean;
    }

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
