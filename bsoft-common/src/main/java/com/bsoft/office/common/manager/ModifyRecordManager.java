package com.bsoft.office.common.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.condition.ModifyRecordQueryCnd;
import com.bsoft.office.common.vo.ModifyRecordViewVO;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/11 9:35
 * @Description
 */
public interface ModifyRecordManager {
    Result<ModifyRecordViewVO> getModifyRecordList(ModifyRecordQueryCnd cnd);
}
