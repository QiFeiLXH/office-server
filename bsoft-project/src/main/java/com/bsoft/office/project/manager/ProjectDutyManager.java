package com.bsoft.office.project.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.project.condition.ProjectDutyQueryCnd;
import com.bsoft.office.project.vo.*;

import java.util.List;
import java.util.Map;

/**
 * @Author Xuhui Lin
 * @Date 2020/5/12 12:56
 * @Description
 */
public interface ProjectDutyManager {
    Result<ProjectDutyViewVO> getProjectDutyMaintainList(ProjectDutyQueryCnd cnd);

    Result<ProjectDutyAuditViewVO> getProjectDutyAuditList(ProjectDutyQueryCnd cnd);

    Result<ProjectDutyCustomerAndProjectSelectViewVO> getProjectDutyCustomerSelectList(Integer pageNo, Integer pageSize, String userId);

    List<ProjectDutyRegionViewVO> getProjectDutyRegionList(Integer dutyId);

    Result<ProjectDutyCustomerAndProjectSelectViewVO> getProjectDutyProjectSelectList(String userId, String customerId, Integer pageNo, Integer pageSize);

    String getProjectDutyNameNo(String customerId, String year);

    void deleteProjectDuty(Integer dutyId);

    Integer saveProjectDuty(ProjectDutyAndRegionVO projectDutyAndRegionVO, String userId);

    void auditProjectDutyList(List<ProjectDutyAuditSaveVO> auditSaveVOS, String userId);

    List<ProjectDutyMilepostVO> getDutyMilepostList(String contractNo);

    List<ProjectDutyMilepostVO> getDutyMilepostsWithPlan(String contractNo);

    void saveProjectDutyMilepost(List<ProjectDutyMilepostVO> projectDutyMilepostVOS, List<Integer> deletes);

    Result<ProjectDutyMilepostViewVO> getProjectDutyMliepost(String contractNo, Integer dutyId, Integer pageNo, Integer pageSize);

    List<ProjectDutyPaymentViewVO> getProjectDutyPayment(Integer dutyId);

    void saveProjectDutyPayment(List<ProjectDutyPaymentVO> saves, List<Integer> deletes);

    List<ProjectDutyAuditViewVO> exportProjectDutyAuditList(ProjectDutyQueryCnd cnd);

    ProjectDutyViewVO getProjectDutyView(Integer dutyId);

}
