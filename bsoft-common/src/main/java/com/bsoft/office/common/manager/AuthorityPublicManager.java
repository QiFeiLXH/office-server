package com.bsoft.office.common.manager;

/**
 * @Author Xuhui Lin
 * @Date 2020/10/22 14:50
 * @Description
 */
public interface AuthorityPublicManager {
    /** 检查判断是否拥有全部权限
     * @Param: personId 员工工号
     * @Param: menuId 菜单id
     * @Param: key 全部权限编号
     * @return boolean true 有全部权限  false 无全部权限
     * @author Xuhui Lin
     */
    boolean checkAllPermission(String personId, Integer menuId, Integer key);
}
