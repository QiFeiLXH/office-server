package com.bsoft.office.hr.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.hr.condition.PersonalTrainQueryCnd;
import com.bsoft.office.hr.manager.TrainManager;
import com.bsoft.office.hr.vo.PersonalTrainVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author Xuhui Lin
 * @Date 2020/8/10 16:20
 * @Description
 */
@RestController
@RequestMapping("/personaltrain")
public class PersonTrainController {
    private final static Logger LOGGER = LoggerFactory.getLogger(PersonTrainController.class);

    @Autowired
    private TrainManager trainManager;

    @GetMapping("/query")
    @OperLog(operType = OperLogType.QUERY,operDesc = "个人培训列表")
    public OfficeResopnseBean getPersonalTrainList(PersonalTrainQueryCnd cnd, HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        cnd.setPersonId(personId);
        Result<PersonalTrainVO> result = trainManager.getPersonalTrainList(cnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        LOGGER.info("获取个人培训查询列表！[{}]", JSONUtils.toString(result));
        return responseBean;
    }
}
