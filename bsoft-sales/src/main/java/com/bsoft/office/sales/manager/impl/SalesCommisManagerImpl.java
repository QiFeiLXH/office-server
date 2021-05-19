package com.bsoft.office.sales.manager.impl;

import com.bsoft.common.dto.FileServerDefinitionDTO;
import com.bsoft.common.dto.ImportResultDTO;
import com.bsoft.common.result.Result;
import com.bsoft.common.service.FileServerService;
import com.bsoft.office.common.dozer.GeneratorUtil;
import com.bsoft.office.common.exportExcel.ImportResultVO;
import com.bsoft.office.sales.condition.SalesCommisQueryCndVO;
import com.bsoft.office.sales.manager.SalesCommisManager;
import com.bsoft.office.sales.vo.SalesCommisImportVO;
import com.bsoft.office.sales.vo.SalesCommisViewVO;
import com.bsoft.sales.dto.SalesCommisImportDTO;
import com.bsoft.sales.dto.SalesCommisQueryCndDTO;
import com.bsoft.sales.dto.SalesCommisViewDTO;
import com.bsoft.sales.service.SalesCommisService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/10/10 17:28
 * @Description:
 */
@Service
public class SalesCommisManagerImpl implements SalesCommisManager {
    @Reference(timeout = 60000)
    private SalesCommisService salesCommisService;
    @Autowired
    private GeneratorUtil generatorUtil;
    @Reference
    private FileServerService fileServerService;
    private static final Integer FILEID = 4187;

    @Override
    public Result<SalesCommisViewVO> getSalesCommis(SalesCommisQueryCndVO cndVO) {
        SalesCommisQueryCndDTO cndDTO = generatorUtil.convert(cndVO,SalesCommisQueryCndDTO.class);
        if (cndDTO.getAll() == null){
            cndDTO.setAll(0);
        }
        Result<SalesCommisViewDTO> salesCommisViewDTOResult = salesCommisService.getSalesCommis(cndDTO);
        return generatorUtil.convert(salesCommisViewDTOResult,SalesCommisViewVO.class);
    }

    @Override
    public FileServerDefinitionDTO getTemplateExcel() {
        FileServerDefinitionDTO fileServerDefinitionDTO = fileServerService.get(FILEID);
        return fileServerDefinitionDTO;
    }

    @Override
    public ImportResultVO importSalesCommis(List<SalesCommisImportVO> list, String personId) {
        List<SalesCommisImportDTO> salesCommisImportDTOS = generatorUtil.convert(list,SalesCommisImportDTO.class);
        ImportResultDTO importResultDTO = salesCommisService.importSalesCommis(salesCommisImportDTOS,personId);
        return generatorUtil.convert(importResultDTO,ImportResultVO.class);
    }

    @Override
    public void deleteSalesCommis(List<Integer> ids) {
        salesCommisService.deleteSalesCommis(ids);
    }

    @Override
    public void aduitSalesCommis(List<Integer> ids, String personId) {
        salesCommisService.aduitSalesCommis(ids,personId);
    }

    @Override
    public List<SalesCommisImportVO> getErrorList(String personId) {
        List<SalesCommisImportDTO> list = salesCommisService.getImportError(personId);
        return generatorUtil.convert(list,SalesCommisImportVO.class);
    }
}
