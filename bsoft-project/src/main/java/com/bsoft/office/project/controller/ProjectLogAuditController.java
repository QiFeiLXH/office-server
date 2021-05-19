package com.bsoft.office.project.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.project.condition.WorkLogAuditCnd;
import com.bsoft.office.project.manager.ProjectLogAuditManager;
import com.bsoft.office.project.manager.ProjectLogManager;
import com.bsoft.office.project.manager.ProjectPlanManager;
import com.bsoft.office.project.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(value = "/workLogAudit")
public class ProjectLogAuditController {
    private static Logger logger = LoggerFactory.getLogger(ProjectLogAuditController.class);

    @Autowired
    private ProjectLogAuditManager projectLogAuditManager;
    @Autowired
    private ProjectLogManager projectLogManager;
    @Autowired
    private ProjectPlanManager projectPlanManager;

    @RequestMapping(value = "/getAllWorkLogs",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询结构化日志全部列表")
    public OfficeResopnseBean getWorkLogs(@RequestBody WorkLogAuditCnd params, HttpServletRequest request){
        String userId = ContextUtils.getUserId(request);
        Result<ProjectLogNeedAuditVO> workLogVOResult = projectLogAuditManager.getProjectLogNeedAudit(userId,params);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(workLogVOResult);
        logger.info("获取项目日志全部列表成功！[工号：{}]",userId);
        return responseBean;
    }

    @RequestMapping(value = "/saveWorkLogDetails",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.SAVE,operDesc = "审核结构化日志审核明细")
    public OfficeResopnseBean saveWorkLogDetails(@RequestBody List<ProjectLogAuditVO> projectLogAuditList, HttpServletRequest request){
        String userId = ContextUtils.getUserId(request);
        projectLogAuditManager.auditProjectLogs(userId,projectLogAuditList);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        logger.info("{}审核项目日志审核明细成功！",userId);
        return responseBean;
    }

    @RequestMapping(value = "/getWorkLogById",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询结构化日志详情")
    public OfficeResopnseBean getWorkLogById(@RequestParam Integer proWorkLogId, @RequestParam String projectId,HttpServletRequest request){
        Map<String,Object> returnMap = projectLogAuditManager.getWorkLogById(proWorkLogId,projectId);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(returnMap);
        logger.info("获取项目日志详情成功！[id:{}]",proWorkLogId);
        return responseBean;

    }

    @RequestMapping(value = "/saveWorkLog",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.MODIFY,operDesc = "修改结构化日志")
    public OfficeResopnseBean saveWorkLog(@RequestBody ProjectLogBaseVO projectLogBaseVO, HttpServletRequest request){
            ProjectLogVO projectLog = projectLogAuditManager.saveWorkLog(projectLogBaseVO);
            OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
            responseBean.setBody(projectLog);
            logger.info("修改日志成功！[{}]", JSONUtils.toString(projectLogBaseVO));
            return responseBean;
    }



    @RequestMapping(value = "/getProjectWithAuditList",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询项目列表")
    public OfficeResopnseBean getProjectWithAuditList(@RequestBody WorkLogAuditCnd params,HttpServletRequest request){
        String userId = ContextUtils.getUserId(request);
        Result<ProjectWithAuditVO> projectWithAudits = projectLogAuditManager.getProjectWithAuditList(userId,params);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(projectWithAudits);
        logger.info("获取{}所属的项目列表成功！",userId);
        return responseBean;
    }

    @RequestMapping(value = "/initpage",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询日志审核，修改界面字典(角色)，(类型)数据")
    public OfficeResopnseBean getWorkLogs(HttpServletRequest request){
        String userId = ContextUtils.getUserId(request);
        Map<String,Object> map = projectLogAuditManager.getRoleAndType();
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(map);
        logger.info("获取日志审核，修改界面字典(角色)，(类型)数据成功！");
        return responseBean;
    }
}
