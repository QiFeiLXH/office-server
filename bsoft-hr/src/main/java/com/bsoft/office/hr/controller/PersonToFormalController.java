package com.bsoft.office.hr.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.hr.condition.PersonToFormalQueryCnd;
import com.bsoft.office.hr.manager.PersonToFormalManager;
import com.bsoft.office.hr.vo.PersonToFormalCountVO;
import com.bsoft.office.hr.vo.PersonToFormalVO;
import com.bsoft.office.hr.vo.PersonTurViewVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2021/2/1 8:48
 * @Description: 员工转正管理
 */
@RestController
@RequestMapping("/toformal")
public class PersonToFormalController {

    @Autowired
    private PersonToFormalManager personToFormalManager;

    @RequestMapping(value = "/count",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "按月统计人数")
    public OfficeResopnseBean getMonthList(@RequestParam("year") Integer year){
        List<PersonToFormalCountVO> countVOS = personToFormalManager.getMonthCount(year);
        return OfficeResopnseBean.newSuccessBean(countVOS);
    }

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.QUERY,operDesc = "月份需转正人员列表")
    public OfficeResopnseBean getMonthDetailList(@RequestBody PersonToFormalQueryCnd cnd){
        Result<PersonToFormalVO> result = personToFormalManager.getMonthPersonToFormalList(cnd);
        return OfficeResopnseBean.newSuccessBean(result);
    }

    @RequestMapping(value = "/turinfo",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "员工转正申请详情")
    public OfficeResopnseBean getPersonTur(@RequestParam("turId") Integer turId){
        PersonTurViewVO personTurViewVO = personToFormalManager.getPersonTur(turId);
        return OfficeResopnseBean.newSuccessBean(personTurViewVO);
    }
}
