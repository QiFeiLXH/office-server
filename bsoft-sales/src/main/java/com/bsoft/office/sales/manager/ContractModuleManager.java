package com.bsoft.office.sales.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.vo.DynamicTableHeaderVO;
import com.bsoft.office.sales.condition.ContractModuleQueryCndVO;
import com.bsoft.office.sales.condition.SalesContractAuditCndVO;
import com.bsoft.office.sales.condition.SalesContractCheckQueryCndVO;
import com.bsoft.office.sales.condition.SalesContractQueryCndVO;
import com.bsoft.office.sales.vo.*;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2021/3/3 13:04
 * @Description
 */
public interface ContractModuleManager {
    Result<ContractProducVO> getContractProductList(ContractModuleQueryCndVO cnd);

    List<ContractModuleVO> getContractModuleList(ContractModuleQueryCndVO cnd);

    void saveContractProductModuleRelation(ContractModuleProductSaveVO relations, String userId);

    Integer commitContractProductModuleRelation(ContractModuleProductSaveVO relations, String userId);

    Result<SalesContractViewVO> getSalesContractList(SalesContractQueryCndVO cnd);

    List<DynamicTableHeaderVO> getContractModuleHeader(SalesContractQueryCndVO contractId);

    List<SalesContractModuleViewVO> getSalesContractModuleList(SalesContractQueryCndVO cndVO);

    List<SalesContractAreaViewVO> getSalesContractAreaList(SalesContractAuditCndVO cnd);

    Result<SalesContractViewVO> getSalesContractAuditList(SalesContractAuditCndVO cnd);

    void auditSalesContract(String contractId);

    void returnSalesContract(String contractId, String backReason);

    Result<SalesContractCheckViewVO> getSalesCheckContractList(SalesContractCheckQueryCndVO cnd);

    Result<SalesContractModuleCheckViewVO> getSalesCheckContractModuleList(Integer pageNo, Integer pageSize, String contractId);

    void checkSalesContract(String contractId, String personId);

    Integer getUncheckedCount(String personId, boolean allPermission);
}
