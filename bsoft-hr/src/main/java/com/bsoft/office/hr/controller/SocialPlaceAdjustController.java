package com.bsoft.office.hr.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.hr.condition.PersonSocialPlaceQueryCnd;
import com.bsoft.office.hr.manager.SocialSecurityAdjustManager;
import com.bsoft.office.hr.vo.PersonSocialPlaceViewVO;
import com.bsoft.office.hr.vo.SocialAdjustmentRecordVO;
import com.bsoft.office.hr.vo.SocialAdjustmentRecordViewVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/11/27 8:45
 * @Description
 */
@RestController
@RequestMapping("/personsocialplace")
public class SocialPlaceAdjustController {
    private static Logger logger  = LoggerFactory.getLogger(SocialPlaceAdjustController.class);

    @Autowired
    private SocialSecurityAdjustManager socialSecurityManager;

    @GetMapping("/query")
    @OperLog(operType = OperLogType.QUERY,operDesc = "人员社保缴纳地信息列表")
    public OfficeResopnseBean getPersonalSocialPlaceList(PersonSocialPlaceQueryCnd cnd){
        Result<PersonSocialPlaceViewVO> result = socialSecurityManager.getPersonalSocialPlaceList(cnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        logger.info("获取人员社保缴纳地信息列表！[{}]", JSONUtils.toString(result));
        return responseBean;
    }

    @PostMapping("/save")
    @OperLog(operType = OperLogType.MODIFY,operDesc = "保存员工社保缴纳地")
    public OfficeResopnseBean savePersonalSocialPlaces(@RequestBody List<SocialAdjustmentRecordVO> records, HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        socialSecurityManager.savePersonalSocialPlaces(records, personId);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody("保存员工社保缴纳地成功！");
        logger.info("保存员工社保缴纳地成功");
        return responseBean;
    }

    @GetMapping("/adjustrecord")
    @OperLog(operType = OperLogType.QUERY,operDesc = "人员社保缴纳地调整列表")
    public OfficeResopnseBean getPersonAdjustRecordList(Integer pageNo,Integer pageSize, String personId){
        Result<SocialAdjustmentRecordViewVO> result = socialSecurityManager.getPersonAdjustRecordList(pageNo, pageSize, personId);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        logger.info("获取人员社保缴纳地调整列表！[{}]", JSONUtils.toString(result));
        return responseBean;
    }
}
