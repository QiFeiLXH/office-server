package com.bsoft.office.hr.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.hr.condition.LeaveQueryCnd;
import com.bsoft.office.hr.manager.LeaveManager;
import com.bsoft.office.hr.vo.LeaveInfoVO;
import com.bsoft.office.hr.vo.WorkLeaveVacationVO;
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
 * @Description
 */
@RestController
@RequestMapping("/leave")
public class LeaveController {
    private final static Logger LOGGER = LoggerFactory.getLogger(LeaveController.class);
    @Autowired
    private LeaveManager leaveManager;

    @GetMapping("/query")
    @OperLog(operType = OperLogType.QUERY,operDesc = "员工假期记录")
    public OfficeResopnseBean getWorkLeaveVacationList(LeaveQueryCnd cnd, HttpServletRequest request){
        String userId = ContextUtils.getUserId(request);
        cnd.setPersonId(userId);
        Result<WorkLeaveVacationVO> result = leaveManager.getWorkLeaveVacationList(cnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        LOGGER.info("获取员工假期记录列表！[{}]", JSONUtils.toString(result));
        return responseBean;
    }

    @GetMapping("/infoquery")
    @OperLog(operType = OperLogType.QUERY,operDesc = "年休、调休已使用记录")
    public OfficeResopnseBean getLeaveList(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize, @RequestParam("type") Integer type, @RequestParam("year") String year, @RequestParam("personId")String personId){
        Result<LeaveInfoVO> result = leaveManager.getLeaveList(pageNo, pageSize, personId, type, year);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        LOGGER.info("获取年休、调休已使用列表列表！[{}]", JSONUtils.toString(result));
        return responseBean;
    }


    @GetMapping("/totalquery")
    @OperLog(operType = OperLogType.QUERY,operDesc = "年休、调休总列表")
    public OfficeResopnseBean getWorkVacationTotalList(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize, @RequestParam("type") Integer type, @RequestParam("year") String year, @RequestParam("personId")String personId){
        Result<WorkVacationTotalVO> result = leaveManager.getWorkVacationTotalList(pageNo, pageSize, personId, type,year);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        LOGGER.info("获取年休、调休总列表列表！[{}]", JSONUtils.toString(result));
        return responseBean;
    }

}
