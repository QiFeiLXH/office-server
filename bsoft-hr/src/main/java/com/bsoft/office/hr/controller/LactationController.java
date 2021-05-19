package com.bsoft.office.hr.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.hr.condition.LactationQueryCnd;
import com.bsoft.office.hr.manager.LactationManager;
import com.bsoft.office.hr.vo.LactationVO;
import com.bsoft.office.hr.vo.LactationViewVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/5 10:56
 * @Description
 */
@RestController
@RequestMapping("/lactation")
public class LactationController {
    @Autowired
    private LactationManager lactationManager;

    @GetMapping("/list")
    @OperLog(operType = OperLogType.QUERY,operDesc = "公司股份列表")
    public OfficeResopnseBean getLactationList(LactationQueryCnd queryCnd) {
        if (queryCnd.getStatus() == null) {
            queryCnd.setStatus(new ArrayList<>());
        }
        Result<LactationViewVO> result = lactationManager.getLactationList(queryCnd);
        return OfficeResopnseBean.newSuccessBean(result);
    }

    @PostMapping("/save")
    @OperLog(operType = OperLogType.MODIFY,operDesc = "公司股份保存")
    public OfficeResopnseBean saveLactation(@RequestBody LactationVO lactation, HttpServletRequest request) {
        if (lactation.getId() == null) {
            String personId = ContextUtils.getUserId(request);
            lactation.setSubmitter(personId);
        }
        Integer id = lactationManager.saveLactation(lactation);
        return OfficeResopnseBean.newSuccessBean(id);
    }
}
