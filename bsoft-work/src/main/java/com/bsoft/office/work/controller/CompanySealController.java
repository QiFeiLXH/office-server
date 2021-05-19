package com.bsoft.office.work.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.work.manager.CompanySealManager;
import com.bsoft.office.work.vo.CompanySealVO;
import com.bsoft.work.dto.CompanySealDTO;
import com.bsoft.work.dto.CompanySealQueryCnd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/companyseal")
public class CompanySealController {
    @Autowired
    private CompanySealManager companySealManager;


    @GetMapping(value = "/getcompanyseals")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取公司印章列表")
    public OfficeResopnseBean getCompanyseals(CompanySealQueryCnd cnd){
        Result<CompanySealVO> companySealList = companySealManager.getCompanySealList(cnd);
        return OfficeResopnseBean.newSuccessBean(companySealList);
    }

    @GetMapping(value = "/getseal")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取公司印章信息")
    public OfficeResopnseBean getSeal(Integer id){
        CompanySealVO seal = companySealManager.getCompanySeal(id);
        return OfficeResopnseBean.newSuccessBean(seal);
    }

    @GetMapping(value = "/getcompany")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取所有未注销公司信息")
    public OfficeResopnseBean getCompany(String input){
        return OfficeResopnseBean.newSuccessBean(companySealManager.getCompanyNoCancel(input));
    }

    @PostMapping(value = "/savecompanyseal")
    @OperLog(operType = OperLogType.SAVE,operDesc = "保存公司印章信息")
    public OfficeResopnseBean  saveCompanyseals(@RequestBody CompanySealDTO companySealDTO){
        companySealManager.saveCompanySeal(companySealDTO);
        return OfficeResopnseBean.newSuccessBean("保存成功");
    }

}
