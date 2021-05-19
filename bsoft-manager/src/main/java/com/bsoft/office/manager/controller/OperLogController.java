package com.bsoft.office.manager.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.manager.condition.OperLogQueryCnd;
import com.bsoft.office.manager.manager.OperLogManager;
import com.bsoft.office.manager.vo.OperLogVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author: xucl
 * @DateTime: 2021/2/7 9:26
 * @Description: 人员操作记录
 */
@RestController
@RequestMapping(value = "/operlog")
public class OperLogController {

    @Autowired
    private OperLogManager operLogManager;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询操作日志列表")
    public OfficeResopnseBean getList(OperLogQueryCnd cnd, HttpServletRequest request){
        String userId = ContextUtils.getUserId(request);
        Result<OperLogVO> result = operLogManager.findList(userId,cnd);
        return OfficeResopnseBean.newSuccessBean(result);
    }
}
