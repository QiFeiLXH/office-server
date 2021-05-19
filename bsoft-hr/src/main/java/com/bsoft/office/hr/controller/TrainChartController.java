package com.bsoft.office.hr.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.hr.condition.TrainChartCnd;
import com.bsoft.office.hr.manager.TrainChartManager;
import com.bsoft.office.hr.vo.TrainChartVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: zy
 * @date: 2020/8/5 11:58
 */

@RestController
@RequestMapping("/trainreport")
public class TrainChartController {
    private static final Logger logger = LoggerFactory.getLogger(TrainChartController.class);

    @Autowired
    TrainChartManager trainChartManager;

    @PostMapping("/query")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取培训情况")
    public OfficeResopnseBean getTrainReport(@RequestBody TrainChartCnd cnd){
        logger.info("获取培训情况[{}]", JSONUtils.toString(cnd));
        Result<TrainChartVO> result = trainChartManager.getTrainChartList(cnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        return responseBean;
    }

}
