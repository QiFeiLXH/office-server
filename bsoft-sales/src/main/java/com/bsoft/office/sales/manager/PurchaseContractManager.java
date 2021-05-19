package com.bsoft.office.sales.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.vo.PublicDicVO;
import com.bsoft.office.sales.condition.PurContractPayQueryCndVO;
import com.bsoft.office.sales.condition.PurchaseContractQueryCndVO;
import com.bsoft.office.sales.vo.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Author: xucl
 * @DateTime: 2020/9/23 12:05
 * @Description: 采购合同manager
 */
public interface PurchaseContractManager {
    /**
     * 查询采购合同列表
     * @param cndVO
     * @return
     */
    Result<PurchaseContractViewVO> getPurchaseContract(PurchaseContractQueryCndVO cndVO);

    /**
     * 查询支付信息
     * @param cndVO
     * @return
     */
    Result<PurContractPayViewVO> getPurContractPay(PurContractPayQueryCndVO cndVO);

    /**
     * 根据ID获取支付信息详细信息
     * @param id
     * @return
     */
    PurContractPayViewVO getPurContractPay(Integer id);

    /**
     * 保存、更新支付信息
     * @param payViewVO
     */
    Integer savePurContractPay(PurContractPayViewVO payViewVO);

    /**
     * 获取核算口径归属
     * @return
     */
    List<PublicDicVO> getPersonnelGroupDic(String deptId,Integer year);

    Integer savePaymentApplication(PurContractPayViewVO payViewVO);


    /**
     * 查询客户往来列表
     *
     * @param pageNo
     * @param pageSize
     * @param inputContent
     * @return
     */
    Result<CustomerContactsVO> getCustomerContactsList(Integer pageNo, Integer pageSize, String inputContent);
    Result<CustomerContactViewVO> getCustomerContacts(Integer pageNo, Integer pageSize, String inputContent);

    Map<String, Object> getDicList();

    Result<PublicWordsViewVO> getPublicWordsList(Integer pageNo, Integer pageSize, Integer mainId, Integer menuId, Integer type);

    void uploadFile(MultipartFile file, Integer contractId, Integer menuId, String personId) throws IOException;

    PublicWordsVO downloadFile(Integer fileId, Integer wordId, String personId);

    void deleteFile(Integer fileId, Integer wordId);

    void savePurchaseContract(PurchaseContractViewVO purchaseContract, List<PurchaseContractPaymentVO> saves, List<Integer> deletes, String contractNo);

    List<PurchaseContractPaymentVO> getPurchaseContractPaymentList(Integer contractId);
}
