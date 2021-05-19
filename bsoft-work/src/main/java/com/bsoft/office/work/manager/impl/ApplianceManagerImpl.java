package com.bsoft.office.work.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.common.manager.CostDicManager;
import com.bsoft.office.common.vo.CostDicVO;
import com.bsoft.office.work.condition.ApplianceNameQueryCnd;
import com.bsoft.office.work.vo.ApplianceNameVO;
import com.bsoft.sales.dto.CustomerContactsDTO;
import com.bsoft.sales.service.CustomerContactsService;
import com.bsoft.office.work.condition.ApplianceQueryCnd;
import com.bsoft.work.dto.*;
import com.bsoft.office.work.manager.ApplianceManager;
import com.bsoft.work.service.ApplianceService;
import com.bsoft.office.work.vo.ApplianceStockVO;
import com.bsoft.office.work.vo.ApplianceUseVO;
import com.bsoft.office.work.vo.CustomerContactVO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author: zy
 * @date: 2020/11/5
 * @description 办公用品入库
 */
@Component
public class ApplianceManagerImpl implements ApplianceManager {

    @Autowired
    private IGenerator iGenerator;
    @Reference
    private ApplianceService applianceService;
    @Autowired
    private CostDicManager costDicManager;
    @Reference
    private CustomerContactsService customerContactsService;

    @Override
    public Result<ApplianceStockVO> getApplianceStockList(String userId, ApplianceQueryCnd queryCnd) {
        ApplianceQueryCndDTO queryCndDTO = iGenerator.convert(queryCnd, ApplianceQueryCndDTO.class);
        Result<ApplianceStockDTO> result = applianceService.getApplianceStockList(userId, queryCndDTO);
        return iGenerator.convert(result, ApplianceStockVO.class);
    }

    @Override
    public List<ApplianceUseVO> getApplianceUseDetail(String userId, Integer stockId) {
        List<ApplianceUseDTO> resultDTO = applianceService.getApplianceUseDetail(userId, stockId);
        return iGenerator.convert(resultDTO, ApplianceUseVO.class);
    }

    @Override
    public void saveApplianceStock(String userId, ApplianceStockVO saveVO) {
        ApplianceStockDTO saveDTO = iGenerator.convert(saveVO, ApplianceStockDTO.class);
        applianceService.saveApplianceStock(userId, saveDTO);
    }

    @Override
    public void submitApplianceStock(String userId, ApplianceStockVO saveVO) {
        ApplianceStockDTO saveDTO = iGenerator.convert(saveVO, ApplianceStockDTO.class);
        applianceService.submitApplianceStock(userId, saveDTO);
    }

    @Override
    public List<CostDicVO> getApplianceNameSelectList(Integer applianceType, String inputContent) {
        List<CostDicVO> list = costDicManager.getCostDicList(2, applianceType, 0, inputContent);
        return list;
    }

    @Override
    public Result<CustomerContactVO> getCustomerContactList(Integer pageNo, Integer pageSize, String inputContent) {
        Result<CustomerContactsDTO> result = customerContactsService.getCustomerContactsList(pageNo, pageSize, inputContent);
        return iGenerator.convert(result, CustomerContactVO.class);
    }

    @Override
    public Double countApplianceUnPayMoney(String userId, Integer type) {
        return applianceService.countApplianceUnPayMoney(userId, type);
    }

    @Override
    public Result<ApplianceUseVO> getApplianceUseList(String userId, ApplianceQueryCnd queryCnd) {
        ApplianceQueryCndDTO queryCndDTO = iGenerator.convert(queryCnd, ApplianceQueryCndDTO.class);
        Result<ApplianceUseDTO> result = applianceService.getApplianceUseList(userId, queryCndDTO);
        return iGenerator.convert(result, ApplianceUseVO.class);
    }

    @Override
    public Result<ApplianceStockVO> getApplianceStoreList(String userId, ApplianceQueryCnd queryCnd) {
        ApplianceQueryCndDTO queryCndDTO = iGenerator.convert(queryCnd, ApplianceQueryCndDTO.class);
        Result<ApplianceStoreDTO> result = applianceService.getApplianceStoreList(userId, queryCndDTO);
        return iGenerator.convert(result, ApplianceStockVO.class);
    }

    @Override
    public Result<ApplianceNameVO> getApplianceNameList(String userId, ApplianceNameQueryCnd queryCnd) {
//        ApplianceNameQueryCndDTO queryCndDTO = iGenerator.convert(queryCnd, ApplianceNameQueryCndDTO.class);
//        Result<ApplianceNameDTO> result = applianceService.getApplianceNameList(userId, queryCndDTO);
//        return iGenerator.convert(result, ApplianceNameVO.class);
        return null;
    }

    @Override
    public void saveApplianceName(String userId, ApplianceNameVO saveVO) {
//        ApplianceNameDTO saveDTO = iGenerator.convert(saveVO, ApplianceNameDTO.class);
//        applianceService.saveApplianceName(userId, saveDTO);

    }

}
