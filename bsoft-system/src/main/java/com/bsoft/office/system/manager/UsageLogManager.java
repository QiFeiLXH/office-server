package com.bsoft.office.system.manager;

import com.bsoft.office.system.condition.UsageLogCountQueryCnd;
import com.bsoft.office.system.vo.LoginLogVO;
import com.bsoft.office.system.vo.UsageLogCountVO;
import com.bsoft.office.system.vo.UsageLogCountWithDateVO;
import com.bsoft.office.system.vo.UsageLogReportVO;

import java.util.Date;
import java.util.List;

public interface UsageLogManager {
    public void CountUsageLog(Integer menuId,String ip,String userId);
    public void CountLoginLog(LoginLogVO logVO);
    public List<UsageLogReportVO> UsageLogReport(Date startDate, Date endDate);
    List<UsageLogCountVO> countUsageLogs(UsageLogCountQueryCnd countQueryCnd);
    List<UsageLogCountWithDateVO> countUsageLogGroup(Date startDate,Date endDate);
}
