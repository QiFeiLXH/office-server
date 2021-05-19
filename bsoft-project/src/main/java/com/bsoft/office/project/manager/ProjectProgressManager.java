package com.bsoft.office.project.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.vo.DynamicTableHeaderVO;
import com.bsoft.office.project.condition.ProgressManagerQueryCnd;
import com.bsoft.office.project.vo.DeptProgressViewVO;
import com.bsoft.office.project.vo.ProjectExpandViewVO;
import com.bsoft.office.project.vo.ProjectProgressManagerVO;
import com.bsoft.office.project.vo.RegionProgressViewVO;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2021/4/7 10:16
 * @Description
 */
public interface ProjectProgressManager {
    Result<RegionProgressViewVO> getRegionProgressManagerList(ProgressManagerQueryCnd cnd);

    void saveRegionList(List<ProjectProgressManagerVO> regions);

    void logoutRegion(String deptId);

    void enableRegion(String deptId);

    List<DeptProgressViewVO> getDeptProgressManagerList(ProgressManagerQueryCnd cnd);

    void saveDeptProgressManager(ProjectProgressManagerVO managerVO);

    List<DynamicTableHeaderVO> getDeptProgressManagerHeader(String userId, List<Integer> logout, String inputContent);

    List<DeptProgressViewVO> getAllDeptProgressManagerList(ProgressManagerQueryCnd cnd);

    List<DynamicTableHeaderVO> getAllDeptProgressManagerHeader(List<Integer> logout, String inputContent);

    Result<ProjectExpandViewVO> getProjectProgressManagerList(ProgressManagerQueryCnd cnd);

    void saveProjectProgressManager(ProjectExpandViewVO progressManager);
}
