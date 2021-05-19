package com.bsoft.office.work.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.condition.ModifyRecordQueryCnd;
import com.bsoft.office.common.manager.ModifyRecordManager;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.common.vo.ModifyRecordViewVO;
import com.bsoft.office.work.condition.OwnPurchaseContractQueryCndVO;
import com.bsoft.office.work.manager.OwnPurchaseContractManager;
import com.bsoft.office.work.vo.OwnPurchaseContractSaveVO;
import com.bsoft.office.work.vo.OwnPurchaseContractViewVO;
import com.bsoft.office.work.vo.PurchaseContractPaymentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: Xuhui Lin
 * @DateTime: 2020/9/23 12:04
 * @Description: 公司自用采购合同Controller
 */
@RestController
@RequestMapping(value = "/ownpurchaseaudit")
public class OwnPurchaseContractAuditController {

    @Autowired
    private OwnPurchaseContractManager ownPurchaseContractManager;
    @Autowired
    private ModifyRecordManager modifyRecordManager;

    /**
     * 获取公司自用采购合同列表
     * @param cndVO
     * @param request
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.QUERY,operDesc = "公司自用采购合同列表")
    public OfficeResopnseBean getOwnPurchaseContractAuditList(@RequestBody OwnPurchaseContractQueryCndVO cndVO, HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        cndVO.setPersonId(personId);
        Result<OwnPurchaseContractViewVO> result = ownPurchaseContractManager.getOwnPurchaseContractAuditList(cndVO);
        return OfficeResopnseBean.newSuccessBean(result);
    }

    /**
     * 审核合同
     */
    @GetMapping(value = "/audit")
    @OperLog(operType = OperLogType.OTHER,operDesc = "审核合同")
    public OfficeResopnseBean auditOwnPurchaseContract(Integer contractId, Integer oldStatus, HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        ownPurchaseContractManager.auditOwnPurchaseContract(contractId, oldStatus, personId);
        return OfficeResopnseBean.newSuccessBean("审核合同成功");
    }

    /**
     * 驳回合同
     */
    @GetMapping(value = "/disagree")
    @OperLog(operType = OperLogType.OTHER,operDesc = "驳回合同")
    public OfficeResopnseBean disagreeOwnPurchaseContract(Integer contractId, Integer oldStatus){
        ownPurchaseContractManager.disagreeOwnPurchaseContract(contractId,oldStatus);
        return OfficeResopnseBean.newSuccessBean("合同审核不通过");
    }

    /**
     * 未审核的采购合同数量
     */
    @GetMapping(value = "/unreviewed")
    @OperLog(operType = OperLogType.QUERY,operDesc = "未审核的采购合同数量")
    public OfficeResopnseBean getUnreviewedPurchaseContractCount(Integer signYear,String inputContent){
        Integer count = ownPurchaseContractManager.getUnreviewedPurchaseContractCount(signYear,inputContent);
        return OfficeResopnseBean.newSuccessBean(count);
    }

    /**
     * 变更审核合同
     */
    @PostMapping(value = "/alteraudit")
    @OperLog(operType = OperLogType.OTHER,operDesc = "变更审核合同")
    public OfficeResopnseBean auditAlterOwnPurchaseContract(@RequestBody OwnPurchaseContractSaveVO contractSaveVO, HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        OwnPurchaseContractViewVO purchaseContract = contractSaveVO.getPurchaseContract();
        List<PurchaseContractPaymentVO> saves = contractSaveVO.getSaves();
        ownPurchaseContractManager.auditAlterOwnPurchaseContract(purchaseContract, saves, personId);
        return OfficeResopnseBean.newSuccessBean("变更审核合同成功");
    }

    /**
     * 变更驳回合同
     */
    @PostMapping(value = "/alterdisagree")
    @OperLog(operType = OperLogType.OTHER,operDesc = "变更驳回合同")
    public OfficeResopnseBean disagreeAlterOwnPurchaseContract(@RequestBody OwnPurchaseContractSaveVO contractSaveVO){
        OwnPurchaseContractViewVO purchaseContract = contractSaveVO.getPurchaseContract();
        List<PurchaseContractPaymentVO> saves = contractSaveVO.getSaves();
        ownPurchaseContractManager.disagreeAlterOwnPurchaseContract(purchaseContract, saves);
        return OfficeResopnseBean.newSuccessBean("合同变更审核不通过");
    }

    /**
     * 获取采购合同变更修改记录列表
     * @param cnd
     * @param request
     * @return
     */
    @GetMapping("/modifyrecord")
    @OperLog(operType = OperLogType.QUERY,operDesc = "采购合同变更修改记录")
    public OfficeResopnseBean getAlterModifyRecordList(ModifyRecordQueryCnd cnd, HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        cnd.setModifyPersonId(personId);
        Result<ModifyRecordViewVO> result = modifyRecordManager.getModifyRecordList(cnd);
        return OfficeResopnseBean.newSuccessBean(result);
    }

}
