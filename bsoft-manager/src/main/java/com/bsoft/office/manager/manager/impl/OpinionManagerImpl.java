package com.bsoft.office.manager.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.common.service.ServerDateService;
import com.bsoft.office.common.dozer.GeneratorUtil;
import com.bsoft.office.manager.condition.OpinionQueryCnd;
import com.bsoft.office.manager.manager.OpinionManager;
import com.bsoft.office.manager.vo.OpinionVO;
import com.bsoft.opinion.dto.OpinionDTO;
import com.bsoft.opinion.dto.OpinionQueryCndDTO;
import com.bsoft.opinion.service.OpinionService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/8/5 15:28
 * @Description: 意见ManagerImpl
 */
@Component
public class OpinionManagerImpl implements OpinionManager {
    @Reference
    private OpinionService opinionService;
    @Autowired
    private GeneratorUtil generatorUtil;
    @Reference
    private ServerDateService serverDateService;
    @Override
    public Result<OpinionVO> getOpinions(OpinionQueryCnd cnd) {
        OpinionQueryCndDTO cndDTO = generatorUtil.convert(cnd,OpinionQueryCndDTO.class);
//        cndDTO.setSystem(1);
        Result<OpinionDTO> result = opinionService.getOpinions(cndDTO);
        return generatorUtil.convert(result,OpinionVO.class);
    }

    @Override
    public OpinionVO getOpinionsById(Integer id) {
        OpinionDTO opinionDTO =  opinionService.getOpinionById(id);
        return generatorUtil.convert(opinionDTO,OpinionVO.class);
    }

    @Override
    public void auditOpinion(OpinionVO opinionVO) {
        OpinionDTO opinionDTO = generatorUtil.convert(opinionVO,OpinionDTO.class);
        opinionDTO.setFeedbackDate(serverDateService.getServerDateTime());
        opinionService.saveOpinion(opinionDTO);
    }

    @Override
    public List<OpinionVO> findAllOpinion(OpinionQueryCnd cnd) {
        OpinionQueryCndDTO cndDTO = generatorUtil.convert(cnd,OpinionQueryCndDTO.class);
        List<OpinionDTO> list = opinionService.findAllOpinion(cndDTO);
        return generatorUtil.convert(list,OpinionVO.class);
    }
}
