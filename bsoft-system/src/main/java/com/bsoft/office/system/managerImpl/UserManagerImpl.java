package com.bsoft.office.system.managerImpl;

import com.bsoft.auth.service.AuthService;
import com.bsoft.menu.dto.MenuAndAuthDTO;
import com.bsoft.menu.dto.MenuDTO;
import com.bsoft.menu.service.MenuService;
import com.bsoft.office.common.dozer.GeneratorUtil;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.sort.ListBeanSort;
import com.bsoft.office.system.manager.UserManager;
import com.bsoft.office.system.vo.MenuAndAuthVO;
import com.bsoft.office.system.vo.MenuVO;
import com.bsoft.office.system.vo.PersonVO;
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
public class UserManagerImpl implements UserManager {

    private static final Logger logger = LoggerFactory.getLogger(UserManagerImpl.class);

    @Reference
    private PersonService personService;
//    @Reference
//    private AuthService authService;
    @Reference
    private MenuService menuService;
    @Autowired
    GeneratorUtil generatorUtil;
    @Override
    public PersonVO getUserInfo(String userId) {
        PersonDTO personDTO = personService.getPerson(userId);
        PersonVO personVO = generatorUtil.convert(personDTO,PersonVO.class);
        logger.info("获取员工[{}]，基本信息成功[{}]",userId, JSONUtils.toString(personVO));
        return personVO;
    }

//    @Override
//    public List<Map> getUserAuthInfo(String userId) {
//        List<Map> roleMenuAuthDTOList = authService.getOfficeAuth(userId);
//        List<Map> list = this.processRoles(roleMenuAuthDTOList);
//        logger.info("获取员工[{}]权限信息...[{}]",userId,JSONUtils.toString(list));
//        return list;
//    }

//    @Override
//    public List<Map> getUserAuthInfoBySystem(String userId, Integer system) {
//        List<Map> roleMenuAuthDTOList = authService.getOfficeAuthBySystem(userId,system);
//        List<Map> list = this.processRoles(roleMenuAuthDTOList);
//        return roleMenuAuthDTOList;
//    }

//    @Override
//    public List<MenuVO> getCurrentUserNav(String userId) {
//        List<MenuDTO> menuDTOList = menuService.getOfficeAuthMenu(userId);
//        List<MenuVO> menuVOList = new ArrayList<>();
//        for (MenuDTO officeMenuDTO : menuDTOList){
//            MenuVO menuVO = new MenuVO();
//            menuVO.setId(officeMenuDTO.getId());
//            menuVO.setParentId(officeMenuDTO.getParentId());
//            menuVO.setName(officeMenuDTO.getPermisionid());
//            menuVO.setTitle(officeMenuDTO.getName());
//            menuVO.setIcon(officeMenuDTO.getIcon());
//            menuVO.setPath(officeMenuDTO.getObject());
//            menuVO.setComponent(officeMenuDTO.getComponent());
//            menuVO.setSort(officeMenuDTO.getSort());
//            menuVOList.add(menuVO);
//        }
//        ListBeanSort.sort(menuVOList,"sort",true);
//        logger.info("获取员工[{}],菜单导航信息[{}]",userId,JSONUtils.toString(menuVOList));
//        return menuVOList;
//    }

    @Override
    public List<MenuAndAuthVO> getCurrentUserNavBySystem(String userId, Integer System) {
        List<MenuAndAuthDTO> menuAndAuthDTOs = menuService.getOfficeAuthMenuList(userId, System);
        List<MenuAndAuthVO> menuAndAuths = generatorUtil.convert(menuAndAuthDTOs, MenuAndAuthVO.class);
        ListBeanSort.sort(menuAndAuths,"sort",true);
        return menuAndAuths;
    }

    /**
     * 格式化权限信息
     * [{
     *   'roleId': 'admin',
     *   'permissionId': 'user',
     *   'permissionName': '用户管理',
     *   'actionEntitySet': [{
     *      'action': 'add',
     *      'describe': '新增',
     *      'defaultCheck': false
     *      }]
     * }]
     * @param roleMenuAuthDTOList
     * @return
     */
//    private List<Map> processRoles(List<Map> roleMenuAuthDTOList){
//        List<Map> list = new ArrayList<>();
//        for (int i=0;i<roleMenuAuthDTOList.size();i++){
//            String roleId = (String) roleMenuAuthDTOList.get(i).get("roleId");
//            String permissionId = (String) roleMenuAuthDTOList.get(i).get("permisionid");
//            String action = (String) roleMenuAuthDTOList.get(i).get("action");
//            Collection<Map> result = Collections2.filter(list, x->x.get("roleId").equals(roleId) && x.get("permissionId").equals(permissionId));
//            if (result.size() <= 0){
//                Map<String,Object> map = new HashMap<>();
//                map.put("roleId",roleId);
//                map.put("permissionId",permissionId);
//                Map<String,Object> actionMap = new HashMap<>();
//                actionMap.put("action",action);
//                List<Map> actionList = new ArrayList<>();
//                actionList.add(actionMap);
//                map.put("actionEntitySet",actionList);
//                list.add(map);
//            } else {
//                Map<String,Object> actionMap = new HashMap<>();
//                actionMap.put("action",action);
//                List<Map> actionList = (List<Map>) new ArrayList<>(result).get(0).get("actionEntitySet");
//                actionList.add(actionMap);
//            }
//        }
//        return list;
//    }
}
