package com.bsoft.office.manager.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.logs.dto.OperLogDTO;
import com.bsoft.logs.dto.OperLogQueryCndDTO;
import com.bsoft.logs.service.RequestLogReportService;
import com.bsoft.office.common.dozer.GeneratorUtil;
import com.bsoft.office.manager.condition.OperLogQueryCnd;
import com.bsoft.office.manager.manager.OperLogManager;
import com.bsoft.office.manager.vo.OperLogVO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: xucl
 * @DateTime: 2021/2/7 9:31
 * @Description:
 */
@Component
public class OperLogManagerImpl implements OperLogManager {
    @Reference(timeout = 60000)
    private RequestLogReportService reportService;
    @Autowired
    private GeneratorUtil generatorUtil;

    @Override
    public Result<OperLogVO> findList(String userId, OperLogQueryCnd cnd) {
        OperLogQueryCndDTO cndDTO = generatorUtil.convert(cnd,OperLogQueryCndDTO.class);
        Result<OperLogDTO> dtoResult = reportService.getRequestLogList(userId,cndDTO);
        return generatorUtil.convert(dtoResult,OperLogVO.class);
    }
}
