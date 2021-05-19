package com.bsoft.office.project.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.project.manager.ProjectGroupManager;
import com.bsoft.office.project.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @BelongsProject: bsoft-office-server
 * @BelongsPackage: com.bsoft.controller
 * @Author: Xuhui Lin
 * @CreateTime: 2020-02-07
 * @Description:
 */
@RestController
@RequestMapping(value="/projectgroup")
public class ProjectGroupController {
    private static Logger logger  = LoggerFactory.getLogger(ProjectGroupController.class);

    @Autowired
    private ProjectGroupManager projectGroupManager;

    /**
     *功能描述: 获取组员维护项目分组
     */
    @RequestMapping(value = "/groupstree",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取组员维护项目分组")
    public OfficeResopnseBean getLeaderSelfProjectGroupsTree(@RequestParam String contractNo,HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        List<ProjectGroupViewVO> projectGroupsTree = projectGroupManager.getLeaderSelfProjectGroupsTree(personId, contractNo);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(projectGroupsTree);
        logger.info("获取组员维护项目组列表成功");
        return responseBean;
    }

    //保存项目组节点信息
    @RequestMapping(value = "/savetreenode/{flag}",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.QUERY,operDesc = "项目责任书管理列表")
    public OfficeResopnseBean saveProjectGroupTreeNode(@RequestBody ProjectGroupVO projectGroupVO, @PathVariable("flag") Integer flag){
        projectGroupManager.saveProjectGroup(projectGroupVO,flag);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        logger.info("组员维护保存项目组节点成功！");
        return responseBean;
    }

    //删除项目组节点信息
    @RequestMapping(value = "/deletetreenode",method = RequestMethod.DELETE)
    @OperLog(operType = OperLogType.DELETE,operDesc = "删除项目组节点信息")
    public OfficeResopnseBean deleteProjectGroupTreeNode(@RequestParam Integer groupId){
        projectGroupManager.deleteProjectGroup(groupId);
        OfficeResopnseBean responseBean = new OfficeResopnseBean();
        responseBean.setCode(200);
        responseBean.setMsg("删除成功！");
        logger.info("组员维护删除项目组节点成功！");
        return responseBean;
    }

    //查找指定成员管理条件的项目组成员
    @RequestMapping(value = "/conditionalmembers/{contractNo}",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查找指定成员管理条件的项目组成员")
    public OfficeResopnseBean getProjectGroupMembersByCondition(@RequestParam("inputContent") String inputContent,
                                                                @RequestParam("pageSize") Integer pageSize,
                                                                @RequestParam("pageNo") Integer pageNo,
                                                                @PathVariable("contractNo") String contractNo,
                                                                HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        Map<String,Object> result = new HashMap<> ();
        List<Integer> groupIds = new ArrayList<>();
        Result<ProjectGroupDetailViewVO> queryResult = projectGroupManager.getProjectLeaderGroupMembers(contractNo, personId, inputContent, pageSize, pageNo);
        List<ProjectGroupDetailViewVO> items = queryResult.getItems();
        items.stream().forEach(item -> groupIds.add(item.getGroupId()));
        result.put("members",queryResult);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        logger.info("组员维护获取指定条件的项目组成员成功");
        return responseBean;
    }

    //获取项目组成员列表
    @RequestMapping(value = "/memberslist",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "项目组成员列表")
    public OfficeResopnseBean getProjectGroupMembersList(@RequestParam Integer groupId,
                                                         @RequestParam Integer pageSize,
                                                         @RequestParam Integer pageNo){
        Result<ProjectGroupDetailViewVO> result = projectGroupManager.getProjectGroupMembersList(groupId, pageSize, pageNo);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        logger.info("组员维护获取项目组成员列表成功！");
        return responseBean;
    }

    //批量保存/删除/修改项目组成员
    @RequestMapping(value = "/savemembers/{contractNo}",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.OTHER,operDesc = "批量保存/删除/修改项目组成员")
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
        logger.info("组员维护批量保存项目组成员成功");
        return responseBean;
    }

    //获取组长为自身所管理项目列表
    @RequestMapping(value = "/projectlist",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取组长为自身所管理项目列表")
    public OfficeResopnseBean getLeaderSelfProjectList(@RequestParam Integer pageSize,
                                                       @RequestParam Integer pageNo,
                                                       HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        Result<ProjectGroupLeaderSelfViewVO> result = projectGroupManager.getLeaderSelfProjectList(personId, pageSize, pageNo);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        logger.info("组员维护获取组长为自身所管理项目列表成功");
        return responseBean;
    }

}
