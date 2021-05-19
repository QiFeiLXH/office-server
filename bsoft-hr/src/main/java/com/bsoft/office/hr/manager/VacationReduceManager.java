package com.bsoft.office.hr.manager;

import com.bsoft.common.result.Result;
import com.bsoft.hr.dto.VacationReduceDTO;
import com.bsoft.office.hr.condition.VacationReduceQueryCnd;
import com.bsoft.office.hr.vo.VacationReduceVO;

public interface VacationReduceManager {
    /**
     * 获取年假扣除情况列表
     * @param cnd
     * @return
     */
    Result<VacationReduceVO> getVacationReduceList(String personId, VacationReduceQueryCnd cnd);

    /**
     * 保存年假扣除信息
     * @param vacationReduce
     */
    void save(String personId,VacationReduceVO vacationReduce);
    /**
     * 删除未执行的年假扣除信息
     * @param personId
     * @param vacationReduce
     */
    void delete(String personId, VacationReduceVO vacationReduce);

    /**
     * 统一扣除年假
     * @param personId
     * @param year
     * @param days
     */
    void reduceAnnualVacationUnified(String personId,String year, Integer days,Integer reduceId);
}
