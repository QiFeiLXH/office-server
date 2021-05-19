package com.bsoft.office.organ.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.common.service.PublicDicService;
import com.bsoft.cost.dto.AccountCaliberDTO;
import com.bsoft.cost.service.AccountCaliberService;
import com.bsoft.office.organ.manager.AccountCaliberManager;
import com.bsoft.office.organ.vo.AccountCaliberVO;
import com.bsoft.office.organ.vo.PublicDicVO;
import com.bsoft.office.common.dozer.IGenerator;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/4 11:24
 * @Description
 */
@Service
public class AccountCaliberManagerImpl implements AccountCaliberManager {
    @Reference(timeout = 60000)
    private AccountCaliberService accountCaliberService;
    @Reference
    private PublicDicService publicDicService;

    @Autowired
    private IGenerator iGenerator;

    @Override
    public Result<AccountCaliberVO> getDpetAccountCaliberList(Integer pageSize, Integer pageNo, Integer year, String deptId, Integer deptType,Integer accountCaliber) {
        Result<AccountCaliberDTO> result = accountCaliberService.getDpetAccountCaliberList(pageNo, pageSize, year, accountCaliber, deptId,deptType);
        return iGenerator.convert(result,AccountCaliberVO.class);
    }

    @Override
    public Map<String, Object> getAccountCaliberDic() {
        List<PublicDicVO> accountCaliberDic = iGenerator.convert(publicDicService.getPublicDic(3505), PublicDicVO.class); // 核算口径归属
        List<PublicDicVO> deptTypeDic = iGenerator.convert(publicDicService.getPublicDic(3008), PublicDicVO.class); // 部门类别
        Map<String, Object> dicMap = new HashMap<>();
        dicMap.put("caliber", accountCaliberDic);
        dicMap.put("deptType", deptTypeDic);
        return dicMap;
    }

    @Override
    public void saveYearlyDeptAccountCaliber(Integer year) {
        accountCaliberService.saveYearlyDeptAccountCaliber(year);
    }

    @Override
    public void saveDeptAccountCaliber(List<Integer> caliberSaves, List<Integer> caliberDeletes, String deptId, Integer year) {
        accountCaliberService.saveDeptAccountCaliber(caliberSaves,caliberDeletes,deptId,year);
    }
}
