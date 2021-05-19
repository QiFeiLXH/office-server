package com.bsoft.office.project.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.dozer.GeneratorUtil;
import com.bsoft.office.project.condition.ProjectReportQueryCnd;
import com.bsoft.office.project.manager.ContractLevelManPowerMoneyManager;
import com.bsoft.office.project.vo.*;
import com.bsoft.project.report.dto.*;
import com.bsoft.project.report.service.ContractLevelManPowerMoneyService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractLevelManPowerMoneyManagerImpl implements ContractLevelManPowerMoneyManager {
    @Reference(timeout = 60000)
    ContractLevelManPowerMoneyService contractLevelManPowerMoneyService;
    @Autowired
    GeneratorUtil generatorUtil;
    @Override
    public Result<ContractLevelManPowerMoneyAllVO> getContractLevelmoneyloadAll(ProjectReportQueryCnd cnd) {
        Result<ContractLevelManPowerMoneyAllDTO> result = contractLevelManPowerMoneyService.findAllSubTotal(cnd.getStartYear(),cnd.getEndYear(),cnd.getPageNo(),cnd.getPageSize());
        Result<ContractLevelManPowerMoneyAllVO> result1 = generatorUtil.convert(result,ContractLevelManPowerMoneyAllVO.class);
        return result1;
    }

    @Override
    public List<ContractLevelManPowerMoneyAllVO> getContractLevelmoneyloadAllList(Integer startYear, Integer endYear) {
        List<ContractLevelManPowerMoneyAllDTO> result = contractLevelManPowerMoneyService.findAllSubTotalList(startYear, endYear);
        List<ContractLevelManPowerMoneyAllVO> result1 = generatorUtil.convert(result,ContractLevelManPowerMoneyAllVO.class);
        return result1;
    }

    @Override
    public Result<ContractLevelManPowerMoneyAllByYearVO> getContractLevelmoneyloadAllByYear(ProjectReportQueryCnd cnd) {
        Result<ContractLevelManPowerMoneyAllByYearDTO> result = contractLevelManPowerMoneyService.findAllGroupByYear(cnd.getStartYear(),cnd.getEndYear(),cnd.getPageNo(),cnd.getPageSize());
        Result<ContractLevelManPowerMoneyAllByYearVO> result1 = generatorUtil.convert(result,ContractLevelManPowerMoneyAllByYearVO.class);
        return result1;
    }

    @Override
    public List<ContractLevelManPowerMoneyAllByYearVO> getContractLevelmoneyloadAllByYearList(Integer startYear, Integer endYear) {
        List<ContractLevelManPowerMoneyAllByYearDTO> result = contractLevelManPowerMoneyService.findAllGroupByYearList(startYear, endYear);
        List<ContractLevelManPowerMoneyAllByYearVO> result1 = generatorUtil.convert(result,ContractLevelManPowerMoneyAllByYearVO.class);
        return result1;
    }

    @Override
    public Result<ContractLevelManPowerMoneyAllByMonthVO> getContractLevelmoneyloadAllByMonth(ProjectReportQueryCnd cnd) {
        Result<ContractLevelManPowerMoneyAllByMonthDTO> result = contractLevelManPowerMoneyService.findAllGroupByMonth(cnd.getStartYear(),cnd.getEndYear(),cnd.getPageNo(),cnd.getPageSize());
        Result<ContractLevelManPowerMoneyAllByMonthVO> result1 = generatorUtil.convert(result,ContractLevelManPowerMoneyAllByMonthVO.class);
        return result1;
    }

    @Override
    public List<ContractLevelManPowerMoneyAllByMonthVO> getContractLevelmoneyloadAllByMonthList(Integer startYear, Integer endYear) {
        List<ContractLevelManPowerMoneyAllByMonthDTO> result = contractLevelManPowerMoneyService.findAllGroupByMonthList(startYear, endYear);
        List<ContractLevelManPowerMoneyAllByMonthVO> result1 = generatorUtil.convert(result,ContractLevelManPowerMoneyAllByMonthVO.class);
        return result1;
    }

    @Override
    public Result<ContractLevelManPowerMoneyAllByDepVO> getContractLevelmoneyloadAllByDep(ProjectReportQueryCnd cnd) {
        Result<ContractLevelManPowerMoneyAllByDepDTO> result = contractLevelManPowerMoneyService.findDepTypeSubTotal(cnd.getStartYear(),cnd.getEndYear(),cnd.getPageNo(),cnd.getPageSize());
        Result<ContractLevelManPowerMoneyAllByDepVO> result1 = generatorUtil.convert(result, ContractLevelManPowerMoneyAllByDepVO.class);
        return result1;
    }

    @Override
    public List<ContractLevelManPowerMoneyAllByDepVO> getContractLevelmoneyloadAllByDepList(Integer startYear, Integer endYear) {
        List<ContractLevelManPowerMoneyAllByDepDTO> result = contractLevelManPowerMoneyService.findDepTypeSubTotalList(startYear, endYear);
        List<ContractLevelManPowerMoneyAllByDepVO> result1 = generatorUtil.convert(result, ContractLevelManPowerMoneyAllByDepVO.class);
        return result1;
    }

    @Override
    public Result<ContractLevelManPowerMoneyAllByDepByYearVO> getContractLevelmoneyloadAllVOByDepByYear(ProjectReportQueryCnd cnd) {
        Result<ContractLevelManPowerMoneyAllByDepByYearDTO> result = contractLevelManPowerMoneyService.findDepTypeGroupByYear(cnd.getStartYear(),cnd.getEndYear(),cnd.getPageNo(),cnd.getPageSize());
        Result<ContractLevelManPowerMoneyAllByDepByYearVO> result1 = generatorUtil.convert(result, ContractLevelManPowerMoneyAllByDepByYearVO.class);
        return result1;
    }

    @Override
    public List<ContractLevelManPowerMoneyAllByDepByYearVO> getContractLevelmoneyloadAllVOByDepByYearList(Integer startYear, Integer endYear) {
        List<ContractLevelManPowerMoneyAllByDepByYearDTO> result = contractLevelManPowerMoneyService.findDepTypeGroupByYearList(startYear, endYear);
        List<ContractLevelManPowerMoneyAllByDepByYearVO> result1 = generatorUtil.convert(result, ContractLevelManPowerMoneyAllByDepByYearVO.class);
        return result1;
    }

    @Override
    public Result<ContractLevelManPowerMoneyAllByDepByMonthVO> getContractLevelmoneyloadAllVOByDepByMonth(ProjectReportQueryCnd cnd) {
        Result<ContractLevelManPowerMoneyAllByDepByMonthDTO> result = contractLevelManPowerMoneyService.findDepTypeGroupByMonth(cnd.getStartYear(),cnd.getEndYear(),cnd.getPageNo(),cnd.getPageSize());
        Result<ContractLevelManPowerMoneyAllByDepByMonthVO> result1 = generatorUtil.convert(result, ContractLevelManPowerMoneyAllByDepByMonthVO.class);
        return result1;
    }

    @Override
    public List<ContractLevelManPowerMoneyAllByDepByMonthVO> getContractLevelmoneyloadAllVOByDepByMonthList(Integer startYear, Integer endYear) {
        List<ContractLevelManPowerMoneyAllByDepByMonthDTO> result = contractLevelManPowerMoneyService.findDepTypeGroupByMonthList(startYear, endYear);
        List<ContractLevelManPowerMoneyAllByDepByMonthVO> result1 = generatorUtil.convert(result, ContractLevelManPowerMoneyAllByDepByMonthVO.class);
        return result1;
    }
}
