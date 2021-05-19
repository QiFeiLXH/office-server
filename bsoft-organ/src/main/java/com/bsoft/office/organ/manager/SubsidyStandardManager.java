package com.bsoft.office.organ.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.organ.condition.SubsidyStandardQueryCnd;
import com.bsoft.office.organ.vo.SubsidyStandardViewVO;

/**
 * @Author: xucl
 * @DateTime: 2020/11/25 17:38
 * @Description:
 */
public interface SubsidyStandardManager {
    Result<SubsidyStandardViewVO> findSubsidyStandard(SubsidyStandardQueryCnd cnd);
    void saveSubsidyStandard(SubsidyStandardViewVO standardViewVO);
}
