package com.bsoft.office.work.vo;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/25 15:14
 * @Description
 */
public class OwnPurchaseContractSaveVO {
    /** 采购合同信息 */
    private OwnPurchaseContractViewVO purchaseContract;
    /** 采购合同付款条件 */
    private List<PurchaseContractPaymentVO> saves;
    /** 待删除的付款条件id */
    private List<Integer> deletes;

    public OwnPurchaseContractViewVO getPurchaseContract() {
        return purchaseContract;
    }

    public void setPurchaseContract(OwnPurchaseContractViewVO purchaseContract) {
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
}
