package com.bsoft.office.project.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.project.condition.ProjectReportQueryCnd;
import com.bsoft.office.project.vo.*;

import java.util.List;

public interface ContractLevelworkloadManager {
    Result<ContractLevelworkloadAllVO> getContractLevelworkloadAll(ProjectReportQueryCnd cnd);
    List<ContractLevelworkloadAllVO> getContractLevelworkloadAllList(Integer startYear, Integer endYear);
    Result<ContractLevelworkloadAllByYearVO> getContractLevelworkloadAllByYear(ProjectReportQueryCnd cnd);
    List<ContractLevelworkloadAllByYearVO> getContractLevelworkloadAllByYearList(Integer startYear, Integer endYear);
    Result<ContractLevelworkloadAllByMonthVO> getContractLevelworkloadAllByMonth(ProjectReportQueryCnd cnd);
    List<ContractLevelworkloadAllByMonthVO> getContractLevelworkloadAllByMonthList(Integer startYear, Integer endYear);
    Result<ContractLevelworkloadAllByDepVO> getContractLevelworkloadAllByDep(ProjectReportQueryCnd cnd);
    List<ContractLevelworkloadAllByDepVO> getContractLevelworkloadAllByDepList(Integer startYear, Integer endYear);
    Result<ContractLevelworkloadAllByDepByYearVO> getContractLevelworkloadAllByDepByYear(ProjectReportQueryCnd cnd);
    List<ContractLevelworkloadAllByDepByYearVO> getContractLevelworkloadAllByDepByYearList(Integer startYear, Integer endYear);
    Result<ContractLevelworkloadAllByDepByMonthVO> getContractLevelworkloadAllByDepByMonth(ProjectReportQueryCnd cnd);
    List<ContractLevelworkloadAllByDepByMonthVO> getContractLevelworkloadAllByDepByMonthList(Integer startYear, Integer endYear);
}
