package com.bsoft.office.project.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.project.condition.ProjectReportQueryCnd;
import com.bsoft.office.project.manager.ContractLevelAllManager;
import com.bsoft.office.project.vo.*;
import com.bsoft.project.report.dto.ContractAllByMonthDTO;
import com.bsoft.project.report.dto.ContractAllSubTotalDTO;
import com.bsoft.project.report.dto.ContractDepTypeByMonthDTO;
import com.bsoft.project.report.dto.ContractDepTypeByYearDTO;
import com.bsoft.project.report.service.ContractLevelService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: bsoft-office-server
 * @BelongsPackage: com.bsoft.office.project.manager.impl
 * @Author: Xuhui Lin
 * @CreateTime: 2020-04-02 09:38
 * @Description:
 */
@Service
public class ContractLevelAllManagerImpl implements ContractLevelAllManager {
    @Reference(timeout = 60000)
    private ContractLevelService contractLevelService;
    @Autowired
    private IGenerator iGenerator;
    @Override
    public Result<ContractLevelAllSubtotalVO> findContractLevelAllSubtotal(ProjectReportQueryCnd cnd) {
        Result<ContractAllSubTotalDTO> list =  contractLevelService.findAllSubTotal(cnd.getStartYear(),cnd.getEndYear(),cnd.getPageNo(),cnd.getPageSize());
        return iGenerator.convert(list, ContractLevelAllSubtotalVO.class);
    }

    @Override
    public List<ContractLevelAllSubtotalVO> exportContractLevelAllSubtotal(ProjectReportQueryCnd cnd) {
        List<ContractAllSubTotalDTO> list =  contractLevelService.findAllSubTotal(cnd.getStartYear(),cnd.getEndYear());
        return iGenerator.convert(list, ContractLevelAllSubtotalVO.class);
    }

    @Override
    public Result<ContractLevelAllByYearVO> findContractLevelAllYear(ProjectReportQueryCnd cnd) {
        Result<ContractAllSubTotalDTO> list =  contractLevelService.findAllGroupByYear(cnd.getStartYear(),cnd.getEndYear(),cnd.getPageNo(),cnd.getPageSize());
        return iGenerator.convert(list, ContractLevelAllByYearVO.class);
    }

    @Override
    public List<ContractLevelAllByYearVO> exportContractLevelAllYear(ProjectReportQueryCnd cnd) {
        List<ContractAllSubTotalDTO> list =  contractLevelService.findAllGroupByYear(cnd.getStartYear(),cnd.getEndYear());
        return iGenerator.convert(list, ContractLevelAllByYearVO.class);
    }

    @Override
    public Result<ContractLevelAllByMonthVO> findContractLevelAllMonth(ProjectReportQueryCnd cnd) {
        Result<ContractAllByMonthDTO> list =  contractLevelService.findAllGroupByMonth(cnd.getStartYear(),cnd.getEndYear(),cnd.getPageNo(),cnd.getPageSize());
        return iGenerator.convert(list, ContractLevelAllByMonthVO.class);
    }

    @Override
    public List<ContractLevelAllByMonthVO> exportContractLevelAllMonth(ProjectReportQueryCnd cnd) {
        List<ContractAllByMonthDTO> list =  contractLevelService.findAllGroupByMonth(cnd.getStartYear(),cnd.getEndYear());
        return iGenerator.convert(list, ContractLevelAllByMonthVO.class);
    }

    @Override
    public Result<ContractLevelDepTypeSubtotalVO> findContractLevelAllDepSubtotal(ProjectReportQueryCnd cnd) {
        Result<ContractDepTypeByYearDTO> list =  contractLevelService.findDepTypeSubTotal(cnd.getStartYear(),cnd.getEndYear(),cnd.getPageNo(),cnd.getPageSize());
        return iGenerator.convert(list, ContractLevelDepTypeSubtotalVO.class);
    }

    @Override
    public List<ContractLevelDepTypeSubtotalVO> exportContractLevelAllDepSubtotal(ProjectReportQueryCnd cnd) {
        List<ContractDepTypeByYearDTO> list =  contractLevelService.findDepTypeSubTotal(cnd.getStartYear(),cnd.getEndYear());
        return iGenerator.convert(list, ContractLevelDepTypeSubtotalVO.class);
    }

    @Override
    public Result<ContractLevelDepTypeByYearVO> findContractLevelAllDepYear(ProjectReportQueryCnd cnd) {
        Result<ContractDepTypeByYearDTO> list =  contractLevelService.findDepTypeGroupByYear(cnd.getStartYear(),cnd.getEndYear(),cnd.getPageNo(),cnd.getPageSize());
        return iGenerator.convert(list, ContractLevelDepTypeByYearVO.class);
    }

    @Override
    public List<ContractLevelDepTypeByYearVO> exportContractLevelAllDepYear(ProjectReportQueryCnd cnd) {
        List<ContractDepTypeByYearDTO> list =  contractLevelService.findDepTypeGroupByYear(cnd.getStartYear(),cnd.getEndYear());
        return iGenerator.convert(list, ContractLevelDepTypeByYearVO.class);
    }

    @Override
    public Result<ContractLevelDepTypeByMonthVO> findContractLevelAllDepMonth(ProjectReportQueryCnd cnd) {
        Result<ContractDepTypeByMonthDTO> list =  contractLevelService.findDepTypeGroupByMonth(cnd.getStartYear(),cnd.getEndYear(),cnd.getPageNo(),cnd.getPageSize());
        return iGenerator.convert(list, ContractLevelDepTypeByMonthVO.class);
    }

    @Override
    public List<ContractLevelDepTypeByMonthVO> exportContractLevelAllDepMonth(ProjectReportQueryCnd cnd) {
        List<ContractDepTypeByMonthDTO> list =  contractLevelService.findDepTypeGroupByMonth(cnd.getStartYear(),cnd.getEndYear());
        return iGenerator.convert(list, ContractLevelDepTypeByMonthVO.class);
    }
}
