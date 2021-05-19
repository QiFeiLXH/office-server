package com.bsoft.office.manager.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.manager.condition.GroupRoleQueryCnd;
import com.bsoft.office.manager.manager.GroupRoleManager;
import com.bsoft.office.manager.vo.GroupRoleVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: zy
 * @date: 2020/12/4
 * @description 流程组角色
 */
@RestController
@RequestMapping("/role/workflowgroup")
public class GroupRoleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GroupRoleController.class);

    @Autowired
    private GroupRoleManager groupRoleManager;

    @GetMapping(value = "/list")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取流程组角色列表")
    public OfficeResopnseBean getGroupRoleList(GroupRoleQueryCnd queryCnd, HttpServletRequest request){
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("流程组角色--工号[{}]获取流程组角色列表[{}]", userId, JSONUtils.toString(queryCnd));
        Result<GroupRoleVO> result = groupRoleManager.getGroupRoleList(userId, queryCnd);
        return OfficeResopnseBean.newSuccessBean(result);
    }

    @PostMapping(value = "/save")
    @OperLog(operType = OperLogType.SAVE,operDesc = "保存流程组角色信息")
    public OfficeResopnseBean saveGroupRole(@RequestBody GroupRoleVO saveVO, HttpServletRequest request){
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("流程组角色--工号[{}]保存流程组角色信息[{}]", userId, JSONUtils.toString(saveVO));
        groupRoleManager.saveGroupRole(userId, saveVO);
        return OfficeResopnseBean.newSuccessBean();
    }


    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @OperLog(operType = OperLogType.DELETE,operDesc = "删除流程组角色信息")
    public OfficeResopnseBean deleteGroupRole(@RequestParam(value = "id") Integer id, HttpServletRequest request){
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("流程组角色--工号[{}]删除流程组角色信息[{}]", userId, id);
        groupRoleManager.deleteGroupRole(userId, id);
        return OfficeResopnseBean.newSuccessBean();
    }


}
