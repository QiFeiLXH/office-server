package com.bsoft.office.manager.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.manager.manager.SocialSecurityManager;
import com.bsoft.office.manager.vo.CompanySocialMeeterVO;
import com.bsoft.office.manager.vo.CompanySocialMeeterViewVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/11/27 8:45
 * @Description
 */
@RestController
@RequestMapping("/socialmeeter")
public class CompanySocialMeeterController {
    private static Logger logger  = LoggerFactory.getLogger(CompanySocialMeeterController.class);

    @Autowired
    private SocialSecurityManager socialSecurityManager;

    @GetMapping("/query")
    @OperLog(operType = OperLogType.QUERY,operDesc = "分子公司社保对接人")
    public OfficeResopnseBean getCompanySocialMeeterList(String inputContent, Integer pageNo, Integer pageSize, @RequestParam(name="socialCompanyFlag",required = false)List<Integer> socialCompanyFlag){
        if (socialCompanyFlag == null) {
            socialCompanyFlag = new ArrayList<>();
        }
        Result<CompanySocialMeeterViewVO> result = socialSecurityManager.getCompanySocialMeeterList(inputContent, socialCompanyFlag, pageNo, pageSize);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        logger.info("获取分子公司社保对接人列表！[{}]", JSONUtils.toString(result));
        return responseBean;
    }

    @PostMapping("/save")
    @OperLog(operType = OperLogType.MODIFY,operDesc = "保存分子公司社保对接人")
    public OfficeResopnseBean saveCompanySocialMeeter(@RequestBody CompanySocialMeeterVO companySocialMeeterVO){
        socialSecurityManager.saveCompanySocialMeeter(companySocialMeeterVO);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody("保存分子公司社保对接人成功！");
        logger.info("保存分子公司社保对接人成功", JSONUtils.toString(companySocialMeeterVO));
        return responseBean;
    }
}
