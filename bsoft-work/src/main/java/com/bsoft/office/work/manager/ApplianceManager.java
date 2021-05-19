package com.bsoft.office.work.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.vo.CostDicVO;
import com.bsoft.office.work.condition.ApplianceNameQueryCnd;
import com.bsoft.office.work.condition.ApplianceQueryCnd;
import com.bsoft.office.work.vo.ApplianceStockVO;
import com.bsoft.office.work.vo.ApplianceNameVO;
import com.bsoft.office.work.vo.ApplianceUseVO;
import com.bsoft.office.work.vo.CustomerContactVO;

import java.util.List;

/**
 * @author: zy
 * @date: 2020/11/5
 * @description 办公用品入库
 */
public interface ApplianceManager {
    Result<ApplianceStockVO> getApplianceStockList(String uerId, ApplianceQueryCnd queryCnd);

    List<ApplianceUseVO> getApplianceUseDetail(String userId, Integer stockId);

    void saveApplianceStock(String userId, ApplianceStockVO saveVO);

    void submitApplianceStock(String userId, ApplianceStockVO saveVO);

    List<CostDicVO> getApplianceNameSelectList(Integer type, String inputContent);

    Result<CustomerContactVO> getCustomerContactList(Integer pageNo, Integer pageSize, String inputContent);

    Double countApplianceUnPayMoney(String userId, Integer type);

    /**
     * 获取行政物品领用列表
     * @param userId
     * @param queryCnd
     * @return
     */
    Result<ApplianceUseVO> getApplianceUseList(String userId, ApplianceQueryCnd queryCnd);

    /**
     * 获取行政物品库存列表
     * @param userId
     * @param queryCnd
     * @return
     */
    Result<ApplianceStockVO> getApplianceStoreList(String userId, ApplianceQueryCnd queryCnd);

    /**
     * 获取行政用品名称列表
     * @param userId
     * @param queryCnd
     * @return
     */
    Result<ApplianceNameVO> getApplianceNameList(String userId, ApplianceNameQueryCnd queryCnd);

    /**
     * 保存行政用品名称信息
     * @param userId
     */
    void saveApplianceName(String userId, ApplianceNameVO saveVO);
}
