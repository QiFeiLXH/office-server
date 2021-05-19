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
import com.bsoft.office.hr.condition.TrainKnowledgeQueryCnd;
import com.bsoft.office.hr.manager.TrainManager;
import com.bsoft.office.hr.vo.TrainKnowledgeLearnViewVO;
import com.bsoft.office.hr.vo.TrainKnowledgeShareViewVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/7/21 14:22
 * @Description
 */
@RestController
@RequestMapping("/train")
public class TrainKnowledgeController {
    private static final Logger logger = LoggerFactory.getLogger(TrainKnowledgeController.class);

    @Autowired
    private TrainManager trainManager;

    @GetMapping("/learn/query")
    @OperLog(operType = OperLogType.QUERY,operDesc = "云学堂知识学习记录")
    public OfficeResopnseBean getKnowledgeLearnList(TrainKnowledgeQueryCnd trainKnowledgeQueryCnd){
        Result<TrainKnowledgeLearnViewVO> result = trainManager.getKnowledgeLearnList(trainKnowledgeQueryCnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        logger.info("获取云学堂知识学习记录查询列表！[{}]", JSONUtils.toString(result));
        return responseBean;
    }
    @GetMapping("/share/query")
    @OperLog(operType = OperLogType.QUERY,operDesc = "云学堂知识分享记录")
    public OfficeResopnseBean getKnowledgeShareList(TrainKnowledgeQueryCnd trainKnowledgeQueryCnd){
        Result<TrainKnowledgeShareViewVO> result = trainManager.getKnowledgeShareList(trainKnowledgeQueryCnd);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        logger.info("获取云学堂知识分享查询列表！[{}]", JSONUtils.toString(result));
        return responseBean;
    }

    @DeleteMapping("/learn/delete")
    @OperLog(operType = OperLogType.DELETE,operDesc = "删除云学堂知识学习记录")
    public OfficeResopnseBean deleteBatchLearnList(@RequestParam(value = "deletes")List<Integer> deletes){
        trainManager.deleteBatchLearnList(deletes);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody("删除云学堂知识分享记录成功！");
        logger.info("删除云学堂知识学习记录！");
        return responseBean;
    }

    @DeleteMapping("/share/delete")
    @OperLog(operType = OperLogType.DELETE,operDesc = "删除云学堂知识分享记录")
    public OfficeResopnseBean deleteBatchShareList(@RequestParam(value = "deletes")List<Integer> deletes){
        trainManager.deleteBatchShareList(deletes);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody("删除云学堂知识分享记录成功！");
        logger.info("删除云学堂知识分享记录！");
        return responseBean;
    }

    /**
     *功能描述: 学习记录模板列表导出
     */
    @GetMapping("/learn/templatedownload")
    @RequiredExportLog
    @OperLog(operType = OperLogType.EXPORT,operDesc = "导出云学堂知识学习记录模板")
    public void exportLearnTemplate(ExportLogParams params,
                                          HttpServletResponse response){
        List<TrainKnowledgeLearnViewVO> list = getLearnTemplateData();
        ExportExcel.exportWithCustomStyle(list, TrainKnowledgeLearnViewVO.class,"云学堂知识学习记录模板",new CustomCellWriteHandler(),response);
        logger.info("培训管理-导出云学堂知识学习记录模板成功！");
    }

    /**
     *功能描述: 学习记录错误列表导出
     */
    @GetMapping("/learn/errordownload")
    @OperLog(operType = OperLogType.EXPORT,operDesc = "导出云学堂知识学习错误数据")
    public void exportLearnErrorRecords( HttpServletRequest request,
                                          HttpServletResponse response){
        String personId = ContextUtils.getUserId(request);
        List<TrainKnowledgeLearnViewVO> list = trainManager.getErrorLearnList(personId);
        ExportExcel.export(list,TrainKnowledgeLearnViewVO.class,"云学堂知识学习导入失败数据",response);
        logger.info("培训管理-导出云学堂知识学习错误数据成功！");
    }

    /**
     *功能描述: 学习分享模板列表导出
     */
    @GetMapping("/share/templatedownload")
    @RequiredExportLog
    @OperLog(operType = OperLogType.EXPORT,operDesc = "导出云学堂知识分享模板")
    public void exportShareTemplate(ExportLogParams params,HttpServletResponse response){
        List<TrainKnowledgeShareViewVO> list = getShareTemplateData();
        ExportExcel.exportWithCustomStyle(list, TrainKnowledgeShareViewVO.class,"云学堂知识分享模板",new CustomCellWriteHandler(), response);
        logger.info("培训管理-导出云学堂知识分享模板成功！");
    }

    /**
     *功能描述: 学习分享错误列表导出
     */
    @GetMapping("/share/errordownload")
    @OperLog(operType = OperLogType.EXPORT,operDesc = "导出云学堂知识分享错误数据")
    public void exportShareErrorRecords( HttpServletRequest request, HttpServletResponse response){
        String personId = ContextUtils.getUserId(request);
        List<TrainKnowledgeShareViewVO> list = trainManager.getErrorShareList(personId);
        ExportExcel.export(list,TrainKnowledgeShareViewVO.class,"云学堂知识分享导入失败数据",response);
        logger.info("培训管理-导出云学堂知识分享错误数据成功！");
    }

    /** 知识学习-导入数据 */
    @PostMapping("/learn/import")
    @OperLog(operType = OperLogType.IMPORT,operDesc = "知识学习-导入数据")
    public OfficeResopnseBean importKnowledgeLearnData(@RequestParam MultipartFile file, HttpServletRequest request) {
        String personId = ContextUtils.getUserId(request);
        try {
            List<TrainKnowledgeLearnViewVO> list = ExcelUtils.readExcel(file, TrainKnowledgeLearnViewVO.class, new ExcelListener<TrainKnowledgeLearnViewVO>());

            ImportResultVO result = trainManager.importKnowledgeLearnData(list, personId);
            OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
            responseBean.setBody(result);
            logger.info("知识学习-导入数据成功!", JSONUtils.toString(result));
            return responseBean;
        } catch (IOException e) {
            return OfficeResopnseBean.newFailBean(500, "知识学习-导入失败");
        }
    }

    /** 知识分享-导入数据 */
    @PostMapping("/share/import")
    @OperLog(operType = OperLogType.IMPORT,operDesc = "学习分享-导入数据")
    public OfficeResopnseBean importKnowledgeShareData(@RequestParam MultipartFile file, HttpServletRequest request) {
        String personId = ContextUtils.getUserId(request);
        try {
            List<TrainKnowledgeShareViewVO> list = ExcelUtils.readExcel(file, TrainKnowledgeShareViewVO.class, new ExcelListener<TrainKnowledgeShareViewVO>());
            ImportResultVO result = trainManager.importKnowledgeShareData(list,personId);
            OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
            responseBean.setBody(result);
            logger.info("学习分享-导入数据成功！", JSONUtils.toString(result));
            return responseBean;
        } catch (IOException e) {
            return OfficeResopnseBean.newFailBean(500, "学习分享-导入失败");
        }
    }

    /** 知识学习模板数据 */
    private List<TrainKnowledgeLearnViewVO> getLearnTemplateData() {
        TrainKnowledgeLearnViewVO template = new TrainKnowledgeLearnViewVO();
        TrainKnowledgeLearnViewVO template1 = new TrainKnowledgeLearnViewVO();
        TrainKnowledgeLearnViewVO template2 = new TrainKnowledgeLearnViewVO();

        template.setPersonId("9304");
        template.setPersonName("雷鑫");
        template.setKnowledgeName("安全生产管理措施");
        template.setLearningRateStr("100%");
        template.setLearningModel("指派学习");
        template.setLearningTimeStr("36.0");
        template.setEarnedCreditsStr("3.6");
        template1.setPersonId("9294");
        template1.setPersonName("刘开选");
        template1.setKnowledgeName("01 基本模块开发1");
        template1.setLearningRateStr("100%");
        template1.setLearningModel("自主学习");
        template1.setLearningTimeStr("20.0");
        template1.setEarnedCreditsStr("2.0");

        template.setStartDateStr("2020/06/18 14:45");
        template.setEndDateStr("2020/06/18 18:07");
        template1.setStartDateStr("2020/04/15 22:16");
        template1.setEndDateStr("2020/04/15 22:34");



        List list = Arrays.asList(template,template1,template2, template2, template2,template2);
        return list;

    }

    /** 知识分享模板数据 */
    private List<TrainKnowledgeShareViewVO> getShareTemplateData() {
        TrainKnowledgeShareViewVO template = new TrainKnowledgeShareViewVO();
        TrainKnowledgeShareViewVO template1 = new TrainKnowledgeShareViewVO();
        TrainKnowledgeShareViewVO template2 = new TrainKnowledgeShareViewVO();

        template.setPersonId("0983");
        template.setPersonName("汪慧丹");
        template.setKnowledgeName("20200526-施晓峰-社区基卫业务--门诊、住院等业务流程及要点的在线培训");
        template1.setPersonId("8305");
        template1.setPersonName("袁兆龙");
        template1.setKnowledgeName("20200608-顺德区全民健康信息平台数据集标准（医疗部分V3.0）-华南大区");
        template.setShareDateStr("2020/05/27 09:37:13");
        template1.setShareDateStr("2020/06/05 18:19:50");

        List list = Arrays.asList(template,template1,template2, template2, template2,template2);
        return list;

    }
}
