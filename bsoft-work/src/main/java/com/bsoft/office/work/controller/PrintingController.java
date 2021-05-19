package com.bsoft.office.work.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.annotation.RequiredExportLog;
import com.bsoft.office.common.condition.ExportLogParams;
import com.bsoft.office.common.exportExcel.*;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.work.condition.PrintingQueryCnd;
import com.bsoft.office.work.manager.PrintingManager;
import com.bsoft.office.work.vo.*;
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

/**
 * @Author Xuhui Lin
 * @Date 2021/1/27 15:59
 * @Description
 */
@RestController
@RequestMapping("/printing")
public class PrintingController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PrintingController.class);

    @Autowired
    private PrintingManager printingManager;

    @GetMapping("/list")
    @OperLog(operType = OperLogType.QUERY,operDesc = "文印列表")
    public OfficeResopnseBean getPrintingList(PrintingQueryCnd queryCnd) {
        Result<PrintingViewVO> result = printingManager.getPrintingList(queryCnd);
        return OfficeResopnseBean.newSuccessBean(result);
    }

    @GetMapping("/unpaidcount")
    @OperLog(operType = OperLogType.QUERY,operDesc = "文印未支付数量")
    public OfficeResopnseBean getPrintingUnpaidCount(PrintingQueryCnd queryCnd) {
        Integer count = printingManager.getPrintingUnpaidCount(queryCnd);
        return OfficeResopnseBean.newSuccessBean(count);
    }

    @GetMapping("/unpaidamount")
    @OperLog(operType = OperLogType.QUERY,operDesc = "文印未支付金额")
    public OfficeResopnseBean getPrintingUnpaidAmount() {
        Double amount = printingManager.getPrintingUnpaidAmount();
        return OfficeResopnseBean.newSuccessBean(amount);
    }

    @GetMapping("/totalamount")
    @OperLog(operType = OperLogType.QUERY,operDesc = "文印总金额")
    public OfficeResopnseBean getPrintingTotalAmount(@RequestParam(value = "printingIds", required = false) List<Integer> printingIds) {
        if (printingIds == null) {
            printingIds = new ArrayList<>();
        }
        Double amount = printingManager.getPrintingTotalAmount(printingIds);
        return OfficeResopnseBean.newSuccessBean(amount);
    }

    @GetMapping("/printingids")
    @OperLog(operType = OperLogType.QUERY,operDesc = "文印ids")
    public OfficeResopnseBean getPrintingIdList(PrintingQueryCnd queryCnd) {
        List<Integer> printingids = printingManager.getPrintingIdList(queryCnd);
        return OfficeResopnseBean.newSuccessBean(printingids);
    }

    @PostMapping("/save")
    @OperLog(operType = OperLogType.SAVE,operDesc = "文印保存")
    public OfficeResopnseBean savePrinting(@RequestBody PrintingViewVO printingViewVO) {
        printingManager.savePrinting(printingViewVO);
        return OfficeResopnseBean.newSuccessBean("修改核准金额成功！");
    }

    @PostMapping("/import")
    @OperLog(operType = OperLogType.IMPORT,operDesc = "文印导入")
    public OfficeResopnseBean importPrintingData(@RequestParam MultipartFile file, HttpServletRequest request) {
        String personId = ContextUtils.getUserId(request);
        try {
            List<PrintingTemplateVO> list = ExcelUtils.readExcel(file, PrintingTemplateVO.class, new ExcelListener<PrintingTemplateVO>());

            ImportResultVO result = printingManager.importPrintingData(list, personId);
            OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
            responseBean.setBody(result);
            return responseBean;
        } catch (IOException e) {
            return OfficeResopnseBean.newFailBean(500, "文印-导入失败");
        }
    }

    @GetMapping("/applypaydownload")
    @RequiredExportLog
    @OperLog(operType = OperLogType.EXPORT,operDesc = "文印支付申请")
    public void applyPayPrinting(@RequestParam(name="ids", required = false) List<Integer> ids,
                                      ExportLogParams params,
                                      HttpServletResponse response) {
        List<PrintingViewVO> list = new ArrayList<>();
        if (ids != null) {
            list = printingManager.applyPayPrinting(ids);
        }
        ExportExcel.doExport(list,PrintingViewVO.class,"文印支付申请数据",response);
    }

    @GetMapping("/pay")
    @OperLog(operType = OperLogType.OTHER,operDesc = "批量支付成功")
    public OfficeResopnseBean payPrinting(@RequestParam(name="ids", required = false) List<Integer> ids) {
        if (ids == null) {
            ids = new ArrayList<>();
        }
        printingManager.payPrinting(ids);
        return OfficeResopnseBean.newSuccessBean("批量支付成功");
    }

    @GetMapping("/errordatadownload")
    @RequiredExportLog
    @OperLog(operType = OperLogType.EXPORT,operDesc = "导出文印核准金额错误数据")
    public void exportErrorRecords( HttpServletRequest request,
                                    ExportLogParams params,
                                    HttpServletResponse response){
        String personId = ContextUtils.getUserId(request);
        List<PrintingErrorTemplateVO> list = printingManager.getErrorPrintingList(personId);
        ExportExcel.doExport(list,PrintingErrorTemplateVO.class,"文印核准金额导入失败数据",response);
        LOGGER.info("导出文印核准金额错误数据成功！");
    }

    @GetMapping("/templatedownload")
    @RequiredExportLog
    @OperLog(operType = OperLogType.EXPORT,operDesc = "文印核准金额模板")
    public void exportExpressDetailTemplate(ExportLogParams params,
                                            HttpServletResponse response){
        List<ExpressDetailTemplateVO> list = getTemplateData();
        String noticeContent = "填表说明：\n" +
                "1、黄色底色内容必填\n" +
                "2、导入前请将本行删除及测试用例以及相关合计数据";
        ExportExcel.exportWithCustomStyle(list, PrintingTemplateVO.class,"文印核准金额模板",new CustomCellWriteHandler(noticeContent),response);
        LOGGER.info("下载文印模板！");
    }

    @GetMapping("/detaillist")
    @OperLog(operType = OperLogType.QUERY,operDesc = "文印明细列表")
    public OfficeResopnseBean getPrintingDetailList(Integer printingId) {
        List<PrintingDetailVO> list = printingManager.getPrintingDetailList(printingId);
        return OfficeResopnseBean.newSuccessBean(list);
    }

    /** 模板数据 */
    private List<ExpressDetailTemplateVO> getTemplateData() {
        PrintingTemplateVO template = new PrintingTemplateVO();
        PrintingTemplateVO template1 = new PrintingTemplateVO();
        template.setOrderNum("2020xxxx002");
        template.setPrintUnitName("xxxxx");
        template.setContactPerson("xxx");
        template.setApprovalStr("417.6");

        List list = Arrays.asList(template,template1,template1, template1, template1,template1);
        return list;

    }

}
