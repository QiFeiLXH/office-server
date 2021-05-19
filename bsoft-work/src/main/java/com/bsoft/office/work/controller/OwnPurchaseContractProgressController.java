package com.bsoft.office.work.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.annotation.RequiredExportLog;
import com.bsoft.office.common.condition.ExportLogParams;
import com.bsoft.office.common.exportExcel.ExportExcel;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.work.condition.OwnPurchaseContractQueryCndVO;
import com.bsoft.office.work.manager.OwnPurchaseContractManager;
import com.bsoft.office.work.vo.OwnPurchaseContractViewVO;
import com.bsoft.office.work.vo.OwnPurchaseContractWithProgressViewVO;
import com.bsoft.office.work.vo.PurchaseContractProgressViewVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/11/11 8:55
 * @Description 采购进度
 */
@RestController
@RequestMapping(value = "/ownpurchaseprogress")
public class OwnPurchaseContractProgressController {
    @Autowired
    private OwnPurchaseContractManager ownPurchaseContractManager;

    /**
     * 获取公司自用采购合同列表
     */
    @GetMapping(value = "/list")
    @OperLog(operType = OperLogType.QUERY,operDesc = "公司自用采购合同列表")
    public OfficeResopnseBean getOwnPurchaseContractWithProgressList(OwnPurchaseContractQueryCndVO cndVO){
        Result<OwnPurchaseContractWithProgressViewVO> result = ownPurchaseContractManager.getOwnPurchaseContractWithProgressList(cndVO);
        return OfficeResopnseBean.newSuccessBean(result);
    }

    /**
     * 获取公司自用采购合同列表
     */
    @GetMapping(value = "/getone")
    @OperLog(operType = OperLogType.QUERY,operDesc = "公司自用采购合同明细")
    public OfficeResopnseBean getOwnPurchaseContract(Integer purchaseContractId){
        OwnPurchaseContractViewVO contract = ownPurchaseContractManager.getOwnPurchaseContract(purchaseContractId);
        return OfficeResopnseBean.newSuccessBean(contract);
    }

    /**
     * 获取公司自用采购合同列表
     */
    @GetMapping(value = "/progress")
    @OperLog(operType = OperLogType.QUERY,operDesc = "公司自用采购合同进度列表")
    public OfficeResopnseBean getOwnPurchaseContractProgressList(Integer purchaseContractId){
        List<PurchaseContractProgressViewVO> list = ownPurchaseContractManager.getOwnPurchaseContractProgressList(purchaseContractId);
        return OfficeResopnseBean.newSuccessBean(list);
    }

    /**
     * 保存公司自用采购合同进度
     */
    @PostMapping(value = "/progresssave")
    @OperLog(operType = OperLogType.SAVE,operDesc = "保存公司自用采购合同进度")
    public OfficeResopnseBean saveOwnPurchaseContractProgress(@RequestBody PurchaseContractProgressViewVO progress, HttpServletRequest request){
        String userId = ContextUtils.getUserId(request);
        progress.setRegisterPersonId(userId);
        Integer progressId = ownPurchaseContractManager.saveOwnPurchaseContractProgress(progress);
        return OfficeResopnseBean.newSuccessBean(progressId);
    }

    /** 获取采购合同选择列表 */
    @GetMapping(value = "/contractselect")
    @OperLog(operType = OperLogType.QUERY,operDesc = "采购合同选择列表")
    public OfficeResopnseBean getOwnPurchaseContractSelectList(String inputContent, Integer pageNo, Integer pageSize) {
        Result<OwnPurchaseContractViewVO> result = ownPurchaseContractManager.getOwnPurchaseContractSelectList(inputContent,pageNo,pageSize);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        return responseBean;
    }

    /**
     *功能描述: 采购合同导出
     */
    @PostMapping(value = "/contractdownload")
    @RequiredExportLog
    @OperLog(operType = OperLogType.EXPORT,operDesc = "采购合同导出")
    public void exportOwnPurchaseContractWithProgressList(@RequestBody OwnPurchaseContractQueryCndVO cndVO,
                                                                        ExportLogParams params,
                                                                        HttpServletRequest request,
                                                                        HttpServletResponse response) {
        String personId = ContextUtils.getUserId(request);
        cndVO.setPersonId(personId);
        List<OwnPurchaseContractWithProgressViewVO> list = ownPurchaseContractManager.exportOwnPurchaseContractWithProgressList(cndVO);
        ExportExcel.export(list,OwnPurchaseContractWithProgressViewVO.class,"公司采购合同进度列表",response);
    }
}
