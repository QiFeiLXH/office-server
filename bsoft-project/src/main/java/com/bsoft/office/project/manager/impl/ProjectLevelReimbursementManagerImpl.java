package com.bsoft.office.project.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.project.condition.ProjectReportQueryCnd;
import com.bsoft.office.project.manager.ProjectLevelReimbursementManager;
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
public class ProjectLevelReimbursementManagerImpl implements ProjectLevelReimbursementManager {
    private LinkedHashMap<String, String> baseProjectLevelMap;
    @Reference(timeout = 60000)
    private FinancialSubjectService financialSubjectService;
    @Reference(timeout = 60000)
    private ReimbursementCostService reimbursementCostService;
    @Autowired
    private IGenerator iGenerator;
    {
        initFields();
    }

    @Override
    public List<FinancialSubjectVO> getCostSubjectColumns() {
        List<FinancialSubjectDTO> costSubject = financialSubjectService.findCostSubject();
        return iGenerator.convert(costSubject, FinancialSubjectVO.class);
    }

    @Override
    public Result<Map<String, String>> findProjectLevelReimbursementCostAllSubtotal(ProjectReportQueryCnd queryCnd) {
        return reimbursementCostService.findReimburseProAllTotal(queryCnd.getStartYear(), queryCnd.getEndYear(), queryCnd.getPageNo(), queryCnd.getPageSize());
    }

    @Override
    public Map<String, Object> exportProjectLevelReimbursementCostAllSubtotal(ProjectReportQueryCnd queryCnd) {
        List<Map<String, String>> records = reimbursementCostService.findReimburseProAllTotal(queryCnd.getStartYear(), queryCnd.getEndYear());
        LinkedHashMap<String, String> sheetHead = this.getSheetHead(null);
        Map<String, Object> colsAndData = new HashMap<>();
        colsAndData.put("head", sheetHead);
        colsAndData.put("data",records);
        return colsAndData;
    }

    @Override
    public Result<Map<String, String>> findProjectLevelReimbursementCostAllYear(ProjectReportQueryCnd queryCnd) {
        return reimbursementCostService.findReimburseProAllYear(queryCnd.getStartYear(), queryCnd.getEndYear(), queryCnd.getPageNo(), queryCnd.getPageSize());
    }

    @Override
    public Map<String, Object> exportProjectLevelReimbursementCostAllYear(ProjectReportQueryCnd queryCnd) {
        List<Map<String, String>> records = reimbursementCostService.findReimburseProAllYear(queryCnd.getStartYear(), queryCnd.getEndYear());
        LinkedHashMap<String, String> otherColumns = new LinkedHashMap<>();
        otherColumns.put("COSTYEAR","费用年度");
        LinkedHashMap<String, String> sheetHead = this.getSheetHead(otherColumns);

        Map<String, Object> colsAndData = new HashMap<>();
        colsAndData.put("head", sheetHead);
        colsAndData.put("data",records);
        return colsAndData;
    }

    @Override
    public Result<Map<String, String>> findProjectLevelReimbursementCostAllMonth(ProjectReportQueryCnd queryCnd) {
        return reimbursementCostService.findReimburseProAllMonth(queryCnd.getStartYear(), queryCnd.getEndYear(), queryCnd.getPageNo(), queryCnd.getPageSize());
    }

    @Override
    public Map<String, Object> exportProjectLevelReimbursementCostAllMonth(ProjectReportQueryCnd queryCnd) {
        List<Map<String, String>> records = reimbursementCostService.findReimburseProAllMonth(queryCnd.getStartYear(), queryCnd.getEndYear());
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
    public Result<Map<String, String>> findProjectLevelReimbursementCostDepSubtotal(ProjectReportQueryCnd queryCnd) {
        return reimbursementCostService.findReimburseProDepTotal(queryCnd.getStartYear(), queryCnd.getEndYear(), queryCnd.getPageNo(), queryCnd.getPageSize());
    }

    @Override
    public Map<String, Object> exportProjectLevelReimbursementCostDepSubtotal(ProjectReportQueryCnd queryCnd) {
        List<Map<String, String>> records = reimbursementCostService.findReimburseProDepTotal(queryCnd.getStartYear(), queryCnd.getEndYear());
        LinkedHashMap<String, String> otherColumns = new LinkedHashMap<>();
        otherColumns.put("DEPTYPETEXT","费用产生部门类别");
        LinkedHashMap<String, String> sheetHead = this.getSheetHead(otherColumns);

        Map<String, Object> colsAndData = new HashMap<>();
        colsAndData.put("head", sheetHead);
        colsAndData.put("data",records);
        return colsAndData;
    }

    @Override
    public Result<Map<String, String>> findProjectLevelReimbursementCostDepYear(ProjectReportQueryCnd queryCnd) {
        return reimbursementCostService.findReimburseProDepYear(queryCnd.getStartYear(), queryCnd.getEndYear(), queryCnd.getPageNo(), queryCnd.getPageSize());
    }

    @Override
    public Map<String, Object> exportProjectLevelReimbursementCostDepYear(ProjectReportQueryCnd queryCnd) {
        List<Map<String, String>> records = reimbursementCostService.findReimburseProDepYear(queryCnd.getStartYear(), queryCnd.getEndYear());
        LinkedHashMap<String, String> otherColumns = new LinkedHashMap<>();
        otherColumns.put("COSTYEAR","费用年度");
        otherColumns.put("DEPTYPETEXT","费用产生部门类别");
        LinkedHashMap<String, String> sheetHead = this.getSheetHead( otherColumns);

        Map<String, Object> colsAndData = new HashMap<>();
        colsAndData.put("head", sheetHead);
        colsAndData.put("data",records);
        return colsAndData;
    }

    @Override
    public Result<Map<String, String>> findProjectLevelReimbursementCostDepMonth(ProjectReportQueryCnd queryCnd) {
        return reimbursementCostService.findReimburseProDepMonth(queryCnd.getStartYear(), queryCnd.getEndYear(), queryCnd.getPageNo(), queryCnd.getPageSize());
    }

    @Override
    public Map<String, Object> exportProjectLevelReimbursementCostDepMonth(ProjectReportQueryCnd queryCnd) {
        List<Map<String, String>> records = reimbursementCostService.findReimburseProDepMonth(queryCnd.getStartYear(), queryCnd.getEndYear());
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
        baseProjectLevelMap = new LinkedHashMap<>();
        baseProjectLevelMap.put("CAREERGROUPTEXT","事业群");
        baseProjectLevelMap.put("LARGEAREATEXT","大区");
        baseProjectLevelMap.put("SMALLAREATEXT","小区");
        baseProjectLevelMap.put("MONEYBACKDEPTTEXT","回款业绩部门");
        baseProjectLevelMap.put("SALEDEPTTEXT","销售业绩部门");
        baseProjectLevelMap.put("CUSTOMERCODE","客户编码");
        baseProjectLevelMap.put("CUSTOMERNAME","客户名称");
        baseProjectLevelMap.put("CONTRACTNO","合同编号");
        baseProjectLevelMap.put("CONTRACTNAME","合同名称");
        baseProjectLevelMap.put("CONTRACTAMOUNT","合同金额");
        baseProjectLevelMap.put("CONTRACTSOFTWAREAMOUNT","合同软件金额");
        baseProjectLevelMap.put("SOFTWARESERVICEAMOUNT","软件与服务金额");
        baseProjectLevelMap.put("DISCOUNT","折扣");
        baseProjectLevelMap.put("CONTRACTSIGNINGDATE","合同签订日期");
        baseProjectLevelMap.put("CONTRACTASSESSMENTDATE","合同考核日期");
        baseProjectLevelMap.put("PROJECTID","项目ID");
        baseProjectLevelMap.put("PROJECTNAME","项目名称");
        baseProjectLevelMap.put("PROJECTAMOUNT","项目金额");
        baseProjectLevelMap.put("PROJECTFLAGTEXT","项目类别");
        baseProjectLevelMap.put("PROJECTTYPETEXT","项目类型");
        baseProjectLevelMap.put("ACCEPTANCESTAMP","验收标记");
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

        head.putAll(baseProjectLevelMap);
        if (otherColumns != null) {
            head.putAll(otherColumns);
        }
        head.putAll(costColumns);
        return head;

    }
}
