package com.bsoft.office.hr.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.common.vo.PublicDicVO;
import com.bsoft.office.hr.manager.PersonTransferManager;
import com.bsoft.office.hr.vo.PersonTransferDicVO;
import com.bsoft.office.hr.vo.PersonTransferQueryCndVO;
import com.bsoft.office.hr.vo.PersonTransferVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/12/30 11:09
 * @Description: 人员调动 Controller
 */
@RestController
@RequestMapping("transfer")
public class PersonTransferController {

    @Autowired
    private PersonTransferManager personTransferManager;

    /**
     * 分页查询人员驻地、部门等信息
     * @param cndVO
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询人员驻地、部门等信息")
    public OfficeResopnseBean findPersonTransfer(@RequestBody PersonTransferQueryCndVO cndVO){
        Result<PersonTransferVO> result = personTransferManager.findPersonTransfer(cndVO);
        return OfficeResopnseBean.newSuccessBean(result);
    }

    @RequestMapping(value = "/getdic",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询岗位、职务、归属群、补贴等字典信息")
    public OfficeResopnseBean getDic(){
        PersonTransferDicVO personTransferDicVO = personTransferManager.getAllDic();
        return OfficeResopnseBean.newSuccessBean(personTransferDicVO);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.ADD,operDesc = "新增调动人员信息")
    public OfficeResopnseBean savePersonTransfer(@RequestBody List<PersonTransferVO> personTransferVOS, HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        personTransferManager.savePersonTransfer(personTransferVOS,personId);
        return OfficeResopnseBean.newSuccessBean();
    }

    @GetMapping(value = "/getPersonnelGroupDic")
    @OperLog(operType = OperLogType.QUERY,operDesc = "根据部门、年份获取人员归属群")
    public OfficeResopnseBean getPersonnelGroupDic(@RequestParam String deptId,@RequestParam Integer year){
        List<PublicDicVO> list = personTransferManager.getPersonnelGroupDic(deptId,year);
        return OfficeResopnseBean.newSuccessBean(list);
    }

}
