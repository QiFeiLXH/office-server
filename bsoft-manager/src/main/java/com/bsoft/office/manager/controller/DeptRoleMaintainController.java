package com.bsoft.office.manager.controller;

import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.annotation.RequiredExportLog;
import com.bsoft.office.common.condition.ExportLogParams;
import com.bsoft.office.common.exportExcel.ExportExcel;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.manager.manager.RoleMaintainManager;
import com.bsoft.office.manager.vo.RoleMaintainBaseVO;
import com.bsoft.office.manager.vo.RoleNameVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @Auther: hy
 * @Date: 2020/8/3
 * @Description:
 */
@RestController
@RequestMapping("/deptrolemaintain")
public class DeptRoleMaintainController {

    @Autowired
    private RoleMaintainManager roleMaintainManager;

    @GetMapping("/getroles")
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询部门角色列表")
    public OfficeResopnseBean getRoles(@RequestParam Integer status,@RequestParam String content){
        List<RoleNameVO> roles = roleMaintainManager.getRoles(status, content);
        OfficeResopnseBean res = OfficeResopnseBean.newSuccessBean();
        res.setBody(roles);
        return res;
    }

    @PostMapping("/saverole")
    @OperLog(operType = OperLogType.SAVE,operDesc = "保存部门角色信息")
    public OfficeResopnseBean saveRole(@RequestBody RoleNameVO role){
        RoleNameVO roleNameVO = roleMaintainManager.saveRole(role);
        OfficeResopnseBean res = OfficeResopnseBean.newSuccessBean();
        res.setBody(roleNameVO);
        return res;
    }

    @PostMapping("/saveroles")
    @OperLog(operType = OperLogType.SAVE,operDesc = "批量保存部门角色信息")
    public OfficeResopnseBean saveRoles(@RequestBody List<RoleNameVO> roles){
        List<RoleNameVO> roleNameVO = roleMaintainManager.saveRoles(roles);
        OfficeResopnseBean res = OfficeResopnseBean.newSuccessBean();
        res.setBody(roleNameVO);
        return res;
    }

    @GetMapping("/getdeptroles")
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询部门角色人员信息")
    public OfficeResopnseBean getDeptRoles(@RequestParam String dept){
        List<RoleMaintainBaseVO> roleMaintainBase = roleMaintainManager.getDeptRoles(dept);
        OfficeResopnseBean res = OfficeResopnseBean.newSuccessBean();
        res.setBody(roleMaintainBase);
        return res;
    }

    @PostMapping("/savedeptroles")
    @OperLog(operType = OperLogType.SAVE,operDesc = "更新部门角色人员信息")
    public OfficeResopnseBean saveDeptRoles(@RequestBody List<RoleMaintainBaseVO> deptRoles){
        roleMaintainManager.saveDeptRoles(deptRoles);
        OfficeResopnseBean res = OfficeResopnseBean.newSuccessBean();
        return res;
    }

    @GetMapping("/getdeptroledetails")
    @OperLog(operType = OperLogType.QUERY,operDesc = "查看部门角色人员列表")
    public OfficeResopnseBean getDeptRoleDetails(){
        List<Map<String,Object>> roleMaintainBase = roleMaintainManager.getDeptRoleDetails();
        OfficeResopnseBean res = OfficeResopnseBean.newSuccessBean();
        res.setBody(roleMaintainBase);
        return res;
    }

    @GetMapping("/deptroledetailsdownload")
    @RequiredExportLog
    @OperLog(operType = OperLogType.EXPORT,operDesc = "导出部门角色人员列表")
    public void exportDeptRoleDetails(ExportLogParams params, HttpServletResponse response){
        Map<String, Object> colsAndData = roleMaintainManager.exportDeptRoleDetails();
        ExportExcel.mapExport(colsAndData,"部门角色列表",response);
    }

}
