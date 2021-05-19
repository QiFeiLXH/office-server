package com.bsoft.office.hr.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.hr.manager.LeaveManager;
import com.bsoft.office.hr.vo.LeaveInfoVO;
import com.bsoft.office.hr.vo.PersonalWorkLeaveVacationVO;
import com.bsoft.office.hr.vo.WorkVacationTotalVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


/**
 * @Author Xuhui Lin
 * @Date 2020/8/19 11:27
 * @Description 个人请假
 */
@RestController
@RequestMapping("/personalleave")
public class PersonalLeaveController {
    private final static Logger LOGGER = LoggerFactory.getLogger(PersonalLeaveController.class);
    @Autowired
    private LeaveManager leaveManager;

    @GetMapping("/personalquery")
    @OperLog(operType = OperLogType.QUERY,operDesc = "个人假期记录")
    public OfficeResopnseBean getPersonalVacationList(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize,@RequestParam("year") String year,HttpServletRequest request){
        String userId = ContextUtils.getUserId(request);
        Result<PersonalWorkLeaveVacationVO> result = leaveManager.getPersonalVacationList(pageNo, pageSize,userId,year);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        LOGGER.info("获取个人假期记录列表！[{}]", JSONUtils.toString(result));
        return responseBean;
    }

    @GetMapping("/personaltotal")
    @OperLog(operType = OperLogType.QUERY,operDesc = "个人假期总天数记录")
    public OfficeResopnseBean getPersonalTotalVacationList(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize,@RequestParam("year") String year,@RequestParam("type") Integer type,HttpServletRequest request){
        String userId = ContextUtils.getUserId(request);
        Result<WorkVacationTotalVO> result = leaveManager.getPersonalTotalVacationList(pageNo, pageSize,userId,year,type);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        LOGGER.info("获取个人假期总天数记录列表！[{}]", JSONUtils.toString(result));
        return responseBean;
    }

    @GetMapping("/personalused")
    @OperLog(operType = OperLogType.QUERY,operDesc = "个人请假记录")
    public OfficeResopnseBean getPersonalVacationUsedList(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize,@RequestParam("year") String year,@RequestParam("type") Integer type,HttpServletRequest request){
        String userId = ContextUtils.getUserId(request);
        Result<LeaveInfoVO> result = leaveManager.getPersonalVacationUsedList(pageNo, pageSize,userId,year,type);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        LOGGER.info("获取个人请假记录列表！[{}]", JSONUtils.toString(result));
        return responseBean;
    }
}
