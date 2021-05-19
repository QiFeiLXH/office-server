package com.bsoft.office.project.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.project.condition.ProjectReportQueryCnd;
import com.bsoft.office.project.manager.ContractLevelBonusManager;
import com.bsoft.office.project.vo.*;
import com.bsoft.project.report.dto.ProjectBonusDTO;
import com.bsoft.project.report.service.ProjectBonusService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/4/26 17:43
 * @Description
 */
@Service
public class ContractLevelBonusManagerImpl implements ContractLevelBonusManager {
    @Reference(timeout = 60000)
    private ProjectBonusService projectBonusService;
    @Autowired
    private IGenerator iGenerator;
    @Override
    public Result<ContractLevelBonusAllSubtotalVO> getContractLevelBonusAllSubtotal(ProjectReportQueryCnd queryCnd) {
        Result<ProjectBonusDTO> result = projectBonusService.findProjectBonusConAllTotal(queryCnd.getStartYear(), queryCnd.getEndYear(), queryCnd.getPageNo(), queryCnd.getPageSize());
        return iGenerator.convert(result,ContractLevelBonusAllSubtotalVO.class);
    }

    @Override
    public List<ContractLevelBonusAllSubtotalVO> exportContractLevelBonusAllSubtotal(ProjectReportQueryCnd queryCnd) {
        List<ProjectBonusDTO> result = projectBonusService.findProjectBonusConAllTotal(queryCnd.getStartYear(), queryCnd.getEndYear());
        return iGenerator.convert(result,ContractLevelBonusAllSubtotalVO.class);
    }

    @Override
    public Result<ContractLevelBonusAllByYearVO> getContractLevelBonusAllYear(ProjectReportQueryCnd queryCnd) {
        Result<ProjectBonusDTO> result = projectBonusService.findProjectBonusConAllYear(queryCnd.getStartYear(), queryCnd.getEndYear(), queryCnd.getPageNo(), queryCnd.getPageSize());
        return iGenerator.convert(result,ContractLevelBonusAllByYearVO.class);
    }

    @Override
    public List<ContractLevelBonusAllByYearVO> exportContractLevelBonusAllYear(ProjectReportQueryCnd queryCnd) {
        List<ProjectBonusDTO> result = projectBonusService.findProjectBonusConAllYear(queryCnd.getStartYear(), queryCnd.getEndYear());
        return iGenerator.convert(result,ContractLevelBonusAllByYearVO.class);
    }

    @Override
    public Result<ContractLevelBonusAllByMonthVO> getContractLevelBonusAllMonth(ProjectReportQueryCnd queryCnd) {
        Result<ProjectBonusDTO> result = projectBonusService.findProjectBonusConAllMonth(queryCnd.getStartYear(), queryCnd.getEndYear(), queryCnd.getPageNo(), queryCnd.getPageSize());
        return iGenerator.convert(result,ContractLevelBonusAllByMonthVO.class);
    }

    @Override
    public List<ContractLevelBonusAllByMonthVO> exportContractLevelBonusAllMonth(ProjectReportQueryCnd queryCnd) {
        List<ProjectBonusDTO> result = projectBonusService.findProjectBonusConAllMonth(queryCnd.getStartYear(), queryCnd.getEndYear());
        return iGenerator.convert(result,ContractLevelBonusAllByMonthVO.class);
    }

    @Override
    public Result<ContractLevelBonusDepTypeSubtotalVO> getContractLevelBonusDepSubtotal(ProjectReportQueryCnd queryCnd) {
        Result<ProjectBonusDTO> result = projectBonusService.findProjectBonusConDepTotal(queryCnd.getStartYear(), queryCnd.getEndYear(), queryCnd.getPageNo(), queryCnd.getPageSize());
        return iGenerator.convert(result,ContractLevelBonusDepTypeSubtotalVO.class);
    }

    @Override
    public List<ContractLevelBonusDepTypeSubtotalVO> exportContractLevelBonusDepSubtotal(ProjectReportQueryCnd queryCnd) {
        List<ProjectBonusDTO> result = projectBonusService.findProjectBonusConDepTotal(queryCnd.getStartYear(), queryCnd.getEndYear());
        return iGenerator.convert(result,ContractLevelBonusDepTypeSubtotalVO.class);
    }

    @Override
    public Result<ContractLevelBonusDepTypeByYearVO> getContractLevelBonusDepYear(ProjectReportQueryCnd queryCnd) {
        Result<ProjectBonusDTO> result = projectBonusService.findProjectBonusConDepYear(queryCnd.getStartYear(), queryCnd.getEndYear(), queryCnd.getPageNo(), queryCnd.getPageSize());
        return iGenerator.convert(result,ContractLevelBonusDepTypeByYearVO.class);
    }

    @Override
    public List<ContractLevelBonusDepTypeByYearVO> exportContractLevelBonusDepYear(ProjectReportQueryCnd queryCnd) {
        List<ProjectBonusDTO> result = projectBonusService.findProjectBonusConDepYear(queryCnd.getStartYear(), queryCnd.getEndYear());
        return iGenerator.convert(result,ContractLevelBonusDepTypeByYearVO.class);
    }

    @Override
    public Result<ContractLevelBonusDepTypeByMonthVO> getContractLevelBonusDepMonth(ProjectReportQueryCnd queryCnd) {
        Result<ProjectBonusDTO> result = projectBonusService.findProjectBonusConDepMonth(queryCnd.getStartYear(), queryCnd.getEndYear(), queryCnd.getPageNo(), queryCnd.getPageSize());
        return iGenerator.convert(result,ContractLevelBonusDepTypeByMonthVO.class);
    }

    @Override
    public List<ContractLevelBonusDepTypeByMonthVO> exportContractLevelBonusDepMonth(ProjectReportQueryCnd queryCnd) {
        List<ProjectBonusDTO> result = projectBonusService.findProjectBonusConDepMonth(queryCnd.getStartYear(), queryCnd.getEndYear());
        return iGenerator.convert(result,ContractLevelBonusDepTypeByMonthVO.class);
    }
}
