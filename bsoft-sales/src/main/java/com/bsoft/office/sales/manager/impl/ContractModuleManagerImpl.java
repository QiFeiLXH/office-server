package com.bsoft.office.sales.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.common.vo.DynamicTableHeaderVO;
import com.bsoft.office.sales.condition.ContractModuleQueryCndVO;
import com.bsoft.office.sales.condition.SalesContractAuditCndVO;
import com.bsoft.office.sales.condition.SalesContractCheckQueryCndVO;
import com.bsoft.office.sales.condition.SalesContractQueryCndVO;
import com.bsoft.office.sales.manager.ContractModuleManager;
import com.bsoft.office.sales.vo.*;
import com.bsoft.sales.dto.*;
import com.bsoft.sales.service.ContractModuleService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author Xuhui Lin
 * @Date 2021/3/3 13:04
 * @Description
 */
@Component
public class ContractModuleManagerImpl implements ContractModuleManager {
    @Reference(timeout = 6000)
    private ContractModuleService contractModuleService;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public Result<ContractProducVO> getContractProductList(ContractModuleQueryCndVO cnd) {
        ContractModuleQueryCndDTO cndDTO = iGenerator.convert(cnd, ContractModuleQueryCndDTO.class);
        Result<ContractProducDTO> result = contractModuleService.getContractProductList(cndDTO);
        return iGenerator.convert(result, ContractProducVO.class);
    }

    @Override
    public List<ContractModuleVO> getContractModuleList(ContractModuleQueryCndVO cnd) {
        ContractModuleQueryCndDTO cndDTO = iGenerator.convert(cnd, ContractModuleQueryCndDTO.class);
        List<ContractModuleDTO> list = contractModuleService.getContractModuleList(cndDTO);
        return iGenerator.convert(list, ContractModuleVO.class);
    }

    @Override
    public void saveContractProductModuleRelation(ContractModuleProductSaveVO contractModuleProductSaveVO, String userId) {
        String contractId = contractModuleProductSaveVO.getContractId();
        List<ContractModuleProductVO> deleteList = contractModuleProductSaveVO.getDeleteList();
        List<ContractModuleProductVO> saveList = contractModuleProductSaveVO.getSaveList();
        List<ContractModuleProductDTO> deletes = iGenerator.convert(deleteList, ContractModuleProductDTO.class);
        List<ContractModuleProductDTO> saves = iGenerator.convert(saveList, ContractModuleProductDTO.class);
        contractModuleService.saveContractProductModuleRelation(saves, deletes, contractId, userId);
    }

    @Override
    public Integer commitContractProductModuleRelation(ContractModuleProductSaveVO contractModuleProductSaveVO, String userId) {
        String contractId = contractModuleProductSaveVO.getContractId();
        Integer completeFlag = contractModuleProductSaveVO.getCompleteFlag();
        List<ContractModuleProductVO> deleteList = contractModuleProductSaveVO.getDeleteList();
        List<ContractModuleProductVO> saveList = contractModuleProductSaveVO.getSaveList();
        List<ContractModuleProductDTO> deletes = iGenerator.convert(deleteList, ContractModuleProductDTO.class);
        List<ContractModuleProductDTO> saves = iGenerator.convert(saveList, ContractModuleProductDTO.class);
        return contractModuleService.commitContractProductModuleRelation(saves, deletes, contractId, userId,completeFlag);
    }

    @Override
    public Result<SalesContractViewVO> getSalesContractList(SalesContractQueryCndVO cnd) {
        SalesContractQueryCndDTO cndDTO = iGenerator.convert(cnd, SalesContractQueryCndDTO.class);
        Result<SalesContractDTO> result = contractModuleService.getContractList(cndDTO);
        return iGenerator.convert(result, SalesContractViewVO.class);
    }

    @Override
    public List<DynamicTableHeaderVO> getContractModuleHeader(SalesContractQueryCndVO cnd) {
        SalesContractQueryCndDTO cndDTO = iGenerator.convert(cnd, SalesContractQueryCndDTO.class);
        List<Integer> rowSpan = contractModuleService.getSalesContractModuleCount(cndDTO);
        DynamicTableHeaderVO h1 = DynamicTableHeaderVO.builder().title("业务大类").column("businessCategoryText").rowSpan(rowSpan).width(100).ellipsis(false).build();
        DynamicTableHeaderVO h2 = DynamicTableHeaderVO.builder().title("类别").column("productType").rowSpan(rowSpan).width(100).ellipsis(false).build();
        DynamicTableHeaderVO h3 = DynamicTableHeaderVO.builder().title("产品名称").column("productName").rowSpan(rowSpan).width(210).ellipsis(false).build();
        DynamicTableHeaderVO h4 = DynamicTableHeaderVO.builder().title("合同模块").column("name").rowSpan(rowSpan).width(210).ellipsis(false).build();
        DynamicTableHeaderVO h5 = DynamicTableHeaderVO.builder().title("产品模块").column("productNameText").width(240).ellipsis(true).scopedSlots(Map.of("customRender", "productNameText")).build();
        DynamicTableHeaderVO h6 = DynamicTableHeaderVO.builder().title("系统软件").column("parentProductNameText").width(240).ellipsis(true).scopedSlots(Map.of("customRender", "parentProductNameText")).build();
        return Arrays.asList(h1,h2,h3,h4,h5,h6);
    }

    @Override
    public List<SalesContractModuleViewVO> getSalesContractModuleList(SalesContractQueryCndVO cndVO) {
        SalesContractQueryCndDTO cndDTO = iGenerator.convert(cndVO, SalesContractQueryCndDTO.class);
        List<SalesContractModuleDTO> list = contractModuleService.getSalesContractModuleList(cndDTO);
        return iGenerator.convert(list, SalesContractModuleViewVO.class);
    }

    @Override
    public List<SalesContractAreaViewVO> getSalesContractAreaList(SalesContractAuditCndVO cnd) {
        SalesContractAuditCndDTO cndDTO = iGenerator.convert(cnd, SalesContractAuditCndDTO.class);
        List<SalesContractAreaDTO> list = contractModuleService.getSalesContractAreaList(cndDTO);
        return iGenerator.convert(list, SalesContractAreaViewVO.class);
    }

    @Override
    public Result<SalesContractViewVO> getSalesContractAuditList(SalesContractAuditCndVO cnd) {
        SalesContractAuditCndDTO cndDTO = iGenerator.convert(cnd, SalesContractAuditCndDTO.class);
        Result<SalesContractDTO> result = contractModuleService.getSalesContractAuditList(cndDTO);
        return iGenerator.convert(result, SalesContractViewVO.class);
    }

    @Override
    public void auditSalesContract(String contractId) {
        contractModuleService.auditSalesContract(contractId);
    }

    @Override
    public void returnSalesContract(String contractId, String backReason) {
        contractModuleService.returnSalesContract(contractId, backReason);
    }

    @Override
    public Result<SalesContractCheckViewVO> getSalesCheckContractList(SalesContractCheckQueryCndVO cnd) {
        SalesContractCheckQueryCndDTO cndDTO = iGenerator.convert(cnd, SalesContractCheckQueryCndDTO.class);
        Result<SalesContractCheckDTO> result = contractModuleService.getSalesCheckContractList(cndDTO);
        return iGenerator.convert(result, SalesContractCheckViewVO.class);
    }

    @Override
    public Result<SalesContractModuleCheckViewVO> getSalesCheckContractModuleList(Integer pageNo, Integer pageSize, String contractId) {
        Result<SalesContractModuleCheckDTO> result = contractModuleService.getSalesCheckContractModuleList(pageNo, pageSize, contractId);
        return iGenerator.convert(result, SalesContractModuleCheckViewVO.class);
    }

    @Override
    public void checkSalesContract(String contractId, String personId) {
        contractModuleService.checkSalesContract(contractId, personId);
    }

    @Override
    public Integer getUncheckedCount(String personId, boolean allPermission) {
        return contractModuleService.getUncheckedCount(personId,allPermission);
    }
}
