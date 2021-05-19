package com.bsoft.office.project.manager.impl;

import com.bosft.progress.dto.*;
import com.bsoft.common.result.Result;
import com.bsoft.exception.ServiceException;
import com.bsoft.office.common.dozer.GeneratorUtil;
import com.bsoft.office.common.manager.ServerDateManager;
import com.bsoft.office.project.condition.ProgressReportQueryCnd;
import com.bsoft.office.project.manager.ProgressReportManager;
import com.bsoft.office.project.vo.*;
import com.bsoft.progress.service.ProgressReportService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2021/4/19 13:20
 * @Description:
 */
@Service
public class ProgressReportManagerImpl implements ProgressReportManager {

    @Reference(check = false)
    private ProgressReportService reportService;
    @Autowired
    private GeneratorUtil generatorUtil;
    @Autowired
    private ServerDateManager serverDateManager;

    @Override
    public Result<ProgressReportViewVO> findProjectProgressList(ProgressReportQueryCnd cnd) {
        ProgressReportQueryCndDTO cndDTO = generatorUtil.convert(cnd,ProgressReportQueryCndDTO.class);
        Result<ProgressReportViewDTO> result = reportService.findProgressList(cndDTO);
        return generatorUtil.convert(result,ProgressReportViewVO.class);
    }

    @Override
    public ProgressReportViewVO getProjectProgress(String projectId) {
        ProgressReportViewDTO progressReportViewDTO = reportService.getProjectProgress(projectId);
        return generatorUtil.convert(progressReportViewDTO,ProgressReportViewVO.class);
    }

    @Override
    public List<ProjectReportTypeViewVO> findReportTypeList(String projectId) {
        List<ProjectReportTypeViewDTO> typeViewDTOS = reportService.findReportTypeList(projectId);
        return generatorUtil.convert(typeViewDTOS,ProjectReportTypeViewVO.class);
    }

    @Override
    public List<ProProgressNodeVO> getColumnsHeader(String projectId,Integer reportTypeId,Date progressMonth) {
        List<ProProgressNodeDTO> proProgressNodeDTOS = reportService.getColumnHeader(projectId,reportTypeId,progressMonth);
        return generatorUtil.convert(proProgressNodeDTOS,ProProgressNodeVO.class);
    }

    @Override
    public List<ProReportProgressVO> getMonthProgress(String projectId, Date month, Integer reportType,String inputContent) {
        List<ProReportProgressDTO> proReportProgressDTOS = reportService.getMonthProgress(projectId, month, reportType,inputContent);
        return generatorUtil.convert(proReportProgressDTOS,ProReportProgressVO.class);
    }

    @Override
    public boolean checkHasReport(String projectId, Date month) {
        return reportService.checkHasReport(projectId,month);
    }

    @Override
    public void addReportProgress(String projectId, Date month,String reporter,String reporterName) {
        if (checkDate(month)){
            if (!reportService.checkHasReport(projectId,month)){
                reportService.addReportProgress(projectId, month,reporter,reporterName);
            }
        }
    }

    @Override
    public void reportProgress(ReportProgressSaveVO saveVO,Date progressMonth) {
        if (checkDate(progressMonth)){
            ReportProgressSaveDTO saveDTO = generatorUtil.convert(saveVO,ReportProgressSaveDTO.class);
            reportService.reportProgress(saveDTO);
        }
    }

    @Override
    public boolean checkDate(Date progressMonth){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(progressMonth);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) +1;

        java.sql.Date sysDate = serverDateManager.getServerDate();
        Calendar sysCalendar = Calendar.getInstance();
        sysCalendar.setTime(sysDate);
        int sysYear = sysCalendar.get(Calendar.YEAR);
        int sysMonth = sysCalendar.get(Calendar.MONTH) +1;
        int sysDay = sysCalendar.get(Calendar.DAY_OF_MONTH);

        if (sysDay > 5){//5号之后只能上报当月的
            if (year == sysYear && month == sysMonth){
                return true;
            }else{
                return false;
            }
        }else{//5号之前及5号只能上报上月份的
            if (year == sysYear && month == (sysMonth - 1)){
                return true;
            }else{
                return false;
            }
        }
    }
}
