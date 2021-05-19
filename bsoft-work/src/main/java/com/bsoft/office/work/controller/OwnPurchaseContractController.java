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
import com.bsoft.office.work.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: Xuhui Lin
 * @DateTime: 2020/9/23 12:04
 * @Description: 公司自用采购合同Controller
 */
@RestController
@RequestMapping(value = "/ownpurchase")
public class OwnPurchaseContractController {

    @Autowired
    private OwnPurchaseContractManager ownPurchaseContractManager;

    /**
     * 获取公司自用采购合同列表
     * @param cndVO
     * @param request
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.QUERY,operDesc = "公司自用采购合同列表")
    public OfficeResopnseBean getOwnPurchaseContract(@RequestBody OwnPurchaseContractQueryCndVO cndVO, HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        cndVO.setPersonId(personId);
        Result<OwnPurchaseContractViewVO> result = ownPurchaseContractManager.getOwnPurchaseContract(cndVO);
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
     * 客户往来单位列表
     */
    @RequestMapping(value = "/customers",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "客户往来单位列表")
    public OfficeResopnseBean getCustomerContactsList(@RequestParam Integer pageNo,
                                                      @RequestParam Integer pageSize,
                                                      @RequestParam(required = false) String inputContent){
        Result<CustomerContactVO> result = ownPurchaseContractManager.getCustomerContactsList(pageNo, pageSize, inputContent);
        return OfficeResopnseBean.newSuccessBean(result);
    }

    /** 字典查询 */
    @GetMapping(value = "/dic")
    @OperLog(operType = OperLogType.QUERY,operDesc = "字典")
    public OfficeResopnseBean getDicList() {
        Map<String, Object> dics = ownPurchaseContractManager.getDicList();
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(dics);
        return responseBean;
    }

    /** 保存采购合同 */
    @PostMapping(value = "/contractsave")
    @OperLog(operType = OperLogType.SAVE,operDesc = "保存采购合同")
    public OfficeResopnseBean saveOwnPurchaseContract(@RequestBody OwnPurchaseContractSaveVO contractSaveVO, HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        OwnPurchaseContractViewVO purchaseContract = contractSaveVO.getPurchaseContract();
        List<Integer> deletes = contractSaveVO.getDeletes();
        List<PurchaseContractPaymentVO> saves = contractSaveVO.getSaves();

        if (deletes == null) {
            deletes = new ArrayList<>();
        }
        if (saves == null) {
            saves = new ArrayList<>();
        }
        Integer purchaseContractId = ownPurchaseContractManager.saveOwnPurchaseContract(purchaseContract,saves, deletes,userId);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(purchaseContractId);
        return responseBean;
    }

    /**
     * 付款条件列表
     */
    @GetMapping(value = "/paymentquery")
    @OperLog(operType = OperLogType.QUERY,operDesc = "付款条件列表")
    public OfficeResopnseBean getPurchaseContractPaymentList(Integer contractId, Integer alterFlag){
        List<PurchaseContractPaymentVO> list = ownPurchaseContractManager.getOwnPurchaseContractPaymentList(contractId, alterFlag);
        return OfficeResopnseBean.newSuccessBean(list);
    }

    /**
     * 未完结的采购合同数量
     */
    @GetMapping(value = "/unfinished")
    @OperLog(operType = OperLogType.QUERY,operDesc = "未完结的采购合同数量")
    public OfficeResopnseBean getUnfinishedPurchaseContractCount(Integer signYear, String inputContent, HttpServletRequest request){
        String userId = ContextUtils.getUserId(request);
        Integer count = ownPurchaseContractManager.getUnfinishedPurchaseContractCount(signYear,inputContent,userId);
        return OfficeResopnseBean.newSuccessBean(count);
    }

    /**
     * 删除合同
     */
    @DeleteMapping(value = "/contractdelete")
    @OperLog(operType = OperLogType.DELETE,operDesc = "删除合同")
    public OfficeResopnseBean deleteOwnPurchaseContractCount(Integer purchaseContractId){
        ownPurchaseContractManager.deleteOwnPurchaseContractCount(purchaseContractId);
        return OfficeResopnseBean.newSuccessBean("删除采购合同成功！");
    }


    /** 公司采购合同支付信息列表 */
    @GetMapping(value = "/costpayment")
    @OperLog(operType = OperLogType.QUERY,operDesc = "公司采购合同支付信息列表")
    public OfficeResopnseBean getOwnPurchaseCostPaymentList(Integer pageNo,Integer pageSize,String purchaseContractNo) {
        Result<OwnPurchaseCostPaymentViewVO> result = ownPurchaseContractManager.getOwnPurchaseCostPaymentList(pageNo, pageSize, purchaseContractNo);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        return responseBean;
    }

    /** 生成获取采购合同号 */
    @GetMapping(value = "/contractno")
    @OperLog(operType = OperLogType.OTHER,operDesc = "生成获取采购合同号")
    public OfficeResopnseBean getOwnPurchaseContractNo(Integer hasContract, Integer classification, String signDate) {
        String contractNo = ownPurchaseContractManager.getOwnPurchaseContractNo(hasContract, classification, signDate);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(contractNo);
        return responseBean;
    }

    /** 判断采购合同号是否重复 */
    @GetMapping(value = "/contractnoexist")
    @OperLog(operType = OperLogType.OTHER,operDesc = "判断采购合同号是否重复")
    public OfficeResopnseBean existOwnPurchaseContractNo(String purchaseContractNo) {
        boolean exist = ownPurchaseContractManager.existOwnPurchaseContractNo(purchaseContractNo);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(exist);
        return responseBean;
    }

    /** 获取采购合同查找列表 */
    @GetMapping(value = "/contracts")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取采购合同查找列表")
    public OfficeResopnseBean getOwnPurchaseContractSearchList(Integer purchaseContractId, String inputContent, Integer pageNo, Integer pageSize) {
        Result<OwnPurchaseContractViewVO> result = ownPurchaseContractManager.getOwnPurchaseContractSearchList(purchaseContractId, inputContent, pageNo, pageSize);
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
    public void exportOwnPurchaseContractList(@RequestBody OwnPurchaseContractQueryCndVO cndVO,
                                          ExportLogParams params,
                                          HttpServletRequest request,
                                          HttpServletResponse response){
        String personId = ContextUtils.getUserId(request);
        cndVO.setPersonId(personId);
        List<OwnPurchaseContractViewVO> list = ownPurchaseContractManager.exportOwnPurchaseContractList(cndVO);
        ExportExcel.export(list,OwnPurchaseContractViewVO.class,"公司采购合同申请列表",response);
    }


    /** 获取补充协议的数量 */
    @GetMapping(value = "/supplement")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取补充协议的数量")
    public OfficeResopnseBean getOwnPurchaseContractSuplementCount(Integer purchaseContractId) {
        Integer count = ownPurchaseContractManager.getOwnPurchaseContractSuplementCount(purchaseContractId);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(count);
        return responseBean;
    }


    /** 变更采购合同-合同金额、付款条件 */
    @PostMapping(value = "/contractalter")
    @OperLog(operType = OperLogType.SAVE,operDesc = "变更采购合同-合同金额、付款条件 ")
    public OfficeResopnseBean alterOwnPurchaseContract(@RequestBody OwnPurchaseContractSaveVO contractSaveVO, HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        OwnPurchaseContractViewVO purchaseContract = contractSaveVO.getPurchaseContract();
        List<Integer> deletes = contractSaveVO.getDeletes();
        List<PurchaseContractPaymentVO> saves = contractSaveVO.getSaves();
        if (saves == null) {
            saves = new ArrayList<>();
        }
        ownPurchaseContractManager.alterOwnPurchaseContract(purchaseContract,saves,userId);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody("变更成功");
        return responseBean;
    }

}
