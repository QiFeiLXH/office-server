package com.bsoft.office.manager.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.manager.vo.CompanySocialMeeterVO;
import com.bsoft.office.manager.vo.CompanySocialMeeterViewVO;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/11/27 8:47
 * @Description
 */
public interface SocialSecurityManager {
    Result<CompanySocialMeeterViewVO> getCompanySocialMeeterList(String inputContent, List<Integer> socialCompanyFlag, Integer pageNo, Integer pageSize);

    void saveCompanySocialMeeter(CompanySocialMeeterVO companySocialMeeterVO);

}
