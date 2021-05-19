package com.bsoft.office.manager.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.manager.condition.AppBindCountQueryCnd;
import com.bsoft.office.manager.vo.AppBindCountVO;

import java.util.List;

/**
 * @author: zy
 * @date: 2020/10/23
 * @description App用户绑定情况统计
 */
public interface AppBindCountManager {
    Integer getBindTotalCount(String userId);
    List<AppBindCountVO> getBindCountList(String userId, AppBindCountQueryCnd queryCnd);
    Result<AppBindCountVO> getBindCountListWithPage(String userId, AppBindCountQueryCnd queryCnd);
}
