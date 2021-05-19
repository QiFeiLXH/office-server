package com.bsoft.office.project.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.project.condition.ProjectPlanQueryCnd;
import com.bsoft.office.project.manager.ProjectLogAuditManager;
import com.bsoft.office.project.manager.ProjectLogManager;
import com.bsoft.office.project.manager.ProjectPlanManager;
import com.bsoft.office.project.vo.ProjectHavePlanVO;
import com.bsoft.office.project.vo.ProjectLogInfoQueryVO;
import com.bsoft.office.project.vo.ProjectPlanQueryLogVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping(value = "/planquery")
public class ProjectPlanQueryController {
    private static final Logger logger = LoggerFactory.getLogger(ProjectPlanQueryController.class);
    @Autowired
    private ProjectPlanManager projectPlanManager;
    @Autowired
    private ProjectLogManager projectLogManager;
    @Autowired
    private ProjectLogAuditManager projectLogAuditManager;


    @RequestMapping(value = "/planlist", method = RequestMethod.POST)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询项目计划列表")
    public OfficeResopnseBean getProjectPlanQueryList(@RequestBody ProjectPlanQueryCnd projectPlanQueryCnd,
                                                      HttpServletRequest request) {
        String personId = ContextUtils.getUserId(request);
        Result<ProjectHavePlanVO> result = projectPlanManager.getProjectPlanQueryList(personId, projectPlanQueryCnd, projectPlanQueryCnd.getPageNo(), projectPlanQueryCnd.getPageSize());
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        logger.info("获取项目计划查询列表成功！[{}]", JSONUtils.toString(result));
        return responseBean;
    }

    @RequestMapping(value = "/plantree", method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询项目计划树")
    public OfficeResopnseBean getProjectPlanQueryTree(@RequestParam String contractNo,@RequestParam String projectId, HttpServletRequest request) {
        Map<String, Object> map = projectPlanManager.getProjectPlanQueryTree(contractNo, projectId, 1);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(map);
        logger.info("获取项目计划查询-计划树成功！[{}]", JSONUtils.toString(map));
        return responseBean;
    }


    @RequestMapping(value = "/workloglist", method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询项目计划-日志列表")
    public OfficeResopnseBean getProjectWorklogList(@RequestParam("pageSize") Integer pageSize,
                                                    @RequestParam("pageNo") Integer pageNo,
                                                    @RequestParam("milepostId") Integer milepostId,
                                                    @RequestParam("contractNo") String contractNo) {
        Result<ProjectPlanQueryLogVO> result = projectLogManager.getProjectWorklogList(pageSize, pageNo - 1, milepostId, contractNo);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        logger.info("获取项目计划查询-日志列表成功！[{}]", JSONUtils.toString(result));
        return responseBean;
    }

    @RequestMapping(value = "/workloginfo", method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询项目计划-日志详情")
    public OfficeResopnseBean getWorklogInfo(@RequestParam("id") Integer id) {
        ProjectLogInfoQueryVO worklogInfo = projectLogManager.getWorklogInfo(id);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(worklogInfo);
        logger.info("获取项目计划查询-日志详情成功！[{}]", JSONUtils.toString(worklogInfo));
        return responseBean;
    }

    @RequestMapping(value = "/initpage", method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询获取日志查询，修改界面字典(角色)，(类型)数据")
    public OfficeResopnseBean getWorkLogs(HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        Map<String, Object> map = projectLogAuditManager.getRoleAndType();
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(map);
        logger.info("获取日志查询，修改界面字典(角色)，(类型)数据成功！");
        return responseBean;

    }
}
