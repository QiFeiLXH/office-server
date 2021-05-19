package com.bsoft.office.common.controller;

import com.bsoft.common.dto.FileServerDefinitionDTO;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.manager.HelpWordManager;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.utils.ContextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * @Author: xucl
 * @DateTime: 2020/12/7 15:01
 * @Description:
 */
@RestController
@RequestMapping("/help")
public class HelpWordController {

    @Autowired
    private HelpWordManager helpWordManager;

    @RequestMapping(value = "/showhelp",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.DOWNLOAD,operDesc = "查看帮助文档")
    public void showHelpWord(Integer menuId, HttpServletRequest request, HttpServletResponse response){
        String personId = ContextUtils.getUserId(request);
        FileServerDefinitionDTO fileServerDefinitionDTO = helpWordManager.getHelpWord(menuId, personId);
        if (fileServerDefinitionDTO != null) {
            OutputStream outputStream = null;
            try {
                String fileType = fileServerDefinitionDTO.getFileName().substring(fileServerDefinitionDTO.getFileName().lastIndexOf(".") + 1);
                response.setCharacterEncoding("UTF-8");
                if (fileType.equalsIgnoreCase("pdf")){
                    response.setContentType("application/pdf");
                }else{
                    response.setContentType("application/msword");
                }
                response.setHeader("Content-Disposition", "inline;fileName="+ URLEncoder.encode(fileServerDefinitionDTO.getFileName(), "utf-8"));
                outputStream = response.getOutputStream();
                outputStream.write(fileServerDefinitionDTO.getData());
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
