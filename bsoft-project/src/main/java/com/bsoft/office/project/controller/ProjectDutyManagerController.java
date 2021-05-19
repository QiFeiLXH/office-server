package com.bsoft.office.project.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.annotation.RequiredExportLog;
import com.bsoft.office.common.condition.ExportLogParams;
import com.bsoft.office.common.exportExcel.ExportExcel;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.project.condition.ProjectDutyQueryCnd;
import com.bsoft.office.project.manager.ProjectDutyManager;
import com.bsoft.office.project.vo.ProjectDutyAuditSaveVO;
import com.bsoft.office.project.vo.ProjectDutyAuditViewVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-05-20 14:25
 * @Version 1.0
 * @Description
 */
@RestController
@RequestMapping("/dutymanager")
public class ProjectDutyManagerController {
    private static final Logger logger = LoggerFactory.getLogger(ProjectDutyManagerController.class);

    @Autowired
    private ProjectDutyManager projectDutyManager;

    /** 项目责任书管理列表 */
    @PostMapping(value = "/query")
    @OperLog(operType = OperLogType.QUERY,operDesc = "项目责任书管理列表")
    public OfficeResopnseBean getProjectDutyAuditList(@RequestBody ProjectDutyQueryCnd cnd,
                                                         HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        cnd.setUserId(userId);
        Result<ProjectDutyAuditViewVO> result = projectDutyManager.getProjectDutyAuditList(cnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        logger.info("获取项目责任书管理列表成功！[{}]", JSONUtils.toString(result));
        return responseBean;
    }

    /** 项目责任书维护列表 */
    @PostMapping(value = "/audit")
    @OperLog(operType = OperLogType.OTHER,operDesc = "审核责任书")
    public OfficeResopnseBean auditProjectDutyList(@RequestBody List<ProjectDutyAuditSaveVO> saveVOS,
                                                      HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        projectDutyManager.auditProjectDutyList(saveVOS, userId);
        responseBean.setBody("审核责任书成功！");
        logger.info("项目责任书-审核责任书成功！");
        return responseBean;
    }

    /** 项目责任书管理列表-导出excel */
    @GetMapping(value = "/dutydownload")
    @RequiredExportLog
    @OperLog(operType = OperLogType.EXPORT,operDesc = "项目责任书管理列表-导出excel")
    public void exportProjectDutyAuditList(ProjectDutyQueryCnd cnd,
                                           ExportLogParams params,
                                           HttpServletRequest request,
                                           HttpServletResponse response) {
        String userId = ContextUtils.getUserId(request);
        cnd.setUserId(userId);
        List<ProjectDutyAuditViewVO> list = projectDutyManager.exportProjectDutyAuditList(cnd);
        ExportExcel.export(list,ProjectDutyAuditViewVO.class,"项目责任书审核列表",response);
    }
}
