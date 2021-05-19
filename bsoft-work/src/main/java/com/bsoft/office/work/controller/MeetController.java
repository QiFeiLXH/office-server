package com.bsoft.office.work.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.annotation.RequiredExportLog;
import com.bsoft.office.common.condition.ExportLogParams;
import com.bsoft.office.common.exportExcel.ExcelListener;
import com.bsoft.office.common.exportExcel.ExcelUtils;
import com.bsoft.office.common.exportExcel.ExportExcel;
import com.bsoft.office.common.exportExcel.ImportResultVO;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.work.condition.MeetPersonQueryCnd;
import com.bsoft.office.work.condition.MeetQueryCnd;
import com.bsoft.office.work.manager.MeetManager;
import com.bsoft.office.work.manager.MeetPersonManager;
import com.bsoft.office.work.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-12-21 15:46
 * @Version 1.0
 */
@RestController
@RequestMapping("/meet")
public class MeetController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MeetController.class);
    @Autowired
    private MeetManager meetManager;
    @Autowired
    private MeetPersonManager meetPersonManager;

    @GetMapping("/meetlist")
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询会议列表")
    public OfficeResopnseBean getMeetList(MeetQueryCnd queryCnd, HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("[{}]获取会议列表[{}]", userId, JSONUtils.toString(queryCnd));
        Result<MeetViewVO> result = meetManager.getMeetList(userId, queryCnd);
        return OfficeResopnseBean.newSuccessBean(result);
    }

    @PostMapping("/savemeet")
    @OperLog(operType = OperLogType.SAVE,operDesc = "保存会议信息")
    public OfficeResopnseBean saveMeet(@RequestBody MeetVO saveVO, HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("[{}]保存会议信息[{}]", userId, saveVO);
        meetManager.saveMeet(userId, saveVO);
        return OfficeResopnseBean.newSuccessBean();
    }

    @GetMapping("/meetpersonlist")
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询会议人员列表")
    public OfficeResopnseBean getMeetPersonList(MeetPersonQueryCnd queryCnd, HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("[{}]获取会议人员列表[{}]", userId, JSONUtils.toString(queryCnd));
        Result<MeetPersonVO> result = meetPersonManager.getMeetPersons(userId, queryCnd);
        return OfficeResopnseBean.newSuccessBean(result);
    }

    @PostMapping("/savemeetperson")
    @OperLog(operType = OperLogType.SAVE,operDesc = "保存会议人员信息")
    public OfficeResopnseBean saveMeetPerson(@RequestBody MeetPersonVO saveVO, HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("[{}]保存会议人员信息[{}]", userId, saveVO);
        meetPersonManager.saveMeetPerson(userId, saveVO);
        return OfficeResopnseBean.newSuccessBean();
    }

    @PostMapping("/personexitmeet")
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询该手机号是否已参与会议信息")
    public OfficeResopnseBean personExitsMeet(@RequestBody MeetPersonVO saveVO, HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("[{}]查询该手机号是否已参与会议信息[{}]", userId, saveVO);
        Boolean exitFlag = meetPersonManager.personExitsMeet(userId, saveVO);
        return OfficeResopnseBean.newSuccessBean(exitFlag);
    }

    @PostMapping("/haveperson")
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询该手机号是否已使用信息")
    public OfficeResopnseBean havePersonExits(@RequestBody MeetPersonVO saveVO, HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("[{}]查询该手机号是否已使用信息[{}]", userId, saveVO);
        String exitsName = meetPersonManager.havePersonExits(userId, saveVO);
        return OfficeResopnseBean.newSuccessBean(exitsName);
    }

    @GetMapping("/deleteperson")
    @OperLog(operType = OperLogType.DELETE,operDesc = "删除会议人员信息")
    public OfficeResopnseBean saveMeetPerson(@RequestParam Integer id, HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("[{}]删除会议人员信息[{}]", userId, id);
        meetPersonManager.deleteMeetPerson(userId, id);
        return OfficeResopnseBean.newSuccessBean();
    }

    /** 导出销售计划错误数据 */
    @GetMapping("/errordownload")
    @RequiredExportLog
    @OperLog(operType = OperLogType.EXPORT,operDesc = "导出参会人员错误数据")
    public void exportErrorData(ExportLogParams params, HttpServletRequest request, HttpServletResponse response){
        LOGGER.info("导出参会人员错误数据");
        String userId = ContextUtils.getUserId(request);
        List<MeetPersonExcelErrorVO> list = meetPersonManager.exportErrorData(userId);
        ExportExcel.export(list, MeetPersonExcelVO.class,"参会人员导入失败数据", response);
    }

    /** 导入会议人员数据*/
    @PostMapping("/import")
    @OperLog(operType = OperLogType.IMPORT,operDesc = "导入会议人员数据")
    public OfficeResopnseBean importData(@RequestParam MultipartFile file,@RequestParam Integer meetId, HttpServletRequest request) {
        LOGGER.info("导入会议人员数据[{}]", file.getOriginalFilename());
        String userId = ContextUtils.getUserId(request);
        try {
            // 读取Excel数据转换成VO
            List<MeetPersonExcelVO> list = ExcelUtils.readExcel(file, MeetPersonExcelVO.class, new ExcelListener<MeetPersonExcelVO>());
            for(MeetPersonExcelVO vo :list){
                vo.setMeetId(meetId);
            }
            // 保存VO并返回结果
            ImportResultVO result = meetPersonManager.importMeetPersonData(userId, list,meetId);
            return OfficeResopnseBean.newSuccessBean(result);
        } catch (IOException e) {
            return OfficeResopnseBean.newFailBean(500, "导入失败");
        }
    }

}
