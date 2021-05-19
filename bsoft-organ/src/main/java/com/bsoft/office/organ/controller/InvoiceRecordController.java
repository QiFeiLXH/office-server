package com.bsoft.office.organ.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.organ.condition.InvoiceRecordQueryCnd;
import com.bsoft.office.organ.manager.InvoiceManager;
import com.bsoft.office.organ.vo.InvoiceContentViewVO;
import com.bsoft.office.organ.vo.InvoiceRecordViewVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @Author Xuhui Lin
 * @Date 2020/9/15 11:07
 * @Description 财务开票
 */
@RestController
@RequestMapping("/invoicing")
public class InvoiceRecordController {
    private static final Logger LOGGER = LoggerFactory.getLogger(InvoiceRecordController.class);

    @Autowired
    private InvoiceManager invoiceManager;

    /**
     *功能描述: 开票记录查询
     */
    @GetMapping(value = "/recordquery")
    @OperLog(operType = OperLogType.QUERY,operDesc = "开票记录列表")
    public OfficeResopnseBean getInvoiceRecordList(InvoiceRecordQueryCnd cnd){
        Result<InvoiceRecordViewVO> result = invoiceManager.getInvoiceRecordList(cnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        LOGGER.info("获取开票记录列表成功！[{}]", JSONUtils.toString(result));
        return responseBean;
    }

    /**
     *功能描述: 开票内容查询
     */
    @GetMapping(value = "/contentquery")
    @OperLog(operType = OperLogType.QUERY,operDesc = "开票内容查询")
    public OfficeResopnseBean getInvoiceContentList(@RequestParam("invoiceRecordId") Integer invoiceRecordId){
        List<InvoiceContentViewVO> list = invoiceManager.getInvoiceContentList(invoiceRecordId);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(list);
        LOGGER.info("获取开票内容列表成功！[{}]", JSONUtils.toString(list));
        return responseBean;
    }

}
