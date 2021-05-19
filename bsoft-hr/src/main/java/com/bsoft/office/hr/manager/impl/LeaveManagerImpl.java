package com.bsoft.office.hr.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.hr.dto.*;
import com.bsoft.hr.service.LeaveService;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.hr.condition.LeaveQueryCnd;
import com.bsoft.office.hr.manager.LeaveManager;
import com.bsoft.office.hr.vo.*;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Xuhui Lin
 * @Date 2020/8/17 14:59
 * @Description
 */
@Service
public class LeaveManagerImpl implements LeaveManager {
    @Reference
    private LeaveService leaveService;
    @Autowired
    private IGenerator iGenerator;
    @Override
    public Result<WorkLeaveVacationVO> getWorkLeaveVacationList(LeaveQueryCnd cnd) {
        LeaveQueryCndDTO cndDTO = iGenerator.convert(cnd, LeaveQueryCndDTO.class);
        Result<WorkLeaveVacationDTO> result = leaveService.getWorkLeaveVacationList(cndDTO);
        return iGenerator.convert(result, WorkLeaveVacationVO.class);
    }

    @Override
    public Result<LeaveInfoVO> getLeaveList(Integer pageNo, Integer pageSize, String personId, Integer type, String year) {
        Result<LeaveInfoDTO> result = leaveService.getLeaveList(pageNo, pageSize, personId, type, year);
        return iGenerator.convert(result, LeaveInfoVO.class);
    }

    @Override
    public Result<WorkVacationTotalVO> getWorkVacationTotalList(Integer pageNo, Integer pageSize, String personId, Integer type, String year) {
        Result<WorkVacationTotalDTO> result = leaveService.getWorkVacationTotalList(pageNo, pageSize, personId, type, year);
        return iGenerator.convert(result, WorkVacationTotalVO.class);
    }

    @Override
    public Result<PersonalWorkLeaveVacationVO> getPersonalVacationList(Integer pageNo, Integer pageSize, String userId, String year) {
        Result<PersonalWorkLeaveVacationDTO> result = leaveService.getPersonalVacationList(pageNo, pageSize, userId, year);
        return iGenerator.convert(result, PersonalWorkLeaveVacationVO.class);
    }

    @Override
    public Result<LeaveInfoVO> getPersonalVacationUsedList(Integer pageNo, Integer pageSize, String userId, String year, Integer type) {
        Result<LeaveInfoDTO> result = leaveService.getPersonalVacationUsedList(pageNo, pageSize, userId, year, type);
        return iGenerator.convert(result,LeaveInfoVO.class);
    }

    @Override
    public Result<WorkVacationTotalVO> getPersonalTotalVacationList(Integer pageNo, Integer pageSize, String userId, String year, Integer type) {
        Result<WorkVacationTotalDTO> result = leaveService.getPersonalTotalVacationList(pageNo, pageSize, userId, year, type);
        return iGenerator.convert(result, WorkVacationTotalVO.class);
    }
}
