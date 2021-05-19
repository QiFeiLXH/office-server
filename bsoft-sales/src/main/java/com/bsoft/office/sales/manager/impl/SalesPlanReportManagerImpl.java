package com.bsoft.office.sales.manager.impl;

import com.bsoft.clue.dto.*;
import com.bsoft.clue.service.SalesCluesService;
import com.bsoft.clue.service.SalesPlanService;
import com.bsoft.common.dto.ImportResultDTO;
import com.bsoft.common.dto.PublicDicDTO;
import com.bsoft.common.dto.SystemDicDTO;
import com.bsoft.common.result.Result;
import com.bsoft.common.service.PublicDicService;
import com.bsoft.common.service.ServerDateService;
import com.bsoft.common.service.SystemDicService;
import com.bsoft.customer.dto.CustomerDTO;
import com.bsoft.customer.service.CustomerService;
import com.bsoft.dept.dto.DeptDTO;
import com.bsoft.dept.service.DeptService;
import com.bsoft.office.common.dozer.GeneratorUtil;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.common.exportExcel.ImportResultVO;
import com.bsoft.office.common.vo.PublicDicVO;
import com.bsoft.office.common.vo.SystemDicVO;
import com.bsoft.office.sales.condition.SalesPlanQueryCndVO;
import com.bsoft.office.sales.manager.SalesPlanReportManager;
import com.bsoft.office.sales.vo.*;
import com.bsoft.person.dto.PersonDTO;
import com.bsoft.person.service.PersonService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: zy
 * @date: 2020/11/20
 * @description
 */
@Component
public class SalesPlanReportManagerImpl implements SalesPlanReportManager {
    @Reference
    private SalesPlanService salesPlanService;
    @Reference
    private SalesCluesService salesCluesService;
    @Reference
    private SystemDicService systemDicService;
    @Reference
    private PublicDicService publicDicService;
    @Reference
    private ServerDateService serverDateService;
    @Reference
    private PersonService personService;
    @Reference
    private DeptService deptService;
    @Reference
    private CustomerService customerService;
    @Autowired
    private IGenerator iGenerator;


    @Override
    public Result<SalesPlanReportVO> listSalesPlanReports(String userId, SalesPlanQueryCndVO queryCndVO) {
        SalesPlanQueryCndDTO queryCndDTO = iGenerator.convert(queryCndVO, SalesPlanQueryCndDTO.class);
        Result<SalesPlanViewDTO> resultDTO = salesPlanService.listSalesPlanReportView(userId, queryCndDTO);
        return iGenerator.convert(resultDTO, SalesPlanReportVO.class);
    }

    @Override
    public List<SalesPlanPersonVO> listPersons(String userId, SalesPlanQueryCndVO queryCndVO) {
        SalesPlanQueryCndDTO queryCndDTO = iGenerator.convert(queryCndVO, SalesPlanQueryCndDTO.class);
        List<SalesPlanDTO> personDTOList = salesPlanService.listTrackPersons(userId, queryCndDTO);
        List<SalesPlanPersonVO> personVOList = new ArrayList<>();
        personDTOList.forEach(item->{
            SalesPlanPersonVO salesPlanPersonVO = new SalesPlanPersonVO();
            salesPlanPersonVO.setPersonId(item.getTrackPerson());
            salesPlanPersonVO.setPersonName(item.getTrackPersonName());
            personVOList.add(salesPlanPersonVO);
        });
        return personVOList;
    }

    @Override
    public List<SalesPlanDeptVO> listDepts(String userId, SalesPlanQueryCndVO queryCndVO) {
        SalesPlanQueryCndDTO queryCndDTO = iGenerator.convert(queryCndVO, SalesPlanQueryCndDTO.class);
        List<SalesPlanDTO> deptDTOList = salesPlanService.listTrackDepts(userId, queryCndDTO);
        List<SalesPlanDeptVO> deptVOList = new ArrayList<>();
        deptDTOList.forEach(item->{
            SalesPlanDeptVO salesPlanDeptVO = new SalesPlanDeptVO();
            salesPlanDeptVO.setDeptId(item.getTrackDept());
            salesPlanDeptVO.setDeptName(item.getTrackDeptName());
            deptVOList.add(salesPlanDeptVO);
        });
        return deptVOList;
    }

    @Override
    public List<PublicDicVO> listBusinessBelongs() {
        List<PublicDicDTO> businessBelongList = publicDicService.getPublicDic(1501);
        return iGenerator.convert(businessBelongList, PublicDicVO.class);
    }

    @Override
    public List<SystemDicVO> listCluesNatures() {
        List<SystemDicDTO> cluesNatureList = systemDicService.getSystemDic(946);
        return iGenerator.convert(cluesNatureList, SystemDicVO.class);
    }

    @Override
    public List<SystemDicVO> listStages() {
        List<SystemDicDTO> stageList = systemDicService.getSystemDic(924);
        return iGenerator.convert(stageList, SystemDicVO.class);
    }

    @Override
    public List<SystemDicVO> listStatus() {
        List<SystemDicDTO> statusList = systemDicService.getSystemDic(944);
        return iGenerator.convert(statusList, SystemDicVO.class);
    }

    @Override
    public List<SystemDicVO> getPlanSourceList() {
        List<SystemDicDTO> statusList = systemDicService.getSystemDic(9018);
        return iGenerator.convert(statusList, SystemDicVO.class);
    }

    @Override
    public List<SystemDicVO> getCluesSourceList() {
        List<SystemDicDTO> statusList = systemDicService.getSystemDic(9019);
        return iGenerator.convert(statusList, SystemDicVO.class);
    }

    @Override
    public SalesPlanAmountVO countMoney(String userId, SalesPlanQueryCndVO queryCndVO) {
        SalesPlanQueryCndDTO queryCndDTO = iGenerator.convert(queryCndVO, SalesPlanQueryCndDTO.class);
        SalesPlanAmountDTO salesPlanAmountDTO = salesPlanService.getSalesPlanAmount(userId, queryCndDTO);
        return iGenerator.convert(salesPlanAmountDTO, SalesPlanAmountVO.class);
    }

    @Override
    public void saveSalesPlanReport(String userId, SalesPlanReportVO saveVO) {
        SalesPlanDTO saveDTO = iGenerator.convert(saveVO, SalesPlanDTO.class);
        salesPlanService.saveSalesPlanReport(userId, saveDTO);
    }

    @Override
    public ImportResultVO importData(String userId, List<SalesPlanReportExcelVO> importVOList) {
        List<SalesPlanDTO> importDTOList = iGenerator.convert(importVOList, SalesPlanDTO.class);
        Map<String, List<SalesPlanDTO>> checkResult = this.checkImportData(importDTOList);
        List<SalesPlanDTO> saveList = checkResult.get("saveList");
        List<SalesPlanDTO> errorList = checkResult.get("errorList");
        salesPlanService.importSalesPlanData(userId, saveList, errorList);
        return new ImportResultVO(saveList.size(), errorList.size());
    }

    @Override
    public List<SalesPlanReportExcelVO> exportData(String userId, SalesPlanQueryCndVO queryCndVO) {
        SalesPlanQueryCndDTO queryCndDTO = iGenerator.convert(queryCndVO, SalesPlanQueryCndDTO.class);
        List<SalesPlanViewDTO> list = salesPlanService.getSalesPlanReportViewList(userId, queryCndDTO);
        List<SalesPlanReportExcelVO> exportList = iGenerator.convert(list, SalesPlanReportExcelVO.class);
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM");
        exportList.forEach(item -> {
            if(item.getEstimateSoftware() != null) {
                item.setEstimateSoftwareStr(item.getEstimateSoftware().toString());
            }
            if(item.getEstimateHardware() != null) {
                item.setEstimateHardwareStr(item.getEstimateHardware().toString());
            }
            if(item.getEstimateNetSales() != null) {
                item.setEstimateNetSalesStr(item.getEstimateNetSales().toString());
            }
            if(item.getSignDate() != null) {
                item.setSignDateStr(sdf1.format(item.getSignDate()));
            }
            if(item.getPlanDate() != null) {
                item.setPlanDateStr(sdf2.format(item.getPlanDate()));
            }
        });
        return exportList;
    }


    @Override
    public List<SalesPlanReportExcelErrorVO> exportErrorData(String userId) {
        List<SalesPlanDTO> errorList = salesPlanService.exportErrorData(userId);
        return iGenerator.convert(errorList, SalesPlanReportExcelErrorVO.class);
    }

    @Override
    public SalesPlanDetailViewVO getSalesPlanDetail(String personId, Integer clueId) {
        SalesPlanDetailViewDTO salesPlanDetail = salesPlanService.getSalesPlanDetail(personId, clueId);
        return iGenerator.convert(salesPlanDetail,SalesPlanDetailViewVO.class);
    }

    @Override
    public Result<SalesCluesViewVO> listClueForSearch(String personId, SalesPlanQueryCndVO queryCndVO) {
        SalesPlanQueryCndDTO queryCndDTO = iGenerator.convert(queryCndVO, SalesPlanQueryCndDTO.class);
        Result<SalesCluesViewDTO> result = salesPlanService.getCluesForSearch(personId, queryCndDTO);
        return iGenerator.convert(result, SalesCluesViewVO.class);
    }

    /**
     * 校验导入数据
     */
    private Map<String, List<SalesPlanDTO>> checkImportData(List<SalesPlanDTO> importList) {
        List<SalesPlanDTO> notNullList = new ArrayList<>();
        List<SalesPlanDTO> formatList = new ArrayList<>();
        List<SalesPlanDTO> saveList = new ArrayList<>();
        List<SalesPlanDTO> errorList = new ArrayList<>();
        List<String> personIdList = new ArrayList<>();
        List<String> customerNameList = new ArrayList<>();
        List<String> deptNameList = new ArrayList<>();
        HashMap<String, List<SalesPlanDTO>> result = new HashMap<>();
        Date now = serverDateService.getServerDateTime();

        // 非空判断
        importList.forEach(item -> {
            Boolean hasNull = StringUtils.isBlank(item.getBusinessBelong())
                    || StringUtils.isBlank(item.getTrackPerson())
                    || StringUtils.isBlank(item.getTrackDeptName())
                    || StringUtils.isBlank(item.getEstimateSoftwareStr())
                    || StringUtils.isBlank(item.getEstimateNetSalesStr())
                    || StringUtils.isBlank(item.getEstimateHardwareStr())
                    || StringUtils.isBlank(item.getSignDateStr())
                    || StringUtils.isBlank(item.getPlanDateStr());
            if (hasNull) {
                item.setFailReason("必填数据不能为空");
                errorList.add(item);
            } else {
                notNullList.add(item);
            }
        });

        // 格式转换
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        sdf1.setLenient(false);// 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
        sdf2.setLenient(false);
        for (SalesPlanDTO item : notNullList) {
            try{
                item.setPlanDate(sdf1.parse(item.getPlanDateStr()));
                item.setSignDate(sdf2.parse(item.getSignDateStr()));
                if (StringUtils.isNotBlank(item.getOpeningDate())) {
                    Date openingDate = sdf2.parse(item.getOpeningDate());
                }
                item.setEstimateSoftware(new BigDecimal(item.getEstimateSoftwareStr()).doubleValue() * 10000);
                item.setEstimateHardware(new BigDecimal(item.getEstimateHardwareStr()).doubleValue() * 10000);
                item.setEstimateNetSales(new BigDecimal(item.getEstimateNetSalesStr()).doubleValue() * 10000);
                formatList.add(item);
            } catch(Exception e) {
                if (e instanceof ParseException) {
                    item.setFailReason("日期格式不正确");
                }
                if (e instanceof NumberFormatException) {
                    item.setFailReason("数字格式不正确");
                }
                errorList.add(item);
            }
        }

        // 查询相关数据
        formatList.forEach(item -> {
            personIdList.add(item.getTrackPerson());
            customerNameList.add(item.getCustomerName());
            deptNameList.add(item.getTrackDeptName());
        });
        List<PersonDTO> personList = personService.getPersonList(personIdList);
        List<DeptDTO> deptList = deptService.getDeptList(deptNameList);
        List<CustomerDTO> customerList = customerService.getCustomerList(customerNameList);
        List<PublicDicDTO> businessBelongDic = publicDicService.getPublicDic(1501);
        List<SystemDicDTO> stageList = systemDicService.getSystemDic(924);
        List<SystemDicDTO> cluesNatureList = systemDicService.getSystemDic(946);
        List<SystemDicDTO> planSourceList = systemDicService.getSystemDic(9018);
        Map<String, String> personMap = personList.stream().collect(Collectors.toMap(PersonDTO::getPersonId, PersonDTO::getPersonName));
        Map<String, String> deptMap = deptList.stream().collect(Collectors.toMap(DeptDTO::getDeptName, DeptDTO::getDeptId));
        Map<String, String> customerMap = customerList.stream().collect(Collectors.toMap(CustomerDTO::getName, CustomerDTO::getId));
        Map<String, Integer> businessBelongMap = businessBelongDic.stream().collect(Collectors.toMap(PublicDicDTO::getName, PublicDicDTO::getId));
        Map<String, Integer> cluesNatureMap = cluesNatureList.stream().collect(Collectors.toMap(SystemDicDTO::getName, SystemDicDTO::getId));
        Map<String, Integer> stageMap = stageList.stream().collect(Collectors.toMap(SystemDicDTO::getName, SystemDicDTO::getId));
        Map<String, Integer> planSourceMap = planSourceList.stream().collect(Collectors.toMap(SystemDicDTO::getName, SystemDicDTO::getId));

        // 检验
        formatList.forEach(item -> {
            Boolean checked = true;
            if (StringUtils.isNotBlank(item.getPlanSource()) && !planSourceMap.containsKey(item.getPlanSource())) {
                checked = false;
                item.setFailReason("计划来源不准确");
            }
            if (StringUtils.isNotBlank(item.getCluesNature()) && !cluesNatureMap.containsKey(item.getCluesNature())) {
                checked = false;
                item.setFailReason("线索信息不准确");
            }
            if (StringUtils.isNotBlank(item.getStage()) && !stageMap.containsKey(item.getStage())) {
                checked = false;
                item.setFailReason("项目阶段不准确");
            }
            if (item.getEstimateHardware() < 0 || item.getEstimateNetSales() < 0 || item.getEstimateSoftware() < 0) {
                checked = false;
                item.setFailReason("金额不能小于零");
            }
            if (!customerMap.containsKey(item.getCustomerName())) {
                checked = false;
                item.setFailReason("客户名称不准确");
            }
            if (!deptMap.containsKey(item.getTrackDeptName())) {
                checked = false;
                item.setFailReason("跟单部门名称不准确");
            }
            if (!personMap.containsKey(item.getTrackPerson())) {
                checked = false;
                item.setFailReason("跟单人工号不存在");
            } else if (StringUtils.isNotBlank(item.getTrackPersonName()) && !personMap.get(item.getTrackPerson()).equals(item.getTrackPersonName())) {
                item.setFailReason("跟单人姓名与工号不匹配");
            }
            if (!businessBelongMap.containsKey(item.getBusinessBelong())) {
                checked = false;
                item.setFailReason("业务归属名称不准确");
            }

            if (checked) {
                item.setTrackDept(deptMap.get(item.getTrackDeptName()));
                item.setCustomer(customerMap.get(item.getCustomerName()));
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(item.getSignDate());
                item.setEstimateMonth(String.format(calendar.get(Calendar.YEAR) + "." + (calendar.get(Calendar.MONTH) + 1)));
                item.setReportDate(now);
                item.setStatus(2);
                saveList.add(item);
            } else {
                errorList.add(item);
            }
        });

        // 将结果用map封装传回
        result.put("saveList", saveList);
        result.put("errorList", errorList);
        return result;
    }
}
