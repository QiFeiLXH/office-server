package com.bsoft.office.organ.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.organ.vo.PersonFinancialViewVO;

import java.util.List;

public interface PersonFinancialViewManager {

    /**
     * 特殊人员财务类别查询
     * @param personFinancialViewVO
     * @return
     */
    Result<PersonFinancialViewVO> getPersonFinancialList (PersonFinancialViewVO personFinancialViewVO);

    /**
     * 特殊人员财务类别修改
     * 1.可修改调整后财务类别（未注销的）、调整年月
     * 2、保存时，增加一条人员的财务类别调整记录。
     * 3、可批量调整修改
     * @param personFinancialViewVOList
     */
    void updatePersonFinancial(String userId,List<PersonFinancialViewVO> personFinancialViewVOList);

}
