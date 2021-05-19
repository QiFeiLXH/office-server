package com.bsoft.office.manager.controller;

import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.manager.manager.RoleMaintainManager;
import com.bsoft.office.manager.vo.RoleNameVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/10/23 11:18
 * @Description
 */
@RestController
@RequestMapping("/rolenamemaintain")
public class RoleNameMaintainController {
    @Autowired
    private RoleMaintainManager roleMaintainManager;

    @GetMapping("/getroles")
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询角色名称列表")
    public OfficeResopnseBean getRoles(@RequestParam Integer status, @RequestParam String content){
        List<RoleNameVO> roles = roleMaintainManager.getRoles(status, content);
        OfficeResopnseBean res = OfficeResopnseBean.newSuccessBean();
        res.setBody(roles);
        return res;
    }

    @PostMapping("/saverole")
    @OperLog(operType = OperLogType.SAVE,operDesc = "新增、修改角色名称")
    public OfficeResopnseBean saveRole(@RequestBody RoleNameVO role){
        RoleNameVO roleNameVO = roleMaintainManager.saveRole(role);
        OfficeResopnseBean res = OfficeResopnseBean.newSuccessBean();
        res.setBody(roleNameVO);
        return res;
    }

    @PostMapping("/saveroles")
    @OperLog(operType = OperLogType.MODIFY, operDesc = "批量修改角色名称")
    public OfficeResopnseBean saveRoles(@RequestBody List<RoleNameVO> roles){
        List<RoleNameVO> roleNameVO = roleMaintainManager.saveRoles(roles);
        OfficeResopnseBean res = OfficeResopnseBean.newSuccessBean();
        res.setBody(roleNameVO);
        return res;
    }
}
