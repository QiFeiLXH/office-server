package com.bsoft.office.hr.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.exportExcel.ImportResultVO;
import com.bsoft.office.hr.condition.PersonStockQueryCnd;
import com.bsoft.office.hr.vo.PersonStockErrorTemplateVO;
import com.bsoft.office.hr.vo.PersonStockTemplateVO;
import com.bsoft.office.hr.vo.PersonStockViewVO;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/14 10:16
 * @Description
 */
public interface PersonStockManager {
    Result<PersonStockViewVO> getPersonStockList(PersonStockQueryCnd cnd);

    void logoutOnePersonStock(Integer id);

    void batchLogoutPersonStocks(List<Integer> ids);

    void savePersonStock(PersonStockViewVO personStock);

    ImportResultVO importPersonStockData(List<PersonStockTemplateVO> list, String personId);

    List<PersonStockErrorTemplateVO> getErrorPersonStockList(String personId);

    List<PersonStockViewVO> getAllPersonStockList(PersonStockQueryCnd cnd);
}
