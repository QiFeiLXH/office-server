package com.bsoft.office.hr.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.hr.condition.VacationReduceQueryCnd;
import com.bsoft.office.hr.manager.VacationReduceManager;
import com.bsoft.office.hr.vo.VacationReduceVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/vacation/reduce")
public class VacationReduceController {

    private static final Logger LOGGER = LoggerFactory.getLogger(VacationReduceController.class);
    @Autowired
    private VacationReduceManager vacationReduceManager;

    @GetMapping("/query")
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询年假扣除信息")
    public OfficeResopnseBean getVacationReduceInfo(VacationReduceQueryCnd cnd, HttpServletRequest request) {
        String personId = ContextUtils.getUserId(request);
        LOGGER.info("获取年假扣除信息--参数[{}]", JSONUtils.toString(cnd));
        Result<VacationReduceVO> result = vacationReduceManager.getVacationReduceList(personId,cnd);
        LOGGER.info("获取年假扣除信息--结果[{}]", JSONUtils.toString(result));
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        return responseBean;
    }

    @PostMapping("/save")
    @OperLog(operType = OperLogType.SAVE,operDesc = "保存年假扣除信息")
    public OfficeResopnseBean updateVacationReduce(@RequestBody VacationReduceVO vacationReduceVO,HttpServletRequest request) {
        String personId = ContextUtils.getUserId(request);
        LOGGER.info("保存年假扣除信息--参数[{}]", JSONUtils.toString(vacationReduceVO));
        vacationReduceManager.save(personId,vacationReduceVO);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        return responseBean;
    }

    @PostMapping("/delete")
    @OperLog(operType = OperLogType.DELETE,operDesc = "删除年假扣除信息")
    public OfficeResopnseBean deleteVacationReduce(@RequestBody VacationReduceVO vacationReduceVO,HttpServletRequest request) {
        String personId = ContextUtils.getUserId(request);
        LOGGER.info("删除年假扣除信息--参数[{}]", JSONUtils.toString(vacationReduceVO));
        vacationReduceManager.delete(personId,vacationReduceVO);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        return responseBean;
    }

    @RequestMapping(value = "/reduce",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.MODIFY,operDesc = "扣除年假")
    public OfficeResopnseBean reduceAnnualVacationUnified(@RequestParam("year") String year, @RequestParam("days") Integer days,@RequestParam("reduceId") Integer reduceId, HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        vacationReduceManager.reduceAnnualVacationUnified(personId,year,days,reduceId);
        return OfficeResopnseBean.newSuccessBean();
    }


}
