package com.bsoft.office.hr.controller;

import com.bsoft.common.dto.FileServerDefinitionDTO;
import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.annotation.RequiredExportLog;
import com.bsoft.office.common.condition.ExportLogParams;
import com.bsoft.office.common.exportExcel.ExportExcel;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.manager.FilePublicManager;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.FileUtils;
import com.bsoft.office.hr.condition.WorkCardQueryCnd;
import com.bsoft.office.hr.manager.WorkCardManager;
import com.bsoft.office.hr.vo.WorkCardViewVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/12/16 9:46
 * @Description 工牌核实、领取
 */
@RestController
@RequestMapping("/workcardmake")
public class WorkCardMakeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(WorkCardMakeController.class);

    @Autowired
    private WorkCardManager workCardManager;
    @Autowired
    private FilePublicManager filePublicManager;

    @GetMapping("/personquery")
    @OperLog(operType = OperLogType.QUERY,operDesc = "工牌制作记录")
    public OfficeResopnseBean getWorkCardMakeList(WorkCardQueryCnd cnd){
        if (cnd.getRecharge() == null) {
            cnd.setRecharge(new ArrayList<>());
        }
        Result<WorkCardViewVO> result = workCardManager.getWorkCardMakeList(cnd);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(result);
        LOGGER.info("获取工牌制作数据", JSONUtils.toString(result));
        return bean;
    }

    @PostMapping("/make")
    @OperLog(operType = OperLogType.OTHER,operDesc = "制作工牌")
    public OfficeResopnseBean makeWorkCard(@RequestBody WorkCardViewVO workCardViewVO){
        workCardManager.makeWorkCard(workCardViewVO);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody("制作工牌成功");
        LOGGER.info("制作工牌");
        return bean;
    }

    @GetMapping("/makecount")
    @OperLog(operType = OperLogType.QUERY,operDesc = "工牌待制作数量")
    public OfficeResopnseBean getWorkCardMakeCount(WorkCardQueryCnd cnd){
        if (cnd.getRecharge() == null) {
            cnd.setRecharge(new ArrayList<>());
        }
        Integer count = workCardManager.getWorkCardMakeCount(cnd);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(count);
        LOGGER.info("获取工牌待制作数量", JSONUtils.toString(count));
        return bean;
    }

    @GetMapping(value = "/showimage")
    @OperLog(operType = OperLogType.OTHER,operDesc = "工牌一寸照")
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

    @GetMapping(value = "/imagedownload")
    @OperLog(operType = OperLogType.EXPORT,operDesc = "工牌一寸照下载")
    public void downloadFile(Integer fileId, HttpServletResponse response){
        FileServerDefinitionDTO file = filePublicManager.downloadFile(fileId);
        ServletOutputStream sout = null;
        BufferedOutputStream bos = null;
        try {
            response.setContentLength(file.getData().length);
            response.setContentType("application/octet-stream;charset=utf-8");
            // 下载文件能正常显示中文
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(file.getFileName(), "UTF-8"));
            sout = response.getOutputStream();
            bos = new BufferedOutputStream(sout);
            bos.write(file.getData());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(bos != null){
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @GetMapping(value = "/batchDownload")
    @RequiredExportLog
    @OperLog(operType = OperLogType.EXPORT,operDesc = "人员工牌制作导出信息")
    public void batchDownload(@RequestParam(name="personIds", required = true) List<String> personIds,
                              ExportLogParams params,
                              HttpServletResponse response){
        List<WorkCardViewVO> persons = workCardManager.getWorkCardNeedMakingList(personIds);
        List<FileServerDefinitionDTO> files = workCardManager.getPersonalImageFiles(persons);

        byte[] bytes = ExportExcel.transformListToBytes(persons, WorkCardViewVO.class, "人员信息");
        FileServerDefinitionDTO excel = new FileServerDefinitionDTO();
        excel.setFileName("人员工牌制作导出信息表格.xlsx");
        excel.setData(bytes);
        files.add(excel);

        try {
            response.setContentType("application/zip");
            response.setHeader("Content-Disposition", "attachment; filename="+URLEncoder.encode("人员信息及一寸照.zip","UTF-8"));
            FileUtils.toZipWithMultiFiles(files, response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
