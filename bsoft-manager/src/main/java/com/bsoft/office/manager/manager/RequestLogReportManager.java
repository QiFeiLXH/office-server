package com.bsoft.office.manager.manager;

import com.bsoft.common.result.Result;
import com.bsoft.logs.dto.RequestLogReportDTO;
import com.bsoft.logs.dto.RequestLogReportQueryCndDTO;
import com.bsoft.office.manager.condition.RequestLogReportQueryCnd;
import com.bsoft.office.manager.vo.RequestLogReportVO;

import java.util.List;

/**
 * @author: zy
 * @date: 2020/10/27
 * @description
 */
public interface RequestLogReportManager {
    List<RequestLogReportVO> getMenuCountForChart(String userId, RequestLogReportQueryCnd queryCnd);
    Result<RequestLogReportVO> getMenuCountForTable(String userId, RequestLogReportQueryCnd queryCnd);
    List<RequestLogReportVO> getPathCountForChart(String userId, RequestLogReportQueryCnd queryCnd);
    Result<RequestLogReportVO> getPathCountForTable(String userId, RequestLogReportQueryCnd queryCnd);
}
