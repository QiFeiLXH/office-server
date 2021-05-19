package com.bsoft.office.sales.manager;

import com.bsoft.common.dto.FileServerDefinitionDTO;
import com.bsoft.common.result.Result;
import com.bsoft.office.common.exportExcel.ImportResultVO;
import com.bsoft.office.sales.condition.SalesCommisQueryCndVO;
import com.bsoft.office.sales.vo.SalesCommisImportVO;
import com.bsoft.office.sales.vo.SalesCommisViewVO;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/10/10 17:26
 * @Description:
 */
public interface SalesCommisManager {
    Result<SalesCommisViewVO> getSalesCommis(SalesCommisQueryCndVO cndVO);

    FileServerDefinitionDTO getTemplateExcel();

    ImportResultVO importSalesCommis(List<SalesCommisImportVO> list, String personId);

    void deleteSalesCommis(List<Integer> ids);

    void aduitSalesCommis(List<Integer> ids,String personId);

    List<SalesCommisImportVO> getErrorList(String personId);
}
