package com.bsoft.office.project.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.project.condition.ProjectReportQueryCnd;
import com.bsoft.office.project.vo.FinancialSubjectVO;

import java.util.List;
import java.util.Map;

/**
 * @Author Xuhui Lin
 * @Date 2020/4/26 14:17
 * @Description
 */
public interface ProjectLevelReimbursementManager {
    List<FinancialSubjectVO> getCostSubjectColumns();

    Result<Map<String, String>> findProjectLevelReimbursementCostAllSubtotal(ProjectReportQueryCnd queryCnd);

    Map<String, Object> exportProjectLevelReimbursementCostAllSubtotal(ProjectReportQueryCnd queryCnd);

    Result<Map<String, String>> findProjectLevelReimbursementCostAllYear(ProjectReportQueryCnd queryCnd);

    Map<String, Object> exportProjectLevelReimbursementCostAllYear(ProjectReportQueryCnd queryCnd);

    Result<Map<String, String>> findProjectLevelReimbursementCostAllMonth(ProjectReportQueryCnd queryCnd);

    Map<String, Object> exportProjectLevelReimbursementCostAllMonth(ProjectReportQueryCnd queryCnd);

    Result<Map<String, String>> findProjectLevelReimbursementCostDepSubtotal(ProjectReportQueryCnd queryCnd);

    Map<String, Object> exportProjectLevelReimbursementCostDepSubtotal(ProjectReportQueryCnd queryCnd);

    Result<Map<String, String>> findProjectLevelReimbursementCostDepYear(ProjectReportQueryCnd queryCnd);

    Map<String, Object> exportProjectLevelReimbursementCostDepYear(ProjectReportQueryCnd queryCnd);

    Result<Map<String, String>> findProjectLevelReimbursementCostDepMonth(ProjectReportQueryCnd queryCnd);

    Map<String, Object> exportProjectLevelReimbursementCostDepMonth(ProjectReportQueryCnd queryCnd);
}
