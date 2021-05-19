package com.bsoft.office.manager.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.manager.condition.UnbindQueryCnd;
import com.bsoft.office.manager.manager.AppUnbindManager;
import com.bsoft.office.manager.vo.UnbindViewVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: xucl
 * @DateTime: 2020/7/20 17:01
 * @Description: App解绑
 */
@RestController
@RequestMapping(value = "/appunbind")
public class AppUnbindController {

    @Autowired
    private AppUnbindManager appUnbindManager;

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询app解绑申请列表")
    public OfficeResopnseBean getAppUnbindList(@RequestBody UnbindQueryCnd cndVO){
        Result<UnbindViewVO> unbindViewVOResult = appUnbindManager.getUnbindList(cndVO);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(unbindViewVOResult);
        return bean;
    }

    @RequestMapping(value = "/audit",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.MODIFY,operDesc = "审核app解绑申请")
    public OfficeResopnseBean auditUnbind(@RequestBody UnbindViewVO unbindViewVO, HttpServletRequest request){
        String userId = ContextUtils.getUserId(request);
        appUnbindManager.auditUnbind(unbindViewVO,userId);
        return OfficeResopnseBean.newSuccessBean();
    }
}
