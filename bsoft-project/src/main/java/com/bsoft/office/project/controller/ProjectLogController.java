package com.bsoft.office.project.controller;

import com.bsoft.exception.ServiceException;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.common.result.Result;
import com.bsoft.office.common.sort.ListBeanSort;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.project.condition.ProjectWordQueryCnd;
import com.bsoft.office.project.manager.ProjectLogManager;
import com.bsoft.office.project.vo.*;
import com.bsoft.project.dto.ProjectWordDetailDTO;
import com.bsoft.project.dto.ReferenceDocumentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.text.ParseException;
import java.util.*;

@RestController
@RequestMapping("projectlog")
public class ProjectLogController {

    @Autowired
    private ProjectLogManager projectLogManager;

    @RequestMapping(value = "/initpage",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "结构化日志录入页面初始化")
    public OfficeResopnseBean init(HttpServletRequest request){
        try{
            String userId = ContextUtils.getUserId(request);
            OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
            Map<String,Object> map = projectLogManager.init(userId);
            map.put("userId", userId);
            bean.setBody(map);
            return bean;
        }catch (Exception e){
            e.printStackTrace();
            OfficeResopnseBean responseBean = OfficeResopnseBean.newFailBean(500,"初始化页面失败！");
            return responseBean;
        }
    }

    @RequestMapping(value = "/ownattendance",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询住宿情况信息")
    public OfficeResopnseBean ownAttendance(HttpServletRequest request,@RequestParam String attendanceDate){
        try{
            String userId = ContextUtils.getUserId(request);
            OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
            AttendanceVO attendanceVO = projectLogManager.ownAttendance(userId,attendanceDate);
            if(attendanceVO.getStay() == null){
                attendanceVO.setStay(1);
            }
            bean.setBody(attendanceVO);
            return bean;
        }catch (Exception e){
            e.printStackTrace();
            OfficeResopnseBean responseBean = OfficeResopnseBean.newFailBean(500,"获取住宿情况失败！");
            return responseBean;
        }
    }


    @RequestMapping(value = "/refreshplantree",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "修改项目刷新项目计划树")
    public OfficeResopnseBean refreshPlanTree(@RequestParam String projectId,@RequestParam String attendanceDate,@RequestParam Integer part, HttpServletRequest request){
        try{
            OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
            String userId = ContextUtils.getUserId(request);
            Map<String,Object> map = projectLogManager.getPlanTree(projectId,userId,attendanceDate,part);
            bean.setBody(map);
            return bean;
        }catch (Exception e){
            e.printStackTrace();
            OfficeResopnseBean responseBean = OfficeResopnseBean.newFailBean(500,"获取项目计划树失败！");
            return responseBean;
        }
    }

    @GetMapping(value = "/milepostplanfinished")
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询项目计划是否结束")
    public OfficeResopnseBean milepostPlanFinished(@RequestParam String contractId,@RequestParam Integer dutyId){
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(projectLogManager.milepostPlanIsFinished(contractId, dutyId));
        return bean;
    }

    @RequestMapping("/ownworklogs")
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询项目日志列表")
    public OfficeResopnseBean getOwnWorkLogs(@RequestParam String projectId, @RequestParam Integer milepostId, @RequestParam Date attendanceDate, HttpServletRequest request) {
        try{
            String userId = ContextUtils.getUserId(request);
            OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
            List<ProjectLogVO> result = projectLogManager.getOwnProjectLogs(projectId,userId,milepostId,attendanceDate);
            ListBeanSort.sort(result, "id", true);
            bean.setBody(result);
            return bean;
        }catch (Exception e){
            e.printStackTrace();
            OfficeResopnseBean responseBean = OfficeResopnseBean.newFailBean(500,"获取项目日志失败！");
            return responseBean;
        }
    }

    @RequestMapping(value = "/saveworklogs",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.SAVE,operDesc = "保存结构化日志")
    public OfficeResopnseBean saveOrUpdateWorkLogs(@RequestBody ProjectLogBaseVO projectLogBaseVO,HttpServletRequest request){
        String userId = ContextUtils.getUserId(request);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();

        List<ProjectLogVO> projectLogs = null;
        try {
            projectLogs = projectLogManager.saveWorkLogs(userId, projectLogBaseVO);
            ListBeanSort.sort(projectLogs,"id",true);
            bean.setBody(projectLogs);
            return bean;
        } catch (ParseException e) {
            e.printStackTrace();
            OfficeResopnseBean responseBean = OfficeResopnseBean.newFailBean(500,"保存日志失败！");
            return responseBean;
        }
    }

    @RequestMapping(value = "/searchprojects",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "结构化日志查询项目信息")
    public OfficeResopnseBean SearchProjects(@RequestParam String context,@RequestParam Integer pageNo,@RequestParam Integer pageSize,HttpServletRequest request){
        try{
            String userId = ContextUtils.getUserId(request);
            OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
            Result<CustomerProjectVO>  resultVO = projectLogManager.searchProjects(userId,context,pageNo,pageSize);
            bean.setBody(resultVO);
            return bean;
        }catch (Exception e){
            e.printStackTrace();
            OfficeResopnseBean responseBean = OfficeResopnseBean.newFailBean(500,"查找项目失败！");
            return responseBean;
        }
    }

    @RequestMapping(value = "/searchhouses",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "结构化日志查询宿舍信息")
    public OfficeResopnseBean SearchHouses(@RequestParam String area,@RequestParam String context,@RequestParam Integer pageNo,@RequestParam Integer pageSize,HttpServletRequest request){
        try{
            String userId = ContextUtils.getUserId(request);
            OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
            Result<HouseVO>  resultVO = projectLogManager.searchHouses(context,area,userId,pageNo,pageSize);
            bean.setBody(resultVO);
            return bean;
        }catch (Exception e){
            e.printStackTrace();
            OfficeResopnseBean responseBean = OfficeResopnseBean.newFailBean(500,"查找宿舍失败！");
            return responseBean;
        }
    }

    @RequestMapping(value = "/deleteprojectlog",method = RequestMethod.DELETE)
    @OperLog(operType = OperLogType.DELETE,operDesc = "删除结构化日志")
    public OfficeResopnseBean deleteProjectLog(@RequestParam Integer id){
        try{
            OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
            projectLogManager.deleteProjectLog(id);
            return bean;
        }catch (Exception e){
            e.printStackTrace();
            OfficeResopnseBean responseBean = OfficeResopnseBean.newFailBean(500,"删除失败！");
            return responseBean;
        }
    }

    @GetMapping(value = "/loadprojectwordlist")
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询项目文档信息列表")
    public OfficeResopnseBean loadProjectWordList(ProjectWordQueryCnd projectWordQueryCnd){
        try{
            OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
            Result<ProjectWordViewVO> resultVO = projectLogManager.getProjectWordList(projectWordQueryCnd);
            bean.setBody(resultVO);
            return bean;
        }catch (Exception e){
            e.printStackTrace();
            OfficeResopnseBean responseBean = OfficeResopnseBean.newFailBean(500,"获取文档列表失败！");
            return responseBean;
        }
    }

    @GetMapping(value = "/loadprojectworddetails")
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询里程碑项目文档信息列表")
    public OfficeResopnseBean loadProjectWordDetails(@RequestParam Integer pageNo,@RequestParam Integer pageSize,@RequestParam Integer id,@RequestParam Integer milepostId){
        try{
            OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
            Result<ProjectWordRecordViewVO> result = projectLogManager.getProjectWordDetails(pageNo, pageSize, id, milepostId);
            bean.setBody(result);
            return bean;
        }catch (Exception e){
            e.printStackTrace();
            OfficeResopnseBean responseBean = OfficeResopnseBean.newFailBean(500,"获取文档信息失败！");
            return responseBean;
        }
    }

    @GetMapping(value = "/loadstagedocumentheader")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取阶段文档表头")
    public OfficeResopnseBean loadStageDocumentHeader(@RequestParam String contractNo){
        try{
            OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
            List<StageDocumentHeaderVO> header = projectLogManager.getStageDocumentHeader(contractNo);
            bean.setBody(header);
            return bean;
        }catch (Exception e) {
            e.printStackTrace();
            OfficeResopnseBean responseBean = OfficeResopnseBean.newFailBean(500,"获取表头失败");
            return responseBean;
        }
    }

    @GetMapping(value = "/loadstagedocument")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取阶段文档信息")
    public OfficeResopnseBean loadStageDocument(@RequestParam String contractNo,@RequestParam String projectId){
        try{
            OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
            List<Map<String,Object>> header = projectLogManager.getStageDocument(contractNo,projectId);
            bean.setBody(header);
            return bean;
        }catch (Exception e) {
            e.printStackTrace();
            OfficeResopnseBean responseBean = OfficeResopnseBean.newFailBean(500,"获取阶段文档信息失败");
            return responseBean;
        }
    }

    @PostMapping(value = "/fileupload")
    @OperLog(operType = OperLogType.UPLOAD,operDesc = "上传文档")
    public OfficeResopnseBean fileUpload(@RequestParam MultipartFile file, @RequestParam Integer id,@RequestParam Integer fileKey,@RequestParam String contractId,@RequestParam Integer detailId,@RequestParam Integer milepostId,HttpServletRequest request){
        try{
            if(milepostId == null || milepostId == -1){
                throw new ServiceException("当前阶段不能上传文档");
            }else{
                OfficeResopnseBean bean  = OfficeResopnseBean.newSuccessBean();
                String userId = ContextUtils.getUserId(request);
                projectLogManager.fileUpload(userId,file,id,fileKey,contractId,detailId,milepostId);
                return bean;
            }
        }catch (Exception e){
            e.printStackTrace();
            OfficeResopnseBean responseBean = OfficeResopnseBean.newFailBean(500,"文件上传失败！");
            return responseBean;
        }
    }

    @GetMapping(value = "/uploadtypes")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取可上传文件格式列表")
    public OfficeResopnseBean uploadTypes(){
        try{
            OfficeResopnseBean bean  = OfficeResopnseBean.newSuccessBean();
            List<PublicDicVO> fileTypes = projectLogManager.getFileUploadTypes();
            bean.setBody(fileTypes);
            return bean;
        }catch (Exception e){
            e.printStackTrace();
            OfficeResopnseBean responseBean = OfficeResopnseBean.newFailBean(500,"获取上传文件格式失败！");
            return responseBean;
        }
    }

    @GetMapping(value = "/filedownload")
    @OperLog(operType = OperLogType.DOWNLOAD,operDesc = "下载项目文档")
    public void fileDownload(@RequestParam String htbh, @RequestParam Integer detailId, HttpServletResponse response){
        ProjectWordDetailDTO detailDTO = projectLogManager.findDetailById(htbh,detailId);
        ServletOutputStream sout = null;
        BufferedOutputStream bos = null;
        try {
            response.setContentLength(detailDTO.getFile().length);
            response.setContentType("application/octet-stream;charset=utf-8");
            // 下载文件能正常显示中文
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(detailDTO.getFileName(), "UTF-8"));
            sout = response.getOutputStream();
            bos = new BufferedOutputStream(sout);
            bos.write(detailDTO.getFile());
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

    @GetMapping(value = "/referencedownload")
    @OperLog(operType = OperLogType.DOWNLOAD,operDesc = "下载参考文件")
    public void referenceDownload(@RequestParam Integer fileId, HttpServletResponse response){
        ReferenceDocumentDTO referenceDocumentDTO = projectLogManager.findReferenceFileById(fileId);
        ServletOutputStream sout = null;
        BufferedOutputStream bos = null;
        try {
            response.setContentLength(referenceDocumentDTO.getReferenceContent().length);
            response.setContentType("application/octet-stream;charset=utf-8");
            // 下载文件能正常显示中文
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(referenceDocumentDTO.getReferenceName(), StandardCharsets.UTF_8));

            sout = response.getOutputStream();
            bos = new BufferedOutputStream(sout);
            bos.write(referenceDocumentDTO.getReferenceContent());
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
    @OperLog(operType = OperLogType.DELETE,operDesc = "删除项目文件")
    public OfficeResopnseBean fileDelete(@RequestParam Integer id,@RequestParam Integer detailId,@RequestParam String htbh){
       try {
            OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
            projectLogManager.deleteFile(id,detailId,htbh);
            return bean;
       }catch (Exception e){
           OfficeResopnseBean responseBean = OfficeResopnseBean.newFailBean(500,"文件删除失败！");
           return responseBean;
       }
    }
}
