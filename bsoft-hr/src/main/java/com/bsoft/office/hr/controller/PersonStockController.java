package com.bsoft.office.hr.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.annotation.RequiredExportLog;
import com.bsoft.office.common.condition.ExportLogParams;
import com.bsoft.office.common.exportExcel.*;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.hr.condition.PersonStockQueryCnd;
import com.bsoft.office.hr.manager.PersonStockManager;
import com.bsoft.office.hr.vo.PersonStockErrorTemplateVO;
import com.bsoft.office.hr.vo.PersonStockTemplateVO;
import com.bsoft.office.hr.vo.PersonStockViewVO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/14 10:12
 * @Description
 */
@RestController
@RequestMapping("/personstock")
public class PersonStockController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonStockController.class);

    @Autowired
    private PersonStockManager personStockManager;

    @GetMapping("/query")
    @OperLog(operType = OperLogType.QUERY,operDesc = "员工股份记录")
    public OfficeResopnseBean getPersonStockList(PersonStockQueryCnd cnd){
        Result<PersonStockViewVO> result = personStockManager.getPersonStockList(cnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        LOGGER.info("获取员工股份记录列表！[{}]", JSONUtils.toString(result));
        return responseBean;
    }

    @DeleteMapping("/logoutone")
    @OperLog(operType = OperLogType.OTHER,operDesc = "注销员工股份记录")
    public OfficeResopnseBean logoutOnePersonStock(Integer id){
        personStockManager.logoutOnePersonStock(id);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody("注销成功！");
        LOGGER.info("注销员工股份记录列表！id：[{}]", id);
        return responseBean;
    }

    @DeleteMapping("/batchlogout")
    @OperLog(operType = OperLogType.OTHER,operDesc = "批量注销员工股份记录")
    public OfficeResopnseBean batchLogoutPersonStocks(@RequestParam(name="ids", required = false) List<Integer> ids){
        if (ids == null) {
            ids = new ArrayList<>();
        }
        personStockManager.batchLogoutPersonStocks(ids);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody("批量注销成功！");
        LOGGER.info("批量注销员工股份记录列表！ids：[{}]", JSONUtils.toString(ids));
        return responseBean;
    }

    @PostMapping("/save")
    @OperLog(operType = OperLogType.MODIFY,operDesc = "保存员工股份")
    public OfficeResopnseBean savePersonStock(@RequestBody PersonStockViewVO personStock, HttpServletRequest request){
        if (StringUtils.isBlank(personStock.getRegister())) {
            String personId = ContextUtils.getUserId(request);
            personStock.setRegister(personId);
        }
        personStockManager.savePersonStock(personStock);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody("保存成功！");
        LOGGER.info("保存员工股份！[{}]", JSONUtils.toString(personStock));
        return responseBean;
    }

    @GetMapping("/exportdownload")
    @RequiredExportLog
    @OperLog(operType = OperLogType.EXPORT,operDesc = "导出员工股份")
    public void exportAllPersonStocks(ExportLogParams params,
                                      PersonStockQueryCnd cnd,
                                    HttpServletResponse response){
        List<PersonStockViewVO> list = personStockManager.getAllPersonStockList(cnd);
        ExportExcel.doExport(list,PersonStockViewVO.class,"员工股份信息",response);
        LOGGER.info("导出员工股份信息成功！");
    }

    @GetMapping("/templatedownload")
    @RequiredExportLog
    @OperLog(operType = OperLogType.EXPORT,operDesc = "导出员工股份信息模板")
    public void exportPersonStockTemplate(ExportLogParams params,
                                    HttpServletResponse response){
        List<PersonStockTemplateVO> list = getTemplateData();
        ExportExcel.exportWithCustomStyle(list, PersonStockTemplateVO.class,"员工股份信息模板",new CustomCellWriteHandler(),response);
        LOGGER.info("导出员工股份信息模板成功！");
    }

    @GetMapping("/errordatadownload")
    @OperLog(operType = OperLogType.EXPORT,operDesc = "导出员工股份信息错误数据")
    public void exportLearnErrorRecords( HttpServletRequest request,
                                         HttpServletResponse response){
        String personId = ContextUtils.getUserId(request);
        List<PersonStockErrorTemplateVO> list = personStockManager.getErrorPersonStockList(personId);
        ExportExcel.doExport(list,PersonStockErrorTemplateVO.class,"员工股份信息导入失败数据",response);
        LOGGER.info("导出员工股份信息错误数据成功！");
    }

    @PostMapping("/import")
    @OperLog(operType = OperLogType.OTHER,operDesc = "员工股份信息-导入数据")
    public OfficeResopnseBean importPersonStockData(@RequestParam MultipartFile file, HttpServletRequest request) {
        String personId = ContextUtils.getUserId(request);
        try {
            List<PersonStockTemplateVO> list = ExcelUtils.readExcel(file, PersonStockTemplateVO.class, new ExcelListener<PersonStockTemplateVO>());

            ImportResultVO result = personStockManager.importPersonStockData(list, personId);
            OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
            responseBean.setBody(result);
            LOGGER.info("员工股份信息-导入数据成功!", JSONUtils.toString(result));
            return responseBean;
        } catch (IOException e) {
            return OfficeResopnseBean.newFailBean(500, "员工股份信息-导入失败");
        }
    }

    /** 模板数据 */
    private List<PersonStockTemplateVO> getTemplateData() {
        PersonStockTemplateVO template = new PersonStockTemplateVO();
        PersonStockTemplateVO template1 = new PersonStockTemplateVO();
        template.setPersonId("xxx");
        template.setPersonName("xxx");
        template.setDeptName("xxx");

        List list = Arrays.asList(template,template1,template1, template1, template1,template1);
        return list;

    }
}
