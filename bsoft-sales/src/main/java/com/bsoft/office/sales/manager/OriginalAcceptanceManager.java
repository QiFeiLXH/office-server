package com.bsoft.office.sales.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.sales.condition.OriginalAcceptanceQueryCndVO;
import com.bsoft.office.sales.vo.OriginalAcceptanceVO;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/7/29 16:23
 * @Description: 合同原件审核Manager
 */
public interface OriginalAcceptanceManager {
    /**
     * 财务接收审核列表
     */
    Result<OriginalAcceptanceVO> getFinancialReceptionList(OriginalAcceptanceQueryCndVO cndVO);

    /**
     * 财务接收
     * @param words 接收的文档记录列表
     * @param userId 接收人工号
     */
    void auditFinancialReception(List<OriginalAcceptanceVO> words, String userId);
    /**
     * 财务归档列表
     * @return
     */
    Result<OriginalAcceptanceVO> getFinancialFilingList(OriginalAcceptanceQueryCndVO cndVO);

    /**
     * 财务归档
     * @param words
     * @param userId
     */
    void auditFinanceFill(List<OriginalAcceptanceVO> words,String userId);
    /**
     * 法务接收列表
     */
    Result<OriginalAcceptanceVO> getLegalReceptionList(OriginalAcceptanceQueryCndVO cndVO);

    /**
     * 法务接收
     * @param words
     * @param userId
     */
    void auditLegalReception(List<OriginalAcceptanceVO> words,String userId);
}
