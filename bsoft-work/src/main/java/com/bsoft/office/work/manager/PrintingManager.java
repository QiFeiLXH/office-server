package com.bsoft.office.work.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.exportExcel.ImportResultVO;
import com.bsoft.office.work.condition.PrintingQueryCnd;
import com.bsoft.office.work.vo.PrintingDetailVO;
import com.bsoft.office.work.vo.PrintingErrorTemplateVO;
import com.bsoft.office.work.vo.PrintingTemplateVO;
import com.bsoft.office.work.vo.PrintingViewVO;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/27 15:52
 * @Description
 */
public interface PrintingManager {
    Result<PrintingViewVO> getPrintingList(PrintingQueryCnd queryCnd);

    Integer getPrintingUnpaidCount(PrintingQueryCnd queryCnd);

    Double getPrintingUnpaidAmount();

    Double getPrintingTotalAmount(List<Integer> printingIds);

    List<Integer> getPrintingIdList(PrintingQueryCnd queryCnd);

    void savePrinting(PrintingViewVO printingViewVO);

    ImportResultVO importPrintingData(List<PrintingTemplateVO> list, String personId);

    List<PrintingViewVO> applyPayPrinting(List<Integer> ids);

    void payPrinting(List<Integer> ids);

    List<PrintingErrorTemplateVO> getErrorPrintingList(String personId);

    List<PrintingDetailVO> getPrintingDetailList(Integer printingId);
}
