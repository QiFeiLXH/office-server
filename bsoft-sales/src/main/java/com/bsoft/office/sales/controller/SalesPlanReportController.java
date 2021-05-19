package com.bsoft.office.sales.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.annotation.RequiredExportLog;
import com.bsoft.office.common.condition.ExportLogParams;
import com.bsoft.office.common.exportExcel.*;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.common.vo.PublicDicVO;
import com.bsoft.office.common.vo.SystemDicVO;
import com.bsoft.office.sales.condition.SalesPlanQueryCndVO;
import com.bsoft.office.sales.manager.SalesPlanReportManager;
import com.bsoft.office.sales.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: zy
 * @date: 2020/11/19
 * @description
 */
@RestController
@RequestMapping("salesplan/report")
public class SalesPlanReportController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SalesPlanReportController.class);
    @Autowired
    private SalesPlanReportManager salesPlanReportManager;

    /** 获取销售计划列表*/
    @GetMapping("/list")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取销售线索计划列表")
    public OfficeResopnseBean listSalesPlanReports(SalesPlanQueryCndVO queryCndVO, HttpServletRequest request) {
        LOGGER.info("获取销售线索计划列表[{}]", JSONUtils.toString(queryCndVO));
        String userId = ContextUtils.getUserId(request);
        Result<SalesPlanReportVO> result = salesPlanReportManager.listSalesPlanReports(userId, queryCndVO);
        return OfficeResopnseBean.newSuccessBean(result);
    }

    /** 获取销售计划跟单人列表*/
    @GetMapping("/personlist")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取销售线索计划跟单人列表")
    public OfficeResopnseBean listPersons(SalesPlanQueryCndVO queryCndVO, HttpServletRequest request) {
        LOGGER.info("获取销售线索计划跟单人列表");
        String userId = ContextUtils.getUserId(request);
        List<SalesPlanPersonVO> result = salesPlanReportManager.listPersons(userId, queryCndVO);
        return OfficeResopnseBean.newSuccessBean(result);
    }

    /** 获取销售计划跟单部门列表*/
    @GetMapping("/deptlist")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取销售计划跟单部门列表")
    public OfficeResopnseBean listDeptTree(SalesPlanQueryCndVO queryCndVO, HttpServletRequest request) {
        LOGGER.info("获取销售计划跟单部门列表");
        String userId = ContextUtils.getUserId(request);
        List<SalesPlanDeptVO> result = salesPlanReportManager.listDepts(userId, queryCndVO);
        return OfficeResopnseBean.newSuccessBean(result);
    }

    /** 获取业务归属列表*/
    @GetMapping("/businessbelonglist")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取业务归属列表")
    public OfficeResopnseBean listBusinessBelongs(HttpServletRequest request) {
        LOGGER.info("获取业务归属列表");
        String userId = ContextUtils.getUserId(request);
        List<PublicDicVO> result = salesPlanReportManager.listBusinessBelongs();
        return OfficeResopnseBean.newSuccessBean(result);
    }

    /** 获取线索性质列表*/
    @GetMapping("/cluesnaturelist")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取线索性质列表")
    public OfficeResopnseBean listCluesNatures(HttpServletRequest request) {
        LOGGER.info("获取线索性质列表");
        String userId = ContextUtils.getUserId(request);
        List<SystemDicVO> result = salesPlanReportManager.listCluesNatures();
        return OfficeResopnseBean.newSuccessBean(result);
    }

    /** 获取线索切入阶段列表*/
    @GetMapping("/stagelist")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取线索切入阶段列表")
    public OfficeResopnseBean listStages(HttpServletRequest request) {
        LOGGER.info("获取线索切入阶段列表");
        String userId = ContextUtils.getUserId(request);
        List<SystemDicVO> result = salesPlanReportManager.listStages();
        return OfficeResopnseBean.newSuccessBean(result);
    }

    /** 获取线索状态列表*/
    @GetMapping("/statuslist")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取线索状态列表")
    public OfficeResopnseBean listStatus(HttpServletRequest request) {
        LOGGER.info("获取线索状态列表");
        String userId = ContextUtils.getUserId(request);
        List<SystemDicVO> result = salesPlanReportManager.listStatus();
        return OfficeResopnseBean.newSuccessBean(result);
    }

    /** 获取计划来源列表*/
    @GetMapping("/plansourcelist")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取计划来源列表")
    public OfficeResopnseBean getPlanSourceList(HttpServletRequest request) {
        LOGGER.info("获取计划来源列表");
        String userId = ContextUtils.getUserId(request);
        List<SystemDicVO> result = salesPlanReportManager.getPlanSourceList();
        return OfficeResopnseBean.newSuccessBean(result);
    }

    /** 获取线索来源列表*/
    @GetMapping("/cluessourcelist")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取线索来源列表")
    public OfficeResopnseBean getCluesSourceList(HttpServletRequest request) {
        LOGGER.info("获取线索来源列表");
        String userId = ContextUtils.getUserId(request);
        List<SystemDicVO> result = salesPlanReportManager.getCluesSourceList();
        return OfficeResopnseBean.newSuccessBean(result);
    }


    /** 获取销售线索基本信息*/
    @GetMapping("/clueinfo")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取销售计划详细信息")
    public OfficeResopnseBean getCluesInfo(@RequestParam Integer clueId, HttpServletRequest request) {
        LOGGER.info("获取销售计划详细信息");
        String userId = ContextUtils.getUserId(request);
        SalesPlanDetailViewVO salesPlanDetail = salesPlanReportManager.getSalesPlanDetail(userId, clueId);
        return OfficeResopnseBean.newSuccessBean(salesPlanDetail);
    }

    /** 获取线索状态列表*/
    @GetMapping("/cluelist")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取线索状态列表")
    public OfficeResopnseBean listClues(SalesPlanQueryCndVO queryCndVO, HttpServletRequest request) {
        LOGGER.info("获取线索状态列表[{}]", JSONUtils.toString(queryCndVO));
        String userId = ContextUtils.getUserId(request);
        Result<SalesCluesViewVO> result = salesPlanReportManager.listClueForSearch(userId, queryCndVO);
        return OfficeResopnseBean.newSuccessBean(result);
    }

    /** 统计销售计划金额*/
    @GetMapping("/count")
    @OperLog(operType = OperLogType.QUERY,operDesc = "统计销售计划金额")
    public OfficeResopnseBean countMoney(SalesPlanQueryCndVO queryCndVO, HttpServletRequest request) {
        LOGGER.info("统计销售计划金额[{}]", JSONUtils.toString(queryCndVO));
        String userId = ContextUtils.getUserId(request);
        SalesPlanAmountVO result = salesPlanReportManager.countMoney(userId, queryCndVO);
        return OfficeResopnseBean.newSuccessBean(result);
    }

    /** 保存销售计划信息*/
    @PostMapping("/save")
    @OperLog(operType = OperLogType.SAVE,operDesc = "保存销售计划信息")
    public OfficeResopnseBean saveSalesPlanReport(@RequestBody SalesPlanReportVO saveVO, HttpServletRequest request) {
        LOGGER.info("保存销售计划信息[{}]", JSONUtils.toString(saveVO));
        String userId = ContextUtils.getUserId(request);
        saveVO.setStatus(2);
        salesPlanReportManager.saveSalesPlanReport(userId, saveVO);
        return OfficeResopnseBean.newSuccessBean();
    }

    /** 导入销售计划数据*/
    @PostMapping("/import")
    @OperLog(operType = OperLogType.IMPORT,operDesc = "导入销售计划数据")
    public OfficeResopnseBean importData(@RequestParam MultipartFile file, HttpServletRequest request) {
        LOGGER.info("导入销售计划数据[{}]", file.getOriginalFilename());
        String userId = ContextUtils.getUserId(request);
        try {
            // 读取Excel数据转换成VO
            List<SalesPlanReportExcelVO> list = ExcelUtils.readExcel(file, SalesPlanReportExcelVO.class, new ExcelListener<SalesPlanReportExcelVO>());
            // 保存VO并返回结果
            ImportResultVO result = salesPlanReportManager.importData(userId, list);
            return OfficeResopnseBean.newSuccessBean(result);
        } catch (IOException e) {
            return OfficeResopnseBean.newFailBean(500, "导入失败");
        }
    }

    /** 导出销售计划页面数据 */
    @PostMapping("/pagedownload")
    @RequiredExportLog
    @OperLog(operType = OperLogType.EXPORT,operDesc = "导出销售计划页面数据")
    public void exportData(ExportLogParams params,
                           @RequestBody SalesPlanQueryCndVO queryCndVO,
                           HttpServletRequest request,
                           HttpServletResponse response){
        LOGGER.info("导出销售计划页面数据[{}]", JSONUtils.toString(queryCndVO));
        String userId = ContextUtils.getUserId(request);
        List<SalesPlanReportExcelVO> list = salesPlanReportManager.exportData(userId, queryCndVO);
        String fileName = "销售计划页面数据";
        ExportExcel.doExport(list, SalesPlanReportExcelVO.class, fileName, response);
    }

    /** 导出销售计划错误数据 */
    @GetMapping("/errordownload")
    @RequiredExportLog
    @OperLog(operType = OperLogType.EXPORT,operDesc = "导出销售计划错误数据")
    public void exportErrorData(ExportLogParams params,HttpServletRequest request, HttpServletResponse response){
        LOGGER.info("导出销售计划错误数据");
        String userId = ContextUtils.getUserId(request);
        List<SalesPlanReportExcelErrorVO> list = salesPlanReportManager.exportErrorData(userId);
        List<CellRangeParam> cellRangeParams = initCellRangeParamList();
        String fileName = "销售计划导入失败数据";
        ExportExcel.doExportWithCustomStyle(list, SalesPlanReportExcelErrorVO.class, fileName, new CustomSheetWriterHandler(cellRangeParams), null, response);
    }

    /** 导出销售计划模板 */
    @GetMapping("/templatedownload")
    @RequiredExportLog
    @OperLog(operType = OperLogType.EXPORT,operDesc = "导出销售计划模板")
    public void exportTemplate(ExportLogParams params, HttpServletResponse response){
        LOGGER.info("导出销售计划模板");
        List<SalesPlanReportExcelVO> list = initTemplateData();
        List<CellRangeParam> cellRangeParams = initCellRangeParamList();
        String fileName = "销售计划导入模板";
        String noticeContent = "填表说明：\n" +
                "1、黄色底色内容必填\n" +
                "2、下拉选择业务归属、项目阶段、线索性质、计划来源\n" +
                "3、日期格式请与示例保持一致\n" +
                "4、导入前请将本行及示例数据删除";
        ExportExcel.doExportWithCustomStyle(list, SalesPlanReportExcelVO.class, fileName, new CustomSheetWriterHandler(cellRangeParams), new CustomCellWriteHandler(noticeContent), response);
    }

    /** 设置表格下拉框的参数*/
    private List<CellRangeParam> initCellRangeParamList() {
        List<CellRangeParam> cellRangeParams = new ArrayList<>();
        List<String> businessBelongList = salesPlanReportManager.listBusinessBelongs().stream().map(PublicDicVO::getName).collect(Collectors.toList());
        List<String> stageList = salesPlanReportManager.listStages().stream().map(SystemDicVO::getName).collect(Collectors.toList());
        List<String> cluesNatureList = salesPlanReportManager.listCluesNatures().stream().map(SystemDicVO::getName).collect(Collectors.toList());
        List<String> planSourceList = salesPlanReportManager.getPlanSourceList().stream().map(SystemDicVO::getName).collect(Collectors.toList());
        cellRangeParams.add(new CellRangeParam( 1, 999, 0, 0, businessBelongList.toArray(new String[businessBelongList.size()])));
        cellRangeParams.add(new CellRangeParam( 1, 999, 11, 11, stageList.toArray(new String[stageList.size()])));
        cellRangeParams.add(new CellRangeParam( 1, 999, 13, 13, cluesNatureList.toArray(new String[cluesNatureList.size()])));
        cellRangeParams.add(new CellRangeParam( 1, 999, 14, 14, planSourceList.toArray(new String[planSourceList.size()])));
        return cellRangeParams;
    }

    /** 模板数据 */
    private List<SalesPlanReportExcelVO> initTemplateData() {
        SalesPlanReportExcelVO template1 = new SalesPlanReportExcelVO();
        SalesPlanReportExcelVO template2 = new SalesPlanReportExcelVO();
        SalesPlanReportExcelVO template3 = new SalesPlanReportExcelVO();

        template1.setBusinessBelong("信息化事业群");
        template1.setTrackPerson("10713");
        template1.setTrackPersonName("张三");
        template1.setTrackDeptName("信息中心");
        template1.setCustomerName("中山大学附属第五医院");
        template1.setContent("智慧医院二期");
        template1.setEstimateSoftwareStr("100.00");
        template1.setEstimateNetSalesStr("80.00");
        template1.setEstimateHardwareStr("50.00");
        template1.setSignDateStr("2021-03-01");
        template1.setOpeningDate("2020-11-23");
        template1.setStage("合同谈判");
        template1.setLatestDevelopment("最新进展");
        template1.setCluesNature("争取");
        template1.setPlanSource("总办会");
        template1.setPlanDateStr("2020-12");

        List list = Arrays.asList(template1, template2, template3, template3, template3, template3);
        return list;
    }
}

