package com.bsoft.office.sysconfig.filter;

import ctd.oauth.CookieConsumer;
import ctd.oauth.SampleOAuthConsumer;
import net.oauth.OAuth;
import net.oauth.OAuthAccessor;
import net.oauth.OAuthConsumer;
import net.util.CookieUtils;
import net.util.OAuthJSONUtils;
import net.util.SessionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

@RestController
@RequestMapping(value = "/oauth")
public class OfficeFilterController {
    private static final Logger logger    = LoggerFactory.getLogger(OfficeFilterController.class);

    private static String NAME = "office";
    private static final String resourceName = "consumer.properties";
    private boolean mode = true;
    private String reqURL = "oauth/user";
    private static OAuthConsumer consumer = null;

    static {
        try {
            consumer = CookieConsumer.getConsumer(NAME, resourceName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/autoLogin")
    public void autoLogon(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        logger.info("start filter  Servlert..............");
        String uri = request.getRequestURI();
        int endIndex = request.getRequestURL().length() - request.getRequestURI().length() + 1;
        String url = request.getRequestURL().substring(0, endIndex);
        try {
            if ((this.mode) || (!SessionUtils.isLogin(request))){
                String param = request.getParameter("param");
                String toPath = "";
                if (param != "" && param != null){
                    toPath = param;
                }
                if (consumer == null){
                    consumer = CookieConsumer.getConsumer(NAME, resourceName);
                }
                OAuthAccessor accessor = CookieConsumer.getAccessor(request, response, consumer);
                Collection<OAuth.Parameter> parameters = new ArrayList();
                String consumerKey = accessor.consumer.consumerKey;
                if (!OAuth.newMap(parameters).containsKey(consumerKey)) {
                    parameters.add(new OAuth.Parameter("consumerKey", consumerKey));
                }
                String res = SampleOAuthConsumer.invoke(accessor, parameters, this.reqURL);
                HashMap<String, Object> user = (HashMap) OAuthJSONUtils.parse(res, HashMap.class);
                HttpSession session = request.getSession(false);
                if (session == null) {
                    session = request.getSession();
                }
                session.setAttribute("userId", user.get("userId"));
                session.setAttribute("toPath", toPath);
                logger.info("用户[{}],单点登录成功,sessionId = [{}]！",user.get("userId"),session.getId());
                CookieUtils.addCookie("SSO", "true", request, response);
            }
            if ((uri.endsWith(".html")) || (uri.endsWith("/"))) {
                response.setHeader("Cache-Control", "no-store");
                response.setHeader("Pragrma", "no-cache");
                response.setDateHeader("Expires", 0L);
            }
            String redirectUrl = url + "#/user/autoLogin";
            response.sendRedirect(redirectUrl);
            logger.info("end filter  Servlert..............");
        }catch (Exception e){
            CookieConsumer.handleException(e, request, response, consumer);
        }
    }
}
