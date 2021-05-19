package com.bsoft.office.manager.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.manager.condition.UserBoundQueryCnd;
import com.bsoft.office.manager.manager.AppBoundManager;
import com.bsoft.office.manager.vo.AppBoundVO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/7/21 9:08
 * @Description: app已绑定
 */
@RestController
@RequestMapping(value = "/appbound")
public class AppBoundController {

    @Autowired
    private AppBoundManager appBoundManager;

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询App用户")
    public OfficeResopnseBean getBoundList(@RequestBody UserBoundQueryCnd queryCnd){
        Result<AppBoundVO> appBoundVOResult = appBoundManager.getAppBoundList(queryCnd);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(appBoundVOResult);
        return bean;
    }

    @RequestMapping(value = "/batchUnbound",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.MODIFY,operDesc = "批量解绑App用户")
    public OfficeResopnseBean batchUnbound(@RequestBody List<String> ids, HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        appBoundManager.batchUnBound(ids,personId);
        return OfficeResopnseBean.newSuccessBean();
    }
}
