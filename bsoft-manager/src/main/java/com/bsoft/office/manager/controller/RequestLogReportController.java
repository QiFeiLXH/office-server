package com.bsoft.office.manager.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.manager.condition.RequestLogReportQueryCnd;
import com.bsoft.office.manager.manager.RequestLogReportManager;
import com.bsoft.office.manager.vo.RequestLogReportVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: zy
 * @date: 2020/10/27
 * @description
 */
@RestController
@RequestMapping("/app/requestlog")
public class RequestLogReportController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequestLogReportController.class);

    @Autowired
    private RequestLogReportManager requestLogReportManager;
    @Autowired
    private IGenerator iGenerator;

    @GetMapping("/menuchart")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取请求菜单统计图表")
    public OfficeResopnseBean getMenuCountForChart(RequestLogReportQueryCnd queryCnd, HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("[{}]获取请求菜单统计(图)[{}]", userId, JSONUtils.toString(queryCnd));
        List<RequestLogReportVO> result = requestLogReportManager.getMenuCountForChart(userId, queryCnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        return responseBean;
    }

    @GetMapping("/menutable")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取请求菜单统计列表")
    public OfficeResopnseBean getMenuCountForTable(RequestLogReportQueryCnd queryCnd, HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("[{}]获取请求菜单统计(表格)[{}]", userId, JSONUtils.toString(queryCnd));
        Result<RequestLogReportVO> result = requestLogReportManager.getMenuCountForTable(userId, queryCnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        return responseBean;
    }

    @GetMapping("/pathchart")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取请求路径统计图表")
    public OfficeResopnseBean getPathCountForChart(RequestLogReportQueryCnd queryCnd, HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("[{}]获取请求路径统计(图)[{}]", userId, JSONUtils.toString(queryCnd));
        List<RequestLogReportVO> result = requestLogReportManager.getPathCountForChart(userId, queryCnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        return responseBean;
    }

    @GetMapping("/pathtable")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取请求路径统计列表")
    public OfficeResopnseBean getPathCountForTable(RequestLogReportQueryCnd queryCnd, HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("[{}]获取请求路径统计(表格)[{}]", userId, JSONUtils.toString(queryCnd));
        Result<RequestLogReportVO> result = requestLogReportManager.getPathCountForTable(userId, queryCnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        return responseBean;
    }
}
