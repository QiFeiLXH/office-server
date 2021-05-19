package com.bsoft.office.sales.controller;

import com.bsoft.common.dto.FileServerDefinitionDTO;
import com.bsoft.common.result.Result;
import com.bsoft.exception.ServiceException;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.annotation.RequiredExportLog;
import com.bsoft.office.common.condition.ExportLogParams;
import com.bsoft.office.common.exportExcel.ExcelListener;
import com.bsoft.office.common.exportExcel.ExcelUtils;
import com.bsoft.office.common.exportExcel.ExportExcel;
import com.bsoft.office.common.exportExcel.ImportResultVO;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.sales.condition.SalesCommisQueryCndVO;
import com.bsoft.office.sales.manager.SalesCommisManager;
import com.bsoft.office.sales.vo.SalesCommisImportVO;
import com.bsoft.office.sales.vo.SalesCommisViewVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/10/10 17:25
 * @Description:
 */
@RestController
@RequestMapping(value = "/salescommis")
public class SalesCommisController {

    private static Logger logger = LoggerFactory.getLogger(SalesCommisController.class);
    @Autowired
    private SalesCommisManager salesCommisManager;

    /**
     * 查询销售提成列表
     * @param cndVO
     * @param request
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询销售提成列表")
    public OfficeResopnseBean getSalesCommislist(@RequestBody SalesCommisQueryCndVO cndVO, HttpServletRequest request){
        String userId = ContextUtils.getUserId(request);
        cndVO.setPersonId(userId);
        Result<SalesCommisViewVO> result = salesCommisManager.getSalesCommis(cndVO);
        return OfficeResopnseBean.newSuccessBean(result);
    }

    /**
     * 删除销售提成
     * @param deletes
     * @return
     */
    @RequestMapping(value = "delete",method = RequestMethod.DELETE)
    @OperLog(operType = OperLogType.DELETE,operDesc = "删除销售提成记录")
    public OfficeResopnseBean deleteSalesCommis(@RequestParam(value = "deletes")List<Integer> deletes){
        salesCommisManager.deleteSalesCommis(deletes);
        return OfficeResopnseBean.newSuccessBean("删除销售提成成功！");
    }

    /**
     * 审核销售提成
     * @param aduits
     * @param request
     * @return
     */
    @RequestMapping(value = "aduit",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.MODIFY,operDesc = "审核销售提成记录")
    public OfficeResopnseBean aduitSalesCommis(@RequestBody List<Integer> aduits,HttpServletRequest request){
        String userId = ContextUtils.getUserId(request);
        salesCommisManager.aduitSalesCommis(aduits,userId);
        return OfficeResopnseBean.newSuccessBean("审核销售提成成功！");
    }


    /**
     * 导出销售提成模板excel
     * @param response
     */
    @RequestMapping(value = "templatedownload",method = RequestMethod.GET)
    @RequiredExportLog
    @OperLog(operType = OperLogType.EXPORT,operDesc = "导出销售提成模板excel")
    public void exportTemplte(ExportLogParams params, HttpServletResponse response){
        FileServerDefinitionDTO fileServerDefinitionDTO = salesCommisManager.getTemplateExcel();
        ServletOutputStream sout = null;
        BufferedOutputStream bos = null;
        try {
            response.setContentLength(fileServerDefinitionDTO.getData().length);
            response.setContentType("application/octet-stream;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileServerDefinitionDTO.getFileName(), "UTF-8"));
            sout = response.getOutputStream();
            bos = new BufferedOutputStream(sout);
            bos.write(fileServerDefinitionDTO.getData());
            logger.info("下载文件销售提成模板成功！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 导入销售提成
     * @return
     */
    @RequestMapping(value = "/import",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.IMPORT,operDesc = "导入销售提成")
    public OfficeResopnseBean importSalesCommis(@RequestParam MultipartFile file, HttpServletRequest request){
        if(file.isEmpty()){
            throw new ServiceException("文件为空！");
        }
        String personId = ContextUtils.getUserId(request);
        try {
            List<SalesCommisImportVO> list = ExcelUtils.readExcel(file, SalesCommisImportVO.class, new ExcelListener<SalesCommisImportVO>());
            ImportResultVO resultVO = salesCommisManager.importSalesCommis(list,personId);
            logger.info("导入销售提成成功！信息为[{}]", JSONUtils.toString(resultVO));
            return OfficeResopnseBean.newSuccessBean(resultVO);
        } catch (IOException e) {
            logger.error("导入销售提成失败！");
            return OfficeResopnseBean.newFailBean(500, "销售提成导入失败");
        }
    }

    @RequestMapping(value = "errordownload",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.EXPORT,operDesc = "导出销售提成导入失败数据")
    public void exportIncomeErrorRecords( HttpServletRequest request, HttpServletResponse response){
        String personId = ContextUtils.getUserId(request);
        List<SalesCommisImportVO> list = salesCommisManager.getErrorList(personId);
        ExportExcel.export(list,SalesCommisImportVO.class,"销售提成导入失败数据",response);
        logger.info("导出销售提成错误数据成功！");
    }
}
