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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = "/manpowerreport")
@Slf4j
public class ProjectReportManPowerController {
    @Autowired
    private ProjectLevelWorkLoadManager projectLevelWorkLoadManager;
    @Autowired
    private ContractLevelworkloadManager contractLevelworkloadManager;
    @Autowired
    private ProjectLevelManPowerMoneyManager projectLevelManPowerMoneyManager;
    @Autowired
    private ContractLevelManPowerMoneyManager contractLevelManPowerMoneyManager;


    /**
     * B01 获取报表人力成本-工作量-项目级-全部-小计
     */
    @RequestMapping(value = "/projectworkload/all",method = RequestMethod.GET)
    public OfficeResopnseBean projectLevelworkloadAll(ProjectReportQueryCnd queryCnd){
        Result<ProjectLevelworkloadAllVO> result = projectLevelWorkLoadManager.getProjectLevelworkloadAll(queryCnd);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(result);
        log.info(JSONUtils.toString(result));
        return bean;
    }

    /**
     * B01 导出报表人力成本-工作量-项目级-全部-小计
     */
    @RequestMapping(value = "/projectworkload/alldownload",method = RequestMethod.GET)
    @RequiredExportLog
    public void projectLevelworkloadAll(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        List<ProjectLevelworkloadAllVO> result = projectLevelWorkLoadManager.getProjectLevelworkloadAllList(queryCnd.getStartYear(),queryCnd.getEndYear());
        ExportExcel.export(result,ProjectLevelworkloadAllVO.class,"B01-工作量-项目级-全部-小计",response);
    }

    /**
     * B02 获取报表人力成本-工作量-项目级-全部-年度
     */
    @RequestMapping(value = "/projectworkload/allbyyear",method = RequestMethod.GET)
    public OfficeResopnseBean projectLevelworkloadAllByYear(ProjectReportQueryCnd queryCnd){
        Result<ProjectLevelworkloadAllByYearVO> result = projectLevelWorkLoadManager.getProjectLevelworkloadAllByYear(queryCnd);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(result);
        log.info(JSONUtils.toString(result));
        return bean;
    }

    /**
     * B02 导出  报表人力成本-工作量-项目级-全部-年度
     */
    @RequestMapping(value = "/projectworkload/allbyyeardownload",method = RequestMethod.GET)
    @RequiredExportLog
    public void projectLevelworkloadAllByYear(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        List<ProjectLevelworkloadAllByYearVO> result = projectLevelWorkLoadManager.getProjectLevelworkloadAllByYearList(queryCnd.getStartYear(),queryCnd.getEndYear());
        ExportExcel.export(result,ProjectLevelworkloadAllByYearVO.class,"B02-工作量-项目级-全部-年度",response);
    }

    /**
     * B03 获取报表人力成本-工作量-项目级-全部-月度
     */
    @RequestMapping(value = "/projectworkload/allbymonth",method = RequestMethod.GET)
    public OfficeResopnseBean projectLevelworkloadAllByMonth(ProjectReportQueryCnd queryCnd){
        Result<ProjectLevelworkloadAllByMonthVO> result = projectLevelWorkLoadManager.getProjectLevelworkloadAllByMonth(queryCnd);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(result);
        log.info(JSONUtils.toString(result));
        return bean;
    }

    /**
     * B03 导出  报表人力成本-工作量-项目级-全部-月度
     */
    @RequestMapping(value = "/projectworkload/allbymonthdownload",method = RequestMethod.GET)
    @RequiredExportLog
    public void projectLevelworkloadAllByMonth(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        List<ProjectLevelworkloadAllByMonthVO> result = projectLevelWorkLoadManager.getProjectLevelworkloadAllByMonthList(queryCnd.getStartYear(),queryCnd.getEndYear());
        ExportExcel.export(result,ProjectLevelworkloadAllByMonthVO.class,"B03-工作量-项目级-全部-月度",response);
    }

    /**
     * B04 获取报表人力成本-工作量-项目级-按产生部门类别-小计
     */
    @RequestMapping(value = "/projectworkload/allbydep",method = RequestMethod.GET)
    public OfficeResopnseBean projectLevelworkloadAllByDep(ProjectReportQueryCnd queryCnd){
        Result<ProjectLevelworkloadAllByDepVO> result = projectLevelWorkLoadManager.getProjectLevelworkloadAllByDep(queryCnd);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(result);
        log.info(JSONUtils.toString(result));
        return bean;
    }

    /**
     * B04 导出  报表人力成本-工作量-项目级-按产生部门类别-小计
     */
    @RequestMapping(value = "/projectworkload/allbydepdownload",method = RequestMethod.GET)
    @RequiredExportLog
    public void projectLevelworkloadAllByDep(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        List<ProjectLevelworkloadAllByDepVO> result = projectLevelWorkLoadManager.getProjectLevelworkloadAllByDepList(queryCnd.getStartYear(),queryCnd.getEndYear());
        ExportExcel.export(result,ProjectLevelworkloadAllByDepVO.class,"B04-工作量-项目级-按产生部门类别-小计",response);
    }

    /**
     * B05 获取报表人力成本-工作量-项目级-按产生部门类别-年度
     */
    @RequestMapping(value = "/projectworkload/allbydepbyyear",method = RequestMethod.GET)
    public OfficeResopnseBean projectLevelworkloadAllByDepByYear(ProjectReportQueryCnd queryCnd){
        Result<ProjectLevelworkloadAllByDepByYearVO> result = projectLevelWorkLoadManager.getProjectLevelworkloadAllVOByDepByYear(queryCnd);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(result);
        log.info(JSONUtils.toString(result));
        return bean;
    }

    /**
     * B05 导出  报表人力成本-工作量-项目级-按产生部门类别-年度
     */
    @RequestMapping(value = "/projectworkload/allbydepbyyeardownload",method = RequestMethod.GET)
    @RequiredExportLog
    public void projectLevelworkloadAllByDepByYear(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        List<ProjectLevelworkloadAllByDepByYearVO> result = projectLevelWorkLoadManager.getProjectLevelworkloadAllVOByDepByYearList(queryCnd.getStartYear(),queryCnd.getEndYear());
        ExportExcel.export(result,ProjectLevelworkloadAllByDepByYearVO.class,"B05-工作量-项目级-按产生部门类别-年度",response);
    }

    /**
     * B06 获取报表人力成本-工作量-项目级-按产生部门类别-月度
     */
    @RequestMapping(value = "/projectworkload/allbydepbymonth",method = RequestMethod.GET)
    public OfficeResopnseBean projectLevelworkloadAllByDepByMonth(ProjectReportQueryCnd queryCnd){
        Result<ProjectLevelworkloadAllByDepByMonthVO> result = projectLevelWorkLoadManager.getProjectLevelworkloadAllVOByDepByMonth(queryCnd);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(result);
        log.info(JSONUtils.toString(result));
        return bean;
    }

    /**
     * B06 导出报表人力成本-工作量-项目级-按产生部门类别-月度
     */
    @RequestMapping(value = "/projectworkload/allbydepbymonthdownload",method = RequestMethod.GET)
    @RequiredExportLog
    public void projectLevelworkloadAllByDepByMonth(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        List<ProjectLevelworkloadAllByDepByMonthVO> result = projectLevelWorkLoadManager.getProjectLevelworkloadAllVOByDepByMonthList(queryCnd.getStartYear(),queryCnd.getEndYear());
        ExportExcel.export(result,ProjectLevelworkloadAllByDepByMonthVO.class,"B06-工作量-项目级-按产生部门类别-月度",response);
    }

    /**
     * B07 获取报表人力成本-工作量-合同级-全部-小计
     */
    @RequestMapping(value = "/contractworkload/all",method = RequestMethod.GET)
    public OfficeResopnseBean contractLevelworkloadAll(ProjectReportQueryCnd queryCnd){
        Result<ContractLevelworkloadAllVO> result = contractLevelworkloadManager.getContractLevelworkloadAll(queryCnd);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(result);
        log.info(JSONUtils.toString(result));
        return bean;
    }

    /**
     * B07 导出  报表人力成本-工作量-合同级-全部-小计
     */
    @RequestMapping(value = "/contractworkload/alldownload",method = RequestMethod.GET)
    @RequiredExportLog
    public void contractLevelworkloadAll(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        List<ContractLevelworkloadAllVO> result = contractLevelworkloadManager.getContractLevelworkloadAllList(queryCnd.getStartYear(),queryCnd.getEndYear());
        ExportExcel.export(result,ContractLevelworkloadAllVO.class,"B07-工作量-合同级-全部-小计",response);
    }

    /**
     * B08 获取报表人力成本-工作量-合同级-全部-年度
     */
    @RequestMapping(value = "/contractworkload/allbyyear",method = RequestMethod.GET)
    public OfficeResopnseBean contractLevelworkloadAllByYear(ProjectReportQueryCnd queryCnd){
        Result<ContractLevelworkloadAllByYearVO> result = contractLevelworkloadManager.getContractLevelworkloadAllByYear(queryCnd);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(result);
        log.info(JSONUtils.toString(result));
        return bean;
    }

    /**
     * B08 导出  报表人力成本-工作量-合同级-全部-年度
     */
    @RequestMapping(value = "/contractworkload/allbyyeardownload",method = RequestMethod.GET)
    @RequiredExportLog
    public void contractLevelworkloadAllByYear(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        List<ContractLevelworkloadAllByYearVO> result = contractLevelworkloadManager.getContractLevelworkloadAllByYearList(queryCnd.getStartYear(),queryCnd.getEndYear());
        ExportExcel.export(result,ContractLevelworkloadAllByYearVO.class,"B08-工作量-合同级-全部-年度",response);
    }

    /**
     * B09 获取报表人力成本-工作量-合同级-全部-月度
     */
    @RequestMapping(value = "/contractworkload/allbymonth",method = RequestMethod.GET)
    public OfficeResopnseBean contractLevelworkloadAllByMonth(ProjectReportQueryCnd queryCnd){
        Result<ContractLevelworkloadAllByMonthVO> result = contractLevelworkloadManager.getContractLevelworkloadAllByMonth(queryCnd);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(result);
        log.info(JSONUtils.toString(result));
        return bean;
    }

    /**
     * B09 导出  报表人力成本-工作量-合同级-全部-月度
     */
    @RequestMapping(value = "/contractworkload/allbymonthdownload",method = RequestMethod.GET)
    @RequiredExportLog
    public void contractLevelworkloadAllByMonth(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        List<ContractLevelworkloadAllByMonthVO> result = contractLevelworkloadManager.getContractLevelworkloadAllByMonthList(queryCnd.getStartYear(),queryCnd.getEndYear());
        ExportExcel.export(result,ContractLevelworkloadAllByMonthVO.class,"B09-工作量-合同级-全部-月度",response);
    }

    /**
     * B10 获取报表人力成本-工作量-合同级-按产生部门类别-小计
     */
    @RequestMapping(value = "/contractworkload/allbydep",method = RequestMethod.GET)
    public OfficeResopnseBean contractLevelworkloadAllByDep(ProjectReportQueryCnd queryCnd){
        Result<ContractLevelworkloadAllByDepVO> result = contractLevelworkloadManager.getContractLevelworkloadAllByDep(queryCnd);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(result);
        log.info(JSONUtils.toString(result));
        return bean;
    }

    /**
     * B10 导出  报表人力成本-工作量-合同级-按产生部门类别-小计
     */
    @RequestMapping(value = "/contractworkload/allbydepdownload",method = RequestMethod.GET)
    @RequiredExportLog
    public void contractLevelworkloadAllByDep(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        List<ContractLevelworkloadAllByDepVO> result = contractLevelworkloadManager.getContractLevelworkloadAllByDepList(queryCnd.getStartYear(),queryCnd.getEndYear());
        ExportExcel.export(result,ContractLevelworkloadAllByDepVO.class,"B10-工作量-合同级-按产生部门类别-小计",response);
    }

    /**
     * B11 获取报表人力成本-工作量-合同级-按产生部门类别-年度
     */
    @RequestMapping(value = "/contractworkload/allbydepbyyear",method = RequestMethod.GET)
    public OfficeResopnseBean contractLevelworkloadAllByDepByYear(ProjectReportQueryCnd queryCnd){
        Result<ContractLevelworkloadAllByDepByYearVO> result = contractLevelworkloadManager.getContractLevelworkloadAllByDepByYear(queryCnd);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(result);
        log.info(JSONUtils.toString(result));
        return bean;
    }

    /**
     * B11 导出 报表人力成本-工作量-合同级-按产生部门类别-年度
     */
    @RequestMapping(value = "/contractworkload/allbydepbyyeardownload",method = RequestMethod.GET)
    @RequiredExportLog
    public void contractLevelworkloadAllByDepByYear(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        List<ContractLevelworkloadAllByDepByYearVO> result = contractLevelworkloadManager.getContractLevelworkloadAllByDepByYearList(queryCnd.getStartYear(),queryCnd.getEndYear());
        ExportExcel.export(result,ContractLevelworkloadAllByDepByYearVO.class,"B11-工作量-合同级-按产生部门类别-年度",response);
    }

    /**
     * B12 获取报表人力成本-工作量-合同级-按产生部门类别-月度
     */
    @RequestMapping(value = "/contractWorkload/allByDepByMonth",method = RequestMethod.GET)
    public OfficeResopnseBean contractLevelworkloadAllByDepByMonth(ProjectReportQueryCnd queryCnd){
        Result<ContractLevelworkloadAllByDepByMonthVO> result = contractLevelworkloadManager.getContractLevelworkloadAllByDepByMonth(queryCnd);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(result);
        log.info(JSONUtils.toString(result));
        return bean;
    }

    /**
     * B12 导出 报表人力成本-工作量-合同级-按产生部门类别-月度
     */
    @RequestMapping(value = "/contractWorkload/allByDepByMonthDownload",method = RequestMethod.GET)
    @RequiredExportLog
    public void contractLevelworkloadAllByDepByMonth(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        List<ContractLevelworkloadAllByDepByMonthVO> result = contractLevelworkloadManager.getContractLevelworkloadAllByDepByMonthList(queryCnd.getStartYear(),queryCnd.getEndYear());
        ExportExcel.export(result,ContractLevelworkloadAllByDepByMonthVO.class,"B12-工作量-合同级-按产生部门类别-月度",response);
    }

    /**
     * C01 获取报表人力成本-金额-项目级-全部-小计
     * @param queryCnd
     * @return
     */
    @RequestMapping(value = "/pmoney/all",method = RequestMethod.GET)
    public OfficeResopnseBean projectLevelMoneyAll(ProjectReportQueryCnd queryCnd){
        Result<ProjectLevelManPowerMoneyAllVO> result = projectLevelManPowerMoneyManager.getProjectLevelmoneyloadAll(queryCnd);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(result);
        log.info(JSONUtils.toString(result));
        return bean;
    }

    /**
     * C01 导出  报表人力成本-金额-项目级-全部-小计
     * @param queryCnd
     * @param response
     */
    @RequestMapping(value = "/pmoney/alldownload",method = RequestMethod.GET)
    @RequiredExportLog
    public void projectLevelMoneyAll(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        List<ProjectLevelManPowerMoneyAllVO> result = projectLevelManPowerMoneyManager.getProjectLevelmoneyloadAllList(queryCnd.getStartYear(),queryCnd.getEndYear());
        ExportExcel.export(result,ProjectLevelManPowerMoneyAllVO.class,"C01-金额-项目级-全部-小计",response);
    }

    /**
     * C02 获取报表人力成本-金额-项目级-全部-年度
     * @param queryCnd
     * @return
     */
    @RequestMapping(value = "/pmoney/allbyyear",method = RequestMethod.GET)
    public OfficeResopnseBean projectLevelMoneyAllByYear(ProjectReportQueryCnd queryCnd){
        Result<ProjectLevelManPowerMoneyAllByYearVO> result = projectLevelManPowerMoneyManager.getProjectLevelmoneyloadAllByYear(queryCnd);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(result);
        log.info(JSONUtils.toString(result));
        return bean;
    }

    /**
     * C02 导出  报表人力成本-金额-项目级-全部-年度
     * @param queryCnd
     * @param response
     */
    @RequestMapping(value = "/pmoney/allbyyeardownload",method = RequestMethod.GET)
    @RequiredExportLog
    public void projectLevelMoneyAllByYear(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        List<ProjectLevelManPowerMoneyAllByYearVO> result = projectLevelManPowerMoneyManager.getProjectLevelmoneyloadAllByYearList(queryCnd.getStartYear(),queryCnd.getEndYear());
        ExportExcel.export(result,ProjectLevelManPowerMoneyAllByYearVO.class,"C02-金额-项目级-全部-年度",response);
    }

    /**
     * C03 获取报表人力成本-金额-项目级-全部-月度
     * @param queryCnd
     * @return
     */
    @RequestMapping(value = "/pmoney/allbymonth",method = RequestMethod.GET)
    public OfficeResopnseBean projectLevelMoneyAllByMonth(ProjectReportQueryCnd queryCnd){
        Result<ProjectLevelManPowerMoneyAllByMonthVO> result = projectLevelManPowerMoneyManager.getProjectLevelmoneyloadAllByMonth(queryCnd);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(result);
        log.info(JSONUtils.toString(result));
        return bean;
    }

    /**
     * C03 导出报表人力成本-金额-项目级-全部-月度
     * @param queryCnd
     * @param response
     */
    @RequestMapping(value = "/pmoney/allbymonthdownload",method = RequestMethod.GET)
    @RequiredExportLog
    public void projectLevelMoneyAllByMonth(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        List<ProjectLevelManPowerMoneyAllByMonthVO> result = projectLevelManPowerMoneyManager.getProjectLevelmoneyloadAllByMonthList(queryCnd.getStartYear(),queryCnd.getEndYear());
        ExportExcel.export(result,ProjectLevelManPowerMoneyAllByMonthVO.class,"C03-金额-项目级-全部-月度",response);
    }

    /**
     * C04 获取报表人力成本-金额-项目级-按产生部门类别-小计
     * @param queryCnd
     * @return
     */
    @RequestMapping(value = "/pmoney/allbydep",method = RequestMethod.GET)
    public OfficeResopnseBean projectLevelMoneyAllByDep(ProjectReportQueryCnd queryCnd){
        Result<ProjectLevelManPowerMoneyAllByDepVO> result = projectLevelManPowerMoneyManager.getProjectLevelmoneyloadAllByDep(queryCnd);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(result);
        log.info(JSONUtils.toString(result));
        return bean;
    }

    /**
     * C04 导出报表人力成本-金额-项目级-按产生部门类别-小计
     * @param queryCnd
     * @param response
     */
    @RequestMapping(value = "/pmoney/allbydepdownload",method = RequestMethod.GET)
    @RequiredExportLog
    public void projectLevelMoneyAllByDep(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        List<ProjectLevelManPowerMoneyAllByDepVO> result = projectLevelManPowerMoneyManager.getProjectLevelmoneyloadAllByDepList(queryCnd.getStartYear(),queryCnd.getEndYear());
        ExportExcel.export(result,ProjectLevelManPowerMoneyAllByDepVO.class,"C04-金额-项目级-按产生部门类别-小计",response);
    }

    /**
     * C05 获取报表人力成本-金额-项目级-按产生部门类别-年度
     * @param queryCnd
     * @return
     */
    @RequestMapping(value = "/pmoney/allbydepbyyear",method = RequestMethod.GET)
    public OfficeResopnseBean projectLevelMoneyAllByDepByYear(ProjectReportQueryCnd queryCnd){
        Result<ProjectLevelManPowerMoneyAllByDepByYearVO> result = projectLevelManPowerMoneyManager.getProjectLevelmoneyloadAllVOByDepByYear(queryCnd);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(result);
        log.info(JSONUtils.toString(result));
        return bean;
    }

    /**
     * C05 导出  报表人力成本-金额-项目级-按产生部门类别-年度
     * @param queryCnd
     * @param response
     */
    @RequestMapping(value = "/pmoney/allbydepbyyeardownload",method = RequestMethod.GET)
    @RequiredExportLog
    public void projectLevelMoneyAllByDepByYear(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        List<ProjectLevelManPowerMoneyAllByDepByYearVO> result = projectLevelManPowerMoneyManager.getProjectLevelmoneyloadAllVOByDepByYearList(queryCnd.getStartYear(),queryCnd.getEndYear());
        ExportExcel.export(result,ProjectLevelManPowerMoneyAllByDepByYearVO.class,"C05-金额-项目级-按产生部门类别-年度",response);
    }

    /**
     * C06 获取报表人力成本-金额-项目级-按产生部门类别-月度
     * @param queryCnd
     * @return
     */
    @RequestMapping(value = "/pmoney/allbydepbymonth",method = RequestMethod.GET)
    public OfficeResopnseBean projectLevelMoneyAllByDepByMonth(ProjectReportQueryCnd queryCnd){
        Result<ProjectLevelManPowerMoneyAllByDepByMonthVO> result = projectLevelManPowerMoneyManager.getProjectLevelmoneyloadAllVOByDepByMonth(queryCnd);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(result);
        log.info(JSONUtils.toString(result));
        return bean;
    }

    /**
     * C06 导出 报表人力成本-金额-项目级-按产生部门类别-月度
     * @param queryCnd
     * @param response
     */
    @RequestMapping(value = "/pmoney/allbydepbymonthdownload",method = RequestMethod.GET)
    @RequiredExportLog
    public void projectLevelMoneyAllByDepByMonth(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        List<ProjectLevelManPowerMoneyAllByDepByMonthVO> result = projectLevelManPowerMoneyManager.getProjectLevelmoneyloadAllVOByDepByMonthList(queryCnd.getStartYear(),queryCnd.getEndYear());
        ExportExcel.export(result,ProjectLevelManPowerMoneyAllByDepByMonthVO.class,"C06-金额-项目级-按产生部门类别-月度",response);
    }


    /**
     * C07 获取报表人力成本-金额-合同级-全部-小计
     * @param queryCnd
     * @return
     */
    @RequestMapping(value = "/cmoney/all",method = RequestMethod.GET)
    public OfficeResopnseBean contractLevelMoneyAll(ProjectReportQueryCnd queryCnd){
        Result<ContractLevelManPowerMoneyAllVO> result = contractLevelManPowerMoneyManager.getContractLevelmoneyloadAll(queryCnd);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(result);
        log.info(JSONUtils.toString(result));
        return bean;
    }

    /**
     * C07 导出 报表人力成本-金额-合同级-全部-小计
     * @param queryCnd
     * @param response
     */
    @RequestMapping(value = "/cmoney/alldownload",method = RequestMethod.GET)
    @RequiredExportLog
    public void contractLevelMoneyAll(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        List<ContractLevelManPowerMoneyAllVO> result = contractLevelManPowerMoneyManager.getContractLevelmoneyloadAllList(queryCnd.getStartYear(),queryCnd.getEndYear());
        ExportExcel.export(result,ContractLevelManPowerMoneyAllVO.class,"C07-金额-合同级-全部-小计",response);
    }

    /**
     * C08 获取报表人力成本-金额-合同级-全部-年度
     * @param queryCnd
     * @return
     */
    @RequestMapping(value = "/cmoney/allbyyear",method = RequestMethod.GET)
    public OfficeResopnseBean contractLevelMoneyAllByYear(ProjectReportQueryCnd queryCnd){
        Result<ContractLevelManPowerMoneyAllByYearVO> result = contractLevelManPowerMoneyManager.getContractLevelmoneyloadAllByYear(queryCnd);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(result);
        log.info(JSONUtils.toString(result));
        return bean;
    }

    /**
     * C08 导出  报表人力成本-金额-合同级-全部-年度
     * @param queryCnd
     * @param response
     */
    @RequestMapping(value = "/cmoney/allbyyeardownload",method = RequestMethod.GET)
    @RequiredExportLog
    public void contractLevelMoneyAllByYear(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        List<ContractLevelManPowerMoneyAllByYearVO> result = contractLevelManPowerMoneyManager.getContractLevelmoneyloadAllByYearList(queryCnd.getStartYear(),queryCnd.getEndYear());
        ExportExcel.export(result,ContractLevelManPowerMoneyAllByYearVO.class,"C08-金额-合同级-全部-年度",response);
    }

    /**
     * C09 获取报表人力成本-金额-合同级-全部-月度
     * @param queryCnd
     * @return
     */
    @RequestMapping(value = "/cmoney/allbymonth",method = RequestMethod.GET)
    public OfficeResopnseBean contractLevelMoneyAllByMonth(ProjectReportQueryCnd queryCnd){
        Result<ContractLevelManPowerMoneyAllByMonthVO> result = contractLevelManPowerMoneyManager.getContractLevelmoneyloadAllByMonth(queryCnd);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(result);
        log.info(JSONUtils.toString(result));
        return bean;
    }

    /**
     * C09 导出  报表人力成本-金额-合同级-全部-月度
     * @param queryCnd
     * @param response
     */
    @RequestMapping(value = "/cmoney/allbymonthdownload",method = RequestMethod.GET)
    @RequiredExportLog
    public void contractLevelMoneyAllByMonth(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        List<ContractLevelManPowerMoneyAllByMonthVO> result = contractLevelManPowerMoneyManager.getContractLevelmoneyloadAllByMonthList(queryCnd.getStartYear(),queryCnd.getEndYear());
        ExportExcel.export(result,ContractLevelManPowerMoneyAllByMonthVO.class,"C09-金额-合同级-全部-月度",response);
    }

    /**
     * C10 获取报表人力成本-金额-合同级-按产生部门类别-小计
     * @param queryCnd
     * @return
     */
    @RequestMapping(value = "/cmoney/allbydep",method = RequestMethod.GET)
    public OfficeResopnseBean contractLevelMoneyAllByDep(ProjectReportQueryCnd queryCnd){
        Result<ContractLevelManPowerMoneyAllByDepVO> result = contractLevelManPowerMoneyManager.getContractLevelmoneyloadAllByDep(queryCnd);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(result);
        log.info(JSONUtils.toString(result));
        return bean;
    }

    /**
     * C10 导出  报表人力成本-金额-合同级-按产生部门类别-小计
     * @param queryCnd
     * @param response
     */
    @RequestMapping(value = "/cmoney/allbydepdownload",method = RequestMethod.GET)
    @RequiredExportLog
    public void contractLevelMoneyAllByDep(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        List<ContractLevelManPowerMoneyAllByDepVO> result = contractLevelManPowerMoneyManager.getContractLevelmoneyloadAllByDepList(queryCnd.getStartYear(),queryCnd.getEndYear());
        ExportExcel.export(result,ContractLevelManPowerMoneyAllByDepVO.class,"C10-金额-合同级-按产生部门类别-小计",response);
    }

    /**
     * C11 获取报表人力成本-金额-合同级-按产生部门类别-年度
     * @param queryCnd
     * @return
     */
    @RequestMapping(value = "/cmoney/allbydepbyyear",method = RequestMethod.GET)
    public OfficeResopnseBean contractLevelMoneyAllByDepByYear(ProjectReportQueryCnd queryCnd){
        Result<ContractLevelManPowerMoneyAllByDepByYearVO> result = contractLevelManPowerMoneyManager.getContractLevelmoneyloadAllVOByDepByYear(queryCnd);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(result);
        log.info(JSONUtils.toString(result));
        return bean;
    }

    /**
     * C11 导出 报表人力成本-金额-合同级-按产生部门类别-年度
     * @param queryCnd
     * @param response
     */
    @RequestMapping(value = "/cmoney/allbydepbyyeardownload",method = RequestMethod.GET)
    @RequiredExportLog
    public void contractLevelMoneyAllByDepByYear(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        List<ContractLevelManPowerMoneyAllByDepByYearVO> result = contractLevelManPowerMoneyManager.getContractLevelmoneyloadAllVOByDepByYearList(queryCnd.getStartYear(),queryCnd.getEndYear());
        ExportExcel.export(result,ContractLevelManPowerMoneyAllByDepByYearVO.class,"C11-金额-合同级-按产生部门类别-年度",response);
    }

    /**
     * C12 获取报表人力成本-获取报表人力成本-金额-合同级-按产生部门类别-月度
     * @param queryCnd
     * @return
     */
    @RequestMapping(value = "/cmoney/allbydepbymonth",method = RequestMethod.GET)
    public OfficeResopnseBean contractLevelMoneyAllByDepByMonth(ProjectReportQueryCnd queryCnd){
        Result<ContractLevelManPowerMoneyAllByDepByMonthVO> result = contractLevelManPowerMoneyManager.getContractLevelmoneyloadAllVOByDepByMonth(queryCnd);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(result);
        log.info(JSONUtils.toString(result));
        return bean;
    }

    /**
     * C12 导出  报表人力成本-获取报表人力成本-金额-合同级-按产生部门类别-月度
     * @param queryCnd
     * @param response
     */
    @RequestMapping(value = "/cmoney/allbydepbymonthdownload",method = RequestMethod.GET)
    @RequiredExportLog
    public void contractLevelMoneyAllByDepByMonth(ProjectReportQueryCnd queryCnd, ExportLogParams params, HttpServletResponse response){
        List<ContractLevelManPowerMoneyAllByDepByMonthVO> result = contractLevelManPowerMoneyManager.getContractLevelmoneyloadAllVOByDepByMonthList(queryCnd.getStartYear(),queryCnd.getEndYear());
        ExportExcel.export(result,ContractLevelManPowerMoneyAllByDepByMonthVO.class,"C12-金额-合同级-按产生部门类别-月度",response);
    }


}
