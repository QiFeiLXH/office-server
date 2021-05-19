package com.bsoft.office.organ.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.organ.condition.FlowPaymentQueryCnd;
import com.bsoft.office.organ.vo.PaymentFlowViewVO;
import com.bsoft.office.organ.vo.PaymentIncomeViewVO;
import com.bsoft.office.organ.vo.PublicDicVO;
import com.bsoft.office.common.exportExcel.ImportResultVO;

import java.util.List;

/**
 * @BelongsProject: bsoft-office-server
 * @BelongsPackage: com.bsoft.office.administration.manager
 * @Author: Qi fei
 * @CreateTime: 2020-07-25 18:36
 * @Description:
 */
public interface FlowPaymentManager {
    Result<PaymentFlowViewVO> getPaymentFlowList(FlowPaymentQueryCnd flowPaymentQueryCnd);

    Result<PaymentIncomeViewVO> getPaymentIncomeList(FlowPaymentQueryCnd flowPaymentQueryCnd);

    void deleteBatchFlowList(List<Integer> ids);

    void deleteBatchIncomeList(List<Integer> ids);

    ImportResultVO importPaymentFlowData(List<PaymentFlowViewVO> list, String personId);

    ImportResultVO importPaymentIncomeData(List<PaymentIncomeViewVO> list, String personId);

    List<PaymentFlowViewVO> getErrorFlowList(String personId);

    List<PaymentIncomeViewVO> getErrorIncomeList(String personId);

    void auditPaymentFlowList(List<PaymentFlowViewVO> flows, String personId);

    void auditPaymentIncomeList(List<PaymentFlowViewVO> incomes, String personId);

    List<PublicDicVO> getBusinessLineDic();

    List<PublicDicVO> getTypeDic();
}
