package com.bsoft.office.hr.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.hr.condition.WorkVacationQueryCnd;
import com.bsoft.office.hr.manager.WorkVacationManager;
import com.bsoft.office.hr.vo.WorkVacationTotalViewVO;
import com.bsoft.office.hr.vo.WorkVacationVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: zy
 * @date: 2020/8/20
 * @description 员工加班调休假controller
 */
@RestController
@RequestMapping("/personalvacation")
public class PersonalWorkVacationController {
    private static final Logger logger = LoggerFactory.getLogger(PersonalWorkVacationController.class);

    @Autowired
    private WorkVacationManager workVacationManager;

    /**
     * 查询调休假（我的总览）
     */
    @GetMapping("/query/total/mine")
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询总调休假")
    public OfficeResopnseBean getWorkVacationTotalMine(WorkVacationQueryCnd cnd, HttpServletRequest request) {
        logger.info("查询调休假（总览）--参数[{}]", JSONUtils.toString(cnd));
        cnd.setPersonId(ContextUtils.getUserId(request));
        Result<WorkVacationTotalViewVO> result = workVacationManager.getWorkVacationTotal(cnd);
        logger.info("查询调休假（总览）--结果[{}]", JSONUtils.toString(result));
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        return responseBean;
    }

    /**
     * 查询调休假（我的）
     */
    @GetMapping("/query/mine")
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询调休假")
    public OfficeResopnseBean getWorkVacationMine(WorkVacationQueryCnd cnd, HttpServletRequest request) {
        logger.info("查询调休假（我的）--参数[{}]", JSONUtils.toString(cnd));
        cnd.setPersonId(ContextUtils.getUserId(request));
        Result<WorkVacationVO> result = workVacationManager.getWorkVacationPersonal(cnd);
        logger.info("查询调休假（我的）--结果[{}]", JSONUtils.toString(result));
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        return responseBean;
    }
}
