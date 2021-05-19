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
public interface ContractLevelReimbursementManager {
    List<FinancialSubjectVO> getCostSubjectColumns();

    Result<Map<String, String>> findContractLevelReimbursementCostAllSubtotal(ProjectReportQueryCnd queryCnd);

    Map<String, Object> exportContractLevelReimbursementCostAllSubtotal(ProjectReportQueryCnd queryCnd);

    Result<Map<String, String>> findContractLevelReimbursementCostAllYear(ProjectReportQueryCnd queryCnd);

    Map<String, Object> exportContractLevelReimbursementCostAllYear(ProjectReportQueryCnd queryCnd);

    Result<Map<String, String>> findContractLevelReimbursementCostAllMonth(ProjectReportQueryCnd queryCnd);

    Map<String, Object> exportContractLevelReimbursementCostAllMonth(ProjectReportQueryCnd queryCnd);

    Result<Map<String, String>> findContractLevelReimbursementCostDepSubtotal(ProjectReportQueryCnd queryCnd);

    Map<String, Object> exportContractLevelReimbursementCostDepSubtotal(ProjectReportQueryCnd queryCnd);

    Result<Map<String, String>> findContractLevelReimbursementCostDepYear(ProjectReportQueryCnd queryCnd);

    Map<String, Object> exportContractLevelReimbursementCostDepYear(ProjectReportQueryCnd queryCnd);

    Result<Map<String, String>> findContractLevelReimbursementCostDepMonth(ProjectReportQueryCnd queryCnd);

    Map<String, Object> exportContractLevelReimbursementCostDepMonth(ProjectReportQueryCnd queryCnd);
}
