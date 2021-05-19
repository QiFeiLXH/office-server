package com.bsoft.office.manager.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.manager.condition.UnbindQueryCnd;
import com.bsoft.office.manager.vo.UnbindViewVO;

/**
 * @Author: xucl
 * @DateTime: 2020/7/20 17:07
 * @Description: app解绑
 */
public interface AppUnbindManager {

    Result<UnbindViewVO> getUnbindList(UnbindQueryCnd queryCndVO);

    void auditUnbind(UnbindViewVO unbindViewVO,String userId);
}
