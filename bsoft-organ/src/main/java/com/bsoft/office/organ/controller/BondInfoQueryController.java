package com.bsoft.office.organ.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.annotation.RequiredExportLog;
import com.bsoft.office.common.condition.ExportLogParams;
import com.bsoft.office.common.exportExcel.ExportExcel;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.organ.condition.BondInfoQueryCnd;
import com.bsoft.office.organ.manager.BondManager;
import com.bsoft.office.organ.vo.BondOverdueInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/4/21 11:32
 * @Description 保证金逾期情况查询
 */
@RestController
@RequestMapping("/bond")
public class BondInfoQueryController {
    private static Logger logger  = LoggerFactory.getLogger(BondInfoQueryController.class);

    @Autowired
    private BondManager bondManager;

    /**
     *功能描述: 保证金逾期情况查询
     */
    @PostMapping(value = "/query")
    @OperLog(operType = OperLogType.QUERY,operDesc = "保证金逾期情况查询")
    public OfficeResopnseBean getBondOverdueInfoList(@RequestBody BondInfoQueryCnd bondInfoQueryCnd,
                                                      HttpServletRequest request){
        String userId = ContextUtils.getUserId(request);
        bondInfoQueryCnd.setUserId(userId);
        Result<BondOverdueInfoVO> result = bondManager.getBondOverdueInfoList(bondInfoQueryCnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        logger.info("获取保证金逾期情况查询成功！[{}]", JSONUtils.toString(result));
        return responseBean;
    }

    /**
     *功能描述: 保证金逾期列表导出
     */
    @PostMapping(value = "/bondinfodownload")
    @RequiredExportLog
    @OperLog(operType = OperLogType.EXPORT,operDesc = "保证金逾期列表导出")
    public void exportBondOverdueInfoList(@RequestBody BondInfoQueryCnd bondInfoQueryCnd,
                                          ExportLogParams params,
                                          HttpServletRequest request,
                                          HttpServletResponse response){
        String userId = ContextUtils.getUserId(request);
        bondInfoQueryCnd.setUserId(userId);
        List<BondOverdueInfoVO> list = bondManager.exportBondOverdueInfoList(bondInfoQueryCnd);
        ExportExcel.export(list,BondOverdueInfoVO.class,"保证金逾期情况列表",response);
    }

    /**
     *功能描述: 个人保证金逾期情况查询
     */
    @PostMapping(value = "/personalquery")
    @OperLog(operType = OperLogType.EXPORT,operDesc = "个人保证金逾期情况")
    public OfficeResopnseBean getPersonalBondList(@RequestBody BondInfoQueryCnd bondInfoQueryCnd,
                                                      HttpServletRequest request){
        String userId = ContextUtils.getUserId(request);
        bondInfoQueryCnd.setUserId(userId);
        Result<BondOverdueInfoVO> result = bondManager.getPersonalBondList(bondInfoQueryCnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        logger.info("获取保证金逾期情况查询成功！[{}]", JSONUtils.toString(result));
        return responseBean;
    }

    /**
     *功能描述: 个人保证金逾期列表导出
     */
    @PostMapping(value = "/personalbonddownload")
    @RequiredExportLog
    @OperLog(operType = OperLogType.EXPORT,operDesc = "个人保证金逾期列表导出")
    public void exportPersonalBondList(@RequestBody BondInfoQueryCnd bondInfoQueryCnd,
                                       ExportLogParams params,
                                       HttpServletRequest request,
                                       HttpServletResponse response){
        String userId = ContextUtils.getUserId(request);
        bondInfoQueryCnd.setUserId(userId);
        List<BondOverdueInfoVO> list = bondManager.exportPersonalBondInfoList(bondInfoQueryCnd);
        ExportExcel.export(list,BondOverdueInfoVO.class,"保证金逾期情况列表",response);
    }

    /**
     * 根据id获取保证金详情信息
     * @param id
     * @return
     */
    @GetMapping(value = "/getdetail")
    @OperLog(operType = OperLogType.QUERY,operDesc = "保证金详情信息")
    public OfficeResopnseBean getBondInfoById(@RequestParam("id") String id){
        BondOverdueInfoVO voResult = bondManager.getBondOverdueDetail(id);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(voResult);
        logger.info("获取id为:{}的保证金详情成功", id);
        return responseBean;
    }
}
