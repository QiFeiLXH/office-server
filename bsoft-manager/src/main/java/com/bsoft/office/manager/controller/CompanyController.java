package com.bsoft.office.manager.controller;

import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.vo.PublicDicVO;
import com.bsoft.office.manager.manager.CompanyManager;
import com.bsoft.office.manager.vo.CompanyViewVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/11/26 11:05
 * @Description: 分子公司管理
 */
@RestController
@RequestMapping("/company")
public class CompanyController {
    private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);

    @Autowired
    private CompanyManager companyManager;

    //获取所有分子公司
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询所有分子公司")
    public OfficeResopnseBean getCompanyList(){
        List<CompanyViewVO> list = companyManager.getCompanyList();
        logger.info("获取所有分子公司成功!");
        return OfficeResopnseBean.newSuccessBean(list);
    }

    //获取详细分子公司信息
    @RequestMapping(value = "/getOne",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查看分子公司详情")
    public OfficeResopnseBean getCompany(@RequestParam Integer id){
        CompanyViewVO companyViewVO = companyManager.getCompany(id);
        logger.info("获取详细分子公司成功！,id=[{}]",id);
        return OfficeResopnseBean.newSuccessBean(companyViewVO);
    }

    //保存、更新分子公司
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.SAVE,operDesc = "新增、修改分子公司")
    public OfficeResopnseBean saveCompany(@RequestBody CompanyViewVO companyViewVO){
        CompanyViewVO companyViewVO1 = companyManager.saveCompany(companyViewVO);
        logger.info("保存、更新分子公司成功！");
        return OfficeResopnseBean.newSuccessBean(companyViewVO1);
    }

    //获取分子公司用途字典
    @RequestMapping(value = "/getpurpose")
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询分子公司用途字典")
    public OfficeResopnseBean getPurposeList(){
        List<PublicDicVO> list = companyManager.getPurposeList();
        logger.info("获取分子公司用途字典成功！");
        return OfficeResopnseBean.newSuccessBean(list);
    }

    @RequestMapping(value = "/notcancledlist",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询未注销的分子公司")
    public OfficeResopnseBean getNotCancledCompanyList(){
        List<CompanyViewVO> list = companyManager.getNotCancelledCompany();
        logger.info("获取所有未注销分子公司成功!");
        return OfficeResopnseBean.newSuccessBean(list);
    }

    @RequestMapping(value = "/docancle",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.MODIFY,operDesc = "注销分子公司")
    public OfficeResopnseBean doCancle(@RequestParam Integer companyId){
        companyManager.doCancle(companyId);
        logger.info("注销分子公司成功!");
        return OfficeResopnseBean.newSuccessBean();
    }
}
