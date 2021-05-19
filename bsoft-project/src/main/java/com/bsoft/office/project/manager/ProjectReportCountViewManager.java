package com.bsoft.office.project.manager;

import com.bosft.progress.dto.ProjectReportCountQueryCndDTO;
import com.bsoft.common.result.Result;
import com.bsoft.office.project.condition.ProjectReportQueryCnd;
import com.bsoft.office.project.vo.*;

import java.util.List;

/**
 * @Author: lin kanghua
 * @CreateTime: 2020-04-02 09:36
 * @Description:
 */
public interface ProjectReportCountViewManager {
    Result<ProjectReportCountViewVO> getprojectReportCountViews(ProjectReportCountQueryCndDTO queryCnd);
}
