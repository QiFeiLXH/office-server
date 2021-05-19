package com.bsoft.office.manager.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.vo.PublicDicVO;
import com.bsoft.office.manager.condition.AppDeptCountQueryCnd;
import com.bsoft.office.manager.vo.AppBoundProportionVO;
import com.bsoft.office.manager.vo.AppDeptCountVO;
import com.bsoft.office.manager.vo.AppProvinceCountVO;
import com.bsoft.office.manager.vo.AppTerminalCountVO;

import java.util.List;

/**
 * @author: zy
 * @date: 2020/10/19
 * @description APP用户分布情况分析
 */
public interface AppUserCountManager {
    Result<AppDeptCountVO> getDeptCountList(String userId, AppDeptCountQueryCnd queryCnd);
    List<PublicDicVO> getDeptTypeList();
    List<AppProvinceCountVO> getProvinceCountList(String userId);
    List<AppTerminalCountVO> getTerminalCountList(String userId);
    AppBoundProportionVO getBoundProportion(String userId, AppDeptCountQueryCnd queryCnd);
}
