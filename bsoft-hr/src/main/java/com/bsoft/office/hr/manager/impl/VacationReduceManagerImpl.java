package com.bsoft.office.hr.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.hr.dto.VacationReduceDTO;
import com.bsoft.hr.dto.VacationReduceQueryCndDTO;
import com.bsoft.hr.service.VacationReduceService;
import com.bsoft.office.common.dozer.GeneratorUtil;
import com.bsoft.office.hr.condition.VacationReduceQueryCnd;
import com.bsoft.office.hr.manager.VacationReduceManager;
import com.bsoft.office.hr.vo.VacationReduceVO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

@Component
public class VacationReduceManagerImpl implements VacationReduceManager {
    @Reference
    private VacationReduceService vacationReduceService;

    @Override
    public Result<VacationReduceVO> getVacationReduceList(String personId, VacationReduceQueryCnd cnd) {
        VacationReduceQueryCndDTO queryCnd = GeneratorUtil.instance().convert(cnd,VacationReduceQueryCndDTO.class);
        Result<VacationReduceDTO> result = vacationReduceService.getVacationReduceList(personId,queryCnd);
        return GeneratorUtil.instance().convert(result,VacationReduceVO.class);
    }

    @Override
    public void save(String personId, VacationReduceVO vacationReduce) {
        VacationReduceDTO dto = GeneratorUtil.instance().convert(vacationReduce,VacationReduceDTO.class);
        vacationReduceService.save(personId,dto);
    }

    @Override
    public void delete(String personId, VacationReduceVO vacationReduce) {
        VacationReduceDTO dto = GeneratorUtil.instance().convert(vacationReduce,VacationReduceDTO.class);
        vacationReduceService.delete(personId,dto);
    }

    @Override
    public void reduceAnnualVacationUnified(String personId, String year, Integer days, Integer reduceId) {
        vacationReduceService.reduceAnnualVacationUnified(personId, year, days, reduceId);
    }
}
