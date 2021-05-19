package com.bsoft.office.manager.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.common.service.ServerDateService;
import com.bsoft.office.common.dozer.GeneratorUtil;
import com.bsoft.office.manager.condition.UnbindQueryCnd;
import com.bsoft.office.manager.manager.AppUnbindManager;
import com.bsoft.office.manager.vo.UnbindViewVO;
import com.bsoft.user.dto.UnbindDTO;
import com.bsoft.user.dto.UnbindQueryCndDTO;
import com.bsoft.user.dto.UnbindViewDTO;
import com.bsoft.user.service.AppTokenService;
import com.bsoft.user.service.UnbindService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: xucl
 * @DateTime: 2020/7/20 17:08
 * @Description: app解绑
 */
@Component
public class AppUnbindManagerImpl implements AppUnbindManager {

    @Reference
    private UnbindService unbindService;
    @Reference
    private ServerDateService serverDateService;
    @Reference
    private AppTokenService appTokenService;
    @Autowired
    private GeneratorUtil generatorUtil;

    @Override
    public Result<UnbindViewVO> getUnbindList(UnbindQueryCnd queryCndVO) {
        UnbindQueryCndDTO queryCndDTO = generatorUtil.convert(queryCndVO,UnbindQueryCndDTO.class);
        Result<UnbindViewDTO> unbindViewDTOResult = unbindService.getUnbindList(queryCndDTO);
        Result<UnbindViewVO> unbindViewVOResult = generatorUtil.convert(unbindViewDTOResult,UnbindViewVO.class);
        return unbindViewVOResult;
    }

    @Override
    public void auditUnbind(UnbindViewVO unbindViewVO,String userId) {
        UnbindDTO unbindDTO = generatorUtil.convert(unbindViewVO,UnbindDTO.class);
        unbindDTO.setAuditter(userId);
        unbindDTO.setAuditDate(serverDateService.getServerDateTime());
        unbindService.auditUnbind(unbindDTO);
        if (unbindDTO.getAuditflag() == 1){//同意解绑，清空token缓存
            appTokenService.removeToken(unbindViewVO.getPersonId());
        }
    }
}
