package com.bsoft.office.common.manager.impl;

import com.bsoft.common.dto.ModifyRecordDTO;
import com.bsoft.common.dto.ModifyRecordQueryCndDTO;
import com.bsoft.common.result.Result;
import com.bsoft.common.service.ModifyRecordService;
import com.bsoft.office.common.condition.ModifyRecordQueryCnd;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.common.manager.ModifyRecordManager;
import com.bsoft.office.common.vo.ModifyRecordViewVO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Xuhui Lin
 * @Date 2020/12/10 17:03
 * @Description
 */
@Service
public class ModifyRecordManagerImpl implements ModifyRecordManager {
    @Reference(timeout = 60000)
    private ModifyRecordService modifyRecordService;
    @Autowired
    private IGenerator iGenerator;
    @Override
    public Result<ModifyRecordViewVO> getModifyRecordList(ModifyRecordQueryCnd cnd) {
        ModifyRecordQueryCndDTO cndDTO = iGenerator.convert(cnd, ModifyRecordQueryCndDTO.class);
        Result<ModifyRecordDTO> result = modifyRecordService.getModifyRecordList(cndDTO);
        return iGenerator.convert(result, ModifyRecordViewVO.class);
    }
}
