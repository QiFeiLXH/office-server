package com.bsoft.office.system.controller;

import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.common.utils.IpUtils;
import com.bsoft.office.system.condition.UsageLogCountQueryCnd;
import com.bsoft.office.system.manager.UsageLogManager;
import com.bsoft.office.system.vo.UsageLogCountVO;
import com.bsoft.office.system.vo.UsageLogCountWithDateVO;
import com.bsoft.office.system.vo.UsageLogReportVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/log")
public class UsageLogController {

    private static final Logger log = LoggerFactory.getLogger(UsageLogController.class);

    @Autowired
    UsageLogManager usageLogManager;

    @RequestMapping(value="/usagelog",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.SAVE,operDesc = "保存菜单使用日志")
    public OfficeResopnseBean SaveUsageLog(@RequestParam(value = "menuId",required = true) Integer menuId,
                                            HttpServletRequest request){
        String ip = IpUtils.getIpAdrress(request);
        String userId = ContextUtils.getUserId(request);
        usageLogManager.CountUsageLog(menuId,ip,userId);
        log.info("菜单使用日志保存成功!");
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        return bean;
    }

    @RequestMapping(value="/usagelogreport",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询菜单使用日志")
    public OfficeResopnseBean getUsageLogReport(@RequestParam(value = "startDate")String startDate,@RequestParam(value = "endDate")String endDate){
        log.info("获取使用日志报表，开始[{}]，结束[{}]!",startDate,endDate);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date start = simpleDateFormat.parse(startDate);
            Date end = simpleDateFormat.parse(endDate);
            List<UsageLogReportVO> usageLogReportVOList = usageLogManager.UsageLogReport(start,end);
            OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
            bean.setBody(usageLogReportVOList);
            return bean;
        } catch (ParseException e) {
            e.printStackTrace();
            OfficeResopnseBean bean = OfficeResopnseBean.newFailBean(500,"参数格式转换异常！");
            return bean;
        }
    }

    @PostMapping("/countlog")
    @OperLog(operType = OperLogType.QUERY,operDesc = "统计菜单访问次数")
    public OfficeResopnseBean countLog(@RequestBody UsageLogCountQueryCnd countQueryCnd){
        List<UsageLogCountVO> voList = usageLogManager.countUsageLogs(countQueryCnd);
        OfficeResopnseBean res = OfficeResopnseBean.newSuccessBean();
        res.setBody(voList);
        return res;
    }

    @GetMapping("/countloggroup")
    @OperLog(operType = OperLogType.QUERY,operDesc = "统计菜单使用日志")
    public OfficeResopnseBean countLogWithDate(@RequestParam(value = "startDate")String startDate,@RequestParam(value = "endDate")String endDate){
        log.info("获取使用日志报表，开始[{}]，结束[{}]!",startDate,endDate);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date start = simpleDateFormat.parse(startDate);
            Date end = simpleDateFormat.parse(endDate);
            List<UsageLogCountWithDateVO> voList = usageLogManager.countUsageLogGroup(start,end);
            OfficeResopnseBean res = OfficeResopnseBean.newSuccessBean();
            res.setBody(voList);
            return res;
        } catch (ParseException e) {
            e.printStackTrace();
            OfficeResopnseBean bean = OfficeResopnseBean.newFailBean(500,"参数格式转换异常！");
            return bean;
        }

    }
}
