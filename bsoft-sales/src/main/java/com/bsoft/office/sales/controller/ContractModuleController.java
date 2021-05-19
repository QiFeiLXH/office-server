package com.bsoft.office.sales.controller;

import com.bsoft.common.result.Result;
import com.bsoft.exception.ServiceException;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.sales.condition.ContractModuleQueryCndVO;
import com.bsoft.office.sales.manager.ContractModuleManager;
import com.bsoft.office.sales.vo.ContractModuleProductSaveVO;
import com.bsoft.office.sales.vo.ContractModuleProductVO;
import com.bsoft.office.sales.vo.ContractModuleVO;
import com.bsoft.office.sales.vo.ContractProducVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * @Author Xuhui Lin
 * @Date 2021/3/3 13:06
 * @Description
 */
@RestController
@RequestMapping("/contractmodule")
public class ContractModuleController {
    @Autowired
    private ContractModuleManager contractModuleManager;

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

}
