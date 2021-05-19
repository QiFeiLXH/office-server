package com.bsoft.office.project.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.project.condition.ProjectReportQueryCnd;
import com.bsoft.office.project.vo.*;

import java.util.List;

/**
 * @BelongsProject: bsoft-office-server
 * @BelongsPackage: com.bsoft.office.project.manager
 * @Author: Xuhui Lin
 * @CreateTime: 2020-04-02 09:36
 * @Description:
 */
public interface ContractLevelAllManager {
    Result<ContractLevelAllSubtotalVO> findContractLevelAllSubtotal(ProjectReportQueryCnd queryCnd);

    List<ContractLevelAllSubtotalVO> exportContractLevelAllSubtotal(ProjectReportQueryCnd queryCnd);

    Result<ContractLevelAllByYearVO> findContractLevelAllYear(ProjectReportQueryCnd queryCnd);

    List<ContractLevelAllByYearVO> exportContractLevelAllYear(ProjectReportQueryCnd queryCnd);

    Result<ContractLevelAllByMonthVO> findContractLevelAllMonth(ProjectReportQueryCnd queryCnd);

    List<ContractLevelAllByMonthVO> exportContractLevelAllMonth(ProjectReportQueryCnd queryCnd);

    Result<ContractLevelDepTypeSubtotalVO> findContractLevelAllDepSubtotal(ProjectReportQueryCnd queryCnd);

    List<ContractLevelDepTypeSubtotalVO> exportContractLevelAllDepSubtotal(ProjectReportQueryCnd queryCnd);

    Result<ContractLevelDepTypeByYearVO> findContractLevelAllDepYear(ProjectReportQueryCnd queryCnd);

    List<ContractLevelDepTypeByYearVO> exportContractLevelAllDepYear(ProjectReportQueryCnd queryCnd);

    Result<ContractLevelDepTypeByMonthVO> findContractLevelAllDepMonth(ProjectReportQueryCnd queryCnd);

    List<ContractLevelDepTypeByMonthVO> exportContractLevelAllDepMonth(ProjectReportQueryCnd queryCnd);
}
