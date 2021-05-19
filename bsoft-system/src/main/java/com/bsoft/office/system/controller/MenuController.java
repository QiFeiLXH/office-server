package com.bsoft.office.system.controller;

import com.bsoft.office.common.dozer.GeneratorUtil;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.system.manager.MenuManager;
import com.bsoft.office.system.vo.MenuSaveVO;
import com.bsoft.office.system.vo.OfficeMenuVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * 菜单设置
 */

@RestController
@RequestMapping(value = "/menu")
public class MenuController {
    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);

    @Autowired
    MenuManager menuManager;

    @Autowired
    GeneratorUtil generatorUtil;
    /**
     * 获取系统菜单列表
     * @param request
     * @param response
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public OfficeResopnseBean getSystemMenuList(@RequestParam(value = "system",required = true) Integer system,
                                                HttpServletRequest request,
                                                HttpServletResponse response){
        List<OfficeMenuVO> officeMenuVOList = menuManager.getMenuList(system);
        logger.info("菜单设置获取系统[{}],菜单列表成功！",system);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(officeMenuVOList);
        return bean;
    }

    /**
     * 根据菜单Id获取菜单详细信息
     * @param menuId 菜单ID
     * @return
     */
    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public OfficeResopnseBean OfficeMenuInfo(@RequestParam(value = "menuId",required = true) Integer menuId){
        OfficeMenuVO officeMenuVO = menuManager.getMenuInfo(menuId);
        logger.info("获取菜单ID=[{}]的详细菜单信息成功！",menuId);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(officeMenuVO);
        return bean;
    }

    /**
     * 更新菜单信息
     * @param menuSaveVO
     * @param request
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public OfficeResopnseBean saveMenuInfo (@RequestBody MenuSaveVO menuSaveVO, HttpServletRequest request) {
        Integer menuId = menuManager.saveOfficeMenuInfo(menuSaveVO.getOfficeMenuVO(),menuSaveVO.getAuthorityVOList());
        OfficeResopnseBean bean = null;
        if(menuId!=null){
            logger.info("更新菜单id=[{}]信息成功!",menuSaveVO.getOfficeMenuVO().getId());
            bean = OfficeResopnseBean.newSuccessBean();
            bean.setBody(menuId);
        }else{
            logger.info("更新菜单id=[{}]信息失败!",menuSaveVO.getOfficeMenuVO().getId());
            bean = OfficeResopnseBean.newFailBean(500,"更新菜单信息失败!");
        }
        return bean;
    }

    /**
     * 禁用菜单
     * @param menuId
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public OfficeResopnseBean deleteMenu(@RequestParam(value = "menuId",required = true) Integer menuId,
                                         @RequestParam(value = "flag",required = true) String flag){
        boolean status = menuManager.deleteMenu(menuId,flag);
        OfficeResopnseBean bean = null;
        if (status){
            logger.info("禁用菜单ID=[{}]菜单!  成功!",menuId);
            bean = OfficeResopnseBean.newSuccessBean();
        }else{
            logger.info("禁用菜单ID=[{}]菜单!  失败!",menuId);
            bean = OfficeResopnseBean.newFailBean(500,"禁用菜单信息失败!");
        }
        return bean;
    }

}
