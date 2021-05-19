package com.bsoft.office.hr.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.hr.condition.PersonToFormalQueryCnd;
import com.bsoft.office.hr.vo.PersonToFormalCountVO;
import com.bsoft.office.hr.vo.PersonToFormalVO;
import com.bsoft.office.hr.vo.PersonTurViewVO;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2021/2/1 8:51
 * @Description:
 */
public interface PersonToFormalManager {

    List<PersonToFormalCountVO> getMonthCount(Integer year);

    Result<PersonToFormalVO> getMonthPersonToFormalList(PersonToFormalQueryCnd cnd);

    PersonTurViewVO getPersonTur(Integer id);
}
