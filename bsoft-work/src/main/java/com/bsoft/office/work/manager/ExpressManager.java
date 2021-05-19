package com.bsoft.office.work.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.exportExcel.ImportResultVO;
import com.bsoft.office.work.condition.ExpressQueryCnd;
import com.bsoft.office.work.vo.ExpressDetailErrorTemplateVO;
import com.bsoft.office.work.vo.ExpressDetailTemplateVO;
import com.bsoft.office.work.vo.ExpressDetailViewVO;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/12/30 15:12
 * @Description
 */
public interface ExpressManager {
    Result<ExpressDetailViewVO> getExpressList(ExpressQueryCnd queryCnd);

    Integer getExpressUnpaidCount(ExpressQueryCnd queryCnd);

    Double getExpressUnpaidAmount();

    Double getExpressTotalAmount(List<Integer> expressIds);

    List<Integer> getExpressIdList(ExpressQueryCnd queryCnd);

    ImportResultVO importExpressData(List<ExpressDetailTemplateVO> list, String personId);

    List<ExpressDetailViewVO> getExpressList(List<Integer> ids);

    List<ExpressDetailViewVO> applyPayExpressDetail(List<Integer> ids);

    void payExpressDetail(List<Integer> ids);

    List<ExpressDetailErrorTemplateVO> getErrorExpressDetailList(String personId);

    void saveExpressDetail(ExpressDetailViewVO expressDetail);
}
