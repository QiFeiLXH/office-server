package com.bsoft.office.hr.manager;

import com.bsoft.common.result.Result;
import com.bsoft.hr.dto.WorkVacationDTO;
import com.bsoft.office.hr.condition.WorkVacationQueryCnd;
import com.bsoft.office.hr.vo.AnnualVacationInfoVO;
import com.bsoft.office.hr.vo.WorkVacationVO;

/**
 * @author: zy
 * @date: 2020/8/26
 * @description
 */
public interface AnnualVacationManager {
    Result<AnnualVacationInfoVO> getAnnualVacationInfo(String userId, WorkVacationQueryCnd cnd);
    void addAnnualVacation(String userId, WorkVacationVO workVacationVO);
    void updateAnnualVacation(String userId, WorkVacationVO workVacationVO);
}
