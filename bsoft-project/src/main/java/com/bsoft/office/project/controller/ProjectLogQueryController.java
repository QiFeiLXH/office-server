package com.bsoft.office.project.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.project.condition.ProjectLogQueryCnd;
import com.bsoft.office.project.manager.ProjectLogAuditManager;
import com.bsoft.office.project.manager.ProjectLogManager;
import com.bsoft.office.project.vo.ProjectLogQueryDetailVO;
import com.bsoft.office.project.vo.ProjectLogQueryProjectVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/logquery")
public class ProjectLogQueryController {
    private static final Logger logger = LoggerFactory.getLogger(ProjectLogQueryController.class);

    @Autowired
    private ProjectLogManager projectLogManager;
    @Autowired
    private ProjectLogAuditManager projectLogAuditManager;

    /** 获取项目日志查询登录人员填写日志或者项目经理管理的项目 */
    @PostMapping("/projectswithlogsnum")
    @OperLog(operType = OperLogType.QUERY,operDesc = "项目日志查询")
    public OfficeResopnseBean getProjectsWithLogsnum(@RequestBody ProjectLogQueryCnd projectLogQueryCnd,
                                                     HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        projectLogQueryCnd.setUserId(userId);
        Result<ProjectLogQueryProjectVO> projects = projectLogManager.getProjectsWithLogsnum(projectLogQueryCnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(projects);
        logger.info("获取项目日志查询-项目成功！[{}]", JSONUtils.toString(projects));
        return responseBean;

    }

    /** 获取登录人员填写日志或者项目经理管理的项目下的项目日志概要 */
    @PostMapping("/projectlogssummary")
    @OperLog(operType = OperLogType.QUERY,operDesc = "项目日志概要")
    public OfficeResopnseBean getProjectLogSummary(@RequestBody ProjectLogQueryCnd projectLogQueryCnd,
                                                   @RequestParam(required = false) String inputContent,
                                                   @RequestParam(required = false) String projectId,
                                                   HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        projectLogQueryCnd.setUserId(userId);
        Result<ProjectLogQueryDetailVO> logs = projectLogManager.getProjectLogSummary(projectLogQueryCnd, inputContent, projectId);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(logs);
        logger.info("获取项目日志查询-日志成功！[{}]", JSONUtils.toString(logs));
        return responseBean;
    }

    @RequestMapping(value = "/initpage",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "日志查询数据")
    public OfficeResopnseBean getWorkLogs(HttpServletRequest request){
        String userId = ContextUtils.getUserId(request);
        Map<String,Object> map = projectLogAuditManager.getRoleAndType();
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(map);
        logger.info("获取日志查询，修改界面字典(角色)，(类型)数据成功！");
        return responseBean;
    }

}
