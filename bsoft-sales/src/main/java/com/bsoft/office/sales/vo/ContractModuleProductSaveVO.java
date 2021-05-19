package com.bsoft.office.sales.vo;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2021/3/12 16:01
 * @Description
 */
public class ContractModuleProductSaveVO {
    private List<ContractModuleProductVO> saveList;
    private List<ContractModuleProductVO> deleteList;
    private String contractId;
    private Integer completeFlag;

    public List<ContractModuleProductVO> getSaveList() {
        return saveList;
    }

    public void setSaveList(List<ContractModuleProductVO> saveList) {
        this.saveList = saveList;
    }

    public List<ContractModuleProductVO> getDeleteList() {
        return deleteList;
    }

    public void setDeleteList(List<ContractModuleProductVO> deleteList) {
        this.deleteList = deleteList;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public Integer getCompleteFlag() {
        return completeFlag;
    }

    public void setCompleteFlag(Integer completeFlag) {
        this.completeFlag = completeFlag;
    }
}
