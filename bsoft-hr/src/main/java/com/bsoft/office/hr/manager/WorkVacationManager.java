package com.bsoft.office.hr.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.hr.condition.WorkVacationQueryCnd;
import com.bsoft.office.hr.vo.WorkVacationVO;
import com.bsoft.office.hr.vo.WorkVacationTotalViewVO;

/**
 * @author: zy
 * @date: 2020/8/20
 * @description 员工加班调休假Manager
 */
public interface WorkVacationManager {
    Result<WorkVacationTotalViewVO> getWorkVacationTotal(WorkVacationQueryCnd cnd);
    Result<WorkVacationVO> getWorkVacationPersonal(WorkVacationQueryCnd cnd);
}
