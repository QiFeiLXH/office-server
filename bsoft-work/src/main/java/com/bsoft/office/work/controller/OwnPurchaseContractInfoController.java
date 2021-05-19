package com.bsoft.office.work.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.annotation.RequiredExportLog;
import com.bsoft.office.common.condition.ExportLogParams;
import com.bsoft.office.common.exportExcel.ExportExcel;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.work.condition.OwnPurchaseContractQueryCndVO;
import com.bsoft.office.work.manager.OwnPurchaseContractManager;
import com.bsoft.office.work.vo.OwnPurchaseContractInfoViewVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author: Xuhui Lin
 * @DateTime: 2020/9/23 12:04
 * @Description: 公司自用采购合同Controller
 */
@RestController
@RequestMapping(value = "/ownpurchaseinfo")
public class OwnPurchaseContractInfoController {

    @Autowired
    private OwnPurchaseContractManager ownPurchaseContractManager;

    /**
     * 获取公司自用采购合同列表
     * @param cndVO
     * @param request
     * @return
     */
    @GetMapping(value = "/list")
    @OperLog(operType = OperLogType.QUERY,operDesc = "公司自用采购合同列表")
    public OfficeResopnseBean getOwnPurchaseContractInfoList(OwnPurchaseContractQueryCndVO cndVO, HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        cndVO.setPersonId(personId);
        Result<OwnPurchaseContractInfoViewVO> result = ownPurchaseContractManager.getOwnPurchaseContractInfoList(cndVO);
        return OfficeResopnseBean.newSuccessBean(result);
    }

    /**
     *功能描述: 采购合同导出
     */
    @PostMapping(value = "/contractdownload")
    @RequiredExportLog
    @OperLog(operType = OperLogType.EXPORT,operDesc = "采购合同导出")
    public void exportOwnPurchaseContractInfoList(@RequestBody OwnPurchaseContractQueryCndVO cndVO,
                                          ExportLogParams params,
                                          HttpServletRequest request,
                                          HttpServletResponse response){
        String personId = ContextUtils.getUserId(request);
        cndVO.setPersonId(personId);
        List<OwnPurchaseContractInfoViewVO> list = ownPurchaseContractManager.exportOwnPurchaseContractInfoList(cndVO);
        ExportExcel.export(list,OwnPurchaseContractInfoViewVO.class,"公司采购合同情况列表",response);
    }

}
