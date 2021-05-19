package com.bsoft.office.organ.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.manager.CompanyDicManager;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.vo.CompanyDicVO;
import com.bsoft.office.organ.condition.InvoiceLibraryQueryCnd;
import com.bsoft.office.organ.manager.InvoiceManager;
import com.bsoft.office.organ.vo.CompanyVO;
import com.bsoft.office.organ.vo.InvoiceLibraryVO;
import com.bsoft.office.organ.vo.PublicDicVO;
import com.bsoft.office.common.response.OfficeResopnseBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 票据库
 */
@RestController
@RequestMapping(value = "/invoice")
public class InvoiceController {
    private static final Logger logger = LoggerFactory.getLogger(InvoiceController.class);

    @Autowired
    private InvoiceManager invoiceManager;
    @Autowired
    private CompanyDicManager companyDicManager;

    @RequestMapping(value = "invoicelist",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询票据库列表")
    public OfficeResopnseBean getInvoiceList(@RequestBody InvoiceLibraryQueryCnd cnd){
        Result<InvoiceLibraryVO> result = invoiceManager.getInvoiceList(cnd);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(result);
        return bean;
    }

    @RequestMapping(value = "sourcelist",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询票据库数据来源")
    public OfficeResopnseBean getSourceList(){
        List<PublicDicVO> publicDicVOS = invoiceManager.getSourceList();
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(publicDicVOS);
        return bean;
    }

    @RequestMapping(value = "companylist",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询票据归属公司")
    public OfficeResopnseBean getCompanyList(){
        List<CompanyDicVO> companyVOS = companyDicManager.getCompanyDic(1);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(companyVOS);
        return bean;
    }
}
