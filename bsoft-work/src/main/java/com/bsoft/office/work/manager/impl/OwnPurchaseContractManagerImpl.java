package com.bsoft.office.work.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.common.service.PublicDicService;
import com.bsoft.common.service.SystemDicService;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.common.vo.PublicDicVO;
import com.bsoft.office.common.vo.SystemDicVO;
import com.bsoft.office.work.condition.OwnPurchaseContractQueryCndVO;
import com.bsoft.office.work.manager.OwnPurchaseContractManager;
import com.bsoft.office.work.vo.*;
import com.bsoft.sales.dto.*;
import com.bsoft.sales.service.CustomerContactsService;
import com.bsoft.sales.service.PurchaseContractService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Xuhui Lin
 * @DateTime: 2020/11/21 12:06
 * @Description: 采购合同Manager实现类
 */
@Service
public class OwnPurchaseContractManagerImpl implements OwnPurchaseContractManager {
    @Autowired
    private IGenerator iGenerator;
    @Reference(timeout = 60000)
    private PurchaseContractService purchaseContractService;
    @Reference
    private PublicDicService publicDicService;
    @Reference
    private CustomerContactsService customerContactsService;
    @Reference
    private SystemDicService systemDicService;


    @Override
    public Result<CustomerContactVO> getCustomerContactsList(Integer pageNo, Integer pageSize, String inputContent) {
        Result<CustomerContactsDTO> result = customerContactsService.getCustomerContactsList(pageNo, pageSize, inputContent);
        return iGenerator.convert(result, CustomerContactVO.class);
    }

    @Override
    public Map<String, Object> getDicList() {
        List<PublicDicVO> fileTypes = iGenerator.convert(publicDicService.getPublicDic(2002), PublicDicVO.class); // 文件类型
        List<SystemDicVO> paymentItems = iGenerator.convert(systemDicService.getSystemDic(919), SystemDicVO.class); // 付款科目
        List<PublicDicVO> contractClassifications = iGenerator.convert(publicDicService.getPublicDic(1510), PublicDicVO.class); // 合同分类
        Map<String, Object> dics = new HashMap<>();
        dics.put("fileTypes",fileTypes);
        dics.put("paymentItems",paymentItems);
        dics.put("contractClassifications",contractClassifications);
        return dics;
    }

    @Override
    public List<PurchaseContractPaymentVO> getOwnPurchaseContractPaymentList(Integer contractId,Integer alterFlag) {
        List<PurchaseContractPaymentDTO> paymentDTOList = purchaseContractService.getOwnPurchaseContractPaymentList(contractId,alterFlag);
        return iGenerator.convert(paymentDTOList, PurchaseContractPaymentVO.class);
    }

    @Override
    public Result<OwnPurchaseContractViewVO> getOwnPurchaseContract(OwnPurchaseContractQueryCndVO cndVO) {
        OwnPurchaseContractQueryCndDTO cndDTO = iGenerator.convert(cndVO,OwnPurchaseContractQueryCndDTO.class);
        Result<PurchaseContractViewDTO> result = purchaseContractService.getOwnPurchaseContract(cndDTO);
        return iGenerator.convert(result, OwnPurchaseContractViewVO.class);
    }

    @Override
    public OwnPurchaseContractViewVO getOwnPurchaseContract(Integer purchaseContractId) {
        PurchaseContractViewDTO contract = purchaseContractService.getOwnPurchaseContract(purchaseContractId);
        return iGenerator.convert(contract, OwnPurchaseContractViewVO.class);
    }

    @Override
    public Integer saveOwnPurchaseContract(OwnPurchaseContractViewVO purchaseContract, List<PurchaseContractPaymentVO> saves, List<Integer> deletes, String userId) {
        if (!saves.isEmpty()) {
            saves.forEach(item -> {
                if (item.getId() < 0) {
                    item.setId(null);
                }
            });
        }
        PurchaseContractViewDTO contractDTO = iGenerator.convert(purchaseContract, PurchaseContractViewDTO.class);
        List<PurchaseContractPaymentDTO> paymentDTOS = iGenerator.convert(saves, PurchaseContractPaymentDTO.class);
        Integer purchaseContractId = purchaseContractService.saveOwnPurchaseContract(contractDTO,paymentDTOS,deletes,userId);
        return purchaseContractId;
    }

    @Override
    public Integer getUnfinishedPurchaseContractCount(Integer signYear, String inputContent, String userId) {
        return purchaseContractService.getOwnUnfinishedCount(signYear,inputContent,userId);
    }

    @Override
    public void deleteOwnPurchaseContractCount(Integer purchaseContractId) {
        purchaseContractService.deleteOwnPurchaseContractCount(purchaseContractId);
    }

    @Override
    public Integer getUnreviewedPurchaseContractCount(Integer signYear,String inputContent) {
        return purchaseContractService.getOwnUnreviewedCount(signYear,inputContent);
    }

    @Override
    public void auditOwnPurchaseContract(Integer contractId, Integer oldStatus, String personId) {
        purchaseContractService.auditOwnPurchaseContract(contractId, oldStatus, personId);
    }

    @Override
    public Result<OwnPurchaseContractViewVO> getOwnPurchaseContractAuditList(OwnPurchaseContractQueryCndVO cndVO) {
        OwnPurchaseContractQueryCndDTO cndDTO = iGenerator.convert(cndVO,OwnPurchaseContractQueryCndDTO.class);
        Result<PurchaseContractViewDTO> result = purchaseContractService.getOwnPurchaseContractAuditList(cndDTO);
        return iGenerator.convert(result, OwnPurchaseContractViewVO.class);
    }

    @Override
    public Result<OwnPurchaseCostPaymentViewVO> getOwnPurchaseCostPaymentList(Integer pageNo, Integer pageSize, String purchaseContractNo) {
        Result<OwnPurchaseCostPaymentDTO> result = purchaseContractService.getOwnPurchaseCostPaymentList(purchaseContractNo, pageNo, pageSize);
        return iGenerator.convert(result, OwnPurchaseCostPaymentViewVO.class);
    }

    @Override
    public Result<OwnPurchaseContractWithProgressViewVO> getOwnPurchaseContractWithProgressList(OwnPurchaseContractQueryCndVO cndVO) {
        OwnPurchaseContractQueryCndDTO cndDTO = iGenerator.convert(cndVO,OwnPurchaseContractQueryCndDTO.class);
        Result<PurchaseContractViewDTO> result = purchaseContractService.getOwnPurchaseContractWithProgressList(cndDTO);
        return iGenerator.convert(result, OwnPurchaseContractWithProgressViewVO.class);
    }

    @Override
    public List<PurchaseContractProgressViewVO> getOwnPurchaseContractProgressList(Integer purchaseContractId) {
        List<PurchaseContractProgressDTO> list = purchaseContractService.getOwnPurchaseContractProgressList(purchaseContractId);
        return iGenerator.convert(list, PurchaseContractProgressViewVO.class);
    }

    @Override
    public String getOwnPurchaseContractNo(Integer hasContract, Integer classification, String signDate) {
        return purchaseContractService.getOwnPurchaseContractNo(hasContract, classification, signDate);
    }

    @Override
    public Result<OwnPurchaseContractViewVO> getOwnPurchaseContractSearchList(Integer purchaseContractId, String inputContent, Integer pageNo, Integer pageSize) {
        Result<PurchaseContractViewDTO> result = purchaseContractService.getOwnPurchaseContractSearchList(purchaseContractId, inputContent, pageNo, pageSize);
        return iGenerator.convert(result, OwnPurchaseContractViewVO.class);
    }

    @Override
    public Result<OwnPurchaseContractViewVO> getOwnPurchaseContractSelectList(String inputContent,Integer pageNo, Integer pageSize) {
        Result<PurchaseContractViewDTO> result = purchaseContractService.getOwnPurchaseContractSelectList(inputContent,pageNo,pageSize);
        return iGenerator.convert(result, OwnPurchaseContractViewVO.class);
    }

    @Override
    public Integer saveOwnPurchaseContractProgress(PurchaseContractProgressViewVO progress) {
        PurchaseContractProgressDTO progressDTO = iGenerator.convert(progress, PurchaseContractProgressDTO.class);
        return purchaseContractService.savePurchaseContractProgress(progressDTO);
    }

    @Override
    public List<OwnPurchaseContractViewVO> exportOwnPurchaseContractList(OwnPurchaseContractQueryCndVO cndVO) {
        OwnPurchaseContractQueryCndDTO cndDTO = iGenerator.convert(cndVO,OwnPurchaseContractQueryCndDTO.class);
        List<PurchaseContractViewDTO> list = purchaseContractService.getAllOwnPurchaseContractList(cndDTO);
        return iGenerator.convert(list, OwnPurchaseContractViewVO.class);
    }

    @Override
    public Result<OwnPurchaseContractInfoViewVO> getOwnPurchaseContractInfoList(OwnPurchaseContractQueryCndVO cndVO) {
        OwnPurchaseContractQueryCndDTO cndDTO = iGenerator.convert(cndVO,OwnPurchaseContractQueryCndDTO.class);
        Result<PurchaseContractViewDTO> result = purchaseContractService.getOwnPurchaseContractInfoList(cndDTO);
        return iGenerator.convert(result, OwnPurchaseContractInfoViewVO.class);
    }

    @Override
    public List<OwnPurchaseContractInfoViewVO> exportOwnPurchaseContractInfoList(OwnPurchaseContractQueryCndVO cndVO) {
        OwnPurchaseContractQueryCndDTO cndDTO = iGenerator.convert(cndVO,OwnPurchaseContractQueryCndDTO.class);
        List<PurchaseContractViewDTO> list = purchaseContractService.getAllOwnPurchaseContractInfoList(cndDTO);
        return iGenerator.convert(list, OwnPurchaseContractInfoViewVO.class);
    }

    @Override
    public boolean existOwnPurchaseContractNo(String purchaseContractNo) {
        return purchaseContractService.existPurchaseContract(purchaseContractNo);
    }

    @Override
    public void disagreeOwnPurchaseContract(Integer contractId, Integer oldStatus) {
        purchaseContractService.disagreeOwnPurchaseContract(contractId,oldStatus);
    }

    @Override
    public Integer getOwnPurchaseContractSuplementCount(Integer purchaseContractId) {
        return purchaseContractService.getOwnPurchaseContractSuplementCount(purchaseContractId);
    }

    @Override
    public List<OwnPurchaseContractWithProgressViewVO> exportOwnPurchaseContractWithProgressList(OwnPurchaseContractQueryCndVO cndVO) {
        OwnPurchaseContractQueryCndDTO cndDTO = iGenerator.convert(cndVO,OwnPurchaseContractQueryCndDTO.class);
        List<PurchaseContractViewDTO> list = purchaseContractService.getAllOwnPurchaseContractWithProgressList(cndDTO);
        return iGenerator.convert(list, OwnPurchaseContractWithProgressViewVO.class);
    }

    @Override
    public void alterOwnPurchaseContract(OwnPurchaseContractViewVO purchaseContract, List<PurchaseContractPaymentVO> saves, String userId) {
        if (!saves.isEmpty()) {
            saves.forEach(item -> {
                if (item.getId() < 0) {
                    item.setId(null);
                }
            });
        }
        PurchaseContractViewDTO contractDTO = iGenerator.convert(purchaseContract, PurchaseContractViewDTO.class);
        List<PurchaseContractPaymentDTO> paymentDTOS = iGenerator.convert(saves, PurchaseContractPaymentDTO.class);
        purchaseContractService.alterOwnPurchaseContract(contractDTO,paymentDTOS,userId);
    }

    @Override
    public void auditAlterOwnPurchaseContract(OwnPurchaseContractViewVO purchaseContract, List<PurchaseContractPaymentVO> saves,String personId) {
        PurchaseContractViewDTO contractDTO = iGenerator.convert(purchaseContract, PurchaseContractViewDTO.class);
        List<PurchaseContractPaymentDTO> paymentDTOS = iGenerator.convert(saves, PurchaseContractPaymentDTO.class);
        purchaseContractService.auditAlterOwnPurchaseContract(contractDTO,paymentDTOS, personId);
    }

    @Override
    public void disagreeAlterOwnPurchaseContract(OwnPurchaseContractViewVO purchaseContract, List<PurchaseContractPaymentVO> saves) {
        PurchaseContractViewDTO contractDTO = iGenerator.convert(purchaseContract, PurchaseContractViewDTO.class);
        List<PurchaseContractPaymentDTO> paymentDTOS = iGenerator.convert(saves, PurchaseContractPaymentDTO.class);
        purchaseContractService.disagreeAlterOwnPurchaseContract(contractDTO,paymentDTOS);
    }


}
