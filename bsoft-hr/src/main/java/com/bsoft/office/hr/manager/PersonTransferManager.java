package com.bsoft.office.hr.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.vo.PublicDicVO;
import com.bsoft.office.hr.condition.PersonTransferConditionQueryCndVO;
import com.bsoft.office.hr.vo.PersonTransferConditionVO;
import com.bsoft.office.hr.vo.PersonTransferDicVO;
import com.bsoft.office.hr.vo.PersonTransferQueryCndVO;
import com.bsoft.office.hr.vo.PersonTransferVO;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/12/30 11:10
 * @Description:
 */
public interface PersonTransferManager {
    Result<PersonTransferVO> findPersonTransfer(PersonTransferQueryCndVO cndVO);

    PersonTransferDicVO getAllDic();

    void savePersonTransfer(List<PersonTransferVO> personTransferVOS, String personId);

    List<PublicDicVO> getPersonnelGroupDic(String deptId, Integer year);

    Result<PersonTransferConditionVO>  getPersonTransferCondition(PersonTransferConditionQueryCndVO cndVO);

    List<PersonTransferConditionVO>  getExcelPersonTransferCondition(PersonTransferConditionQueryCndVO cndVO);

}
