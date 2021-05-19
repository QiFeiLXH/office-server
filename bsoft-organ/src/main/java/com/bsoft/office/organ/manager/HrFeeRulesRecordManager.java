package com.bsoft.office.organ.manager;

import com.bsoft.common.result.Result;
import com.bsoft.hr.dto.HrFeeRulesRecordCndDTO;
import com.bsoft.office.organ.vo.HrFeeRulesRecordVO;

public interface HrFeeRulesRecordManager {

    /**
     * 岗位费用部门列表查询
     * @param hrFeeRulesRecordCndDTO
     * @return
     */
    Result<HrFeeRulesRecordVO> getList (String userId, HrFeeRulesRecordCndDTO hrFeeRulesRecordCndDTO);


}
