package com.bsoft.office.system.controller;

import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.jsonutil.GsonUtils;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.response.OfficeResponseCode;
import com.bsoft.office.common.utils.IpUtils;
import com.bsoft.office.system.manager.UsageLogManager;
import com.bsoft.office.system.vo.LoginLogVO;
import com.bsoft.office.system.vo.LoginParamsVO;
import com.bsoft.user.service.OfficeVeriService;
import com.bsoft.user.service.UserService;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import eu.bitwalker.useragentutils.Version;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


/**
 * 登录功能
 */

@RestController
@RequestMapping(value = "/auth")
public class LogonController {

    private static final Logger logger    = LoggerFactory.getLogger(LogonController.class);

    @Reference
    private UserService userService;

    @Reference
    private OfficeVeriService officeVeriService;

    @Autowired
    UsageLogManager usageLogManager;
    /**
     * 获取用户名密码验证错误次数,是否可登录
     * @param request
     * @return
     */
    @RequestMapping(value = "/checkEnable",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取用户名密码验证错误次数，验证能否登陆")
    public OfficeResopnseBean checkEnable(HttpServletRequest request) {
        String ip = IpUtils.getIpAdrress(request);
        if (officeVeriService.hasVeriInfo(ip)){
            Map<String,Object> returnMap = new HashMap<>();
            Map<String,Object> map = GsonUtils.gsonToMaps(officeVeriService.getVeriInfo(ip));
            Double t = (Double) map.get("times");
            Integer times = Integer.valueOf(t.intValue());
            long needTimes = 0L;
            if (times >= 10) {
                long startTime = 0L;
                long newTime = 0L;
                Double l = (Double) map.get("create");
                startTime = l.longValue();
                newTime = System.currentTimeMillis();
                needTimes = 5*60*1000 - (newTime - startTime);
            }
            returnMap.put("times",times);
            returnMap.put("count",needTimes);
            OfficeResopnseBean bean = OfficeResopnseBean.newFailBean(OfficeResponseCode.VALIDATION_ERROR,"用户名密码验证错误！");
            bean.setProperties(returnMap);
            return bean;
        } else {
            return OfficeResopnseBean.newSuccessBean();
        }
    }

    /**
     * 登录
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.LOGIN,operDesc = "登录系统")
    public OfficeResopnseBean login(HttpServletRequest request, @RequestBody LoginParamsVO loginParamsVO) throws IOException {
            String userId   = loginParamsVO.getUsername();
            String password = loginParamsVO.getPassword();
            HttpSession httpSession = request.getSession(false);
            if (httpSession == null || !userId.equals(httpSession.getAttribute("userId"))){
                httpSession = request.getSession();
            }
            if (loginParamsVO.getInputCode() != null && loginParamsVO.getInputCode() != ""){
                String inputCode = loginParamsVO.getInputCode();
                String text = (String) httpSession.getAttribute("sCode");
                if (!inputCode.equalsIgnoreCase(text)){
                    OfficeResopnseBean bean = OfficeResopnseBean.newFailBean(OfficeResponseCode.VERIFY_CODE_ERROR,"请输入正确的验证码！");
                    return bean;
                }
            }
            Map<String,Object> returnMap = new HashMap<>();
            String ip = IpUtils.getIpAdrress(request);
            logger.info("用户[{}] 申请登录！" ,userId);
            Boolean flag = userService.validatePassword(userId,password);
            if(flag){
                httpSession.setAttribute("userId",userId);
                if (officeVeriService.hasVeriInfo(ip)){
                    officeVeriService.removeVeriInfo(ip);
                }
                httpSession.setMaxInactiveInterval(3600);//会话有效时间1小时
                String sessionId = httpSession.getId();
                logger.info("用户[{}] 用户名密码验证成功！",userId);
                OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
                bean.setProperty("sessionid",sessionId);
                this.afterLogin(request,1,userId,password);
                return bean;
            }else{
                Integer times = 0;
                long startTime = 0L;
                long newTime = 0L;
                long needTimes = 0L;
                if (officeVeriService.hasVeriInfo(ip)){
                    String mapString = officeVeriService.getVeriInfo(ip);
                    Map<String,Object> map = GsonUtils.gsonToMaps(mapString);
                    Double t = (Double) map.get("times");
                    times = Integer.valueOf(t.intValue());
                    times++;
                    map.put("times",times);
                    startTime = System.currentTimeMillis();
                    map.put("create",startTime);
                    officeVeriService.setVeriInfo(ip,map.toString(),5L, TimeUnit.MINUTES);
                } else {
                    HashMap<String,Object> map = new HashMap<>();
                    times++;
                    map.put("times",times);
                    startTime = System.currentTimeMillis();
                    map.put("create",startTime);
                    String mapString = map.toString();
                    officeVeriService.setVeriInfo(ip,mapString,5L, TimeUnit.MINUTES);
                }
                if (times >= 10){
                    newTime = System.currentTimeMillis();
                    needTimes = 5*60*1000 - (newTime - startTime);
                }
                logger.info("用户[{}] 用户名密码验证失败！第[{}]次",userId,times);
                OfficeResopnseBean bean = OfficeResopnseBean.newFailBean(OfficeResponseCode.VALIDATION_ERROR,"用户名或密码错误！");
                returnMap.put("times",times);
                returnMap.put("count",needTimes);
                bean.setProperties(returnMap);
                this.afterLogin(request,0,userId,password);
                return bean;
            }
    }

    /**
     * 验证单点登录是否正常登录
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/checkLogon",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.LOGIN,operDesc = "验证单点登录")
    public OfficeResopnseBean checkLogin(HttpServletRequest request) {
        HttpSession httpSession = request.getSession(false);
        if (httpSession == null){
            logger.error("单点登录失败，无session！");
            return OfficeResopnseBean.newFailBean(OfficeResponseCode.OAUTH_LOGIN_ERROR,"单点登录失败，无session！");
        }
        logger.info("checkLogin sessionId = [{}]！",httpSession.getId());
        String userId = (String) httpSession.getAttribute("userId");
        String toPath = (String) httpSession.getAttribute("toPath");
        if (userId == null || userId == ""){
            logger.error("单点登录失败，无用户信息！");
            return OfficeResopnseBean.newFailBean(OfficeResponseCode.OAUTH_LOGIN_ERROR,"单点登录失败，无用户信息！");
        } else {
            String sessionId = httpSession.getId();
            OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
            bean.setProperty("sessionid",sessionId);
            bean.setProperty("toPath",toPath);
            logger.info("单点登录成功！");
            this.afterLogin(request,1,userId,"");
            return bean;
        }
    }

    /**
     * 退出登录
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.LOGOUT,operDesc = "退出登录")
    public OfficeResopnseBean logout(HttpServletRequest request,HttpServletResponse response){
        HttpSession httpSession = request.getSession(false);
        OfficeResopnseBean bean = null;
        if (httpSession == null){
            bean = OfficeResopnseBean.newSuccessBean();
            bean.setMsg("成功登出！");
        }else{
            httpSession.setAttribute("userId",null);
            httpSession.setAttribute("toPath","");
            httpSession.invalidate();
            bean = OfficeResopnseBean.newSuccessBean();
            bean.setMsg("成功登出！");
        }
        return bean;
    }

    private String getHttpInfo(HttpServletRequest request){
        StringBuffer stringBuffer = new StringBuffer();
        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
        Browser browser = userAgent.getBrowser();//浏览器名称
        OperatingSystem operatingSystem = userAgent.getOperatingSystem();//操作系统名称
        Version browserVersion = userAgent.getBrowserVersion();//浏览器版本
        stringBuffer.append(browser.getName()).append("/").append(browserVersion.getVersion()).append("/").append(operatingSystem.getName());
        return stringBuffer.toString();
    }

    /**
     * 保存登录日志信息
     * @param request
     * @param status 1登录成功，0登录失败
     * @param userId 用户工号
     * @param passWord 密码
     */
    private void afterLogin(HttpServletRequest request,Integer status,String userId,String passWord){
        String ip = IpUtils.getIpAdrress(request);
        String bz = this.getHttpInfo(request);
        LoginLogVO loginLogVO = new LoginLogVO();
        loginLogVO.setIp(ip);
        loginLogVO.setPersonId(userId);
        loginLogVO.setPassWord(passWord);
        loginLogVO.setUseDate(new Date());
        loginLogVO.setBz(bz);
        loginLogVO.setStatus(status);
        usageLogManager.CountLoginLog(loginLogVO);
        logger.info("登录日志信息[{}]，发送消息队列，success!",JSONUtils.toString(loginLogVO));
    }
}
