package com.bsoft.office.sales.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.sales.condition.SalesAgreementQueryCndVO;
import com.bsoft.office.sales.manager.CooperationAgreementManager;
import com.bsoft.office.sales.vo.*;
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
import java.util.Map;

/**
 * @Author Xuhui Lin
 * @Date 2020/6/30 10:37
 * @Description
 */
@RestController
@RequestMapping("/cooperation")
public class CooperationAgreementController {
    private static final Logger logger = LoggerFactory.getLogger(CooperationAgreementController.class);

    @Autowired
    private CooperationAgreementManager cooperationAgreementManager;


    /** 合作协议列表查询 */
    @GetMapping(value = "/agreement")
    @OperLog(operType = OperLogType.QUERY,operDesc = "合作协议列表")
    public OfficeResopnseBean getSalesAgreementList(SalesAgreementQueryCndVO cnds) {
        Result<SalesAgreementViewVO> result = cooperationAgreementManager.getSalesAgreementList(cnds);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        logger.info("获取合作协议列表成功！[{}]", JSONUtils.toString(result));
        return responseBean;
    }

    /** 删除合作协议 */
    @DeleteMapping(value = "/deleteagreement")
    @OperLog(operType = OperLogType.DELETE,operDesc = "删除合作协议")
    public OfficeResopnseBean deleteSalesAgreement(Integer id) {
        cooperationAgreementManager.deleteSalesAgreement(id);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody("删除合作协议成功！");
        logger.info("删除合作协议成功！id:[{}]", JSONUtils.toString(id));
        return responseBean;
    }

    /** 合作协议-合作类别、原件状态字典查询 */
    @GetMapping(value = "/dic")
    @OperLog(operType = OperLogType.QUERY,operDesc = "合作协议-合作类别、原件状态字典")
    public OfficeResopnseBean getDicList() {
        Map<String, Object> result = cooperationAgreementManager.getDicList();
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        logger.info("获取合作协议想字典！[{}]", JSONUtils.toString(result));
        return responseBean;
    }

    /** 合作协议-合作单位查找 */
    @GetMapping(value = "/partnerselect")
    @OperLog(operType = OperLogType.QUERY,operDesc = "合作协议-合作单位")
    public OfficeResopnseBean getPartnerSelectList(String partnerName) {
        List<SalesPartnerViewVO> list = cooperationAgreementManager.getPartnerSelectList(partnerName);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(list);
        logger.info("获取合作单位查找列表！[{}]", JSONUtils.toString(list));
        return responseBean;
    }

    /** 合作协议-上传资料查找 */
    @GetMapping(value = "/files")
    @OperLog(operType = OperLogType.QUERY,operDesc = "合作协议-上传资料查找")
    public OfficeResopnseBean getPublicWordsList(@RequestParam Integer pageNo,
                                                 @RequestParam Integer pageSize,
                                                 @RequestParam Integer menuId,
                                                 @RequestParam Integer mainId,
                                                 @RequestParam Integer type) {
        Result<PublicWordsViewVO> result = cooperationAgreementManager.getPublicWordsList(pageNo, pageSize, mainId, menuId, type);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        logger.info("获取上传资料列表！[{}]", JSONUtils.toString(result));
        return responseBean;
    }

    /** 保存合作协议 */
    @PostMapping(value = "/saveagreement")
    @OperLog(operType = OperLogType.MODIFY,operDesc = "保存合作协议")
    public OfficeResopnseBean saveAgreement(@RequestBody SalesAgreementVO salesAgreementVO,HttpServletRequest request) {
        String personId = ContextUtils.getUserId(request);
        SalesAgreementVO salesAgreement = cooperationAgreementManager.saveAgreement(salesAgreementVO, personId);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(salesAgreement);
        logger.info("保存合作协议！", JSONUtils.toString(salesAgreement));
        return responseBean;
    }

    /** 合作协议-上传文件 */
    @PostMapping(value = "/fileupload")
    @OperLog(operType = OperLogType.UPLOAD,operDesc = "合作协议-上传文件")
    public OfficeResopnseBean uploadFile(@RequestParam MultipartFile file, @RequestParam Integer agreementId, @RequestParam Integer menuId, HttpServletRequest request) {
        String personId = ContextUtils.getUserId(request);
        try {
            cooperationAgreementManager.uploadFile(file, agreementId, menuId, personId);
            OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
            responseBean.setBody("上传成功！");
            logger.info("合作协议-文件上传成功！", JSONUtils.toString("上传成功！"));
            return responseBean;
        } catch (IOException e) {
            e.printStackTrace();
            OfficeResopnseBean responseBean = OfficeResopnseBean.newFailBean(500,"获取上传文件格式失败！");
            logger.info("获取上传文件格式失败");
            return responseBean;
        }
    }
    @GetMapping(value = "/filedownload")
    @OperLog(operType = OperLogType.DOWNLOAD,operDesc = "合作协议-文件下载")
    public void downloadFile(Integer fileId, Integer wordId, HttpServletRequest request, HttpServletResponse response){
        String personId = ContextUtils.getUserId(request);
        PublicWordsVO wordsVO = cooperationAgreementManager.downloadFile(fileId, wordId,personId);
        ServletOutputStream sout = null;
        BufferedOutputStream bos = null;
        try {
            response.setContentLength(wordsVO.getFileBytes().length);
            response.setContentType("application/octet-stream;charset=utf-8");
            // 下载文件能正常显示中文
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(wordsVO.getFileName(), "UTF-8"));
            sout = response.getOutputStream();
            bos = new BufferedOutputStream(sout);
            bos.write(wordsVO.getFileBytes());
            logger.info("下载文件成功！文件服务器文件id:{}, 资料id: {}", fileId, wordId);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(bos != null){
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @DeleteMapping(value = "/filedelete")
    @OperLog(operType = OperLogType.DELETE,operDesc = "合作协议-文件删除")
    public OfficeResopnseBean deleteFile(Integer fileId, Integer wordId){
        cooperationAgreementManager.deleteFile(fileId, wordId);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody("上传文件删除成功！");
        logger.info("上传文件删除成功！文件服务器文件id:{}, 资料id: {}", fileId, wordId);
        return responseBean;
    }
}
