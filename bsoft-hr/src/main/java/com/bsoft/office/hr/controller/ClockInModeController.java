package com.bsoft.office.hr.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.hr.condition.ClockInModeQueryCnd;
import com.bsoft.office.hr.manager.ClockInModeManager;
import com.bsoft.office.hr.vo.ClockInModeDeptInfoVO;
import com.bsoft.office.hr.vo.ClockInModePersonalInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: zy
 * @date: 2020/8/28
 * @description 打卡方式维护
 */
@RestController
@RequestMapping("/vacation/clockin")
public class ClockInModeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClockInModeController.class);
    @Autowired
    private ClockInModeManager clockInModeManager;

    @GetMapping("/deptquery")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取部门考勤方式信息")
    public OfficeResopnseBean listDeptInfo(ClockInModeQueryCnd cnd, HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("[{}]获取部门考勤方式信息[{}]", userId, JSONUtils.toString(cnd));
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        Result<ClockInModeDeptInfoVO> result = clockInModeManager.listDeptInfo(userId, cnd);
        responseBean.setBody(result);
        return responseBean;
    }

    @GetMapping("/personalquery")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取个人打卡方式信息")
    public OfficeResopnseBean listPersonalInfo(ClockInModeQueryCnd cnd, HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("[{}]获取个人打卡方式信息[{}]", userId, JSONUtils.toString(cnd));
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        Result<ClockInModePersonalInfoVO> result = clockInModeManager.listPersonalInfo(userId, cnd);
        responseBean.setBody(result);
        return responseBean;
    }

    @PostMapping("/deptset")
    @OperLog(operType = OperLogType.SAVE,operDesc = "设置部门考勤方式")
    public OfficeResopnseBean setDept(@RequestBody List<ClockInModeDeptInfoVO> deptInfoVOList, HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("[{}]设置部门考勤方式[{}]", userId, JSONUtils.toString(deptInfoVOList));
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        try {
            clockInModeManager.setDept(userId, deptInfoVOList);
            responseBean.setMsg("修改成功！");
        } catch (Exception e) {
            e.printStackTrace();
            responseBean.setCode(500);
            responseBean.setMsg("修改失败！");
        }
        return responseBean;
    }

    @PostMapping("/personalset")
    @OperLog(operType = OperLogType.SAVE,operDesc = "设置部门考勤方式")
    public OfficeResopnseBean setPersonal(@RequestBody List<ClockInModePersonalInfoVO> personalInfoVOList, HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("[{}]设置部门考勤方式[{}]", userId, JSONUtils.toString(personalInfoVOList));
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        try {
            clockInModeManager.setPersonal(userId, personalInfoVOList);
            responseBean.setMsg("修改成功！");
        } catch (Exception e) {
            e.printStackTrace();
            responseBean.setCode(500);
            responseBean.setMsg("修改失败！");
        }
        return responseBean;
    }
}
