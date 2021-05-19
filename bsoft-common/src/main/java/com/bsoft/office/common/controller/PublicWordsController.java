package com.bsoft.office.common.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.constant.WordType;
import com.bsoft.office.common.manager.PublicWordsManager;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.common.vo.PublicDicVO;
import com.bsoft.office.common.vo.PublicWordsVO;
import com.bsoft.office.common.vo.PublicWordsViewVO;
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
 * @Author Xuhui Lin
 * @Date 2020/11/19 12:08
 * @Description
 */
@RestController
@RequestMapping("/publicwords")
public class PublicWordsController {

    @Autowired
    private PublicWordsManager publicWordsManager;

    /** 上传文档类型 */
    @GetMapping(value = "/filetypedic")
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询上传文档类型字典")
    public OfficeResopnseBean getFileTypesDic() {
        List<PublicDicVO> fileTypesDic = publicWordsManager.getFileTypesDic();
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(fileTypesDic);
        return responseBean;
    }

    /** 上传资料查找 */
    @GetMapping(value = "/files")
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询上传资料")
    public OfficeResopnseBean getPublicWordsList(@RequestParam Integer pageNo,
                                                 @RequestParam Integer pageSize,
                                                 @RequestParam Integer mainId,
                                                 @RequestParam Integer type) {
        Result<PublicWordsViewVO> result = publicWordsManager.getPublicWordsList(pageNo, pageSize, mainId, type, WordType.OwnPurchaseContract);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        return responseBean;
    }

    /** 上传文件 */
    @PostMapping(value = "/fileupload")
    @OperLog(operType = OperLogType.UPLOAD,operDesc = "上传问价")
    public OfficeResopnseBean uploadFile(@RequestParam MultipartFile file, @RequestParam Integer contractId, @RequestParam Integer menuId, HttpServletRequest request) {
        String personId = ContextUtils.getUserId(request);
        try {
            publicWordsManager.uploadFile(file,contractId,menuId,personId,WordType.OwnPurchaseContract);
            OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
            responseBean.setBody("上传成功！");
            return responseBean;
        } catch (IOException e) {
            e.printStackTrace();
            OfficeResopnseBean responseBean = OfficeResopnseBean.newFailBean(500,"获取上传文件格式失败！");
            return responseBean;
        }
    }
    @GetMapping(value = "/filedownload")
    @OperLog(operType = OperLogType.DOWNLOAD,operDesc = "下载文档")
    public void downloadFile(Integer fileId, Integer wordId, HttpServletRequest request, HttpServletResponse response){
        String personId = ContextUtils.getUserId(request);
        PublicWordsVO wordsVO = publicWordsManager.downloadFile(fileId, wordId,personId);
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
    @OperLog(operType = OperLogType.DELETE,operDesc = "删除文件")
    public OfficeResopnseBean deleteFile(Integer fileId, Integer wordId){
        publicWordsManager.deleteFile(fileId, wordId);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody("上传文件删除成功！");
        return responseBean;
    }
}
