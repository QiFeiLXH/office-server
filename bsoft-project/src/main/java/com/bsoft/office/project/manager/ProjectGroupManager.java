package com.bsoft.office.project.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.project.vo.*;

import java.util.List;
import java.util.Set;

public interface ProjectGroupManager {
    List<ProjectGroupViewVO> getProjectGroupsTree(String contractNo);
    List<ProjectGroupViewVO> getLeaderSelfProjectGroupsTree(String personId, String contractNo);
    void saveProjectGroup(ProjectGroupVO projectGroupVO, Integer flag);
    void deleteProjectGroup(Integer groupId);
    Set<String> saveProjectGroupMembers (String contractNo, List<ProjectGroupDetailVO> saveList, List<Integer> deleteList, List<Integer> updateList);
    Result<ProjectGroupDetailViewVO> getProjectGroupMembers(String contractNo, String inputContent, Integer pageSize, Integer pageNo);
    Result<ProjectGroupDetailViewVO> getProjectLeaderGroupMembers(String contractNo, String personId, String inputContent, Integer pageSize, Integer pageNo);
    Result<ProjectGroupDetailViewVO> getProjectGroupMembersList(Integer groupId, Integer pageSize, Integer pageNo);
    Result<ProjectGroupLeaderSelfViewVO> getLeaderSelfProjectList(String personId , Integer pageSize, Integer pageNo);
}
