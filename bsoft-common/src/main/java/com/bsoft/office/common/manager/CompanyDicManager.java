package com.bsoft.office.common.manager;

import com.bsoft.common.dto.CompanyViewDTO;
import com.bsoft.office.common.vo.CompanyDicVO;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/11/30 13:33
 * @Description: 公司机构字典
 */
public interface CompanyDicManager {
    /**
     * 获取公司机构字典
     * @param type 1 费用归属，2 社保缴纳地，3 人员归属公司
     * @return
     */
    List<CompanyDicVO> getCompanyDic(Integer type);
}
