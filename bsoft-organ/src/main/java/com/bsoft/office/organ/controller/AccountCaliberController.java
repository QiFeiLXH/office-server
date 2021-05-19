package com.bsoft.office.organ.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.organ.manager.AccountCaliberManager;
import com.bsoft.office.organ.vo.AccountCaliberVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/4 11:22
 * @Description
 */
@RestController
@RequestMapping("/accountcaliber")
public class AccountCaliberController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountCaliberController.class);

    @Autowired
    private AccountCaliberManager accountCaliberManager;

    @RequestMapping(value = "/query",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "部门核算口径归属列表")
    public OfficeResopnseBean getDpetAccountCaliberList(@RequestParam("pageSize") Integer pageSize,
                                                   @RequestParam("pageNo") Integer pageNo,
                                                   @RequestParam(value = "year") Integer year,
                                                   @RequestParam(value = "deptId",required = false) String deptId,
                                                   @RequestParam(value = "deptType",required = false) Integer deptType,
                                                   @RequestParam(value = "accountCaliber",required = false) Integer accountCaliber){
        if (accountCaliber == null) {
            accountCaliber = 0;
        }
        if (deptType == null) {
            deptType = 0;
        }
        Result<AccountCaliberVO> result = accountCaliberManager.getDpetAccountCaliberList(pageSize,pageNo,year,deptId,deptType,accountCaliber);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        LOGGER.info("获取部门核算口径归属列表成功！",result);
        return responseBean;
    }

    @RequestMapping(value = "/dic",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "核算口径归属字典列表")
    public OfficeResopnseBean getAccountCaliberDic(){
        Map<String, Object> dics = accountCaliberManager.getAccountCaliberDic();
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(dics);
        LOGGER.info("获取核算口径归属字典列表成功！",dics);
        return responseBean;
    }

    @RequestMapping(value = "/createdept",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.OTHER,operDesc = "生成年度核算口径部门")
    public OfficeResopnseBean saveYearlyDeptAccountCaliber(@RequestParam(value = "year") Integer year){
        accountCaliberManager.saveYearlyDeptAccountCaliber(year);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody("生成年度核算口径部门！");
        LOGGER.info("生成年度核算口径部门！");
        return responseBean;
    }

    @RequestMapping(value = "/calibersave",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.MODIFY,operDesc = "保存部门核算口径")
    public OfficeResopnseBean saveDeptAccountCaliber(@RequestParam(value = "caliberSaves", required = false) List<Integer> caliberSaves,
                                                     @RequestParam(value = "caliberDeletes", required = false) List<Integer> caliberDeletes,
                                                     @RequestParam(value = "deptId") String deptId,
                                                     @RequestParam(value = "year") Integer year){
        if (caliberSaves == null) {
            caliberSaves = new ArrayList<>();
        }
        if (caliberDeletes == null) {
            caliberDeletes = new ArrayList<>();
        }
        accountCaliberManager.saveDeptAccountCaliber(caliberSaves,caliberDeletes, deptId,year);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody("保存部门核算口径！");
        LOGGER.info("保存部门核算口径！");
        return responseBean;
    }
}
