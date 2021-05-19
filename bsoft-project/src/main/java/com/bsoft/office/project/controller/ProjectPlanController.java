package com.bsoft.office.project.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.project.condition.ProjectStandardWordQueryCnd;
import com.bsoft.office.project.manager.*;
import com.bsoft.office.project.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @Author zhanglf
 * @Date 2020-01-17 11:02
 * @Version 1.0
 * @Description
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/projectplan")
public class ProjectPlanController {
    private static final Logger logger = LoggerFactory.getLogger(ProjectPlanController.class);
    @Autowired
    private ProjectGroupManager projectGroupManager;
    @Autowired
    private ProjectPlanManager projectPlanManager;
    @Autowired
    private ProjectDutyManager projectDutyManager;
    @Autowired
    private ProjectWordManager projectWordManager;
    @Autowired
    private ProjectLogManager projectLogManager;

    @RequestMapping(value = "/getlist",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询项目计划")
    public OfficeResopnseBean getProjectHavePlanList(@RequestParam String context,@RequestParam Integer pageNo,@RequestParam Integer pageSize, HttpServletRequest request){
        String projectManager = ContextUtils.getUserId(request);
        Result<ProjectHavePlanVO> result = projectPlanManager.findByProjectManager(projectManager,context,pageNo-1,pageSize);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        logger.info("{}获取项目计划列表成功！",projectManager);
        return responseBean;

    }

    @RequestMapping(value = "/getdetail",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询项目计划详情")
    public OfficeResopnseBean findPlanDetailByPlanId(@RequestParam Integer planId,HttpServletRequest request){
        List<ProjectPlanDetailVO>  detailVOS = projectPlanManager.findPlanDetailByPlanId(planId);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(detailVOS);
        logger.info("获取计划详细列表成功！，计划id:{}",planId);
        return responseBean;
    }

    @RequestMapping(value = "/getstandardword",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询计划维护标准文档列表")
    public OfficeResopnseBean findProjectStandardWord(@RequestBody ProjectStandardWordQueryCnd cnd, HttpServletRequest request){
        Result<ProjectStandardWordVO> projectStandardWordVOs = projectPlanManager.getProjectStandardWordList(cnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(projectStandardWordVOs);
        logger.info("获取计划计划维护标准文档列表");
        return responseBean;
    }

    @RequestMapping(value = "/saveall",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.SAVE,operDesc = "保存计划明细")
    public OfficeResopnseBean saveAllProjectPlanDetail(@RequestBody ProjectPlanAndDetailVO planAndDetail,HttpServletRequest request){
        String userId = ContextUtils.getUserId(request);
        ProjectPlanVO projectPlanVO = projectPlanManager.saveProjectPlanAndDetail(userId,planAndDetail);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(projectPlanVO);
        logger.info("保存计划明细全部成功！");
        return responseBean;
    }

    @RequestMapping(value = "/planhaveworklog",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询项目阶段是否有日志")
    public OfficeResopnseBean getByMilepostIdIn(@RequestBody List<Integer> milePostIdList, HttpServletRequest request){
        Boolean haveWorkLog = projectPlanManager.getByMilepostId(milePostIdList);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(haveWorkLog);
        logger.info("获取阶段是否有日志成功！");
        return responseBean;
    }

    /**
     * 功能描述:获取项目计划-成员管理项目分组
     */
    @RequestMapping(value = "/groupstree",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询项目计划-成员管理项目组")
    public OfficeResopnseBean getProjectGroupsTree(@RequestParam String contractNo){
        List<ProjectGroupViewVO> projectGroupsTree = projectGroupManager.getProjectGroupsTree(contractNo);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(projectGroupsTree);
        logger.info("获取项目计划-成员管理项目组列表成功");
        return responseBean;
    }

    //保存项目组节点信息
    @RequestMapping(value = "/savetreenode/{flag}",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.SAVE,operDesc = "保存项目组")
    public OfficeResopnseBean saveProjectGroupTreeNode(@RequestBody ProjectGroupVO projectGroupVO, @PathVariable("flag") Integer flag){
        projectGroupManager.saveProjectGroup(projectGroupVO, flag);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        logger.info("项目计划-成员管理保存项目组节点成功！");
        return responseBean;
    }

    //删除项目组节点信息
    @RequestMapping(value = "/deletetreenode",method = RequestMethod.DELETE)
    @OperLog(operType = OperLogType.DELETE,operDesc = "删除项目组")
    public OfficeResopnseBean deleteProjectGroupTreeNode(@RequestParam Integer groupId){
        projectGroupManager.deleteProjectGroup(groupId);
        OfficeResopnseBean responseBean = new OfficeResopnseBean();
        responseBean.setCode(200);
        responseBean.setMsg("删除成功！");
        logger.info("项目计划-成员管理删除项目组节点成功！");
        return responseBean;
    }

    //查找指定成员管理条件的项目组成员
    @RequestMapping(value = "/conditionalmembers/{contractNo}",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询指定条件的项目组成员")
    public OfficeResopnseBean getProjectGroupMembersByCondition(@RequestParam("inputContent") String inputContent,
                                                                @RequestParam("pageSize") Integer pageSize,
                                                                @RequestParam("pageNo") Integer pageNo,
                                                                @PathVariable("contractNo") String contractNo){
        Map<String,Object> result = new HashMap<>();
        List<Integer> groupIds = new ArrayList<>();
        //成员管理
        Result<ProjectGroupDetailViewVO> queryResult = projectGroupManager.getProjectGroupMembers(contractNo, inputContent, pageSize, pageNo);
        List<ProjectGroupDetailViewVO> items = queryResult.getItems();
        items.stream().forEach(item -> groupIds.add(item.getGroupId()));
        result.put("members",queryResult);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        logger.info("项目计划-成员管理获取指定条件的项目组成员成功");
        return responseBean;
    }

    //获取项目组成员列表
    @RequestMapping(value = "/memberslist",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询项目组成员")
    public OfficeResopnseBean getProjectGroupMembersList(@RequestParam Integer groupId,
                                                         @RequestParam Integer pageSize,
                                                         @RequestParam Integer pageNo){
        Result<ProjectGroupDetailViewVO> result = projectGroupManager.getProjectGroupMembersList(groupId, pageSize, pageNo);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        logger.info("项目计划-成员管理获取项目组成员列表成功！");
        return responseBean;
    }

    //批量保存/删除/修改项目组成员
    @RequestMapping(value = "/savemembers/{contractNo}",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.SAVE,operDesc = "批量保存项目组成员")
    public OfficeResopnseBean saveProjectGroupMembers(@RequestBody List<ProjectGroupDetailVO> members,
                                                      @RequestParam(name="deleteList",required = false) List<Integer> deleteList,
                                                      @RequestParam(name="updateList",required = false) List<Integer> updateList,
                                                      @PathVariable("contractNo") String contractNo){
        if (deleteList == null) {
            deleteList = new ArrayList<>();
        }
        if (updateList == null) {
            updateList = new ArrayList<>();
        }
        // members:需要保存的列表, deleteList: 需要删除的成员id列表, 查询时组员修改成组长，updateList:原组长的明细id
        Set<String> personIds = projectGroupManager.saveProjectGroupMembers(contractNo, members, deleteList, updateList);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(personIds);
        logger.info("项目计划-成员管理批量保存项目组成员成功");
        return responseBean;
    }

    @RequestMapping(value = "/dutymilepost",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询责任书里程碑")
    public OfficeResopnseBean getDutyMilepostList(@RequestParam String contractNo,HttpServletRequest request){
        String userId = ContextUtils.getUserId(request);
        List<ProjectDutyMilepostVO> milepostVOS = projectDutyManager.getDutyMilepostsWithPlan(contractNo);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(milepostVOS);
        logger.info("项目计划-获取责任书里程碑成功！登录人员:{}",userId);
        return responseBean;
    }

    @RequestMapping(value = "/milepostwordnums",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询责任书里程碑已上传文档数量")
    public OfficeResopnseBean getMilepostWordNums(@RequestParam String contractNo,@RequestParam String projectId,@RequestParam Integer milepostId ,HttpServletRequest request){
        String userId = ContextUtils.getUserId(request);
        List<Map<String, Object>> result = projectWordManager.getDocumentDisplayListWithPlan(contractNo,projectId ,milepostId);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        logger.info("计划维护-获取责任书里程碑已上传文档数量成功！登录人员:{}",userId);
        return responseBean;
    }


    @RequestMapping(value = "/getfileuploadtype",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询责任书里程碑上传文档格式")
    public OfficeResopnseBean getFileTypes(HttpServletRequest request){
        String userId = ContextUtils.getUserId(request);
        List<PublicDicVO> result = projectWordManager.getFileTypes();
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        logger.info("计划维护-获取责任书里程碑上传文档格式！登录人员:{}",userId);
        return responseBean;
    }

    @GetMapping(value = "/loadstagedocumentheader")
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询标准文档表头")
    public OfficeResopnseBean loadStageDocumentHeader(@RequestParam String contractNo,@RequestParam Integer dutyMilepostId){
        try{
            OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
            List<StageDocumentHeaderVO> header = projectLogManager.getStageDocumentHeader(contractNo,dutyMilepostId);
            bean.setBody(header);
            return bean;
        }catch (Exception e) {
            e.printStackTrace();
            OfficeResopnseBean responseBean = OfficeResopnseBean.newFailBean(500,"获取表头失败");
            return responseBean;
        }
    }

    @GetMapping(value = "/loadstagedocument")
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询阶段文档信息")
    public OfficeResopnseBean loadStageDocument(@RequestParam String contractNo,@RequestParam String projectId,@RequestParam Integer dutyMilepostId){
        try{
            OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
            List<Map<String,Object>> header = projectLogManager.getStageDocument(contractNo,projectId,dutyMilepostId);
            bean.setBody(header);
            return bean;
        }catch (Exception e) {
            e.printStackTrace();
            OfficeResopnseBean responseBean = OfficeResopnseBean.newFailBean(500,"获取阶段文档信息失败");
            return responseBean;
        }
    }

}
