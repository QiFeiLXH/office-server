package com.bsoft.office.project.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.project.condition.ProjectReportQueryCnd;
import com.bsoft.office.project.vo.*;

import java.util.List;

public interface ContractLevelManPowerMoneyManager {
    Result<ContractLevelManPowerMoneyAllVO> getContractLevelmoneyloadAll(ProjectReportQueryCnd cnd);
    List<ContractLevelManPowerMoneyAllVO> getContractLevelmoneyloadAllList(Integer startYear, Integer endYear);
    Result<ContractLevelManPowerMoneyAllByYearVO> getContractLevelmoneyloadAllByYear(ProjectReportQueryCnd cnd);
    List<ContractLevelManPowerMoneyAllByYearVO> getContractLevelmoneyloadAllByYearList(Integer startYear, Integer endYear);
    Result<ContractLevelManPowerMoneyAllByMonthVO> getContractLevelmoneyloadAllByMonth(ProjectReportQueryCnd cnd);
    List<ContractLevelManPowerMoneyAllByMonthVO> getContractLevelmoneyloadAllByMonthList(Integer startYear, Integer endYear);
    Result<ContractLevelManPowerMoneyAllByDepVO> getContractLevelmoneyloadAllByDep(ProjectReportQueryCnd cnd);
    List<ContractLevelManPowerMoneyAllByDepVO> getContractLevelmoneyloadAllByDepList(Integer startYear, Integer endYear);
    Result<ContractLevelManPowerMoneyAllByDepByYearVO> getContractLevelmoneyloadAllVOByDepByYear(ProjectReportQueryCnd cnd);
    List<ContractLevelManPowerMoneyAllByDepByYearVO> getContractLevelmoneyloadAllVOByDepByYearList(Integer startYear, Integer endYear);
    Result<ContractLevelManPowerMoneyAllByDepByMonthVO> getContractLevelmoneyloadAllVOByDepByMonth(ProjectReportQueryCnd cnd);
    List<ContractLevelManPowerMoneyAllByDepByMonthVO> getContractLevelmoneyloadAllVOByDepByMonthList(Integer startYear, Integer endYear);
}
