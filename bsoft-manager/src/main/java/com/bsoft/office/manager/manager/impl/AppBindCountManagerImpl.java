package com.bsoft.office.manager.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.dozer.GeneratorUtil;
import com.bsoft.office.manager.condition.AppBindCountQueryCnd;
import com.bsoft.office.manager.manager.AppBindCountManager;
import com.bsoft.office.manager.vo.AppBindCountVO;
import com.bsoft.user.dto.AppBindCountDTO;
import com.bsoft.user.dto.AppBindCountQueryCndDTO;
import com.bsoft.user.service.AppUserCountService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: zy
 * @date: 2020/10/23
 * @description APP用户绑定情况统计
 */
@Component
public class AppBindCountManagerImpl implements AppBindCountManager {
    @Reference
    private AppUserCountService appUserCountService;


    @Override
    public Integer getBindTotalCount(String userId) {
        return appUserCountService.getBindTotalCount(userId);
    }

    @Override
    public List<AppBindCountVO> getBindCountList(String userId, AppBindCountQueryCnd queryCnd) {
        AppBindCountQueryCndDTO queryCndDTO = GeneratorUtil.instance().convert(queryCnd, AppBindCountQueryCndDTO.class);
        List<AppBindCountDTO> resultDTO = appUserCountService.getBindCountList(userId, queryCndDTO);
        return GeneratorUtil.instance().convert(resultDTO, AppBindCountVO.class);
    }

    @Override
    public Result<AppBindCountVO> getBindCountListWithPage(String userId, AppBindCountQueryCnd queryCnd) {
        AppBindCountQueryCndDTO queryCndDTO = GeneratorUtil.instance().convert(queryCnd, AppBindCountQueryCndDTO.class);
        Result<AppBindCountDTO> resultDTO = appUserCountService.getBindCountListWithPage(userId, queryCndDTO);
        return GeneratorUtil.instance().convert(resultDTO, AppBindCountVO.class);
    }
}
