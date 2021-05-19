package com.bsoft.office.organ.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.organ.condition.InvoiceLibraryQueryCnd;
import com.bsoft.office.organ.condition.InvoiceRecordQueryCnd;
import com.bsoft.office.organ.vo.*;

import java.util.List;

public interface InvoiceManager {

    public Result<InvoiceLibraryVO> getInvoiceList(InvoiceLibraryQueryCnd cnd);

    public List<CompanyVO> getCompanyList();

    public List<PublicDicVO> getSourceList();

    Result<InvoiceRecordViewVO> getInvoiceRecordList(InvoiceRecordQueryCnd cnd);

    List<InvoiceContentViewVO> getInvoiceContentList(Integer invoiceRecordId);
}
