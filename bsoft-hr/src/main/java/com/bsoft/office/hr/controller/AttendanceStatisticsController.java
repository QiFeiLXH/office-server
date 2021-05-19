package com.bsoft.office.hr.controller;

import com.bsoft.common.result.Result;
import com.bsoft.exception.ServiceException;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.annotation.RequiredExportLog;
import com.bsoft.office.common.condition.ExportLogParams;
import com.bsoft.office.common.exportExcel.ExportExcel;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.hr.condition.AttendanceStatisticsExportCnd;
import com.bsoft.office.hr.condition.AttendanceStatisticsQueryCnd;
import com.bsoft.office.hr.condition.BackAttendanceParam;
import com.bsoft.office.hr.condition.NewEntryPersonInfoQueryCnd;
import com.bsoft.office.hr.manager.AttendanceStatisticsManager;
import com.bsoft.office.hr.vo.AttendanceAbnormalVO;
import com.bsoft.office.hr.vo.AttendanceCountDetailVO;
import com.bsoft.office.hr.vo.AttendanceStatisticsVO;
import com.bsoft.office.hr.vo.NewEntryPersonInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2021/1/20 9:35
 * @Description:
 */

@RestController
@RequestMapping("/attendencestatis")
public class AttendanceStatisticsController {

    @Autowired
    private AttendanceStatisticsManager attendanceStatisticsManager;

    @RequestMapping(value = "/querycount",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询考勤统计信息")
    public OfficeResopnseBean queryAttendenceCount(@RequestBody AttendanceStatisticsQueryCnd cndVO, HttpServletRequest request){
        String pseronId = ContextUtils.getUserId(request);
        cndVO.setPersonId(pseronId);
        Result<AttendanceStatisticsVO> list = attendanceStatisticsManager.getAttendanceCount(cndVO);
        return OfficeResopnseBean.newSuccessBean(list);
    }

    @RequestMapping(value = "/queryabnormal",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询异常考勤信息")
    public OfficeResopnseBean getAttendanceAbnormal(@RequestBody AttendanceStatisticsQueryCnd cndVO, HttpServletRequest request){
        String pseronId = ContextUtils.getUserId(request);
        cndVO.setPersonId(pseronId);
        List<AttendanceAbnormalVO> list = attendanceStatisticsManager.getAttendanceAbnormal(cndVO);
        return OfficeResopnseBean.newSuccessBean(list);
    }

    @RequestMapping(value = "/gener",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.OTHER,operDesc = "生成考勤统计信息")
    public OfficeResopnseBean generAttendanceCount(@RequestBody AttendanceStatisticsQueryCnd cndVO, HttpServletRequest request){
        String pseronId = ContextUtils.getUserId(request);
        cndVO.setPersonId(pseronId);
        attendanceStatisticsManager.generAttendanceCount(cndVO);
        return OfficeResopnseBean.newSuccessBean();
    }

    @RequestMapping(value = "/commit",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.MODIFY,operDesc = "提交考勤统计信息")
    public OfficeResopnseBean commitAttendanceCount(@RequestBody AttendanceStatisticsQueryCnd cndVO, HttpServletRequest request){
        String pseronId = ContextUtils.getUserId(request);
        cndVO.setPersonId(pseronId);
        attendanceStatisticsManager.commitAttendanceCount(cndVO);
        return OfficeResopnseBean.newSuccessBean();
    }

    @RequestMapping(value = "/doback",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.OTHER,operDesc = "退回考勤统计信息")
    public OfficeResopnseBean backAttendanceCount(@RequestBody BackAttendanceParam param){
           attendanceStatisticsManager.backAttendanceCount(param.getMonth(),param.getPersonIds());
           return OfficeResopnseBean.newSuccessBean();
    }

    @GetMapping(value = "/exportdownload")
    @RequiredExportLog
    @OperLog(operType = OperLogType.EXPORT,operDesc = "导出考勤统计信息")
    public void exportAttendance(ExportLogParams params, AttendanceStatisticsExportCnd cndVO, HttpServletRequest request, HttpServletResponse response) {
        String pseronId = ContextUtils.getUserId(request);
        cndVO.setPersonId(pseronId);
        List<AttendanceStatisticsVO> list = attendanceStatisticsManager.getAllAttendanceCount(cndVO);
        Calendar cal = Calendar.getInstance();
        cal.setTime(cndVO.getStartDate());
        int month = cal.get(Calendar.MONTH) + 1;
        ExportExcel.doExport(list, AttendanceStatisticsVO.class,month + "月考勤统计信息",response);
    }

    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查看考勤明细信息")
    public OfficeResopnseBean getAttendanceCountDetail(@RequestParam("startDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate,
                                                       @RequestParam("endDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate,
                                                       @RequestParam("personId") String personId,
                                                       @RequestParam("type") String type
    ){
        List<AttendanceCountDetailVO> list = attendanceStatisticsManager.getAttendanceCountDetail(startDate,endDate,personId,type);
        return OfficeResopnseBean.newSuccessBean(list);
    }

}
