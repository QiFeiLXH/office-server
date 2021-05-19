package com.bsoft.office.work.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.work.condition.OwnPurchaseContractQueryCndVO;
import com.bsoft.office.work.vo.*;

import java.util.List;
import java.util.Map;

/**
 * @Author: Xuhui Lin
 * @DateTime: 2020/11/21 12:05
 * @Description: 采购合同manager
 */
public interface OwnPurchaseContractManager {


    /**
     * 查询客户往来列表
     *
     * @param pageNo
     * @param pageSize
     * @param inputContent
     * @return
     */
    Result<CustomerContactVO> getCustomerContactsList(Integer pageNo, Integer pageSize, String inputContent);

    Map<String, Object> getDicList();

    List<PurchaseContractPaymentVO> getOwnPurchaseContractPaymentList(Integer contractId,Integer alterFlag);

    Result<OwnPurchaseContractViewVO> getOwnPurchaseContract(OwnPurchaseContractQueryCndVO cndVO);

    OwnPurchaseContractViewVO getOwnPurchaseContract(Integer purchaseContractId);

    Integer saveOwnPurchaseContract(OwnPurchaseContractViewVO purchaseContract, List<PurchaseContractPaymentVO> saves, List<Integer> deletes, String userId);

    Integer getUnfinishedPurchaseContractCount(Integer signYear, String inputContent, String userId);

    void deleteOwnPurchaseContractCount(Integer purchaseContractId);

    Integer getUnreviewedPurchaseContractCount(Integer signYear,String inputContent);

    void auditOwnPurchaseContract(Integer contractId, Integer oldStatus,String personId);

    Result<OwnPurchaseContractViewVO> getOwnPurchaseContractAuditList(OwnPurchaseContractQueryCndVO cndVO);

    Result<OwnPurchaseCostPaymentViewVO> getOwnPurchaseCostPaymentList(Integer pageNo, Integer pageSize, String purchaseContractNo);

    Result<OwnPurchaseContractWithProgressViewVO> getOwnPurchaseContractWithProgressList(OwnPurchaseContractQueryCndVO cndVO);

    List<PurchaseContractProgressViewVO> getOwnPurchaseContractProgressList(Integer purchaseContractId);

    String getOwnPurchaseContractNo(Integer hasContract, Integer classification, String signDate);

    Result<OwnPurchaseContractViewVO> getOwnPurchaseContractSearchList(Integer purchaseContractId, String inputContent, Integer pageNo, Integer pageSize);

    Result<OwnPurchaseContractViewVO> getOwnPurchaseContractSelectList(String inputContent,Integer pageNo, Integer pageSize);

    Integer saveOwnPurchaseContractProgress(PurchaseContractProgressViewVO progress);

    List<OwnPurchaseContractViewVO> exportOwnPurchaseContractList(OwnPurchaseContractQueryCndVO cndVO);

    Result<OwnPurchaseContractInfoViewVO> getOwnPurchaseContractInfoList(OwnPurchaseContractQueryCndVO cndVO);

    List<OwnPurchaseContractInfoViewVO> exportOwnPurchaseContractInfoList(OwnPurchaseContractQueryCndVO cndVO);

    boolean existOwnPurchaseContractNo(String purchaseContractNo);

    void disagreeOwnPurchaseContract(Integer contractId, Integer oldStatus);

    Integer getOwnPurchaseContractSuplementCount(Integer purchaseContractId);

    List<OwnPurchaseContractWithProgressViewVO> exportOwnPurchaseContractWithProgressList(OwnPurchaseContractQueryCndVO cndVO);

    void alterOwnPurchaseContract(OwnPurchaseContractViewVO purchaseContract, List<PurchaseContractPaymentVO> saves, String userId);

    void auditAlterOwnPurchaseContract(OwnPurchaseContractViewVO purchaseContract, List<PurchaseContractPaymentVO> saves,String personId);

    void disagreeAlterOwnPurchaseContract(OwnPurchaseContractViewVO purchaseContract, List<PurchaseContractPaymentVO> saves);
}
