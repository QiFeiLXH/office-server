package com.bsoft.office.system.managerImpl;

import com.alibaba.fastjson.JSON;
import com.bsoft.logs.dto.*;
import com.bsoft.message.logs.LoginLogMessage;
import com.bsoft.message.logs.UsageLogsMessage;
import com.bsoft.office.common.dozer.GeneratorUtil;
import com.bsoft.office.system.condition.UsageLogCountQueryCnd;
import com.bsoft.office.system.manager.UsageLogManager;
import com.bsoft.office.system.vo.*;
import com.bsoft.logs.service.UsageLogReportService;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UsageLogManagerImpl implements UsageLogManager {
    private static final Logger log = LoggerFactory.getLogger(UsageLogManagerImpl.class);
    @Reference
    private UsageLogsMessage usageLogsMessage;
    @Reference
    private LoginLogMessage loginLogMessage;
    @Reference
    private UsageLogReportService usageLogReportService;
    @Autowired
    GeneratorUtil generatorUtil;

    @Override
    public void CountUsageLog(Integer menuId,String ip,String userId) {
        UsageLogVO usageLogVO = new UsageLogVO();
        usageLogVO.setMenuId(menuId);
        usageLogVO.setPersonId(userId);
        usageLogVO.setUseDate(new Date());
        usageLogVO.setIp(ip);
        UsageLogDTO usageLogDTO = generatorUtil.convert(usageLogVO,UsageLogDTO.class);
        usageLogsMessage.send(usageLogDTO);
        log.info("调用日志保存成功 [{}]!", JSON.toJSONString(usageLogDTO));
    }

    @Override
    public void CountLoginLog(LoginLogVO logVO) {
        LoginLogDTO loginLogDTO = generatorUtil.convert(logVO,LoginLogDTO.class);
        loginLogMessage.send(loginLogDTO);
        log.info("调用登录日志保存成功 [{}]!", JSON.toJSONString(loginLogDTO));
    }

    @Override
    public List<UsageLogReportVO> UsageLogReport(Date startDate, Date endDate) {
        List<UsageLogReportDTO> usageLogReportDTOS = usageLogReportService.countUsageLog(startDate,endDate);
        List<UsageLogReportVO> usageLogReportVOS = generatorUtil.convert(usageLogReportDTOS,UsageLogReportVO.class);
        log.info("查询使用日志统计报表成功 [{}]!", JSON.toJSONString(usageLogReportVOS));
        return usageLogReportVOS;
    }

    @Override
    public List<UsageLogCountVO> countUsageLogs(UsageLogCountQueryCnd countQueryCnd) {
        UsageLogCountQueryCndDTO countQueryCndDTO = GeneratorUtil.instance().convert(countQueryCnd,UsageLogCountQueryCndDTO.class);
        List<UsageLogCountDTO> list = usageLogReportService.countUsageLogs(countQueryCndDTO);
        log.info("查询使用日志统计报表成功 [{}]!", JSON.toJSONString(list));
        return GeneratorUtil.instance().convert(list,UsageLogCountVO.class);
    }

    @Override
    public List<UsageLogCountWithDateVO> countUsageLogGroup(Date startDate, Date endDate) {
        List<UsageLogCountWithDateDTO> dtos = usageLogReportService.countUsageLogGroup(startDate,endDate);
        log.info("查询使用日志统计报表成功 [{}]!", JSON.toJSONString(dtos));
        return GeneratorUtil.instance().convert(dtos,UsageLogCountWithDateVO.class);
    }
}
