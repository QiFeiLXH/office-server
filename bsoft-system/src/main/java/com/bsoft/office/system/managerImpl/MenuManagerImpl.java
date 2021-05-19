package com.bsoft.office.system.managerImpl;

import com.bsoft.auth.dto.AuthorityDTO;
import com.bsoft.menu.dto.MenuDTO;
import com.bsoft.menu.dto.OfficeMenuDTO;
import com.bsoft.menu.service.MenuService;
import com.bsoft.office.common.dozer.GeneratorUtil;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.system.manager.MenuManager;
import com.bsoft.office.system.vo.AuthorityVO;
import com.bsoft.office.system.vo.OfficeMenuVO;
import com.google.common.collect.Collections2;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class MenuManagerImpl implements MenuManager {
    private static final Logger logger = LoggerFactory.getLogger(MenuManagerImpl.class);

    @Reference
    private MenuService menuService;

    @Autowired
    GeneratorUtil generatorUtil;

    @Override
    public List<OfficeMenuVO> getMenuList(Integer system) {
        List<MenuDTO> menuDTO = menuService.getOfficeAllMenuBySystem(system);
        List<OfficeMenuVO> officeMenuVOS = new ArrayList<>();
        for (int i=0;i<menuDTO.size();i++){
            MenuDTO menu = menuDTO.get(i);
            OfficeMenuVO officeMenuVO = new OfficeMenuVO();
            officeMenuVO.setId(menu.getId());
            officeMenuVO.setParentId(menu.getParentId());
            officeMenuVO.setIcon(menu.getIcon());
            officeMenuVO.setComponent(menu.getComponent());
            officeMenuVO.setName(menu.getPermisionid());
            officeMenuVO.setPath(menu.getObject());
            officeMenuVO.setRoutetitle(menu.getName());
            officeMenuVO.setSort(menu.getSort());
            officeMenuVO.setPubFlag(menu.getPubFlag());
            officeMenuVO.setSystem(menu.getSystem());
            officeMenuVO.setActive(menu.getActive());
            officeMenuVOS.add(officeMenuVO);
        }
        List<OfficeMenuVO> officeMenuVOList = new ArrayList<>();
        Collection<OfficeMenuVO> result = Collections2.filter(officeMenuVOS, x->x.getParentId().equals(0));
        List<OfficeMenuVO> officeMenuVOList1 = new ArrayList<>(result);
        officeMenuVOList.addAll(officeMenuVOList1);//root
        this.processMenu(officeMenuVOS,officeMenuVOList);
        logger.info("菜单设置时，获取系统菜单:[{}]", JSONUtils.toString(officeMenuVOList));
        return officeMenuVOList;
    }

    @Override
    public OfficeMenuVO getMenuInfo(Integer menuId) {
        OfficeMenuDTO officeMenuDTO = menuService.getOfficeMenuInfo(menuId);
        OfficeMenuVO officeMenuVO = new OfficeMenuVO();
        officeMenuVO.setId(officeMenuDTO.getId());
        officeMenuVO.setParentId(officeMenuDTO.getParentId());
        officeMenuVO.setIcon(officeMenuDTO.getIcon());
        officeMenuVO.setComponent(officeMenuDTO.getComponent());
        officeMenuVO.setName(officeMenuDTO.getName());
        officeMenuVO.setPath(officeMenuDTO.getPath());
        officeMenuVO.setRoutetitle(officeMenuDTO.getRoutetitle());
        officeMenuVO.setSort(officeMenuDTO.getSort());
        officeMenuVO.setPubFlag(officeMenuDTO.getPubFlag());
        officeMenuVO.setSystem(officeMenuDTO.getSystem());
        officeMenuVO.setActive(officeMenuDTO.getActive());
        officeMenuVO.setActionEntitySet(officeMenuDTO.getActionEntitySet());
        logger.info("菜单ID=[{}]的详细菜单信息[{}]",menuId,JSONUtils.toString(officeMenuVO));
        return officeMenuVO;
    }

    @Override
    public Integer saveOfficeMenuInfo(OfficeMenuVO officeMenuVO, List<AuthorityVO> authorityVOS) {
        Integer menuId = null;
        officeMenuVO.setActionData(null);
        officeMenuVO.setActionEntitySet(null);
        OfficeMenuDTO officeMenuDTO = generatorUtil.convert(officeMenuVO,OfficeMenuDTO.class);
        List<AuthorityDTO> authorityDTOS = generatorUtil.convert(authorityVOS,AuthorityDTO.class);
        logger.info("更新菜单id=[{}]信息,菜单信息[{}],权限信息[{}]!",JSONUtils.toString(officeMenuVO),JSONUtils.toString(authorityVOS));
        menuId = menuService.saveOfficeMenuInfo(officeMenuDTO,authorityDTOS);
        return menuId;
    }

    @Override
    public boolean deleteMenu(Integer menuId,String flag) {
        boolean status = false;
        logger.info("禁用菜单ID=[{}]菜单[{}]!",menuId,flag);
        status = menuService.deleteOfficeMenu(menuId,flag);
        return status;
    }

    /**
     * 格式化树形菜单结构
     * @param menus
     * @param parentOfficeMenuVOList
     */
    private void processMenu(List<OfficeMenuVO> menus,List<OfficeMenuVO> parentOfficeMenuVOList){
        for (int j = 0;j<parentOfficeMenuVOList.size();j++){

            Integer parentId = parentOfficeMenuVOList.get(j).getId();
            Collection<OfficeMenuVO> result = Collections2.filter(menus, x->x.getParentId().equals(parentId));
            if (result.size()>0){
                List<OfficeMenuVO> officeMenuVOList1 = new ArrayList<>(result);
                parentOfficeMenuVOList.get(j).setChildren(officeMenuVOList1);
                this.processMenu(menus,officeMenuVOList1);
            }
        }
    }
}
