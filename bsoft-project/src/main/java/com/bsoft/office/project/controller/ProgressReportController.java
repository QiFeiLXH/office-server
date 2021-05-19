package com.bsoft.office.project.controller;

import com.bsoft.common.dto.FileServerDefinitionDTO;
import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.project.condition.ProgressReportQueryCnd;
import com.bsoft.office.project.manager.ProgressReportManager;
import com.bsoft.office.project.manager.ProjectWordManager;
import com.bsoft.office.project.vo.*;
import com.bsoft.project.dto.ProjectWordDetailDTO;
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
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2021/4/19 13:17
 * @Description:
 */
@RestController
@RequestMapping(value = "/progressrespot")
public class ProgressReportController {
    private static final Logger logger = LoggerFactory.getLogger(ProgressReportController.class);

    @Autowired
    private ProgressReportManager progressReportManager;
    @Autowired
    private ProjectWordManager projectWordManager;

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询项目进度上报列表")
    public OfficeResopnseBean findProgressReportList(@RequestBody ProgressReportQueryCnd cnd, HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        cnd.setPersonId(personId);
        Result<ProgressReportViewVO> result = progressReportManager.findProjectProgressList(cnd);
        return OfficeResopnseBean.newSuccessBean(result);
    }

    @RequestMapping(value = "/getprogress",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询项目进度")
    public OfficeResopnseBean getProgressReport(@RequestParam(name = "projectId") String projectId){
        ProgressReportViewVO result = progressReportManager.getProjectProgress(projectId);
        return OfficeResopnseBean.newSuccessBean(result);
    }

    @RequestMapping(value = "/typelist",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询项目可以进行上报的类型列表")
    public OfficeResopnseBean findTypeList(@RequestParam(name = "projectId") String projectId){
        List<ProjectReportTypeViewVO> typeViewVOS = progressReportManager.findReportTypeList(projectId);
        return OfficeResopnseBean.newSuccessBean(typeViewVOS);
    }

    @RequestMapping(value = "/header",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询项目上报列表头部")
    public OfficeResopnseBean getColumnsHeader(@RequestParam(name = "projectId") String projectId,@RequestParam(name = "reportTypeId") Integer reportTypeId,@RequestParam(name = "month") String month){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = format.parse(month);
            List<ProProgressNodeVO> proProgressNodeVOS = progressReportManager.getColumnsHeader(projectId,reportTypeId,date);
            return OfficeResopnseBean.newSuccessBean(proProgressNodeVOS);
        } catch (ParseException e) {
            return OfficeResopnseBean.newFailBean(500,"日期格式错误!");
        }
    }

    @RequestMapping(value = "/checkreport",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询该月份该上报类型是否已上报")
    public OfficeResopnseBean checkHasReport(@RequestParam(name = "projectId") String projectId,
                                             @RequestParam(name = "month") String month){

        try {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = format.parse(month);
            boolean status = progressReportManager.checkHasReport(projectId,date);
            return OfficeResopnseBean.newSuccessBean(status);
        } catch (ParseException e) {
            return OfficeResopnseBean.newFailBean(500,"日期格式错误!");
        }
    }

    @RequestMapping(value = "/addprogress",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.SAVE,operDesc = "新增月份上报进度基础信息")
    public OfficeResopnseBean addReportProgress(@RequestParam(name = "projectId") String projectId,
                                                @RequestParam(name = "month") String month,
                                                HttpServletRequest request){
        try {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = format.parse(month);
            String reporter = ContextUtils.getUserId(request);
            String reporterName = ContextUtils.getAttribute(request,"userName");
            progressReportManager.addReportProgress(projectId,date,reporter,reporterName);
            return OfficeResopnseBean.newSuccessBean();
        } catch (ParseException e) {
            return OfficeResopnseBean.newFailBean(500,"日期格式错误!");
        }
    }

    @RequestMapping(value = "/monthreport",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询项目月份上报进度")
    public OfficeResopnseBean getMonthProgress(@RequestParam(name = "projectId") String projectId,
                                               @RequestParam(name = "month") String month,
                                               @RequestParam(name = "reportType") Integer reportType,
                                               @RequestParam(name = "inputContent") String inputContent){
        try {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = format.parse(month);
            List<ProReportProgressVO> proReportProgressVOS = progressReportManager.getMonthProgress(projectId, date, reportType,inputContent);
            return OfficeResopnseBean.newSuccessBean(proReportProgressVOS);
        } catch (ParseException e) {
            return OfficeResopnseBean.newFailBean(500,"日期格式错误!");
        }
    }

    @RequestMapping(value = "/report",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.SAVE,operDesc = "上报进度")
    public OfficeResopnseBean reportProgress(@RequestBody ReportProgressSaveVO saveVO){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(saveVO.getMonth());
            progressReportManager.reportProgress(saveVO,date);
            return OfficeResopnseBean.newSuccessBean();
        } catch (ParseException e) {
            return OfficeResopnseBean.newFailBean(500,"日期格式错误!");
        }
    }

    @RequestMapping(value = "/checkenablereport",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "验证所选的进度月份当前日期是否可以新增或者上报")
    public OfficeResopnseBean checkEnableReport(@RequestParam(name = "month") String month){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = format.parse(month);
            boolean status = progressReportManager.checkDate(date);
            return OfficeResopnseBean.newSuccessBean(status);
        } catch (ParseException e) {
            return OfficeResopnseBean.newFailBean(500,"日期格式错误!");
        }
    }

    @GetMapping("/file/displaylist")
    @OperLog(operType = OperLogType.QUERY)
    public OfficeResopnseBean getProjectWordDisplayList(@RequestParam("contractNo") String contractNo,
                                                 @RequestParam(value = "inputContent", required = false) String inputContent,
                                                 @RequestParam(value = "isRequired", required = false) Integer isRequired) {
        logger.info("获取项目文档列表[{}][{}][{}]", contractNo, inputContent, isRequired);
        List<ContractWordViewVO> list = projectWordManager.getContractWordViewDisplayList(contractNo, inputContent, isRequired);
        return OfficeResopnseBean.newSuccessBean(list);
    }

    @GetMapping("/file/list")
    @OperLog(operType = OperLogType.QUERY)
    public OfficeResopnseBean getProjectWordList(@RequestParam("contractNo") String contractNo,
                                                 @RequestParam(value = "inputContent", required = false) String inputContent,
                                                 @RequestParam(value = "isRequired", required = false) Integer isRequired) {
        logger.info("获取项目文档列表[{}][{}][{}]", contractNo, inputContent, isRequired);
        List<ContractWordViewVO> list = projectWordManager.getContractWordViewList(contractNo, inputContent, isRequired);
        return OfficeResopnseBean.newSuccessBean(list);
    }

    @GetMapping("/file/detaillist")
    @OperLog(operType = OperLogType.QUERY)
    public OfficeResopnseBean getProjectWordDetailList(@RequestParam("contractNo") String contractNo,
                                                       @RequestParam("standardWordId") Integer standardWordId) {
        logger.info("获取文档明细列表[{}]", contractNo);
        List<ContractWordDetailViewVO> list = projectWordManager.getContractWordDetailViewList(contractNo, standardWordId);
        return OfficeResopnseBean.newSuccessBean(list);
    }

    @GetMapping("/file/standradword")
    @OperLog(operType = OperLogType.QUERY)
    public OfficeResopnseBean getProjectWordView(@RequestParam("contractNo") String contractNo,
                                                 @RequestParam("projectId") String projectId,
                                                 @RequestParam("standardWordId") Integer standardWordId) {
        logger.info("获取标准文档[{}][{}][{}]", contractNo, projectId, standardWordId);
        ProjectWordViewVO projectWordView = projectWordManager.getProjectWordView(contractNo, projectId, standardWordId);
        return OfficeResopnseBean.newSuccessBean(projectWordView);
    }



    @PostMapping("/file/upload")
    @OperLog(operType = OperLogType.UPLOAD,operDesc = "上传文档")
    public OfficeResopnseBean projectWordUpload(@RequestParam MultipartFile file,
                                                @RequestParam Integer id,
                                                @RequestParam Integer fileKey,
                                                @RequestParam String contractNo,
                                                @RequestParam Integer detailId,
                                                @RequestParam Integer milepostId,
                                                @RequestParam(required = false) Date finalCheckDate,
                                                @RequestParam(required = false) Date onlineDate,
                                                HttpServletRequest request){
        try{
            String userId = ContextUtils.getUserId(request);
            projectWordManager.projectWordUpload(userId, file, id, fileKey, contractNo, detailId, milepostId, finalCheckDate, onlineDate);
            return OfficeResopnseBean.newSuccessBean();
        }catch (Exception e){
            e.printStackTrace();
            OfficeResopnseBean responseBean = OfficeResopnseBean.newFailBean(500, "上传失败");
            return responseBean;
        }
    }

    @GetMapping("/file/download")
    @OperLog(operType = OperLogType.DOWNLOAD,operDesc = "下载项目文档")
    public void projectWordDownload(@RequestParam("contractNo") String contractNo,
                                    @RequestParam("dbDetailId") Integer dbDetailId,
                                    HttpServletRequest request,
                                    HttpServletResponse response){
        String personId = ContextUtils.getUserId(request);
        ProjectWordDetailDTO projectWordDBDetail = projectWordManager.getProjectWordDBDetail(contractNo, dbDetailId, personId);
        ServletOutputStream sout = null;
        BufferedOutputStream bos = null;
        try {
            response.setContentLength(projectWordDBDetail.getFile().length);
            response.setContentType("application/octet-stream;charset=utf-8");
            // 下载文件能正常显示中文
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(projectWordDBDetail.getFileName(), "UTF-8"));
            sout = response.getOutputStream();
            bos = new BufferedOutputStream(sout);
            bos.write(projectWordDBDetail.getFile());
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

    @GetMapping("/file/remove")
    @OperLog(operType = OperLogType.QUERY)
    public OfficeResopnseBean projectWordRemove(@RequestParam("contractNo") String contractNo,
                                                @RequestParam("wordId") Integer wordId,
                                                @RequestParam("wordDBid") Integer wordDBid) {
        logger.info("删除文档[{}][{}][{}]", contractNo, wordId, wordDBid);
        try{
            projectWordManager.projectWordRemove(contractNo, wordId, wordDBid);
            return OfficeResopnseBean.newSuccessBean();
        } catch(Exception e) {
            return OfficeResopnseBean.newFailBean(500, "删除失败！");
        }
    }

    @GetMapping("/file/finalcheckdate")
    @OperLog(operType = OperLogType.QUERY)
    public OfficeResopnseBean getContractFinalCheckDate(@RequestParam("contractNo") String contractNo) {
        logger.info("获取项目终验日期[{}]", contractNo);
        Date finalCheckDate = projectWordManager.getContractFinalCheckDate(contractNo);
        return OfficeResopnseBean.newSuccessBean(finalCheckDate);
    }

    @GetMapping("/file/onlinedate")
    @OperLog(operType = OperLogType.QUERY)
    public OfficeResopnseBean getContractOnlineDate(@RequestParam("contractNo") String contractNo) {
        logger.info("获取项目上线函日期[{}]", contractNo);
        Date finalCheckDate = projectWordManager.getContractOnlineDate(contractNo);
        return OfficeResopnseBean.newSuccessBean(finalCheckDate);
    }

    @GetMapping("/file/typelist")
    @OperLog(operType = OperLogType.QUERY)
    public OfficeResopnseBean getFileTypes() {
        logger.info("获取文件类型列表");
        List<PublicDicVO> fileTypes = projectWordManager.getFileTypes();
        return OfficeResopnseBean.newSuccessBean(fileTypes);
    }

    @RequestMapping(value = "/file/example",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.DOWNLOAD,operDesc = "")
    public void showHelpWord(Integer exampleFileId, HttpServletResponse response){
        FileServerDefinitionDTO exampleFile = projectWordManager.getExampleFile(exampleFileId);
        if (exampleFile != null) {
            OutputStream outputStream = null;
            try {
                String fileType = exampleFile.getFileName().substring(exampleFile.getFileName().lastIndexOf(".") + 1);
                response.setCharacterEncoding("UTF-8");
                if (fileType.equalsIgnoreCase("pdf")){
                    response.setContentType("application/pdf");
                } else if (fileType.equalsIgnoreCase("png") || fileType.equalsIgnoreCase("jpg")) {
                    response.setContentType("image/png");
                } else{
                    response.setContentType("application/msword");
                }
                response.setHeader("Content-Disposition", "inline;fileName="+ URLEncoder.encode(exampleFile.getFileName(), "utf-8"));
                outputStream = response.getOutputStream();
                outputStream.write(exampleFile.getData());
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
