package com.bsoft.office.manager.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.common.vo.PublicDicVO;
import com.bsoft.office.manager.condition.FileOverViewQueryCnd;
import com.bsoft.office.manager.manager.FileOverViewManager;
import com.bsoft.office.manager.vo.FileMenuVO;
import com.bsoft.office.manager.vo.FileRecordVO;
import org.apache.commons.lang3.StringUtils;
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

@RestController
@RequestMapping("/file")
public class FileOverViewController {
    private static final Logger logger = LoggerFactory.getLogger(FileOverViewController.class);

    @Autowired
    private FileOverViewManager fileOverViewManager;

    @GetMapping(value = "/system")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取系统列表")
    public OfficeResopnseBean getSystemList(){
        logger.info("获取系统列表");
        List<PublicDicVO> result = fileOverViewManager.getSystemList();
        return OfficeResopnseBean.newSuccessBean(result);
    }

    @GetMapping(value = "/type")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取文件类型列表")
    public OfficeResopnseBean getFileTypeList(){
        logger.info("获取文件类型列表");
        List<PublicDicVO> result = fileOverViewManager.getFileTypeList();
        return OfficeResopnseBean.newSuccessBean(result);
    }

    @GetMapping(value = "/menu")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取菜单列表")
    public OfficeResopnseBean getFileMenu(@RequestParam(value = "system", required = true) Integer systemid, HttpServletRequest request){
        String userId = ContextUtils.getUserId(request);
        logger.info("获取菜单列表[{}]", JSONUtils.toString(systemid));
        List<FileMenuVO> fileMenuVOS = fileOverViewManager.getFileMenuTree(userId, systemid);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(fileMenuVOS);
        return responseBean;
    }

    @GetMapping(value = "/yearfolder")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取年份文件夹列表")
    public OfficeResopnseBean getYearMenu(FileOverViewQueryCnd queryCnd, HttpServletRequest request){
        String userId = ContextUtils.getUserId(request);
        logger.info("获取年份文件夹列表[{}]", JSONUtils.toString(queryCnd));
        Result<FileRecordVO> fileMenuVOS = fileOverViewManager.getYearFolderList(userId, queryCnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(fileMenuVOS);
        return responseBean;
    }

    @GetMapping(value = "/monthfolder")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取月份文件夹列表")
    public OfficeResopnseBean getMonthMenu(FileOverViewQueryCnd queryCnd, HttpServletRequest request){
        String userId = ContextUtils.getUserId(request);
        logger.info("获取月份文件夹列表[{}]", JSONUtils.toString(queryCnd));
        Result<FileRecordVO> fileMenuVOS = fileOverViewManager.getMonthFolderList(userId, queryCnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(fileMenuVOS);
        return responseBean;
    }

    @GetMapping(value = "/filelist")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取文件列表")
    public OfficeResopnseBean getDayList(FileOverViewQueryCnd queryCnd, HttpServletRequest request){
        String userId = ContextUtils.getUserId(request);
        logger.info("获取文件列表[{}]", JSONUtils.toString(queryCnd));
        Result<FileRecordVO> resultVO = fileOverViewManager.getFileList(userId, queryCnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(resultVO);
        return responseBean;
    }

    @GetMapping(value = "/remove")
    @OperLog(operType = OperLogType.DELETE,operDesc = "删除文件")
    public OfficeResopnseBean removeFile(@RequestParam(value ="id") Integer id, HttpServletRequest request){
        String userId = ContextUtils.getUserId(request);
        logger.info("删除文件[{}]", id);
        OfficeResopnseBean resopnseBean = fileOverViewManager.removeFile(userId, id);
        return resopnseBean;
    }

    @PostMapping(value = "/change")
    @OperLog(operType = OperLogType.SAVE,operDesc = "修改文件")
    public OfficeResopnseBean changeFile(@RequestParam MultipartFile file,@RequestParam Integer id, @RequestParam String fileName, HttpServletRequest request) throws Exception{
        String userId = ContextUtils.getUserId(request);
        logger.info("修改文件[{}],[{}],[{}]",id, fileName, file.getOriginalFilename());
        OfficeResopnseBean resopnseBean = fileOverViewManager.changeFile(userId, file, id);
        return resopnseBean;

    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    @OperLog(operType = OperLogType.DOWNLOAD,operDesc = "下载文件")
    public void downloadFile(@RequestParam(value = "id") Integer id, HttpServletResponse response) {
        logger.info("下载文件[{}]", id);
        FileRecordVO fileRecordVO = fileOverViewManager.downloadFile(id);
        ServletOutputStream sout = null;
        BufferedOutputStream bos = null;
        try {
            response.setContentLength(fileRecordVO.getData().length);
            response.setContentType("application/octet-stream;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileRecordVO.getFileName(), "UTF-8"));
            response.setHeader("response-type", "download");
            sout = response.getOutputStream();
            bos = new BufferedOutputStream(sout);
            bos.write(fileRecordVO.getData());
            logger.info("下载文件成功！文件服务器文件id:{}", id);
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


}

