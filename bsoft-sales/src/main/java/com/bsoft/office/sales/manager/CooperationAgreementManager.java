package com.bsoft.office.sales.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.sales.condition.SalesAgreementQueryCndVO;
import com.bsoft.office.sales.vo.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Author Xuhui Lin
 * @Date 2020/6/30 13:21
 * @Description
 */
public interface CooperationAgreementManager {
    Result<SalesPartnerViewVO> getSalesPartnerList(String inputContent,Integer pageNo, Integer pageSize);

    Integer saveSalesPartner(SalesPartnerVO salesPartner,String provinceText, String cityText, String countyText);

    void deleteSalesPartner(Integer id);

    Result<SalesAgreementViewVO> getSalesAgreementList(SalesAgreementQueryCndVO cnds);

    void deleteSalesAgreement(Integer id);

    Map<String, Object> getDicList();

    List<SalesPartnerViewVO> getPartnerSelectList(String partnerName);

    Result<PublicWordsViewVO> getPublicWordsList(Integer pageNo, Integer pageSize, Integer mainId, Integer menuId, Integer type);

    SalesAgreementVO saveAgreement(SalesAgreementVO salesAgreementVO, String personId );

    void uploadFile(MultipartFile file, Integer agreementId, Integer menuId, String personId) throws IOException;

    PublicWordsVO downloadFile(Integer fileId, Integer wordId, String personId);

    void deleteFile(Integer fileId, Integer wordId);
}
