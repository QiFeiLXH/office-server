package com.bsoft.office.project.manager.impl;

import com.bosft.progress.dto.ProgressManagerQueryCndDTO;
import com.bosft.progress.dto.ProjectExpandDTO;
import com.bosft.progress.dto.ProjectProgressManagerDTO;
import com.bsoft.common.result.Result;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.common.vo.DynamicTableHeaderVO;
import com.bsoft.office.project.condition.ProgressManagerQueryCnd;
import com.bsoft.office.project.manager.ProjectProgressManager;
import com.bsoft.office.project.vo.DeptProgressViewVO;
import com.bsoft.office.project.vo.ProjectExpandViewVO;
import com.bsoft.office.project.vo.ProjectProgressManagerVO;
import com.bsoft.office.project.vo.RegionProgressViewVO;
import com.bsoft.progress.service.ProjectProgressManagerService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author Xuhui Lin
 * @Date 2021/4/7 10:16
 * @Description
 */
@Service
public class ProjectProgressManagerImpl implements ProjectProgressManager {
    @Reference(check = false, timeout = 6000)
    private ProjectProgressManagerService projectProgressManagerService;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public Result<RegionProgressViewVO> getRegionProgressManagerList(ProgressManagerQueryCnd cnd) {
        ProgressManagerQueryCndDTO cndDTO = iGenerator.convert(cnd, ProgressManagerQueryCndDTO.class);
        Result<ProjectProgressManagerDTO> result = projectProgressManagerService.getRegionProgressManagerList(cndDTO);
        return iGenerator.convert(result, RegionProgressViewVO.class);
    }

    @Override
    public void saveRegionList(List<ProjectProgressManagerVO> regions) {
        List<ProjectProgressManagerDTO> managerDTOS = iGenerator.convert(regions, ProjectProgressManagerDTO.class);
        projectProgressManagerService.saveRegionList(managerDTOS);
    }

    @Override
    public void logoutRegion(String deptId) {
        projectProgressManagerService.logoutRegion(deptId);
    }

    @Override
    public void enableRegion(String deptId) {
        projectProgressManagerService.enableRegion(deptId);
    }

    @Override
    public List<DeptProgressViewVO> getDeptProgressManagerList(ProgressManagerQueryCnd cnd) {
        ProgressManagerQueryCndDTO cndDTO = iGenerator.convert(cnd, ProgressManagerQueryCndDTO.class);
        List<ProjectProgressManagerDTO> result = projectProgressManagerService.getDeptProgressManagerList(cndDTO);
        return iGenerator.convert(result, DeptProgressViewVO.class);
    }

    @Override
    public void saveDeptProgressManager(ProjectProgressManagerVO managerVO) {
        ProjectProgressManagerDTO managerDTO = iGenerator.convert(managerVO, ProjectProgressManagerDTO.class);
        projectProgressManagerService.saveDeptProgressManager(managerDTO);
    }

    @Override
    public List<DynamicTableHeaderVO> getDeptProgressManagerHeader(String userId, List<Integer> logout, String inputContent) {
        List<Integer> rowSpan = projectProgressManagerService.getDeptProgressManagerCount(userId,logout,inputContent);
        return this.getHeaderList(rowSpan);
    }

    @Override
    public List<DeptProgressViewVO> getAllDeptProgressManagerList(ProgressManagerQueryCnd cnd) {
        ProgressManagerQueryCndDTO cndDTO = iGenerator.convert(cnd, ProgressManagerQueryCndDTO.class);
        List<ProjectProgressManagerDTO> result = projectProgressManagerService.getAllDeptProgressManagerList(cndDTO);
        return iGenerator.convert(result, DeptProgressViewVO.class);
    }

    @Override
    public List<DynamicTableHeaderVO> getAllDeptProgressManagerHeader(List<Integer> logout, String inputContent) {
        List<Integer> rowSpan = projectProgressManagerService.getAllDeptProgressManagerCount(logout,inputContent);
        return this.getHeaderList(rowSpan);
    }

    @Override
    public Result<ProjectExpandViewVO> getProjectProgressManagerList(ProgressManagerQueryCnd cnd) {
        ProgressManagerQueryCndDTO cndDTO = iGenerator.convert(cnd, ProgressManagerQueryCndDTO.class);
        Result<ProjectExpandDTO> result = projectProgressManagerService.getProjectProgressManagerList(cndDTO);
        return iGenerator.convert(result, ProjectExpandViewVO.class);
    }

    @Override
    public void saveProjectProgressManager(ProjectExpandViewVO progressManager) {
        ProjectExpandDTO managerDTO = iGenerator.convert(progressManager, ProjectExpandDTO.class);
        projectProgressManagerService.saveProjectProgressManager(managerDTO);
    }

    private List<DynamicTableHeaderVO> getHeaderList(List<Integer> rowSpan) {
        DynamicTableHeaderVO h1 = DynamicTableHeaderVO.builder().title("一级区域").column("parentDeptName").rowSpan(rowSpan).width(100).ellipsis(false).build();
        DynamicTableHeaderVO h2 = DynamicTableHeaderVO.builder().title("区域进度管理员").column("regionManagerName").rowSpan(rowSpan).width(100).ellipsis(false).build();
        DynamicTableHeaderVO h3 = DynamicTableHeaderVO.builder().title("二级部门").column("deptName").width(100).ellipsis(false).scopedSlots(Map.of("customRender", "deptName")).build();
        DynamicTableHeaderVO h4 = DynamicTableHeaderVO.builder().title("部门进度管理员").column("managerName").width(100).ellipsis(true).scopedSlots(Map.of("customRender", "managerName")).build();
        DynamicTableHeaderVO h5 = DynamicTableHeaderVO.builder().title("操作").column("operation").width(100).ellipsis(false).scopedSlots(Map.of("customRender", "operation")).align("center").build();
        return Arrays.asList(h1,h2,h3,h4,h5);
    }
}
