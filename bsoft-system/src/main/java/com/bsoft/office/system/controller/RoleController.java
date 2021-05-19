package com.bsoft.office.system.controller;

import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.system.manager.RoleManager;
import com.bsoft.office.system.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/role")
public class RoleController {
    private final static Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleManager roleManager;

    /**
     * 获取角色列表
     * @return
     */
    @RequestMapping(value = "/roleList",method = RequestMethod.GET)
    public OfficeResopnseBean getRoleList(){
        logger.info("获取系统角色列表！");
        List<RoleVO> roleVOS = roleManager.getRoleList();
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(roleVOS);
        return bean;
    }

    /**
     * 添加角色，并获取最新的角色列表
     * @param roleVO
     * @return
     */
    @RequestMapping(value = "/roleAdd",method = RequestMethod.POST)
    public OfficeResopnseBean addRole(@RequestBody RoleVO roleVO) {
        logger.info("保存角色信息[{}]",JSONUtils.toString(roleVO));
        List<RoleVO> roleVOS = roleManager.saveRole(roleVO);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(roleVOS);
        return bean;
    }

    /**
     * 删除角色及角色权限信息
     * @param roleId 角色ID
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public OfficeResopnseBean deleteRole(@RequestParam(value = "roleId",required = true) Integer roleId){
        logger.info("删除角色[{}]信息，及菜单、全新等信息",roleId);
        boolean status = roleManager.deleteRole(roleId);
        OfficeResopnseBean bean = null;
        if (status){
            bean = OfficeResopnseBean.newSuccessBean();
        } else {
            bean = OfficeResopnseBean.newFailBean(500,"删除角色相关信息失败!");
        }
        return bean;
    }
    /**
     * 根据角色Id 获取有权限用户信息
     * @param roleId
     * @return
     */
    @RequestMapping(value = "/rolePersonList",method = RequestMethod.GET)
    public OfficeResopnseBean RolePersonList(@RequestParam(value = "roleId",required = true) Integer roleId){
        logger.info("角色维护人员时，开始获取对应角色[{}]的人员信息......",roleId);
        List<RolePersonViewVO> rolePersonDTOS = roleManager.getPersonListByRoleId(roleId);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(rolePersonDTOS);
        return bean;
    }

    /**
     * 设置角色用户时
     * 根据姓名或拼音码获取人员信息
     * @param value
     * @return
     */
    @RequestMapping(value = "/personList",method = RequestMethod.GET)
    public OfficeResopnseBean PersonList(@RequestParam(value = "value",required = true) String value){
        logger.info("角色维护人员时，根据条件[{}]所有在职员工信息......",value);
        List<RolePersonVO> rolePersonVOS = roleManager.getRolePersonList(value);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(rolePersonVOS);
        return bean;
    }

    /**
     * 更新角色人员信息
     * @param rolePersonSaveVO
     * @return
     */
    @RequestMapping(value = "/saveRolePerson",method = RequestMethod.POST)
    public OfficeResopnseBean saveRolePerson(@RequestBody RolePersonSaveVO rolePersonSaveVO){
        Integer roleId = rolePersonSaveVO.getRoleId();
        List<String> orininal = rolePersonSaveVO.getOrininal();
        List<String> newlist = rolePersonSaveVO.getNewList();
        boolean status = roleManager.saveRolePerson(roleId,orininal,newlist);
        OfficeResopnseBean bean = null;
        if (status){
            bean = OfficeResopnseBean.newSuccessBean();
            logger.info("角色维护人员时，更新人员角色成功！");
        }else{
            bean = OfficeResopnseBean.newFailBean(500,"更新人员角色失败！");
            logger.error("角色维护人员时，更新人员角色失败！");
        }
        return bean;
    }

    /**
     * 根据部门编码获取人员信息
     * @param bmdm
     * @return
     */
    @RequestMapping(value = "/orgPersonList",method = RequestMethod.GET)
    public OfficeResopnseBean OrgPersonList(@RequestParam(value = "bmdm",required = true) String bmdm) {
        logger.info("获取bmdm=[{}]的人员信息",bmdm);
        List<RolePersonVO> personVOS = roleManager.getOrgPersonList(bmdm);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(personVOS);
        return bean;
    }

    /**
     * 获取所有菜单及按钮，角色所拥有的菜单、及操作权限
     * @param roleId
     * @return
     */
    @RequestMapping(value = "/MenuAuthList",method = RequestMethod.GET)
    public OfficeResopnseBean getRoleAuthList(@RequestParam(value = "roleId",required = true) Integer roleId,
                                              @RequestParam(value = "system",required = true) Integer system){
        logger.info("获取角色[{}]的菜单信息...",roleId);
        Map<String,Object> returnMap = roleManager.RoleMenuAuthInfo(roleId,system);

        List<OfficeMenuVO> officeMenuVOList = (List<OfficeMenuVO>) returnMap.get("menuInfo");
        List<Integer> menusId = (List<Integer>) returnMap.get("AuthMenuInfo");
        List<Map<String,Object>> actionIds = (List<Map<String, Object>>) returnMap.get("AuthInfo");

        Map<String,Object> map1 = new HashMap<>();
        map1.put("actionList",actionIds);
        map1.put("menuIdList",menusId);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(officeMenuVOList);
        bean.setProperties(map1);
        return bean;
    }

    /**
     * 更新角色拥有的菜单及操作权限
     * @param roleMenuAuthSaveVO
     * @return
     */
    @RequestMapping(value = "/saveRoleMenuAuth",method = RequestMethod.POST)
    public OfficeResopnseBean saveRoleAuth(@RequestBody RoleMenuAuthSaveVO roleMenuAuthSaveVO){
        logger.info("更新角色权限菜单[{}]",JSONUtils.toString(roleMenuAuthSaveVO));
        Integer roleId = roleMenuAuthSaveVO.getRoleId();
        List<Integer> menuIds = roleMenuAuthSaveVO.getMenuIds();
        List<Map> authInfo = roleMenuAuthSaveVO.getAuthInfo();
        Integer system = roleMenuAuthSaveVO.getSystem();
        boolean status = roleManager.saveRoleMenuAuthInfo(roleId,menuIds,authInfo,system);
        OfficeResopnseBean bean = null;
        if (status){
            bean = OfficeResopnseBean.newSuccessBean();
        }else{
            bean = OfficeResopnseBean.newFailBean(500,"保存权限出错！");
        }
        return bean;
    }


}
