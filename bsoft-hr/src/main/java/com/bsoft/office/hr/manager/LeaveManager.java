package com.bsoft.office.hr.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.hr.condition.LeaveQueryCnd;
import com.bsoft.office.hr.vo.*;

/**
 * @Author Xuhui Lin
 * @Date 2020/8/17 14:59
 * @Description
 */
public interface LeaveManager {
    Result<WorkLeaveVacationVO> getWorkLeaveVacationList(LeaveQueryCnd cnd);

    Result<LeaveInfoVO> getLeaveList(Integer pageNo, Integer pageSize, String personId, Integer type, String year);

    Result<WorkVacationTotalVO> getWorkVacationTotalList(Integer pageNo, Integer pageSize, String personId, Integer type, String year);

    Result<PersonalWorkLeaveVacationVO> getPersonalVacationList(Integer pageNo, Integer pageSize, String userId, String year);

    Result<LeaveInfoVO> getPersonalVacationUsedList(Integer pageNo, Integer pageSize, String userId, String year, Integer type);

    Result<WorkVacationTotalVO> getPersonalTotalVacationList(Integer pageNo, Integer pageSize, String userId, String year, Integer type);
}
