package com.bsoft.office.hr.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.hr.vo.PerformanceSaveResultVO;
import com.bsoft.office.hr.vo.PerformanceViewVO;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/7/20 9:22
 * @Description
 */
public interface PerformanceManager {
    Result<PerformanceViewVO> getPerformanceList(Integer year, String deptId, String inputContent, Integer pageNo, Integer pageSize);

    void deleteBatchPerformanceList(List<PerformanceViewVO> deletes);

    List<PerformanceViewVO> getErrorPerformanceList(String personId);

    PerformanceSaveResultVO importPerformanceData(List<PerformanceViewVO> list, String personId);
}
