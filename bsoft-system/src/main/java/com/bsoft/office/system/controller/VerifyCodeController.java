package com.bsoft.office.system.controller;

import com.bsoft.exception.ServiceException;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.verifyCode.VerifyCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

/**
 * 验证码功能
 */

@RestController
@RequestMapping(value = "/code")
public class VerifyCodeController {
    private static final Logger logger = LoggerFactory.getLogger(VerifyCodeController.class);
    /**
     * 刷新验证码
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/refresh",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "用户刷新图片验证码")
    public void checkEnable(HttpServletRequest request,
                                          HttpServletResponse response){
        response.setContentType("image/jpeg");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        try {
            BufferedImage image = VerifyCode.createImage();
            String code = VerifyCode.getText();
            request.getSession().setAttribute("sCode",code);
            logger.info("获取验证码[{}]成功！",code);
            VerifyCode.output(image, response.getOutputStream());
        } catch (Exception e){
            logger.error("获取验证码失败！");
            throw new ServiceException("获取验证码失败！");
        }
    }
}
