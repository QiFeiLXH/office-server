package com.bsoft.office.hr.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.hr.manager.WorkCertificateManager;
import com.bsoft.office.hr.vo.WorkCertificateNumViewVO;
import com.bsoft.office.hr.vo.WorkCertificateVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Xuhui Lin
 * @Date 2020/8/4 14:54
 * @Description
 */
@RestController
@RequestMapping("/certificate")
public class WorkCertificateController {
    private final static Logger LOGGER = LoggerFactory.getLogger(WorkCertificateController.class);

    @Autowired
    private WorkCertificateManager workCertificateManager;

    @GetMapping("/numberquery")
    @OperLog(operType = OperLogType.QUERY,operDesc = "证书数量查询")
    public OfficeResopnseBean getCertificateNumList(@RequestParam(name = "deptId", required = false) String deptId,
                                          @RequestParam(name = "inputContent", required = false) String inputContent,
                                          @RequestParam Integer pageNo,
                                          @RequestParam Integer pageSize ){
        Result<WorkCertificateNumViewVO> result = workCertificateManager.getCertificateNumList(deptId, inputContent, pageNo, pageSize);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        LOGGER.info("获取证书数量查询列表！[{}]", JSONUtils.toString(result));
        return responseBean;
    }

    @GetMapping("/query")
    @OperLog(operType = OperLogType.QUERY,operDesc = "个人证书查询列表")
    public OfficeResopnseBean getPersonalCertificateList(@RequestParam(name = "personId", required = false) String personId,
                                          @RequestParam Integer pageNo,
                                          @RequestParam Integer pageSize ){
        Result<WorkCertificateVO> result = workCertificateManager.getPersonalCertificateList(personId, pageNo, pageSize);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        LOGGER.info("获取个人证书查询列表！[{}]", JSONUtils.toString(result));
        return responseBean;
    }

}
