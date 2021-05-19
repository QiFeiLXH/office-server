package com.bsoft.office.manager.manager.impl;

import com.bsoft.common.dto.PublicDicDTO;
import com.bsoft.common.result.Result;
import com.bsoft.common.service.PublicDicService;
import com.bsoft.office.common.dozer.GeneratorUtil;
import com.bsoft.office.common.vo.PublicDicVO;
import com.bsoft.office.manager.condition.AppBindCountQueryCnd;
import com.bsoft.office.manager.condition.AppDeptCountQueryCnd;
import com.bsoft.office.manager.manager.AppUserCountManager;
import com.bsoft.office.manager.vo.*;
import com.bsoft.user.dto.*;
import com.bsoft.user.service.AppUserCountService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: zy
 * @date: 2020/10/19
 * @description APP用户分布情况分析
 */
@Component
public class AppUserCountManagerImpl implements AppUserCountManager {

    private static final Integer PUB_DIC_TYPE_DEPT = 3008;
    @Reference
    private AppUserCountService appUserCountService;
    @Reference
    private PublicDicService publicDicService;

    @Override
    public Result<AppDeptCountVO> getDeptCountList(String userId, AppDeptCountQueryCnd queryCnd){
        AppDeptCountQueryCndDTO queryCndDTO = GeneratorUtil.instance().convert(queryCnd, AppDeptCountQueryCndDTO.class);
        Result<AppDeptCountDTO> resultDTO = appUserCountService.getDeptCountList(userId, queryCndDTO);
        return GeneratorUtil.instance().convert(resultDTO, AppDeptCountVO.class);
    }

    @Override
    public List<PublicDicVO> getDeptTypeList(){
        List<PublicDicDTO> typeDTOList = publicDicService.getPublicDic(PUB_DIC_TYPE_DEPT);
        return GeneratorUtil.instance().convert(typeDTOList, PublicDicVO.class);
    }

    @Override
    public List<AppProvinceCountVO> getProvinceCountList(String userId) {
        List<AppProvinceCountDTO> resultDTO = appUserCountService.getProvinceCountList(userId);
        return GeneratorUtil.instance().convert(resultDTO, AppProvinceCountVO.class);
    }

    @Override
    public List<AppTerminalCountVO> getTerminalCountList(String userId) {
        List<AppTerminalCountDTO> resultDTO = appUserCountService.getTerminalCountList(userId);
        return GeneratorUtil.instance().convert(resultDTO, AppTerminalCountVO.class);
    }

    @Override
    public AppBoundProportionVO getBoundProportion(String userId, AppDeptCountQueryCnd queryCnd) {
        AppDeptCountQueryCndDTO queryCndDTO = GeneratorUtil.instance().convert(queryCnd, AppDeptCountQueryCndDTO.class);
        AppBoundProportionDTO dto = appUserCountService.getBoundProportion(userId,queryCndDTO);
        return GeneratorUtil.instance().convert(dto, AppBoundProportionVO.class);
    }

}
