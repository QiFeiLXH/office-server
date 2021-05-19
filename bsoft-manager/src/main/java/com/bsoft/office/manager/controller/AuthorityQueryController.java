package com.bsoft.office.manager.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.manager.PublicDicManager;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.vo.PublicDicVO;
import com.bsoft.office.manager.condition.AuthorityQueryCnd;
import com.bsoft.office.manager.manager.AuthManager;
import com.bsoft.office.manager.manager.MenuAuthManager;
import com.bsoft.office.manager.vo.AuthorityPersonVO;
import com.bsoft.office.manager.vo.MenuAndAuthVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/10/19 17:34
 * @Description
 */
@RestController
@RequestMapping("/authorityquery")
public class AuthorityQueryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorityQueryController.class);
    @Autowired
    private MenuAuthManager menuAuthManager;
    @Autowired
    private PublicDicManager publicDicManager;
    @Autowired
    private AuthManager authManager;

    /**
     * 查询系统字典
     */
    @GetMapping("/systemdic")
    @OperLog(operType = OperLogType.QUERY,operDesc = "系统字典")
    public OfficeResopnseBean getPersonalAuthorityDepts(){
        List<PublicDicVO> dics = publicDicManager.getPublicDicsWithFlag(9908, 1);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(dics);
        LOGGER.info("获取系统字典成功： {}", JSONUtils.toString(dics));
        return responseBean;
    }


    /**
     * 查询系统菜单
     */
    @GetMapping("/menu")
    @OperLog(operType = OperLogType.QUERY,operDesc = "系统菜单")
    public OfficeResopnseBean getSystemicMenus(Integer system){
        List<MenuAndAuthVO> menus = menuAuthManager.getMenuInfo(system);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(menus);
        LOGGER.info("获取系统菜单成功： {}", JSONUtils.toString(menus));
        return responseBean;
    }

    /**
     * 查询指定权限的人员列表
     */
    @PostMapping("/authorityperson")
    @OperLog(operType = OperLogType.QUERY,operDesc = "指定权限的人员列表")
    public OfficeResopnseBean getPermissionalPersonList(@RequestBody List<AuthorityQueryCnd> menuAuths,
                                                        @RequestParam Integer pageSize,
                                                        @RequestParam Integer pageNo){
        Result<AuthorityPersonVO> persons = authManager.getPermissionalPersonList(menuAuths, pageNo, pageSize);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(persons);
        LOGGER.info("获取指定权限的人员列表成功： {}", JSONUtils.toString(persons));
        return responseBean;
    }


}
