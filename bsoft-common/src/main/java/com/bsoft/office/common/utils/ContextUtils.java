package com.bsoft.office.common.utils;

import com.bsoft.office.common.exception.NoLogonException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class ContextUtils {
    private static ThreadLocal<Map<String,Object>> threadContext = new ThreadLocal();
    public static String getUserId(HttpServletRequest request){
        HttpSession httpSession = request.getSession(false);
        if(httpSession == null){
            return null;
        }
        String userId = (String) httpSession.getAttribute("userId");
        return userId;
    }

    public static void setAttribute(HttpServletRequest request,String key,String value){
        HttpSession httpSession = request.getSession(false);
        if (httpSession == null){
            httpSession = request.getSession();
        }
        httpSession.setAttribute(key,value);
    }

    public static String getAttribute(HttpServletRequest request,String key){
        HttpSession httpSession = request.getSession(false);
        String value = (String) httpSession.getAttribute(key);
        return value;
    }

    public static Integer getMenuId(HttpServletRequest request) {
        Integer menuId = Integer.valueOf(request.getHeader("menuId"));
        return menuId;
    }


    public static void setContext(Map<String,Object> ctx) {
        threadContext.set(ctx);
    }

    public static boolean hasKey(String key) {
        Map<String,Object> ctx = threadContext.get();
        return ctx == null ? false : ctx.containsKey(key);
    }

    public static Object get(String key) {
        Map<String,Object> ctx = threadContext.get();
        if (ctx == null) {
            ctx = new HashMap<>();
            setContext(ctx);
        }

        return ctx.get(key);
    }

    public static void remove(String key) {
        Map<String,Object> ctx = threadContext.get();
        if (ctx != null) {
            ctx.remove(key);
        }

    }

    public static void put(String key, Object v) {
        Map<String,Object> ctx = threadContext.get();
        if (ctx == null) {
            ctx = new HashMap<>();
            setContext(ctx);
        }
        ctx.put(key, v);
    }

    public static void clear() {
        threadContext.remove();
    }
}
