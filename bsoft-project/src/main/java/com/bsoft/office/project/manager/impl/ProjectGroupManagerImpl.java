package com.bsoft.office.project.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.project.manager.ProjectGroupManager;
import com.bsoft.office.project.vo.*;
import com.bsoft.project.dto.*;
import com.bsoft.project.service.ProjectGroupService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProjectGroupManagerImpl implements ProjectGroupManager {
    @Reference(timeout = 60000)
    private ProjectGroupService projectGroupService;
    @Autowired
    private IGenerator iGenerator;

    public List<ProjectGroupViewVO> getProjectGroupsTree(String contractNo) {
        List<ProjectGroupViewDTO> projectGroupsList = projectGroupService.getProjectGroupsTree(contractNo);
        List<ProjectGroupViewVO> projectGroupsTree = iGenerator.convert(projectGroupsList, ProjectGroupViewVO.class);
        return projectGroupsTree;
    }

    public List<ProjectGroupViewVO> getLeaderSelfProjectGroupsTree(String personId, String contractNo) {
        List<ProjectGroupViewDTO> projectGroupsList = projectGroupService.getLeaderSelfProjectGroupsTree(personId,contractNo);
        List<ProjectGroupViewVO> projectGroupsTree = iGenerator.convert(projectGroupsList, ProjectGroupViewVO.class);
        return projectGroupsTree;
    }

    @Override
    public void saveProjectGroup(ProjectGroupVO projectGroupVO, Integer flag) {
        //同级向上（下）新增子节点
        if (flag == 1 || flag == 2) {
            this.appendSameLevelTreeNode(flag, projectGroupVO);
        }
        //新增子节点
        if (flag == 3) {
            this.appendChildTreeNode(projectGroupVO);
        }
        //修改节点
        if (flag == 4) {
            ProjectGroupDTO projectGroupDTO = iGenerator.convert(projectGroupVO, ProjectGroupDTO.class);
            projectGroupService.saveProjectGroup(projectGroupDTO);
        }
    }

    public void deleteProjectGroup(Integer groupId) {
        projectGroupService.deleteProjectGroup(groupId);
    }

    public Set<String> saveProjectGroupMembers (String contractNo, List<ProjectGroupDetailVO> saveList, List<Integer> deleteList, List<Integer> updateList) {
        List<ProjectGroupDetailDTO> members = saveList.stream().map(projectGroupDetailVO -> iGenerator.convert(projectGroupDetailVO, ProjectGroupDetailDTO.class)).collect(Collectors.toList());
        Set<String> personIds = projectGroupService.saveProjectGroupMembers(contractNo, members, deleteList, updateList);
        return personIds;
    }

    public Result<ProjectGroupDetailViewVO> getProjectGroupMembers(String contractNo, String inputContent, Integer pageSize, Integer pageNo) {
        Result<ProjectGroupDetailViewDTO> projectGroupMembersResult = projectGroupService.getProjectGroupMembers(contractNo, inputContent, pageSize, pageNo);
        Result<ProjectGroupDetailViewVO> result = iGenerator.convert(projectGroupMembersResult, ProjectGroupDetailViewVO.class);
        return result;
    }

    public Result<ProjectGroupDetailViewVO> getProjectLeaderGroupMembers(String contractNo, String personId, String inputContent, Integer pageSize, Integer pageNo) {
        Result<ProjectGroupDetailViewDTO> projectGroupMembersResult = projectGroupService.getProjectLeaderGroupMembers(contractNo, personId, inputContent, pageSize, pageNo);
        Result<ProjectGroupDetailViewVO> result = iGenerator.convert(projectGroupMembersResult, ProjectGroupDetailViewVO.class);
        return result;
    }

    public Result<ProjectGroupDetailViewVO> getProjectGroupMembersList(Integer groupId, Integer pageSize, Integer pageNo) {
        Result<ProjectGroupDetailViewDTO> projectGroupMembersList = projectGroupService.getProjectGroupMembersList(groupId, pageSize, pageNo);
        Result<ProjectGroupDetailViewVO> result = iGenerator.convert(projectGroupMembersList, ProjectGroupDetailViewVO.class);
        return result;
    }

    public Result<ProjectGroupLeaderSelfViewVO> getLeaderSelfProjectList(String personId , Integer pageSize, Integer pageNo) {
        Result<ProjectGroupLeaderSelfViewDTO> projectGroupMembersResult = projectGroupService.getLeaderSelfProjectList(personId, pageSize, pageNo);
        Result<ProjectGroupLeaderSelfViewVO> result = iGenerator.convert(projectGroupMembersResult, ProjectGroupLeaderSelfViewVO.class);
        return result;
    }

    private void appendSameLevelTreeNode (Integer flag, ProjectGroupVO projectGroupVO) {
        Integer sortNo = projectGroupVO.getSortNo();
        Integer parentId = projectGroupVO.getParentId();
        String contractNo = projectGroupVO.getContractNo();
        List<ProjectGroupDTO> result = projectGroupService.getProjectChildGroups(contractNo, parentId);
        List<ProjectGroupVO> projectGroupsList = iGenerator.convert(result, ProjectGroupVO.class);
        //同级向上新增
        if(flag == 1) {
            projectGroupsList.add(sortNo - 1, projectGroupVO);
        } else {
            //同级向下新增
            projectGroupsList.add(sortNo, projectGroupVO);
        }
        for (int i = 0; i < projectGroupsList.size(); i++) {
            ProjectGroupVO data = projectGroupsList.get(i);
            data.setSortNo(i+1);
        }
        projectGroupService.saveProjectGroups(iGenerator.convert(projectGroupsList, ProjectGroupDTO.class));
    }

    //新增子节点
    private void appendChildTreeNode(ProjectGroupVO projectGroupVO) {
        String contractNo = projectGroupVO.getContractNo();
        Integer parentId = projectGroupVO.getParentId();
        Integer childrenCount = projectGroupService.getProjectChildGroupsCount(contractNo, parentId);
        projectGroupVO.setSortNo(childrenCount + 1);
        ProjectGroupDTO projectGroupDTO = iGenerator.convert(projectGroupVO, ProjectGroupDTO.class);
        projectGroupService.saveProjectGroup(projectGroupDTO);
    }
}
