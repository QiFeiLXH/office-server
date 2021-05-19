package com.bsoft.office.hr.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.hr.condition.TrainChartCnd;
import com.bsoft.office.hr.vo.TrainChartVO;

import java.util.List;


/**
 * @author: zy
 * @date: 2020/8/5 12:00
 */

public interface TrainChartManager {
    Result<TrainChartVO> getTrainChartList(TrainChartCnd cnd);
}
