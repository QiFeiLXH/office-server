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
@RequestMapping(value = "/bonusreport")
@Slf4j
public class ProjectReportBonusController {
    @Autowired
    private ProjectLevelBonusManager projectLevelBonusManager;
    @Autowired
    private ContractLevelBonusManager contractLevelBonusManager;


    /**
     *功能描述: 获取E01 项目奖金-项目级-全部-小计
     */
    @GetMapping(value = "/pbonus/allsubtotal")
    public OfficeResopnseBean getProjectLevelBonusAllSubtotal(ProjectReportQueryCnd queryCnd){
        Result<ProjectLevelBonusAllSubtotalVO> result = projectLevelBonusManager.getProjectLevelBonusAllSubtotal(queryCnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        log.info(JSONUtils.toString(result));
        return responseBean;
    }

    /**
     *功能描述: 获取E01 项目奖金-项目级-全部-小计-导出excel
     */
    @GetMapping(value = "/pbonus/allsubtotaldownload")
    @RequiredExportLog
    public void exportProjectLevelBonusAllSubtotal(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        List<ProjectLevelBonusAllSubtotalVO> list = projectLevelBonusManager.exportProjectLevelBonusAllSubtotal(queryCnd);
        ExportExcel.export(list,ProjectLevelBonusAllSubtotalVO.class,"E01-项目奖金-项目级-全部-小计",response);
    }

    /**
     *功能描述: 获取E02 项目奖金-项目级-全部-年度
     */
    @GetMapping(value = "/pbonus/allyear")
    public OfficeResopnseBean getProjectLevelBonusAllYear(ProjectReportQueryCnd queryCnd){
        Result<ProjectLevelBonusAllByYearVO> result = projectLevelBonusManager.getProjectLevelBonusAllYear(queryCnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        log.info(JSONUtils.toString(result));
        return responseBean;
    }

    /**
     *功能描述: 获取E02 项目奖金-项目级-全部-年度-导出excel
     */
    @GetMapping(value = "/pbonus/allyeardownload")
    @RequiredExportLog
    public void exportProjectLevelBonusAllYear(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        List<ProjectLevelBonusAllByYearVO> list = projectLevelBonusManager.exportProjectLevelBonusAllYear(queryCnd);
        ExportExcel.export(list,ProjectLevelBonusAllByYearVO.class,"E02-项目奖金-项目级-全部-年度",response);
    }

    /**
     *功能描述: 获取E03 项目奖金-项目级-全部-月度
     */
    @GetMapping(value = "/pbonus/allmonth")
    public OfficeResopnseBean getProjectLevelBonusAllMonth(ProjectReportQueryCnd queryCnd){
        Result<ProjectLevelBonusAllByMonthVO> result = projectLevelBonusManager.getProjectLevelBonusAllMonth(queryCnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        log.info(JSONUtils.toString(result));
        return responseBean;
    }

    /**
     *功能描述: 获取E03 项目奖金-项目级-全部-月度-导出excel
     */
    @GetMapping(value = "/pbonus/allmonthdownload")
    @RequiredExportLog
    public void exportProjectLevelBonusAllMonth(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        List<ProjectLevelBonusAllByMonthVO> list = projectLevelBonusManager.exportProjectLevelBonusAllMonth(queryCnd);
        ExportExcel.export(list,ProjectLevelBonusAllByMonthVO.class,"E03-项目奖金-项目级-全部-月度",response);
    }

    /**
     *功能描述: 获取E04 项目奖金-项目级-按产生部门类别-小计
     */
    @GetMapping(value = "/pbonus/depsubtotal")
    public OfficeResopnseBean getProjectLevelBonusDepSubtotal(ProjectReportQueryCnd queryCnd){
        Result<ProjectLevelBonusDepTypeSubtotalVO> result = projectLevelBonusManager.getProjectLevelBonusDepSubtotal(queryCnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        log.info(JSONUtils.toString(result));
        return responseBean;
    }

    /**
     *功能描述: 获取E04 项目奖金-项目级-按产生部门类别-小计-导出excel
     */
    @GetMapping(value = "/pbonus/depsubtotalDownload")
    @RequiredExportLog
    public void exportProjectLevelBonusDepSubtotal(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        List<ProjectLevelBonusDepTypeSubtotalVO> list = projectLevelBonusManager.exportProjectLevelBonusDepSubtotal(queryCnd);
        ExportExcel.export(list,ProjectLevelBonusDepTypeSubtotalVO.class,"E04-项目奖金-项目级-按产生部门类别-小计",response);
    }

    /**
     *功能描述: 获取E05 项目奖金-项目级-按产生部门类别-年度
     */
    @GetMapping(value = "/pbonus/depyear")
    public OfficeResopnseBean getProjectLevelBonusDepYear(ProjectReportQueryCnd queryCnd){
        Result<ProjectLevelBonusDepTypeByYearVO> result = projectLevelBonusManager.getProjectLevelBonusDepYear(queryCnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        log.info(JSONUtils.toString(result));
        return responseBean;
    }

    /**
     *功能描述: 获取E05 项目奖金-项目级-按产生部门类别-年度-导出excel
     */
    @GetMapping(value = "/pbonus/depyeardownload")
    @RequiredExportLog
    public void exportProjectLevelBonusDepYear(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        List<ProjectLevelBonusDepTypeByYearVO> list = projectLevelBonusManager.exportProjectLevelBonusDepYear(queryCnd);
        ExportExcel.export(list,ProjectLevelBonusDepTypeByYearVO.class,"E05-项目奖金-项目级-按产生部门类别-年度",response);
    }

    /**
     *功能描述: 获取E06 项目奖金-项目级-按产生部门类别-月度
     */
    @GetMapping(value = "/pbonus/depmonth")
    public OfficeResopnseBean getProjectLevelBonusDepMonth(ProjectReportQueryCnd queryCnd){
        Result<ProjectLevelBonusDepTypeByMonthVO> result = projectLevelBonusManager.getProjectLevelBonusDepMonth(queryCnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        log.info(JSONUtils.toString(result));
        return responseBean;
    }

    /**
     *功能描述: 获取E06 项目奖金-项目级-按产生部门类别-月度-导出excel
     */
    @GetMapping(value = "/pbonus/depmonthdownload")
    @RequiredExportLog
    public void exportProjectLevelBonusDepMonth(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        List<ProjectLevelBonusDepTypeByMonthVO> list = projectLevelBonusManager.exportProjectLevelBonusDepMonth(queryCnd);
        ExportExcel.export(list,ProjectLevelBonusDepTypeByMonthVO.class,"E06-项目奖金-项目级-按产生部门类别-月度",response);
    }
    /**
     *功能描述: 获取E07 项目奖金-合同级-全部-小计
     */
    @GetMapping(value = "/cbonus/allsubtotal")
    public OfficeResopnseBean getContractLevelBonusAllSubtotal(ProjectReportQueryCnd queryCnd){
        Result<ContractLevelBonusAllSubtotalVO> result = contractLevelBonusManager.getContractLevelBonusAllSubtotal(queryCnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        log.info(JSONUtils.toString(result));
        return responseBean;
    }

    /**
     *功能描述: 获取E07 项目奖金-合同级-全部-小计-导出excel
     */
    @GetMapping(value = "/cbonus/allsubtotaldownload")
    @RequiredExportLog
    public void exportContractLevelBonusAllSubtotal(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        List<ContractLevelBonusAllSubtotalVO> list = contractLevelBonusManager.exportContractLevelBonusAllSubtotal(queryCnd);
        ExportExcel.export(list,ContractLevelBonusAllSubtotalVO.class,"E07-项目奖金-合同级-全部-小计",response);
    }

    /**
     *功能描述: 获取E08 项目奖金-合同级-全部-年度
     */
    @GetMapping(value = "/cbonus/allyear")
    public OfficeResopnseBean getContractLevelBonusAllYear(ProjectReportQueryCnd queryCnd){
        Result<ContractLevelBonusAllByYearVO> result = contractLevelBonusManager.getContractLevelBonusAllYear(queryCnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        log.info(JSONUtils.toString(result));
        return responseBean;
    }

    /**
     *功能描述: 获取E08 项目奖金-合同级-全部-年度-导出excel
     */
    @GetMapping(value = "/cbonus/allyeardownload")
    @RequiredExportLog
    public void exportContractLevelBonusAllYear(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        List<ContractLevelBonusAllByYearVO> list = contractLevelBonusManager.exportContractLevelBonusAllYear(queryCnd);
        ExportExcel.export(list,ContractLevelBonusAllByYearVO.class,"E08-项目奖金-合同级-全部-年度",response);
    }

    /**
     *功能描述: 获取E09 项目奖金-合同级-全部-月度
     */
    @GetMapping(value = "/cbonus/allmonth")
    public OfficeResopnseBean getContractLevelBonusAllMonth(ProjectReportQueryCnd queryCnd){
        Result<ContractLevelBonusAllByMonthVO> result = contractLevelBonusManager.getContractLevelBonusAllMonth(queryCnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        log.info(JSONUtils.toString(result));
        return responseBean;
    }

    /**
     *功能描述: 获取E09 项目奖金-合同级-全部-月度-导出excel
     */
    @GetMapping(value = "/cbonus/allmonthdownload")
    @RequiredExportLog
    public void exportContractLevelBonusAllMonth(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        List<ContractLevelBonusAllByMonthVO> list = contractLevelBonusManager.exportContractLevelBonusAllMonth(queryCnd);
        ExportExcel.export(list,ContractLevelBonusAllByMonthVO.class,"E09-项目奖金-合同级-全部-月度",response);
    }

    /**
     *功能描述: 获取E10 项目奖金-合同级-按产生部门类别-小计
     */
    @GetMapping(value = "/cbonus/depsubtotal")
    public OfficeResopnseBean getContractLevelBonusDepSubtotal(ProjectReportQueryCnd queryCnd){
        Result<ContractLevelBonusDepTypeSubtotalVO> result = contractLevelBonusManager.getContractLevelBonusDepSubtotal(queryCnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        log.info(JSONUtils.toString(result));
        return responseBean;
    }

    /**
     *功能描述: 获取E10 项目奖金-合同级-按产生部门类别-小计-导出excel
     */
    @GetMapping(value = "/cbonus/depsubtotalDownload")
    @RequiredExportLog
    public void exportContractLevelBonusDepSubtotal(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        List<ContractLevelBonusDepTypeSubtotalVO> list = contractLevelBonusManager.exportContractLevelBonusDepSubtotal(queryCnd);
        ExportExcel.export(list,ContractLevelBonusDepTypeSubtotalVO.class,"E10-项目奖金-合同级-按产生部门类别-小计",response);
    }

    /**
     *功能描述: 获取E11 项目奖金-合同级-按产生部门类别-年度
     */
    @GetMapping(value = "/cbonus/depyear")
    public OfficeResopnseBean getContractLevelBonusDepYear(ProjectReportQueryCnd queryCnd){
        Result<ContractLevelBonusDepTypeByYearVO> result = contractLevelBonusManager.getContractLevelBonusDepYear(queryCnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        log.info(JSONUtils.toString(result));
        return responseBean;
    }

    /**
     *功能描述: 获取E11 项目奖金-合同级-按产生部门类别-年度-导出excel
     */
    @GetMapping(value = "/cbonus/depyeardownload")
    @RequiredExportLog
    public void exportContractLevelBonusDepYear(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        List<ContractLevelBonusDepTypeByYearVO> list = contractLevelBonusManager.exportContractLevelBonusDepYear(queryCnd);
        ExportExcel.export(list,ContractLevelBonusDepTypeByYearVO.class,"E11-项目奖金-合同级-按产生部门类别-年度",response);
    }

    /**
     *功能描述: 获取E12 项目奖金-合同级-按产生部门类别-月度
     */
    @GetMapping(value = "/cbonus/depmonth")
    public OfficeResopnseBean getContractLevelBonusDepMonth(ProjectReportQueryCnd queryCnd){
        Result<ContractLevelBonusDepTypeByMonthVO> result = contractLevelBonusManager.getContractLevelBonusDepMonth(queryCnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        log.info(JSONUtils.toString(result));
        return responseBean;
    }

    /**
     *功能描述: 获取E12 项目奖金-合同级-按产生部门类别-月度-导出excel
     */
    @GetMapping(value = "/cbonus/depmonthdownload")
    @RequiredExportLog
    public void exportContractLevelBonusDepMonth(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        List<ContractLevelBonusDepTypeByMonthVO> list = contractLevelBonusManager.exportContractLevelBonusDepMonth(queryCnd);
        ExportExcel.export(list,ContractLevelBonusDepTypeByMonthVO.class,"E12-项目奖金-合同级-按产生部门类别-月度",response);
    }
}
