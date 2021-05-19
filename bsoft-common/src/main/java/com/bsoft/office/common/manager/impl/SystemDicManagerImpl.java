package com.bsoft.office.common.manager.impl;

import com.bsoft.common.dto.SystemDicDTO;
import com.bsoft.common.dto.SystemDicSelectQueryCndDTO;
import com.bsoft.common.service.SystemDicService;
import com.bsoft.office.common.condition.SystemDicSelectQueryCnd;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.common.manager.SystemDicManager;
import com.bsoft.office.common.vo.SystemDicVO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @version 1.0
 * @author: zy
 * @date: 2021/2/5
 * @description
 */
@Component
public class SystemDicManagerImpl implements SystemDicManager {
    @Reference
    private SystemDicService systemDicService;
    @Autowired
    private IGenerator iGenerator;
    @Override
    public List<SystemDicVO> getSystemDicSelectList(SystemDicSelectQueryCnd queryCnd) {
        SystemDicSelectQueryCndDTO queryCndDTO = iGenerator.convert(queryCnd, SystemDicSelectQueryCndDTO.class);
        List<SystemDicDTO> list = systemDicService.getSystemDicSelectList(queryCndDTO);
        return iGenerator.convert(list, SystemDicVO.class);
    }
}
