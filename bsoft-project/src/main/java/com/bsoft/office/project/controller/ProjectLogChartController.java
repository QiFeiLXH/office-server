package com.bsoft.office.project.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.project.condition.ProjectLogChartQueryCnd;
import com.bsoft.office.project.manager.ProjectLogChartManager;
import com.bsoft.office.project.vo.ProjectLogChartMonthVO;
import com.bsoft.office.project.vo.ProjectLogChartVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: zy
 * @date: 2020/8/6 19:03
 */
@RestController
@RequestMapping("/logchart")
public class ProjectLogChartController {

    private static final Logger logger = LoggerFactory.getLogger(ProjectLogChartController.class);

    @Autowired
    private ProjectLogChartManager projectLogChartManager;

    @GetMapping("/query/day")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取结构化日志每日填写情况")
    public OfficeResopnseBean getLogChartList(ProjectLogChartQueryCnd queryCnd) {
        Result<ProjectLogChartVO> result =  projectLogChartManager.getLogChartList(queryCnd);
        logger.info("获取结构化日志每日填写情况[{}]", queryCnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        return responseBean;
    }

    @GetMapping("/query/month")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取结构化日志每月平均填写情况")
    public OfficeResopnseBean getLogChartMonthList(ProjectLogChartQueryCnd queryCnd) {
        Result<ProjectLogChartMonthVO> result =  projectLogChartManager.getLogChartMonthList(queryCnd);
        logger.info("获取结构化日志每月平均填写情况[{}]", queryCnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        return responseBean;
    }

}
