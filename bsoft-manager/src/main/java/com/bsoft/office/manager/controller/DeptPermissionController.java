package com.bsoft.office.manager.controller;

import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.manager.DeptPermissionManager;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/10/19 17:01
 * @Description
 */
@RestController
@RequestMapping("/deptpermission")
public class DeptPermissionController {
    @Autowired
    DeptPermissionManager deptPermissionManager;


    /**
     * 根据工号、类型查询员工权限部门
     * @param personId 工号
     * @param flag 1 部门权限 2工程区域
     * @return
     */
    @RequestMapping(value = "/authoritydept",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "员工权限部门")
    public OfficeResopnseBean getPersonalAuthorityDepts(@RequestParam String personId, @RequestParam Integer flag){
        List<String> persons = deptPermissionManager.getPersonalAuthorityDepts(personId, flag);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(persons);
        return responseBean;
    }


    /**
     * 保存权限部门
     * @param needSaves 待保存的部门id
     * @param needDeletes 待删除的部门id
     * @param personId 工号
     * @param flag 1 部门权限 2工程区域
     * @return
     */
    @PostMapping(value = "/authoritydeptsave")
    @OperLog(operType = OperLogType.MODIFY,operDesc = "保存权限部门")
    public OfficeResopnseBean saveAuthorityDept(@RequestParam(required = false) List<String> needSaves,
                                                @RequestParam(required = false) List<String> needDeletes,
                                                @RequestParam String personId,
                                                @RequestParam Integer flag){
        if (needDeletes == null) {
            needDeletes = new ArrayList<>();
        }
        if (needSaves == null) {
            needSaves = new ArrayList<>();
        }
        deptPermissionManager.saveAuthorityDept(personId, flag, needSaves, needDeletes);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody("保存、删除部门权限成功");
        return responseBean;
    }
}
