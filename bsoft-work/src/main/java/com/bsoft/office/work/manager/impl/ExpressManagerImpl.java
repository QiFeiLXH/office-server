package com.bsoft.office.work.manager.impl;

import com.bsoft.common.dto.ImportResultDTO;
import com.bsoft.common.result.Result;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.common.exportExcel.ImportResultVO;
import com.bsoft.office.work.condition.ExpressQueryCnd;
import com.bsoft.office.work.manager.ExpressManager;
import com.bsoft.office.work.vo.ExpressDetailErrorTemplateVO;
import com.bsoft.office.work.vo.ExpressDetailTemplateVO;
import com.bsoft.office.work.vo.ExpressDetailViewVO;
import com.bsoft.work.dto.ExpressDetailDTO;
import com.bsoft.work.dto.ExpressQueryCndDTO;
import com.bsoft.work.service.ExpressService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/12/30 15:12
 * @Description
 */
@Service
public class ExpressManagerImpl implements ExpressManager {
    @Reference
    private ExpressService expressService;
    @Autowired
    private IGenerator iGenerator;
    @Override
    public Result<ExpressDetailViewVO> getExpressList(ExpressQueryCnd queryCnd) {
        ExpressQueryCndDTO cnd = iGenerator.convert(queryCnd, ExpressQueryCndDTO.class);
        Result<ExpressDetailDTO> result = expressService.getExpressList(cnd);
        return iGenerator.convert(result, ExpressDetailViewVO.class);
    }

    @Override
    public Integer getExpressUnpaidCount(ExpressQueryCnd queryCnd) {
        ExpressQueryCndDTO cnd = iGenerator.convert(queryCnd, ExpressQueryCndDTO.class);
        return expressService.getExpressUnpaidCount(cnd);
    }

    @Override
    public Double getExpressUnpaidAmount() {
        return expressService.getExpressUnpaidAmount();
    }

    @Override
    public Double getExpressTotalAmount(List<Integer> expressIds) {
        return expressService.getExpressTotalAmount(expressIds);
    }

    @Override
    public List<Integer> getExpressIdList(ExpressQueryCnd queryCnd) {
        ExpressQueryCndDTO cnd = iGenerator.convert(queryCnd, ExpressQueryCndDTO.class);
        return expressService.getExpressIdList(cnd);
    }

    @Override
    public ImportResultVO importExpressData(List<ExpressDetailTemplateVO> list, String personId) {
        List<ExpressDetailTemplateVO> needSaveData = new ArrayList<>();
        List<ExpressDetailTemplateVO> errorData = new ArrayList<>();
        // 数据处理
        list.forEach(expressDetailTemplateVO -> {
            try{
                expressDetailTemplateVO.setApproval(new BigDecimal(expressDetailTemplateVO.getApprovalStr()).doubleValue());
                needSaveData.add(expressDetailTemplateVO);
            } catch (Exception e) {
                errorData.add(expressDetailTemplateVO);
            }
        });
        List<ExpressDetailDTO> needSaveDataDTO = iGenerator.convert(needSaveData, ExpressDetailDTO.class);
        List<ExpressDetailDTO> errorDataDTO = iGenerator.convert(errorData, ExpressDetailDTO.class);
        ImportResultDTO result = expressService.saveExpressDetails(needSaveDataDTO, errorDataDTO, personId);
        return iGenerator.convert(result, ImportResultVO.class);
    }

    @Override
    public List<ExpressDetailViewVO> getExpressList(List<Integer> ids) {
        return iGenerator.convert(expressService.getExpressList(ids), ExpressDetailViewVO.class);
    }

    @Override
    public List<ExpressDetailViewVO> applyPayExpressDetail(List<Integer> ids) {
        List<ExpressDetailDTO> expressDetailDTOS = expressService.updateExpressApplyPay(ids);
        return iGenerator.convert(expressDetailDTOS, ExpressDetailViewVO.class);
    }

    @Override
    public void payExpressDetail(List<Integer> ids) {
        expressService.updateExpressPay(ids);
    }


    @Override
    public List<ExpressDetailErrorTemplateVO> getErrorExpressDetailList(String personId) {
        List<ExpressDetailDTO> list = expressService.getErrorExpressList(personId);
        return iGenerator.convert(list, ExpressDetailErrorTemplateVO.class);
    }

    @Override
    public void saveExpressDetail(ExpressDetailViewVO expressDetail) {
        ExpressDetailDTO expressDetailDTO = iGenerator.convert(expressDetail, ExpressDetailDTO.class);
        expressService.saveExpressDetail(expressDetailDTO);
    }
}
