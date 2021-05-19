package com.bsoft.office.manager.controller;

import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.manager.PublicDicManager;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.vo.PublicDicVO;
import com.bsoft.office.manager.manager.AuthManager;
import com.bsoft.office.manager.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author: xucl
 * @DateTime: 2020/10/20 16:42
 * @Description:
 */
@RestController
@RequestMapping(value = "/authmanager")
public class AuthManagerController {

    @Autowired
    private AuthManager authManager;
    @Autowired
    private PublicDicManager publicDicManager;

    @RequestMapping(value = "/systemlist",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取信息系统列表")
    public OfficeResopnseBean getSystemList(){
        List<PublicDicVO> list = publicDicManager.getPublicDicsWithFlag(9908,1);
        return OfficeResopnseBean.newSuccessBean(list);
    }

    @RequestMapping(value = "/rolelist",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询角色列表")
    public OfficeResopnseBean getRoles(){
        List<RoleShowVO> list = authManager.getRoles();
        return OfficeResopnseBean.newSuccessBean(list);
    }

    @RequestMapping(value = "/rolepersonlist",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "根据角色ID查询该角色用户列表")
    public OfficeResopnseBean getRoleList(@RequestParam(name = "roleId") Integer roleId){
        List<RolePersonViewVO> list = authManager.findRolePersonsByRole(roleId);
        return OfficeResopnseBean.newSuccessBean(list);
    }

    @RequestMapping(value = "/saverole",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.SAVE,operDesc = "新增、修改角色信息")
    public OfficeResopnseBean saveRole(@RequestBody List<RoleVO> roleVOS){
        List<RoleVO> roleVOS1 = authManager.saveRoles(roleVOS);
        return OfficeResopnseBean.newSuccessBean(roleVOS1);
    }

    @RequestMapping(value = "/deleterole",method = RequestMethod.DELETE)
    @OperLog(operType = OperLogType.DELETE,operDesc = "删除角色信息")
    public OfficeResopnseBean deleteRole(@RequestParam(name = "id") Integer id){
        authManager.deleteRole(id);
        return OfficeResopnseBean.newSuccessBean();
    }

    @RequestMapping(value = "/saveroleperson",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.SAVE,operDesc = "新增、修改角色人员列表")
    public OfficeResopnseBean saveRolePerson(@RequestBody RolePersonVO rolePersonVO){
        authManager.saveRolePerson(rolePersonVO);
        return OfficeResopnseBean.newSuccessBean();
    }

    @RequestMapping(value = "/deleteroleperson",method = RequestMethod.DELETE)
    @OperLog(operType = OperLogType.DELETE,operDesc = "删除人员的角色信息")
    public OfficeResopnseBean deleteRolePerson(@RequestParam(name = "personId") String personId){
        authManager.deleteRolePerson(personId);
        return OfficeResopnseBean.newSuccessBean();
    }

    /**
     * 获取角色和人员的菜单及操作权限
     * @param roleId
     * @param personId
     * @return
     */
    @RequestMapping(value = "/getauth",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询人员的权限信息")
    public OfficeResopnseBean getAuth(@RequestParam(name = "roleId") Integer roleId,
                                      @RequestParam(name = "personId") String personId,
                                      @RequestParam(name = "system") Integer system){
        Map<String,Object> map = authManager.getMenuAuth(roleId,personId,system);
        return OfficeResopnseBean.newSuccessBean(map);

    }

    @RequestMapping(value = "/authrange",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取权限范围字典列表")
    public OfficeResopnseBean getAuthRangeList(){
        List<PublicDicVO> list = publicDicManager.getPublicDics(9911);
        return OfficeResopnseBean.newSuccessBean(list);
    }

    @RequestMapping(value = "/saveauth",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.SAVE,operDesc = "更新权限信息")
    public OfficeResopnseBean saveAuth(@RequestBody AuthSaveVO authSaveVO
                                        ){
        authManager.saveAuth(
                authSaveVO.getRoleId(),
                authSaveVO.getPersonId(),
                authSaveVO.getSystem(),
                authSaveVO.getMenuIds(),
                authSaveVO.getMenuAuths(),
                authSaveVO.getMenuRanges(),
                authSaveVO.getPersonDeptAuths()
        );
        return OfficeResopnseBean.newSuccessBean();
    }

    @RequestMapping(value = "/getroleperson",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "根据工号查询角色信息")
    public OfficeResopnseBean getRolePerson(@RequestParam("personId") String personId){
        List<RolePersonViewVO> list = authManager.getRolePersonByPersonId(personId);
        return OfficeResopnseBean.newSuccessBean(list);
    }
}
