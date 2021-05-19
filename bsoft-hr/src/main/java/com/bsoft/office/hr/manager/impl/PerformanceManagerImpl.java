package com.bsoft.office.hr.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.common.service.ServerDateService;
import com.bsoft.hr.dto.PerformanceDTO;
import com.bsoft.hr.dto.PerformanceSaveResultDTO;
import com.bsoft.hr.service.PerformanceService;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.hr.manager.PerformanceManager;
import com.bsoft.office.hr.vo.PerformanceSaveResultVO;
import com.bsoft.office.hr.vo.PerformanceViewVO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/7/20 9:22
 * @Description
 */
@Service
public class PerformanceManagerImpl implements PerformanceManager {
    @Reference(timeout = 60000)
    private PerformanceService performanceService;
    @Autowired
    private ServerDateService serverDateService;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public Result<PerformanceViewVO> getPerformanceList(Integer year, String deptId, String inputContent, Integer pageNo, Integer pageSize) {
        Result<PerformanceDTO> result = performanceService.getPerformanceList(year, deptId, inputContent, pageNo, pageSize);
        return iGenerator.convert(result, PerformanceViewVO.class);
    }

    @Override
    public void deleteBatchPerformanceList(List<PerformanceViewVO> deletes) {
        List<PerformanceDTO> deleteDTOS = iGenerator.convert(deletes, PerformanceDTO.class);
        performanceService.deletePerformances(deleteDTOS);
    }

    @Override
    public List<PerformanceViewVO> getErrorPerformanceList(String personId) {
        List<PerformanceDTO> records = performanceService.getErrorPerformanceList(personId);
        return iGenerator.convert(records, PerformanceViewVO.class);
    }

    @Override
    public PerformanceSaveResultVO importPerformanceData(List<PerformanceViewVO> list, String personId) {
        List<PerformanceViewVO> needSaveData = new ArrayList<>();
        List<PerformanceViewVO> errorData = new ArrayList<>();
        Date currentDate = serverDateService.getServerDate();

        list.forEach(performanceViewVO -> {
            // 设置登记人（评价人）
            performanceViewVO.setEvaluationPerson(personId);
            // 设置登记日期（评价日期）
            performanceViewVO.setEvaluationDate(currentDate);
            // 将读取的数据转换成应保存的字段数据
            try {
                // 转换年份
                performanceViewVO.setYear(Integer.valueOf(performanceViewVO.getYearStr()));
                // 转换年度绩效分
                performanceViewVO.setPerformance(new BigDecimal(performanceViewVO.getPerformanceStr()).doubleValue());
                needSaveData.add(performanceViewVO);
            } catch(Exception e) {
                errorData.add(performanceViewVO);
            }
        });
        List<PerformanceDTO> needSaveDataDTO = iGenerator.convert(needSaveData, PerformanceDTO.class);
        List<PerformanceDTO> errorDataDTO = iGenerator.convert(errorData, PerformanceDTO.class);
        PerformanceSaveResultDTO result = performanceService.savePerformance(personId, needSaveDataDTO, errorDataDTO);
        return iGenerator.convert(result, PerformanceSaveResultVO.class);
    }
}
