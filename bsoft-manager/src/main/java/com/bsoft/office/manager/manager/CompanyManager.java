package com.bsoft.office.manager.manager;

import com.bsoft.office.common.vo.PublicDicVO;
import com.bsoft.office.manager.vo.CompanyViewVO;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/11/26 11:12
 * @Description:
 */
public interface CompanyManager {
    List<CompanyViewVO> getCompanyList();
    CompanyViewVO saveCompany(CompanyViewVO companyViewVO);
    List<PublicDicVO> getPurposeList();
    CompanyViewVO getCompany(Integer id);
    List<CompanyViewVO> getNotCancelledCompany();
    void doCancle(Integer companyId);
}
