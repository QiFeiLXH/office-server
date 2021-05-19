package com.bsoft.office.project.controller;

import com.bosft.progress.dto.ProjectReportCountQueryCndDTO;
import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.RequiredExportLog;
import com.bsoft.office.common.condition.ExportLogParams;
import com.bsoft.office.common.exportExcel.ExportExcel;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.project.condition.ProjectReportQueryCnd;
import com.bsoft.office.project.manager.ContractLevelAllManager;
import com.bsoft.office.project.manager.ProjectLevelAllManager;
import com.bsoft.office.project.manager.ProjectReportCountViewManager;
import com.bsoft.office.project.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/reportcount")
@Slf4j
public class ProjectReportCountViewController {
    @Autowired
    private ProjectReportCountViewManager projectReportCountViewManager;

    /**
     *获取项目上报统计情况
     */
    @GetMapping(value = "/getreportcountview")
    public OfficeResopnseBean findProjectLevelAllSubtotal(ProjectReportCountQueryCndDTO queryCnd){
        try {
            if(queryCnd.getProgressMonthStr()!=null){
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                queryCnd.setProgressMonth(format.parse(queryCnd.getProgressMonthStr()));;
            }
            Result<ProjectReportCountViewVO> result = projectReportCountViewManager.getprojectReportCountViews(queryCnd);
            OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
            responseBean.setBody(result);
            log.info(JSONUtils.toString(result));
            return responseBean;
        } catch (ParseException e) {
            return OfficeResopnseBean.newFailBean(500,"日期格式错误!");
        }
    }
}
