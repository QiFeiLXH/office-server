package com.bsoft.office.organ.manager.impl;

import com.bsoft.common.dto.ImportResultDTO;
import com.bsoft.common.result.Result;
import com.bsoft.common.service.PublicDicService;
import com.bsoft.common.service.ServerDateService;
import com.bsoft.office.organ.condition.FlowPaymentQueryCnd;
import com.bsoft.office.organ.manager.FlowPaymentManager;
import com.bsoft.office.organ.vo.PaymentFlowViewVO;
import com.bsoft.office.organ.vo.PaymentIncomeViewVO;
import com.bsoft.office.organ.vo.PublicDicVO;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.common.exportExcel.ImportResultVO;
import com.bsoft.payment.dto.FlowPaymentDTO;
import com.bsoft.payment.dto.FlowPaymentQueryCndDTO;
import com.bsoft.payment.service.FlowPaymentService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: bsoft-office-server
 * @BelongsPackage: com.bsoft.office.administration.manager.impl
 * @Author: Qi fei
 * @CreateTime: 2020-07-25 18:37
 * @Description:
 */
@Service
public class FlowPaymentManagerImpl implements FlowPaymentManager {
    @Reference (timeout = 60000)
    private FlowPaymentService flowPaymentService;
    @Autowired
    private ServerDateService serverDateService;
    @Reference
    private PublicDicService publicDicService;

    @Autowired
    private IGenerator iGenerator;
    @Override
    public Result<PaymentFlowViewVO> getPaymentFlowList(FlowPaymentQueryCnd flowPaymentQueryCnd) {
        FlowPaymentQueryCndDTO cndDTO = iGenerator.convert(flowPaymentQueryCnd, FlowPaymentQueryCndDTO.class);
        Result<FlowPaymentDTO> result = flowPaymentService.getFinancialPaymentList(cndDTO);
        return iGenerator.convert(result, PaymentFlowViewVO.class);
    }

    @Override
    public Result<PaymentIncomeViewVO> getPaymentIncomeList(FlowPaymentQueryCnd flowPaymentQueryCnd) {
        FlowPaymentQueryCndDTO cndDTO = iGenerator.convert(flowPaymentQueryCnd, FlowPaymentQueryCndDTO.class);
        Result<FlowPaymentDTO> result = flowPaymentService.getFinancialPaymentList(cndDTO);
        return iGenerator.convert(result, PaymentIncomeViewVO.class);
    }

    @Override
    public void deleteBatchFlowList(List<Integer> ids) {
        flowPaymentService.deleteFinancialPayments(ids);
    }

    @Override
    public void deleteBatchIncomeList(List<Integer> ids) {
        flowPaymentService.deleteFinancialPayments(ids);
    }

    @Override
    public ImportResultVO importPaymentFlowData(List<PaymentFlowViewVO> list, String personId) {
        List<PaymentFlowViewVO> needSaveData = new ArrayList<>();
        List<PaymentFlowViewVO> errorData = new ArrayList<>();
        Date currentDate = serverDateService.getServerDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");

        list.forEach(paymentFlowViewVO -> {
            // 设置导入的数据类型
            paymentFlowViewVO.setFlag(1);
            // 设置登记人
            paymentFlowViewVO.setRegister(personId);
            // 设置登记日期
            paymentFlowViewVO.setRegistrationDate(currentDate);
            // 设置审核标记
            paymentFlowViewVO.setAuditFlag(0);
            try {
                // 转换流水金额
                paymentFlowViewVO.setAmount(new BigDecimal(paymentFlowViewVO.getAmountStr()).doubleValue());
                // 转换核算时间
                paymentFlowViewVO.setAccountDate(sdf.parse(paymentFlowViewVO.getAccountDateStr()));
                needSaveData.add(paymentFlowViewVO);
            } catch (Exception e) {
                errorData.add(paymentFlowViewVO);
            }
        });

        List<FlowPaymentDTO> needSaveDataDTO = iGenerator.convert(needSaveData, FlowPaymentDTO.class);
        List<FlowPaymentDTO> errorDataDTO = iGenerator.convert(errorData, FlowPaymentDTO.class);
        ImportResultDTO importResultDTO = flowPaymentService.saveFinancialPayments(needSaveDataDTO, errorDataDTO, personId, 1);
        return iGenerator.convert(importResultDTO, ImportResultVO.class);
    }

    @Override
    public ImportResultVO importPaymentIncomeData(List<PaymentIncomeViewVO> list, String personId) {
        List<PaymentIncomeViewVO> needSaveData = new ArrayList<>();
        List<PaymentIncomeViewVO> errorData = new ArrayList<>();
        Date currentDate = serverDateService.getServerDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");

        list.forEach(paymentIncomeViewVO -> {
            // 设置导入的数据类型
            paymentIncomeViewVO.setFlag(2);
            // 设置登记人
            paymentIncomeViewVO.setRegister(personId);
            // 设置登记日期
            paymentIncomeViewVO.setRegistrationDate(currentDate);
            // 设置审核标记
            paymentIncomeViewVO.setAuditFlag(0);
            try {
                // 转换流水金额
                paymentIncomeViewVO.setAmount(new BigDecimal(paymentIncomeViewVO.getAmountStr()).doubleValue());
                // 转换核算时间
                paymentIncomeViewVO.setAccountDate(sdf.parse(paymentIncomeViewVO.getAccountDateStr()));

                needSaveData.add(paymentIncomeViewVO);
            } catch (Exception e) {
                errorData.add(paymentIncomeViewVO);
            }
        });

        List<FlowPaymentDTO> needSaveDataDTO = iGenerator.convert(needSaveData, FlowPaymentDTO.class);
        List<FlowPaymentDTO> errorDataDTO = iGenerator.convert(errorData, FlowPaymentDTO.class);
        ImportResultDTO importResultDTO = flowPaymentService.saveFinancialPayments(needSaveDataDTO, errorDataDTO, personId, 2);
        return iGenerator.convert(importResultDTO, ImportResultVO.class);
    }

    @Override
    public List<PaymentFlowViewVO> getErrorFlowList(String personId) {
        List<FlowPaymentDTO> list = flowPaymentService.getErrorFinancialPayments(personId, 1);
        return iGenerator.convert(list, PaymentFlowViewVO.class);
    }

    @Override
    public List<PaymentIncomeViewVO> getErrorIncomeList(String personId) {
        List<FlowPaymentDTO> list = flowPaymentService.getErrorFinancialPayments(personId, 2);
        return iGenerator.convert(list, PaymentIncomeViewVO.class);
    }

    @Override
    public void auditPaymentFlowList(List<PaymentFlowViewVO> flows, String personId) {
        List<FlowPaymentDTO> flowPaymentDTOS = iGenerator.convert(flows, FlowPaymentDTO.class);
        flowPaymentService.auditFinancialPayments(flowPaymentDTOS,personId);
    }

    @Override
    public void auditPaymentIncomeList(List<PaymentFlowViewVO> incomes, String personId) {
        List<FlowPaymentDTO> flowPaymentDTOS = iGenerator.convert(incomes, FlowPaymentDTO.class);
        flowPaymentService.auditFinancialPayments(flowPaymentDTOS,personId);
    }

    @Override
    public List<PublicDicVO> getBusinessLineDic() {
        return iGenerator.convert(publicDicService.getPublicDic(1506), PublicDicVO.class);
    }

    @Override
    public List<PublicDicVO> getTypeDic() {
        return iGenerator.convert(publicDicService.getPublicDic(1507), PublicDicVO.class);
    }
}
