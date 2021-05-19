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
import java.util.Map;

@RestController
@RequestMapping(value = "/reimbursereport")
@Slf4j
public class ProjectReportReimburseController {
    @Autowired
    private ProjectLevelReimbursementManager projectLevelReimbursementManager;
    @Autowired
    private ContractLevelReimbursementManager contractLevelReimbursementManager;

    /**
     * D01 报销费用-项目级-全部-小计
     */
    @GetMapping(value = "/projectreimbursementcost/allsubtotal")
    public OfficeResopnseBean findProjectLevelReimbursementCostAllSubtotal(ProjectReportQueryCnd queryCnd){
        Result<Map<String, String>> result = projectLevelReimbursementManager.findProjectLevelReimbursementCostAllSubtotal(queryCnd);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(result);
        log.info(JSONUtils.toString(result));
        return bean;
    }

    /**
     * D01 报销费用-项目级-全部-小计-导出excel
     */
    @GetMapping(value = "/projectreimbursementcost/allsubtotaldownload")
    @RequiredExportLog
    public void exportProjectLevelReimbursementCostAllSubtotal(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        Map<String, Object> colsAndData = projectLevelReimbursementManager.exportProjectLevelReimbursementCostAllSubtotal(queryCnd);
        ExportExcel.mapExport(colsAndData,"D01-报销费用-项目级-全部-小计",response);
    }

    /**
     * D02 报销费用-项目级-全部-年度
     */
    @GetMapping(value = "/projectreimbursementcost/allyear")
    public OfficeResopnseBean findProjectLevelReimbursementCostAllYear(ProjectReportQueryCnd queryCnd){
        Result<Map<String, String>> result = projectLevelReimbursementManager.findProjectLevelReimbursementCostAllYear(queryCnd);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(result);
        log.info(JSONUtils.toString(result));
        return bean;
    }

    /**
     * D02 报销费用-项目级-全部-年度-导出excel
     */
    @GetMapping(value = "/projectreimbursementcost/allyeardownload")
    @RequiredExportLog
    public void exportfindProjectLevelReimbursementCostAllYear(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response) {
        Map<String, Object> colsAndData = projectLevelReimbursementManager.exportProjectLevelReimbursementCostAllYear(queryCnd);
        ExportExcel.mapExport(colsAndData,"D02-报销费用-项目级-全部-年度",response);
    }

    /**
     * D03 报销费用-项目级-全部-月度
     */
    @GetMapping(value = "/projectreimbursementcost/allmonth")
    public OfficeResopnseBean findProjectLevelReimbursementCostAllMonth(ProjectReportQueryCnd queryCnd){
        Result<Map<String, String>> result = projectLevelReimbursementManager.findProjectLevelReimbursementCostAllMonth(queryCnd);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(result);
        log.info(JSONUtils.toString(result));
        return bean;
    }

    /**
     * D03 报销费用-项目级-全部-月度-导出excel
     */
    @GetMapping(value = "/projectreimbursementcost/allmonthdownload")
    @RequiredExportLog
    public void exportProjectLevelReimbursementCostAllMonth(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        Map<String, Object> colsAndData = projectLevelReimbursementManager.exportProjectLevelReimbursementCostAllMonth(queryCnd);
        ExportExcel.mapExport(colsAndData,"D03-报销费用-项目级-全部-月度",response);
    }

    /**
     * D04 报销费用-项目级-按产生部门类别-小计
     */
    @GetMapping(value = "/projectreimbursementcost/depsubtotal")
    public OfficeResopnseBean findProjectLevelReimbursementCostDepSubtotal(ProjectReportQueryCnd queryCnd){
        Result<Map<String, String>> result = projectLevelReimbursementManager.findProjectLevelReimbursementCostDepSubtotal(queryCnd);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(result);
        log.info(JSONUtils.toString(result));
        return bean;
    }

    /**
     * D04 报销费用-项目级-按产生部门类别-小计-导出excel
     */
    @GetMapping(value = "/projectreimbursementcost/depsubtotaldownload")
    @RequiredExportLog
    public void exportProjectLevelReimbursementCostDepSubtotal(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        Map<String, Object> colsAndData = projectLevelReimbursementManager.exportProjectLevelReimbursementCostDepSubtotal(queryCnd);
        ExportExcel.mapExport(colsAndData,"D04-报销费用-项目级-按产生部门类别-小计",response);
    }

    /**
     * D05 报销费用-项目级-按产生部门类别-年度
     */
    @GetMapping(value = "/projectreimbursementcost/depyear")
    public OfficeResopnseBean findProjectLevelReimbursementCostDepYear(ProjectReportQueryCnd queryCnd){
        Result<Map<String, String>> result = projectLevelReimbursementManager.findProjectLevelReimbursementCostDepYear(queryCnd);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(result);
        log.info(JSONUtils.toString(result));
        return bean;
    }

    /**
     * D05 报销费用-项目级-按产生部门类别-年度-导出excel
     */
    @GetMapping(value = "/projectreimbursementcost/depyeardownload")
    @RequiredExportLog
    public void exportProjectLevelReimbursementCostDepYear(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        Map<String, Object> colsAndData = projectLevelReimbursementManager.exportProjectLevelReimbursementCostDepYear(queryCnd);
        ExportExcel.mapExport(colsAndData,"D05-报销费用-项目级-按产生部门类别-年度",response);
    }

    /**
     * D06 报销费用-项目级-按产生部门类别-月度
     */
    @GetMapping(value = "/projectreimbursementcost/depmonth")
    public OfficeResopnseBean findProjectLevelReimbursementCostDepMonth(ProjectReportQueryCnd queryCnd){
        Result<Map<String, String>> result = projectLevelReimbursementManager.findProjectLevelReimbursementCostDepMonth(queryCnd);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(result);
        log.info(JSONUtils.toString(result));
        return bean;
    }

    /**
     * D06 报销费用-项目级-按产生部门类别-月度-导出excel
     */
    @GetMapping(value = "/projectreimbursementcost/depmonthdownload")
    @RequiredExportLog
    public void exportProjectLevelReimbursementCostDepMonth(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        Map<String, Object> colsAndData = projectLevelReimbursementManager.exportProjectLevelReimbursementCostDepMonth(queryCnd);
        ExportExcel.mapExport(colsAndData,"D06-报销费用-项目级-按产生部门类别-月度",response);
    }

     /**
     * D07 报销费用-合同级-全部-小计
     */
    @GetMapping(value = "/contractreimbursementcost/allsubtotal")
    public OfficeResopnseBean findContractLevelReimbursementCostAllSubtotal(ProjectReportQueryCnd queryCnd){
        Result<Map<String, String>> result = contractLevelReimbursementManager.findContractLevelReimbursementCostAllSubtotal(queryCnd);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(result);
        log.info(JSONUtils.toString(result));
        return bean;
    }

    /**
     * D07 报销费用-合同级-全部-小计-导出excel
     */
    @GetMapping(value = "/contractreimbursementcost/allsubtotaldownload")
    @RequiredExportLog
    public void exportContractLevelReimbursementCostAllSubtotal(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        Map<String, Object> colsAndData = contractLevelReimbursementManager.exportContractLevelReimbursementCostAllSubtotal(queryCnd);
        ExportExcel.mapExport(colsAndData,"D07-报销费用-合同级-全部-小计",response);
    }

    /**
     * D08 报销费用-合同级-全部-年度
     */
    @GetMapping(value = "/contractreimbursementcost/allyear")
    public OfficeResopnseBean findContractLevelReimbursementCostAllYear(ProjectReportQueryCnd queryCnd){
        Result<Map<String, String>> result = contractLevelReimbursementManager.findContractLevelReimbursementCostAllYear(queryCnd);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(result);
        log.info(JSONUtils.toString(result));
        return bean;
    }

    /**
     * D08 报销费用-合同级-全部-年度-导出excel
     */
    @GetMapping(value = "/contractreimbursementcost/allyeardownload")
    @RequiredExportLog
    public void exportContractLevelReimbursementCostAllYear(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        Map<String, Object> colsAndData = contractLevelReimbursementManager.exportContractLevelReimbursementCostAllYear(queryCnd);
        ExportExcel.mapExport(colsAndData,"D08-报销费用-合同级-全部-年度",response);
    }

    /**
     * D09 报销费用-合同级-全部-月度
     */
    @GetMapping(value = "/contractreimbursementcost/allmonth")
    public OfficeResopnseBean findContractLevelReimbursementCostAllMonth(ProjectReportQueryCnd queryCnd){
        Result<Map<String, String>> result = contractLevelReimbursementManager.findContractLevelReimbursementCostAllMonth(queryCnd);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(result);
        log.info(JSONUtils.toString(result));
        return bean;
    }

    /**
     * D09 报销费用-合同级-全部-月度-导出excel
     */
    @GetMapping(value = "/contractreimbursementcost/allmonthdownload")
    @RequiredExportLog
    public void exportContractLevelReimbursementCostAllMonth(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        Map<String, Object> colsAndData = contractLevelReimbursementManager.exportContractLevelReimbursementCostAllMonth(queryCnd);
        ExportExcel.mapExport(colsAndData,"D09-报销费用-合同级-全部-月度",response);
    }

    /**
     * D10 报销费用-合同级-按产生部门类别-小计
     */
    @GetMapping(value = "/contractreimbursementcost/depsubtotal")
    public OfficeResopnseBean findContractLevelReimbursementCostDepSubtotal(ProjectReportQueryCnd queryCnd){
        Result<Map<String, String>> result = contractLevelReimbursementManager.findContractLevelReimbursementCostDepSubtotal(queryCnd);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(result);
        log.info(JSONUtils.toString(result));
        return bean;
    }

    /**
     * D10 报销费用-合同级-按产生部门类别-小计-导出excel
     */
    @GetMapping(value = "/contractreimbursementcost/depsubtotaldownload")
    @RequiredExportLog
    public void exportContractLevelReimbursementCostDepSubtotal(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        Map<String, Object> colsAndData = contractLevelReimbursementManager.exportContractLevelReimbursementCostDepSubtotal(queryCnd);
        ExportExcel.mapExport(colsAndData,"D10-报销费用-合同级-按产生部门类别-小计",response);
    }

    /**
     * D11 报销费用-合同级-按产生部门类别-年度
     */
    @GetMapping(value = "/contractreimbursementcost/depyear")
    public OfficeResopnseBean findContractLevelReimbursementCostDepYear(ProjectReportQueryCnd queryCnd){
        Result<Map<String, String>> result = contractLevelReimbursementManager.findContractLevelReimbursementCostDepYear(queryCnd);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(result);
        log.info(JSONUtils.toString(result));
        return bean;
    }

    /**
     * D11 报销费用-合同级-按产生部门类别-年度-导出excel
     */
    @GetMapping(value = "/contractreimbursementcost/depyeardownload")
    @RequiredExportLog
    public void exportContractLevelReimbursementCostDepYear(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        Map<String, Object> colsAndData = contractLevelReimbursementManager.exportContractLevelReimbursementCostDepYear(queryCnd);
        ExportExcel.mapExport(colsAndData,"D11-报销费用-合同级-按产生部门类别-年度",response);
    }

    /**
     * D12 报销费用-合同级-按产生部门类别-月度
     */
    @GetMapping(value = "/contractreimbursementcost/depmonth")
    public OfficeResopnseBean findContractLevelReimbursementCostDepMonth(ProjectReportQueryCnd queryCnd){
        Result<Map<String, String>> result = contractLevelReimbursementManager.findContractLevelReimbursementCostDepMonth(queryCnd);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(result);
        log.info(JSONUtils.toString(result));
        return bean;
    }

    /**
     * D12 报销费用-合同级-按产生部门类别-月度-导出excel
     */
    @GetMapping(value = "/contractreimbursementcost/depmonthdownload")
    @RequiredExportLog
    public void exportContractLevelReimbursementCostDepMonth(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        Map<String, Object> colsAndData = contractLevelReimbursementManager.exportContractLevelReimbursementCostDepMonth(queryCnd);
        ExportExcel.mapExport(colsAndData,"D12-报销费用-合同级-按产生部门类别-月度",response);

    }

    /**
     *  报销费用-费用科目
     */
    @GetMapping(value = "/costsubjectcolumns")
    public OfficeResopnseBean getCostSubjectCloumns(){
        List<FinancialSubjectVO> list = contractLevelReimbursementManager.getCostSubjectColumns();
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(list);
        log.info(JSONUtils.toString(list));
        return bean;
    }

}
