package com.bsoft.office.project.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.project.condition.ProjectReportQueryCnd;
import com.bsoft.office.project.vo.*;

import java.util.List;

/**
 * @BelongsProject: bsoft-office-server
 * @BelongsPackage: com.bsoft.office.project.manager
 * @Author: Xuhui Lin
 * @CreateTime: 2020-04-02 09:36
 * @Description:
 */
public interface ProjectLevelAllManager {
    Result<ProjectLevelAllSubtotalVO> findProjectLevelAllSubtotal(ProjectReportQueryCnd queryCnd);

    List<ProjectLevelAllSubtotalVO> exportProjectLevelAllSubtotal(ProjectReportQueryCnd queryCnd);

    Result<ProjectLevelAllByYearVO> findProjectLevelAllYear(ProjectReportQueryCnd queryCnd);

    List<ProjectLevelAllByYearVO> exportProjectLevelAllYear(ProjectReportQueryCnd queryCnd);

    Result<ProjectLevelAllByMonthVO> findProjectLevelAllMonth(ProjectReportQueryCnd queryCnd);

    List<ProjectLevelAllByMonthVO> exportProjectLevelAllMonth(ProjectReportQueryCnd queryCnd);

    Result<ProjectLevelDepTypeSubtotalVO> findProjectLevelAllDepSubtotal(ProjectReportQueryCnd queryCnd);

    List<ProjectLevelDepTypeSubtotalVO> exportProjectLevelAllDepSubtotal(ProjectReportQueryCnd queryCnd);

    Result<ProjectLevelDepTypeByYearVO> findProjectLevelAllDepYear(ProjectReportQueryCnd queryCnd);

    List<ProjectLevelDepTypeByYearVO> exportProjectLevelAllDepYear(ProjectReportQueryCnd queryCnd);

    Result<ProjectLevelDepTypeByMonthVO> findProjectLevelAllDepMonth(ProjectReportQueryCnd queryCnd);

    List<ProjectLevelDepTypeByMonthVO> exportProjectLevelAllDepMonth(ProjectReportQueryCnd queryCnd);
}
