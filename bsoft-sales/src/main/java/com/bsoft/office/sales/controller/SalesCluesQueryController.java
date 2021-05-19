package com.bsoft.office.sales.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.sales.manager.SalesCluesManager;
import com.bsoft.office.common.vo.ActionRecordVO;
import com.bsoft.office.sales.vo.SalesCluesTaskVO;
import com.bsoft.office.sales.vo.SalesCluesViewVO;
import com.bsoft.office.sales.vo.TaskQueryCndVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/salescluesquery")
public class SalesCluesQueryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SalesCluesQueryController.class);
    @Autowired
    private SalesCluesManager salesCluesManager;

    /**
     * 销售线索  获取待办列表
     */
    @RequestMapping(value = "/getlist",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询销售线索审核待办列表")
    public OfficeResopnseBean getTaskList(@RequestBody TaskQueryCndVO data, HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        Result<SalesCluesTaskVO> result = salesCluesManager.getTaskList(personId,data);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        LOGGER.info("获取消息线索审核 待办列表");
        return responseBean;
    }


    /**
     * 销售线索  获取基本信息以及审核流程操作信息
     */
    @RequestMapping(value = "/getclue",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询销售线索基本信息及审核流程操作信息")
    public OfficeResopnseBean getClue(@RequestParam Integer clueId, @RequestParam String processInstanceId, HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        SalesCluesViewVO clueInfo = salesCluesManager.getClue(personId,clueId);
        List<ActionRecordVO> actionRecords = salesCluesManager.getActionRecords(personId,processInstanceId);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        Map<String,Object> result = new HashMap<>();
        result.put("clueInfo",clueInfo);
        result.put("actionRecords",actionRecords);
        responseBean.setBody(result);
        LOGGER.info("获取销售线索基本信息以及审核流程操作信息");
        return responseBean;
    }
}
