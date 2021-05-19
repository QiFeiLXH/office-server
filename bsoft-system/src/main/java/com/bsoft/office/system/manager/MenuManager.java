package com.bsoft.office.system.manager;

import com.bsoft.office.system.vo.AuthorityVO;
import com.bsoft.office.system.vo.OfficeMenuVO;

import java.util.List;

public interface MenuManager {
    /**
     * 获取不同系统的菜单信息
     * @param system
     * @return
     */
    public List<OfficeMenuVO> getMenuList(Integer system);

    public OfficeMenuVO getMenuInfo(Integer menuId);

    public Integer saveOfficeMenuInfo(OfficeMenuVO officeMenuVO, List<AuthorityVO> authorityVOS);

    /**
     *
     * @param menuId
     * @param flag ‘stop’ 禁用，‘delete’ 删除
     * @return
     */
    public boolean deleteMenu(Integer menuId,String flag);
}
