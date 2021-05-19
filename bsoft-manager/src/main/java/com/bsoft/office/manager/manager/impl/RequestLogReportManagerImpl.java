package com.bsoft.office.manager.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.logs.dto.RequestLogReportDTO;
import com.bsoft.logs.dto.RequestLogReportQueryCndDTO;
import com.bsoft.logs.service.RequestLogReportService;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.manager.condition.RequestLogReportQueryCnd;
import com.bsoft.office.manager.manager.RequestLogReportManager;
import com.bsoft.office.manager.vo.RequestLogReportVO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: zy
 * @date: 2020/10/27
 * @description
 */
@Component
public class RequestLogReportManagerImpl implements RequestLogReportManager {

    @Reference(timeout = 10000)
    private RequestLogReportService requestLogReportService;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public List<RequestLogReportVO> getMenuCountForChart(String userId, RequestLogReportQueryCnd queryCnd) {
        RequestLogReportQueryCndDTO queryCndDTO = iGenerator.convert(queryCnd, RequestLogReportQueryCndDTO.class);
        List<RequestLogReportDTO> resultDTO = requestLogReportService.getMenuCount(userId, queryCndDTO);
        return iGenerator.convert(resultDTO, RequestLogReportVO.class);
    }

    @Override
    public Result<RequestLogReportVO> getMenuCountForTable(String userId, RequestLogReportQueryCnd queryCnd) {
        RequestLogReportQueryCndDTO queryCndDTO = iGenerator.convert(queryCnd, RequestLogReportQueryCndDTO.class);
        Result<RequestLogReportDTO> resultDTO = requestLogReportService.getMenuCountWithPage(userId, queryCndDTO);
        return iGenerator.convert(resultDTO, RequestLogReportVO.class);
    }

    @Override
    public List<RequestLogReportVO> getPathCountForChart(String userId, RequestLogReportQueryCnd queryCnd) {
        RequestLogReportQueryCndDTO queryCndDTO = iGenerator.convert(queryCnd, RequestLogReportQueryCndDTO.class);
        List<RequestLogReportDTO> resultDTO = requestLogReportService.getPathCount(userId, queryCndDTO);
        return iGenerator.convert(resultDTO, RequestLogReportVO.class);
    }

    @Override
    public Result<RequestLogReportVO> getPathCountForTable(String userId, RequestLogReportQueryCnd queryCnd) {
        RequestLogReportQueryCndDTO queryCndDTO = iGenerator.convert(queryCnd, RequestLogReportQueryCndDTO.class);
        Result<RequestLogReportDTO> resultDTO = requestLogReportService.getPathCountWithPage(userId, queryCndDTO);
        return iGenerator.convert(resultDTO, RequestLogReportVO.class);
    }
}
