package com.bsoft.office.hr.manager.impl;

import com.bsoft.common.dto.PublicDicDTO;
import com.bsoft.common.result.Result;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.common.vo.PublicDicVO;
import com.bsoft.office.hr.condition.CertificateOriginalScriptQueryCnd;
import com.bsoft.office.hr.manager.CertificateOriginalScriptManager;
import com.bsoft.office.hr.vo.CertificateOriginalScriptVO;
import com.bsoft.work.dto.OriginalCertificateDTO;
import com.bsoft.work.dto.OriginalCertificateQueryCndDTO;
import com.bsoft.work.service.OriginalCertificateService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: zy
 * @date: 2020/9/10
 * @description 证书原件管理
 */
@Component
public class CertificateOriginalScriptManagerImpl implements CertificateOriginalScriptManager {
    @Reference
    private OriginalCertificateService originalCertificateService;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public CertificateOriginalScriptVO getByName(String userId, String name) {
        OriginalCertificateDTO certDTO = originalCertificateService.getByName(userId, name);
        return iGenerator.convert(certDTO, CertificateOriginalScriptVO.class);
    }

    @Override
    public Result<CertificateOriginalScriptVO> listCertificateOriginalScripts(String userId, CertificateOriginalScriptQueryCnd queryCnd) {
        OriginalCertificateQueryCndDTO queryCndDTO = iGenerator.convert(queryCnd, OriginalCertificateQueryCndDTO.class);
        Result<OriginalCertificateDTO> resultDTO = originalCertificateService.listByLimits(userId, queryCndDTO);
        return iGenerator.convert(resultDTO, CertificateOriginalScriptVO.class);
    }

    @Override
    public void save(String userId, CertificateOriginalScriptVO saveVO) {
        OriginalCertificateDTO saveDTO = iGenerator.convert(saveVO, OriginalCertificateDTO.class);
        originalCertificateService.save(userId, saveDTO);
    }

    @Override
    public void update(String userId, CertificateOriginalScriptVO updateVO) {
        OriginalCertificateDTO updateDTO = iGenerator.convert(updateVO, OriginalCertificateDTO.class);
        originalCertificateService.update(userId, updateDTO);
    }

    @Override
    public List<PublicDicVO> listCertType(String userId) {
        List<PublicDicDTO> certTypeDTOList =  originalCertificateService.listCertType(userId);
        return iGenerator.convert(certTypeDTOList, PublicDicVO.class);
    }
}
