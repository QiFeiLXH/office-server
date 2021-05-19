package com.bsoft.office.manager.controller;

import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.manager.manager.WorkFlowQueryManager;
import com.bsoft.office.manager.vo.BpmnModelVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/workflowquery")
public class WorkFlowQueryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(WorkFlowQueryController.class);
    @Autowired
    private WorkFlowQueryManager workFlowQueryManager;

    /**
     * 根据流程实例ID获取流程流转信息
     * @param processInstanceId
     * @param request
     * @return
     */
    @RequestMapping(value = "/getflowchart", method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询流程流转信息")
    public OfficeResopnseBean getProcessDeployList(@RequestParam String processInstanceId, HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        BpmnModelVO resultVO = workFlowQueryManager.getBpmnModelMessage(processInstanceId,personId);
        OfficeResopnseBean resopnseBean = OfficeResopnseBean.newSuccessBean();
        resopnseBean.setBody(resultVO);
        LOGGER.info("获取流程图信息成功");
        return resopnseBean;
    }
}
