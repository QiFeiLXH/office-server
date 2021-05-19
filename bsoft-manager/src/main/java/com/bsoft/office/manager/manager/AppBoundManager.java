package com.bsoft.office.manager.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.manager.condition.UserBoundQueryCnd;
import com.bsoft.office.manager.vo.AppBoundVO;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/7/21 9:16
 * @Description: app已绑定manager
 */
public interface AppBoundManager {
    Result<AppBoundVO> getAppBoundList(UserBoundQueryCnd queryCnd);
    void batchUnBound(List<String> ids,String unbinder);
}
