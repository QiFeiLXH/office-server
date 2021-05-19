package com.bsoft.office.hr.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.hr.condition.AttendanceStatisticsExportCnd;
import com.bsoft.office.hr.vo.AttendanceAbnormalVO;
import com.bsoft.office.hr.condition.AttendanceStatisticsQueryCnd;
import com.bsoft.office.hr.vo.AttendanceCountDetailVO;
import com.bsoft.office.hr.vo.AttendanceStatisticsVO;

import java.util.Date;
import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2021/1/20 9:37
 * @Description:
 */
public interface AttendanceStatisticsManager {

    Result<AttendanceStatisticsVO> getAttendanceCount(AttendanceStatisticsQueryCnd cndVO);

    List<AttendanceAbnormalVO> getAttendanceAbnormal(AttendanceStatisticsQueryCnd cndVO);

    void generAttendanceCount(AttendanceStatisticsQueryCnd cndVO);

    void commitAttendanceCount(AttendanceStatisticsQueryCnd cndVO);

    void backAttendanceCount(Date month, List<String> personIds);

    List<AttendanceStatisticsVO> getAllAttendanceCount(AttendanceStatisticsExportCnd cndVO);

    List<AttendanceCountDetailVO> getAttendanceCountDetail(Date startDate, Date endDate, String personId, String type);
}
