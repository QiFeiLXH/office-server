package com.bsoft.office.manager.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.dozer.GeneratorUtil;
import com.bsoft.office.manager.condition.UserBoundQueryCnd;
import com.bsoft.office.manager.manager.AppBoundManager;
import com.bsoft.office.manager.vo.AppBoundVO;
import com.bsoft.user.dto.AppBoundDTO;
import com.bsoft.user.dto.UserBoundQueryCndDTO;
import com.bsoft.user.service.AppTokenService;
import com.bsoft.user.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/7/21 9:38
 * @Description: app已绑定用户
 */
@Component
public class AppBoundManagerImpl implements AppBoundManager {
    @Autowired
    private GeneratorUtil generatorUtil;
    @Reference
    private UserService userService;
    @Reference
    private AppTokenService appTokenService;

    @Override
    public Result<AppBoundVO> getAppBoundList(UserBoundQueryCnd queryCnd) {
        UserBoundQueryCndDTO queryCndDTO = generatorUtil.convert(queryCnd,UserBoundQueryCndDTO.class);
        Result<AppBoundDTO> appBoundDTOResult = userService.getAppBindList(queryCndDTO);
        Result<AppBoundVO> appBoundVOResult = generatorUtil.convert(appBoundDTOResult,AppBoundVO.class);
        return appBoundVOResult;
    }

    @Override
    public void batchUnBound(List<String> ids,String unbinder) {
        userService.batchUnBound(ids,unbinder);
        for (String id:ids){
            appTokenService.removeToken(id);
        }
    }

}
