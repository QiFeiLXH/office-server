package com.bsoft.office.hr.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.hr.dto.TrainChartCndDTO;
import com.bsoft.hr.dto.TrainChartDTO;
import com.bsoft.hr.service.TrainChartService;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.hr.condition.TrainChartCnd;
import com.bsoft.office.hr.controller.TrainChartController;
import com.bsoft.office.hr.manager.TrainChartManager;
import com.bsoft.office.hr.vo.TrainChartVO;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: zy
 * @date: 2020/8/5 12:00
 */

@Component
public class TrainChartManagerImpl implements TrainChartManager {
    private static final Logger logger = LoggerFactory.getLogger(TrainChartController.class);

    @Reference
    private TrainChartService trainChartService;
    @Autowired
    private IGenerator iGenerator;


    @Override
    public Result<TrainChartVO> getTrainChartList(TrainChartCnd cnd) {
        TrainChartCndDTO cndDTO = iGenerator.convert(cnd, TrainChartCndDTO.class);
        Result<TrainChartDTO> result = trainChartService.getTrainChartList(cndDTO);
        logger.info("获取培训情况[{}]", JSONUtils.toString(result));
        return iGenerator.convert(result, TrainChartVO.class);
    }
}
