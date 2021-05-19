package com.bsoft.office.hr.controller;

import com.bsoft.common.result.Result;
import com.bsoft.hr.dto.WorkVacationDTO;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.common.vo.HumanDicVO;
import com.bsoft.office.hr.condition.WorkVacationQueryCnd;
import com.bsoft.office.hr.manager.AnnualVacationManager;
import com.bsoft.office.hr.vo.AnnualVacationInfoVO;
import com.bsoft.office.hr.vo.WorkVacationVO;
import com.bsoft.person.dto.HumanDicDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: zy
 * @date: 2020/8/26
 * @description
 */
@RestController
@RequestMapping("/vacation/annual")
public class AnnualVacationController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AnnualVacationController.class);
    @Autowired
    private AnnualVacationManager annualVacationManager;

    @GetMapping("/query")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取年假信息")
    public OfficeResopnseBean getAnnualVacationInfo(WorkVacationQueryCnd cnd, HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("获取年假信息[{}][{}]", userId, JSONUtils.toString(cnd));
        Result<AnnualVacationInfoVO> result = annualVacationManager.getAnnualVacationInfo(userId, cnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        return responseBean;
    }

    @PostMapping("/add")
    @OperLog(operType = OperLogType.SAVE,operDesc = "新增年假信息")
    public OfficeResopnseBean updateAnnualVacation(@RequestBody WorkVacationVO workVacationVO, HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("新增年假信息[{}][{}]", userId, JSONUtils.toString(workVacationVO));
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setMsg("新增成功");
        try {
            annualVacationManager.addAnnualVacation(userId, workVacationVO);
        } catch(Exception e) {
            e.printStackTrace();
            responseBean.setCode(500);
            responseBean.setMsg("新增失败");
        }
        return responseBean;
    }

    @PostMapping("/update")
    @OperLog(operType = OperLogType.SAVE,operDesc = "修改年假信息")
    public OfficeResopnseBean addAnnualVacation(@RequestBody WorkVacationVO workVacationVO, HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("修改年假信息[{}][{}]", userId, JSONUtils.toString(workVacationVO));
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setMsg("修改成功");
        try {
            annualVacationManager.updateAnnualVacation(userId, workVacationVO);
        } catch(Exception e) {
            e.printStackTrace();
            responseBean.setCode(500);
            responseBean.setMsg("修改失败");
        }
        return responseBean;
    }

}
