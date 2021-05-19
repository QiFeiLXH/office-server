package com.bsoft.office.work.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.annotation.RequiredExportLog;
import com.bsoft.office.common.condition.ExportLogParams;
import com.bsoft.office.common.exportExcel.*;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.work.condition.ExpressQueryCnd;
import com.bsoft.office.work.manager.ExpressManager;
import com.bsoft.office.work.vo.ExpressDetailErrorTemplateVO;
import com.bsoft.office.work.vo.ExpressDetailTemplateVO;
import com.bsoft.office.work.vo.ExpressDetailViewVO;
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
 * @Date 2020/12/30 15:13
 * @Description
 */
@RestController
@RequestMapping("/express")
public class ExpressController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExpressController.class);

    @Autowired
    private ExpressManager expressManager;

    @GetMapping("/list")
    @OperLog(operType = OperLogType.QUERY,operDesc = "快递列表")
    public OfficeResopnseBean getExpressList(ExpressQueryCnd queryCnd) {
        Result<ExpressDetailViewVO> result = expressManager.getExpressList(queryCnd);
        return OfficeResopnseBean.newSuccessBean(result);
    }

    @GetMapping("/unpaidcount")
    @OperLog(operType = OperLogType.QUERY,operDesc = "未支付数量")
    public OfficeResopnseBean getExpressUnpaidCount(ExpressQueryCnd queryCnd) {
        Integer count = expressManager.getExpressUnpaidCount(queryCnd);
        return OfficeResopnseBean.newSuccessBean(count);
    }

    @GetMapping("/unpaidamount")
    @OperLog(operType = OperLogType.QUERY,operDesc = "未支付金额")
    public OfficeResopnseBean getExpressUnpaidAmount() {
        Double amount = expressManager.getExpressUnpaidAmount();
        return OfficeResopnseBean.newSuccessBean(amount);
    }

    @GetMapping("/totalamount")
    @OperLog(operType = OperLogType.QUERY,operDesc = "总金额")
    public OfficeResopnseBean getExpressTotalAmount(@RequestParam(value = "expressIds", required = false) List<Integer> expressIds) {
        if (expressIds == null) {
            expressIds = new ArrayList<>();
        }
        Double amount = expressManager.getExpressTotalAmount(expressIds);
        return OfficeResopnseBean.newSuccessBean(amount);
    }

    @GetMapping("/expressids")
    @OperLog(operType = OperLogType.QUERY,operDesc = "快递ids")
    public OfficeResopnseBean getExpressIdList(ExpressQueryCnd queryCnd) {
        List<Integer> expressIds = expressManager.getExpressIdList(queryCnd);
        return OfficeResopnseBean.newSuccessBean(expressIds);
    }

    @PostMapping("/save")
    @OperLog(operType = OperLogType.SAVE,operDesc = "快递保存")
    public OfficeResopnseBean saveExpressDetail(@RequestBody ExpressDetailViewVO expressDetail) {
        expressManager.saveExpressDetail(expressDetail);
        return OfficeResopnseBean.newSuccessBean("修改核准金额成功！");
    }

    @PostMapping("/import")
    @OperLog(operType = OperLogType.IMPORT,operDesc = "快递导入")
    public OfficeResopnseBean importExpressData(@RequestParam MultipartFile file, HttpServletRequest request) {
        String personId = ContextUtils.getUserId(request);
        try {
            List<ExpressDetailTemplateVO> list = ExcelUtils.readExcel(file, ExpressDetailTemplateVO.class, new ExcelListener<ExpressDetailTemplateVO>());

            ImportResultVO result = expressManager.importExpressData(list, personId);
            OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
            responseBean.setBody(result);
            return responseBean;
        } catch (IOException e) {
            return OfficeResopnseBean.newFailBean(500, "快递信息-导入失败");
        }
    }

    @GetMapping("/applypaydownload")
    @RequiredExportLog
    @OperLog(operType = OperLogType.EXPORT,operDesc = "快递支付申请")
    public void applyPayExpressDetail(@RequestParam(name="ids", required = false) List<Integer> ids,
                                      ExportLogParams params,
                                      HttpServletResponse response) {
        List<ExpressDetailViewVO> list = new ArrayList<>();
        if (ids != null) {
            list = expressManager.applyPayExpressDetail(ids);
        }
        ExportExcel.doExport(list,ExpressDetailViewVO.class,"快递支付申请数据",response);
    }

    @GetMapping("/pay")
    @OperLog(operType = OperLogType.OTHER,operDesc = "批量支付")
    public OfficeResopnseBean payExpressDetail(@RequestParam(name="ids", required = false) List<Integer> ids) {
        if (ids == null) {
            ids = new ArrayList<>();
        }
        expressManager.payExpressDetail(ids);
        return OfficeResopnseBean.newSuccessBean("批量支付成功");
    }

    @GetMapping("/errordatadownload")
    @RequiredExportLog
    @OperLog(operType = OperLogType.EXPORT,operDesc = "快递核准金额导入失败数据")
    public void exportErrorRecords( HttpServletRequest request,
                                         ExportLogParams params,
                                         HttpServletResponse response){
        String personId = ContextUtils.getUserId(request);
        List<ExpressDetailErrorTemplateVO> list = expressManager.getErrorExpressDetailList(personId);
        ExportExcel.doExport(list,ExpressDetailErrorTemplateVO.class,"快递核准金额导入失败数据",response);
        LOGGER.info("导出快递核准金额错误数据成功！");
    }

    @GetMapping("/templatedownload")
    @RequiredExportLog
    @OperLog(operType = OperLogType.EXPORT,operDesc = "快递核准金额模板")
    public void exportExpressDetailTemplate(ExportLogParams params,
                                         HttpServletResponse response){
        List<ExpressDetailTemplateVO> list = getTemplateData();
        String noticeContent = "填表说明：\n" +
                "1、黄色底色内容必填\n" +
                "2、导入前请将本行删除及测试用例以及相关合计数据";
        ExportExcel.exportWithCustomStyle(list, ExpressDetailTemplateVO.class,"快递核准金额模板",new CustomCellWriteHandler(noticeContent),response);
        LOGGER.info("下载快递核准金额模板！");
    }

    /** 模板数据 */
    private List<ExpressDetailTemplateVO> getTemplateData() {
        ExpressDetailTemplateVO template = new ExpressDetailTemplateVO();
        ExpressDetailTemplateVO template1 = new ExpressDetailTemplateVO();
        template.setApprovalStr("xxx");
        template.setExpressNo("xxx");
        template.setSender("xxx");
        template.setWeight("xxx");

        List list = Arrays.asList(template,template1,template1, template1, template1,template1);
        return list;

    }

}
