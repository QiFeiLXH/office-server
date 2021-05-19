package com.bsoft.office.sales.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.sales.manager.CooperationAgreementManager;
import com.bsoft.office.sales.vo.SalesPartnerVO;
import com.bsoft.office.sales.vo.SalesPartnerViewVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Xuhui Lin
 * @Date 2020/6/30 10:37
 * @Description
 */
@RestController
@RequestMapping("/unitpartner")
public class CooperationPartnerController {
    private static final Logger logger = LoggerFactory.getLogger(CooperationPartnerController.class);

    @Autowired
    private CooperationAgreementManager cooperationAgreementManager;

    /** 合作单位列表查询 */
    @GetMapping(value = "/partner")
    @OperLog(operType = OperLogType.QUERY,operDesc = "合作单位列表查询")
    public OfficeResopnseBean getSalesPartnerList(String inputContent,Integer pageNo,Integer pageSize) {
        Result<SalesPartnerViewVO> result = cooperationAgreementManager.getSalesPartnerList(inputContent,pageNo,pageSize);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        logger.info("获取合作单位列表成功！[{}]", JSONUtils.toString(result));
        return responseBean;
    }

    /** 保存合作单位 */
    @PostMapping(value = "/savepartner")
    @OperLog(operType = OperLogType.MODIFY,operDesc = "保存合作单位")
    public OfficeResopnseBean saveSalesPartner(@RequestBody SalesPartnerVO partner,
                                               @RequestParam(name="provinceText", required = false) String provinceText,
                                               @RequestParam(name="cityText", required = false) String cityText,
                                               @RequestParam(name="countyText", required = false) String countyText) {
        if (cityText == null) {
            cityText = "";
        }
        Integer id = cooperationAgreementManager.saveSalesPartner(partner,provinceText,cityText,countyText);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(id);
        logger.info("保存合作单位成功！id：[{}]", JSONUtils.toString(id));
        return responseBean;
    }

    /** 删除合作单位 */
    @DeleteMapping(value = "/deletepartner")
    @OperLog(operType = OperLogType.DELETE,operDesc = "删除合作单位")
    public OfficeResopnseBean deleteSalesPartner(Integer id) {
        cooperationAgreementManager.deleteSalesPartner(id);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody("删除合作单位成功！");
        logger.info("删除合作单位成功！id:[{}]", JSONUtils.toString(id));
        return responseBean;
    }

}
