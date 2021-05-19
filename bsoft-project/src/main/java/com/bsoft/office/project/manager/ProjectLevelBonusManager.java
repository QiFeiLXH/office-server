package com.bsoft.office.project.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.project.condition.ProjectReportQueryCnd;
import com.bsoft.office.project.vo.*;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/4/26 14:15
 * @Description
 */
public interface ProjectLevelBonusManager {
    Result<ProjectLevelBonusAllSubtotalVO> getProjectLevelBonusAllSubtotal(ProjectReportQueryCnd queryCnd);

    List<ProjectLevelBonusAllSubtotalVO> exportProjectLevelBonusAllSubtotal(ProjectReportQueryCnd queryCnd);

    Result<ProjectLevelBonusAllByYearVO> getProjectLevelBonusAllYear(ProjectReportQueryCnd queryCnd);

    List<ProjectLevelBonusAllByYearVO> exportProjectLevelBonusAllYear(ProjectReportQueryCnd queryCnd);

    Result<ProjectLevelBonusAllByMonthVO> getProjectLevelBonusAllMonth(ProjectReportQueryCnd queryCnd);

    List<ProjectLevelBonusAllByMonthVO> exportProjectLevelBonusAllMonth(ProjectReportQueryCnd queryCnd);

    Result<ProjectLevelBonusDepTypeSubtotalVO> getProjectLevelBonusDepSubtotal(ProjectReportQueryCnd queryCnd);

    List<ProjectLevelBonusDepTypeSubtotalVO> exportProjectLevelBonusDepSubtotal(ProjectReportQueryCnd queryCnd);

    Result<ProjectLevelBonusDepTypeByYearVO> getProjectLevelBonusDepYear(ProjectReportQueryCnd queryCnd);

    List<ProjectLevelBonusDepTypeByYearVO> exportProjectLevelBonusDepYear(ProjectReportQueryCnd queryCnd);

    Result<ProjectLevelBonusDepTypeByMonthVO> getProjectLevelBonusDepMonth(ProjectReportQueryCnd queryCnd);

    List<ProjectLevelBonusDepTypeByMonthVO> exportProjectLevelBonusDepMonth(ProjectReportQueryCnd queryCnd);
}
