package com.bsoft.office.manager.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.manager.condition.OperLogQueryCnd;
import com.bsoft.office.manager.vo.OperLogVO;

/**
 * @Author: xucl
 * @DateTime: 2021/2/7 9:29
 * @Description:
 */
public interface OperLogManager {
    Result<OperLogVO> findList(String userId, OperLogQueryCnd cnd);
}
