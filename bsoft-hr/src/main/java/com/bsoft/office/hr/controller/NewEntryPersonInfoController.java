package com.bsoft.office.hr.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.annotation.RequiredExportLog;
import com.bsoft.office.common.condition.ExportLogParams;
import com.bsoft.office.common.exportExcel.ExportExcel;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.hr.condition.NewEntryPersonInfoQueryCnd;
import com.bsoft.office.hr.manager.NewEntryPersonInfoManager;
import com.bsoft.office.hr.vo.NewEntryPersonInfoVO;
import com.bsoft.office.hr.vo.PersonCompanyVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/newperson")
public class NewEntryPersonInfoController {
    private static final Logger LOGGER = LoggerFactory.getLogger(NewEntryPersonInfoController.class);

    @Autowired
    private NewEntryPersonInfoManager newEntryPersonInfoManager;

    @GetMapping("/query")
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询每月入职员工信息")
    public OfficeResopnseBean getPersonInfos(NewEntryPersonInfoQueryCnd cnd, HttpServletRequest request) {
        String personId = ContextUtils.getUserId(request);
        Result<NewEntryPersonInfoVO> result =  newEntryPersonInfoManager.getPersonInfoList(personId,cnd);
        LOGGER.info("获取每月入职员工信息条件[{}]", cnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        return responseBean;
    }

    @GetMapping("/updatesalary")
    @OperLog(operType = OperLogType.MODIFY,operDesc = "修改薪资")
    public OfficeResopnseBean updateSalary(String updatePersonId,Double probationSalary,Double regularSalary,Double paymentBase,Integer place, HttpServletRequest request) {
        String personId = ContextUtils.getUserId(request);
        newEntryPersonInfoManager.updateSalary(personId,updatePersonId,probationSalary,regularSalary,paymentBase,place);
        return  OfficeResopnseBean.newSuccessBean();
    }

    @GetMapping("/getcompany")
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询所属公司")
    public OfficeResopnseBean getAllCompany(HttpServletRequest request) {
        String personId = ContextUtils.getUserId(request);
        List<PersonCompanyVO> list = newEntryPersonInfoManager.getAllCompany(personId);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(list);
        return  responseBean;
    }


    @GetMapping(value = "/exportdownload")
    @RequiredExportLog
    @OperLog(operType = OperLogType.EXPORT,operDesc = "导出每月入职员工信息")
    public void exportPersonInfos(ExportLogParams params, NewEntryPersonInfoQueryCnd cnd, HttpServletRequest request, HttpServletResponse response) {
        String personId = ContextUtils.getUserId(request);
        List<NewEntryPersonInfoVO> list = newEntryPersonInfoManager.getAllPersonInfoList(personId,cnd);
        ExportExcel.export(list, NewEntryPersonInfoVO.class,"每月新入职员工信息",response);
    }


}
