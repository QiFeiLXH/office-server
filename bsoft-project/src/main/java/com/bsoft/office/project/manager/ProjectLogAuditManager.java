package com.bsoft.office.project.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.project.condition.WorkLogAuditCnd;
import com.bsoft.office.project.vo.*;

import java.util.List;
import java.util.Map;

/**
 * @Author zhanglf
 * @Date 2020-03-20 9:05
 * @Version 1.0
 * @Description
 */
public interface ProjectLogAuditManager {
    Result<ProjectLogNeedAuditVO> getProjectLogNeedAudit(String userId, WorkLogAuditCnd params);

    void auditProjectLogs(String userId,List<ProjectLogAuditVO> projectLogAuditVOS);

    Map<String,Object> getWorkLogById(Integer proWorkLogId, String projectId);

    ProjectLogVO saveWorkLog(ProjectLogBaseVO savaWorkLogVO);

    Result<ProjectWithAuditVO> getProjectWithAuditList(String userId, WorkLogAuditCnd params);

    Map<String,Object> getRoleAndType();
}
