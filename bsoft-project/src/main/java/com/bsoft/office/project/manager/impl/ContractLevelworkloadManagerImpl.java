package com.bsoft.office.project.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.dozer.GeneratorUtil;
import com.bsoft.office.project.condition.ProjectReportQueryCnd;
import com.bsoft.office.project.manager.ContractLevelworkloadManager;
import com.bsoft.office.project.vo.*;
import com.bsoft.project.report.dto.*;
import com.bsoft.project.report.service.ContractLevelWorkloadService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractLevelworkloadManagerImpl implements ContractLevelworkloadManager {

    @Reference(timeout = 60000)
    private ContractLevelWorkloadService contractLevelWorkloadService;
    @Autowired
    private GeneratorUtil generatorUtil;

    @Override
    public Result<ContractLevelworkloadAllVO> getContractLevelworkloadAll(ProjectReportQueryCnd cnd) {
        Result<ContractLevelworkloadAllDTO> result = contractLevelWorkloadService.findAllSubTotal(cnd.getStartYear(),cnd.getEndYear(),cnd.getPageNo(),cnd.getPageSize());
        Result<ContractLevelworkloadAllVO> result1 = generatorUtil.convert(result,ContractLevelworkloadAllVO.class);
        return result1;
    }

    @Override
    public List<ContractLevelworkloadAllVO> getContractLevelworkloadAllList(Integer startYear, Integer endYear) {
        List<ContractLevelworkloadAllDTO> result = contractLevelWorkloadService.findAllSubTotalList(startYear,endYear);
        List<ContractLevelworkloadAllVO> result1 = generatorUtil.convert(result,ContractLevelworkloadAllVO.class);
        return result1;
    }

    @Override
    public Result<ContractLevelworkloadAllByYearVO> getContractLevelworkloadAllByYear(ProjectReportQueryCnd cnd) {
        Result<ContractLevelworkloadAllByYearDTO> result = contractLevelWorkloadService.findAllGroupByYear(cnd.getStartYear(),cnd.getEndYear(),cnd.getPageNo(),cnd.getPageSize());
        Result<ContractLevelworkloadAllByYearVO> result1 = generatorUtil.convert(result,ContractLevelworkloadAllByYearVO.class);
        return result1;
    }

    @Override
    public List<ContractLevelworkloadAllByYearVO> getContractLevelworkloadAllByYearList(Integer startYear, Integer endYear) {
        List<ContractLevelworkloadAllByYearDTO> result = contractLevelWorkloadService.findAllGroupByYearList(startYear,endYear);
        List<ContractLevelworkloadAllByYearVO> result1 = generatorUtil.convert(result,ContractLevelworkloadAllByYearVO.class);
        return result1;
    }

    @Override
    public Result<ContractLevelworkloadAllByMonthVO> getContractLevelworkloadAllByMonth(ProjectReportQueryCnd cnd) {
        Result<ContractLevelworkloadAllByMonthDTO> result = contractLevelWorkloadService.findAllGroupByMonth(cnd.getStartYear(),cnd.getEndYear(),cnd.getPageNo(),cnd.getPageSize());
        Result<ContractLevelworkloadAllByMonthVO> result1 = generatorUtil.convert(result,ContractLevelworkloadAllByMonthVO.class);
        return result1;
    }

    @Override
    public List<ContractLevelworkloadAllByMonthVO> getContractLevelworkloadAllByMonthList(Integer startYear, Integer endYear) {
        List<ContractLevelworkloadAllByMonthDTO> result = contractLevelWorkloadService.findAllGroupByMonthList(startYear,endYear);
        List<ContractLevelworkloadAllByMonthVO> result1 = generatorUtil.convert(result,ContractLevelworkloadAllByMonthVO.class);
        return result1;
    }

    @Override
    public Result<ContractLevelworkloadAllByDepVO> getContractLevelworkloadAllByDep(ProjectReportQueryCnd cnd) {
        Result<ContractLevelworkloadAllByDepDTO> result = contractLevelWorkloadService.findDepTypeSubTotal(cnd.getStartYear(),cnd.getEndYear(),cnd.getPageNo(),cnd.getPageSize());
        Result<ContractLevelworkloadAllByDepVO> result1 = generatorUtil.convert(result,ContractLevelworkloadAllByDepVO.class);
        return result1;
    }

    @Override
    public List<ContractLevelworkloadAllByDepVO> getContractLevelworkloadAllByDepList(Integer startYear, Integer endYear) {
        List<ContractLevelworkloadAllByDepDTO> result = contractLevelWorkloadService.findDepTypeSubTotalList(startYear,endYear);
        List<ContractLevelworkloadAllByDepVO> result1 = generatorUtil.convert(result,ContractLevelworkloadAllByDepVO.class);
        return result1;
    }

    @Override
    public Result<ContractLevelworkloadAllByDepByYearVO> getContractLevelworkloadAllByDepByYear(ProjectReportQueryCnd cnd) {
        Result<ContractLevelworkloadAllByDepByYearDTO> result = contractLevelWorkloadService.findDepTypeGroupByYear(cnd.getStartYear(),cnd.getEndYear(),cnd.getPageNo(),cnd.getPageSize());
        Result<ContractLevelworkloadAllByDepByYearVO> result1 = generatorUtil.convert(result,ContractLevelworkloadAllByDepByYearVO.class);
        return result1;
    }

    @Override
    public List<ContractLevelworkloadAllByDepByYearVO> getContractLevelworkloadAllByDepByYearList(Integer startYear, Integer endYear) {
        List<ContractLevelworkloadAllByDepByYearDTO> result = contractLevelWorkloadService.findDepTypeGroupByYearList(startYear,endYear);
        List<ContractLevelworkloadAllByDepByYearVO> result1 = generatorUtil.convert(result,ContractLevelworkloadAllByDepByYearVO.class);
        return result1;
    }

    @Override
    public Result<ContractLevelworkloadAllByDepByMonthVO> getContractLevelworkloadAllByDepByMonth(ProjectReportQueryCnd cnd) {
        Result<ContractLevelworkloadAllByDepByMonthDTO> result = contractLevelWorkloadService.findDepTypeGroupByMonth(cnd.getStartYear(),cnd.getEndYear(),cnd.getPageNo(),cnd.getPageSize());
        Result<ContractLevelworkloadAllByDepByMonthVO> result1 = generatorUtil.convert(result,ContractLevelworkloadAllByDepByMonthVO.class);
        return result1;
    }

    @Override
    public List<ContractLevelworkloadAllByDepByMonthVO> getContractLevelworkloadAllByDepByMonthList(Integer startYear, Integer endYear) {
        List<ContractLevelworkloadAllByDepByMonthDTO> result = contractLevelWorkloadService.findDepTypeGroupByMonthList(startYear,endYear);
        List<ContractLevelworkloadAllByDepByMonthVO> result1 = generatorUtil.convert(result,ContractLevelworkloadAllByDepByMonthVO.class);
        return result1;
    }
}
