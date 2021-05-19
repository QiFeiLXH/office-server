package com.bsoft.office.system.manager;

import com.bsoft.office.system.vo.MenuAndAuthVO;
import com.bsoft.office.system.vo.MenuVO;
import com.bsoft.office.system.vo.PersonVO;

import java.util.List;
import java.util.Map;

public interface UserManager {

    /**
     * 获取用户的基本信息
     * @param userId 工号
     * @return
     */
    PersonVO getUserInfo(String userId);

    /**
     * 获取office系统(system = 2) 用户的菜单按钮权限信息
     * @param userId 工号
     * @return
     */
//    List<Map> getUserAuthInfo(String userId);

    /**
     * 获取不同系统用户的菜单按钮权限信息
     * @param userId 工号
     * @param system 2 office,3 administration
     * @return
     */
//    List<Map> getUserAuthInfoBySystem(String userId,Integer system);

    /**
     * 获取office系统(system = 2)用户的菜单信息
     * @param userId 工号
     * @return
     */
//    List<MenuVO> getCurrentUserNav(String userId);

    /**
     * 获取不同系统用户的菜单信息
     * @param userId 工号
     * @param system 2 office,3 administration
     * @return
     */
    List<MenuAndAuthVO> getCurrentUserNavBySystem(String userId, Integer system);
}
