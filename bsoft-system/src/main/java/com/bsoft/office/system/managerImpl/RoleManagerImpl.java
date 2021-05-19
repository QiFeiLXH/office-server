package com.bsoft.office.system.managerImpl;

import com.bsoft.auth.dto.AuthorityDTO;
import com.bsoft.auth.dto.RoleDTO;
import com.bsoft.auth.dto.RolePersonViewDTO;
import com.bsoft.auth.service.AuthService;
import com.bsoft.auth.service.RoleService;
import com.bsoft.menu.dto.MenuDTO;
import com.bsoft.menu.dto.OfficeMenuDTO;
import com.bsoft.menu.service.MenuService;
import com.bsoft.office.common.dozer.GeneratorUtil;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.system.manager.RoleManager;
import com.bsoft.office.system.vo.OfficeMenuVO;
import com.bsoft.office.system.vo.RolePersonVO;
import com.bsoft.office.system.vo.RolePersonViewVO;
import com.bsoft.office.system.vo.RoleVO;
import com.bsoft.person.dto.PersonDTO;
import com.bsoft.person.service.PersonService;
import com.google.common.collect.Collections2;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RoleManagerImpl implements RoleManager {

    private static final Logger logger = LoggerFactory.getLogger(RoleManagerImpl.class);

    @Reference
    private RoleService roleService;
    @Reference(timeout = 60000)
    private PersonService personService;
    @Reference
    private AuthService authService;
    @Reference
    private MenuService menuService;
    @Autowired
    private GeneratorUtil generatorUtil;

    @Override
    public List<RoleVO> getRoleList() {
        List<RoleDTO> roleDTOS = roleService.getRoleList();
        List<RoleVO> roleVOS = generatorUtil.convert(roleDTOS,RoleVO.class);
        logger.info("获取系统角色列表[{}]成功！", JSONUtils.toString(roleVOS));
        return roleVOS;
    }

    @Override
    public List<RoleVO> saveRole(RoleVO roleVO) {
        RoleDTO roleDTO = generatorUtil.convert(roleVO,RoleDTO.class);
        List<RoleDTO> roleDTOS = roleService.saveRole(roleDTO);
        List<RoleVO> roleVOS = generatorUtil.convert(roleDTOS,RoleVO.class);
        logger.info("保存[{}]并获取系统角色列表[{}]成功！", JSONUtils.toString(roleDTO),JSONUtils.toString(roleVOS));
        return roleVOS;
    }

    @Override
    public List<RolePersonVO> getRolePersonList(String value) {
        List<PersonDTO> personDTOS = personService.getPersonInfo(value);
        List<RolePersonVO> personVOS = generatorUtil.convert(personDTOS,RolePersonVO.class);
        logger.info("角色维护人员时，获取条件[{}]所有在职员工信息成功[{}]！",value,JSONUtils.toString(personVOS));
        return personVOS;
    }

    @Override
    public List<RolePersonViewVO> getPersonListByRoleId(Integer roleId) {
        List<RolePersonViewDTO> rolePersonList = roleService.getRolePerson(roleId);
        logger.info("角色维护人员时，获取对应角色的人员信息成功！");
        return generatorUtil.convert(rolePersonList,RolePersonViewVO.class);
    }

    @Override
    public boolean saveRolePerson(Integer roleId, List<String> orininal, List<String> newlist) {
        List<String> A1 = orininal;
        List<String> A2 = orininal;
        List<String> B1 = newlist;
        List<String> B2 = newlist;
        A1.removeAll(B1);
        B2.removeAll(A2);
        List<String> add = B2;
        List<String> remove = A1;
        boolean status = false;
        status = roleService.saveRolePerson(roleId,add,remove);
        logger.info("更新人员角色权限[{}]",status);
        return status;
    }

    @Override
    public List<RolePersonVO> getOrgPersonList(String bmdm) {
        List<PersonDTO> list = personService.getDeptPerson(bmdm);
        List<RolePersonVO> personVOS = generatorUtil.convert(list,RolePersonVO.class);
        logger.info("根据部门代码[{}],获取人员列表[{}]成功！",bmdm,JSONUtils.toString(personVOS));
        return personVOS;
    }

    @Override
    public Map RoleMenuAuthInfo(Integer roleId,Integer system) {
        Map<String,Object> map = menuService.getOfficeAllMenuAndAuth(roleId,system);
        logger.info("获取系统[{}]所有菜单信息[{}]",system,JSONUtils.toString(map));
        Map<String,Object> returnMap = this.processRoleAuth(map);
        return returnMap;
    }

    @Override
    public boolean saveRoleMenuAuthInfo(Integer roleId,List<Integer> menuIds,List<Map> authInfo,Integer system) {
        boolean status = false;
        status = authService.saveOfficeAuth(roleId,menuIds,authInfo,system);
        return status;
    }

    @Override
    public boolean deleteRole(Integer roleId) {
        boolean status = false;
        status = roleService.deleteRole(roleId);
        return status;
    }

    private List<Map<String,Object>> processAuthActions(List<Map> AuthActions){
        List<Map<String,Object>> maps = new ArrayList<>();
        for (int i=0;i<AuthActions.size();i++){
            Map<String,Object> roleMenuAuthDTO = (Map<String, Object>) AuthActions.get(i);
            Integer menuId = Integer.valueOf(roleMenuAuthDTO.get("menuId").toString());
            Integer id = Integer.valueOf(roleMenuAuthDTO.get("authId").toString());
            Collection<Map<String,Object>> mapCollection = Collections2.filter(maps, r->r.get("menuId").equals(menuId));
            if (mapCollection.size()>0){
                List<Map<String,Object>> list = new ArrayList<>(mapCollection);
                Map<String,Object> map = list.get(0);
                List<Integer> actionList = (List<Integer>) map.get("actionList");
                actionList.add(id);
            }else{
                Map<String,Object> newMap = new HashMap<>();
                newMap.put("menuId",menuId);
                List<Integer> list = new ArrayList<>();
                list.add(id);
                newMap.put("actionList",list);
                maps.add(newMap);
            }
        }
        return maps;
    }

    public Map<String,Object> processRoleAuth(Map<String,Object> map){
        Map<String,Object> returnMap = new HashMap<>();
        List<OfficeMenuDTO> menus = (List<OfficeMenuDTO>) map.get("menuList");
        List<OfficeMenuVO> officeMenuVOList = GeneratorUtil.instance().convert(menus,OfficeMenuVO.class);
        List<MenuDTO> authMenus = (List<MenuDTO>) map.get("authMenuList");
        List<AuthorityDTO> actions = (List<AuthorityDTO>) map.get("actionList");
        List<Map> AuthActions = (List<Map>) map.get("authActionList");

        // 有权限的菜单ID列表
        List<Integer> menuIds = new ArrayList<>();
        for (MenuDTO menuDTO:authMenus){
            menuIds.add(menuDTO.getId());
        }

        //有权限的菜单操作权限
        List<Map<String,Object>> actionsList = this.processAuthActions(AuthActions);

        List<OfficeMenuVO> menusAuthList = new ArrayList<>();

        Collection<OfficeMenuVO> result = Collections2.filter(officeMenuVOList, x->x.getParentId().equals(0));
        List<OfficeMenuVO> officeMenuVOList1 = new ArrayList<>(result);
        menusAuthList.addAll(officeMenuVOList1);//root
        for (int i=0;i<menusAuthList.size();i++){
            OfficeMenuVO officeMenuVO = menusAuthList.get(i);
            Collection<AuthorityDTO> actionsAll = Collections2.filter(actions, x->x.getMenuId().equals(officeMenuVO.getId()));
            if (actionsAll.size()>0){
                List<AuthorityDTO> list = new ArrayList<>(actionsAll);
                List<Map> actionIdS = new ArrayList<>();
                for (AuthorityDTO authorityDTO:list){
                    Map<String,Object> map1 = new HashMap<>();
                    map1.put("label",authorityDTO.getDescribe());
                    map1.put("value",authorityDTO.getId());
                    actionIdS.add(map1);
                }
                officeMenuVO.setActionEntitySet(actionIdS);
            }

            Collection<Map<String,Object>> actionAuth = Collections2.filter(actionsList, x->x.get("menuId").equals(officeMenuVO.getId()));
            if (actionAuth.size()>0){
                List<Map<String,Object>> list = new ArrayList<>(actionAuth);
                officeMenuVO.setActionData((List<Integer>) list.get(0).get("actionList"));
            }
        }
        this.processMenuAuth(officeMenuVOList,actions,menusAuthList,actionsList);
        returnMap.put("menuInfo",menusAuthList);
        returnMap.put("AuthMenuInfo",menuIds);
        returnMap.put("AuthInfo",actionsList);
        return returnMap;
    }

    /**
     *
     * @param officeMenuVOList 所有菜单
     * @param actions 所有权限
     * @param menusAuthList 返回树结构
     * @param actionsList 已分配权限
     */
    private void processMenuAuth(List<OfficeMenuVO> officeMenuVOList,
                                 List<AuthorityDTO> actions,
                                 List<OfficeMenuVO> menusAuthList,
                                 List<Map<String,Object>> actionsList){
        for (int i=0;i<menusAuthList.size();i++){
            OfficeMenuVO officeMenuVO = menusAuthList.get(i);
            Integer parentId = officeMenuVO.getId();
            Collection<OfficeMenuVO> result = Collections2.filter(officeMenuVOList, x->x.getParentId().equals(parentId));
            if (result.size()>0){
                List<OfficeMenuVO> officeMenuVOList1 = new ArrayList<>(result);
                for (int j=0;j<officeMenuVOList1.size();j++){
                    OfficeMenuVO officeMenuVO1 = officeMenuVOList1.get(j);
                    Collection<AuthorityDTO> actionsAll = Collections2.filter(actions, x->x.getMenuId().equals(officeMenuVO1.getId()));
                    if (actionsAll.size()>0){
                        List<AuthorityDTO> list = new ArrayList<>(actionsAll);
                        List<Map> actionIdS = new ArrayList<>();
                        for (AuthorityDTO authorityDTO:list){
                            Map<String,Object> map1 = new HashMap<>();
                            map1.put("label",authorityDTO.getDescribe());
                            map1.put("value",authorityDTO.getId());
                            actionIdS.add(map1);
                        }
                        officeMenuVO1.setActionEntitySet(actionIdS);
                    }

                    Collection<Map<String,Object>> actionAuth = Collections2.filter(actionsList, x->x.get("menuId").equals(officeMenuVO1.getId()));
                    if (actionAuth.size()>0){
                        List<Map<String,Object>> list = new ArrayList<>(actionAuth);
                        officeMenuVO1.setActionData((List<Integer>) list.get(0).get("actionList"));
                    }
                }
                officeMenuVO.setChildren(officeMenuVOList1);
                this.processMenuAuth(officeMenuVOList, actions,officeMenuVOList1,actionsList);
            }
        }
    }
}
