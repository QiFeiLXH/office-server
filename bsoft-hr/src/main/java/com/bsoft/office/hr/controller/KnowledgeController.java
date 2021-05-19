package com.bsoft.office.hr.controller;

import com.bsoft.common.dto.FileServerDefinitionDTO;
import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.hr.manager.KnowledgeManager;
import com.bsoft.office.hr.vo.KnowledgeNumViewVO;
import com.bsoft.office.hr.vo.KnowledgeVO;
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
import java.net.URLEncoder;

/**
 * @Author Xuhui Lin
 * @Date 2020/8/6 12:52
 * @Description
 */
@RestController
@RequestMapping("/knowledge")
public class KnowledgeController {
    private final static Logger LOGGER = LoggerFactory.getLogger(KnowledgeController.class);
    @Autowired
    private KnowledgeManager knowledgeManager;

    @GetMapping("/numberquery")
    @OperLog(operType = OperLogType.QUERY,operDesc = "知识贡献")
    public OfficeResopnseBean getKnowledgeNumList(@RequestParam(name = "deptId", required = false) String deptId,
                                                    @RequestParam(name = "inputContent", required = false) String inputContent,
                                                    @RequestParam Integer pageNo,
                                                    @RequestParam Integer pageSize ){
        Result<KnowledgeNumViewVO> result = knowledgeManager.getKnowledgeNumList(deptId, inputContent, pageNo, pageSize);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        LOGGER.info("获取知识贡献查询列表！[{}]", JSONUtils.toString(result));
        return responseBean;
    }

    @GetMapping("/query")
    @OperLog(operType = OperLogType.QUERY,operDesc = "个人知识贡献")
    public OfficeResopnseBean getPersonalKnowledgeList(@RequestParam(name = "personId", required = false) String personId,
                                                         @RequestParam Integer pageNo,
                                                         @RequestParam Integer pageSize ){
        Result<KnowledgeVO> result = knowledgeManager.getPersonalKnowledgeList(personId, pageNo, pageSize);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        LOGGER.info("获取个人知识贡献查询列表！[{}]", JSONUtils.toString(result));
        return responseBean;
    }

    @GetMapping(value = "/knowledgedownload")
    @OperLog(operType = OperLogType.OTHER,operDesc = "知识贡献文件下载")
    public void downloadFile(Integer fileId, HttpServletResponse response){
        FileServerDefinitionDTO file = knowledgeManager.downloadFile(fileId);
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
            LOGGER.info("下载文件成功！文件服务器文件id:{}, 资料id: {}", fileId);
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
}
