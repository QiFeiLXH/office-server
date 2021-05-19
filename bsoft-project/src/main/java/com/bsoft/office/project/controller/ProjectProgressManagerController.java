package com.bsoft.office.project.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.manager.AuthorityPublicManager;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.project.condition.ProgressManagerQueryCnd;
import com.bsoft.office.project.manager.ProjectProgressManager;
import com.bsoft.office.project.vo.ProjectExpandViewVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author Xuhui Lin
 * @Date 2021/4/20 20:09
 * @Description
 */
@RestController
    @RequestMapping("/projectprogress")
public class ProjectProgressManagerController {
    @Autowired
    private ProjectProgressManager projectProgressManager;
    @Autowired
    private AuthorityPublicManager authorityPublicManager;

    @GetMapping(value = "/query")
    @OperLog(operType = OperLogType.QUERY,operDesc = "项目进度管理员列表")
    public OfficeResopnseBean getProjectProgressManagerList(ProgressManagerQueryCnd cnd, HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        Integer menuId = ContextUtils.getMenuId(request);
        boolean allPermission = authorityPublicManager.checkAllPermission(userId, menuId, 1);
        cnd.setPersonId(userId);
        cnd.setAllPermission(allPermission);
        Result<ProjectExpandViewVO> result = projectProgressManager.getProjectProgressManagerList(cnd);
        return OfficeResopnseBean.newSuccessBean(result);
    }

    @PostMapping(value = "/save")
    @OperLog(operType = OperLogType.SAVE,operDesc = "项目进度管理员保存")
    public OfficeResopnseBean saveProjectProgressManager(@RequestBody ProjectExpandViewVO progressManager, HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        progressManager.setRegistrant(userId);
        projectProgressManager.saveProjectProgressManager(progressManager);
        return OfficeResopnseBean.newSuccessBean("保存成功");
    }
}
