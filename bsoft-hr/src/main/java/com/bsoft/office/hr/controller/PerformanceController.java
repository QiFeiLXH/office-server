package com.bsoft.office.hr.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.annotation.RequiredExportLog;
import com.bsoft.office.common.condition.ExportLogParams;
import com.bsoft.office.common.exportExcel.CustomCellWriteHandler;
import com.bsoft.office.common.exportExcel.ExcelListener;
import com.bsoft.office.common.exportExcel.ExcelUtils;
import com.bsoft.office.common.exportExcel.ExportExcel;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.hr.manager.PerformanceManager;
import com.bsoft.office.hr.vo.PerformanceSaveResultVO;
import com.bsoft.office.hr.vo.PerformanceViewVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/7/20 9:21
 * @Description
 */
@RestController
@RequestMapping("/performance")
public class PerformanceController {
    private static Logger logger  = LoggerFactory.getLogger(PerformanceController.class);

    @Autowired
    private PerformanceManager performanceManager;

    @GetMapping("/query")
    @OperLog(operType = OperLogType.QUERY,operDesc = "年度绩效查询")
    public OfficeResopnseBean getPerformanceList(@RequestParam Integer year,
                                                 @RequestParam(name = "deptId", required = false) String deptId,
                                                 @RequestParam(name = "inputContent", required = false) String inputContent,
                                                 @RequestParam Integer pageNo,
                                                 @RequestParam Integer pageSize ){
        Result<PerformanceViewVO> result = performanceManager.getPerformanceList(year, deptId, inputContent, pageNo, pageSize);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        logger.info("获取年度绩效查询列表！[{}]", JSONUtils.toString(result));
        return responseBean;
    }

    @PostMapping("/delete")
    @OperLog(operType = OperLogType.DELETE,operDesc = "批量删除年度绩效")
    public OfficeResopnseBean deleteBatchPerformanceList(@RequestBody List<PerformanceViewVO> deletes){
        performanceManager.deleteBatchPerformanceList(deletes);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody("批量删除年度绩效成功！");
        logger.info("批量删除年度绩效成功");
        return responseBean;
    }

    /**
     *功能描述: 绩效模板列表导出
     */
    @GetMapping("/templatedownload")
    @RequiredExportLog
    @OperLog(operType = OperLogType.EXPORT,operDesc = "绩效管理-导出模板")
    public void exportPerformanceTemplate(ExportLogParams params,
                                          HttpServletResponse response){
        List<PerformanceViewVO> list = getTemplateData();
        ExportExcel.exportWithCustomStyle(list, PerformanceViewVO.class,"年度绩效导入模板",new CustomCellWriteHandler(),response);
        logger.info("绩效管理-导出模板成功！");
    }

    /** 年度绩效-导入数据 */
    @PostMapping("/import")
    @OperLog(operType = OperLogType.OTHER,operDesc = "年度绩效-导入数据")
    public OfficeResopnseBean importPerformanceData(@RequestParam MultipartFile file, HttpServletRequest request) {
        String personId = ContextUtils.getUserId(request);
        try {
            // 读取excel数据
            List<PerformanceViewVO> list = ExcelUtils.readExcel(file, PerformanceViewVO.class, new ExcelListener<PerformanceViewVO>());
            PerformanceSaveResultVO result = performanceManager.importPerformanceData(list, personId);
            OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
            responseBean.setBody(result);
            logger.info("年度绩效-导入数据成功！,成功导入：{}条数据", JSONUtils.toString(result));
            return responseBean;
        } catch (IOException e) {
            return OfficeResopnseBean.newFailBean(500, "导入失败");
        }
    }

    /**
     *功能描述: 年度绩效错误列表导出
     */
    @GetMapping("/errordownload")
    @OperLog(operType = OperLogType.EXPORT,operDesc = "年度绩效错误列表导出")
    public void exportPerformanceErrorRecords( HttpServletRequest request, HttpServletResponse response){
        String personId = ContextUtils.getUserId(request);
        List<PerformanceViewVO> list = performanceManager.getErrorPerformanceList(personId);
        ExportExcel.export(list,PerformanceViewVO.class,"年度绩效导入失败数据",response);
        logger.info("年度绩效错误数据成功！");
    }

    /** 模板数据 */
    private List<PerformanceViewVO> getTemplateData() {
        PerformanceViewVO template = new PerformanceViewVO();
        template.setPersonId("9765");
        template.setPersonName("徐某某");
        template.setYearStr("2020");
        template.setPerformanceStr("92");
        template.setEvaluationGrade("A");
        PerformanceViewVO template1 = new PerformanceViewVO();
        List list = Arrays.asList(template,template1,template1, template1, template1,template1);
        return list;

    }
}
