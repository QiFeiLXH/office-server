package com.bsoft.office.project.controller;

import com.bsoft.common.result.Result;
import com.bsoft.exception.ServiceException;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.project.condition.ProjectProgressCountQueryCnd;
import com.bsoft.office.project.manager.ProgressCountManager;
import com.bsoft.office.project.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2021/4/29 13:53
 * @Description:
 */
@RestController
@RequestMapping(value = "/procount")
public class ProgressCountController {

    @Autowired
    private ProgressCountManager progressCountManager;

    @PostMapping(value = "/list")
    @OperLog(operType = OperLogType.QUERY,operDesc = "项目进度查看列表")
    public OfficeResopnseBean findProgressCount(@RequestBody ProjectProgressCountQueryCnd cnd, HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        cnd.setPersonId(personId);
        Result<ProjectProgressCountVO> result = progressCountManager.findProgressCount(cnd);
        return OfficeResopnseBean.newSuccessBean(result);
    }

    @GetMapping(value = "/projectlist")
    public OfficeResopnseBean findProjectList(@RequestParam(name = "contractNo") String contractNo,
                                              @RequestParam(name = "month") String month){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = format.parse(month);
            List<ProContractProjectProgressVO> contractProjectProgressVOS = progressCountManager.getContractProjectProList(contractNo,date);
            return OfficeResopnseBean.newSuccessBean(contractProjectProgressVOS);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new ServiceException("格式化日期出错!");
        }
    }

    @RequestMapping(value = "/typelist",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "项目进度查看,查询上报类型列表")
    public OfficeResopnseBean findTypeList(@RequestParam(name = "projectId") String projectId){
        List<ProjectReportTypeViewVO> typeViewVOS = progressCountManager.findReportTypeList(projectId);
        return OfficeResopnseBean.newSuccessBean(typeViewVOS);
    }

    @RequestMapping(value = "/typeandheader",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "项目进度查看,查询项目上报列表头部")
    public OfficeResopnseBean getColumnsHeader(@RequestParam(name = "projectId") String projectId,
                                               @RequestParam(name = "month") String progressMonth){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date month = format.parse(progressMonth);
            List<ProjectReportTypeAndHeaderVO> proProgressNodeVOS = progressCountManager.getTypeAndHeader(projectId,month);
            return OfficeResopnseBean.newSuccessBean(proProgressNodeVOS);
        } catch (ParseException e) {
            return OfficeResopnseBean.newFailBean(500,"日期格式错误!");
        }
    }

    @RequestMapping(value = "/contypeandheader",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "按合同查看进度,查询上报列表头部")
    public OfficeResopnseBean getConColumnsHeader(@RequestParam(name = "contractNo") String contractNo,
                                                  @RequestParam(name = "month") String progressMonth){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date month = format.parse(progressMonth);
            List<ContractReportTypeVO> proProgressNodeVOS = progressCountManager.getConTypeAndHeader(contractNo,month);
            return OfficeResopnseBean.newSuccessBean(proProgressNodeVOS);
        } catch (ParseException e) {
            return OfficeResopnseBean.newFailBean(500,"日期格式错误!");
        }
    }

    @RequestMapping(value = "/monthreport",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "项目进度查看,查询项目月份上报进度")
    public OfficeResopnseBean getMonthProgress(@RequestParam(name = "projectId") String projectId,
                                               @RequestParam(name = "month") String month,
                                               @RequestParam(name = "reportType") List<Integer> reportTypes,
                                               @RequestParam(name = "inputContent") String inputContent){
        try {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = format.parse(month);
            List<List<ProReportProgressVO>> proReportProgressVOS = progressCountManager.getMonthProgress(projectId, date, reportTypes,inputContent);
            return OfficeResopnseBean.newSuccessBean(proReportProgressVOS);
        } catch (ParseException e) {
            return OfficeResopnseBean.newFailBean(500,"日期格式错误!");
        }
    }

    @RequestMapping(value = "/conmonthreport",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "项目进度查看,查询项目月份上报进度")
    public OfficeResopnseBean getConMonthProgress(@RequestParam(name = "contractNo") String contractNo,
                                               @RequestParam(name = "month") String month,
                                               @RequestParam(name = "reportType") List<Integer> reportTypes,
                                               @RequestParam(name = "inputContent") String inputContent){
        try {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = format.parse(month);
            List<List<ProReportProgressVO>> proReportProgressVOS = progressCountManager.getConMonthProgress(contractNo, date, reportTypes,inputContent);
            return OfficeResopnseBean.newSuccessBean(proReportProgressVOS);
        } catch (ParseException e) {
            return OfficeResopnseBean.newFailBean(500,"日期格式错误!");
        }
    }
}
