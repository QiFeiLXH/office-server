package com.bsoft.office.organ.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.hr.dto.HrFeeRulesRecordCndDTO;
import com.bsoft.hr.dto.HrFeeRulesRecordDTO;
import com.bsoft.hr.service.PersonFinancialMaintainService;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.organ.manager.HrFeeRulesRecordManager;
import com.bsoft.office.organ.vo.HrFeeRulesRecordVO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HrFeeRulesRecordManagerImpl implements HrFeeRulesRecordManager {

    @Reference(timeout = 6000)
    @Autowired
    private PersonFinancialMaintainService personFinancialMaintainService;

    @Autowired
    private IGenerator iGenerator;

    @Override
    public Result<HrFeeRulesRecordVO> getList(String userId, HrFeeRulesRecordCndDTO cnd) {
        Result<HrFeeRulesRecordDTO> hrFeeRulesRecordList = personFinancialMaintainService.getHrFeeRulesRecordList(userId,cnd);
        Result<HrFeeRulesRecordVO> convert = iGenerator.convert(hrFeeRulesRecordList, HrFeeRulesRecordVO.class);
        return convert;
    }
}
