package com.bsoft.office.work.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.dozer.GeneratorUtil;
import com.bsoft.office.work.condition.MeetQueryCnd;
import com.bsoft.office.work.manager.MeetManager;
import com.bsoft.office.work.vo.MeetVO;
import com.bsoft.office.work.vo.MeetViewVO;
import com.bsoft.work.dto.MeetDTO;
import com.bsoft.work.dto.MeetQueryCndDTO;
import com.bsoft.work.dto.MeetViewDTO;
import com.bsoft.work.service.MeetService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

/**
 * @Author zhanglf
 * @Date 2020-12-21 15:33
 * @Version 1.0
 */
@Component
public class MeetManagerImpl implements MeetManager {
    @Reference
    private MeetService meetService;

    @Override
    public void saveMeet(String personId, MeetVO meetVO) {
        MeetDTO meetDTO = GeneratorUtil.instance().convert(meetVO,MeetDTO.class);
        meetService.saveMeet(personId,meetDTO);
    }

    @Override
    public Result<MeetViewVO> getMeetList(String personId, MeetQueryCnd cnd) {
        MeetQueryCndDTO cndDTO = GeneratorUtil.instance().convert(cnd,MeetQueryCndDTO.class);
        Result<MeetViewDTO> result = meetService.getMeetList(personId,cndDTO);
        return GeneratorUtil.instance().convert(result,MeetViewVO.class);
    }

    @Override
    public void grantProve(String personId, Integer id) {
        meetService.grantProve(personId,id);
    }
}
