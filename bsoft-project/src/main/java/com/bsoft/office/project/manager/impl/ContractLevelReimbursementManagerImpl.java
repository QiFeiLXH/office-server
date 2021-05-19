package com.bsoft.office.project.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.project.condition.ProjectReportQueryCnd;
import com.bsoft.office.project.manager.ContractLevelReimbursementManager;
import com.bsoft.office.project.vo.FinancialSubjectVO;
import com.bsoft.project.report.dto.FinancialSubjectDTO;
import com.bsoft.project.report.service.FinancialSubjectService;
import com.bsoft.project.report.service.ReimbursementCostService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Xuhui Lin
 * @Date 2020/4/26 14:20
 * @Description
 */
@Service
public class ContractLevelReimbursementManagerImpl implements ContractLevelReimbursementManager {
    private LinkedHashMap<String, String> baseContractLevelMap;
    @Reference(timeout = 60000)
    private FinancialSubjectService financialSubjectService;
    @Reference(timeout = 60000)
    private ReimbursementCostService reimbursementCostService;
    @Autowired
    private IGenerator iGenerator;
    @Override
    public List<FinancialSubjectVO> getCostSubjectColumns() {
        List<FinancialSubjectDTO> costSubject = financialSubjectService.findCostSubject();
        return iGenerator.convert(costSubject, FinancialSubjectVO.class);
    }
    @Override
    public Result<Map<String, String>> findContractLevelReimbursementCostAllSubtotal(ProjectReportQueryCnd queryCnd) {
        return reimbursementCostService.findReimburseConAllTotal(queryCnd.getStartYear(), queryCnd.getEndYear(), queryCnd.getPageNo(), queryCnd.getPageSize());
    }

    @Override
    public Map<String, Object> exportContractLevelReimbursementCostAllSubtotal(ProjectReportQueryCnd queryCnd) {
        List<Map<String, String>> records = reimbursementCostService.findReimburseConAllTotal(queryCnd.getStartYear(), queryCnd.getEndYear());
        LinkedHashMap<String, String> sheetHead = this.getSheetHead(null);

        Map<String, Object> colsAndData = new HashMap<>();
        colsAndData.put("head", sheetHead);
        colsAndData.put("data",records);
        return colsAndData;
    }

    @Override
    public Result<Map<String, String>> findContractLevelReimbursementCostAllYear(ProjectReportQueryCnd queryCnd) {
        return reimbursementCostService.findReimburseConAllYear(queryCnd.getStartYear(), queryCnd.getEndYear(), queryCnd.getPageNo(), queryCnd.getPageSize());
    }

    @Override
    public Map<String, Object> exportContractLevelReimbursementCostAllYear(ProjectReportQueryCnd queryCnd) {
        List<Map<String, String>> records = reimbursementCostService.findReimburseConAllYear(queryCnd.getStartYear(), queryCnd.getEndYear());
        LinkedHashMap<String, String> otherColumns = new LinkedHashMap<>();
        otherColumns.put("COSTYEAR","费用年度");
        LinkedHashMap<String, String> sheetHead = this.getSheetHead(otherColumns);

        Map<String, Object> colsAndData = new HashMap<>();
        colsAndData.put("head", sheetHead);
        colsAndData.put("data",records);
        return colsAndData;
    }

    @Override
    public Result<Map<String, String>> findContractLevelReimbursementCostAllMonth(ProjectReportQueryCnd queryCnd) {
        return reimbursementCostService.findReimburseConAllMonth(queryCnd.getStartYear(), queryCnd.getEndYear(), queryCnd.getPageNo(), queryCnd.getPageSize());
    }

    @Override
    public Map<String, Object> exportContractLevelReimbursementCostAllMonth(ProjectReportQueryCnd queryCnd) {
        List<Map<String, String>> records = reimbursementCostService.findReimburseConAllMonth(queryCnd.getStartYear(), queryCnd.getEndYear());
        LinkedHashMap<String, String> otherColumns = new LinkedHashMap<>();
        otherColumns.put("COSTQUARTER","费用季度");
        otherColumns.put("COSTMONTH","费用核算月份");
        LinkedHashMap<String, String> sheetHead = this.getSheetHead(otherColumns);

        Map<String, Object> colsAndData = new HashMap<>();
        colsAndData.put("head", sheetHead);
        colsAndData.put("data",records);
        return colsAndData;
    }

    @Override
    public Result<Map<String, String>> findContractLevelReimbursementCostDepSubtotal(ProjectReportQueryCnd queryCnd) {
        return reimbursementCostService.findReimburseConDepTotal(queryCnd.getStartYear(), queryCnd.getEndYear(), queryCnd.getPageNo(), queryCnd.getPageSize());
    }

    @Override
    public Map<String, Object> exportContractLevelReimbursementCostDepSubtotal(ProjectReportQueryCnd queryCnd) {
        List<Map<String, String>> records = reimbursementCostService.findReimburseConDepTotal(queryCnd.getStartYear(), queryCnd.getEndYear());
        LinkedHashMap<String, String> otherColumns = new LinkedHashMap<>();
        otherColumns.put("DEPTYPETEXT","费用产生部门类别");
        LinkedHashMap<String, String> sheetHead = this.getSheetHead(otherColumns);

        Map<String, Object> colsAndData = new HashMap<>();
        colsAndData.put("head", sheetHead);
        colsAndData.put("data",records);
        return colsAndData;
    }

    @Override
    public Result<Map<String, String>> findContractLevelReimbursementCostDepYear(ProjectReportQueryCnd queryCnd) {
        return reimbursementCostService.findReimburseConDepYear(queryCnd.getStartYear(), queryCnd.getEndYear(), queryCnd.getPageNo(), queryCnd.getPageSize());
    }

    @Override
    public Map<String, Object> exportContractLevelReimbursementCostDepYear(ProjectReportQueryCnd queryCnd) {
        List<Map<String, String>> records = reimbursementCostService.findReimburseConDepYear(queryCnd.getStartYear(), queryCnd.getEndYear());
        LinkedHashMap<String, String> otherColumns = new LinkedHashMap<>();
        otherColumns.put("COSTYEAR","费用年度");
        otherColumns.put("DEPTYPETEXT","费用产生部门类别");
        LinkedHashMap<String, String> sheetHead = this.getSheetHead(otherColumns);

        Map<String, Object> colsAndData = new HashMap<>();
        colsAndData.put("head", sheetHead);
        colsAndData.put("data",records);
        return colsAndData;
    }

    @Override
    public Result<Map<String, String>> findContractLevelReimbursementCostDepMonth(ProjectReportQueryCnd queryCnd) {
        return reimbursementCostService.findReimburseConDepMonth(queryCnd.getStartYear(), queryCnd.getEndYear(), queryCnd.getPageNo(), queryCnd.getPageSize());
    }

    @Override
    public Map<String, Object> exportContractLevelReimbursementCostDepMonth(ProjectReportQueryCnd queryCnd) {
        List<Map<String, String>> records = reimbursementCostService.findReimburseConDepMonth(queryCnd.getStartYear(), queryCnd.getEndYear());
        LinkedHashMap<String, String> otherColumns = new LinkedHashMap<>();
        otherColumns.put("COSTQUARTER","费用季度");
        otherColumns.put("COSTMONTH","费用核算月份");
        otherColumns.put("DEPTYPETEXT","费用产生部门类别");
        LinkedHashMap<String, String> sheetHead = this.getSheetHead(otherColumns);

        Map<String, Object> colsAndData = new HashMap<>();
        colsAndData.put("head", sheetHead);
        colsAndData.put("data",records);
        return colsAndData;
    }

    /**
     * 初始化项目级、合同级字段，用于Excel导出表头
     */
    private void initFields() {
        baseContractLevelMap = new LinkedHashMap<>();
        baseContractLevelMap.put("CAREERGROUPTEXT","事业群");
        baseContractLevelMap.put("LARGEAREATEXT","大区");
        baseContractLevelMap.put("SMALLAREATEXT","小区");
        baseContractLevelMap.put("MONEYBACKDEPTTEXT","回款业绩部门");
        baseContractLevelMap.put("SALEDEPTTEXT","销售业绩部门");
        baseContractLevelMap.put("CUSTOMERCODE","客户编码");
        baseContractLevelMap.put("CUSTOMERNAME","客户名称");
        baseContractLevelMap.put("CONTRACTNO","合同编号");
        baseContractLevelMap.put("CONTRACTNAME","合同名称");
        baseContractLevelMap.put("CONTRACTAMOUNT","合同金额");
        baseContractLevelMap.put("CONTRACTSOFTWAREAMOUNT","合同软件金额");
        baseContractLevelMap.put("SOFTWARESERVICEAMOUNT","软件与服务金额");
        baseContractLevelMap.put("DISCOUNT","折扣");
        baseContractLevelMap.put("CONTRACTSIGNINGDATE","合同签订日期");
        baseContractLevelMap.put("CONTRACTASSESSMENTDATE","合同考核日期");
    }

    /**
     * @param otherColumns 其他字段（除公共字段外）
     * @return
     */
    public LinkedHashMap<String, String> getSheetHead(LinkedHashMap<String, String> otherColumns) {
        List<FinancialSubjectVO> costSubjectCloumns = this.getCostSubjectColumns();
        LinkedHashMap<String, String> costColumns = new LinkedHashMap<>(60);
        costSubjectCloumns.forEach(column ->{
            costColumns.put("COSTTYPE_" + column.getId(),column.getCostSubject());
        });
        LinkedHashMap<String, String> head = new LinkedHashMap<>(90);

        head.putAll(baseContractLevelMap);
        if (otherColumns != null) {
            head.putAll(otherColumns);
        }
        head.putAll(costColumns);
        return head;

    }
}
