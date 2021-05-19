package com.bsoft.office.sales.controller;


import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.sales.condition.SalesPlanQueryCndVO;
import com.bsoft.office.sales.manager.SalesCluesManager;
import com.bsoft.office.sales.manager.SalesPlanManager;
import com.bsoft.office.common.vo.ActionRecordVO;
import com.bsoft.office.sales.vo.SalesCluesViewVO;
import com.bsoft.office.sales.vo.SalesPlanAmountVO;
import com.bsoft.office.sales.vo.SalesPlanVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/salesplan")
public class SalesPlanController {
    private final  static Logger LOGGER = LoggerFactory.getLogger(SalesPlanController.class);
    @Autowired
    private SalesPlanManager salesPlanManager;
    @Autowired
    private SalesCluesManager salesCluesManager;

    @RequestMapping(value = "/getlist",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询销售计划列表")
    public OfficeResopnseBean getSalesPlan(@RequestBody SalesPlanQueryCndVO salesPlanQueryCndVO, HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        salesPlanQueryCndVO.setTrackPerson(personId);
        Result<SalesPlanVO> result = salesPlanManager.getSalesPlan(personId, salesPlanQueryCndVO);
        SalesPlanAmountVO salesPlanAmountVO = salesPlanManager.getSalesPlanAmount(personId, salesPlanQueryCndVO);
        OfficeResopnseBean resopnseBean = OfficeResopnseBean.newSuccessBean();
        Map<String,Object> res = new HashMap<>();
        res.put("salesPlan",result);
        res.put("amount",salesPlanAmountVO);
        resopnseBean.setBody(res);
        LOGGER.info("工号:{}获取销售计划列表成功",new Object[]{personId});
        return resopnseBean;
    }

    @RequestMapping(value = "/getclues",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询本人的销售销售列表")
    public OfficeResopnseBean getClues(HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        List<SalesCluesViewVO> list = salesPlanManager.getClues(personId);
        OfficeResopnseBean resopnseBean = OfficeResopnseBean.newSuccessBean();
        resopnseBean.setBody(list);
        LOGGER.info("工号:{}获取本人的销售线索列表成功",new Object[]{personId});
        return resopnseBean;
    }

    @RequestMapping(value = "/saveall",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.SAVE,operDesc = "保存销售计划并发起审核流程")
    public OfficeResopnseBean getSalesPlan(@RequestBody List<SalesPlanVO> salesPlanVOS, HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        salesPlanManager.save(personId,salesPlanVOS);
        OfficeResopnseBean resopnseBean = OfficeResopnseBean.newSuccessBean();
        LOGGER.info("工号:{}提交保存销售计划并发起审核流程成功",new Object[]{personId});
        return resopnseBean;

    }

    /**
     * 销售线索  获取基本信息
     */
    @RequestMapping(value = "/getclue",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询销售线索基本信息")
    public OfficeResopnseBean getClue(@RequestParam Integer clueId, HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        SalesCluesViewVO clueInfo = salesCluesManager.getClue(personId,clueId);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        Map<String,Object> result = new HashMap<>();
        result.put("clueInfo",clueInfo);
        responseBean.setBody(result);
        LOGGER.info("获取销售线索基本信息");
        return responseBean;
    }

    /**
     * 销售计划获取审核流转信息
     */
    @RequestMapping(value = "/getrecord",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询销售计划审核流程操作信息")
    public OfficeResopnseBean getRecord(@RequestParam String processInstanceId, HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        List<ActionRecordVO> actionRecords = salesCluesManager.getActionRecords(personId,processInstanceId);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        Map<String,Object> result = new HashMap<>();
        result.put("actionRecords",actionRecords);
        responseBean.setBody(result);
        LOGGER.info("获取销售计划审核流程操作信息");
        return responseBean;
    }

    /**
     *  根据年份获取当年有数据的月份
     */
    @RequestMapping(value = "/getmonths",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询当年有数据的月份")
    public OfficeResopnseBean getMonths(@RequestParam String year, HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        List<String> list = salesPlanManager.getReportMonthWithYear(personId,year);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(list);
        return responseBean;
    }


}
