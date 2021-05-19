package com.bsoft.office.hr.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.common.vo.PublicDicVO;
import com.bsoft.office.hr.condition.CertificateOriginalScriptQueryCnd;
import com.bsoft.office.hr.manager.CertificateOriginalScriptManager;
import com.bsoft.office.hr.vo.CertificateOriginalScriptVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: zy
 * @date: 2020/9/10
 * @description 证书原件管理
 */
@RestController
@RequestMapping("/certificate/origin")
public class CertificateOriginalScriptController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CertificateOriginalScriptController.class);
    @Autowired
    private CertificateOriginalScriptManager certificateOriginalScriptManager;

    @GetMapping("/query")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取证书原件列表")
    public OfficeResopnseBean listCertificateOriginalScripts(CertificateOriginalScriptQueryCnd queryCnd, HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("[{}]获取证书原件列表[{}]", userId, JSONUtils.toString(queryCnd));
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        Result<CertificateOriginalScriptVO> result = certificateOriginalScriptManager.listCertificateOriginalScripts(userId, queryCnd);
        responseBean.setBody(result);
        return responseBean;
    }

    @GetMapping("/audit")
    @OperLog(operType = OperLogType.QUERY,operDesc = "根据名字获取证书原件信息")
    public OfficeResopnseBean getByName(@RequestParam("name") String name, HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("[{}]根据名字获取证书原件信息[{}]", userId, name);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        CertificateOriginalScriptVO certVO = certificateOriginalScriptManager.getByName(userId, name);
        responseBean.setBody(certVO);
        return responseBean;
    }

    @PostMapping("/save")
    @OperLog(operType = OperLogType.SAVE,operDesc = "保存证书原件信息")
    public OfficeResopnseBean save(@RequestBody CertificateOriginalScriptVO saveVO, HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("[{}]保存证书原件信息[{}]", userId, JSONUtils.toString(saveVO));
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        try{
            certificateOriginalScriptManager.save(userId, saveVO);
            responseBean.setMsg("保存成功！");
        } catch (Exception e) {
            e.printStackTrace();
            responseBean.setCode(500);
            responseBean.setMsg("保存失败！");
        }
        return responseBean;
    }

    @PostMapping("/update")
    @OperLog(operType = OperLogType.SAVE,operDesc = "更新证书原件信息")
    public OfficeResopnseBean update(@RequestBody CertificateOriginalScriptVO updateVO, HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("[{}]更新证书原件信息[{}]", userId, JSONUtils.toString(updateVO));
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        try{
            certificateOriginalScriptManager.update(userId, updateVO);
            responseBean.setMsg("修改成功！");
        } catch (Exception e) {
            e.printStackTrace();
            responseBean.setCode(500);
            responseBean.setMsg("修改失败！");
        }
        return responseBean;
    }

    @GetMapping("/type")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取证书类别")
    public OfficeResopnseBean listCertType(HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("[{}]获取证书类别", userId);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        List<PublicDicVO> certTypeVOList = certificateOriginalScriptManager.listCertType(userId);
        responseBean.setBody(certTypeVOList);
        return responseBean;
    }
}


