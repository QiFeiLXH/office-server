package com.bsoft.office.sales.vo;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/25 15:14
 * @Description
 */
public class PurchaseContractSaveVO {
    /** 合同号 */
    private String contractNo;
    /** 采购合同信息 */
    private PurchaseContractViewVO purchaseContract;
    /** 采购合同付款条件 */
    private List<PurchaseContractPaymentVO> saves;
    /** 待删除的付款条件id */
    private List<Integer> deletes;

    public PurchaseContractViewVO getPurchaseContract() {
        return purchaseContract;
    }

    public void setPurchaseContract(PurchaseContractViewVO purchaseContract) {
        this.purchaseContract = purchaseContract;
    }

    public List<PurchaseContractPaymentVO> getSaves() {
        return saves;
    }

    public void setSaves(List<PurchaseContractPaymentVO> saves) {
        this.saves = saves;
    }

    public List<Integer> getDeletes() {
        return deletes;
    }

    public void setDeletes(List<Integer> deletes) {
        this.deletes = deletes;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }
}
