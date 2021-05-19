package com.bsoft.office.project.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.project.condition.ProjectDutyQueryCnd;
import com.bsoft.office.project.manager.ProjectDutyManager;
import com.bsoft.office.project.manager.ProjectWordManager;
import com.bsoft.office.project.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author Xuhui Lin
 * @Date 2020/5/12 12:51
 * @Description 项目责任书维护
 */
@RestController
@RequestMapping("/dutymaintain")
public class ProjectDutyMaintainController {
    private static final Logger logger = LoggerFactory.getLogger(ProjectDutyMaintainController.class);

    @Autowired
    private ProjectDutyManager projectDutyManager;
    @Autowired
    private ProjectWordManager projectWordManager;

    /** 项目责任书维护列表 */
    @PostMapping(value = "/duty")
    @OperLog(operType = OperLogType.QUERY,operDesc = "项目责任书维护列表")
    public OfficeResopnseBean getProjectDutyMaintainList(@RequestBody ProjectDutyQueryCnd cnd,
                                                      HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        cnd.setUserId(userId);
        Result<ProjectDutyViewVO> result = projectDutyManager.getProjectDutyMaintainList(cnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        logger.info("获取项目责任书维护列表成功！[{}]", JSONUtils.toString(result));
        return responseBean;
    }

    /** 项目责任书维护列表 */
    @GetMapping(value = "/dutyinfo")
    @OperLog(operType = OperLogType.QUERY,operDesc = "项目责任书明细")
    public OfficeResopnseBean getProjectDutyView(@RequestParam Integer dutyId) {
        ProjectDutyViewVO projectDutyViewVO = projectDutyManager.getProjectDutyView(dutyId);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(projectDutyViewVO);
        logger.info("获取项目责任书详情！[{}]", JSONUtils.toString(projectDutyViewVO));
        return responseBean;
    }

    /** 项目责任书-客户选择列表 */
    @GetMapping(value = "/customerselect")
    @OperLog(operType = OperLogType.QUERY,operDesc = "项目责任书-客户选择列表")
    public OfficeResopnseBean getProjectDutyCustomerSelectList(@RequestParam Integer pageSize,
                                                               @RequestParam Integer pageNo,
                                                               HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        Result<ProjectDutyCustomerAndProjectSelectViewVO> result = projectDutyManager.getProjectDutyCustomerSelectList(pageNo, pageSize, userId);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        logger.info("获取项目责任书-客户选择列表成功！[{}]", JSONUtils.toString(result));
        return responseBean;
    }

    /** 项目责任书-项目范围列表 */
    @GetMapping(value = "/projectregion")
    @OperLog(operType = OperLogType.QUERY,operDesc = "项目责任书-项目范围列表")
    public OfficeResopnseBean getProjectDutyRegionList(@RequestParam Integer dutyId) {
        List<ProjectDutyRegionViewVO> result = projectDutyManager.getProjectDutyRegionList(dutyId);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        logger.info("获取项目责任书-项目范围列表成功！[{}]", JSONUtils.toString(result));
        return responseBean;
    }

    /** 项目责任书-项目选择列表 */
    @GetMapping(value = "/projectselect")
    @OperLog(operType = OperLogType.QUERY,operDesc = "项目责任书-项目选择列表")
    public OfficeResopnseBean getProjectDutyProjectSelectList(@RequestParam Integer pageSize,
                                                              @RequestParam Integer pageNo,
                                                              @RequestParam String customerId,
                                                              HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        Result<ProjectDutyCustomerAndProjectSelectViewVO> result = projectDutyManager.getProjectDutyProjectSelectList(userId, customerId, pageNo, pageSize);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        logger.info("获取项目责任书-项目选择列表成功！[{}]", JSONUtils.toString(result));
        return responseBean;
    }

    /** 项目责任书-项目责任书编号列表 */
    @GetMapping(value = "/dutynameno")
    @OperLog(operType = OperLogType.QUERY,operDesc = "项目责任书-项目责任书编号")
    public OfficeResopnseBean getProjectDutyNameNo(@RequestParam String customerId, @RequestParam String year) {
        String dutyName = projectDutyManager.getProjectDutyNameNo(customerId, year);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(dutyName);
        logger.info("获取项目责任书-项目责任书编号成功！[{}]", JSONUtils.toString(dutyName));
        return responseBean;
    }

    /** 项目责任书-删除责任书 */
    @DeleteMapping(value = "/dutydelete")
    @OperLog(operType = OperLogType.DELETE,operDesc = "项目责任书-删除责任书")
    public OfficeResopnseBean deleteProjectDuty(@RequestParam Integer dutyId) {
        projectDutyManager.deleteProjectDuty(dutyId);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody("删除责任书成功！");
        logger.info("项目责任书-删除责任书成功!，责任书id[{}]", JSONUtils.toString(dutyId));
        return responseBean;
    }

    /** 项目责任书-保存责任书 */
    @PostMapping(value = "/dutysave")
    @OperLog(operType = OperLogType.MODIFY,operDesc = "项目责任书-保存责任书")
    public OfficeResopnseBean saveProjectDuty(@RequestBody ProjectDutyAndRegionVO projectDutyAndRegionVO,
                                              HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        Integer dutyId = projectDutyManager.saveProjectDuty(projectDutyAndRegionVO, userId);
        responseBean.setBody(dutyId);
        logger.info("项目责任书-保存责任书成功!,责任书id [{}]", JSONUtils.toString(dutyId));
        return responseBean;
    }

    /** 项目责任书-里程碑列表 */
    @GetMapping(value = "/milepost")
    @OperLog(operType = OperLogType.QUERY,operDesc = "项目责任书-里程碑列表")
    public OfficeResopnseBean getProjectDutyMliepost(@RequestParam String contractNo,
                                                     @RequestParam Integer dutyId,
                                                     @RequestParam Integer pageNo,
                                                     @RequestParam Integer pageSize) {
        Result<ProjectDutyMilepostViewVO> result = projectDutyManager.getProjectDutyMliepost(contractNo, dutyId, pageNo, pageSize);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        logger.info("获取项目责任书-项目责任书编号成功！[{}]", JSONUtils.toString(result));
        return responseBean;
    }

    /** 项目责任书-保存里程碑 */
    @PostMapping(value = "/milepostsave")
    @OperLog(operType = OperLogType.MODIFY,operDesc = "项目责任书-保存里程碑")
    public OfficeResopnseBean saveProjectDutyMilepost(@RequestBody List<ProjectDutyMilepostVO> saves,
                                                      @RequestParam(name="deletes",required = false) List<Integer> deletes) {
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        if (deletes == null) {
            deletes = new ArrayList<>();
        }
        projectDutyManager.saveProjectDutyMilepost(saves, deletes);
        responseBean.setBody("保存责任书里程碑成功！");
        logger.info("项目责任书-保存责任书里程碑成功!");
        return responseBean;
    }

    @GetMapping(value = "/loadstagedocumentheader")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取表头")
    public OfficeResopnseBean loadStageDocumentHeader(@RequestParam String contractNo,@RequestParam Integer dutyId){
        try{
            OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
            List<StageDocumentHeaderVO> header = projectWordManager.getStageDocumentHeader(contractNo, dutyId);
            bean.setBody(header);
            return bean;
        }catch (Exception e) {
            e.printStackTrace();
            OfficeResopnseBean responseBean = OfficeResopnseBean.newFailBean(500,"获取表头失败");
            return responseBean;
        }
    }

    @GetMapping(value = "/loadstagedocument")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取阶段文档")
    public OfficeResopnseBean loadStageDocument(@RequestParam String contractNo,@RequestParam Integer dutyId){
        try{
            OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
            List<Map<String,Object>> header = projectWordManager.getStageDocument(contractNo,dutyId);
            bean.setBody(header);
            return bean;
        }catch (Exception e) {
            e.printStackTrace();
            OfficeResopnseBean responseBean = OfficeResopnseBean.newFailBean(500,"获取阶段文档信息失败");
            return responseBean;
        }
    }

    /** 项目责任书-预计回款查询 */
    @GetMapping(value = "/payment")
    @OperLog(operType = OperLogType.QUERY,operDesc = "项目责任书-预计回款查询")
    public OfficeResopnseBean getProjectDutyPayment(@RequestParam Integer dutyId) {
        List<ProjectDutyPaymentViewVO> result = projectDutyManager.getProjectDutyPayment(dutyId);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        logger.info("获取项目责任书-项目责任书编号成功！[{}]", JSONUtils.toString(result));
        return responseBean;
    }

    /** 项目责任书-预计回款保存、删除 */
    @PostMapping(value = "/paymentsave")
    @OperLog(operType = OperLogType.MODIFY,operDesc = "项目责任书-计划回款保存")
    public OfficeResopnseBean saveProjectDutyPayment(@RequestBody List<ProjectDutyPaymentVO> saves,
                                                     @RequestParam(name="deletes",required = false) List<Integer> deletes) {
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        if (deletes == null) {
            deletes = new ArrayList<>();
        }
        projectDutyManager.saveProjectDutyPayment(saves, deletes);
        responseBean.setBody("项目责任书-计划回款保存成功！");
        logger.info("项目责任书-计划回款保存成功！");
        return responseBean;
    }
}
