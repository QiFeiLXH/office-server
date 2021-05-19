package com.bsoft.office.work.manager.impl;

import com.bsoft.common.dto.ImportResultDTO;
import com.bsoft.common.result.Result;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.common.exportExcel.ImportResultVO;
import com.bsoft.office.work.condition.PrintingQueryCnd;
import com.bsoft.office.work.manager.PrintingManager;
import com.bsoft.office.work.vo.PrintingDetailVO;
import com.bsoft.office.work.vo.PrintingErrorTemplateVO;
import com.bsoft.office.work.vo.PrintingTemplateVO;
import com.bsoft.office.work.vo.PrintingViewVO;
import com.bsoft.work.dto.PrintingDTO;
import com.bsoft.work.dto.PrintingDetailDTO;
import com.bsoft.work.dto.PrintingQueryCndDTO;
import com.bsoft.work.service.PrintingService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/27 15:58
 * @Description
 */
@Service
public class PrintingManagerImpl implements PrintingManager {
    @Reference
    private PrintingService printingService;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public Result<PrintingViewVO> getPrintingList(PrintingQueryCnd queryCnd) {
        PrintingQueryCndDTO cnd = iGenerator.convert(queryCnd, PrintingQueryCndDTO.class);
        Result<PrintingDTO> result = printingService.getPrintingList(cnd);
        return iGenerator.convert(result, PrintingViewVO.class);
    }

    @Override
    public Integer getPrintingUnpaidCount(PrintingQueryCnd queryCnd) {
        PrintingQueryCndDTO cnd = iGenerator.convert(queryCnd, PrintingQueryCndDTO.class);
        return printingService.getPrintingUnpaidCount(cnd);
    }

    @Override
    public Double getPrintingUnpaidAmount() {
        return printingService.getPrintingUnpaidAmount();
    }

    @Override
    public Double getPrintingTotalAmount(List<Integer> printingIds) {
        return printingService.getPrintingTotalAmount(printingIds);
    }

    @Override
    public List<Integer> getPrintingIdList(PrintingQueryCnd queryCnd) {
        PrintingQueryCndDTO cnd = iGenerator.convert(queryCnd, PrintingQueryCndDTO.class);
        return printingService.getPrintingIdList(cnd);
    }

    @Override
    public void savePrinting(PrintingViewVO printingViewVO) {
        PrintingDTO dto = iGenerator.convert(printingViewVO, PrintingDTO.class);
        printingService.savePrinting(dto);
    }

    @Override
    public ImportResultVO importPrintingData(List<PrintingTemplateVO> list, String personId) {
        List<PrintingTemplateVO> needSaveData = new ArrayList<>();
        List<PrintingTemplateVO> errorData = new ArrayList<>();
        // 数据处理
        list.forEach(printingTemplateVO -> {
            try{
                printingTemplateVO.setApproval(new BigDecimal(printingTemplateVO.getApprovalStr()).doubleValue());
                needSaveData.add(printingTemplateVO);
            } catch (Exception e) {
                printingTemplateVO.setFailureReason("订单金额格式不正确");
                errorData.add(printingTemplateVO);
            }
        });
        List<PrintingDTO> needSaveDataDTO = iGenerator.convert(needSaveData, PrintingDTO.class);
        List<PrintingDTO> errorDataDTO = iGenerator.convert(errorData, PrintingDTO.class);
        ImportResultDTO result = printingService.savePrintings(needSaveDataDTO, errorDataDTO, personId);
        return iGenerator.convert(result, ImportResultVO.class);
    }

    @Override
    public List<PrintingViewVO> applyPayPrinting(List<Integer> ids) {
        List<PrintingDTO> list = printingService.updatePrintingApplyPay(ids);
        return iGenerator.convert(list, PrintingViewVO.class);
    }

    @Override
    public void payPrinting(List<Integer> ids) {
        printingService.updatePrintingPay(ids);
    }

    @Override
    public List<PrintingErrorTemplateVO> getErrorPrintingList(String personId) {
        List<PrintingDTO> list = printingService.getErrorPrintingList(personId);
        return iGenerator.convert(list, PrintingErrorTemplateVO.class);
    }

    @Override
    public List<PrintingDetailVO> getPrintingDetailList(Integer printingId) {
        List<PrintingDetailDTO> list = printingService.getPrintingDetailList(printingId);
        return iGenerator.convert(list, PrintingDetailVO.class);
    }
}
