package com.bsoft.office.hr.controller;

import com.bsoft.common.dto.FileServerDefinitionDTO;
import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.hr.manager.RankManager;
import com.bsoft.office.hr.vo.RankViewVO;
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
 * @Date 2020/8/3 13:11
 * @Description
 */
@RestController
@RequestMapping("/rank")
public class RankController {
    private final static Logger LOGGER = LoggerFactory.getLogger(RankController.class);

    @Autowired
    private RankManager rankManager;

    @GetMapping("/query")
    @OperLog(operType = OperLogType.QUERY,operDesc = "职级查询")
    public OfficeResopnseBean getRankList(@RequestParam Integer year,
                                                 @RequestParam(name = "deptId", required = false) String deptId,
                                                 @RequestParam(name = "inputContent", required = false) String inputContent,
                                                 @RequestParam Integer pageNo,
                                                 @RequestParam Integer pageSize ){
        Result<RankViewVO> result = rankManager.getRankList(year, deptId, inputContent, pageNo, pageSize);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        LOGGER.info("获取职级查询列表！[{}]", JSONUtils.toString(result));
        return responseBean;
    }

    @GetMapping(value = "/pptdownload")
    @OperLog(operType = OperLogType.EXPORT,operDesc = "职级-ppt下载")
    public void downloadFile(Integer pptId, HttpServletResponse response){
        FileServerDefinitionDTO file = rankManager.downloadFile(pptId);
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
            LOGGER.info("下载文件成功！文件服务器文件id:{}, 资料id: {}", pptId);
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
