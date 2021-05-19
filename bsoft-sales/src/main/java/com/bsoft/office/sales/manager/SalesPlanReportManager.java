package com.bsoft.office.sales.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.exportExcel.ImportResultVO;
import com.bsoft.office.common.vo.PublicDicVO;
import com.bsoft.office.common.vo.SystemDicVO;
import com.bsoft.office.sales.condition.SalesPlanQueryCndVO;
import com.bsoft.office.sales.vo.*;

import java.util.List;

/**
 * @author: zy
 * @date: 2020/11/20
 * @description
 */
public interface SalesPlanReportManager {
    Result<SalesPlanReportVO> listSalesPlanReports(String userId, SalesPlanQueryCndVO queryCndVO);
    List<SalesPlanPersonVO> listPersons(String userId, SalesPlanQueryCndVO queryCndVO);
    List<SalesPlanDeptVO> listDepts(String userId, SalesPlanQueryCndVO queryCndVO);
    List<PublicDicVO> listBusinessBelongs();
    List<SystemDicVO> listCluesNatures();
    List<SystemDicVO> listStages();
    List<SystemDicVO> listStatus();
    List<SystemDicVO> getPlanSourceList();
    List<SystemDicVO> getCluesSourceList();

    SalesPlanAmountVO countMoney(String userId, SalesPlanQueryCndVO queryCndVO);

    /** 保存销售计划信息*/
    void saveSalesPlanReport(String userId, SalesPlanReportVO salesPlanVO);

    /** 导入销售计划信息*/
    ImportResultVO importData(String userId, List<SalesPlanReportExcelVO> importList);

    /** 导出销售计划信息*/
    List<SalesPlanReportExcelVO> exportData(String userId, SalesPlanQueryCndVO queryCndVO);

    /** 导出错误信息*/
    List<SalesPlanReportExcelErrorVO> exportErrorData(String userId);

    /** 根据线索编号获取销售线索详细信息 */
    SalesPlanDetailViewVO getSalesPlanDetail(String personId,Integer clueId);

    /** 根据条件获取销售线索列表*/
    Result<SalesCluesViewVO> listClueForSearch(String personId, SalesPlanQueryCndVO queryCndVO);
}
