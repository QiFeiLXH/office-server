package com.bsoft.office.organ.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.organ.vo.AccountCaliberVO;

import java.util.List;
import java.util.Map;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/4 11:24
 * @Description
 */
public interface AccountCaliberManager {
    Result<AccountCaliberVO> getDpetAccountCaliberList(Integer pageSize, Integer pageNo, Integer year, String deptId, Integer deptType,Integer accountCaliber);

    Map<String, Object> getAccountCaliberDic();

    void saveYearlyDeptAccountCaliber(Integer year);

    void saveDeptAccountCaliber(List<Integer> caliberSaves, List<Integer> caliberDeletes, String deptId, Integer year);
}
