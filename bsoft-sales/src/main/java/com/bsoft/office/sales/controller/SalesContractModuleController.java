package com.bsoft.office.sales.controller;

import com.bsoft.common.result.Result;
import com.bsoft.exception.ServiceException;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.manager.AuthorityPublicManager;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.common.vo.DynamicTableHeaderVO;
import com.bsoft.office.sales.condition.ContractModuleQueryCndVO;
import com.bsoft.office.sales.condition.SalesContractQueryCndVO;
import com.bsoft.office.sales.manager.ContractModuleManager;
import com.bsoft.office.sales.vo.*;
import io.netty.util.concurrent.CompleteFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Author Xuhui Lin
 * @Date 2021/3/16 10:20
 * @Description
 */
@RestController
@RequestMapping("/salescontract")
public class SalesContractModuleController {
    @Autowired
    private ContractModuleManager contractModuleManager;
    @Autowired
    private AuthorityPublicManager authorityPublicManager;

    @GetMapping(value = "/contract")
    @OperLog(operType = OperLogType.QUERY,operDesc = "合同查询")
    public OfficeResopnseBean getSalesContractList(SalesContractQueryCndVO cnd, HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        Integer menuId = ContextUtils.getMenuId(request);
        boolean allPermission = authorityPublicManager.checkAllPermission(userId, menuId, 1);
        cnd.setPersonId(userId);
        cnd.setAllPermission(allPermission);
        Result<SalesContractViewVO> result = contractModuleManager.getSalesContractList(cnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        return responseBean;
    }

    @GetMapping(value = "/query")
    @OperLog(operType = OperLogType.QUERY,operDesc = "合同模块产品查询")
    public OfficeResopnseBean getContractModuleProductList(ContractModuleQueryCndVO cnd) {
        Map<String, Object> result = new HashMap<>();
        CompletableFuture<Result<ContractProducVO>> productFuture = CompletableFuture.supplyAsync(() -> {
            return contractModuleManager.getContractProductList(cnd);
        });
        CompletableFuture<List<ContractModuleVO>> moduleFuture = CompletableFuture.supplyAsync(() -> {
            return contractModuleManager.getContractModuleList(cnd);
        });
        CompletableFuture.allOf(productFuture, moduleFuture);
        try {
            Result<ContractProducVO> products = productFuture.get();
            List<ContractModuleVO> modules = moduleFuture.get();
            if (products.getItems().isEmpty() || modules.isEmpty()) {
                result.put("product", new Result<>());
                result.put("module", new ArrayList<>());
            } else {
                result.put("product", products);
                result.put("module", modules);
            }
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }

        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        return responseBean;
    }


    @GetMapping(value = "/product")
    @OperLog(operType = OperLogType.QUERY,operDesc = "合同产品查询")
    public OfficeResopnseBean getContractProductList(ContractModuleQueryCndVO cnd) {
        Result<ContractProducVO> result = contractModuleManager.getContractProductList(cnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        return responseBean;
    }

    @GetMapping(value = "/module")
    @OperLog(operType = OperLogType.QUERY,operDesc = "合同模块查询")
    public OfficeResopnseBean getContractModuleList(ContractModuleQueryCndVO cnd) {
        List<ContractModuleVO> list = contractModuleManager.getContractModuleList(cnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(list);
        return responseBean;
    }

    @PostMapping(value = "/save")
    @OperLog(operType = OperLogType.SAVE,operDesc = "合同模块保存")
    public OfficeResopnseBean saveContractProductModuleRelation(@RequestBody ContractModuleProductSaveVO contractModuleProductSaveVO, HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        contractModuleManager.saveContractProductModuleRelation(contractModuleProductSaveVO,userId);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody("保存成功！");
        return responseBean;
    }

    @PostMapping(value = "/commit")
    @OperLog(operType = OperLogType.SAVE,operDesc = "合同模块提交")
    public OfficeResopnseBean commitContractProductModuleRelation(@RequestBody ContractModuleProductSaveVO contractModuleProductSaveVO, HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        Integer result = contractModuleManager.commitContractProductModuleRelation(contractModuleProductSaveVO,userId);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        return responseBean;
    }


    @GetMapping(value = "/header")
    @OperLog(operType = OperLogType.QUERY,operDesc = "合同模块表头")
    public OfficeResopnseBean getContractModuleHeader(SalesContractQueryCndVO cndVO) {
        List<DynamicTableHeaderVO> headers = contractModuleManager.getContractModuleHeader(cndVO);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(headers);
        return responseBean;
    }

    @GetMapping(value = "/modulelist")
    @OperLog(operType = OperLogType.QUERY,operDesc = "合同模块列表")
    public OfficeResopnseBean getSalesContractModuleList(SalesContractQueryCndVO cndVO) {
        List<SalesContractModuleViewVO> list = contractModuleManager.getSalesContractModuleList(cndVO);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(list);
        return responseBean;
    }
}
