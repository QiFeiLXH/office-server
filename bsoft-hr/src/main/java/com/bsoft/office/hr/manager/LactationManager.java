package com.bsoft.office.hr.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.hr.condition.LactationQueryCnd;
import com.bsoft.office.hr.vo.LactationVO;
import com.bsoft.office.hr.vo.LactationViewVO;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/5 10:55
 * @Description
 */
public interface LactationManager {
    Result<LactationViewVO> getLactationList(LactationQueryCnd queryCnd);

    Integer saveLactation(LactationVO lactation);
}
