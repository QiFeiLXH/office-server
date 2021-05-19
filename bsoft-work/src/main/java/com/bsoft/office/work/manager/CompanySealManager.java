package com.bsoft.office.work.manager;

import com.bsoft.common.dto.CompanyViewDTO;
import com.bsoft.common.result.Result;
import com.bsoft.office.work.vo.CompanySealVO;
import com.bsoft.work.dto.CompanySealDTO;
import com.bsoft.work.dto.CompanySealQueryCnd;

import java.util.List;


public interface CompanySealManager {
    /**
     * 查询公司印章列表
     * @param companySealQueryCnd
     * @return
     */
    Result<CompanySealVO> getCompanySealList(CompanySealQueryCnd companySealQueryCnd);

    /**
     * 保存公司印章
     * @param companySealDTO
     */
    void saveCompanySeal(CompanySealDTO companySealDTO);

    /**
     * 根据ID获取公司公章信息
     * @param id
     */
    CompanySealVO getCompanySeal(Integer id);

    /**
     * 获取所有未注销的公司信息
     * @param
     */
    List<CompanyViewDTO> getCompanyNoCancel(String input);
}
