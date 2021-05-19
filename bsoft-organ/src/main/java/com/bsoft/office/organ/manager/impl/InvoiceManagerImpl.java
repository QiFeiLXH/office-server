package com.bsoft.office.organ.manager.impl;

import com.bsoft.common.dto.CompanyDTO;
import com.bsoft.common.dto.PublicDicDTO;
import com.bsoft.common.result.Result;
import com.bsoft.common.service.PublicDicService;
import com.bsoft.cost.dto.*;
import com.bsoft.cost.service.InvoiceLibraryService;
import com.bsoft.cost.service.InvoiceRecordService;
import com.bsoft.office.organ.condition.InvoiceLibraryQueryCnd;
import com.bsoft.office.organ.condition.InvoiceRecordQueryCnd;
import com.bsoft.office.organ.manager.InvoiceManager;
import com.bsoft.office.common.dozer.GeneratorUtil;
import com.bsoft.office.organ.vo.*;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InvoiceManagerImpl implements InvoiceManager {
    @Autowired
    private GeneratorUtil generatorUtil;
    @Reference
    private InvoiceLibraryService invoiceLibraryService;
    @Reference
    private PublicDicService publicDicService;
    @Reference(timeout = 60000)
    private InvoiceRecordService invoiceRecordService;

    @Override
    public Result<InvoiceLibraryVO> getInvoiceList(InvoiceLibraryQueryCnd cnd) {
        InvoiceLibraryQueryCndDTO cndDTO = generatorUtil.convert(cnd,InvoiceLibraryQueryCndDTO.class);
        Result<InvoiceLibraryDTO> result =  invoiceLibraryService.getInvoiceLibraryList(cndDTO);
        return generatorUtil.convert(result,InvoiceLibraryVO.class);
    }

    @Override
    public List<CompanyVO> getCompanyList() {
        List<CompanyDTO> companyDTOS = invoiceLibraryService.getCompanyList();
        return generatorUtil.convert(companyDTOS,CompanyVO.class);
    }

    @Override
    public List<PublicDicVO> getSourceList() {
        List<PublicDicDTO> publicInfoDTOS = publicDicService.getPublicDic(3508);
        return generatorUtil.convert(publicInfoDTOS,PublicDicVO.class);
    }

    @Override
    public Result<InvoiceRecordViewVO> getInvoiceRecordList(InvoiceRecordQueryCnd cnd) {
        InvoiceRecordQueryCndDTO cndDTO = generatorUtil.convert(cnd, InvoiceRecordQueryCndDTO.class);
        Result<InvoiceRecordDTO> result = invoiceRecordService.getInvoiceRecordList(cndDTO);
        return generatorUtil.convert(result, InvoiceRecordViewVO.class);
    }

    @Override
    public List<InvoiceContentViewVO> getInvoiceContentList(Integer invoiceRecordId) {
        List<InvoiceContentDTO> list = invoiceRecordService.getInvoiceContentList(invoiceRecordId);
        return generatorUtil.convert(list, InvoiceContentViewVO.class);
    }
}
