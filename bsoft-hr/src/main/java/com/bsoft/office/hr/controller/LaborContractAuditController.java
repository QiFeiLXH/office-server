package com.bsoft.office.hr.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.manager.CompanyDicManager;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.common.vo.ActionRecordVO;
import com.bsoft.office.common.vo.CompanyDicVO;
import com.bsoft.office.common.vo.CustomerParamVO;
import com.bsoft.office.common.vo.TaskAuditVO;
import com.bsoft.office.hr.manager.LaborContractRenewalManager;
import com.bsoft.office.hr.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author zhanglf
 * @Date 2020-12-09 14:00
 * @Version 1.0
 */
@RestController
@RequestMapping("/laborcontractaudit")
public class LaborContractAuditController {
    private final static Logger LOGGER = LoggerFactory.getLogger(LaborContractAuditController.class);
    @Autowired
    private LaborContractRenewalManager laborContractRenewalManager;
    @Autowired
    private CompanyDicManager companyDicManager;

    /**
     * 劳动合同续签 获取待办列表
     */
    @RequestMapping(value = "/getlist",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询劳动合同续签待办列表")
    public OfficeResopnseBean getTaskList(@RequestBody TaskQueryCndVO data, HttpServletRequest request){
        LOGGER.info("获取劳动合同续签 待办列表[{}]", JSONUtils.toString(data));
        String personId = ContextUtils.getUserId(request);
        data.setPersonId(personId);//设置查询条件-待办人
        Result<LaborContractApplyViewVO> result = laborContractRenewalManager.getLaborContractAuditList(personId,data);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        return responseBean;
    }

    @RequestMapping(value = "/deptaudit",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.MODIFY,operDesc = "部门负责人审核")
    public OfficeResopnseBean deptAudit(@RequestBody LaborContractAuditVO data, HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        LaborContractApplyVO applyVO = data.getLaborContractApplyVO();
        TaskAuditVO auditVO = data.getTaskAuditVO();
        auditVO.setSystem(5);
        laborContractRenewalManager.deptAudit(personId,applyVO,auditVO);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        LOGGER.info("部门负责人审核");
        return responseBean;
    }

    @RequestMapping(value = "/areaaudit",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.MODIFY,operDesc = "大区行政总监审核")
    public OfficeResopnseBean areaAudit(@RequestBody LaborContractAuditVO data, HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        LaborContractApplyVO applyVO = data.getLaborContractApplyVO();
        TaskAuditVO auditVO = data.getTaskAuditVO();
        auditVO.setSystem(5);
        laborContractRenewalManager.areaAudit(personId,applyVO,auditVO);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        LOGGER.info("大区行政总监审核");
        return responseBean;
    }

    @RequestMapping(value = "/hraudit",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.MODIFY,operDesc = "人事专员审核")
    public OfficeResopnseBean hrAudit(@RequestBody LaborContractAuditVO data, HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        Integer flag = data.getFlag();
        LaborContractApplyVO applyVO = data.getLaborContractApplyVO();
        TaskAuditVO auditVO = data.getTaskAuditVO();
        auditVO.setSystem(5);
        laborContractRenewalManager.hrAudit(flag,personId,applyVO,auditVO);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        LOGGER.info("人事专员审核");
        return responseBean;
    }

    @RequestMapping(value = "/audit",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.MODIFY,operDesc = "劳动合同续签审核")
    public OfficeResopnseBean Audit(@RequestBody LaborContractAuditVO data, HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        LaborContractApplyVO applyVO = data.getLaborContractApplyVO();
        TaskAuditVO auditVO = data.getTaskAuditVO();
        auditVO.setSystem(5);
        if(applyVO.getTaskDefineKey().equals("usertask5")){ //部门负责人
            auditVO.setOpinion(applyVO.getDeptOpinion());
            laborContractRenewalManager.deptAudit(personId,applyVO,auditVO);
            LOGGER.info("部门负责人审核");
        }else if(applyVO.getTaskDefineKey().equals("usertask9")){//大区行政总监
            auditVO.setOpinion(applyVO.getRemark());
            laborContractRenewalManager.areaAudit(personId,applyVO,auditVO);
            LOGGER.info("大区行政总监审核");
        }else if(applyVO.getTaskDefineKey().equals("usertask11")){//人事专员1 有大区行政总监
            auditVO.setOpinion(applyVO.getHrOpinion());
            laborContractRenewalManager.hrAudit(1,personId,applyVO,auditVO);
            LOGGER.info("人事专员审核");
        }else if(applyVO.getTaskDefineKey().equals("usertask10")){//人事专员2 无大区行政总监
            auditVO.setOpinion(applyVO.getHrOpinion());
            laborContractRenewalManager.hrAudit(2,personId,applyVO,auditVO);
            LOGGER.info("人事专员审核");
        }

        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        return responseBean;
    }


    @RequestMapping(value = "/auditall",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.MODIFY,operDesc = "劳动合同续签批量审核")
    public OfficeResopnseBean AuditAll(@RequestBody List<LaborContractAuditVO> datas, HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        for(LaborContractAuditVO data : datas){
            LaborContractApplyVO applyVO = data.getLaborContractApplyVO();
            TaskAuditVO auditVO = data.getTaskAuditVO();
            auditVO.setSystem(5);
            if(applyVO.getNotifyFlag().equals(1)){

            }else{
                if(applyVO.getTaskDefineKey().equals("usertask5")){ //部门负责人
                    auditVO.setOpinion(applyVO.getDeptOpinion());
                    laborContractRenewalManager.deptAudit(personId,applyVO,auditVO);
                    LOGGER.info("部门负责人审核");
                }else if(applyVO.getTaskDefineKey().equals("usertask9")){//大区行政总监
                    auditVO.setOpinion(applyVO.getRemark());
                    laborContractRenewalManager.areaAudit(personId,applyVO,auditVO);
                    LOGGER.info("大区行政总监审核");
                }else if(applyVO.getTaskDefineKey().equals("usertask11")){//人事专员1 有大区行政总监
                    auditVO.setOpinion(applyVO.getHrOpinion());
                    laborContractRenewalManager.hrAudit(1,personId,applyVO,auditVO);
                    LOGGER.info("人事专员审核");
                }else if(applyVO.getTaskDefineKey().equals("usertask10")){//人事专员2 无大区行政总监
                    auditVO.setOpinion(applyVO.getHrOpinion());
                    laborContractRenewalManager.hrAudit(2,personId,applyVO,auditVO);
                    LOGGER.info("人事专员审核");
                }
            }
        }
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        return responseBean;
    }



    @RequestMapping(value = "/getdetail",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询对应任务节点详情，流程操作记录，自定义表单属性")
    public OfficeResopnseBean getDetailAndAuth(@RequestParam String taskId,@RequestParam String processInstanceId,@RequestParam Integer id, HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        List<CustomerParamVO> list = laborContractRenewalManager.getCustomParam(personId,taskId);
        List<ActionRecordVO> actionRecords = laborContractRenewalManager.getActionRecords(personId,processInstanceId);
        LaborContractApplyViewVO laborContractApplyView = laborContractRenewalManager.getLaborContractApplyView(personId,id);
        Map<String,Object> result = new HashMap<>();
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        result.put("auth",list);
        result.put("actionRecord",actionRecords);
        result.put("detail",laborContractApplyView);
        responseBean.setBody(result);
        LOGGER.info("获取对应任务节点详情，流程操作记录，自定义表单属性");
        return responseBean;
    }

    @GetMapping(value = "/getcompanydic")
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询社保缴纳单位")
    public OfficeResopnseBean getCompanyDic(@RequestParam Integer type){
        List<CompanyDicVO> vo = companyDicManager.getCompanyDic(type);
        return OfficeResopnseBean.newSuccessBean(vo);
    }

    @GetMapping(value = "/getquit")
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询离职单")
    public OfficeResopnseBean getQuitList(@RequestParam String personId){
        List<LaborContractQuitViewVO> vo = laborContractRenewalManager.getQuitList(personId);
        return OfficeResopnseBean.newSuccessBean(vo);
    }


    @GetMapping(value = "/completenotify")
    @OperLog(operType = OperLogType.MODIFY,operDesc = "完成知会任务")
    public OfficeResopnseBean completeNotify(@RequestParam String taskId, HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        laborContractRenewalManager.completeNotifyTask(personId, taskId);
        return OfficeResopnseBean.newSuccessBean();
    }
}
