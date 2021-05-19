package com.bsoft.office.hr.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.annotation.RequiredExportLog;
import com.bsoft.office.common.condition.ExportLogParams;
import com.bsoft.office.common.exportExcel.ExportExcel;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.hr.condition.PersonTransferConditionQueryCndVO;
import com.bsoft.office.hr.manager.PersonTransferManager;
import com.bsoft.office.hr.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/12/30 11:09
 * @Description: 人员调动 Controller
 */
@RestController
@RequestMapping("/transfercondition")
public class PersonTransferConditionController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonTransferConditionController.class);

    @Autowired
    private PersonTransferManager personTransferManager;

//    @GetMapping(value = "/getPersonTransferCondition")
    @RequestMapping(value="/getPersonTransferCondition",method=RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询员工调动情况")
    public OfficeResopnseBean getPersonTransferCondition(PersonTransferConditionQueryCndVO cndVO){
        Result<PersonTransferConditionVO> result = personTransferManager.getPersonTransferCondition(cndVO);
        return OfficeResopnseBean.newSuccessBean(result);
    }

    @GetMapping("/exportdownload")
    @RequiredExportLog
    @OperLog(operType = OperLogType.EXPORT,operDesc = "导出员工调动信息")
    public void exportAllPersonTransfer(ExportLogParams params,
                                      PersonTransferConditionQueryCndVO cndVO,
                                      HttpServletResponse response){
        List<PersonTransferConditionVO> result = personTransferManager.getExcelPersonTransferCondition(cndVO);
        System.out.println(result);
        ExportExcel.doExport(result,PersonTransferConditionVO.class,"员工调动信息",response);
        LOGGER.info("导出员工股份信息成功！");
    }



}
