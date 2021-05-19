package com.bsoft.office.organ.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.annotation.RequiredExportLog;
import com.bsoft.office.common.condition.ExportLogParams;
import com.bsoft.office.common.exportExcel.*;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.organ.condition.FlowPaymentQueryCnd;
import com.bsoft.office.organ.manager.FlowPaymentManager;
import com.bsoft.office.organ.vo.PaymentFlowViewVO;
import com.bsoft.office.organ.vo.PaymentIncomeViewVO;
import com.bsoft.office.organ.vo.PublicDicVO;
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
 * @BelongsProject: bsoft-office-server
 * @BelongsPackage: com.bsoft.office.administration.controller
 * @Author: Qi fei
 * @CreateTime: 2020-07-25 18:34
 * @Description:
 */
@RestController
@RequestMapping("/finance")
public class FlowPaymentController {
    private static final Logger logger = LoggerFactory.getLogger(FlowPaymentController.class);

    @Autowired
    private FlowPaymentManager flowPaymentManager;

    /**
     *功能描述: 流水列表查询
     */
    @GetMapping("/flow/query")
    @OperLog(operType = OperLogType.QUERY,operDesc = "运营流水查询列表")
    public OfficeResopnseBean getPaymentFlowList(FlowPaymentQueryCnd flowPaymentQueryCnd){
        Result<PaymentFlowViewVO> result = flowPaymentManager.getPaymentFlowList(flowPaymentQueryCnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        logger.info("获取运营流水查询列表！[{}]", JSONUtils.toString(result));
        return responseBean;
    }

    /**
     *功能描述: 毛利列表查询
     */
    @GetMapping("/income/query")
    @OperLog(operType = OperLogType.QUERY,operDesc = "运营毛利查询列表")
    public OfficeResopnseBean getPaymentIncomeList(FlowPaymentQueryCnd flowPaymentQueryCnd){
        Result<PaymentIncomeViewVO> result = flowPaymentManager.getPaymentIncomeList(flowPaymentQueryCnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        logger.info("获取运营毛利查询列表！[{}]", JSONUtils.toString(result));
        return responseBean;
    }

    /**
     *功能描述: 流水审核
     */
    @PostMapping("/flow/audit")
    @OperLog(operType = OperLogType.OTHER,operDesc = "审核流水")
    public OfficeResopnseBean auditPaymentFlowList(@RequestBody List<PaymentFlowViewVO> payments,HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        flowPaymentManager.auditPaymentFlowList(payments,personId);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody("获审核流水成功");
        logger.info("获审核流水成功");
        return responseBean;
    }

    /**
     *功能描述: 毛利审核
     */
    @PostMapping("/income/audit")
    @OperLog(operType = OperLogType.OTHER,operDesc = "审核毛利")
    public OfficeResopnseBean auditPaymentIncomeList(@RequestBody List<PaymentFlowViewVO> payments,HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        flowPaymentManager.auditPaymentIncomeList(payments,personId);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody("获审核毛利成功");
        logger.info("获审核毛利成功");
        return responseBean;
    }

    /**
     *功能描述: 流水删除
     */
    @DeleteMapping("/flow/delete")
    @OperLog(operType = OperLogType.DELETE,operDesc = "删除运营流水")
    public OfficeResopnseBean deleteBatchFlowList(@RequestParam(value = "deletes")List<Integer> deletes){
        flowPaymentManager.deleteBatchFlowList(deletes);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody("删除运营流水成功！");
        logger.info("删除运营流水！");
        return responseBean;
    }

    /**
     *功能描述: 毛利删除
     */
    @DeleteMapping("/income/delete")
    @OperLog(operType = OperLogType.DELETE,operDesc = "删除运营毛利")
    public OfficeResopnseBean deleteBatchIncomeList(@RequestParam(value = "deletes")List<Integer> deletes){
        flowPaymentManager.deleteBatchIncomeList(deletes);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody("删除运营毛利成功！");
        logger.info("删除运营毛利！");
        return responseBean;
    }

    /**
     *功能描述: 流水模板列表导出
     */
    @GetMapping("/flow/templatedownload")
    @RequiredExportLog
    @OperLog(operType = OperLogType.EXPORT,operDesc = "导出运营流水模板")
    public void exportFlowTemplate(ExportLogParams params,
                                    HttpServletResponse response){
        List<PaymentFlowViewVO> list = getFlowTemplateData();
        ExportExcel.exportWithCustomStyle(list, PaymentFlowViewVO.class,"运营流水模板",new CustomCellWriteHandler(),response);
        logger.info("导出运营流水模板成功！");
    }

    /**
     *功能描述: 流水错误列表导出
     */
    @GetMapping("/flow/errordownload")
    @OperLog(operType = OperLogType.EXPORT,operDesc = "导出运营流水错误")
    public void exportFlowErrorRecords( HttpServletRequest request,
                                         HttpServletResponse response){
        String personId = ContextUtils.getUserId(request);
        List<PaymentFlowViewVO> list = flowPaymentManager.getErrorFlowList(personId);
        ExportExcel.export(list,PaymentFlowViewVO.class,"运营流水导入失败数据",response);
        logger.info("导出运营流水错误成功！");
    }

    /**
     *功能描述: 毛利模板列表导出
     */
    @GetMapping("/income/templatedownload")
    @RequiredExportLog
    @OperLog(operType = OperLogType.EXPORT,operDesc = "导出运营毛利模板")
    public void exportIncomeTemplate(ExportLogParams params,HttpServletResponse response){
        List<PaymentIncomeViewVO> list = getIncomeTemplateData();
        ExportExcel.exportWithCustomStyle(list, PaymentIncomeViewVO.class,"运营毛利模板",new CustomCellWriteHandler(), response);
        logger.info("导出运营毛利模板成功！");
    }

    /**
     *功能描述: 毛利错误列表导出
     */
    @GetMapping("/income/errordownload")
    @OperLog(operType = OperLogType.EXPORT,operDesc = "导出运营毛利错误数据")
    public void exportIncomeErrorRecords( HttpServletRequest request, HttpServletResponse response){
        String personId = ContextUtils.getUserId(request);
        List<PaymentIncomeViewVO> list = flowPaymentManager.getErrorIncomeList(personId);
        ExportExcel.export(list,PaymentIncomeViewVO.class,"运营毛利导入失败数据",response);
        logger.info("导出运营毛利错误数据成功！");
    }

    /** 流水数据 */
    @PostMapping("/flow/import")
    @OperLog(operType = OperLogType.IMPORT,operDesc = "导入运营流水数据")
    public OfficeResopnseBean importPaymentFlowData(@RequestParam MultipartFile file, HttpServletRequest request) {
        String personId = ContextUtils.getUserId(request);
        try {
            List<PaymentFlowViewVO> list = ExcelUtils.readExcel(file, PaymentFlowViewVO.class, new ExcelListener<PaymentFlowViewVO>());

            ImportResultVO result = flowPaymentManager.importPaymentFlowData(list, personId);
            OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
            responseBean.setBody(result);
            logger.info("导入运营流水数据成功!", JSONUtils.toString(result));
            return responseBean;
        } catch (IOException e) {
            return OfficeResopnseBean.newFailBean(500, "运营流水数据导入失败");
        }
    }

    /** 毛利导入数据 */
    @PostMapping("/income/import")
    @OperLog(operType = OperLogType.IMPORT,operDesc = "导入运营毛利数据")
    public OfficeResopnseBean importPaymentIncomeData(@RequestParam MultipartFile file, HttpServletRequest request) {
        String personId = ContextUtils.getUserId(request);
        try {
            List<PaymentIncomeViewVO> list = ExcelUtils.readExcel(file, PaymentIncomeViewVO.class, new ExcelListener<PaymentIncomeViewVO>());
            ImportResultVO result = flowPaymentManager.importPaymentIncomeData(list,personId);

            OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
            responseBean.setBody(result);
            logger.info("导入运营毛利数据成功！", JSONUtils.toString(result));
            return responseBean;
        } catch (IOException e) {
            return OfficeResopnseBean.newFailBean(500, "运营毛利导入失败");
        }
    }

    /**
     *功能描述: 业务条线字典
     */
    @GetMapping("/businessline/dic")
    @OperLog(operType = OperLogType.QUERY,operDesc = "业务条线字典")
    public OfficeResopnseBean getBusinessLineDic(){
        List<PublicDicVO> list = flowPaymentManager.getBusinessLineDic();
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(list);
        logger.info("获取业务条线字典列表！[{}]", JSONUtils.toString(list));
        return responseBean;
    }

    /**
     *功能描述: 类别字典
     */
    @GetMapping("/type/dic")
    @OperLog(operType = OperLogType.QUERY,operDesc = "类别字典")
    public OfficeResopnseBean getTypeDic(){
        List<PublicDicVO> list = flowPaymentManager.getTypeDic();
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(list);
        logger.info("获取类别字典列表！[{}]", JSONUtils.toString(list));
        return responseBean;
    }

    /** 流水模板数据 */
    private List<PaymentFlowViewVO> getFlowTemplateData() {
        PaymentFlowViewVO template = new PaymentFlowViewVO();
        PaymentFlowViewVO template1 = new PaymentFlowViewVO();
        template.setDeptName("杭州区");
        template.setOrgName("XXXXXXX");
        template.setBusinessLineText("支付");
        template.setTypeText("订单流水");
        template.setAmountStr("2287.4");
        template.setAccountDateStr("2020.5.31");


        List list = Arrays.asList(template,template1,template1, template1, template1,template1);
        return list;

    }

    /** 毛利模板数据 */
    private List<PaymentIncomeViewVO> getIncomeTemplateData() {
        PaymentIncomeViewVO template = new PaymentIncomeViewVO();
        PaymentIncomeViewVO template1 = new PaymentIncomeViewVO();
        template.setDeptName("杭州区");
        template.setOrgName("XXXXXXX");
        template.setBusinessLineText("支付");
        template.setTypeText("提点返佣");
        template.setAmountStr("41155.38");
        template.setAccountDateStr("2020.5.31");

        List list = Arrays.asList(template,template1,template1, template1, template1,template1);
        return list;

    }
}
