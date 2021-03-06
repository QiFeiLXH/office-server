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
        otherColumns.put("COSTYEAR","????????????");
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
        otherColumns.put("COSTQUARTER","????????????");
        otherColumns.put("COSTMONTH","??????????????????");
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
        otherColumns.put("DEPTYPETEXT","????????????????????????");
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
        otherColumns.put("COSTYEAR","????????????");
        otherColumns.put("DEPTYPETEXT","????????????????????????");
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
        otherColumns.put("COSTQUARTER","????????????");
        otherColumns.put("COSTMONTH","??????????????????");
        otherColumns.put("DEPTYPETEXT","????????????????????????");
        LinkedHashMap<String, String> sheetHead = this.getSheetHead(otherColumns);

        Map<String, Object> colsAndData = new HashMap<>();
        colsAndData.put("head", sheetHead);
        colsAndData.put("data",records);
        return colsAndData;
    }

    /**
     * ?????????????????????????????????????????????Excel????????????
     */
    private void initFields() {
        baseProjectLevelMap = new LinkedHashMap<>();
        baseProjectLevelMap.put("CAREERGROUPTEXT","?????????");
        baseProjectLevelMap.put("LARGEAREATEXT","??????");
        baseProjectLevelMap.put("SMALLAREATEXT","??????");
        baseProjectLevelMap.put("MONEYBACKDEPTTEXT","??????????????????");
        baseProjectLevelMap.put("SALEDEPTTEXT","??????????????????");
        baseProjectLevelMap.put("CUSTOMERCODE","????????????");
        baseProjectLevelMap.put("CUSTOMERNAME","????????????");
        baseProjectLevelMap.put("CONTRACTNO","????????????");
        baseProjectLevelMap.put("CONTRACTNAME","????????????");
        baseProjectLevelMap.put("CONTRACTAMOUNT","????????????");
        baseProjectLevelMap.put("CONTRACTSOFTWAREAMOUNT","??????????????????");
        baseProjectLevelMap.put("SOFTWARESERVICEAMOUNT","?????????????????????");
        baseProjectLevelMap.put("DISCOUNT","??????");
        baseProjectLevelMap.put("CONTRACTSIGNINGDATE","??????????????????");
        baseProjectLevelMap.put("CONTRACTASSESSMENTDATE","??????????????????");
        baseProjectLevelMap.put("PROJECTID","??????ID");
        baseProjectLevelMap.put("PROJECTNAME","????????????");
        baseProjectLevelMap.put("PROJECTAMOUNT","????????????");
        baseProjectLevelMap.put("PROJECTFLAGTEXT","????????????");
        baseProjectLevelMap.put("PROJECTTYPETEXT","????????????");
        baseProjectLevelMap.put("ACCEPTANCESTAMP","????????????");
    }

    /**
     * @param otherColumns ????????????????????????????????????
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
