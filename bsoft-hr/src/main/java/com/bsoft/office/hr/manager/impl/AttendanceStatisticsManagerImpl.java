package com.bsoft.office.hr.manager.impl;

import com.bsoft.attendance.dto.AttendanceAbnormalDTO;
import com.bsoft.attendance.dto.AttendanceCountDetailDTO;
import com.bsoft.attendance.dto.AttendanceStatisticsCndDTO;
import com.bsoft.attendance.dto.AttendanceStatisticsDTO;
import com.bsoft.attendance.service.AttendanceStatisticsService;
import com.bsoft.common.result.Result;
import com.bsoft.office.common.dozer.GeneratorUtil;
import com.bsoft.office.hr.condition.AttendanceStatisticsExportCnd;
import com.bsoft.office.hr.condition.AttendanceStatisticsQueryCnd;
import com.bsoft.office.hr.manager.AttendanceStatisticsManager;
import com.bsoft.office.hr.vo.AttendanceAbnormalVO;
import com.bsoft.office.hr.vo.AttendanceCountDetailVO;
import com.bsoft.office.hr.vo.AttendanceStatisticsVO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2021/1/20 9:37
 * @Description:
 */
@Component
public class AttendanceStatisticsManagerImpl implements AttendanceStatisticsManager {

    @Reference(timeout = 60000)
    private AttendanceStatisticsService attendanceStatisticsService;
    @Autowired
    private GeneratorUtil generatorUtil;

    @Override
    public Result<AttendanceStatisticsVO> getAttendanceCount(AttendanceStatisticsQueryCnd cndVO) {
        AttendanceStatisticsCndDTO cndDTO = generatorUtil.convert(cndVO,AttendanceStatisticsCndDTO.class);
        Result<AttendanceStatisticsDTO> attendanceStatisticsDTOS = attendanceStatisticsService.getAttendanceCount(cndDTO);
        return generatorUtil.convert(attendanceStatisticsDTOS,AttendanceStatisticsVO.class);
    }

    @Override
    public List<AttendanceAbnormalVO> getAttendanceAbnormal(AttendanceStatisticsQueryCnd cndVO) {
        AttendanceStatisticsCndDTO cndDTO = generatorUtil.convert(cndVO,AttendanceStatisticsCndDTO.class);
        List<AttendanceAbnormalDTO> attendanceAbnormalDTOS = attendanceStatisticsService.getAttendanceAbnormal(cndDTO);
        return generatorUtil.convert(attendanceAbnormalDTOS,AttendanceAbnormalVO.class);
    }

    @Override
    public void generAttendanceCount(AttendanceStatisticsQueryCnd cndVO) {
        AttendanceStatisticsCndDTO cndDTO = generatorUtil.convert(cndVO,AttendanceStatisticsCndDTO.class);
        attendanceStatisticsService.generAttendanceCount(cndDTO);
    }

    @Override
    public void commitAttendanceCount(AttendanceStatisticsQueryCnd cndVO) {
        AttendanceStatisticsCndDTO cndDTO = generatorUtil.convert(cndVO,AttendanceStatisticsCndDTO.class);
        attendanceStatisticsService.commitAttendanceCount(cndDTO);
    }

    @Override
    public void backAttendanceCount(Date month, List<String> personIds) {
        attendanceStatisticsService.backAttendanceCount(month,personIds);
    }

    @Override
    public List<AttendanceStatisticsVO> getAllAttendanceCount(AttendanceStatisticsExportCnd cndVO) {
        AttendanceStatisticsCndDTO cndDTO = generatorUtil.convert(cndVO,AttendanceStatisticsCndDTO.class);
        List<AttendanceStatisticsDTO> list = attendanceStatisticsService.getAllAttendanceCount(cndDTO);
        return generatorUtil.convert(list,AttendanceStatisticsVO.class);
    }

    @Override
    public List<AttendanceCountDetailVO> getAttendanceCountDetail(Date startDate, Date endDate, String personId, String type) {
        List<AttendanceCountDetailDTO> list = attendanceStatisticsService.getAttendanceCountDetail(startDate,endDate,personId,type);
        return generatorUtil.convert(list,AttendanceCountDetailVO.class);
    }
}
