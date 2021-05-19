package com.bsoft.office.project.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.project.condition.ProgressReportQueryCnd;
import com.bsoft.office.project.vo.*;

import java.util.Date;
import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2021/4/19 13:20
 * @Description:
 */
public interface ProgressReportManager {

   Result<ProgressReportViewVO> findProjectProgressList(ProgressReportQueryCnd cnd);

   ProgressReportViewVO getProjectProgress(String projectId);

   List<ProjectReportTypeViewVO> findReportTypeList(String projectId);

   List<ProProgressNodeVO> getColumnsHeader(String projectId,Integer reportTypeId,Date progressMonth);

   List<ProReportProgressVO> getMonthProgress(String projectId, Date month,Integer reportType,String inputContent);

   boolean checkHasReport(String projectId, Date month);

   void addReportProgress(String projectId, Date month,String reporter,String reporterName);

   void reportProgress(ReportProgressSaveVO saveVO,Date progressMonth);

   boolean checkDate(Date progressMonth);
}
