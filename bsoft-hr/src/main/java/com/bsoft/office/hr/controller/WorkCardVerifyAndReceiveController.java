package com.bsoft.office.hr.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.manager.FilePublicManager;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.hr.condition.WorkCardQueryCnd;
import com.bsoft.office.hr.manager.WorkCardManager;
import com.bsoft.office.hr.vo.WorkCardDateCountVO;
import com.bsoft.office.hr.vo.WorkCardViewVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/12/16 9:46
 * @Description 工牌核实、领取
 */
@RestController
@RequestMapping("/workcardverifyreceive")
public class WorkCardVerifyAndReceiveController {
    private static final Logger LOGGER = LoggerFactory.getLogger(WorkCardVerifyAndReceiveController.class);

    @Autowired
    private WorkCardManager workCardManager;
    @Autowired
    private FilePublicManager filePublicManager;

    @GetMapping("/datequery")
    @OperLog(operType = OperLogType.QUERY,operDesc = "工牌日期数据")
    public OfficeResopnseBean getDateList(){
        List<WorkCardDateCountVO> result = workCardManager.getDateList();
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(result);
        LOGGER.info("获取工牌日期数据", JSONUtils.toString(result));
        return bean;
    }

    @GetMapping("/personquery")
    @OperLog(operType = OperLogType.QUERY,operDesc = "工牌人员数据")
    public OfficeResopnseBean getWorkCardList(WorkCardQueryCnd cnd){
        if (cnd.getRecharge() == null) {
            cnd.setRecharge(new ArrayList<Integer>());
        }
        Result<WorkCardViewVO> result = workCardManager.getWorkCardList(cnd);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(result);
        LOGGER.info("获取工牌人员数据", JSONUtils.toString(result));
        return bean;
    }

    @GetMapping("/amount")
    @OperLog(operType = OperLogType.QUERY,operDesc = "工牌人员充值金额")
    public OfficeResopnseBean getPersonWorkCardAmount(Integer personType, @DateTimeFormat(pattern = "yyyy-MM-dd")Date startDate){
        Double amount = workCardManager.getPersonWorkCardAmount(personType, startDate);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(amount);
        LOGGER.info("获取工牌人员充值金额数据", JSONUtils.toString(amount));
        return bean;
    }

    @GetMapping("/verifycount")
    @OperLog(operType = OperLogType.QUERY,operDesc = "工牌待核实数量")
    public OfficeResopnseBean getWorkCardVerifyCount(WorkCardQueryCnd cnd){
        if (cnd.getRecharge() == null) {
            cnd.setRecharge(new ArrayList<Integer>());
        }
        Integer count = workCardManager.getWorkCardVerifyCount(cnd);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(count);
        LOGGER.info("获取工牌待核实数量", JSONUtils.toString(count));
        return bean;
    }

    @GetMapping("/receivecount")
    @OperLog(operType = OperLogType.QUERY,operDesc = "工牌待领取数量")
    public OfficeResopnseBean getWorkCardReceiveCount(WorkCardQueryCnd cnd){
        if (cnd.getRecharge() == null) {
            cnd.setRecharge(new ArrayList<Integer>());
        }
        Integer count = workCardManager.getWorkCardReceiveCount(cnd);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(count);
        LOGGER.info("获取工牌待领取数量", JSONUtils.toString(count));
        return bean;
    }

    @PostMapping("/verify")
    @OperLog(operType = OperLogType.OTHER,operDesc = "审核工牌数据")
    public OfficeResopnseBean verifyWorkCard(@RequestBody WorkCardViewVO workCardViewVO){
        workCardManager.verifyWorkCard(workCardViewVO);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody("审核工牌数据成功");
        LOGGER.info("审核工牌数据");
        return bean;
    }

    @GetMapping("/receive")
    @OperLog(operType = OperLogType.OTHER,operDesc = "领取工牌")
    public OfficeResopnseBean receiveWorkCard(String personId){
        workCardManager.receiveWorkCard(personId);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody("领取工牌数据成功");
        LOGGER.info("领取工牌数据");
        return bean;
    }

    /** 上传文件 */
    @PostMapping(value = "/imagerewrite")
    @OperLog(operType = OperLogType.UPLOAD,operDesc = "上传一寸照")
    public OfficeResopnseBean uploadFile(@RequestParam MultipartFile file, @RequestParam Integer fileId) {
        try {
            filePublicManager.rewriteFile(file, fileId);
            OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
            responseBean.setBody("重传成功！");
            return responseBean;
        } catch (IOException e) {
            e.printStackTrace();
            OfficeResopnseBean responseBean = OfficeResopnseBean.newFailBean(500,"重传失败");
            return responseBean;
        }
    }

    @GetMapping(value = "/showimage")
    @OperLog(operType = OperLogType.OTHER,operDesc = "显示一寸照")
    public void showImage(Integer fileId, HttpServletResponse response){
        OutputStream outputStream = null;
        try {
            byte[] data = filePublicManager.showImageByte(fileId);
            outputStream = response.getOutputStream();
            outputStream.write(data);
            outputStream.flush();
        } catch (IOException e) {
            LOGGER.error("请求图片失败！");
            LOGGER.error(e.getMessage());
        }finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                LOGGER.error(e.getMessage());
            }
        }
    }


    /** 上传文件 */
    @PostMapping(value = "/imageupload")
    @OperLog(operType = OperLogType.UPLOAD,operDesc = "上传一寸照")
    public OfficeResopnseBean uploadImage(@RequestParam MultipartFile file, @RequestParam Integer recruitmentId, HttpServletRequest request) {
        Integer menuId = ContextUtils.getMenuId(request);

        try {
            Integer fileId = filePublicManager.uploadFile(file, menuId);
            workCardManager.updateOneInchPhoto(fileId,recruitmentId);
            OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
            responseBean.setBody(fileId);
            return responseBean;
        } catch (IOException e) {
            e.printStackTrace();
            OfficeResopnseBean responseBean = OfficeResopnseBean.newFailBean(500,"上传失败");
            return responseBean;
        }
    }


    @GetMapping("/batchreceive")
    @OperLog(operType = OperLogType.OTHER,operDesc = "批量领取工牌")
    public OfficeResopnseBean batchReceiveWorkCard(@RequestParam(name = "personIds", required = false)List<String> personIds){
        if (personIds == null) {
            personIds = new ArrayList<>();
        }
        workCardManager.batchReceiveWorkCard(personIds);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody("批量领取工牌数据成功");
        LOGGER.info("批量领取工牌数据，工号列表：{}", JSONUtils.toString(personIds));
        return bean;
    }

}
