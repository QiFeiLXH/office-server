package com.bsoft.office.project.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.RequiredExportLog;
import com.bsoft.office.common.condition.ExportLogParams;
import com.bsoft.office.common.exportExcel.ExportExcel;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.project.condition.ProjectReportQueryCnd;
import com.bsoft.office.project.manager.*;
import com.bsoft.office.project.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = "/allreport")
@Slf4j
public class ProjectReportAllController {
    @Autowired
    private ProjectLevelAllManager projectLevelAllManager;
    @Autowired
    private ContractLevelAllManager contractLevelAllManager;


    /**
     *功能描述: 获取A01 全部-项目级-全部-小计
     */
    @GetMapping(value = "/allproject/allsubtotal")
    public OfficeResopnseBean findProjectLevelAllSubtotal(ProjectReportQueryCnd queryCnd){
        Result<ProjectLevelAllSubtotalVO> result = projectLevelAllManager.findProjectLevelAllSubtotal(queryCnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        log.info(JSONUtils.toString(result));
        return responseBean;
    }

    /**
     *功能描述: 获取A01 全部-项目级-全部-小计-导出excel
     */
    @GetMapping(value = "/allproject/allsubtotaldownload")
    @RequiredExportLog
    public void exportProjectLevelAllSubtotal(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        List<ProjectLevelAllSubtotalVO> list = projectLevelAllManager.exportProjectLevelAllSubtotal(queryCnd);
        ExportExcel.export(list,ProjectLevelAllSubtotalVO.class,"A01-全部-项目级-全部-小计",response);
    }

    /**
     *功能描述: 获取A02 全部-项目级-全部-年度
     */
    @GetMapping(value = "/allproject/allyear")
    public OfficeResopnseBean findProjectLevelAllYear(ProjectReportQueryCnd queryCnd){
        Result<ProjectLevelAllByYearVO> result = projectLevelAllManager.findProjectLevelAllYear(queryCnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        log.info(JSONUtils.toString(result));
        return responseBean;
    }

    /**
     *功能描述: 获取A02 全部-项目级-全部-年度-导出excel
     */
    @GetMapping(value = "/allproject/allyeardownload")
    @RequiredExportLog
    public void exportProjectLevelAllYear(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        List<ProjectLevelAllByYearVO> list = projectLevelAllManager.exportProjectLevelAllYear(queryCnd);
        ExportExcel.export(list,ProjectLevelAllByYearVO.class,"A02-全部-项目级-全部-年度",response);
    }

    /**
     *功能描述: 获取A03 全部-项目级-全部-月度
     */
    @GetMapping(value = "/allproject/allmonth")
    public OfficeResopnseBean findProjectLevelAllMonth(ProjectReportQueryCnd queryCnd){
        Result<ProjectLevelAllByMonthVO> result = projectLevelAllManager.findProjectLevelAllMonth(queryCnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        log.info(JSONUtils.toString(result));
        return responseBean;
    }

    /**
     *功能描述: 获取A03 全部-项目级-全部-月度-导出excel
     */
    @GetMapping(value = "/allproject/allmonthdownload")
    @RequiredExportLog
    public void exportProjectLevelAllMonth(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        List<ProjectLevelAllByMonthVO> list = projectLevelAllManager.exportProjectLevelAllMonth(queryCnd);
        ExportExcel.export(list,ProjectLevelAllByMonthVO.class,"A03-全部-项目级-全部-月度",response);
    }

    /**
     *功能描述: 获取A04 全部-项目级-按产生部门类别-小计
     */
    @GetMapping(value = "/allproject/alldepsubtotal")
    public OfficeResopnseBean findProjectLevelAllDepSubtotal(ProjectReportQueryCnd queryCnd){
        Result<ProjectLevelDepTypeSubtotalVO> result = projectLevelAllManager.findProjectLevelAllDepSubtotal(queryCnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        log.info(JSONUtils.toString(result));
        return responseBean;
    }

    /**
     *功能描述: 获取A04 全部-项目级-按产生部门类别-小计-导出excel
     */
    @GetMapping(value = "/allproject/alldepsubtotaldownload")
    @RequiredExportLog
    public void exportProjectLevelAllDepSubtotal(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        List<ProjectLevelDepTypeSubtotalVO> list = projectLevelAllManager.exportProjectLevelAllDepSubtotal(queryCnd);
        ExportExcel.export(list,ProjectLevelDepTypeSubtotalVO.class,"A04-全部-项目级-按产生部门类别-小计",response);
    }

    /**
     *功能描述: 获取A05 全部-项目级-按产生部门类别-年度
     */
    @GetMapping(value = "/allproject/alldepyear")
    public OfficeResopnseBean findProjectLevelAllDepYear(ProjectReportQueryCnd queryCnd){
        Result<ProjectLevelDepTypeByYearVO> result = projectLevelAllManager.findProjectLevelAllDepYear(queryCnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        log.info(JSONUtils.toString(result));
        return responseBean;
    }

    /**
     *功能描述: 获取A05 全部-项目级-按产生部门类别-年度-导出excel
     */
    @GetMapping(value = "/allproject/alldepyeardownload")
    @RequiredExportLog
    public void exportProjectLevelAllDepYear(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        List<ProjectLevelDepTypeByYearVO> list = projectLevelAllManager.exportProjectLevelAllDepYear(queryCnd);
        ExportExcel.export(list,ProjectLevelDepTypeByYearVO.class,"A05-全部-项目级-按产生部门类别-年度",response);
    }

    /**
     *功能描述: 获取A06 全部-项目级-按产生部门类别-月度
     */
    @GetMapping(value = "/allproject/alldepmonth")
    public OfficeResopnseBean findProjectLevelAllDepMonth(ProjectReportQueryCnd queryCnd){
        Result<ProjectLevelDepTypeByMonthVO> result = projectLevelAllManager.findProjectLevelAllDepMonth(queryCnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        log.info(JSONUtils.toString(result));
        return responseBean;
    }

    /**
     *功能描述: 获取A06 全部-项目级-按产生部门类别-月度-导出excel
     */
    @GetMapping(value = "/allproject/alldepmonthdownload")
    @RequiredExportLog
    public void exportProjectLevelAllDepMonth(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        List<ProjectLevelDepTypeByMonthVO> list = projectLevelAllManager.exportProjectLevelAllDepMonth(queryCnd);
        ExportExcel.export(list,ProjectLevelDepTypeByMonthVO.class,"A06-全部-项目级-按产生部门类别-月度",response);
    }


    /**
     *功能描述: 获取A07 全部-合同级-全部-小计
     */
    @GetMapping(value = "/allcontract/allsubtotal")
    public OfficeResopnseBean findContractLevelAllSubtotal(ProjectReportQueryCnd queryCnd){
        Result<ContractLevelAllSubtotalVO> result = contractLevelAllManager.findContractLevelAllSubtotal(queryCnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        log.info(JSONUtils.toString(result));
        return responseBean;
    }

    /**
     *功能描述: 获取A07 全部-合同级-全部-小计-导出excel
     */
    @GetMapping(value = "/allcontract/allsubtotaldownload")
    @RequiredExportLog
    public void exportContractLevelAllSubtotal(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        List<ContractLevelAllSubtotalVO> list = contractLevelAllManager.exportContractLevelAllSubtotal(queryCnd);
        ExportExcel.export(list,ContractLevelAllSubtotalVO.class,"A07-全部-合同级-全部-小计",response);
    }

    /**
     *功能描述: 获取A08 全部-合同级-全部-年度
     */
    @GetMapping(value = "/allcontract/allyear")
    public OfficeResopnseBean findContractLevelAllYear(ProjectReportQueryCnd queryCnd){
        Result<ContractLevelAllByYearVO> result = contractLevelAllManager.findContractLevelAllYear(queryCnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        log.info(JSONUtils.toString(result));
        return responseBean;
    }

    /**
     *功能描述: 获取A08 全部-合同级-全部-年度-导出excel
     */
    @GetMapping(value = "/allcontract/allyeardownload")
    @RequiredExportLog
    public void exportContractLevelAllYear(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        List<ContractLevelAllByYearVO> list = contractLevelAllManager.exportContractLevelAllYear(queryCnd);
        ExportExcel.export(list,ContractLevelAllByYearVO.class,"A08-全部-合同级-全部-年度",response);
    }

    /**
     *功能描述: 获取A09 全部-合同级-全部-月度
     */
    @GetMapping(value = "/allcontract/allmonth")
    public OfficeResopnseBean findContractLevelAllMonth(ProjectReportQueryCnd queryCnd){
        Result<ContractLevelAllByMonthVO> result = contractLevelAllManager.findContractLevelAllMonth(queryCnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        log.info(JSONUtils.toString(result));
        return responseBean;
    }

    /**
     *功能描述: 获取A09 全部-合同级-全部-月度-导出excel
     */
    @GetMapping(value = "/allcontract/allmonthdownload")
    @RequiredExportLog
    public void exportContractLevelAllMonth(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        List<ContractLevelAllByMonthVO> list = contractLevelAllManager.exportContractLevelAllMonth(queryCnd);
        ExportExcel.export(list,ContractLevelAllByMonthVO.class,"A09-全部-合同级-全部-月度",response);
    }

    /**
     *功能描述: 获取A10 全部-合同级-按产生部门类别-小计
     */
    @GetMapping(value = "/allcontract/alldepsubtotal")
    public OfficeResopnseBean findContractLevelAllDepSubtotal(ProjectReportQueryCnd queryCnd){
        Result<ContractLevelDepTypeSubtotalVO> result = contractLevelAllManager.findContractLevelAllDepSubtotal(queryCnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        log.info(JSONUtils.toString(result));
        return responseBean;
    }

    /**
     *功能描述: 获取A10 全部-合同级-按产生部门类别-小计-导出excel
     */
    @GetMapping(value = "/allcontract/alldepsubtotaldownload")
    @RequiredExportLog
    public void exportContractLevelAllDepSubtotal(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        List<ContractLevelDepTypeSubtotalVO> list = contractLevelAllManager.exportContractLevelAllDepSubtotal(queryCnd);
        ExportExcel.export(list,ContractLevelDepTypeSubtotalVO.class,"A10-全部-合同级-按产生部门类别-小计",response);
    }

    /**
     *功能描述: 获取A11 全部-合同级-按产生部门类别-年度
     */
    @GetMapping(value = "/allcontract/alldepyear")
    public OfficeResopnseBean findContractLevelAllDepYear(ProjectReportQueryCnd queryCnd){
        Result<ContractLevelDepTypeByYearVO> result = contractLevelAllManager.findContractLevelAllDepYear(queryCnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        log.info(JSONUtils.toString(result));
        return responseBean;
    }

    /**
     *功能描述: 获取A11 全部-合同级-按产生部门类别-年度-导出excel
     */
    @GetMapping(value = "/allcontract/alldepyeardownload")
    @RequiredExportLog
    public void exportContractLevelAllDepYear(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        List<ContractLevelDepTypeByYearVO> list = contractLevelAllManager.exportContractLevelAllDepYear(queryCnd);
        ExportExcel.export(list,ContractLevelDepTypeByYearVO.class,"A11-全部-合同级-按产生部门类别-年度",response);
    }

    /**
     *功能描述: 获取A12 全部-合同级-按产生部门类别-月度
     */
    @GetMapping(value = "/allcontract/alldepmonth")
    public OfficeResopnseBean findContractLevelAllDepMonth(ProjectReportQueryCnd queryCnd){
        Result<ContractLevelDepTypeByMonthVO> result = contractLevelAllManager.findContractLevelAllDepMonth(queryCnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        log.info(JSONUtils.toString(result));
        return responseBean;
    }

    /**
     *功能描述: 获取A12 全部-合同级-按产生部门类别-月度-导出excel
     */
    @GetMapping(value = "/allcontract/alldepmonthdownload")
    @RequiredExportLog
    public void exportContractLevelAllDepMonth(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        List<ContractLevelDepTypeByMonthVO> list = contractLevelAllManager.exportContractLevelAllDepMonth(queryCnd);
        ExportExcel.export(list,ContractLevelDepTypeByMonthVO.class,"A12-全部-合同级-按产生部门类别-月度",response);
    }

}
