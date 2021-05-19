package com.bsoft.office.hr.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.hr.dto.WorkVacationDTO;
import com.bsoft.hr.dto.WorkVacationQueryCndDTO;
import com.bsoft.hr.dto.WorkVacationTotalViewDTO;
import com.bsoft.hr.service.WorkVacationService;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.hr.condition.WorkVacationQueryCnd;
import com.bsoft.office.hr.manager.WorkVacationManager;
import com.bsoft.office.hr.vo.WorkVacationVO;
import com.bsoft.office.hr.vo.WorkVacationTotalViewVO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: zy
 * @date: 2020/8/20
 * @description 员工加班调休假ManagerImpl
 */
@Component
public class WorkVacationManagerImpl implements WorkVacationManager {

    @Reference
    private WorkVacationService workVacationService;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public Result<WorkVacationTotalViewVO> getWorkVacationTotal(WorkVacationQueryCnd cnd) {
        WorkVacationQueryCndDTO cndDTO = iGenerator.convert(cnd, WorkVacationQueryCndDTO.class);
        Result<WorkVacationTotalViewDTO> result = workVacationService.getWorkVacationTotal(cndDTO);
        return iGenerator.convert(result, WorkVacationTotalViewVO.class);
    }

    @Override
    public Result<WorkVacationVO> getWorkVacationPersonal(WorkVacationQueryCnd cnd) {
        WorkVacationQueryCndDTO cndDTO = iGenerator.convert(cnd, WorkVacationQueryCndDTO.class);
        Result<WorkVacationDTO> result = workVacationService.getWorkVacationPersonal(cndDTO);
        return iGenerator.convert(result, WorkVacationVO.class);
    }
}
