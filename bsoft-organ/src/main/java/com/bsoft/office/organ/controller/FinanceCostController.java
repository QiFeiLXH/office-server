package com.bsoft.office.organ.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.organ.condition.FinanceCostQueryCnd;
import com.bsoft.office.organ.manager.FinanceCostManager;
import com.bsoft.office.organ.vo.FinanceCostViewVO;
import com.bsoft.office.common.annotation.RequiredExportLog;
import com.bsoft.office.common.condition.ExportLogParams;
import com.bsoft.office.common.exportExcel.ExportExcel;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-05-26 10:51
 * @Version 1.0
 * @Description
 */
@RestController
@RequestMapping("/financecost")
public class FinanceCostController {
    private static final Logger logger = LoggerFactory.getLogger(FinanceCostController.class);
    @Autowired
    private FinanceCostManager financeCostManager;
    @PostMapping(value = "/query")
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询项目报表")
    public OfficeResopnseBean getFinanceCostList(@RequestBody FinanceCostQueryCnd financeCostQueryCnd,
                                                HttpServletRequest request){
        String userId = ContextUtils.getUserId(request);
//        publicCostCnd.setUserId(userId);
        Result<FinanceCostViewVO> result = financeCostManager.getFinanceCostList(financeCostQueryCnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        logger.info("获取财务项目报表成功！[{}]", JSONUtils.toString(result));
        return responseBean;
    }

    /** 项目责任书管理列表-导出excel */
    @PostMapping(value = "/financedownload")
    @RequiredExportLog
    @OperLog(operType = OperLogType.EXPORT,operDesc = "导出项目报表")
    public void exportFinanceCostList(@RequestBody FinanceCostQueryCnd cnd,
                                      ExportLogParams params,
                                      HttpServletRequest request,
                                      HttpServletResponse response) {
        String userId = ContextUtils.getUserId(request);
//        cnd.setUserId(userId);
        List<FinanceCostViewVO> list = financeCostManager.exportFinanceCostList(cnd);
        ExportExcel.export(list,FinanceCostViewVO.class,"财务项目报表",response);
    }
}
