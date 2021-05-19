package com.bsoft.office.manager.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.manager.condition.OpinionQueryCnd;
import com.bsoft.office.manager.vo.OpinionVO;
import com.bsoft.opinion.dto.OpinionQueryCndDTO;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/8/5 15:27
 * @Description: 意见Manager
 */
public interface OpinionManager {
    /**
     * 查询意见列表
     * @param cnd
     * @return
     */
    Result<OpinionVO> getOpinions(OpinionQueryCnd cnd);

    /**
     * 查詢意見詳細信息
     * @param id 意見ID
     * @return
     */
    OpinionVO getOpinionsById(Integer id);

    /**
     * 审核意见
     * @param opinionVO
     */
    void auditOpinion(OpinionVO opinionVO);

    /**
     * 查询全部意见列表
     * @return
     */
    List<OpinionVO> findAllOpinion(OpinionQueryCnd cnd);
}
