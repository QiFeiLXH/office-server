package com.bsoft.office.common.manager;

import com.bsoft.office.common.vo.MenuVO;

/**
 * @Author Xuhui Lin
 * @Date 2020/10/22 16:48
 * @Description
 */
public interface MenuPublicManager {

    /** 检查判断是否拥有全部权限
     * @Param: menuId 菜单id
     * @return MenuVO
     * @author Xuhui Lin
     */
    MenuVO getMenuInfo(Integer menuId);

    /** 检查判断员工是否拥有非公用菜单权限
     * @Param: personId 员工工号
     * @Param: menuId 菜单id
     * @return boolean true 有权限  false 无权限
     * @author Xuhui Lin
     */
    boolean checkPrivateMenuPermission(String personId, Integer menuId);
}
