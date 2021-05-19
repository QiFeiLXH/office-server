package com.bsoft.office.project.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.project.condition.ProjectReportQueryCnd;
import com.bsoft.office.project.vo.*;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/4/26 14:16
 * @Description
 */
public interface ContractLevelBonusManager {
    Result<ContractLevelBonusAllSubtotalVO> getContractLevelBonusAllSubtotal(ProjectReportQueryCnd queryCnd);

    List<ContractLevelBonusAllSubtotalVO> exportContractLevelBonusAllSubtotal(ProjectReportQueryCnd queryCnd);

    Result<ContractLevelBonusAllByYearVO> getContractLevelBonusAllYear(ProjectReportQueryCnd queryCnd);

    List<ContractLevelBonusAllByYearVO> exportContractLevelBonusAllYear(ProjectReportQueryCnd queryCnd);

    Result<ContractLevelBonusAllByMonthVO> getContractLevelBonusAllMonth(ProjectReportQueryCnd queryCnd);

    List<ContractLevelBonusAllByMonthVO> exportContractLevelBonusAllMonth(ProjectReportQueryCnd queryCnd);

    Result<ContractLevelBonusDepTypeSubtotalVO> getContractLevelBonusDepSubtotal(ProjectReportQueryCnd queryCnd);

    List<ContractLevelBonusDepTypeSubtotalVO> exportContractLevelBonusDepSubtotal(ProjectReportQueryCnd queryCnd);

    Result<ContractLevelBonusDepTypeByYearVO> getContractLevelBonusDepYear(ProjectReportQueryCnd queryCnd);

    List<ContractLevelBonusDepTypeByYearVO> exportContractLevelBonusDepYear(ProjectReportQueryCnd queryCnd);

    Result<ContractLevelBonusDepTypeByMonthVO> getContractLevelBonusDepMonth(ProjectReportQueryCnd queryCnd);

    List<ContractLevelBonusDepTypeByMonthVO> exportContractLevelBonusDepMonth(ProjectReportQueryCnd queryCnd);
}
