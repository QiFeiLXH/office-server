package com.bsoft.office.work.controller;

import com.bsoft.common.dto.FileServerDefinitionDTO;
import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.annotation.RequiredExportLog;
import com.bsoft.office.common.condition.ExportLogParams;
import com.bsoft.office.common.exportExcel.ExportExcel;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.work.condition.BusinessCardQueryCnd;
import com.bsoft.office.work.manager.BusinessCardManager;
import com.bsoft.office.work.vo.BusinessCardViewVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2021/2/3 16:23
 * @Description
 */
@RestController
@RequestMapping("/businesscard")
public class BusinessCardController {
    private final static Logger LOGGER = LoggerFactory.getLogger(BusinessCardController.class);
    @Autowired
    private BusinessCardManager businessCardManager;

    @GetMapping("/list")
    @OperLog(operType = OperLogType.QUERY,operDesc = "名片列表")
    public OfficeResopnseBean getBusinessCardList(BusinessCardQueryCnd queryCnd) {
        Result<BusinessCardViewVO> result = businessCardManager.getBusinessCardList(queryCnd);
        return OfficeResopnseBean.newSuccessBean(result);
    }

    @GetMapping("/unpaidcount")
    @OperLog(operType = OperLogType.QUERY,operDesc = "未支付数量")
    public OfficeResopnseBean getBusinessCardUnpaidCount(BusinessCardQueryCnd queryCnd) {
        Integer count = businessCardManager.getBusinessCardUnpaidCount(queryCnd);
        return OfficeResopnseBean.newSuccessBean(count);
    }

    @GetMapping("/unpaidamount")
    @OperLog(operType = OperLogType.QUERY,operDesc = "未支付金额")
    public OfficeResopnseBean getBusinessCardUnpaidAmount() {
        Double amount = businessCardManager.getBusinessCardUnpaidAmount();
        return OfficeResopnseBean.newSuccessBean(amount);
    }

    @GetMapping("/totalamount")
    @OperLog(operType = OperLogType.QUERY,operDesc = "名片总金额")
    public OfficeResopnseBean getBusinessCardTotalAmount(@RequestParam(value = "businessCardIds", required = false) List<Integer> businessCardIds) {
        if (businessCardIds == null) {
            businessCardIds = new ArrayList<>();
        }
        Double amount = businessCardManager.getBusinessCardTotalAmount(businessCardIds);
        return OfficeResopnseBean.newSuccessBean(amount);
    }

    @GetMapping("/businesscardids")
    @OperLog(operType = OperLogType.QUERY,operDesc = "名片ids")
    public OfficeResopnseBean getBusinessCardIdList(BusinessCardQueryCnd queryCnd) {
        List<Integer> businessCardIds = businessCardManager.getBusinessCardIdList(queryCnd);
        return OfficeResopnseBean.newSuccessBean(businessCardIds);
    }

    @GetMapping("/applypaydownload")
    @RequiredExportLog
    @OperLog(operType = OperLogType.OTHER,operDesc = "名片支付申请")
    public void applyPayBusinessCard(@RequestParam(name="businessCardIds", required = false) List<Integer> businessCardIds,
                                 ExportLogParams params,
                                 HttpServletResponse response) {
        List<BusinessCardViewVO> list = new ArrayList<>();
        if (businessCardIds != null) {
            list = businessCardManager.applyPayBusinessCard(businessCardIds);
        }
        ExportExcel.doExport(list,BusinessCardViewVO.class,"名片支付申请数据",response);
    }

    @GetMapping("/pay")
    @OperLog(operType = OperLogType.MODIFY,operDesc = "批量支付")
    public OfficeResopnseBean payBusinessCard(@RequestParam(name="businessCardIds", required = false) List<Integer> businessCardIds) {
        if (businessCardIds == null) {
            businessCardIds = new ArrayList<>();
        }
        businessCardManager.payBusinessCard(businessCardIds);
        return OfficeResopnseBean.newSuccessBean("批量支付成功");
    }

    @GetMapping(value = "/showimage")
    @OperLog(operType = OperLogType.OTHER,operDesc = "显示二维码")
    public void showImage(Integer id, HttpServletResponse response){
        OutputStream outputStream = null;
        try {
            FileServerDefinitionDTO file = businessCardManager.showImageByte(id);
            outputStream = response.getOutputStream();
            outputStream.write(file.getData());
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

    @GetMapping(value = "/imagedownload")
    @OperLog(operType = OperLogType.DOWNLOAD,operDesc = "二维码下载")
    public void downloadsaveBusinessCardImage(Integer id,HttpServletResponse response) {
        FileServerDefinitionDTO file = businessCardManager.showImageByte(id);
        ServletOutputStream sout = null;
        BufferedOutputStream bos = null;
        try {
            response.setContentLength(file.getData().length);
            response.setContentType("application/octet-stream;charset=utf-8");
            // 下载文件能正常显示中文
            response.setHeader("Content-Disposition", "attachment;");
            sout = response.getOutputStream();
            bos = new BufferedOutputStream(sout);
            bos.write(file.getData());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
