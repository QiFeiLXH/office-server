package com.bsoft.office.hr.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.vo.PublicDicVO;
import com.bsoft.office.hr.condition.CertificateOriginalScriptQueryCnd;
import com.bsoft.office.hr.vo.CertificateOriginalScriptVO;
import com.bsoft.work.dto.OriginalCertificateDTO;

import java.util.List;

/**
 * @author: zy
 * @date: 2020/9/10
 * @description 证书原件管理
 */
public interface CertificateOriginalScriptManager {
    CertificateOriginalScriptVO getByName(String userId, String name);
    Result<CertificateOriginalScriptVO> listCertificateOriginalScripts(String userId, CertificateOriginalScriptQueryCnd queryCnd);
    void save(String userId, CertificateOriginalScriptVO saveVO);
    void update(String userId, CertificateOriginalScriptVO updateVO);
    List<PublicDicVO> listCertType(String userId);
}
