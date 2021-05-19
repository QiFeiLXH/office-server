package com.bsoft.office.project.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.project.condition.ProjectLogChartQueryCnd;
import com.bsoft.office.project.vo.ProjectLogChartMonthVO;
import com.bsoft.office.project.vo.ProjectLogChartVO;

/**
 * @author: zy
 * @date: 2020/8/6 19:03
 */
public interface ProjectLogChartManager {
    Result<ProjectLogChartVO> getLogChartList(ProjectLogChartQueryCnd queryCnd);
    Result<ProjectLogChartMonthVO> getLogChartMonthList(ProjectLogChartQueryCnd queryCnd);
}
