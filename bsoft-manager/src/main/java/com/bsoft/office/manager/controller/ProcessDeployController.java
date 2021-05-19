package com.bsoft.office.manager.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.common.vo.PublicDicVO;
import com.bsoft.office.manager.condition.ProcessDeployQueryCnd;
import com.bsoft.office.manager.manager.ProcessDeployManager;
import com.bsoft.office.manager.vo.ProcessDeployVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/processdeploy")
public class ProcessDeployController {
    private static final Logger logger = LoggerFactory.getLogger(ProcessDeployController.class);

    @Autowired
    private ProcessDeployManager processDeployManager;

    /**
     * 获取流程信息列表
     * @param queryCnd
     * @param request
     * @return
     */
    @RequestMapping(value = "/processlist", method = RequestMethod.POST)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询流程信息列表")
    public OfficeResopnseBean getProcessDeployList(@RequestBody ProcessDeployQueryCnd queryCnd, HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        logger.info("[{}]获取流程信息列表[{}]", personId, JSONUtils.toString(queryCnd));
        Result<ProcessDeployVO> resultVO = processDeployManager.getProcessDeployList(queryCnd,personId);
        OfficeResopnseBean resopnseBean = OfficeResopnseBean.newSuccessBean();
        resopnseBean.setBody(resultVO);
        return resopnseBean;
    }

    /**
     * 获取流程类别
     */
    @RequestMapping(value = "/processtype", method = RequestMethod.POST)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询流程分类")
    public OfficeResopnseBean getProcessDeployType(HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        logger.info("[{}]获取流程分类", personId);
        List<PublicDicVO> publicDicVOList = processDeployManager.getProcessDeployType();
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(publicDicVOList);
        return responseBean;
    }


    /** 上传流程文件 */
    @PostMapping(value = "/fileupload")
    @OperLog(operType = OperLogType.UPLOAD,operDesc = "上传流程文件")
    public OfficeResopnseBean uploadFile(@RequestParam MultipartFile file, @RequestParam Integer agreementId, @RequestParam Integer menuId, HttpServletRequest request) {
        String personId = ContextUtils.getUserId(request);
        try {
            Integer fileId = processDeployManager.uploadProcessFile(file, agreementId, menuId, personId);
            OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
            responseBean.setBody(fileId);
            logger.info("流程部署-文件上传成功！", JSONUtils.toString("上传成功！"));
            return responseBean;
        } catch (IOException e) {
            logger.info("获取上传文件格式失败");
            return OfficeResopnseBean.newFailBean(500,"获取上传文件格式失败！");
        }
    }

    /**
     * 保存流程部署信息
     * @return
     */
    @RequestMapping(value = "/saveprocess", method = RequestMethod.POST)
    @OperLog(operType = OperLogType.SAVE,operDesc = "保存流程部署信息")
    public OfficeResopnseBean saveProcessDeploy(@RequestBody ProcessDeployVO processDeployVO,HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        processDeployManager.saveProcessDeploy(processDeployVO,personId);
        return OfficeResopnseBean.newSuccessBean();
    }

    /**
     * 部署流程信息
     * @return
     */
    @RequestMapping(value = "/deployprocess", method = RequestMethod.GET)
    @OperLog(operType = OperLogType.MODIFY,operDesc = "部署流程")
    public OfficeResopnseBean deployProcess(@RequestParam Integer id,HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        processDeployManager.deployProcess(id,personId);
        return OfficeResopnseBean.newSuccessBean();
    }

}
