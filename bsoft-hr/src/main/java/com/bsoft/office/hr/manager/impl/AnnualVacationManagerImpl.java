package com.bsoft.office.hr.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.hr.dto.AnnualVacationInfoDTO;
import com.bsoft.hr.dto.WorkVacationDTO;
import com.bsoft.hr.dto.WorkVacationQueryCndDTO;
import com.bsoft.hr.service.AnnualVacationService;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.hr.condition.WorkVacationQueryCnd;
import com.bsoft.office.hr.manager.AnnualVacationManager;
import com.bsoft.office.hr.vo.AnnualVacationInfoVO;
import com.bsoft.office.hr.vo.WorkVacationVO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: zy
 * @date: 2020/8/26
 * @description
 */
@Component
public class AnnualVacationManagerImpl implements AnnualVacationManager {
    @Reference(timeout = 60000)
    private AnnualVacationService annualVacationService;

    @Autowired
    private IGenerator iGenerator;


    @Override
    public Result<AnnualVacationInfoVO> getAnnualVacationInfo(String userId, WorkVacationQueryCnd cnd) {
        WorkVacationQueryCndDTO cndDTO = iGenerator.convert(cnd, WorkVacationQueryCndDTO.class);
        Result<AnnualVacationInfoDTO> result = annualVacationService.getAnnualVacationInfo(userId, cndDTO);
        return iGenerator.convert(result, AnnualVacationInfoVO.class);
    }

    @Override
    public void addAnnualVacation(String userId, WorkVacationVO workVacationVO) {
        WorkVacationDTO workVacationDTO = iGenerator.convert(workVacationVO, WorkVacationDTO.class);
         annualVacationService.addAnnualVacation(userId, workVacationDTO);
    }

    @Override
    public void updateAnnualVacation(String userId, WorkVacationVO workVacationVO) {
        WorkVacationDTO workVacationDTO = iGenerator.convert(workVacationVO, WorkVacationDTO.class);
        annualVacationService.updateAnnualVacation(userId, workVacationDTO);
    }

}
